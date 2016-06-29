package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class FilteredKeyMultimap$AddRejectingList extends ForwardingList
{
    final Object key;
    
    FilteredKeyMultimap$AddRejectingList(final Object key) {
        this.key = key;
    }
    
    @Override
    public boolean add(final Object o) {
        this.add(0, o);
        return true;
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        this.addAll(0, collection);
        return true;
    }
    
    @Override
    public void add(final int n, final Object o) {
        Preconditions.checkPositionIndex(n, 0);
        final String value = String.valueOf(this.key);
        throw new IllegalArgumentException(new StringBuilder(32 + String.valueOf(value).length()).append("Key does not satisfy predicate: ").append(value).toString());
    }
    
    @Override
    public boolean addAll(final int n, final Collection collection) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkPositionIndex(n, 0);
        final String value = String.valueOf(this.key);
        throw new IllegalArgumentException(new StringBuilder(32 + String.valueOf(value).length()).append("Key does not satisfy predicate: ").append(value).toString());
    }
    
    @Override
    protected List delegate() {
        return Collections.emptyList();
    }
}
