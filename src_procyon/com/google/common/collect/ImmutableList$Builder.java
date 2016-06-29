package com.google.common.collect;

import java.util.*;

public final class ImmutableList$Builder extends ImmutableCollection$ArrayBasedBuilder
{
    public ImmutableList$Builder() {
        this(4);
    }
    
    ImmutableList$Builder(final int n) {
        super(n);
    }
    
    @Override
    public ImmutableList$Builder add(final Object o) {
        super.add(o);
        return this;
    }
    
    @Override
    public ImmutableList$Builder addAll(final Iterable iterable) {
        super.addAll(iterable);
        return this;
    }
    
    @Override
    public ImmutableList$Builder add(final Object... array) {
        super.add(array);
        return this;
    }
    
    @Override
    public ImmutableList$Builder addAll(final Iterator iterator) {
        super.addAll(iterator);
        return this;
    }
    
    @Override
    public ImmutableList build() {
        return ImmutableList.asImmutableList(this.contents, this.size);
    }
}
