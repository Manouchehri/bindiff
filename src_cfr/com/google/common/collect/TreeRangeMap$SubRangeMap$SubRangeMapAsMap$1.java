/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1
extends Maps$KeySet {
    final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

    TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap, Map map) {
        this.this$2 = treeRangeMap$SubRangeMap$SubRangeMapAsMap;
        super(map);
    }

    @Override
    public boolean remove(@Nullable Object object) {
        if (this.this$2.remove(object) == null) return false;
        return true;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.keyFunction()));
    }
}

