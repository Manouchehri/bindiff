/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ValueReference;

interface MapMakerInternalMap$ReferenceEntry {
    public MapMakerInternalMap$ValueReference getValueReference();

    public void setValueReference(MapMakerInternalMap$ValueReference var1);

    public MapMakerInternalMap$ReferenceEntry getNext();

    public int getHash();

    public Object getKey();

    public long getExpirationTime();

    public void setExpirationTime(long var1);

    public MapMakerInternalMap$ReferenceEntry getNextExpirable();

    public void setNextExpirable(MapMakerInternalMap$ReferenceEntry var1);

    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable();

    public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry var1);

    public MapMakerInternalMap$ReferenceEntry getNextEvictable();

    public void setNextEvictable(MapMakerInternalMap$ReferenceEntry var1);

    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable();

    public void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry var1);
}

