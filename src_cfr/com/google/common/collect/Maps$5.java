/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import java.util.Map;

final class Maps$5
extends AbstractMapEntry {
    final /* synthetic */ Map.Entry val$entry;

    Maps$5(Map.Entry entry) {
        this.val$entry = entry;
    }

    @Override
    public Object getKey() {
        return this.val$entry.getKey();
    }

    @Override
    public Object getValue() {
        return this.val$entry.getValue();
    }
}

