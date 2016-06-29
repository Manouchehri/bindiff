package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class FilteredEntryMultimap$AsMap extends Maps$ViewCachingAbstractMap
{
    final /* synthetic */ FilteredEntryMultimap this$0;
    
    FilteredEntryMultimap$AsMap(final FilteredEntryMultimap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.get(o) != null;
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
    
    @Override
    public Collection get(@Nullable final Object o) {
        final Collection collection = this.this$0.unfiltered.asMap().get(o);
        if (collection == null) {
            return null;
        }
        final Collection filterCollection = FilteredEntryMultimap.filterCollection(collection, new FilteredEntryMultimap$ValuePredicate(this.this$0, o));
        return filterCollection.isEmpty() ? null : filterCollection;
    }
    
    @Override
    public Collection remove(@Nullable final Object o) {
        final Collection<Object> collection = this.this$0.unfiltered.asMap().get(o);
        if (collection == null) {
            return null;
        }
        final ArrayList arrayList = Lists.newArrayList();
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            if (this.this$0.satisfies(o, next)) {
                iterator.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (this.this$0.unfiltered instanceof SetMultimap) {
            return Collections.unmodifiableSet((Set<?>)Sets.newLinkedHashSet(arrayList));
        }
        return Collections.unmodifiableList((List<?>)arrayList);
    }
    
    @Override
    Set createKeySet() {
        return new FilteredEntryMultimap$AsMap$1KeySetImpl(this);
    }
    
    @Override
    Set createEntrySet() {
        return new FilteredEntryMultimap$AsMap$1EntrySetImpl(this);
    }
    
    @Override
    Collection createValues() {
        return new FilteredEntryMultimap$AsMap$1ValuesImpl(this);
    }
}
