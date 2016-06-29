package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

class RegularContiguousSet$1 extends AbstractSequentialIterator
{
    final Comparable last;
    final /* synthetic */ RegularContiguousSet this$0;
    
    RegularContiguousSet$1(final RegularContiguousSet this$0, final Comparable comparable) {
        this.this$0 = this$0;
        super(comparable);
        this.last = this.this$0.last();
    }
    
    protected Comparable computeNext(final Comparable comparable) {
        return equalsOrThrow(comparable, this.last) ? null : this.this$0.domain.next(comparable);
    }
}
