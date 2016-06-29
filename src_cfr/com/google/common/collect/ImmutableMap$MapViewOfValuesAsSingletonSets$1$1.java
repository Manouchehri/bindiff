/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1;
import com.google.common.collect.ImmutableSet;
import java.util.Map;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1$1
extends AbstractMapEntry {
    final /* synthetic */ Map.Entry val$backingEntry;
    final /* synthetic */ ImmutableMap.MapViewOfValuesAsSingletonSets.1 this$2;

    ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(ImmutableMap.MapViewOfValuesAsSingletonSets.1 var1_1, Map.Entry entry) {
        this.this$2 = var1_1;
        this.val$backingEntry = entry;
    }

    @Override
    public Object getKey() {
        return this.val$backingEntry.getKey();
    }

    @Override
    public ImmutableSet getValue() {
        return ImmutableSet.of(this.val$backingEntry.getValue());
    }
}

