/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMapEntry;
import javax.annotation.Nullable;

class ImmutableMapEntry$NonTerminalImmutableMapEntry
extends ImmutableMapEntry {
    private final transient ImmutableMapEntry nextInKeyBucket;

    ImmutableMapEntry$NonTerminalImmutableMapEntry(Object object, Object object2, ImmutableMapEntry immutableMapEntry) {
        super(object, object2);
        this.nextInKeyBucket = immutableMapEntry;
    }

    @Nullable
    @Override
    final ImmutableMapEntry getNextInKeyBucket() {
        return this.nextInKeyBucket;
    }

    @Override
    final boolean isReusable() {
        return false;
    }
}

