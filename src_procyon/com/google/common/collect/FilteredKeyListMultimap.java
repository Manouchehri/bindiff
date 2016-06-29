package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
final class FilteredKeyListMultimap extends FilteredKeyMultimap implements ListMultimap
{
    FilteredKeyListMultimap(final ListMultimap listMultimap, final Predicate predicate) {
        super(listMultimap, predicate);
    }
    
    @Override
    public ListMultimap unfiltered() {
        return (ListMultimap)super.unfiltered();
    }
    
    @Override
    public List get(final Object o) {
        return (List)super.get(o);
    }
    
    @Override
    public List removeAll(@Nullable final Object o) {
        return (List)super.removeAll(o);
    }
    
    @Override
    public List replaceValues(final Object o, final Iterable iterable) {
        return (List)super.replaceValues(o, iterable);
    }
}
