/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Set;

class MapConstraints$ConstrainedSetMultimap
extends MapConstraints$ConstrainedMultimap
implements SetMultimap {
    MapConstraints$ConstrainedSetMultimap(SetMultimap setMultimap, MapConstraint mapConstraint) {
        super(setMultimap, mapConstraint);
    }

    @Override
    public Set get(Object object) {
        return (Set)super.get(object);
    }

    @Override
    public Set entries() {
        return (Set)super.entries();
    }

    @Override
    public Set removeAll(Object object) {
        return (Set)super.removeAll(object);
    }

    @Override
    public Set replaceValues(Object object, Iterable iterable) {
        return (Set)super.replaceValues(object, iterable);
    }
}

