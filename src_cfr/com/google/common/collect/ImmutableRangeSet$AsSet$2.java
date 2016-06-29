/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableRangeSet$AsSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

class ImmutableRangeSet$AsSet$2
extends AbstractIterator {
    final Iterator rangeItr;
    Iterator elemItr;
    final /* synthetic */ ImmutableRangeSet$AsSet this$1;

    ImmutableRangeSet$AsSet$2(ImmutableRangeSet$AsSet immutableRangeSet$AsSet) {
        this.this$1 = immutableRangeSet$AsSet;
        this.rangeItr = ImmutableRangeSet.access$000(this.this$1.this$0).reverse().iterator();
        this.elemItr = Iterators.emptyIterator();
    }

    @Override
    protected Comparable computeNext() {
        while (!this.elemItr.hasNext()) {
            if (!this.rangeItr.hasNext()) return (Comparable)this.endOfData();
            this.elemItr = ContiguousSet.create((Range)this.rangeItr.next(), ImmutableRangeSet$AsSet.access$100(this.this$1)).descendingIterator();
        }
        return (Comparable)this.elemItr.next();
    }
}

