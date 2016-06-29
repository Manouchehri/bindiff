/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableMapEntry;
import javax.annotation.Nullable;

final class ImmutableMapEntry$NonTerminalImmutableBiMapEntry
extends ImmutableMapEntry$NonTerminalImmutableMapEntry {
    private final transient ImmutableMapEntry nextInValueBucket;

    ImmutableMapEntry$NonTerminalImmutableBiMapEntry(Object object, Object object2, ImmutableMapEntry immutableMapEntry, ImmutableMapEntry immutableMapEntry2) {
        super(object, object2, immutableMapEntry);
        this.nextInValueBucket = immutableMapEntry2;
    }

    @Nullable
    @Override
    ImmutableMapEntry getNextInValueBucket() {
        return this.nextInValueBucket;
    }
}

