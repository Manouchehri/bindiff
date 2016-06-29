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
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMultiset
extends ForwardingCollection
implements Multiset {
    protected ForwardingMultiset() {
    }

    @Override
    protected abstract Multiset delegate();

    @Override
    public int count(Object object) {
        return this.delegate().count(object);
    }

    @Override
    public int add(Object object, int n2) {
        return this.delegate().add(object, n2);
    }

    @Override
    public int remove(Object object, int n2) {
        return this.delegate().remove(object, n2);
    }

    @Override
    public Set elementSet() {
        return this.delegate().elementSet();
    }

    @Override
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

    @Override
    public int setCount(Object object, int n2) {
        return this.delegate().setCount(object, n2);
    }

    @Override
    public boolean setCount(Object object, int n2, int n3) {
        return this.delegate().setCount(object, n2, n3);
    }

    @Override
    protected boolean standardContains(@Nullable Object object) {
        if (this.count(object) <= 0) return false;
        return true;
    }

    @Override
    protected void standardClear() {
        Iterators.clear(this.entrySet().iterator());
    }

    @Beta
    protected int standardCount(@Nullable Object object) {
        Multiset$Entry multiset$Entry;
        Iterator<E> iterator = this.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return 0;
        } while (!Objects.equal((multiset$Entry = (Multiset$Entry)iterator.next()).getElement(), object));
        return multiset$Entry.getCount();
    }

    protected boolean standardAdd(Object object) {
        this.add(object, 1);
        return true;
    }

    @Beta
    @Override
    protected boolean standardAddAll(Collection collection) {
        return Multisets.addAllImpl(this, collection);
    }

    @Override
    protected boolean standardRemove(Object object) {
        if (this.remove(object, 1) <= 0) return false;
        return true;
    }

    @Override
    protected boolean standardRemoveAll(Collection collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    @Override
    protected boolean standardRetainAll(Collection collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    protected int standardSetCount(Object object, int n2) {
        return Multisets.setCountImpl(this, object, n2);
    }

    protected boolean standardSetCount(Object object, int n2, int n3) {
        return Multisets.setCountImpl(this, object, n2, n3);
    }

    protected Iterator standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    protected int standardSize() {
        return Multisets.sizeImpl(this);
    }

    protected boolean standardEquals(@Nullable Object object) {
        return Multisets.equalsImpl(this, object);
    }

    protected int standardHashCode() {
        return this.entrySet().hashCode();
    }

    @Override
    protected String standardToString() {
        return this.entrySet().toString();
    }
}

