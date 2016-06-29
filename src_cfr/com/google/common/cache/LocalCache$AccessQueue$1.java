/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.LocalCache$ReferenceEntry;

class LocalCache$AccessQueue$1
extends LocalCache$AbstractReferenceEntry {
    LocalCache$ReferenceEntry nextAccess;
    LocalCache$ReferenceEntry previousAccess;
    final /* synthetic */ LocalCache.AccessQueue this$0;

    LocalCache$AccessQueue$1(LocalCache.AccessQueue accessQueue) {
        this.this$0 = accessQueue;
        this.nextAccess = this;
        this.previousAccess = this;
    }

    @Override
    public long getAccessTime() {
        return Long.MAX_VALUE;
    }

    @Override
    public void setAccessTime(long l2) {
    }

    @Override
    public LocalCache$ReferenceEntry getNextInAccessQueue() {
        return this.nextAccess;
    }

    @Override
    public void setNextInAccessQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.nextAccess = localCache$ReferenceEntry;
    }

    @Override
    public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
        return this.previousAccess;
    }

    @Override
    public void setPreviousInAccessQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.previousAccess = localCache$ReferenceEntry;
    }
}

