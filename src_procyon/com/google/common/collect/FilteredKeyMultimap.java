package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
class FilteredKeyMultimap extends AbstractMultimap implements FilteredMultimap
{
    final Multimap unfiltered;
    final Predicate keyPredicate;
    
    FilteredKeyMultimap(final Multimap multimap, final Predicate predicate) {
        this.unfiltered = (Multimap)Preconditions.checkNotNull(multimap);
        this.keyPredicate = (Predicate)Preconditions.checkNotNull(predicate);
    }
    
    @Override
    public Multimap unfiltered() {
        return this.unfiltered;
    }
    
    @Override
    public Predicate entryPredicate() {
        return Maps.keyPredicateOnEntries(this.keyPredicate);
    }
    
    @Override
    public int size() {
        int n = 0;
        final Iterator<Collection> iterator = this.asMap().values().iterator();
        while (iterator.hasNext()) {
            n += iterator.next().size();
        }
        return n;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.unfiltered.containsKey(o) && this.keyPredicate.apply(o);
    }
    
    @Override
    public Collection removeAll(final Object o) {
        return this.containsKey(o) ? this.unfiltered.removeAll(o) : this.unmodifiableEmptyCollection();
    }
    
    Collection unmodifiableEmptyCollection() {
        if (this.unfiltered instanceof SetMultimap) {
            return ImmutableSet.of();
        }
        return ImmutableList.of();
    }
    
    @Override
    public void clear() {
        this.keySet().clear();
    }
    
    @Override
    Set createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }
    
    @Override
    public Collection get(final Object o) {
        if (this.keyPredicate.apply(o)) {
            return this.unfiltered.get(o);
        }
        if (this.unfiltered instanceof SetMultimap) {
            return new FilteredKeyMultimap$AddRejectingSet(o);
        }
        return new FilteredKeyMultimap$AddRejectingList(o);
    }
    
    @Override
    Iterator entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }
    
    @Override
    Collection createEntries() {
        return new FilteredKeyMultimap$Entries(this);
    }
    
    @Override
    Collection createValues() {
        return new FilteredMultimapValues(this);
    }
    
    @Override
    Map createAsMap() {
        return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
    }
    
    @Override
    Multiset createKeys() {
        return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
    }
}
