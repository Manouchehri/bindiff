/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class Maps$FilteredMapValues
extends Maps$Values {
    Map unfiltered;
    Predicate predicate;

    Maps$FilteredMapValues(Map map, Map map2, Predicate predicate) {
        super(map);
        this.unfiltered = map2;
        this.predicate = predicate;
    }

    @Override
    public boolean remove(Object object) {
        if (Iterables.removeFirstMatching(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(object)))) == null) return false;
        return true;
    }

    private boolean removeIf(Predicate predicate) {
        return Iterables.removeIf(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(predicate)));
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.removeIf(Predicates.in(collection));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.removeIf(Predicates.not(Predicates.in(collection)));
    }

    @Override
    public Object[] toArray() {
        return Lists.newArrayList(this.iterator()).toArray();
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return Lists.newArrayList(this.iterator()).toArray(arrobject);
    }
}

