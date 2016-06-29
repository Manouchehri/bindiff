package com.google.common.collect;

import java.util.*;

class AbstractTable$1 extends TransformedIterator
{
    final /* synthetic */ AbstractTable this$0;
    
    AbstractTable$1(final AbstractTable this$0, final Iterator iterator) {
        this.this$0 = this$0;
        super(iterator);
    }
    
    Object transform(final Table$Cell table$Cell) {
        return table$Cell.getValue();
    }
}
