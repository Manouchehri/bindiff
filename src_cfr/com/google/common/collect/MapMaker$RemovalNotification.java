/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.MapMaker$RemovalCause;
import javax.annotation.Nullable;

public final class MapMaker$RemovalNotification
extends ImmutableEntry {
    private static final long serialVersionUID = 0;
    private final MapMaker$RemovalCause cause;

    MapMaker$RemovalNotification(@Nullable Object object, @Nullable Object object2, MapMaker$RemovalCause mapMaker$RemovalCause) {
        super(object, object2);
        this.cause = mapMaker$RemovalCause;
    }

    public MapMaker$RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}

