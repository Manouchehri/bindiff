/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableBiMapEntry;
import com.google.common.collect.ImmutableMapEntrySet$RegularEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap$1;
import com.google.common.collect.RegularImmutableBiMap$Inverse;
import com.google.common.collect.RegularImmutableMap;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
class RegularImmutableBiMap
extends ImmutableBiMap {
    static final RegularImmutableBiMap EMPTY = new RegularImmutableBiMap(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    static final double MAX_LOAD_FACTOR = 1.2;
    private final transient ImmutableMapEntry[] keyTable;
    private final transient ImmutableMapEntry[] valueTable;
    private final transient Map.Entry[] entries;
    private final transient int mask;
    private final transient int hashCode;
    @LazyInit
    private transient ImmutableBiMap inverse;

    static /* varargs */ RegularImmutableBiMap fromEntries(Map.Entry ... arrentry) {
        return RegularImmutableBiMap.fromEntryArray(arrentry.length, arrentry);
    }

    static RegularImmutableBiMap fromEntryArray(int n2, Map.Entry[] arrentry) {
        Preconditions.checkPositionIndex(n2, arrentry.length);
        int n3 = Hashing.closedTableSize(n2, 1.2);
        int n4 = n3 - 1;
        ImmutableMapEntry[] arrimmutableMapEntry = ImmutableMapEntry.createEntryArray(n3);
        ImmutableMapEntry[] arrimmutableMapEntry2 = ImmutableMapEntry.createEntryArray(n3);
        Map.Entry[] arrentry2 = n2 == arrentry.length ? arrentry : ImmutableMapEntry.createEntryArray(n2);
        int n5 = 0;
        int n6 = 0;
        while (n6 < n2) {
            ImmutableMapEntry immutableMapEntry2;
            ImmutableMapEntry immutableMapEntry2;
            Map.Entry entry = arrentry[n6];
            Object k2 = entry.getKey();
            Object v2 = entry.getValue();
            CollectPreconditions.checkEntryNotNull(k2, v2);
            int n7 = k2.hashCode();
            int n8 = v2.hashCode();
            int n9 = Hashing.smear(n7) & n4;
            int n10 = Hashing.smear(n8) & n4;
            ImmutableMapEntry immutableMapEntry3 = arrimmutableMapEntry[n9];
            RegularImmutableMap.checkNoConflictInKeyBucket(k2, entry, immutableMapEntry3);
            ImmutableMapEntry immutableMapEntry4 = arrimmutableMapEntry2[n10];
            RegularImmutableBiMap.checkNoConflictInValueBucket(v2, entry, immutableMapEntry4);
            if (immutableMapEntry4 == null && immutableMapEntry3 == null) {
                boolean bl2 = entry instanceof ImmutableMapEntry && ((ImmutableMapEntry)entry).isReusable();
                immutableMapEntry2 = bl2 ? (ImmutableMapEntry)entry : new ImmutableMapEntry(k2, v2);
            } else {
                immutableMapEntry2 = new ImmutableMapEntry$NonTerminalImmutableBiMapEntry(k2, v2, immutableMapEntry3, immutableMapEntry4);
            }
            arrimmutableMapEntry[n9] = immutableMapEntry2;
            arrimmutableMapEntry2[n10] = immutableMapEntry2;
            arrentry2[n6] = immutableMapEntry2;
            n5 += n7 ^ n8;
            ++n6;
        }
        return new RegularImmutableBiMap(arrimmutableMapEntry, arrimmutableMapEntry2, arrentry2, n4, n5);
    }

    private RegularImmutableBiMap(ImmutableMapEntry[] arrimmutableMapEntry, ImmutableMapEntry[] arrimmutableMapEntry2, Map.Entry[] arrentry, int n2, int n3) {
        this.keyTable = arrimmutableMapEntry;
        this.valueTable = arrimmutableMapEntry2;
        this.entries = arrentry;
        this.mask = n2;
        this.hashCode = n3;
    }

    private static void checkNoConflictInValueBucket(Object object, Map.Entry entry, @Nullable ImmutableMapEntry immutableMapEntry) {
        while (immutableMapEntry != null) {
            RegularImmutableBiMap.checkNoConflict(!object.equals(immutableMapEntry.getValue()), "value", entry, immutableMapEntry);
            immutableMapEntry = immutableMapEntry.getNextInValueBucket();
        }
    }

    @Nullable
    @Override
    public Object get(@Nullable Object object) {
        if (this.keyTable == null) {
            return null;
        }
        Object object2 = RegularImmutableMap.get(object, this.keyTable, this.mask);
        return object2;
    }

    @Override
    ImmutableSet createEntrySet() {
        ImmutableSet immutableSet;
        if (this.isEmpty()) {
            immutableSet = ImmutableSet.of();
            return immutableSet;
        }
        immutableSet = new ImmutableMapEntrySet$RegularEntrySet(this, this.entries);
        return immutableSet;
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
        ImmutableBiMap immutableBiMap;
        if (this.isEmpty()) {
            return ImmutableBiMap.of();
        }
        ImmutableBiMap immutableBiMap2 = this.inverse;
        if (immutableBiMap2 == null) {
            immutableBiMap = this.inverse = new RegularImmutableBiMap$Inverse(this, null);
            return immutableBiMap;
        }
        immutableBiMap = immutableBiMap2;
        return immutableBiMap;
    }

    static /* synthetic */ ImmutableMapEntry[] access$100(RegularImmutableBiMap regularImmutableBiMap) {
        return regularImmutableBiMap.valueTable;
    }

    static /* synthetic */ int access$200(RegularImmutableBiMap regularImmutableBiMap) {
        return regularImmutableBiMap.mask;
    }

    static /* synthetic */ int access$300(RegularImmutableBiMap regularImmutableBiMap) {
        return regularImmutableBiMap.hashCode;
    }

    static /* synthetic */ Map.Entry[] access$400(RegularImmutableBiMap regularImmutableBiMap) {
        return regularImmutableBiMap.entries;
    }
}

