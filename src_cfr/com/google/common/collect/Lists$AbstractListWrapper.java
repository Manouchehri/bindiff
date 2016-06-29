/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

class Lists$AbstractListWrapper
extends AbstractList {
    final List backingList;

    Lists$AbstractListWrapper(List list) {
        this.backingList = (List)Preconditions.checkNotNull(list);
    }

    @Override
    public void add(int n2, Object object) {
        this.backingList.add(n2, object);
    }

    @Override
    public boolean addAll(int n2, Collection collection) {
        return this.backingList.addAll(n2, collection);
    }

    @Override
    public Object get(int n2) {
        return this.backingList.get(n2);
    }

    @Override
    public Object remove(int n2) {
        return this.backingList.remove(n2);
    }

    @Override
    public Object set(int n2, Object object) {
        return this.backingList.set(n2, object);
    }

    @Override
    public boolean contains(Object object) {
        return this.backingList.contains(object);
    }

    @Override
    public int size() {
        return this.backingList.size();
    }
}

