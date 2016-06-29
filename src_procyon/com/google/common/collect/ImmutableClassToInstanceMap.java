package com.google.common.collect;

import java.io.*;
import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

public final class ImmutableClassToInstanceMap extends ForwardingMap implements ClassToInstanceMap, Serializable
{
    private static final ImmutableClassToInstanceMap EMPTY;
    private final ImmutableMap delegate;
    
    public static ImmutableClassToInstanceMap of() {
        return ImmutableClassToInstanceMap.EMPTY;
    }
    
    public static ImmutableClassToInstanceMap of(final Class clazz, final Object o) {
        return new ImmutableClassToInstanceMap(ImmutableMap.of(clazz, o));
    }
    
    public static ImmutableClassToInstanceMap$Builder builder() {
        return new ImmutableClassToInstanceMap$Builder();
    }
    
    public static ImmutableClassToInstanceMap copyOf(final Map map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap)map;
        }
        return new ImmutableClassToInstanceMap$Builder().putAll(map).build();
    }
    
    private ImmutableClassToInstanceMap(final ImmutableMap delegate) {
        this.delegate = delegate;
    }
    
    @Override
    protected Map delegate() {
        return this.delegate;
    }
    
    @Nullable
    @Override
    public Object getInstance(final Class clazz) {
        return this.delegate.get(Preconditions.checkNotNull(clazz));
    }
    
    @Deprecated
    @Override
    public Object putInstance(final Class clazz, final Object o) {
        throw new UnsupportedOperationException();
    }
    
    Object readResolve() {
        return this.isEmpty() ? of() : this;
    }
    
    static {
        EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
    }
}
