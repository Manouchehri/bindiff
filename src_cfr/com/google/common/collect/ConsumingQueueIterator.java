/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Queue;

@GwtCompatible
class ConsumingQueueIterator
extends AbstractIterator {
    private final Queue queue;

    /* varargs */ ConsumingQueueIterator(Object ... arrobject) {
        this.queue = Lists.newLinkedList();
        Collections.addAll(this.queue, arrobject);
    }

    ConsumingQueueIterator(Queue queue) {
        this.queue = (Queue)Preconditions.checkNotNull(queue);
    }

    @Override
    public Object computeNext() {
        Object object;
        if (this.queue.isEmpty()) {
            object = this.endOfData();
            return object;
        }
        object = this.queue.remove();
        return object;
    }
}

