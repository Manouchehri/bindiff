/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableClassToInstanceMap$1;
import com.google.common.collect.ImmutableClassToInstanceMap$Builder;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

public final class ImmutableClassToInstanceMap
extends ForwardingMap
implements ClassToInstanceMap,
Serializable {
    private static final ImmutableClassToInstanceMap EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
    private final ImmutableMap delegate;

    public static ImmutableClassToInstanceMap of() {
        return EMPTY;
    }

    public static ImmutableClassToInstanceMap of(Class class_, Object object) {
        ImmutableMap immutableMap = ImmutableMap.of(class_, object);
        return new ImmutableClassToInstanceMap(immutableMap);
    }

    public static ImmutableClassToInstanceMap$Builder builder() {
        return new ImmutableClassToInstanceMap$Builder();
    }

    public static ImmutableClassToInstanceMap copyOf(Map map) {
        if (!(map instanceof ImmutableClassToInstanceMap)) return new ImmutableClassToInstanceMap$Builder().putAll(map).build();
        return (ImmutableClassToInstanceMap)map;
    }

    private ImmutableClassToInstanceMap(ImmutableMap immutableMap) {
        this.delegate = immutableMap;
    }

    @Override
    protected Map delegate() {
        return this.delegate;
    }

    @Nullable
    @Override
    public Object getInstance(Class class_) {
        return this.delegate.get(Preconditions.checkNotNull(class_));
    }

    @Deprecated
    @Override
    public Object putInstance(Class class_, Object object) {
        throw new UnsupportedOperationException();
    }

    Object readResolve() {
        ImmutableClassToInstanceMap immutableClassToInstanceMap;
        if (this.isEmpty()) {
            immutableClassToInstanceMap = ImmutableClassToInstanceMap.of();
            return immutableClassToInstanceMap;
        }
        immutableClassToInstanceMap = this;
        return immutableClassToInstanceMap;
    }

    /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap immutableMap, ImmutableClassToInstanceMap$1 immutableClassToInstanceMap$1) {
        this(immutableMap);
    }
}

