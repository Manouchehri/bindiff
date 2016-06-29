/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

interface MapMakerInternalMap$ValueReference {
    public Object get();

    public Object waitForValue();

    public MapMakerInternalMap$ReferenceEntry getEntry();

    public MapMakerInternalMap$ValueReference copyFor(ReferenceQueue var1, @Nullable Object var2, MapMakerInternalMap$ReferenceEntry var3);

    public void clear(@Nullable MapMakerInternalMap$ValueReference var1);

    public boolean isComputingReference();
}

