/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapBuilder$ImmutableHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GoogleInternal
@GwtCompatible
public class ImmutableMapBuilder {
    private ImmutableMapBuilder$ImmutableHashMap map;

    @Deprecated
    public static ImmutableMapBuilder fromMap(Map map) {
        ImmutableMapBuilder immutableMapBuilder = new ImmutableMapBuilder(map.size());
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            immutableMapBuilder.put(entry.getKey(), entry.getValue());
        }
        return immutableMapBuilder;
    }

    @Deprecated
    public ImmutableMapBuilder() {
        this(8);
    }

    @Deprecated
    public ImmutableMapBuilder(int n2) {
        this.map = new ImmutableMapBuilder$ImmutableHashMap(n2);
    }

    @Deprecated
    public ImmutableMapBuilder put(@Nullable Object object, @Nullable Object object2) {
        Preconditions.checkState(this.map != null, "map has already been created");
        ImmutableMapBuilder$ImmutableHashMap.access$000(this.map, object, object2);
        return this;
    }

    @Deprecated
    public Map getMap() {
        Preconditions.checkState(this.map != null, "map has already been created");
        try {
            ImmutableMapBuilder$ImmutableHashMap immutableMapBuilder$ImmutableHashMap = this.map;
            return immutableMapBuilder$ImmutableHashMap;
        }
        finally {
            this.map = null;
        }
    }
}

