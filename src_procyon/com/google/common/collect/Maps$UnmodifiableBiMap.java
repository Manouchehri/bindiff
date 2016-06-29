package com.google.common.collect;

import java.io.*;
import javax.annotation.*;
import java.util.*;

class Maps$UnmodifiableBiMap extends ForwardingMap implements BiMap, Serializable
{
    final Map unmodifiableMap;
    final BiMap delegate;
    BiMap inverse;
    transient Set values;
    private static final long serialVersionUID = 0L;
    
    Maps$UnmodifiableBiMap(final BiMap delegate, @Nullable final BiMap inverse) {
        this.unmodifiableMap = Collections.unmodifiableMap((Map<?, ?>)delegate);
        this.delegate = delegate;
        this.inverse = inverse;
    }
    
    @Override
    protected Map delegate() {
        return this.unmodifiableMap;
    }
    
    @Override
    public Object forcePut(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public BiMap inverse() {
        final BiMap inverse = this.inverse;
        return (inverse == null) ? (this.inverse = new Maps$UnmodifiableBiMap(this.delegate.inverse(), this)) : inverse;
    }
    
    @Override
    public Set values() {
        final Set values = this.values;
        return (values == null) ? (this.values = Collections.unmodifiableSet((Set<?>)this.delegate.values())) : values;
    }
}
