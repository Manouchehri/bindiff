/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables$11$1;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$11
extends FluentIterable {
    final /* synthetic */ Iterable val$iterable;
    final /* synthetic */ int val$numberToSkip;

    Iterables$11(Iterable iterable, int n2) {
        this.val$iterable = iterable;
        this.val$numberToSkip = n2;
    }

    public Iterator iterator() {
        Iterator iterator = this.val$iterable.iterator();
        Iterators.advance(iterator, this.val$numberToSkip);
        return new Iterables$11$1(this, iterator);
    }
}

