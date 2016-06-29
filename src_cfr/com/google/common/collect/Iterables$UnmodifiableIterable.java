/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables$1;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$UnmodifiableIterable
extends FluentIterable {
    private final Iterable iterable;

    private Iterables$UnmodifiableIterable(Iterable iterable) {
        this.iterable = iterable;
    }

    public Iterator iterator() {
        return Iterators.unmodifiableIterator(this.iterable.iterator());
    }

    @Override
    public String toString() {
        return this.iterable.toString();
    }

    /* synthetic */ Iterables$UnmodifiableIterable(Iterable iterable, Iterables$1 iterables$1) {
        this(iterable);
    }
}

