/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap$1;
import com.google.protobuf.SmallSortedMap$EmptySet;
import com.google.protobuf.SmallSortedMap$Entry;
import com.google.protobuf.SmallSortedMap$EntrySet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class SmallSortedMap
extends AbstractMap {
    private final int maxArraySize;
    private List entryList;
    private Map overflowEntries;
    private boolean isImmutable;
    private volatile SmallSortedMap$EntrySet lazyEntrySet;

    static SmallSortedMap newFieldMap(int n2) {
        return new SmallSortedMap$1(n2);
    }

    static SmallSortedMap newInstanceForTest(int n2) {
        return new SmallSortedMap(n2);
    }

    private SmallSortedMap(int n2) {
        this.maxArraySize = n2;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
    }

    public void makeImmutable() {
        if (this.isImmutable) return;
        this.overflowEntries = this.overflowEntries.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.overflowEntries);
        this.isImmutable = true;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public Map.Entry getArrayEntryAt(int n2) {
        return (Map.Entry)this.entryList.get(n2);
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable getOverflowEntries() {
        Set set;
        if (this.overflowEntries.isEmpty()) {
            set = SmallSortedMap$EmptySet.iterable();
            return set;
        }
        set = this.overflowEntries.entrySet();
        return set;
    }

    @Override
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    @Override
    public boolean containsKey(Object object) {
        Comparable comparable = (Comparable)object;
        if (this.binarySearchInArray(comparable) >= 0) return true;
        if (this.overflowEntries.containsKey(comparable)) return true;
        return false;
    }

    @Override
    public Object get(Object object) {
        Comparable comparable = (Comparable)object;
        int n2 = this.binarySearchInArray(comparable);
        if (n2 < 0) return this.overflowEntries.get(comparable);
        return ((SmallSortedMap$Entry)this.entryList.get(n2)).getValue();
    }

    @Override
    public Object put(Comparable comparable, Object object) {
        this.checkMutable();
        int n2 = this.binarySearchInArray(comparable);
        if (n2 >= 0) {
            return ((SmallSortedMap$Entry)this.entryList.get(n2)).setValue(object);
        }
        this.ensureEntryArrayMutable();
        int n3 = - n2 + 1;
        if (n3 >= this.maxArraySize) {
            return this.getOverflowEntriesMutable().put(comparable, object);
        }
        if (this.entryList.size() == this.maxArraySize) {
            SmallSortedMap$Entry smallSortedMap$Entry = (SmallSortedMap$Entry)this.entryList.remove(this.maxArraySize - 1);
            this.getOverflowEntriesMutable().put(smallSortedMap$Entry.getKey(), smallSortedMap$Entry.getValue());
        }
        this.entryList.add(n3, new SmallSortedMap$Entry(this, comparable, object));
        return null;
    }

    @Override
    public void clear() {
        this.checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (this.overflowEntries.isEmpty()) return;
        this.overflowEntries.clear();
    }

    @Override
    public Object remove(Object object) {
        this.checkMutable();
        Comparable comparable = (Comparable)object;
        int n2 = this.binarySearchInArray(comparable);
        if (n2 >= 0) {
            return this.removeArrayEntryAt(n2);
        }
        if (!this.overflowEntries.isEmpty()) return this.overflowEntries.remove(comparable);
        return null;
    }

    private Object removeArrayEntryAt(int n2) {
        this.checkMutable();
        Object object = ((SmallSortedMap$Entry)this.entryList.remove(n2)).getValue();
        if (this.overflowEntries.isEmpty()) return object;
        Iterator iterator = this.getOverflowEntriesMutable().entrySet().iterator();
        this.entryList.add(new SmallSortedMap$Entry(this, iterator.next()));
        iterator.remove();
        return object;
    }

    private int binarySearchInArray(Comparable comparable) {
        int n2;
        int n3 = 0;
        int n4 = this.entryList.size() - 1;
        if (n4 >= 0) {
            n2 = comparable.compareTo(((SmallSortedMap$Entry)this.entryList.get(n4)).getKey());
            if (n2 > 0) {
                return - n4 + 2;
            }
            if (n2 == 0) {
                return n4;
            }
        }
        while (n3 <= n4) {
            n2 = (n3 + n4) / 2;
            int n5 = comparable.compareTo(((SmallSortedMap$Entry)this.entryList.get(n2)).getKey());
            if (n5 < 0) {
                n4 = n2 - 1;
                continue;
            }
            if (n5 <= 0) return n2;
            n3 = n2 + 1;
        }
        return - n3 + 1;
    }

    @Override
    public Set entrySet() {
        if (this.lazyEntrySet != null) return this.lazyEntrySet;
        this.lazyEntrySet = new SmallSortedMap$EntrySet(this, null);
        return this.lazyEntrySet;
    }

    private void checkMutable() {
        if (!this.isImmutable) return;
        throw new UnsupportedOperationException();
    }

    private SortedMap getOverflowEntriesMutable() {
        this.checkMutable();
        if (!this.overflowEntries.isEmpty()) return (SortedMap)this.overflowEntries;
        if (this.overflowEntries instanceof TreeMap) return (SortedMap)this.overflowEntries;
        this.overflowEntries = new TreeMap();
        return (SortedMap)this.overflowEntries;
    }

    private void ensureEntryArrayMutable() {
        this.checkMutable();
        if (!this.entryList.isEmpty()) return;
        if (this.entryList instanceof ArrayList) return;
        this.entryList = new ArrayList(this.maxArraySize);
    }

    /* synthetic */ SmallSortedMap(int n2, SmallSortedMap$1 smallSortedMap$1) {
        this(n2);
    }

    static /* synthetic */ void access$200(SmallSortedMap smallSortedMap) {
        smallSortedMap.checkMutable();
    }

    static /* synthetic */ List access$400(SmallSortedMap smallSortedMap) {
        return smallSortedMap.entryList;
    }

    static /* synthetic */ Object access$500(SmallSortedMap smallSortedMap, int n2) {
        return smallSortedMap.removeArrayEntryAt(n2);
    }

    static /* synthetic */ Map access$600(SmallSortedMap smallSortedMap) {
        return smallSortedMap.overflowEntries;
    }
}

