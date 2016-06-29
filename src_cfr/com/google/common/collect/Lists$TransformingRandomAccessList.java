/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists$TransformingRandomAccessList$1;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

class Lists$TransformingRandomAccessList
extends AbstractList
implements Serializable,
RandomAccess {
    final List fromList;
    final Function function;
    private static final long serialVersionUID = 0;

    Lists$TransformingRandomAccessList(List list, Function function) {
        this.fromList = (List)Preconditions.checkNotNull(list);
        this.function = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    public void clear() {
        this.fromList.clear();
    }

    @Override
    public Object get(int n2) {
        return this.function.apply(this.fromList.get(n2));
    }

    @Override
    public Iterator iterator() {
        return this.listIterator();
    }

    @Override
    public ListIterator listIterator(int n2) {
        return new Lists$TransformingRandomAccessList$1(this, this.fromList.listIterator(n2));
    }

    @Override
    public boolean isEmpty() {
        return this.fromList.isEmpty();
    }

    @Override
    public Object remove(int n2) {
        return this.function.apply(this.fromList.remove(n2));
    }

    @Override
    public int size() {
        return this.fromList.size();
    }
}

