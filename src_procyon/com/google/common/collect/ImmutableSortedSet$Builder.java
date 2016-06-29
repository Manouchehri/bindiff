package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

public final class ImmutableSortedSet$Builder extends ImmutableSet$Builder
{
    private final Comparator comparator;
    
    public ImmutableSortedSet$Builder(final Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }
    
    @Override
    public ImmutableSortedSet$Builder add(final Object o) {
        super.add(o);
        return this;
    }
    
    @Override
    public ImmutableSortedSet$Builder add(final Object... array) {
        super.add(array);
        return this;
    }
    
    @Override
    public ImmutableSortedSet$Builder addAll(final Iterable iterable) {
        super.addAll(iterable);
        return this;
    }
    
    @Override
    public ImmutableSortedSet$Builder addAll(final Iterator iterator) {
        super.addAll(iterator);
        return this;
    }
    
    @Override
    public ImmutableSortedSet build() {
        final ImmutableSortedSet construct = ImmutableSortedSet.construct(this.comparator, this.size, (Object[])this.contents);
        this.size = construct.size();
        return construct;
    }
}
