package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Queue;

@GwtCompatible
class ConsumingQueueIterator extends AbstractIterator {
   private final Queue queue;

   ConsumingQueueIterator(Object... var1) {
      this.queue = Lists.newLinkedList();
      Collections.addAll(this.queue, var1);
   }

   ConsumingQueueIterator(Queue var1) {
      this.queue = (Queue)Preconditions.checkNotNull(var1);
   }

   public Object computeNext() {
      return this.queue.isEmpty()?this.endOfData():this.queue.remove();
   }
}
