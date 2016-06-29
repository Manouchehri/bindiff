package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

final class Sets$CartesianSet extends ForwardingCollection implements Set
{
    private final transient ImmutableList axes;
    private final transient CartesianList delegate;
    
    static Set create(final List list) {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(list.size());
        final Iterator<Set> iterator = list.iterator();
        while (iterator.hasNext()) {
            final ImmutableSet copy = ImmutableSet.copyOf(iterator.next());
            if (copy.isEmpty()) {
                return ImmutableSet.of();
            }
            immutableList$Builder.add(copy);
        }
        final ImmutableList build = immutableList$Builder.build();
        return new Sets$CartesianSet(build, new CartesianList(new Sets$CartesianSet$1(build)));
    }
    
    private Sets$CartesianSet(final ImmutableList axes, final CartesianList delegate) {
        this.axes = axes;
        this.delegate = delegate;
    }
    
    @Override
    protected Collection delegate() {
        return this.delegate;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Sets$CartesianSet) {
            return this.axes.equals(((Sets$CartesianSet)o).axes);
        }
        return super.equals(o);
    }
    
    @Override
    public int hashCode() {
        int n = this.size() - 1;
        for (int i = 0; i < this.axes.size(); ++i) {
            n = ~(~(n * 31));
        }
        int n2 = 1;
        for (final Set set : this.axes) {
            n2 = ~(~(31 * n2 + this.size() / set.size() * set.hashCode()));
        }
        return ~(~(n2 + n));
    }
}
