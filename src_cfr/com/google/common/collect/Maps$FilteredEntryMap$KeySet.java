/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$KeySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Maps$FilteredEntryMap$KeySet
extends Maps$KeySet {
    final /* synthetic */ Maps$FilteredEntryMap this$0;

    Maps$FilteredEntryMap$KeySet(Maps$FilteredEntryMap maps$FilteredEntryMap) {
        this.this$0 = maps$FilteredEntryMap;
        super(maps$FilteredEntryMap);
    }

    @Override
    public boolean remove(Object object) {
        if (!this.this$0.containsKey(object)) return false;
        this.this$0.unfiltered.remove(object);
        return true;
    }

    private boolean removeIf(Predicate predicate) {
        return Iterables.removeIf(this.this$0.unfiltered.entrySet(), Predicates.and(this.this$0.predicate, Maps.keyPredicateOnEntries(predicate)));
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

