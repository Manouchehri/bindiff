package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class MapConstraints$ConstrainedMultimap$1AsMap extends ForwardingMap
{
    Set entrySet;
    Collection values;
    final /* synthetic */ Map val$asMapDelegate;
    final /* synthetic */ MapConstraints$ConstrainedMultimap this$0;
    
    MapConstraints$ConstrainedMultimap$1AsMap(final MapConstraints$ConstrainedMultimap this$0, final Map val$asMapDelegate) {
        this.this$0 = this$0;
        this.val$asMapDelegate = val$asMapDelegate;
    }
    
    @Override
    protected Map delegate() {
        return this.val$asMapDelegate;
    }
    
    @Override
    public Set entrySet() {
        Set entrySet = this.entrySet;
        if (entrySet == null) {
            entrySet = (this.entrySet = constrainedAsMapEntries(this.val$asMapDelegate.entrySet(), this.this$0.constraint));
        }
        return entrySet;
    }
    
    @Override
    public Collection get(final Object o) {
        try {
            final Collection value = this.this$0.get(o);
            return value.isEmpty() ? null : value;
        }
        catch (ClassCastException ex) {
            return null;
        }
    }
    
    @Override
    public Collection values() {
        Collection values = this.values;
        if (values == null) {
            values = (this.values = new MapConstraints$ConstrainedAsMapValues(this.delegate().values(), this.entrySet()));
        }
        return values;
    }
    
    @Override
    public boolean containsValue(final Object o) {
        return this.values().contains(o);
    }
}
