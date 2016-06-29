/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2
extends Maps$EntrySet {
    final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

    TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap) {
        this.this$2 = treeRangeMap$SubRangeMap$SubRangeMapAsMap;
    }

    @Override
    Map map() {
        return this.this$2;
    }

    @Override
    public Iterator iterator() {
        return this.this$2.entryIterator();
    }

    @Override
    public boolean retainAll(Collection collection) {
        return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$300(this.this$2, Predicates.not(Predicates.in(collection)));
    }

    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }

    @Override
    public boolean isEmpty() {
        if (this.iterator().hasNext()) return false;
        return true;
    }
}

