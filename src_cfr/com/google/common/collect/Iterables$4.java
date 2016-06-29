/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$4
extends FluentIterable {
    final /* synthetic */ Iterable val$iterable;
    final /* synthetic */ int val$size;

    Iterables$4(Iterable iterable, int n2) {
        this.val$iterable = iterable;
        this.val$size = n2;
    }

    public Iterator iterator() {
        return Iterators.partition(this.val$iterable.iterator(), this.val$size);
    }
}

