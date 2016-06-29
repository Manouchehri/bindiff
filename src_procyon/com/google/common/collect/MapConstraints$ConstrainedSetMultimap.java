package com.google.common.collect;

import java.util.*;

class MapConstraints$ConstrainedSetMultimap extends MapConstraints$ConstrainedMultimap implements SetMultimap
{
    MapConstraints$ConstrainedSetMultimap(final SetMultimap setMultimap, final MapConstraint mapConstraint) {
        super(setMultimap, mapConstraint);
    }
    
    @Override
    public Set get(final Object o) {
        return (Set)super.get(o);
    }
    
    @Override
    public Set entries() {
        return (Set)super.entries();
    }
    
    @Override
    public Set removeAll(final Object o) {
        return (Set)super.removeAll(o);
    }
    
    @Override
    public Set replaceValues(final Object o, final Iterable iterable) {
        return (Set)super.replaceValues(o, iterable);
    }
}
