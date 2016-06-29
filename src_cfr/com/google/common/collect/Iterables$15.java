/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Comparator;
import java.util.Iterator;

final class Iterables$15
extends FluentIterable {
    final /* synthetic */ Iterable val$iterables;
    final /* synthetic */ Comparator val$comparator;

    Iterables$15(Iterable iterable, Comparator comparator) {
        this.val$iterables = iterable;
        this.val$comparator = comparator;
    }

    public Iterator iterator() {
        return Iterators.mergeSorted(Iterables.transform(this.val$iterables, Iterables.access$200()), this.val$comparator);
    }
}

