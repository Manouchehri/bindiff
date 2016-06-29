/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$WriteQueue;

class LocalCache$WriteQueue$1
extends LocalCache$AbstractReferenceEntry {
    LocalCache$ReferenceEntry nextWrite;
    LocalCache$ReferenceEntry previousWrite;
    final /* synthetic */ LocalCache$WriteQueue this$0;

    LocalCache$WriteQueue$1(LocalCache$WriteQueue localCache$WriteQueue) {
        this.this$0 = localCache$WriteQueue;
        this.nextWrite = this;
        this.previousWrite = this;
    }

    @Override
    public long getWriteTime() {
        return Long.MAX_VALUE;
    }

    @Override
    public void setWriteTime(long l2) {
    }

    @Override
    public LocalCache$ReferenceEntry getNextInWriteQueue() {
        return this.nextWrite;
    }

    @Override
    public void setNextInWriteQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.nextWrite = localCache$ReferenceEntry;
    }

    @Override
    public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
        return this.previousWrite;
    }

    @Override
    public void setPreviousInWriteQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.previousWrite = localCache$ReferenceEntry;
    }
}

