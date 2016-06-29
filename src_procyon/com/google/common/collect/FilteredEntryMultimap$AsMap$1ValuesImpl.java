package com.google.common.collect;

import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;

class FilteredEntryMultimap$AsMap$1ValuesImpl extends Maps$Values
{
    final /* synthetic */ FilteredEntryMultimap$AsMap this$1;
    
    FilteredEntryMultimap$AsMap$1ValuesImpl(final FilteredEntryMultimap$AsMap this$1) {
        this.this$1 = this$1;
        super(this$1);
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        if (o instanceof Collection) {
            final Collection collection = (Collection)o;
            final Iterator<Map.Entry<Object, V>> iterator = this.this$1.this$0.unfiltered.asMap().entrySet().iterator();
            while (iterator.hasNext()) {
                final Map.Entry<Object, V> entry = iterator.next();
                final Collection filterCollection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap$ValuePredicate(this.this$1.this$0, entry.getKey()));
                if (!filterCollection.isEmpty() && collection.equals(filterCollection)) {
                    if (filterCollection.size() == ((Collection)entry.getValue()).size()) {
                        iterator.remove();
                    }
                    else {
                        filterCollection.clear();
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
    }
}
