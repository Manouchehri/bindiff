/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import java.util.AbstractCollection;
import java.util.Map;
import javax.annotation.Nullable;

abstract class Multimaps$Entries
extends AbstractCollection {
    Multimaps$Entries() {
    }

    abstract Multimap multimap();

    @Override
    public int size() {
        return this.multimap().size();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        return this.multimap().containsEntry(entry.getKey(), entry.getValue());
    }

    @Override
    public boolean remove(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        return this.multimap().remove(entry.getKey(), entry.getValue());
    }

    @Override
    public void clear() {
        this.multimap().clear();
    }
}

