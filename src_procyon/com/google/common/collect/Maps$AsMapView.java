package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

class Maps$AsMapView extends Maps$ViewCachingAbstractMap
{
    private final Set set;
    final Function function;
    
    Set backingSet() {
        return this.set;
    }
    
    Maps$AsMapView(final Set set, final Function function) {
        this.set = (Set)Preconditions.checkNotNull(set);
        this.function = (Function)Preconditions.checkNotNull(function);
    }
    
    public Set createKeySet() {
        return removeOnlySet(this.backingSet());
    }
    
    @Override
    Collection createValues() {
        return Collections2.transform(this.set, this.function);
    }
    
    @Override
    public int size() {
        return this.backingSet().size();
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.backingSet().contains(o);
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        if (Collections2.safeContains(this.backingSet(), o)) {
            return this.function.apply(o);
        }
        return null;
    }
    
    @Override
    public Object remove(@Nullable final Object o) {
        if (this.backingSet().remove(o)) {
            return this.function.apply(o);
        }
        return null;
    }
    
    @Override
    public void clear() {
        this.backingSet().clear();
    }
    
    protected Set createEntrySet() {
        return new Maps$AsMapView$1EntrySetImpl(this);
    }
}
