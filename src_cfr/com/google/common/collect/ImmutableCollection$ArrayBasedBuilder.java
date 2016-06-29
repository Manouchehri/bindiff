/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ObjectArrays;
import java.util.Collection;

abstract class ImmutableCollection$ArrayBasedBuilder
extends ImmutableCollection$Builder {
    Object[] contents;
    int size;

    ImmutableCollection$ArrayBasedBuilder(int n2) {
        CollectPreconditions.checkNonnegative(n2, "initialCapacity");
        this.contents = new Object[n2];
        this.size = 0;
    }

    private void ensureCapacity(int n2) {
        if (this.contents.length >= n2) return;
        this.contents = ObjectArrays.arraysCopyOf(this.contents, ImmutableCollection$ArrayBasedBuilder.expandedCapacity(this.contents.length, n2));
    }

    @Override
    public ImmutableCollection$ArrayBasedBuilder add(Object object) {
        Preconditions.checkNotNull(object);
        this.ensureCapacity(this.size + 1);
        this.contents[this.size++] = object;
        return this;
    }

    @Override
    public /* varargs */ ImmutableCollection$Builder add(Object ... arrobject) {
        ObjectArrays.checkElementsNotNull(arrobject);
        this.ensureCapacity(this.size + arrobject.length);
        System.arraycopy(arrobject, 0, this.contents, this.size, arrobject.length);
        this.size += arrobject.length;
        return this;
    }

    @Override
    public ImmutableCollection$Builder addAll(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            this.ensureCapacity(this.size + collection.size());
        }
        super.addAll(iterable);
        return this;
    }
}

