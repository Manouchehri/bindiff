/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactLinkedHashMap$1EntrySetImpl;
import com.google.common.collect.CompactLinkedHashMap$1KeySetImpl;
import com.google.common.collect.CompactLinkedHashMap$1ValuesImpl;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@GoogleInternal
@GwtIncompatible(value="not worth using in GWT for now")
public class CompactLinkedHashMap
extends CompactHashMap {
    private static final int ENDPOINT = -2;
    @VisibleForTesting
    transient long[] links;
    private transient int firstEntry;
    private transient int lastEntry;
    private final boolean accessOrder;

    public static CompactLinkedHashMap create() {
        return new CompactLinkedHashMap();
    }

    public static CompactLinkedHashMap createWithExpectedSize(int n2) {
        return new CompactLinkedHashMap(n2);
    }

    CompactLinkedHashMap() {
        this(3);
    }

    CompactLinkedHashMap(int n2) {
        this(n2, 1.0f, false);
    }

    CompactLinkedHashMap(int n2, float f2, boolean bl2) {
        super(n2, f2);
        this.accessOrder = bl2;
    }

    @Override
    void init(int n2, float f2) {
        super.init(n2, f2);
        this.firstEntry = -2;
        this.lastEntry = -2;
        this.links = new long[n2];
        Arrays.fill(this.links, -1);
    }

    private int getPredecessor(int n2) {
        return (int)(this.links[n2] >>> 32);
    }

    private int getSuccessor(int n2) {
        return (int)this.links[n2];
    }

    private void setSuccessor(int n2, int n3) {
        long l2 = 0xFFFFFFFFL;
        this.links[n2] = this.links[n2] & (l2 ^ -1) | (long)n3 & l2;
    }

    private void setPredecessor(int n2, int n3) {
        long l2 = -4294967296L;
        this.links[n2] = this.links[n2] & (l2 ^ -1) | (long)n3 << 32;
    }

    private void setSucceeds(int n2, int n3) {
        if (n2 == -2) {
            this.firstEntry = n3;
        } else {
            this.setSuccessor(n2, n3);
        }
        if (n3 == -2) {
            this.lastEntry = n2;
            return;
        }
        this.setPredecessor(n3, n2);
    }

    @Override
    void insertEntry(int n2, Object object, Object object2, int n3) {
        super.insertEntry(n2, object, object2, n3);
        this.setSucceeds(this.lastEntry, n2);
        this.setSucceeds(n2, -2);
    }

    @Override
    void accessEntry(int n2) {
        if (!this.accessOrder) return;
        this.setSucceeds(this.getPredecessor(n2), this.getSuccessor(n2));
        this.setSucceeds(this.lastEntry, n2);
        this.setSucceeds(n2, -2);
        ++this.modCount;
    }

    @Override
    void moveLastEntry(int n2) {
        int n3 = this.size() - 1;
        this.setSucceeds(this.getPredecessor(n2), this.getSuccessor(n2));
        if (n2 < n3) {
            this.setSucceeds(this.getPredecessor(n3), n2);
            this.setSucceeds(n2, this.getSuccessor(n3));
        }
        super.moveLastEntry(n2);
    }

    @Override
    void resizeEntries(int n2) {
        super.resizeEntries(n2);
        this.links = Arrays.copyOf(this.links, n2);
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

    static /* synthetic */ int access$000(CompactLinkedHashMap compactLinkedHashMap) {
        return compactLinkedHashMap.firstEntry;
    }

    static /* synthetic */ int access$100(CompactLinkedHashMap compactLinkedHashMap, int n2) {
        return compactLinkedHashMap.getSuccessor(n2);
    }
}

