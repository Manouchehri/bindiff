package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Maps$FilteredKeyMap extends Maps$AbstractFilteredMap
{
    Predicate keyPredicate;
    
    Maps$FilteredKeyMap(final Map map, final Predicate keyPredicate, final Predicate predicate) {
        super(map, predicate);
        this.keyPredicate = keyPredicate;
    }
    
    protected Set createEntrySet() {
        return Sets.filter(this.unfiltered.entrySet(), this.predicate);
    }
    
    @Override
    Set createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.unfiltered.containsKey(o) && this.keyPredicate.apply(o);
    }
}
