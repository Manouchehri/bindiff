/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingList
extends ForwardingCollection
implements List {
    protected ForwardingList() {
    }

    @Override
    protected abstract List delegate();

    public void add(int n2, Object object) {
        this.delegate().add(n2, object);
    }

    public boolean addAll(int n2, Collection collection) {
        return this.delegate().addAll(n2, collection);
    }

    public Object get(int n2) {
        return this.delegate().get(n2);
    }

    @Override
    public int indexOf(Object object) {
        return this.delegate().indexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.delegate().lastIndexOf(object);
    }

    public ListIterator listIterator() {
        return this.delegate().listIterator();
    }

    public ListIterator listIterator(int n2) {
        return this.delegate().listIterator(n2);
    }

    public Object remove(int n2) {
        return this.delegate().remove(n2);
    }

    public Object set(int n2, Object object) {
        return this.delegate().set(n2, object);
    }

    public List subList(int n2, int n3) {
        return this.delegate().subList(n2, n3);
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

    protected boolean standardAdd(Object object) {
        this.add(this.size(), object);
        return true;
    }

    protected boolean standardAddAll(int n2, Iterable iterable) {
        return Lists.addAllImpl(this, n2, iterable);
    }

    protected int standardIndexOf(@Nullable Object object) {
        return Lists.indexOfImpl(this, object);
    }

    protected int standardLastIndexOf(@Nullable Object object) {
        return Lists.lastIndexOfImpl(this, object);
    }

    protected Iterator standardIterator() {
        return this.listIterator();
    }

    protected ListIterator standardListIterator() {
        return this.listIterator(0);
    }

    @Beta
    protected ListIterator standardListIterator(int n2) {
        return Lists.listIteratorImpl(this, n2);
    }

    @Beta
    protected List standardSubList(int n2, int n3) {
        return Lists.subListImpl(this, n2, n3);
    }

    @Beta
    protected boolean standardEquals(@Nullable Object object) {
        return Lists.equalsImpl(this, object);
    }

    @Beta
    protected int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }
}

