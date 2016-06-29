/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

class Maps$FilteredKeyMap
extends Maps$AbstractFilteredMap {
    Predicate keyPredicate;

    Maps$FilteredKeyMap(Map map, Predicate predicate, Predicate predicate2) {
        super(map, predicate2);
        this.keyPredicate = predicate;
    }

    @Override
    protected Set createEntrySet() {
        return Sets.filter(this.unfiltered.entrySet(), this.predicate);
    }

    @Override
    Set createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }

    @Override
    public boolean containsKey(Object object) {
        if (!this.unfiltered.containsKey(object)) return false;
        if (!this.keyPredicate.apply(object)) return false;
        return true;
    }
}

