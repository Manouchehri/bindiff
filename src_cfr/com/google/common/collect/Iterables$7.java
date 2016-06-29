/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$7
extends FluentIterable {
    final /* synthetic */ Iterable val$unfiltered;
    final /* synthetic */ Predicate val$predicate;

    Iterables$7(Iterable iterable, Predicate predicate) {
        this.val$unfiltered = iterable;
        this.val$predicate = predicate;
    }

    public Iterator iterator() {
        return Iterators.filter(this.val$unfiltered.iterator(), this.val$predicate);
    }
}

