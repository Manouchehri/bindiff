/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.StandardTable$Row;
import com.google.common.collect.StandardTable$Row$1$1;
import java.util.Iterator;
import java.util.Map;

class StandardTable$Row$1
implements Iterator {
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ StandardTable$Row this$1;

    StandardTable$Row$1(StandardTable$Row standardTable$Row, Iterator iterator) {
        this.this$1 = standardTable$Row;
        this.val$iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Map.Entry next() {
        Map.Entry entry = (Map.Entry)this.val$iterator.next();
        return new StandardTable$Row$1$1(this, entry);
    }

    @Override
    public void remove() {
        this.val$iterator.remove();
        this.this$1.maintainEmptyInvariant();
    }
}

