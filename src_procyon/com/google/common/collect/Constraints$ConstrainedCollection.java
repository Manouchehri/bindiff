package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

class Constraints$ConstrainedCollection extends ForwardingCollection
{
    private final Collection delegate;
    private final Constraint constraint;
    
    public Constraints$ConstrainedCollection(final Collection collection, final Constraint constraint) {
        this.delegate = (Collection)Preconditions.checkNotNull(collection);
        this.constraint = (Constraint)Preconditions.checkNotNull(constraint);
    }
    
    @Override
    protected Collection delegate() {
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
