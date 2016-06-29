package com.google.common.collect;

import java.util.*;

class Constraints$ConstrainedListIterator extends ForwardingListIterator
{
    private final ListIterator delegate;
    private final Constraint constraint;
    
    public Constraints$ConstrainedListIterator(final ListIterator delegate, final Constraint constraint) {
        this.delegate = delegate;
        this.constraint = constraint;
    }
    
    @Override
    protected ListIterator delegate() {
        return this.delegate;
    }
    
    @Override
    public void add(final Object o) {
        this.constraint.checkElement(o);
        this.delegate.add(o);
    }
    
    @Override
    public void set(final Object o) {
        this.constraint.checkElement(o);
        this.delegate.set(o);
    }
}
