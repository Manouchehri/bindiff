/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.RegularContiguousSet;

class RegularContiguousSet$2
extends AbstractSequentialIterator {
    final Comparable first;
    final /* synthetic */ RegularContiguousSet this$0;

    RegularContiguousSet$2(RegularContiguousSet regularContiguousSet, Comparable comparable) {
        this.this$0 = regularContiguousSet;
        super(comparable);
        this.first = this.this$0.first();
    }

    protected Comparable computeNext(Comparable comparable) {
        if (RegularContiguousSet.access$000(comparable, this.first)) {
            return null;
        }
        Comparable comparable2 = this.this$0.domain.previous(comparable);
        return comparable2;
    }
}

