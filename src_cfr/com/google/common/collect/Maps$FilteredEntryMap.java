/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$1;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet;
import com.google.common.collect.Maps$FilteredEntryMap$KeySet;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

class Maps$FilteredEntryMap
extends Maps$AbstractFilteredMap {
    final Set filteredEntrySet;

    Maps$FilteredEntryMap(Map map, Predicate predicate) {
        super(map, predicate);
        this.filteredEntrySet = Sets.filter(map.entrySet(), this.predicate);
    }

    @Override
    protected Set createEntrySet() {
        return new Maps$FilteredEntryMap$EntrySet(this, null);
    }

    @Override
    Set createKeySet() {
        return new Maps$FilteredEntryMap$KeySet(this);
    }
}

