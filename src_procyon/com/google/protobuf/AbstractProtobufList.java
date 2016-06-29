package com.google.protobuf;

import java.util.*;

abstract class AbstractProtobufList extends AbstractList implements Internal$ProtobufList
{
    private boolean isMutable;
    
    AbstractProtobufList() {
        this.isMutable = true;
    }
    
    public boolean add(final Object o) {
        this.ensureIsMutable();
        return super.add(o);
    }
    
    public void add(final int n, final Object o) {
        this.ensureIsMutable();
        super.add(n, o);
    }
    
    public boolean addAll(final Collection collection) {
        this.ensureIsMutable();
        return super.addAll(collection);
    }
    
    public boolean addAll(final int n, final Collection collection) {
        this.ensureIsMutable();
        return super.addAll(n, collection);
    }
    
    public void clear() {
        this.ensureIsMutable();
        super.clear();
    }
    
    public boolean isModifiable() {
        return this.isMutable;
    }
    
    public final void makeImmutable() {
        this.isMutable = false;
    }
    
    public Object remove(final int n) {
        this.ensureIsMutable();
        return super.remove(n);
    }
    
    public boolean remove(final Object o) {
        this.ensureIsMutable();
        return super.remove(o);
    }
    
    public boolean removeAll(final Collection collection) {
        this.ensureIsMutable();
        return super.removeAll(collection);
    }
    
    public boolean retainAll(final Collection collection) {
        this.ensureIsMutable();
        return super.retainAll(collection);
    }
    
    public Object set(final int n, final Object o) {
        this.ensureIsMutable();
        return super.set(n, o);
    }
    
    protected void ensureIsMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }
}
