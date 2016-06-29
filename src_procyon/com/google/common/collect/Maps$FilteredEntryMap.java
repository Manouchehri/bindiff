package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class Maps$FilteredEntryMap extends Maps$AbstractFilteredMap
{
    final Set filteredEntrySet;
    
    Maps$FilteredEntryMap(final Map map, final Predicate predicate) {
        super(map, predicate);
        this.filteredEntrySet = Sets.filter(map.entrySet(), this.predicate);
    }
    
    protected Set createEntrySet() {
        return new Maps$FilteredEntryMap$EntrySet(this, null);
    }
    
    @Override
    Set createKeySet() {
        return new Maps$FilteredEntryMap$KeySet(this);
    }
}
