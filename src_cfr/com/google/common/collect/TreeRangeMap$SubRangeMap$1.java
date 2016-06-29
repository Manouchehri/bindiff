/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Cut;
import com.google.common.collect.Iterators;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;

class TreeRangeMap$SubRangeMap$1
extends TreeRangeMap$SubRangeMap$SubRangeMapAsMap {
    final /* synthetic */ TreeRangeMap$SubRangeMap this$1;

    TreeRangeMap$SubRangeMap$1(TreeRangeMap$SubRangeMap treeRangeMap$SubRangeMap) {
        this.this$1 = treeRangeMap$SubRangeMap;
        super(treeRangeMap$SubRangeMap);
    }

    @Override
    Iterator entryIterator() {
        if (TreeRangeMap$SubRangeMap.access$200(this.this$1).isEmpty()) {
            return Iterators.emptyIterator();
        }
        Iterator iterator = TreeRangeMap.access$000(this.this$1.this$0).headMap(TreeRangeMap$SubRangeMap.access$200((TreeRangeMap$SubRangeMap)this.this$1).upperBound, false).descendingMap().values().iterator();
        return new TreeRangeMap$SubRangeMap$1$1(this, iterator);
    }
}

