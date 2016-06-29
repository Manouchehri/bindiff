/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Lists$OnePlusArrayList
extends AbstractList
implements Serializable,
RandomAccess {
    final Object first;
    final Object[] rest;
    private static final long serialVersionUID = 0;

    Lists$OnePlusArrayList(@Nullable Object object, Object[] arrobject) {
        this.first = object;
        this.rest = (Object[])Preconditions.checkNotNull(arrobject);
    }

    @Override
    public int size() {
        return this.rest.length + 1;
    }

    @Override
    public Object get(int n2) {
        Object object;
        Preconditions.checkElementIndex(n2, this.size());
        if (n2 == 0) {
            object = this.first;
            return object;
        }
        object = this.rest[n2 - 1];
        return object;
    }
}

