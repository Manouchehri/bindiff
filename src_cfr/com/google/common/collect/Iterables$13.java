/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ConsumingQueueIterator;
import com.google.common.collect.FluentIterable;
import java.util.Iterator;
import java.util.Queue;

final class Iterables$13
extends FluentIterable {
    final /* synthetic */ Iterable val$iterable;

    Iterables$13(Iterable iterable) {
        this.val$iterable = iterable;
    }

    public Iterator iterator() {
        return new ConsumingQueueIterator((Queue)this.val$iterable);
    }

    @Override
    public String toString() {
        return "Iterables.consumingIterable(...)";
    }
}

