/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints;
import java.util.Map;
import java.util.Set;

class MapConstraints$ConstrainedMap
extends ForwardingMap {
    private final Map delegate;
    final MapConstraint constraint;
    private transient Set entrySet;

    MapConstraints$ConstrainedMap(Map map, MapConstraint mapConstraint) {
        this.delegate = (Map)Preconditions.checkNotNull(map);
        this.constraint = (MapConstraint)Preconditions.checkNotNull(mapConstraint);
    }

    @Override
    protected Map delegate() {
        return this.delegate;
    }

    @Override
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) return set;
        this.entrySet = set = MapConstraints.access$000(this.delegate.entrySet(), this.constraint);
        return set;
    }

    @Override
    public Object put(Object object, Object object2) {
        this.constraint.checkKeyValue(object, object2);
        return this.delegate.put(object, object2);
    }

    @Override
    public void putAll(Map map) {
        this.delegate.putAll(MapConstraints.access$100(map, this.constraint));
    }
}

