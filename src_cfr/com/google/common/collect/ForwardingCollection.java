/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingCollection
extends ForwardingObject
implements Collection {
    protected ForwardingCollection() {
    }

    @Override
    protected abstract Collection delegate();

    @Override
    public Iterator iterator() {
        return this.delegate().iterator();
    }

    @Override
    public int size() {
        return this.delegate().size();
    }

    public boolean removeAll(Collection collection) {
        return this.delegate().removeAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.delegate().isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return this.delegate().contains(object);
    }

    public boolean add(Object object) {
        return this.delegate().add(object);
    }

    @Override
    public boolean remove(Object object) {
        return this.delegate().remove(object);
    }

    public boolean containsAll(Collection collection) {
        return this.delegate().containsAll(collection);
    }

    public boolean addAll(Collection collection) {
        return this.delegate().addAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return this.delegate().retainAll(collection);
    }

    @Override
    public void clear() {
        this.delegate().clear();
    }

    @Override
    public Object[] toArray() {
        return this.delegate().toArray();
    }

    public Object[] toArray(Object[] arrobject) {
        return this.delegate().toArray(arrobject);
    }

    protected boolean standardContains(@Nullable Object object) {
        return Iterators.contains(this.iterator(), object);
    }

    protected boolean standardContainsAll(Collection collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    protected boolean standardAddAll(Collection collection) {
        return Iterators.addAll(this, collection.iterator());
    }

    protected boolean standardRemove(@Nullable Object object) {
        Iterator iterator = this.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!Objects.equal(iterator.next(), object));
        iterator.remove();
        return true;
    }

    protected boolean standardRemoveAll(Collection collection) {
        return Iterators.removeAll(this.iterator(), collection);
    }

    protected boolean standardRetainAll(Collection collection) {
        return Iterators.retainAll(this.iterator(), collection);
    }

    protected void standardClear() {
        Iterators.clear(this.iterator());
    }

    protected boolean standardIsEmpty() {
        if (this.iterator().hasNext()) return false;
        return true;
    }

    protected String standardToString() {
        return Collections2.toStringImpl(this);
    }

    protected Object[] standardToArray() {
        Object[] arrobject = new Object[this.size()];
        return this.toArray(arrobject);
    }

    protected Object[] standardToArray(Object[] arrobject) {
        return ObjectArrays.toArrayImpl(this, arrobject);
    }
}

