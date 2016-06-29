/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$14
extends FluentIterable {
    final /* synthetic */ Iterable val$iterable;

    Iterables$14(Iterable iterable) {
        this.val$iterable = iterable;
    }

    public Iterator iterator() {
        return Iterators.consumingIterator(this.val$iterable.iterator());
    }

    @Override
    public String toString() {
        return "Iterables.consumingIterable(...)";
    }
}

