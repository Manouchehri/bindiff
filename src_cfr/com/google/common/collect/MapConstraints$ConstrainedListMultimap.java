/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;

class MapConstraints$ConstrainedListMultimap
extends MapConstraints$ConstrainedMultimap
implements ListMultimap {
    MapConstraints$ConstrainedListMultimap(ListMultimap listMultimap, MapConstraint mapConstraint) {
        super(listMultimap, mapConstraint);
    }

    @Override
    public List get(Object object) {
        return (List)super.get(object);
    }

    @Override
    public List removeAll(Object object) {
        return (List)super.removeAll(object);
    }

    @Override
    public List replaceValues(Object object, Iterable iterable) {
        return (List)super.replaceValues(object, iterable);
    }
}

