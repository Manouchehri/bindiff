/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet$RegularEntrySet;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
final class RegularImmutableMap
extends ImmutableMap {
    private final transient Map.Entry[] entries;
    private final transient ImmutableMapEntry[] table;
    private final transient int mask;
    private static final double MAX_LOAD_FACTOR = 1.2;
    private static final long serialVersionUID = 0;

    static /* varargs */ RegularImmutableMap fromEntries(Map.Entry ... arrentry) {
        return RegularImmutableMap.fromEntryArray(arrentry.length, arrentry);
    }

    static RegularImmutableMap fromEntryArray(int n2, Map.Entry[] arrentry) {
        Preconditions.checkPositionIndex(n2, arrentry.length);
        Map.Entry[] arrentry2 = n2 == arrentry.length ? arrentry : ImmutableMapEntry.createEntryArray(n2);
        int n3 = Hashing.closedTableSize(n2, 1.2);
        ImmutableMapEntry[] arrimmutableMapEntry = ImmutableMapEntry.createEntryArray(n3);
        int n4 = n3 - 1;
        int n5 = 0;
        while (n5 < n2) {
            ImmutableMapEntry immutableMapEntry2;
            ImmutableMapEntry immutableMapEntry2;
            Map.Entry entry = arrentry[n5];
            Object k2 = entry.getKey();
            Object v2 = entry.getValue();
            CollectPreconditions.checkEntryNotNull(k2, v2);
            int n6 = Hashing.smear(k2.hashCode()) & n4;
            ImmutableMapEntry immutableMapEntry3 = arrimmutableMapEntry[n6];
            if (immutableMapEntry3 == null) {
                boolean bl2 = entry instanceof ImmutableMapEntry && ((ImmutableMapEntry)entry).isReusable();
                immutableMapEntry2 = bl2 ? (ImmutableMapEntry)entry : new ImmutableMapEntry(k2, v2);
            } else {
                immutableMapEntry2 = new ImmutableMapEntry$NonTerminalImmutableMapEntry(k2, v2, immutableMapEntry3);
            }
            arrimmutableMapEntry[n6] = immutableMapEntry2;
            arrentry2[n5] = immutableMapEntry2;
            RegularImmutableMap.checkNoConflictInKeyBucket(k2, immutableMapEntry2, immutableMapEntry3);
            ++n5;
        }
        return new RegularImmutableMap(arrentry2, arrimmutableMapEntry, n4);
    }

    private RegularImmutableMap(Map.Entry[] arrentry, ImmutableMapEntry[] arrimmutableMapEntry, int n2) {
        this.entries = arrentry;
        this.table = arrimmutableMapEntry;
        this.mask = n2;
    }

    static void checkNoConflictInKeyBucket(Object object, Map.Entry entry, @Nullable ImmutableMapEntry immutableMapEntry) {
        while (immutableMapEntry != null) {
            RegularImmutableMap.checkNoConflict(!object.equals(immutableMapEntry.getKey()), "key", entry, immutableMapEntry);
            immutableMapEntry = immutableMapEntry.getNextInKeyBucket();
        }
    }

    @Override
    public Object get(@Nullable Object object) {
        return RegularImmutableMap.get(object, this.table, this.mask);
    }

    @Nullable
    static Object get(@Nullable Object object, ImmutableMapEntry[] arrimmutableMapEntry, int n2) {
        if (object == null) {
            return null;
        }
        int n3 = Hashing.smear(object.hashCode()) & n2;
        ImmutableMapEntry immutableMapEntry = arrimmutableMapEntry[n3];
        while (immutableMapEntry != null) {
            Object object2 = immutableMapEntry.getKey();
            if (object.equals(object2)) {
                return immutableMapEntry.getValue();
            }
            immutableMapEntry = immutableMapEntry.getNextInKeyBucket();
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

