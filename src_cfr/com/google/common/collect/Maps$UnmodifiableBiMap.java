/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$UnmodifiableBiMap
extends ForwardingMap
implements BiMap,
Serializable {
    final Map unmodifiableMap;
    final BiMap delegate;
    BiMap inverse;
    transient Set values;
    private static final long serialVersionUID = 0;

    Maps$UnmodifiableBiMap(BiMap biMap, @Nullable BiMap biMap2) {
        this.unmodifiableMap = Collections.unmodifiableMap(biMap);
        this.delegate = biMap;
        this.inverse = biMap2;
    }

    @Override
    protected Map delegate() {
        return this.unmodifiableMap;
    }

    @Override
    public Object forcePut(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BiMap inverse() {
        BiMap biMap;
        BiMap biMap2 = this.inverse;
        if (biMap2 == null) {
            biMap = this.inverse = new Maps$UnmodifiableBiMap(this.delegate.inverse(), this);
            return biMap;
        }
        biMap = biMap2;
        return biMap;
    }

    @Override
    public Set values() {
        Set set;
        Set set2 = this.values;
        if (set2 == null) {
            set = this.values = Collections.unmodifiableSet(this.delegate.values());
            return set;
        }
        set = set2;
        return set;
    }
}

