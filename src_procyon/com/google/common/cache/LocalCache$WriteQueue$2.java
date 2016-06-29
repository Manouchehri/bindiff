package com.google.common.cache;

import com.google.common.collect.*;

class LocalCache$WriteQueue$2 extends AbstractSequentialIterator
{
    final /* synthetic */ LocalCache$WriteQueue this$0;
    
    LocalCache$WriteQueue$2(final LocalCache$WriteQueue this$0, final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.this$0 = this$0;
        super(localCache$ReferenceEntry);
    }
    
    protected LocalCache$ReferenceEntry computeNext(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        final LocalCache$ReferenceEntry nextInWriteQueue = localCache$ReferenceEntry.getNextInWriteQueue();
        return (nextInWriteQueue == this.this$0.head) ? null : nextInWriteQueue;
    }
}
