/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$1
extends FluentIterable {
    final /* synthetic */ Iterable val$iterable;

    Iterables$1(Iterable iterable) {
        this.val$iterable = iterable;
    }

    public Iterator iterator() {
        return Iterators.cycle(this.val$iterable);
    }

    @Override
    public String toString() {
        return String.valueOf(this.val$iterable.toString()).concat(" (cycled)");
    }
}

