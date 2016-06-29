/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMap
extends ForwardingObject
implements Map {
    protected ForwardingMap() {
    }

    @Override
    protected abstract Map delegate();

    @Override
    public int size() {
        return this.delegate().size();
    }

    @Override
    public boolean isEmpty() {
        return this.delegate().isEmpty();
    }

    public Object remove(Object object) {
        return this.delegate().remove(object);
    }

    @Override
    public void clear() {
        this.delegate().clear();
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.delegate().containsKey(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.delegate().containsValue(object);
    }

    public Object get(@Nullable Object object) {
        return this.delegate().get(object);
    }

    public Object put(Object object, Object object2) {
        return this.delegate().put(object, object2);
    }

    public void putAll(Map map) {
        this.delegate().putAll(map);
    }

    public Set keySet() {
        return this.delegate().keySet();
    }

    public Collection values() {
        return this.delegate().values();
    }

    public Set entrySet() {
        return this.delegate().entrySet();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) return true;
        if (this.delegate().equals(object)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.delegate().hashCode();
    }

    protected void standardPutAll(Map map) {
        Maps.putAllImpl(this, map);
    }

    @Beta
    protected Object standardRemove(@Nullable Object object) {
        Map.Entry entry;
        Iterator<E> iterator = this.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!Objects.equal((entry = (Map.Entry)iterator.next()).getKey(), object));
        V v2 = entry.getValue();
        iterator.remove();
        return v2;
    }

    protected void standardClear() {
        Iterators.clear(this.entrySet().iterator());
    }

    @Beta
    protected boolean standardContainsKey(@Nullable Object object) {
        return Maps.containsKeyImpl(this, object);
    }

    protected boolean standardContainsValue(@Nullable Object object) {
        return Maps.containsValueImpl(this, object);
    }

    protected boolean standardIsEmpty() {
        if (this.entrySet().iterator().hasNext()) return false;
        return true;
    }

    protected boolean standardEquals(@Nullable Object object) {
        return Maps.equalsImpl(this, object);
    }

    protected int standardHashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }

    protected String standardToString() {
        return Maps.toStringImpl(this);
    }
}

