package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

public class ImmutableMultiset$Builder extends ImmutableCollection$Builder
{
    final Multiset contents;
    
    public ImmutableMultiset$Builder() {
        this(LinkedHashMultiset.create());
    }
    
    ImmutableMultiset$Builder(final Multiset contents) {
        this.contents = contents;
    }
    
    @Override
    public ImmutableMultiset$Builder add(final Object o) {
        this.contents.add(Preconditions.checkNotNull(o));
        return this;
    }
    
    public ImmutableMultiset$Builder addCopies(final Object o, final int n) {
        this.contents.add(Preconditions.checkNotNull(o), n);
        return this;
    }
    
    public ImmutableMultiset$Builder setCount(final Object o, final int n) {
        this.contents.setCount(Preconditions.checkNotNull(o), n);
        return this;
    }
    
    @Override
    public ImmutableMultiset$Builder add(final Object... array) {
        super.add(array);
        return this;
    }
    
    @Override
    public ImmutableMultiset$Builder addAll(final Iterable iterable) {
        if (iterable instanceof Multiset) {
            for (final Multiset$Entry multiset$Entry : Multisets.cast(iterable).entrySet()) {
                this.addCopies(multiset$Entry.getElement(), multiset$Entry.getCount());
            }
        }
        else {
            super.addAll(iterable);
        }
        return this;
    }
    
    @Override
    public ImmutableMultiset$Builder addAll(final Iterator iterator) {
        super.addAll(iterator);
        return this;
    }
    
    @Override
    public ImmutableMultiset build() {
        return ImmutableMultiset.copyOf(this.contents);
    }
}
