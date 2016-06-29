package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

@GwtCompatible(serializable = true, emulated = true)
final class RegularImmutableMap extends ImmutableMap
{
    private final transient Entry[] entries;
    private final transient ImmutableMapEntry[] table;
    private final transient int mask;
    private static final double MAX_LOAD_FACTOR = 1.2;
    private static final long serialVersionUID = 0L;
    
    static RegularImmutableMap fromEntries(final Entry... array) {
        return fromEntryArray(array.length, array);
    }
    
    static RegularImmutableMap fromEntryArray(final int n, final Entry[] array) {
        Preconditions.checkPositionIndex(n, array.length);
        Entry[] entryArray;
        if (n == array.length) {
            entryArray = array;
        }
        else {
            entryArray = ImmutableMapEntry.createEntryArray(n);
        }
        final int closedTableSize = Hashing.closedTableSize(n, 1.2);
        final ImmutableMapEntry[] entryArray2 = ImmutableMapEntry.createEntryArray(closedTableSize);
        final int n2 = closedTableSize - 1;
        for (int i = 0; i < n; ++i) {
            final Entry entry = array[i];
            final Object key = entry.getKey();
            final Object value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            final int n3 = Hashing.smear(key.hashCode()) & n2;
            final ImmutableMapEntry immutableMapEntry = entryArray2[n3];
            ImmutableMapEntry immutableMapEntry2;
            if (immutableMapEntry == null) {
                immutableMapEntry2 = (ImmutableMapEntry)((entry instanceof ImmutableMapEntry && ((ImmutableMapEntry)entry).isReusable()) ? entry : new ImmutableMapEntry(key, value));
            }
            else {
                immutableMapEntry2 = new ImmutableMapEntry$NonTerminalImmutableMapEntry(key, value, immutableMapEntry);
            }
            entryArray2[n3] = immutableMapEntry2;
            checkNoConflictInKeyBucket(key, entryArray[i] = immutableMapEntry2, immutableMapEntry);
        }
        return new RegularImmutableMap(entryArray, entryArray2, n2);
    }
    
    private RegularImmutableMap(final Entry[] entries, final ImmutableMapEntry[] table, final int mask) {
        this.entries = entries;
        this.table = table;
        this.mask = mask;
    }
    
    static void checkNoConflictInKeyBucket(final Object o, final Entry entry, @Nullable ImmutableMapEntry nextInKeyBucket) {
        while (nextInKeyBucket != null) {
            ImmutableMap.checkNoConflict(!o.equals(nextInKeyBucket.getKey()), "key", entry, nextInKeyBucket);
            nextInKeyBucket = nextInKeyBucket.getNextInKeyBucket();
        }
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        return get(o, this.table, this.mask);
    }
    
    @Nullable
    static Object get(@Nullable final Object o, final ImmutableMapEntry[] array, final int n) {
        if (o == null) {
            return null;
        }
        for (ImmutableMapEntry nextInKeyBucket = array[Hashing.smear(o.hashCode()) & n]; nextInKeyBucket != null; nextInKeyBucket = nextInKeyBucket.getNextInKeyBucket()) {
            if (o.equals(nextInKeyBucket.getKey())) {
                return nextInKeyBucket.getValue();
            }
        }
        return null;
    }
    
    @Override
    public int size() {
        return this.entries.length;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    ImmutableSet createEntrySet() {
        return new ImmutableMapEntrySet$RegularEntrySet(this, this.entries);
    }
}
