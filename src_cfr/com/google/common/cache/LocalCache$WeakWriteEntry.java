/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$WeakEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class LocalCache$WeakWriteEntry
extends LocalCache$WeakEntry {
    volatile long writeTime = Long.MAX_VALUE;
    LocalCache$ReferenceEntry nextWrite = LocalCache.nullEntry();
    LocalCache$ReferenceEntry previousWrite = LocalCache.nullEntry();

    LocalCache$WeakWriteEntry(ReferenceQueue referenceQueue, Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        super(referenceQueue, object, n2, localCache$ReferenceEntry);
    }

    @Override
    public long getWriteTime() {
        return this.writeTime;
    }

    @Override
    public void setWriteTime(long l2) {
        this.writeTime = l2;
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

