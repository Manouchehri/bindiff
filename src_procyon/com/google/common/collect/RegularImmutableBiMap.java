package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;

@GwtCompatible(serializable = true, emulated = true)
class RegularImmutableBiMap extends ImmutableBiMap
{
    static final RegularImmutableBiMap EMPTY;
    static final double MAX_LOAD_FACTOR = 1.2;
    private final transient ImmutableMapEntry[] keyTable;
    private final transient ImmutableMapEntry[] valueTable;
    private final transient Entry[] entries;
    private final transient int mask;
    private final transient int hashCode;
    @LazyInit
    private transient ImmutableBiMap inverse;
    
    static RegularImmutableBiMap fromEntries(final Entry... array) {
        return fromEntryArray(array.length, array);
    }
    
    static RegularImmutableBiMap fromEntryArray(final int n, final Entry[] array) {
        Preconditions.checkPositionIndex(n, array.length);
        final int closedTableSize = Hashing.closedTableSize(n, 1.2);
        final int n2 = closedTableSize - 1;
        final ImmutableMapEntry[] entryArray = ImmutableMapEntry.createEntryArray(closedTableSize);
        final ImmutableMapEntry[] entryArray2 = ImmutableMapEntry.createEntryArray(closedTableSize);
        Entry[] entryArray3;
        if (n == array.length) {
            entryArray3 = array;
        }
        else {
            entryArray3 = ImmutableMapEntry.createEntryArray(n);
        }
        int n3 = 0;
        for (int i = 0; i < n; ++i) {
            final Entry entry = array[i];
            final Object key = entry.getKey();
            final Object value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            final int hashCode = key.hashCode();
            final int hashCode2 = value.hashCode();
            final int n4 = Hashing.smear(hashCode) & n2;
            final int n5 = Hashing.smear(hashCode2) & n2;
            final ImmutableMapEntry immutableMapEntry = entryArray[n4];
            RegularImmutableMap.checkNoConflictInKeyBucket(key, entry, immutableMapEntry);
            final ImmutableMapEntry immutableMapEntry2 = entryArray2[n5];
            checkNoConflictInValueBucket(value, entry, immutableMapEntry2);
            ImmutableMapEntry immutableMapEntry3;
            if (immutableMapEntry2 == null && immutableMapEntry == null) {
                immutableMapEntry3 = (ImmutableMapEntry)((entry instanceof ImmutableMapEntry && ((ImmutableMapEntry)entry).isReusable()) ? entry : new ImmutableMapEntry(key, value));
            }
            else {
                immutableMapEntry3 = new ImmutableMapEntry$NonTerminalImmutableBiMapEntry(key, value, immutableMapEntry, immutableMapEntry2);
            }
            entryArray[n4] = immutableMapEntry3;
            entryArray3[i] = (entryArray2[n5] = immutableMapEntry3);
            n3 += (hashCode ^ hashCode2);
        }
        return new RegularImmutableBiMap(entryArray, entryArray2, entryArray3, n2, n3);
    }
    
    private RegularImmutableBiMap(final ImmutableMapEntry[] keyTable, final ImmutableMapEntry[] valueTable, final Entry[] entries, final int mask, final int hashCode) {
        this.keyTable = keyTable;
        this.valueTable = valueTable;
        this.entries = entries;
        this.mask = mask;
        this.hashCode = hashCode;
    }
    
    private static void checkNoConflictInValueBucket(final Object o, final Entry entry, @Nullable ImmutableMapEntry nextInValueBucket) {
        while (nextInValueBucket != null) {
            ImmutableMap.checkNoConflict(!o.equals(nextInValueBucket.getValue()), "value", entry, nextInValueBucket);
            nextInValueBucket = nextInValueBucket.getNextInValueBucket();
        }
    }
    
    @Nullable
    @Override
    public Object get(@Nullable final Object o) {
        return (this.keyTable == null) ? null : RegularImmutableMap.get(o, this.keyTable, this.mask);
    }
    
    @Override
    ImmutableSet createEntrySet() {
        return this.isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet$RegularEntrySet(this, this.entries);
    }
    
    @Override
    boolean isHashCodeFast() {
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.hashCode;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public int size() {
        return this.entries.length;
    }
    
    @Override
    public ImmutableBiMap inverse() {
        if (this.isEmpty()) {
            return ImmutableBiMap.of();
        }
        final ImmutableBiMap inverse = this.inverse;
        return (inverse == null) ? (this.inverse = new RegularImmutableBiMap$Inverse(this, null)) : inverse;
    }
    
    static {
        EMPTY = new RegularImmutableBiMap(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    }
}
