package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GoogleInternal
@GwtIncompatible("not worth using in GWT for now")
public class CompactLinkedHashMap extends CompactHashMap
{
    private static final int ENDPOINT = -2;
    @VisibleForTesting
    transient long[] links;
    private transient int firstEntry;
    private transient int lastEntry;
    private final boolean accessOrder;
    
    public static CompactLinkedHashMap create() {
        return new CompactLinkedHashMap();
    }
    
    public static CompactLinkedHashMap createWithExpectedSize(final int n) {
        return new CompactLinkedHashMap(n);
    }
    
    CompactLinkedHashMap() {
        this(3);
    }
    
    CompactLinkedHashMap(final int n) {
        this(n, 1.0f, false);
    }
    
    CompactLinkedHashMap(final int n, final float n2, final boolean accessOrder) {
        super(n, n2);
        this.accessOrder = accessOrder;
    }
    
    @Override
    void init(final int n, final float n2) {
        super.init(n, n2);
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.links = new long[n], -1L);
    }
    
    private int getPredecessor(final int n) {
        return (int)(this.links[n] >>> 32);
    }
    
    private int getSuccessor(final int n) {
        return (int)this.links[n];
    }
    
    private void setSuccessor(final int n, final int n2) {
        final long n3 = 4294967295L;
        this.links[n] = ((this.links[n] & ~n3) | (n2 & n3));
    }
    
    private void setPredecessor(final int n, final int n2) {
        this.links[n] = ((this.links[n] & ~0xFFFFFFFF00000000L) | n2 << 32);
    }
    
    private void setSucceeds(final int lastEntry, final int firstEntry) {
        if (lastEntry == -2) {
            this.firstEntry = firstEntry;
        }
        else {
            this.setSuccessor(lastEntry, firstEntry);
        }
        if (firstEntry == -2) {
            this.lastEntry = lastEntry;
        }
        else {
            this.setPredecessor(firstEntry, lastEntry);
        }
    }
    
    @Override
    void insertEntry(final int n, final Object o, final Object o2, final int n2) {
        super.insertEntry(n, o, o2, n2);
        this.setSucceeds(this.lastEntry, n);
        this.setSucceeds(n, -2);
    }
    
    @Override
    void accessEntry(final int n) {
        if (this.accessOrder) {
            this.setSucceeds(this.getPredecessor(n), this.getSuccessor(n));
            this.setSucceeds(this.lastEntry, n);
            this.setSucceeds(n, -2);
            ++this.modCount;
        }
    }
    
    @Override
    void moveLastEntry(final int n) {
        final int n2 = this.size() - 1;
        this.setSucceeds(this.getPredecessor(n), this.getSuccessor(n));
        if (n < n2) {
            this.setSucceeds(this.getPredecessor(n2), n);
            this.setSucceeds(n, this.getSuccessor(n2));
        }
        super.moveLastEntry(n);
    }
    
    @Override
    void resizeEntries(final int n) {
        super.resizeEntries(n);
        this.links = Arrays.copyOf(this.links, n);
    }
    
    @Override
    Set createEntrySet() {
        return new CompactLinkedHashMap$1EntrySetImpl(this);
    }
    
    @Override
    Set createKeySet() {
        return new CompactLinkedHashMap$1KeySetImpl(this);
    }
    
    @Override
    Collection createValues() {
        return new CompactLinkedHashMap$1ValuesImpl(this);
    }
    
    @Override
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }
}
