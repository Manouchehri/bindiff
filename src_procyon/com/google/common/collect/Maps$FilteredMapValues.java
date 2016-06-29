package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Maps$FilteredMapValues extends Maps$Values
{
    Map unfiltered;
    Predicate predicate;
    
    Maps$FilteredMapValues(final Map map, final Map unfiltered, final Predicate predicate) {
        super(map);
        this.unfiltered = unfiltered;
        this.predicate = predicate;
    }
    
    @Override
    public boolean remove(final Object o) {
        return Iterables.removeFirstMatching(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(o)))) != null;
    }
    
    private boolean removeIf(final Predicate predicate) {
        return Iterables.removeIf(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(predicate)));
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.removeIf(Predicates.in(collection));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.removeIf(Predicates.not(Predicates.in(collection)));
    }
    
    @Override
    public Object[] toArray() {
        return Lists.newArrayList(this.iterator()).toArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return Lists.newArrayList(this.iterator()).toArray(array);
    }
}
