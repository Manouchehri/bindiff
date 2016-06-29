package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Sets$FilteredSortedSet extends Sets$FilteredSet implements SortedSet
{
    Sets$FilteredSortedSet(final SortedSet set, final Predicate predicate) {
        super(set, predicate);
    }
    
    @Override
    public Comparator comparator() {
        return ((SortedSet)this.unfiltered).comparator();
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).subSet(o, o2), this.predicate);
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).headSet(o), this.predicate);
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return new Sets$FilteredSortedSet(((SortedSet)this.unfiltered).tailSet(o), this.predicate);
    }
    
    @Override
    public Object first() {
        return this.iterator().next();
    }
    
    @Override
    public Object last() {
        SortedSet<Object> headSet = (SortedSet<Object>)this.unfiltered;
        Object last;
        while (true) {
            last = headSet.last();
            if (this.predicate.apply(last)) {
                break;
            }
            headSet = headSet.headSet(last);
        }
        return last;
    }
}
