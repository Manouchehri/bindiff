/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterables$11;
import java.util.Iterator;

class Iterables$11$1
implements Iterator {
    boolean atStart;
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ Iterables.11 this$0;

    Iterables$11$1(Iterables.11 var1_1, Iterator iterator) {
        this.this$0 = var1_1;
        this.val$iterator = iterator;
        this.atStart = true;
    }

    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Object next() {
        Object e2 = this.val$iterator.next();
        this.atStart = false;
        return e2;
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(!this.atStart);
        this.val$iterator.remove();
    }
}

