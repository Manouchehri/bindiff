package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
class FilteredEntryMultimap extends AbstractMultimap implements FilteredMultimap
{
    final Multimap unfiltered;
    final Predicate predicate;
    
    FilteredEntryMultimap(final Multimap multimap, final Predicate predicate) {
        this.unfiltered = (Multimap)Preconditions.checkNotNull(multimap);
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }
    
    @Override
    public Multimap unfiltered() {
        return this.unfiltered;
    }
    
    @Override
    public Predicate entryPredicate() {
        return this.predicate;
    }
    
    @Override
    public int size() {
        return this.entries().size();
    }
    
    private boolean satisfies(final Object o, final Object o2) {
        return this.predicate.apply(Maps.immutableEntry(o, o2));
    }
    
    static Collection filterCollection(final Collection collection, final Predicate predicate) {
        if (collection instanceof Set) {
            return Sets.filter((Set)collection, predicate);
        }
        return Collections2.filter(collection, predicate);
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.asMap().get(o) != null;
    }
    
    @Override
    public Collection removeAll(@Nullable final Object o) {
        return (Collection)MoreObjects.firstNonNull(this.asMap().remove(o), this.unmodifiableEmptyCollection());
    }
    
    Collection unmodifiableEmptyCollection() {
        return (this.unfiltered instanceof SetMultimap) ? Collections.emptySet() : Collections.emptyList();
    }
    
    @Override
    public void clear() {
        this.entries().clear();
    }
    
    @Override
    public Collection get(final Object o) {
        return filterCollection(this.unfiltered.get(o), new FilteredEntryMultimap$ValuePredicate(this, o));
    }
    
    @Override
    Collection createEntries() {
        return filterCollection(this.unfiltered.entries(), this.predicate);
    }
    
    @Override
    Collection createValues() {
        return new FilteredMultimapValues(this);
    }
    
    @Override
    Iterator entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }
    
    @Override
    Map createAsMap() {
        return new FilteredEntryMultimap$AsMap(this);
    }
    
    @Override
    public Set keySet() {
        return this.asMap().keySet();
    }
    
    boolean removeEntriesIf(final Predicate predicate) {
        final Iterator<Map.Entry<Object, V>> iterator = this.unfiltered.asMap().entrySet().iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final Map.Entry<Object, V> entry = iterator.next();
            final Object key = entry.getKey();
            final Collection filterCollection = filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap$ValuePredicate(this, key));
            if (!filterCollection.isEmpty() && predicate.apply(Maps.immutableEntry(key, filterCollection))) {
                if (filterCollection.size() == ((Collection)entry.getValue()).size()) {
                    iterator.remove();
                }
                else {
                    filterCollection.clear();
                }
                b = true;
            }
        }
        return b;
    }
    
    @Override
    Multiset createKeys() {
        return new FilteredEntryMultimap$Keys(this);
    }
}
