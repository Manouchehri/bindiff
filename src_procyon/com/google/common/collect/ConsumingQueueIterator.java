package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;

@GwtCompatible
class ConsumingQueueIterator extends AbstractIterator
{
    private final Queue queue;
    
    ConsumingQueueIterator(final Object... array) {
        Collections.addAll(this.queue = Lists.newLinkedList(), array);
    }
    
    ConsumingQueueIterator(final Queue queue) {
        this.queue = (Queue)Preconditions.checkNotNull(queue);
    }
    
    public Object computeNext() {
        return this.queue.isEmpty() ? this.endOfData() : this.queue.remove();
    }
}
