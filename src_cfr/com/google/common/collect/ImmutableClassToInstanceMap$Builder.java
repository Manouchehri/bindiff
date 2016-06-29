/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableClassToInstanceMap;
import com.google.common.collect.ImmutableClassToInstanceMap$1;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.primitives.Primitives;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ImmutableClassToInstanceMap$Builder {
    private final ImmutableMap$Builder mapBuilder = ImmutableMap.builder();

    public ImmutableClassToInstanceMap$Builder put(Class class_, Object object) {
        this.mapBuilder.put(class_, object);
        return this;
    }

    public ImmutableClassToInstanceMap$Builder putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Class class_ = (Class)entry.getKey();
            Object v2 = entry.getValue();
            this.mapBuilder.put(class_, ImmutableClassToInstanceMap$Builder.cast(class_, v2));
        }
        return this;
    }

    private static Object cast(Class class_, Object object) {
        return Primitives.wrap(class_).cast(object);
    }

    public ImmutableClassToInstanceMap build() {
        ImmutableMap immutableMap = this.mapBuilder.build();
        if (!immutableMap.isEmpty()) return new ImmutableClassToInstanceMap(immutableMap, null);
        return ImmutableClassToInstanceMap.of();
    }
}

