package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible
final class WellBehavedMap extends ForwardingMap
{
    private final Map delegate;
    private Set entrySet;
    
    private WellBehavedMap(final Map delegate) {
        this.delegate = delegate;
    }
    
    static WellBehavedMap wrap(final Map map) {
        return new WellBehavedMap(map);
    }
    
    @Override
    protected Map delegate() {
        return this.delegate;
    }
    
    @Override
    public Set entrySet() {
        final Set entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        return this.entrySet = new WellBehavedMap$EntrySet(this, null);
    }
}
