package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class MapConstraints$ConstrainedBiMap extends MapConstraints$ConstrainedMap implements BiMap
{
    volatile BiMap inverse;
    
    MapConstraints$ConstrainedBiMap(final BiMap biMap, @Nullable final BiMap inverse, final MapConstraint mapConstraint) {
        super(biMap, mapConstraint);
        this.inverse = inverse;
    }
    
    @Override
    protected BiMap delegate() {
        return (BiMap)super.delegate();
    }
    
    @Override
    public Object forcePut(final Object o, final Object o2) {
        this.constraint.checkKeyValue(o, o2);
        return this.delegate().forcePut(o, o2);
    }
    
    @Override
    public BiMap inverse() {
        if (this.inverse == null) {
            this.inverse = new MapConstraints$ConstrainedBiMap(this.delegate().inverse(), this, new MapConstraints$InverseConstraint(this.constraint));
        }
        return this.inverse;
    }
    
    @Override
    public Set values() {
        return this.delegate().values();
    }
}
