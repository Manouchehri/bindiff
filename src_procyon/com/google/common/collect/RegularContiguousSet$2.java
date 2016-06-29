package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

class RegularContiguousSet$2 extends AbstractSequentialIterator
{
    final Comparable first;
    final /* synthetic */ RegularContiguousSet this$0;
    
    RegularContiguousSet$2(final RegularContiguousSet this$0, final Comparable comparable) {
        this.this$0 = this$0;
        super(comparable);
        this.first = this.this$0.first();
    }
    
    protected Comparable computeNext(final Comparable comparable) {
        return equalsOrThrow(comparable, this.first) ? null : this.this$0.domain.previous(comparable);
    }
}
