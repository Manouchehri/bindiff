/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$WriteQueue;
import com.google.common.collect.AbstractSequentialIterator;

class LocalCache$WriteQueue$2
extends AbstractSequentialIterator {
    final /* synthetic */ LocalCache$WriteQueue this$0;

    LocalCache$WriteQueue$2(LocalCache$WriteQueue localCache$WriteQueue, LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.this$0 = localCache$WriteQueue;
        super(localCache$ReferenceEntry);
    }

    protected LocalCache$ReferenceEntry computeNext(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry.getNextInWriteQueue();
        if (localCache$ReferenceEntry2 == this.this$0.head) {
            return null;
        }
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = localCache$ReferenceEntry2;
        return localCache$ReferenceEntry3;
    }
}

