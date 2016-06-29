/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableBiMap$1;
import com.google.common.collect.RegularImmutableBiMap$Inverse$InverseEntrySet;
import com.google.common.collect.RegularImmutableBiMap$InverseSerializedForm;
import javax.annotation.Nullable;

final class RegularImmutableBiMap$Inverse
extends ImmutableBiMap {
    final /* synthetic */ RegularImmutableBiMap this$0;

    private RegularImmutableBiMap$Inverse(RegularImmutableBiMap regularImmutableBiMap) {
        this.this$0 = regularImmutableBiMap;
    }

    @Override
    public int size() {
        return this.inverse().size();
    }

    @Override
    public ImmutableBiMap inverse() {
        return this.this$0;
    }

    @Override
    public Object get(@Nullable Object object) {
        if (object == null) return null;
        if (RegularImmutableBiMap.access$100(this.this$0) == null) {
            return null;
        }
        int n2 = Hashing.smear(object.hashCode()) & RegularImmutableBiMap.access$200(this.this$0);
        ImmutableMapEntry immutableMapEntry = RegularImmutableBiMap.access$100(this.this$0)[n2];
        while (immutableMapEntry != null) {
            if (object.equals(immutableMapEntry.getValue())) {
                return immutableMapEntry.getKey();
            }
            immutableMapEntry = immutableMapEntry.getNextInValueBucket();
        }
        return null;
    }

    @Override
    ImmutableSet createEntrySet() {
        return new RegularImmutableBiMap$Inverse$InverseEntrySet(this);
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    Object writeReplace() {
        return new RegularImmutableBiMap$InverseSerializedForm(this.this$0);
    }

    /* synthetic */ RegularImmutableBiMap$Inverse(RegularImmutableBiMap regularImmutableBiMap, RegularImmutableBiMap$1 regularImmutableBiMap$1) {
        this(regularImmutableBiMap);
    }
}

