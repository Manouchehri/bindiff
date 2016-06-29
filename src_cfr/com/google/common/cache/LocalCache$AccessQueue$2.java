/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.collect.AbstractSequentialIterator;

class LocalCache$AccessQueue$2
extends AbstractSequentialIterator {
    final /* synthetic */ LocalCache$AccessQueue this$0;

    LocalCache$AccessQueue$2(LocalCache$AccessQueue localCache$AccessQueue, LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.this$0 = localCache$AccessQueue;
        super(localCache$ReferenceEntry);
    }

    protected LocalCache$ReferenceEntry computeNext(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry.getNextInAccessQueue();
        if (localCache$ReferenceEntry2 == this.this$0.head) {
            return null;
        }
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = localCache$ReferenceEntry2;
        return localCache$ReferenceEntry3;
    }
}

