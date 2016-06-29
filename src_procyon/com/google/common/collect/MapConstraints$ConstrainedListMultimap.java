package com.google.common.collect;

import java.util.*;

class MapConstraints$ConstrainedListMultimap extends MapConstraints$ConstrainedMultimap implements ListMultimap
{
    MapConstraints$ConstrainedListMultimap(final ListMultimap listMultimap, final MapConstraint mapConstraint) {
        super(listMultimap, mapConstraint);
    }
    
    @Override
    public List get(final Object o) {
        return (List)super.get(o);
    }
    
    @Override
    public List removeAll(final Object o) {
        return (List)super.removeAll(o);
    }
    
    @Override
    public List replaceValues(final Object o, final Iterable iterable) {
        return (List)super.replaceValues(o, iterable);
    }
}
