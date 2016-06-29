package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

class MapConstraints$ConstrainedMap extends ForwardingMap
{
    private final Map delegate;
    final MapConstraint constraint;
    private transient Set entrySet;
    
    MapConstraints$ConstrainedMap(final Map map, final MapConstraint mapConstraint) {
        this.delegate = (Map)Preconditions.checkNotNull(map);
        this.constraint = (MapConstraint)Preconditions.checkNotNull(mapConstraint);
    }
    
    @Override
    protected Map delegate() {
        return this.delegate;
    }
    
    @Override
    public Set entrySet() {
        Set entrySet = this.entrySet;
        if (entrySet == null) {
            entrySet = (this.entrySet = constrainedEntrySet(this.delegate.entrySet(), this.constraint));
        }
        return entrySet;
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        this.constraint.checkKeyValue(o, o2);
        return this.delegate.put(o, o2);
    }
    
    @Override
    public void putAll(final Map map) {
        this.delegate.putAll(checkMap(map, this.constraint));
    }
}
