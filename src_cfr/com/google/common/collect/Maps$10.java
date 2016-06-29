/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.Maps$EntryTransformer;
import java.util.Map;

final class Maps$10
extends AbstractMapEntry {
    final /* synthetic */ Map.Entry val$entry;
    final /* synthetic */ Maps$EntryTransformer val$transformer;

    Maps$10(Map.Entry entry, Maps$EntryTransformer entryTransformer) {
        this.val$entry = entry;
        this.val$transformer = entryTransformer;
    }

    @Override
    public Object getKey() {
        return this.val$entry.getKey();
    }

    @Override
    public Object getValue() {
        return this.val$transformer.transformEntry(this.val$entry.getKey(), this.val$entry.getValue());
    }
}

