/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Iterator;
import java.util.Set;

public class ImmutableMultiset$Builder
extends ImmutableCollection$Builder {
    final Multiset contents;

    public ImmutableMultiset$Builder() {
        this(LinkedHashMultiset.create());
    }

    ImmutableMultiset$Builder(Multiset multiset) {
        this.contents = multiset;
    }

    @Override
    public ImmutableMultiset$Builder add(Object object) {
        this.contents.add(Preconditions.checkNotNull(object));
        return this;
    }

    public ImmutableMultiset$Builder addCopies(Object object, int n2) {
        this.contents.add(Preconditions.checkNotNull(object), n2);
        return this;
    }

    public ImmutableMultiset$Builder setCount(Object object, int n2) {
        this.contents.setCount(Preconditions.checkNotNull(object), n2);
        return this;
    }

    @Override
    public /* varargs */ ImmutableMultiset$Builder add(Object ... arrobject) {
        super.add(arrobject);
        return this;
    }

    @Override
    public ImmutableMultiset$Builder addAll(Iterable iterable) {
        if (!(iterable instanceof Multiset)) {
            super.addAll(iterable);
            return this;
        }
        Multiset multiset = Multisets.cast(iterable);
        Iterator iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            this.addCopies(multiset$Entry.getElement(), multiset$Entry.getCount());
        }
        return this;
    }

    @Override
    public ImmutableMultiset$Builder addAll(Iterator iterator) {
        super.addAll(iterator);
        return this;
    }

    @Override
    public ImmutableMultiset build() {
        return ImmutableMultiset.copyOf(this.contents);
    }
}

