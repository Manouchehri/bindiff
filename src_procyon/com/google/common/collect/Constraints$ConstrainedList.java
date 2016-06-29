package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
class Constraints$ConstrainedList extends ForwardingList
{
    final List delegate;
    final Constraint constraint;
    
    Constraints$ConstrainedList(final List list, final Constraint constraint) {
        this.delegate = (List)Preconditions.checkNotNull(list);
        this.constraint = (Constraint)Preconditions.checkNotNull(constraint);
    }
    
    @Override
    protected List delegate() {
        return this.delegate;
    }
    
    @Override
    public boolean add(final Object o) {
        this.constraint.checkElement(o);
        return this.delegate.add(o);
    }
    
    @Override
    public void add(final int n, final Object o) {
        this.constraint.checkElement(o);
        this.delegate.add(n, o);
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        return this.delegate.addAll(checkElements(collection, this.constraint));
    }
    
    @Override
    public boolean addAll(final int n, final Collection collection) {
        return this.delegate.addAll(n, checkElements(collection, this.constraint));
    }
    
    @Override
    public ListIterator listIterator() {
        return constrainedListIterator(this.delegate.listIterator(), this.constraint);
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        return constrainedListIterator(this.delegate.listIterator(n), this.constraint);
    }
    
    @Override
    public Object set(final int n, final Object o) {
        this.constraint.checkElement(o);
        return this.delegate.set(n, o);
    }
    
    @Override
    public List subList(final int n, final int n2) {
        return Constraints.constrainedList(this.delegate.subList(n, n2), this.constraint);
    }
}
