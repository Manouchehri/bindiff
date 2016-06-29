package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

public class ImmutableSortedMultiset$Builder extends ImmutableMultiset$Builder
{
    public ImmutableSortedMultiset$Builder(final Comparator comparator) {
        super(TreeMultiset.create((Comparator)Preconditions.checkNotNull(comparator)));
    }
    
    @Override
    public ImmutableSortedMultiset$Builder add(final Object o) {
        super.add(o);
        return this;
    }
    
    @Override
    public ImmutableSortedMultiset$Builder addCopies(final Object o, final int n) {
        super.addCopies(o, n);
        return this;
    }
    
    @Override
    public ImmutableSortedMultiset$Builder setCount(final Object o, final int n) {
        super.setCount(o, n);
        return this;
    }
    
    @Override
    public ImmutableSortedMultiset$Builder add(final Object... array) {
        super.add(array);
        return this;
    }
    
    @Override
    public ImmutableSortedMultiset$Builder addAll(final Iterable iterable) {
        super.addAll(iterable);
        return this;
    }
    
    @Override
    public ImmutableSortedMultiset$Builder addAll(final Iterator iterator) {
        super.addAll(iterator);
        return this;
    }
    
    @Override
    public ImmutableSortedMultiset build() {
        return ImmutableSortedMultiset.copyOfSorted((SortedMultiset)this.contents);
    }
}
