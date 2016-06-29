/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Hashing;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet$1;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;

@VisibleForTesting
final class LinkedHashMultimap$ValueSet
extends Sets$ImprovedAbstractSet
implements LinkedHashMultimap$ValueSetLink {
    private final Object key;
    @VisibleForTesting
    LinkedHashMultimap$ValueEntry[] hashTable;
    private int size;
    private int modCount;
    private LinkedHashMultimap$ValueSetLink firstEntry;
    private LinkedHashMultimap$ValueSetLink lastEntry;
    final /* synthetic */ LinkedHashMultimap this$0;

    LinkedHashMultimap$ValueSet(LinkedHashMultimap linkedHashMultimap, Object object, int n2) {
        LinkedHashMultimap$ValueEntry[] arrlinkedHashMultimap$ValueEntry;
        this.this$0 = linkedHashMultimap;
        this.size = 0;
        this.modCount = 0;
        this.key = object;
        this.firstEntry = this;
        this.lastEntry = this;
        int n3 = Hashing.closedTableSize(n2, 1.0);
        this.hashTable = arrlinkedHashMultimap$ValueEntry = new LinkedHashMultimap$ValueEntry[n3];
    }

    private int mask() {
        return this.hashTable.length - 1;
    }

    @Override
    public LinkedHashMultimap$ValueSetLink getPredecessorInValueSet() {
        return this.lastEntry;
    }

    @Override
    public LinkedHashMultimap$ValueSetLink getSuccessorInValueSet() {
        return this.firstEntry;
    }

    @Override
    public void setPredecessorInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        this.lastEntry = linkedHashMultimap$ValueSetLink;
    }

    @Override
    public void setSuccessorInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        this.firstEntry = linkedHashMultimap$ValueSetLink;
    }

    @Override
    public Iterator iterator() {
        return new LinkedHashMultimap$ValueSet$1(this);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        int n2 = Hashing.smearedHash(object);
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = this.hashTable[n2 & this.mask()];
        while (linkedHashMultimap$ValueEntry != null) {
            if (linkedHashMultimap$ValueEntry.matchesValue(object, n2)) {
                return true;
            }
            linkedHashMultimap$ValueEntry = linkedHashMultimap$ValueEntry.nextInValueBucket;
        }
        return false;
    }

    @Override
    public boolean add(@Nullable Object object) {
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry;
        int n2 = Hashing.smearedHash(object);
        int n3 = n2 & this.mask();
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2 = linkedHashMultimap$ValueEntry = this.hashTable[n3];
        do {
            if (linkedHashMultimap$ValueEntry2 == null) {
                linkedHashMultimap$ValueEntry2 = new LinkedHashMultimap$ValueEntry(this.key, object, n2, linkedHashMultimap$ValueEntry);
                LinkedHashMultimap.access$200(this.lastEntry, linkedHashMultimap$ValueEntry2);
                LinkedHashMultimap.access$200(linkedHashMultimap$ValueEntry2, this);
                LinkedHashMultimap.access$400(LinkedHashMultimap.access$300(this.this$0).getPredecessorInMultimap(), linkedHashMultimap$ValueEntry2);
                LinkedHashMultimap.access$400(linkedHashMultimap$ValueEntry2, LinkedHashMultimap.access$300(this.this$0));
                this.hashTable[n3] = linkedHashMultimap$ValueEntry2;
                ++this.size;
                ++this.modCount;
                this.rehashIfNecessary();
                return true;
            }
            if (linkedHashMultimap$ValueEntry2.matchesValue(object, n2)) {
                return false;
            }
            linkedHashMultimap$ValueEntry2 = linkedHashMultimap$ValueEntry2.nextInValueBucket;
        } while (true);
    }

    private void rehashIfNecessary() {
        LinkedHashMultimap$ValueEntry[] arrlinkedHashMultimap$ValueEntry;
        if (!Hashing.needsResizing(this.size, this.hashTable.length, 1.0)) return;
        this.hashTable = arrlinkedHashMultimap$ValueEntry = new LinkedHashMultimap$ValueEntry[this.hashTable.length * 2];
        int n2 = arrlinkedHashMultimap$ValueEntry.length - 1;
        LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink = this.firstEntry;
        while (linkedHashMultimap$ValueSetLink != this) {
            LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = (LinkedHashMultimap$ValueEntry)linkedHashMultimap$ValueSetLink;
            int n3 = linkedHashMultimap$ValueEntry.smearedValueHash & n2;
            linkedHashMultimap$ValueEntry.nextInValueBucket = arrlinkedHashMultimap$ValueEntry[n3];
            arrlinkedHashMultimap$ValueEntry[n3] = linkedHashMultimap$ValueEntry;
            linkedHashMultimap$ValueSetLink = linkedHashMultimap$ValueSetLink.getSuccessorInValueSet();
        }
    }

    @Override
    public boolean remove(@Nullable Object object) {
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry;
        block4 : {
            int n2 = Hashing.smearedHash(object);
            int n3 = n2 & this.mask();
            LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2 = null;
            linkedHashMultimap$ValueEntry = this.hashTable[n3];
            while (linkedHashMultimap$ValueEntry != null) {
                if (linkedHashMultimap$ValueEntry.matchesValue(object, n2)) {
                    if (linkedHashMultimap$ValueEntry2 == null) {
                        this.hashTable[n3] = linkedHashMultimap$ValueEntry.nextInValueBucket;
                    } else {
                        linkedHashMultimap$ValueEntry2.nextInValueBucket = linkedHashMultimap$ValueEntry.nextInValueBucket;
                    }
                    break block4;
                }
                linkedHashMultimap$ValueEntry2 = linkedHashMultimap$ValueEntry;
                linkedHashMultimap$ValueEntry = linkedHashMultimap$ValueEntry.nextInValueBucket;
            }
            return false;
        }
        LinkedHashMultimap.access$500(linkedHashMultimap$ValueEntry);
        LinkedHashMultimap.access$600(linkedHashMultimap$ValueEntry);
        --this.size;
        ++this.modCount;
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(this.hashTable, null);
        this.size = 0;
        LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink = this.firstEntry;
        do {
            if (linkedHashMultimap$ValueSetLink == this) {
                LinkedHashMultimap.access$200(this, this);
                ++this.modCount;
                return;
            }
            LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = (LinkedHashMultimap$ValueEntry)linkedHashMultimap$ValueSetLink;
            LinkedHashMultimap.access$600(linkedHashMultimap$ValueEntry);
            linkedHashMultimap$ValueSetLink = linkedHashMultimap$ValueSetLink.getSuccessorInValueSet();
        } while (true);
    }

    static /* synthetic */ LinkedHashMultimap$ValueSetLink access$000(LinkedHashMultimap$ValueSet linkedHashMultimap$ValueSet) {
        return linkedHashMultimap$ValueSet.firstEntry;
    }

    static /* synthetic */ int access$100(LinkedHashMultimap$ValueSet linkedHashMultimap$ValueSet) {
        return linkedHashMultimap$ValueSet.modCount;
    }
}

