/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;

enum MapMakerInternalMap$NullEntry implements MapMakerInternalMap$ReferenceEntry
{
    INSTANCE;
    

    private MapMakerInternalMap$NullEntry() {
    }

    @Override
    public MapMakerInternalMap$ValueReference getValueReference() {
        return null;
    }

    @Override
    public void setValueReference(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNext() {
        return null;
    }

    @Override
    public int getHash() {
        return 0;
    }

    @Override
    public Object getKey() {
        return null;
    }

    @Override
    public long getExpirationTime() {
        return 0;
    }

    @Override
    public void setExpirationTime(long l2) {
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
        return this;
    }

    @Override
    public void setNextExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
        return this;
    }

    @Override
    public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
        return this;
    }

    @Override
    public void setNextEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
        return this;
    }

    @Override
    public void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
    }
}

