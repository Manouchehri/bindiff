/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMap;
import com.google.common.collect.MapConstraints$InverseConstraint;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedBiMap
extends MapConstraints$ConstrainedMap
implements BiMap {
    volatile BiMap inverse;

    MapConstraints$ConstrainedBiMap(BiMap biMap, @Nullable BiMap biMap2, MapConstraint mapConstraint) {
        super(biMap, mapConstraint);
        this.inverse = biMap2;
    }

    @Override
    protected BiMap delegate() {
        return (BiMap)super.delegate();
    }

    @Override
    public Object forcePut(Object object, Object object2) {
        this.constraint.checkKeyValue(object, object2);
        return this.delegate().forcePut(object, object2);
    }

    @Override
    public BiMap inverse() {
        if (this.inverse != null) return this.inverse;
        this.inverse = new MapConstraints$ConstrainedBiMap(this.delegate().inverse(), this, new MapConstraints$InverseConstraint(this.constraint));
        return this.inverse;
    }

    @Override
    public Set values() {
        return this.delegate().values();
    }
}

