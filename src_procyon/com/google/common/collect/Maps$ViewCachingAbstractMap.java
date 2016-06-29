package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible
abstract class Maps$ViewCachingAbstractMap extends AbstractMap
{
    private transient Set entrySet;
    private transient Set keySet;
    private transient Collection values;
    
    abstract Set createEntrySet();
    
    @Override
    public Set entrySet() {
        final Set entrySet = this.entrySet;
        return (entrySet == null) ? (this.entrySet = this.createEntrySet()) : entrySet;
    }
    
    @Override
    public Set keySet() {
        final Set keySet = this.keySet;
        return (keySet == null) ? (this.keySet = this.createKeySet()) : keySet;
    }
    
    Set createKeySet() {
        return new Maps$KeySet(this);
    }
    
    @Override
    public Collection values() {
        final Collection values = this.values;
        return (values == null) ? (this.values = this.createValues()) : values;
    }
    
    Collection createValues() {
        return new Maps$Values(this);
    }
}
