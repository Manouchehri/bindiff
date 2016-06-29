package com.google.common.cache;

import com.google.common.collect.*;

class LocalCache$AccessQueue$2 extends AbstractSequentialIterator
{
    final /* synthetic */ LocalCache$AccessQueue this$0;
    
    LocalCache$AccessQueue$2(final LocalCache$AccessQueue this$0, final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.this$0 = this$0;
        super(localCache$ReferenceEntry);
    }
    
    protected LocalCache$ReferenceEntry computeNext(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        final LocalCache$ReferenceEntry nextInAccessQueue = localCache$ReferenceEntry.getNextInAccessQueue();
        return (nextInAccessQueue == this.this$0.head) ? null : nextInAccessQueue;
    }
}
