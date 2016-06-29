package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

class Constraints$ConstrainedSortedSet extends ForwardingSortedSet
{
    final SortedSet delegate;
    final Constraint constraint;
    
    Constraints$ConstrainedSortedSet(final SortedSet set, final Constraint constraint) {
        this.delegate = (SortedSet)Preconditions.checkNotNull(set);
        this.constraint = (Constraint)Preconditions.checkNotNull(constraint);
    }
    
    @Override
    protected SortedSet delegate() {
        return this.delegate;
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return Constraints.constrainedSortedSet(this.delegate.headSet(o), this.constraint);
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return Constraints.constrainedSortedSet(this.delegate.subSet(o, o2), this.constraint);
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return Constraints.constrainedSortedSet(this.delegate.tailSet(o), this.constraint);
    }
    
    @Override
    public boolean add(final Object o) {
        this.constraint.checkElement(o);
        return this.delegate.add(o);
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        return this.delegate.addAll(checkElements(collection, this.constraint));
    }
}
