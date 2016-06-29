package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.primitives.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible(serializable = true)
class RegularImmutableMultiset extends ImmutableMultiset
{
    static final RegularImmutableMultiset EMPTY;
    private final transient Multisets$ImmutableEntry[] entries;
    private final transient Multisets$ImmutableEntry[] hashTable;
    private final transient int size;
    private final transient int hashCode;
    @LazyInit
    private transient ImmutableSet elementSet;
    
    RegularImmutableMultiset(final Collection collection) {
        final int size = collection.size();
        final Multisets$ImmutableEntry[] array = new Multisets$ImmutableEntry[size];
        if (size == 0) {
            this.entries = array;
            this.hashTable = null;
            this.size = 0;
            this.hashCode = 0;
            this.elementSet = ImmutableSet.of();
        }
        else {
            final int closedTableSize = Hashing.closedTableSize(size, 1.0);
            final int n = closedTableSize - 1;
            final Multisets$ImmutableEntry[] hashTable = new Multisets$ImmutableEntry[closedTableSize];
            int n2 = 0;
            int hashCode = 0;
            long n3 = 0L;
            for (final Multiset$Entry multiset$Entry : collection) {
                final Object checkNotNull = Preconditions.checkNotNull(multiset$Entry.getElement());
                final int count = multiset$Entry.getCount();
                final int hashCode2 = checkNotNull.hashCode();
                final int n4 = Hashing.smear(hashCode2) & n;
                final Multisets$ImmutableEntry multisets$ImmutableEntry = hashTable[n4];
                Multisets$ImmutableEntry multisets$ImmutableEntry2;
                if (multisets$ImmutableEntry == null) {
                    multisets$ImmutableEntry2 = ((multiset$Entry instanceof Multisets$ImmutableEntry && !(multiset$Entry instanceof RegularImmutableMultiset$NonTerminalEntry)) ? multiset$Entry : new Multisets$ImmutableEntry(checkNotNull, count));
                }
                else {
                    multisets$ImmutableEntry2 = new RegularImmutableMultiset$NonTerminalEntry(checkNotNull, count, multisets$ImmutableEntry);
                }
                hashCode += (hashCode2 ^ count);
                hashTable[n4] = (array[n2++] = multisets$ImmutableEntry2);
                n3 += count;
            }
            this.entries = array;
            this.hashTable = hashTable;
            this.size = Ints.saturatedCast(n3);
            this.hashCode = hashCode;
        }
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final Multisets$ImmutableEntry[] hashTable = this.hashTable;
        if (o == null || hashTable == null) {
            return 0;
        }
        for (Multisets$ImmutableEntry nextInBucket = hashTable[Hashing.smearedHash(o) & hashTable.length - 1]; nextInBucket != null; nextInBucket = nextInBucket.nextInBucket()) {
            if (Objects.equal(o, nextInBucket.getElement())) {
                return nextInBucket.getCount();
            }
        }
        return 0;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public ImmutableSet elementSet() {
        final ImmutableSet elementSet = this.elementSet;
        return (elementSet == null) ? (this.elementSet = new RegularImmutableMultiset$ElementSet(this, null)) : elementSet;
    }
    
    @Override
    Multiset$Entry getEntry(final int n) {
        return this.entries[n];
    }
    
    @Override
    public int hashCode() {
        return this.hashCode;
    }
    
    static {
        EMPTY = new RegularImmutableMultiset(ImmutableList.of());
    }
}
