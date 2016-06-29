/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Map;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4
extends Maps$Values {
    final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

    TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4(TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap, Map map) {
        this.this$2 = treeRangeMap$SubRangeMap$SubRangeMapAsMap;
        super(map);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.in(collection), Maps.valueFunction()));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.valueFunction()));
    }
}

