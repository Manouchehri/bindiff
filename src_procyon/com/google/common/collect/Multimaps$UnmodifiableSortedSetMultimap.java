package com.google.common.collect;

import java.util.*;

class Multimaps$UnmodifiableSortedSetMultimap extends Multimaps$UnmodifiableSetMultimap implements SortedSetMultimap
{
    private static final long serialVersionUID = 0L;
    
    Multimaps$UnmodifiableSortedSetMultimap(final SortedSetMultimap sortedSetMultimap) {
        super(sortedSetMultimap);
    }
    
    @Override
    public SortedSetMultimap delegate() {
        return (SortedSetMultimap)super.delegate();
    }
    
    @Override
    public SortedSet get(final Object o) {
        return Collections.unmodifiableSortedSet((SortedSet<Object>)this.delegate().get(o));
    }
    
    @Override
    public SortedSet removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public SortedSet replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Comparator valueComparator() {
        return this.delegate().valueComparator();
    }
}
