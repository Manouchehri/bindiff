/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.WellBehavedMap$1;
import com.google.common.collect.WellBehavedMap$EntrySet;
import java.util.Map;
import java.util.Set;

@GwtCompatible
final class WellBehavedMap
extends ForwardingMap {
    private final Map delegate;
    private Set entrySet;

    private WellBehavedMap(Map map) {
        this.delegate = map;
    }

    static WellBehavedMap wrap(Map map) {
        return new WellBehavedMap(map);
    }

    @Override
    protected Map delegate() {
        return this.delegate;
    }

    @Override
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        this.entrySet = new WellBehavedMap$EntrySet(this, null);
        return this.entrySet;
    }
}

