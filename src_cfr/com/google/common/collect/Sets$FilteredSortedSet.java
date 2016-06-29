/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets$FilteredSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

class Sets$FilteredSortedSet
extends Sets$FilteredSet
implements SortedSet {
    Sets$FilteredSortedSet(SortedSet sortedSet, Predicate predicate) {
        super(sortedSet, predicate);
    }

    public Comparator comparator() {
        return ((SortedSet)this.unfiltered).comparator();
    }

    public SortedSet subSet(Object object, Object object2) {
        return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).subSet(object, object2), this.predicate);
    }

    public SortedSet headSet(Object object) {
        return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).headSet(object), this.predicate);
    }

    public SortedSet tailSet(Object object) {
        return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).tailSet(object), this.predicate);
    }

    public Object first() {
        return this.iterator().next();
    }

    public Object last() {
        SortedSet sortedSet = (SortedSet)this.unfiltered;
        Object e2;
        while (!this.predicate.apply(e2 = sortedSet.last())) {
            sortedSet = sortedSet.headSet(e2);
        }
        return e2;
    }
}

