/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$ProtobufList;
import java.util.AbstractList;
import java.util.Collection;

abstract class AbstractProtobufList
extends AbstractList
implements Internal$ProtobufList {
    private boolean isMutable = true;

    AbstractProtobufList() {
    }

    @Override
    public boolean add(Object object) {
        this.ensureIsMutable();
        return super.add(object);
    }

    public void add(int n2, Object object) {
        this.ensureIsMutable();
        super.add(n2, object);
    }

    @Override
    public boolean addAll(Collection collection) {
        this.ensureIsMutable();
        return super.addAll(collection);
    }

    public boolean addAll(int n2, Collection collection) {
        this.ensureIsMutable();
        return super.addAll(n2, collection);
    }

    @Override
    public void clear() {
        this.ensureIsMutable();
        super.clear();
    }

    @Override
    public boolean isModifiable() {
        return this.isMutable;
    }

    @Override
    public final void makeImmutable() {
        this.isMutable = false;
    }

    public Object remove(int n2) {
        this.ensureIsMutable();
        return super.remove(n2);
    }

    @Override
    public boolean remove(Object object) {
        this.ensureIsMutable();
        return super.remove(object);
    }

    @Override
    public boolean removeAll(Collection collection) {
        this.ensureIsMutable();
        return super.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        this.ensureIsMutable();
        return super.retainAll(collection);
    }

    public Object set(int n2, Object object) {
        this.ensureIsMutable();
        return super.set(n2, object);
    }

    protected void ensureIsMutable() {
        if (this.isMutable) return;
        throw new UnsupportedOperationException();
    }
}

