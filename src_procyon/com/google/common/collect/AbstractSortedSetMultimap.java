package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
abstract class AbstractSortedSetMultimap extends AbstractSetMultimap implements SortedSetMultimap
{
    private static final long serialVersionUID = 430848587173315748L;
    
    protected AbstractSortedSetMultimap(final Map map) {
        super(map);
    }
    
    @Override
    abstract SortedSet createCollection();
    
    @Override
    SortedSet createUnmodifiableEmptyCollection() {
        if (this.valueComparator() == null) {
            return Collections.unmodifiableSortedSet((SortedSet<Object>)this.createCollection());
        }
        return ImmutableSortedSet.emptySet(this.valueComparator());
    }
    
    @Override
    public SortedSet get(@Nullable final Object o) {
        return (SortedSet)super.get(o);
    }
    
    @Override
    public SortedSet removeAll(@Nullable final Object o) {
        return (SortedSet)super.removeAll(o);
    }
    
    @Override
    public SortedSet replaceValues(@Nullable final Object o, final Iterable iterable) {
        return (SortedSet)super.replaceValues(o, iterable);
    }
    
    @Override
    public Map asMap() {
        return super.asMap();
    }
    
    @Override
    public Collection values() {
        return super.values();
    }
}
