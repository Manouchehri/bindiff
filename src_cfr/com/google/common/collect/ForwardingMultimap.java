/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMultimap
extends ForwardingObject
implements Multimap {
    protected ForwardingMultimap() {
    }

    @Override
    protected abstract Multimap delegate();

    @Override
    public Map asMap() {
        return this.delegate().asMap();
    }

    @Override
    public void clear() {
        this.delegate().clear();
    }

    @Override
    public boolean containsEntry(@Nullable Object object, @Nullable Object object2) {
        return this.delegate().containsEntry(object, object2);
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.delegate().containsKey(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.delegate().containsValue(object);
    }

    @Override
    public Collection entries() {
        return this.delegate().entries();
    }

    @Override
    public Collection get(@Nullable Object object) {
        return this.delegate().get(object);
    }

    @Override
    public boolean isEmpty() {
        return this.delegate().isEmpty();
    }

    @Override
    public Multiset keys() {
        return this.delegate().keys();
    }

    @Override
    public Set keySet() {
        return this.delegate().keySet();
    }

    @Override
    public boolean put(Object object, Object object2) {
        return this.delegate().put(object, object2);
    }

    @Override
    public boolean putAll(Object object, Iterable iterable) {
        return this.delegate().putAll(object, iterable);
    }

    @Override
    public boolean putAll(Multimap multimap) {
        return this.delegate().putAll(multimap);
    }

    @Override
    public boolean remove(@Nullable Object object, @Nullable Object object2) {
        return this.delegate().remove(object, object2);
    }

    @Override
    public Collection removeAll(@Nullable Object object) {
        return this.delegate().removeAll(object);
    }

    @Override
    public Collection replaceValues(Object object, Iterable iterable) {
        return this.delegate().replaceValues(object, iterable);
    }

    @Override
    public int size() {
        return this.delegate().size();
    }

    @Override
    public Collection values() {
        return this.delegate().values();
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
}

