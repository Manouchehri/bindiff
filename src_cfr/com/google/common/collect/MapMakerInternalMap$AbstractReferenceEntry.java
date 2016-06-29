/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;

abstract class MapMakerInternalMap$AbstractReferenceEntry
implements MapMakerInternalMap$ReferenceEntry {
    MapMakerInternalMap$AbstractReferenceEntry() {
    }

    @Override
    public MapMakerInternalMap$ValueReference getValueReference() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValueReference(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNext() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getHash() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getKey() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getExpirationTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setExpirationTime(long l2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }
}

