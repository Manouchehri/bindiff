/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

final class Iterators$3
extends UnmodifiableIterator {
    final /* synthetic */ Iterator val$iterator;

    Iterators$3(Iterator iterator) {
        this.val$iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Object next() {
        return this.val$iterator.next();
    }
}

