/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$2
extends FluentIterable {
    final /* synthetic */ Iterable val$inputs;

    Iterables$2(Iterable iterable) {
        this.val$inputs = iterable;
    }

    public Iterator iterator() {
        return Iterators.concat(Iterables.access$100(this.val$inputs));
    }
}

