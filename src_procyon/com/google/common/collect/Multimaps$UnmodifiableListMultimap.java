package com.google.common.collect;

import java.util.*;

class Multimaps$UnmodifiableListMultimap extends Multimaps$UnmodifiableMultimap implements ListMultimap
{
    private static final long serialVersionUID = 0L;
    
    Multimaps$UnmodifiableListMultimap(final ListMultimap listMultimap) {
        super(listMultimap);
    }
    
    public ListMultimap delegate() {
        return (ListMultimap)super.delegate();
    }
    
    @Override
    public List get(final Object o) {
        return Collections.unmodifiableList((List<?>)this.delegate().get(o));
    }
    
    @Override
    public List removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public List replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}
