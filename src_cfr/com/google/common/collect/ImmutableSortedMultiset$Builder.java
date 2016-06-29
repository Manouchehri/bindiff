/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableMultiset$Builder;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;
import java.util.Comparator;
import java.util.Iterator;

public class ImmutableSortedMultiset$Builder
extends ImmutableMultiset$Builder {
    public ImmutableSortedMultiset$Builder(Comparator comparator) {
        super(TreeMultiset.create((Comparator)Preconditions.checkNotNull(comparator)));
    }

    @Override
    public ImmutableSortedMultiset$Builder add(Object object) {
        super.add(object);
        return this;
    }

    @Override
    public ImmutableSortedMultiset$Builder addCopies(Object object, int n2) {
        super.addCopies(object, n2);
        return this;
    }

    @Override
    public ImmutableSortedMultiset$Builder setCount(Object object, int n2) {
        super.setCount(object, n2);
        return this;
    }

    @Override
    public /* varargs */ ImmutableSortedMultiset$Builder add(Object ... arrobject) {
        super.add(arrobject);
        return this;
    }

    @Override
    public ImmutableSortedMultiset$Builder addAll(Iterable iterable) {
        super.addAll(iterable);
        return this;
    }

    @Override
    public ImmutableSortedMultiset$Builder addAll(Iterator iterator) {
        super.addAll(iterator);
        return this;
    }

    @Override
    public ImmutableSortedMultiset build() {
        return ImmutableSortedMultiset.copyOfSorted((SortedMultiset)this.contents);
    }
}

