package com.google.common.collect;

import java.io.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.primitives.*;
import com.google.common.annotations.*;

class ImmutableRangeSet$AsSet$2 extends AbstractIterator
{
    final Iterator rangeItr;
    Iterator elemItr;
    final /* synthetic */ ImmutableRangeSet$AsSet this$1;
    
    ImmutableRangeSet$AsSet$2(final ImmutableRangeSet$AsSet this$1) {
        this.this$1 = this$1;
        this.rangeItr = this.this$1.this$0.ranges.reverse().iterator();
        this.elemItr = Iterators.emptyIterator();
    }
    
    @Override
    protected Comparable computeNext() {
        while (!this.elemItr.hasNext()) {
            if (!this.rangeItr.hasNext()) {
                return (Comparable)this.endOfData();
            }
            this.elemItr = ContiguousSet.create(this.rangeItr.next(), this.this$1.domain).descendingIterator();
        }
        return this.elemItr.next();
    }
}
