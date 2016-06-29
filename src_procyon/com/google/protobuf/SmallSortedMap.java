package com.google.protobuf;

import java.util.*;

class SmallSortedMap extends AbstractMap
{
    private final int maxArraySize;
    private List entryList;
    private Map overflowEntries;
    private boolean isImmutable;
    private volatile SmallSortedMap$EntrySet lazyEntrySet;
    
    static SmallSortedMap newFieldMap(final int n) {
        return new SmallSortedMap$1(n);
    }
    
    static SmallSortedMap newInstanceForTest(final int n) {
        return new SmallSortedMap(n);
    }
    
    private SmallSortedMap(final int maxArraySize) {
        this.maxArraySize = maxArraySize;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
    }
    
    public void makeImmutable() {
        if (!this.isImmutable) {
            this.overflowEntries = (this.overflowEntries.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap((Map<?, ?>)this.overflowEntries));
            this.isImmutable = true;
        }
    }
    
    public boolean isImmutable() {
        return this.isImmutable;
    }
    
    public int getNumArrayEntries() {
        return this.entryList.size();
    }
    
    public Entry getArrayEntryAt(final int n) {
        return (Entry)this.entryList.get(n);
    }
    
    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }
    
    public Iterable getOverflowEntries() {
        return this.overflowEntries.isEmpty() ? SmallSortedMap$EmptySet.iterable() : this.overflowEntries.entrySet();
    }
    
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }
    
    public boolean containsKey(final Object o) {
        final Comparable comparable = (Comparable)o;
        return this.binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable);
    }
    
    public Object get(final Object o) {
        final Comparable comparable = (Comparable)o;
        final int binarySearchInArray = this.binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return ((SmallSortedMap$Entry)this.entryList.get(binarySearchInArray)).getValue();
        }
        return this.overflowEntries.get(comparable);
    }
    
    public Object put(final Comparable comparable, final Object value) {
        this.checkMutable();
        final int binarySearchInArray = this.binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return ((SmallSortedMap$Entry)this.entryList.get(binarySearchInArray)).setValue(value);
        }
        this.ensureEntryArrayMutable();
        final int n = -(binarySearchInArray + 1);
        if (n >= this.maxArraySize) {
            return this.getOverflowEntriesMutable().put(comparable, value);
        }
        if (this.entryList.size() == this.maxArraySize) {
            final SmallSortedMap$Entry smallSortedMap$Entry = this.entryList.remove(this.maxArraySize - 1);
            this.getOverflowEntriesMutable().put(smallSortedMap$Entry.getKey(), smallSortedMap$Entry.getValue());
        }
        this.entryList.add(n, new SmallSortedMap$Entry(this, comparable, value));
        return null;
    }
    
    public void clear() {
        this.checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (!this.overflowEntries.isEmpty()) {
            this.overflowEntries.clear();
        }
    }
    
    public Object remove(final Object o) {
        this.checkMutable();
        final Comparable comparable = (Comparable)o;
        final int binarySearchInArray = this.binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return this.removeArrayEntryAt(binarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }
    
    private Object removeArrayEntryAt(final int n) {
        this.checkMutable();
        final Object value = this.entryList.remove(n).getValue();
        if (!this.overflowEntries.isEmpty()) {
            final Iterator iterator = this.getOverflowEntriesMutable().entrySet().iterator();
            this.entryList.add(new SmallSortedMap$Entry(this, (Entry)iterator.next()));
            iterator.remove();
        }
        return value;
    }
    
    private int binarySearchInArray(final Comparable comparable) {
        int i = 0;
        int n = this.entryList.size() - 1;
        if (n >= 0) {
            final int compareTo = comparable.compareTo(this.entryList.get(n).getKey());
            if (compareTo > 0) {
                return -(n + 2);
            }
            if (compareTo == 0) {
                return n;
            }
        }
        while (i <= n) {
            final int n2 = (i + n) / 2;
            final int compareTo2 = comparable.compareTo(this.entryList.get(n2).getKey());
            if (compareTo2 < 0) {
                n = n2 - 1;
            }
            else {
                if (compareTo2 <= 0) {
                    return n2;
                }
                i = n2 + 1;
            }
        }
        return -(i + 1);
    }
    
    public Set entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new SmallSortedMap$EntrySet(this, null);
        }
        return this.lazyEntrySet;
    }
    
    private void checkMutable() {
        if (this.isImmutable) {
            throw new UnsupportedOperationException();
        }
    }
    
    private SortedMap getOverflowEntriesMutable() {
        this.checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
            this.overflowEntries = new TreeMap();
        }
        return (SortedMap)this.overflowEntries;
    }
    
    private void ensureEntryArrayMutable() {
        this.checkMutable();
        if (this.entryList.isEmpty() && !(this.entryList instanceof ArrayList)) {
            this.entryList = new ArrayList(this.maxArraySize);
        }
    }
}
