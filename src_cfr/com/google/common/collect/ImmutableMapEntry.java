/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableEntry;
import javax.annotation.Nullable;

@GwtIncompatible(value="unnecessary")
class ImmutableMapEntry
extends ImmutableEntry {
    static ImmutableMapEntry[] createEntryArray(int n2) {
        return new ImmutableMapEntry[n2];
    }

    ImmutableMapEntry(Object object, Object object2) {
        super(object, object2);
        CollectPreconditions.checkEntryNotNull(object, object2);
    }

    ImmutableMapEntry(ImmutableMapEntry immutableMapEntry) {
        super(immutableMapEntry.getKey(), immutableMapEntry.getValue());
    }

    @Nullable
    ImmutableMapEntry getNextInKeyBucket() {
        return null;
    }

    @Nullable
    ImmutableMapEntry getNextInValueBucket() {
        return null;
    }

    boolean isReusable() {
        return true;
    }
}

