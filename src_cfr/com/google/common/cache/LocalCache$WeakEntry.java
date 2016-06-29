/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

class LocalCache$WeakEntry
extends WeakReference
implements LocalCache$ReferenceEntry {
    final int hash;
    final LocalCache$ReferenceEntry next;
    volatile LocalCache$ValueReference valueReference = LocalCache.unset();

    LocalCache$WeakEntry(ReferenceQueue referenceQueue, Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        super(object, referenceQueue);
        this.hash = n2;
        this.next = localCache$ReferenceEntry;
    }

    @Override
    public Object getKey() {
        return this.get();
    }

    @Override
    public long getAccessTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setAccessTime(long l2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalCache$ReferenceEntry getNextInAccessQueue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextInAccessQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPreviousInAccessQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getWriteTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWriteTime(long l2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalCache$ReferenceEntry getNextInWriteQueue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextInWriteQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPreviousInWriteQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalCache$ValueReference getValueReference() {
        return this.valueReference;
    }

    @Override
    public void setValueReference(LocalCache$ValueReference localCache$ValueReference) {
        this.valueReference = localCache$ValueReference;
    }

    @Override
    public int getHash() {
        return this.hash;
    }

    @Override
    public LocalCache$ReferenceEntry getNext() {
        return this.next;
    }
}

