package com.google.common.collect;

import javax.annotation.*;

public final class MapMaker$RemovalNotification extends ImmutableEntry
{
    private static final long serialVersionUID = 0L;
    private final MapMaker$RemovalCause cause;
    
    MapMaker$RemovalNotification(@Nullable final Object o, @Nullable final Object o2, final MapMaker$RemovalCause cause) {
        super(o, o2);
        this.cause = cause;
    }
    
    public MapMaker$RemovalCause getCause() {
        return this.cause;
    }
    
    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
