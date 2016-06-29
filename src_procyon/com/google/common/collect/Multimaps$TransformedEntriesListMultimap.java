package com.google.common.collect;

import java.util.*;

final class Multimaps$TransformedEntriesListMultimap extends Multimaps$TransformedEntriesMultimap implements ListMultimap
{
    Multimaps$TransformedEntriesListMultimap(final ListMultimap listMultimap, final Maps$EntryTransformer maps$EntryTransformer) {
        super(listMultimap, maps$EntryTransformer);
    }
    
    @Override
    List transform(final Object o, final Collection collection) {
        return Lists.transform((List)collection, Maps.asValueToValueFunction(this.transformer, o));
    }
    
    @Override
    public List get(final Object o) {
        return this.transform(o, this.fromMultimap.get(o));
    }
    
    @Override
    public List removeAll(final Object o) {
        return this.transform(o, this.fromMultimap.removeAll(o));
    }
    
    @Override
    public List replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}
