/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.CompactHashMap;
import javax.annotation.Nullable;

final class CompactHashMap$MapEntry
extends AbstractMapEntry {
    @Nullable
    private final Object key;
    private int lastKnownIndex;
    final /* synthetic */ CompactHashMap this$0;

    CompactHashMap$MapEntry(CompactHashMap compactHashMap, int n2) {
        this.this$0 = compactHashMap;
        this.key = compactHashMap.keys[n2];
        this.lastKnownIndex = n2;
    }

    @Override
    public Object getKey() {
        return this.key;
    }

    @Override
    public Object getValue() {
        if (this.lastKnownIndex == -1 || this.lastKnownIndex >= this.this$0.size() || !Objects.equal(this.key, this.this$0.keys[this.lastKnownIndex])) {
            this.lastKnownIndex = CompactHashMap.access$200(this.this$0, this.key);
        }
        if (this.lastKnownIndex == -1) {
            return null;
        }
        Object object = this.this$0.values[this.lastKnownIndex];
        return object;
    }
}

