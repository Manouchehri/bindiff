/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import java.util.Iterator;

final class FluentIterable$1
extends FluentIterable {
    final /* synthetic */ Iterable val$iterable;

    FluentIterable$1(Iterable iterable, Iterable iterable2) {
        this.val$iterable = iterable2;
        super(iterable);
    }

    public Iterator iterator() {
        return this.val$iterable.iterator();
    }
}

