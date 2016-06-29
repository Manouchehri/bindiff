package com.google.common.collect;

import java.util.*;

class Multimaps$UnmodifiableSetMultimap extends Multimaps$UnmodifiableMultimap implements SetMultimap
{
    private static final long serialVersionUID = 0L;
    
    Multimaps$UnmodifiableSetMultimap(final SetMultimap setMultimap) {
        super(setMultimap);
    }
    
    public SetMultimap delegate() {
        return (SetMultimap)super.delegate();
    }
    
    @Override
    public Set get(final Object o) {
        return Collections.unmodifiableSet((Set<?>)this.delegate().get(o));
    }
    
    @Override
    public Set entries() {
        return Maps.unmodifiableEntrySet(this.delegate().entries());
    }
    
    @Override
    public Set removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Set replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}
