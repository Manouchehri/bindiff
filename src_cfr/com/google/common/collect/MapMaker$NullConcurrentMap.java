/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalCause;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMaker$RemovalNotification;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

class MapMaker$NullConcurrentMap
extends AbstractMap
implements Serializable,
ConcurrentMap {
    private static final long serialVersionUID = 0;
    private final MapMaker$RemovalListener removalListener;
    private final MapMaker$RemovalCause removalCause;

    MapMaker$NullConcurrentMap(MapMaker mapMaker) {
        this.removalListener = mapMaker.getRemovalListener();
        this.removalCause = mapMaker.nullRemovalCause;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return false;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return false;
    }

    @Override
    public Object get(@Nullable Object object) {
        return null;
    }

    void notifyRemoval(Object object, Object object2) {
        MapMaker$RemovalNotification mapMaker$RemovalNotification = new MapMaker$RemovalNotification(object, object2, this.removalCause);
        this.removalListener.onRemoval(mapMaker$RemovalNotification);
    }

    @Override
    public Object put(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        this.notifyRemoval(object, object2);
        return null;
    }

    @Override
    public Object putIfAbsent(Object object, Object object2) {
        return this.put(object, object2);
    }

    @Override
    public Object remove(@Nullable Object object) {
        return null;
    }

    @Override
    public boolean remove(@Nullable Object object, @Nullable Object object2) {
        return false;
    }

    @Override
    public Object replace(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        return null;
    }

    @Override
    public boolean replace(Object object, @Nullable Object object2, Object object3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object3);
        return false;
    }

    @Override
    public Set entrySet() {
        return Collections.emptySet();
    }
}

