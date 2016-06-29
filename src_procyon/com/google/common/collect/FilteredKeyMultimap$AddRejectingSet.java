package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class FilteredKeyMultimap$AddRejectingSet extends ForwardingSet
{
    final Object key;
    
    FilteredKeyMultimap$AddRejectingSet(final Object key) {
        this.key = key;
    }
    
    @Override
    public boolean add(final Object o) {
        final String value = String.valueOf(this.key);
        throw new IllegalArgumentException(new StringBuilder(32 + String.valueOf(value).length()).append("Key does not satisfy predicate: ").append(value).toString());
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        Preconditions.checkNotNull(collection);
        final String value = String.valueOf(this.key);
        throw new IllegalArgumentException(new StringBuilder(32 + String.valueOf(value).length()).append("Key does not satisfy predicate: ").append(value).toString());
    }
    
    @Override
    protected Set delegate() {
        return Collections.emptySet();
    }
}
