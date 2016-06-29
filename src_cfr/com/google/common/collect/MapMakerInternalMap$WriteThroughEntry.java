/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.MapMakerInternalMap;
import java.util.Map;
import javax.annotation.Nullable;

final class MapMakerInternalMap$WriteThroughEntry
extends AbstractMapEntry {
    final Object key;
    Object value;
    final /* synthetic */ MapMakerInternalMap this$0;

    MapMakerInternalMap$WriteThroughEntry(MapMakerInternalMap mapMakerInternalMap, Object object, Object object2) {
        this.this$0 = mapMakerInternalMap;
        this.key = object;
        this.value = object2;
    }

    @Override
    public Object getKey() {
        return this.key;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        if (!this.key.equals(entry.getKey())) return false;
        if (!this.value.equals(entry.getValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode() ^ this.value.hashCode();
    }

    @Override
    public Object setValue(Object object) {
        Object object2 = this.this$0.put(this.key, object);
        this.value = object;
        return object2;
    }
}

