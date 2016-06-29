package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

final class Maps$FilteredEntryBiMap extends Maps$FilteredEntryMap implements BiMap
{
    private final BiMap inverse;
    
    private static Predicate inversePredicate(final Predicate predicate) {
        return new Maps$FilteredEntryBiMap$1(predicate);
    }
    
    Maps$FilteredEntryBiMap(final BiMap biMap, final Predicate predicate) {
        super(biMap, predicate);
        this.inverse = new Maps$FilteredEntryBiMap(biMap.inverse(), inversePredicate(predicate), this);
    }
    
    private Maps$FilteredEntryBiMap(final BiMap biMap, final Predicate predicate, final BiMap inverse) {
        super(biMap, predicate);
        this.inverse = inverse;
    }
    
    BiMap unfiltered() {
        return (BiMap)this.unfiltered;
    }
    
    @Override
    public Object forcePut(@Nullable final Object o, @Nullable final Object o2) {
        Preconditions.checkArgument(this.apply(o, o2));
        return this.unfiltered().forcePut(o, o2);
    }
    
    @Override
    public BiMap inverse() {
        return this.inverse;
    }
    
    @Override
    public Set values() {
        return this.inverse.keySet();
    }
}
