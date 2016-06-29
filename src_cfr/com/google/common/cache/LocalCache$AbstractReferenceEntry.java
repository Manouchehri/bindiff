/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;

abstract class LocalCache$AbstractReferenceEntry
implements LocalCache$ReferenceEntry {
    LocalCache$AbstractReferenceEntry() {
    }

    @Override
    public LocalCache$ValueReference getValueReference() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValueReference(LocalCache$ValueReference localCache$ValueReference) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalCache$ReferenceEntry getNext() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getHash() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getKey() {
        throw new UnsupportedOperationException();
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
}

