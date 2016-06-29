/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.AbstractMultiset$EntrySet;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ConcurrentHashMultiset$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ConcurrentHashMultiset$EntrySet
extends AbstractMultiset$EntrySet {
    final /* synthetic */ ConcurrentHashMultiset this$0;

    private ConcurrentHashMultiset$EntrySet(ConcurrentHashMultiset concurrentHashMultiset) {
        this.this$0 = concurrentHashMultiset;
        super(concurrentHashMultiset);
    }

    @Override
    ConcurrentHashMultiset multiset() {
        return this.this$0;
    }

    @Override
    public Object[] toArray() {
        return this.snapshot().toArray();
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return this.snapshot().toArray(arrobject);
    }

    private List snapshot() {
        ArrayList arrayList = Lists.newArrayListWithExpectedSize(this.size());
        Iterators.addAll(arrayList, this.iterator());
        return arrayList;
    }

    /* synthetic */ ConcurrentHashMultiset$EntrySet(ConcurrentHashMultiset concurrentHashMultiset, ConcurrentHashMultiset$1 concurrentHashMultiset$1) {
        this(concurrentHashMultiset);
    }
}

