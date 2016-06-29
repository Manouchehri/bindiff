/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

class Collections2$TransformedCollection
extends AbstractCollection {
    final Collection fromCollection;
    final Function function;

    Collections2$TransformedCollection(Collection collection, Function function) {
        this.fromCollection = (Collection)Preconditions.checkNotNull(collection);
        this.function = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    public void clear() {
        this.fromCollection.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.fromCollection.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return Iterators.transform(this.fromCollection.iterator(), this.function);
    }

    @Override
    public int size() {
        return this.fromCollection.size();
    }
}

