package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Multimaps$TransformedEntriesMultimap extends AbstractMultimap
{
    final Multimap fromMultimap;
    final Maps$EntryTransformer transformer;
    
    Multimaps$TransformedEntriesMultimap(final Multimap multimap, final Maps$EntryTransformer maps$EntryTransformer) {
        this.fromMultimap = (Multimap)Preconditions.checkNotNull(multimap);
        this.transformer = (Maps$EntryTransformer)Preconditions.checkNotNull(maps$EntryTransformer);
    }
    
    Collection transform(final Object o, final Collection collection) {
        final Function valueToValueFunction = Maps.asValueToValueFunction(this.transformer, o);
        if (collection instanceof List) {
            return Lists.transform((List)collection, valueToValueFunction);
        }
        return Collections2.transform(collection, valueToValueFunction);
    }
    
    @Override
    Map createAsMap() {
        return Maps.transformEntries(this.fromMultimap.asMap(), new Multimaps$TransformedEntriesMultimap$1(this));
    }
    
    @Override
    public void clear() {
        this.fromMultimap.clear();
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.fromMultimap.containsKey(o);
    }
    
    @Override
    Iterator entryIterator() {
        return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
    }
    
    @Override
    public Collection get(final Object o) {
        return this.transform(o, this.fromMultimap.get(o));
    }
    
    @Override
    public boolean isEmpty() {
        return this.fromMultimap.isEmpty();
    }
    
    @Override
    public Set keySet() {
        return this.fromMultimap.keySet();
    }
    
    @Override
    public Multiset keys() {
        return this.fromMultimap.keys();
    }
    
    @Override
    public boolean put(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean putAll(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean putAll(final Multimap multimap) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean remove(final Object o, final Object o2) {
        return this.get(o).remove(o2);
    }
    
    @Override
    public Collection removeAll(final Object o) {
        return this.transform(o, this.fromMultimap.removeAll(o));
    }
    
    @Override
    public Collection replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int size() {
        return this.fromMultimap.size();
    }
    
    @Override
    Collection createValues() {
        return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
    }
}
