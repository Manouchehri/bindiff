package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

public class ImmutableSet$Builder extends ImmutableCollection$ArrayBasedBuilder
{
    public ImmutableSet$Builder() {
        this(4);
    }
    
    ImmutableSet$Builder(final int n) {
        super(n);
    }
    
    @Override
    public ImmutableSet$Builder add(final Object o) {
        super.add(o);
        return this;
    }
    
    @Override
    public ImmutableSet$Builder add(final Object... array) {
        super.add(array);
        return this;
    }
    
    @Override
    public ImmutableSet$Builder addAll(final Iterable iterable) {
        super.addAll(iterable);
        return this;
    }
    
    @Override
    public ImmutableSet$Builder addAll(final Iterator iterator) {
        super.addAll(iterator);
        return this;
    }
    
    @Override
    public ImmutableSet build() {
        final ImmutableSet access$000 = construct(this.size, this.contents);
        this.size = access$000.size();
        return access$000;
    }
}
