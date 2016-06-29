/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.CompactHashSet;
import com.google.common.collect.CompactLinkedHashSet$1;
import com.google.common.collect.ObjectArrays;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

@GoogleInternal
@GwtIncompatible(value="not worth using in GWT for now")
public class CompactLinkedHashSet
extends CompactHashSet {
    private static final int ENDPOINT = -2;
    private transient int[] predecessor;
    private transient int[] successor;
    private transient int firstEntry;
    private transient int lastEntry;

    public static CompactLinkedHashSet create() {
        return new CompactLinkedHashSet();
    }

    public static CompactLinkedHashSet create(Collection collection) {
        CompactLinkedHashSet compactLinkedHashSet = CompactLinkedHashSet.createWithExpectedSize(collection.size());
        compactLinkedHashSet.addAll(collection);
        return compactLinkedHashSet;
    }

    public static /* varargs */ CompactLinkedHashSet create(Object ... arrobject) {
        CompactLinkedHashSet compactLinkedHashSet = CompactLinkedHashSet.createWithExpectedSize(arrobject.length);
        Collections.addAll(compactLinkedHashSet, arrobject);
        return compactLinkedHashSet;
    }

    public static CompactLinkedHashSet createWithExpectedSize(int n2) {
        return new CompactLinkedHashSet(n2);
    }

    CompactLinkedHashSet() {
    }

    CompactLinkedHashSet(int n2) {
        super(n2);
    }

    @Override
    void init(int n2, float f2) {
        super.init(n2, f2);
        this.predecessor = new int[n2];
        this.successor = new int[n2];
        Arrays.fill(this.predecessor, -1);
        Arrays.fill(this.successor, -1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    private void succeeds(int n2, int n3) {
        if (n2 == -2) {
            this.firstEntry = n3;
        } else {
            this.successor[n2] = n3;
        }
        if (n3 == -2) {
            this.lastEntry = n2;
            return;
        }
        this.predecessor[n3] = n2;
    }

    @Override
    void insertEntry(int n2, Object object, int n3) {
        super.insertEntry(n2, object, n3);
        this.succeeds(this.lastEntry, n2);
        this.succeeds(n2, -2);
    }

    @Override
    void moveEntry(int n2) {
        int n3 = this.size() - 1;
        super.moveEntry(n2);
        this.succeeds(this.predecessor[n2], this.successor[n2]);
        if (n3 != n2) {
            this.succeeds(this.predecessor[n3], n2);
            this.succeeds(n2, this.successor[n3]);
        }
        this.predecessor[n3] = -1;
        this.successor[n3] = -1;
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
    void resizeEntries(int n2) {
        super.resizeEntries(n2);
        int n3 = this.predecessor.length;
        this.predecessor = Arrays.copyOf(this.predecessor, n2);
        this.successor = Arrays.copyOf(this.successor, n2);
        if (n3 >= n2) return;
        Arrays.fill(this.predecessor, n3, n2, -1);
        Arrays.fill(this.successor, n3, n2, -1);
    }

    @Override
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return ObjectArrays.toArrayImpl(this, arrobject);
    }

    @Override
    public Iterator iterator() {
        return new CompactLinkedHashSet$1(this);
    }

    static /* synthetic */ int access$000(CompactLinkedHashSet compactLinkedHashSet) {
        return compactLinkedHashSet.firstEntry;
    }

    static /* synthetic */ int[] access$100(CompactLinkedHashSet compactLinkedHashSet) {
        return compactLinkedHashSet.successor;
    }
}

