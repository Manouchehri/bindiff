/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$8
extends FluentIterable {
    final /* synthetic */ Iterable val$unfiltered;
    final /* synthetic */ Class val$type;

    Iterables$8(Iterable iterable, Class class_) {
        this.val$unfiltered = iterable;
        this.val$type = class_;
    }

    public Iterator iterator() {
        return Iterators.filter(this.val$unfiltered.iterator(), this.val$type);
    }
}

