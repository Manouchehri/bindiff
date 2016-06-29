package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GoogleInternal
@GwtIncompatible("not worth using in GWT for now")
public class CompactLinkedHashSet extends CompactHashSet
{
    private static final int ENDPOINT = -2;
    private transient int[] predecessor;
    private transient int[] successor;
    private transient int firstEntry;
    private transient int lastEntry;
    
    public static CompactLinkedHashSet create() {
        return new CompactLinkedHashSet();
    }
    
    public static CompactLinkedHashSet create(final Collection collection) {
        final CompactLinkedHashSet withExpectedSize = createWithExpectedSize(collection.size());
        withExpectedSize.addAll(collection);
        return withExpectedSize;
    }
    
    public static CompactLinkedHashSet create(final Object... array) {
        final CompactLinkedHashSet withExpectedSize = createWithExpectedSize(array.length);
        Collections.addAll(withExpectedSize, array);
        return withExpectedSize;
    }
    
    public static CompactLinkedHashSet createWithExpectedSize(final int n) {
        return new CompactLinkedHashSet(n);
    }
    
    CompactLinkedHashSet() {
    }
    
    CompactLinkedHashSet(final int n) {
        super(n);
    }
    
    @Override
    void init(final int n, final float n2) {
        super.init(n, n2);
        this.predecessor = new int[n];
        this.successor = new int[n];
        Arrays.fill(this.predecessor, -1);
        Arrays.fill(this.successor, -1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }
    
    private void succeeds(final int lastEntry, final int firstEntry) {
        if (lastEntry == -2) {
            this.firstEntry = firstEntry;
        }
        else {
            this.successor[lastEntry] = firstEntry;
        }
        if (firstEntry == -2) {
            this.lastEntry = lastEntry;
        }
        else {
            this.predecessor[firstEntry] = lastEntry;
        }
    }
    
    @Override
    void insertEntry(final int n, final Object o, final int n2) {
        super.insertEntry(n, o, n2);
        this.succeeds(this.lastEntry, n);
        this.succeeds(n, -2);
    }
    
    @Override
    void moveEntry(final int n) {
        final int n2 = this.size() - 1;
        super.moveEntry(n);
        this.succeeds(this.predecessor[n], this.successor[n]);
        if (n2 != n) {
            this.succeeds(this.predecessor[n2], n);
            this.succeeds(n, this.successor[n2]);
        }
        this.predecessor[n2] = -1;
        this.successor[n2] = -1;
    }
    
    @Override
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.predecessor, -1);
        Arrays.fill(this.successor, -1);
    }
    
    @Override
    void resizeEntries(final int n) {
        super.resizeEntries(n);
        final int length = this.predecessor.length;
        this.predecessor = Arrays.copyOf(this.predecessor, n);
        this.successor = Arrays.copyOf(this.successor, n);
        if (length < n) {
            Arrays.fill(this.predecessor, length, n, -1);
            Arrays.fill(this.successor, length, n, -1);
        }
    }
    
    @Override
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return ObjectArrays.toArrayImpl(this, array);
    }
    
    @Override
    public Iterator iterator() {
        return new CompactLinkedHashSet$1(this);
    }
}
