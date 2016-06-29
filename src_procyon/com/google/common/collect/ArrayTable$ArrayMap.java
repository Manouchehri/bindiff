package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

abstract class ArrayTable$ArrayMap extends Maps$IteratorBasedAbstractMap
{
    private final ImmutableMap keyIndex;
    
    private ArrayTable$ArrayMap(final ImmutableMap keyIndex) {
        this.keyIndex = keyIndex;
    }
    
    @Override
    public Set keySet() {
        return this.keyIndex.keySet();
    }
    
    Object getKey(final int n) {
        return this.keyIndex.keySet().asList().get(n);
    }
    
    abstract String getKeyRole();
    
    @Nullable
    abstract Object getValue(final int p0);
    
    @Nullable
    abstract Object setValue(final int p0, final Object p1);
    
    @Override
    public int size() {
        return this.keyIndex.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.keyIndex.isEmpty();
    }
    
    @Override
    Iterator entryIterator() {
        return new ArrayTable$ArrayMap$1(this, this.size());
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.keyIndex.containsKey(o);
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        final Integer n = (Integer)this.keyIndex.get(o);
        if (n == null) {
            return null;
        }
        return this.getValue(n);
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        final Integer n = (Integer)this.keyIndex.get(o);
        if (n == null) {
            final String keyRole = this.getKeyRole();
            final String value = String.valueOf(o);
            final String value2 = String.valueOf(this.keyIndex.keySet());
            throw new IllegalArgumentException(new StringBuilder(9 + String.valueOf(keyRole).length() + String.valueOf(value).length() + String.valueOf(value2).length()).append(keyRole).append(" ").append(value).append(" not in ").append(value2).toString());
        }
        return this.setValue(n, o2);
    }
    
    @Override
    public Object remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
