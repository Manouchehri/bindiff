package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

class Constraints$ConstrainedSet extends ForwardingSet
{
    private final Set delegate;
    private final Constraint constraint;
    
    public Constraints$ConstrainedSet(final Set set, final Constraint constraint) {
        this.delegate = (Set)Preconditions.checkNotNull(set);
        this.constraint = (Constraint)Preconditions.checkNotNull(constraint);
    }
    
    @Override
    protected Set delegate() {
        return this.delegate;
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
