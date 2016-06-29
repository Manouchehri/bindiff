/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedAsMapValues;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class MapConstraints$ConstrainedMultimap$1AsMap
extends ForwardingMap {
    Set entrySet;
    Collection values;
    final /* synthetic */ Map val$asMapDelegate;
    final /* synthetic */ MapConstraints$ConstrainedMultimap this$0;

    MapConstraints$ConstrainedMultimap$1AsMap(MapConstraints$ConstrainedMultimap mapConstraints$ConstrainedMultimap, Map map) {
        this.this$0 = mapConstraints$ConstrainedMultimap;
        this.val$asMapDelegate = map;
    }

    @Override
    protected Map delegate() {
        return this.val$asMapDelegate;
    }

    @Override
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) return set;
        this.entrySet = set = MapConstraints.access$200(this.val$asMapDelegate.entrySet(), this.this$0.constraint);
        return set;
    }

    @Override
    public Collection get(Object object) {
        try {
            Collection collection = this.this$0.get(object);
            if (collection.isEmpty()) {
                return null;
            }
            Collection collection2 = collection;
            return collection2;
        }
        catch (ClassCastException var2_3) {
            return null;
        }
    }

    @Override
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) return collection;
        this.values = collection = new MapConstraints$ConstrainedAsMapValues(this.delegate().values(), this.entrySet());
        return collection;
    }

    @Override
    public boolean containsValue(Object object) {
        return this.values().contains(object);
    }
}

