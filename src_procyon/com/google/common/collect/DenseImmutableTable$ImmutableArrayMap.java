package com.google.common.collect;

import javax.annotation.*;

abstract class DenseImmutableTable$ImmutableArrayMap extends ImmutableMap$IteratorBasedImmutableMap
{
    private final int size;
    
    DenseImmutableTable$ImmutableArrayMap(final int size) {
        this.size = size;
    }
    
    abstract ImmutableMap keyToIndex();
    
    private boolean isFull() {
        return this.size == this.keyToIndex().size();
    }
    
    Object getKey(final int n) {
        return this.keyToIndex().keySet().asList().get(n);
    }
    
    @Nullable
    abstract Object getValue(final int p0);
    
    @Override
    ImmutableSet createKeySet() {
        return this.isFull() ? this.keyToIndex().keySet() : super.createKeySet();
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        final Integer n = (Integer)this.keyToIndex().get(o);
        return (n == null) ? null : this.getValue(n);
    }
    
    @Override
    UnmodifiableIterator entryIterator() {
        return new DenseImmutableTable$ImmutableArrayMap$1(this);
    }
}
