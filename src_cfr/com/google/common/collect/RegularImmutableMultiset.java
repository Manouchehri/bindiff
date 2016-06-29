/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$ImmutableEntry;
import com.google.common.collect.RegularImmutableMultiset$1;
import com.google.common.collect.RegularImmutableMultiset$ElementSet;
import com.google.common.collect.RegularImmutableMultiset$NonTerminalEntry;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
class RegularImmutableMultiset
extends ImmutableMultiset {
    static final RegularImmutableMultiset EMPTY = new RegularImmutableMultiset(ImmutableList.of());
    private final transient Multisets$ImmutableEntry[] entries;
    private final transient Multisets$ImmutableEntry[] hashTable;
    private final transient int size;
    private final transient int hashCode;
    @LazyInit
    private transient ImmutableSet elementSet;

    RegularImmutableMultiset(Collection collection) {
        int n2 = collection.size();
        Multisets$ImmutableEntry[] arrmultisets$ImmutableEntry = new Multisets$ImmutableEntry[n2];
        if (n2 == 0) {
            this.entries = arrmultisets$ImmutableEntry;
            this.hashTable = null;
            this.size = 0;
            this.hashCode = 0;
            this.elementSet = ImmutableSet.of();
            return;
        }
        int n3 = Hashing.closedTableSize(n2, 1.0);
        int n4 = n3 - 1;
        Multisets$ImmutableEntry[] arrmultisets$ImmutableEntry2 = new Multisets$ImmutableEntry[n3];
        int n5 = 0;
        int n6 = 0;
        long l2 = 0;
        Iterator iterator = collection.iterator();
        do {
            Multisets$ImmutableEntry multisets$ImmutableEntry2;
            Multisets$ImmutableEntry multisets$ImmutableEntry2;
            if (!iterator.hasNext()) {
                this.entries = arrmultisets$ImmutableEntry;
                this.hashTable = arrmultisets$ImmutableEntry2;
                this.size = Ints.saturatedCast(l2);
                this.hashCode = n6;
                return;
            }
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            Object object = Preconditions.checkNotNull(multiset$Entry.getElement());
            int n7 = multiset$Entry.getCount();
            int n8 = object.hashCode();
            int n9 = Hashing.smear(n8) & n4;
            Multisets$ImmutableEntry multisets$ImmutableEntry3 = arrmultisets$ImmutableEntry2[n9];
            if (multisets$ImmutableEntry3 == null) {
                boolean bl2 = multiset$Entry instanceof Multisets$ImmutableEntry && !(multiset$Entry instanceof RegularImmutableMultiset$NonTerminalEntry);
                multisets$ImmutableEntry2 = bl2 ? (Multisets$ImmutableEntry)multiset$Entry : new Multisets$ImmutableEntry(object, n7);
            } else {
                multisets$ImmutableEntry2 = new RegularImmutableMultiset$NonTerminalEntry(object, n7, multisets$ImmutableEntry3);
            }
            n6 += n8 ^ n7;
            arrmultisets$ImmutableEntry[n5++] = multisets$ImmutableEntry2;
            arrmultisets$ImmutableEntry2[n9] = multisets$ImmutableEntry2;
            l2 += (long)n7;
        } while (true);
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public int count(@Nullable Object object) {
        Multisets$ImmutableEntry[] arrmultisets$ImmutableEntry = this.hashTable;
        if (object == null) return 0;
        if (arrmultisets$ImmutableEntry == null) {
            return 0;
        }
        int n2 = Hashing.smearedHash(object);
        int n3 = arrmultisets$ImmutableEntry.length - 1;
        Multisets$ImmutableEntry multisets$ImmutableEntry = arrmultisets$ImmutableEntry[n2 & n3];
        while (multisets$ImmutableEntry != null) {
            if (Objects.equal(object, multisets$ImmutableEntry.getElement())) {
                return multisets$ImmutableEntry.getCount();
            }
            multisets$ImmutableEntry = multisets$ImmutableEntry.nextInBucket();
        }
        return 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableSet elementSet() {
        ImmutableSet immutableSet;
        ImmutableSet immutableSet2 = this.elementSet;
        if (immutableSet2 == null) {
            immutableSet = this.elementSet = new RegularImmutableMultiset$ElementSet(this, null);
            return immutableSet;
        }
        immutableSet = immutableSet2;
        return immutableSet;
    }

    @Override
    Multiset$Entry getEntry(int n2) {
        return this.entries[n2];
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    static /* synthetic */ Multisets$ImmutableEntry[] access$100(RegularImmutableMultiset regularImmutableMultiset) {
        return regularImmutableMultiset.entries;
    }
}

