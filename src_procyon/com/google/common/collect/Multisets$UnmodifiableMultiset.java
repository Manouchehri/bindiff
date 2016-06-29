package com.google.common.collect;

import java.io.*;
import java.util.*;

class Multisets$UnmodifiableMultiset extends ForwardingMultiset implements Serializable
{
    final Multiset delegate;
    transient Set elementSet;
    transient Set entrySet;
    private static final long serialVersionUID = 0L;
    
    Multisets$UnmodifiableMultiset(final Multiset delegate) {
        this.delegate = delegate;
    }
    
    @Override
    protected Multiset delegate() {
        return this.delegate;
    }
    
    Set createElementSet() {
        return Collections.unmodifiableSet((Set<?>)this.delegate.elementSet());
    }
    
    @Override
    public Set elementSet() {
        final Set elementSet = this.elementSet;
        return (elementSet == null) ? (this.elementSet = this.createElementSet()) : elementSet;
    }
    
    @Override
    public Set entrySet() {
        final Set entrySet = this.entrySet;
        return (entrySet == null) ? (this.entrySet = Collections.unmodifiableSet((Set<?>)this.delegate.entrySet())) : entrySet;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }
    
    @Override
    public boolean add(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int add(final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int remove(final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int setCount(final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean setCount(final Object o, final int n, final int n2) {
        throw new UnsupportedOperationException();
    }
}
