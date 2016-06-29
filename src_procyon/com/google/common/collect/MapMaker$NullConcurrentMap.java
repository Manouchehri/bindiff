package com.google.common.collect;

import java.io.*;
import java.util.concurrent.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

class MapMaker$NullConcurrentMap extends AbstractMap implements Serializable, ConcurrentMap
{
    private static final long serialVersionUID = 0L;
    private final MapMaker$RemovalListener removalListener;
    private final MapMaker$RemovalCause removalCause;
    
    MapMaker$NullConcurrentMap(final MapMaker mapMaker) {
        this.removalListener = mapMaker.getRemovalListener();
        this.removalCause = mapMaker.nullRemovalCause;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return false;
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return false;
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        return null;
    }
    
    void notifyRemoval(final Object o, final Object o2) {
        this.removalListener.onRemoval(new MapMaker$RemovalNotification(o, o2, this.removalCause));
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        this.notifyRemoval(o, o2);
        return null;
    }
    
    @Override
    public Object putIfAbsent(final Object o, final Object o2) {
        return this.put(o, o2);
    }
    
    @Override
    public Object remove(@Nullable final Object o) {
        return null;
    }
    
    @Override
    public boolean remove(@Nullable final Object o, @Nullable final Object o2) {
        return false;
    }
    
    @Override
    public Object replace(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        return null;
    }
    
    @Override
    public boolean replace(final Object o, @Nullable final Object o2, final Object o3) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o3);
        return false;
    }
    
    @Override
    public Set entrySet() {
        return Collections.emptySet();
    }
}
