/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$6
extends FluentIterable {
    final /* synthetic */ Iterable val$first;
    final /* synthetic */ Iterable val$second;

    Iterables$6(Iterable iterable, Iterable iterable2) {
        this.val$first = iterable;
        this.val$second = iterable2;
    }

    public Iterator iterator() {
        return Iterators.pairUp(this.val$first.iterator(), this.val$second.iterator());
    }
}

