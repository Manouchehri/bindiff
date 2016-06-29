/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.Multiset$Entry;
import java.util.Iterator;

class ConcurrentHashMultiset$3
extends ForwardingIterator {
    private Multiset$Entry last;
    final /* synthetic */ Iterator val$readOnlyIterator;
    final /* synthetic */ ConcurrentHashMultiset this$0;

    ConcurrentHashMultiset$3(ConcurrentHashMultiset concurrentHashMultiset, Iterator iterator) {
        this.this$0 = concurrentHashMultiset;
        this.val$readOnlyIterator = iterator;
    }

    @Override
    protected Iterator delegate() {
        return this.val$readOnlyIterator;
    }

    @Override
    public Multiset$Entry next() {
        this.last = (Multiset$Entry)super.next();
        return this.last;
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.last != null);
        this.this$0.setCount(this.last.getElement(), 0);
        this.last = null;
    }
}

