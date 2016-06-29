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

class Lists$TwoPlusArrayList
extends AbstractList
implements Serializable,
RandomAccess {
    final Object first;
    final Object second;
    final Object[] rest;
    private static final long serialVersionUID = 0;

    Lists$TwoPlusArrayList(@Nullable Object object, @Nullable Object object2, Object[] arrobject) {
        this.first = object;
        this.second = object2;
        this.rest = (Object[])Preconditions.checkNotNull(arrobject);
    }

    @Override
    public int size() {
        return this.rest.length + 2;
    }

    @Override
    public Object get(int n2) {
        switch (n2) {
            case 0: {
                return this.first;
            }
            case 1: {
                return this.second;
            }
        }
        Preconditions.checkElementIndex(n2, this.size());
        return this.rest[n2 - 2];
    }
}

