/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

final class Iterators$8
extends AbstractIterator {
    final /* synthetic */ Iterator val$unfiltered;
    final /* synthetic */ Predicate val$predicate;

    Iterators$8(Iterator iterator, Predicate predicate) {
        this.val$unfiltered = iterator;
        this.val$predicate = predicate;
    }

    @Override
    protected Object computeNext() {
        Object e2;
        do {
            if (!this.val$unfiltered.hasNext()) return this.endOfData();
        } while (!this.val$predicate.apply(e2 = this.val$unfiltered.next()));
        return e2;
    }
}

