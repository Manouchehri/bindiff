/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.RegularContiguousSet;

class RegularContiguousSet$1
extends AbstractSequentialIterator {
    final Comparable last;
    final /* synthetic */ RegularContiguousSet this$0;

    RegularContiguousSet$1(RegularContiguousSet regularContiguousSet, Comparable comparable) {
        this.this$0 = regularContiguousSet;
        super(comparable);
        this.last = this.this$0.last();
    }

    protected Comparable computeNext(Comparable comparable) {
        if (RegularContiguousSet.access$000(comparable, this.last)) {
            return null;
        }
        Comparable comparable2 = this.this$0.domain.next(comparable);
        return comparable2;
    }
}

