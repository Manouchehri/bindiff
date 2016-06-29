package com.google.common.collect;

import java.util.*;
import com.google.common.primitives.*;

public final class ImmutableClassToInstanceMap$Builder
{
    private final ImmutableMap$Builder mapBuilder;
    
    public ImmutableClassToInstanceMap$Builder() {
        this.mapBuilder = ImmutableMap.builder();
    }
    
    public ImmutableClassToInstanceMap$Builder put(final Class clazz, final Object o) {
        this.mapBuilder.put(clazz, o);
        return this;
    }
    
    public ImmutableClassToInstanceMap$Builder putAll(final Map map) {
        for (final Map.Entry<Class, V> entry : map.entrySet()) {
            final Class clazz = entry.getKey();
            this.mapBuilder.put(clazz, cast(clazz, entry.getValue()));
        }
        return this;
    }
    
    private static Object cast(final Class clazz, final Object o) {
        return Primitives.wrap(clazz).cast(o);
    }
    
    public ImmutableClassToInstanceMap build() {
        final ImmutableMap build = this.mapBuilder.build();
        if (build.isEmpty()) {
            return ImmutableClassToInstanceMap.of();
        }
        return new ImmutableClassToInstanceMap(build, null);
    }
}
