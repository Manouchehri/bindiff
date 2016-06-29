package com.google.common.base;

import java.util.*;

class Optional$1$1 extends AbstractIterator
{
    private final Iterator iterator;
    final /* synthetic */ Optional$1 this$0;
    
    Optional$1$1(final Optional$1 this$0) {
        this.this$0 = this$0;
        this.iterator = (Iterator)Preconditions.checkNotNull(this.this$0.val$optionals.iterator());
    }
    
    @Override
    protected Object computeNext() {
        while (this.iterator.hasNext()) {
            final Optional optional = this.iterator.next();
            if (optional.isPresent()) {
                return optional.get();
            }
        }
        return this.endOfData();
    }
}
