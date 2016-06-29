/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public abstract class ForwardingTable
extends ForwardingObject
implements Table {
    protected ForwardingTable() {
    }

    @Override
    protected abstract Table delegate();

    @Override
    public Set cellSet() {
        return this.delegate().cellSet();
    }

    @Override
    public void clear() {
        this.delegate().clear();
    }

    @Override
    public Map column(Object object) {
        return this.delegate().column(object);
    }

    @Override
    public Set columnKeySet() {
        return this.delegate().columnKeySet();
    }

    @Override
    public Map columnMap() {
        return this.delegate().columnMap();
    }

    @Override
    public boolean contains(Object object, Object object2) {
        return this.delegate().contains(object, object2);
    }

    @Override
    public boolean containsColumn(Object object) {
        return this.delegate().containsColumn(object);
    }

    @Override
    public boolean containsRow(Object object) {
        return this.delegate().containsRow(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.delegate().containsValue(object);
    }

    @Override
    public Object get(Object object, Object object2) {
        return this.delegate().get(object, object2);
    }

    @Override
    public boolean isEmpty() {
        return this.delegate().isEmpty();
    }

    @Override
    public Object put(Object object, Object object2, Object object3) {
        return this.delegate().put(object, object2, object3);
    }

    @Override
    public void putAll(Table table) {
        this.delegate().putAll(table);
    }

    @Override
    public Object remove(Object object, Object object2) {
        return this.delegate().remove(object, object2);
    }

    @Override
    public Map row(Object object) {
        return this.delegate().row(object);
    }

    @Override
    public Set rowKeySet() {
        return this.delegate().rowKeySet();
    }

    @Override
    public Map rowMap() {
        return this.delegate().rowMap();
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
    public boolean equals(Object object) {
        if (object == this) return true;
        if (this.delegate().equals(object)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.delegate().hashCode();
    }
}

