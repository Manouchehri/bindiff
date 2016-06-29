/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.AbstractBiMap$EntrySet;
import com.google.common.collect.AbstractBiMap$Inverse;
import com.google.common.collect.AbstractBiMap$KeySet;
import com.google.common.collect.AbstractBiMap$ValueSet;
import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
abstract class AbstractBiMap
extends ForwardingMap
implements BiMap,
Serializable {
    private transient Map delegate;
    transient AbstractBiMap inverse;
    private transient Set keySet;
    private transient Set valueSet;
    private transient Set entrySet;
    @GwtIncompatible(value="Not needed in emulated source.")
    private static final long serialVersionUID = 0;

    AbstractBiMap(Map map, Map map2) {
        this.setDelegates(map, map2);
    }

    private AbstractBiMap(Map map, AbstractBiMap abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    @Override
    protected Map delegate() {
        return this.delegate;
    }

    Object checkKey(@Nullable Object object) {
        return object;
    }

    Object checkValue(@Nullable Object object) {
        return object;
    }

    void setDelegates(Map map, Map map2) {
        Preconditions.checkState(this.delegate == null);
        Preconditions.checkState(this.inverse == null);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        Preconditions.checkArgument(map != map2);
        this.delegate = map;
        this.inverse = new AbstractBiMap$Inverse(map2, this, null);
    }

    void setInverse(AbstractBiMap abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.inverse.containsKey(object);
    }

    @Override
    public Object put(@Nullable Object object, @Nullable Object object2) {
        return this.putInBothMaps(object, object2, false);
    }

    @Override
    public Object forcePut(@Nullable Object object, @Nullable Object object2) {
        return this.putInBothMaps(object, object2, true);
    }

    private Object putInBothMaps(@Nullable Object object, @Nullable Object object2, boolean bl2) {
        this.checkKey(object);
        this.checkValue(object2);
        boolean bl3 = this.containsKey(object);
        if (bl3 && Objects.equal(object2, this.get(object))) {
            return object2;
        }
        if (bl2) {
            this.inverse().remove(object2);
        } else {
            Preconditions.checkArgument(!this.containsValue(object2), "value already present: %s", object2);
        }
        Object object3 = this.delegate.put(object, object2);
        this.updateInverseMap(object, bl3, object3, object2);
        return object3;
    }

    private void updateInverseMap(Object object, boolean bl2, Object object2, Object object3) {
        if (bl2) {
            this.removeFromInverseMap(object2);
        }
        this.inverse.delegate.put(object3, object);
    }

    @Override
    public Object remove(@Nullable Object object) {
        if (!this.containsKey(object)) return null;
        Object object2 = this.removeFromBothMaps(object);
        return object2;
    }

    private Object removeFromBothMaps(Object object) {
        Object v2 = this.delegate.remove(object);
        this.removeFromInverseMap(v2);
        return v2;
    }

    private void removeFromInverseMap(Object object) {
        this.inverse.delegate.remove(object);
    }

    @Override
    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override
    public BiMap inverse() {
        return this.inverse;
    }

    @Override
    public Set keySet() {
        Set set;
        Set set2 = this.keySet;
        if (set2 == null) {
            set = this.keySet = new AbstractBiMap$KeySet(this, null);
            return set;
        }
        set = set2;
        return set;
    }

    @Override
    public Set values() {
        Set set;
        Set set2 = this.valueSet;
        if (set2 == null) {
            set = this.valueSet = new AbstractBiMap$ValueSet(this, null);
            return set;
        }
        set = set2;
        return set;
    }

    @Override
    public Set entrySet() {
        Set set;
        Set set2 = this.entrySet;
        if (set2 == null) {
            set = this.entrySet = new AbstractBiMap$EntrySet(this, null);
            return set;
        }
        set = set2;
        return set;
    }

    static /* synthetic */ Map access$200(AbstractBiMap abstractBiMap) {
        return abstractBiMap.delegate;
    }

    static /* synthetic */ Object access$300(AbstractBiMap abstractBiMap, Object object) {
        return abstractBiMap.removeFromBothMaps(object);
    }

    static /* synthetic */ void access$600(AbstractBiMap abstractBiMap, Object object, boolean bl2, Object object2, Object object3) {
        abstractBiMap.updateInverseMap(object, bl2, object2, object3);
    }

    static /* synthetic */ void access$700(AbstractBiMap abstractBiMap, Object object) {
        abstractBiMap.removeFromInverseMap(object);
    }

    /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, AbstractBiMap$1 abstractBiMap$1) {
        this(map, abstractBiMap);
    }
}

