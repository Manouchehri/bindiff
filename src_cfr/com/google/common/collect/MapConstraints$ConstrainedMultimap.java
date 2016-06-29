/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedMultimap$1;
import com.google.common.collect.MapConstraints$ConstrainedMultimap$1AsMap;
import com.google.common.collect.Multimap;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class MapConstraints$ConstrainedMultimap
extends ForwardingMultimap
implements Serializable {
    final MapConstraint constraint;
    final Multimap delegate;
    @LazyInit
    transient Collection entries;
    @LazyInit
    transient Map asMap;

    public MapConstraints$ConstrainedMultimap(Multimap multimap, MapConstraint mapConstraint) {
        this.delegate = (Multimap)Preconditions.checkNotNull(multimap);
        this.constraint = (MapConstraint)Preconditions.checkNotNull(mapConstraint);
    }

    @Override
    protected Multimap delegate() {
        return this.delegate;
    }

    @Override
    public Map asMap() {
        Map map = this.asMap;
        if (map != null) return map;
        Map map2 = this.delegate.asMap();
        this.asMap = map = new MapConstraints$ConstrainedMultimap$1AsMap(this, map2);
        return map;
    }

    @Override
    public Collection entries() {
        Collection collection = this.entries;
        if (collection != null) return collection;
        this.entries = collection = MapConstraints.access$300(this.delegate.entries(), this.constraint);
        return collection;
    }

    @Override
    public Collection get(Object object) {
        return Constraints.constrainedTypePreservingCollection(this.delegate.get(object), new MapConstraints$ConstrainedMultimap$1(this, object));
    }

    @Override
    public boolean put(Object object, Object object2) {
        this.constraint.checkKeyValue(object, object2);
        return this.delegate.put(object, object2);
    }

    @Override
    public boolean putAll(Object object, Iterable iterable) {
        return this.delegate.putAll(object, MapConstraints.access$400(object, iterable, this.constraint));
    }

    @Override
    public boolean putAll(Multimap multimap) {
        boolean bl2 = false;
        Iterator iterator = multimap.entries().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            bl2 |= this.put(entry.getKey(), entry.getValue());
        }
        return bl2;
    }

    @Override
    public Collection replaceValues(Object object, Iterable iterable) {
        return this.delegate.replaceValues(object, MapConstraints.access$400(object, iterable, this.constraint));
    }
}

