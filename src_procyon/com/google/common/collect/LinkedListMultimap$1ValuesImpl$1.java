package com.google.common.collect;

import java.util.*;

class LinkedListMultimap$1ValuesImpl$1 extends TransformedListIterator
{
    final /* synthetic */ LinkedListMultimap$NodeIterator val$nodeItr;
    final /* synthetic */ LinkedListMultimap$1ValuesImpl this$1;
    
    LinkedListMultimap$1ValuesImpl$1(final LinkedListMultimap$1ValuesImpl this$1, final ListIterator listIterator, final LinkedListMultimap$NodeIterator val$nodeItr) {
        this.this$1 = this$1;
        this.val$nodeItr = val$nodeItr;
        super(listIterator);
    }
    
    Object transform(final Map.Entry entry) {
        return entry.getValue();
    }
    
    @Override
    public void set(final Object value) {
        this.val$nodeItr.setValue(value);
    }
}
