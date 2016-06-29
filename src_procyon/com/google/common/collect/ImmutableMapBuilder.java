package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import com.google.errorprone.annotations.concurrent.*;
import java.util.*;

@GoogleInternal
@GwtCompatible
public class ImmutableMapBuilder
{
    private ImmutableMapBuilder$ImmutableHashMap map;
    
    @Deprecated
    public static ImmutableMapBuilder fromMap(final Map map) {
        final ImmutableMapBuilder immutableMapBuilder = new ImmutableMapBuilder(map.size());
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            immutableMapBuilder.put(entry.getKey(), entry.getValue());
        }
        return immutableMapBuilder;
    }
    
    public ImmutableMapBuilder() {
        this(8);
    }
    
    public ImmutableMapBuilder(final int n) {
        this.map = new ImmutableMapBuilder$ImmutableHashMap(n);
    }
    
    @Deprecated
    public ImmutableMapBuilder put(@Nullable final Object o, @Nullable final Object o2) {
        Preconditions.checkState(this.map != null, (Object)"map has already been created");
        this.map.secretPut(o, o2);
        return this;
    }
    
    @Deprecated
    public Map getMap() {
        Preconditions.checkState(this.map != null, (Object)"map has already been created");
        try {
            return this.map;
        }
        finally {
            this.map = null;
        }
    }
}
