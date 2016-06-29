/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;

enum LocalCache$NullEntry implements LocalCache$ReferenceEntry
{
    INSTANCE;
    

    private LocalCache$NullEntry() {
    }

    @Override
    public LocalCache$ValueReference getValueReference() {
        return null;
    }

    @Override
    public void setValueReference(LocalCache$ValueReference localCache$ValueReference) {
    }

    @Override
    public LocalCache$ReferenceEntry getNext() {
        return null;
    }

    @Override
    public int getHash() {
        return 0;
    }

    @Override
    public Object getKey() {
        return null;
    }

    @Override
    public long getAccessTime() {
        return 0;
    }

    @Override
    public void setAccessTime(long l2) {
    }

    @Override
    public LocalCache$ReferenceEntry getNextInAccessQueue() {
        return this;
    }

    @Override
    public void setNextInAccessQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
    }

    @Override
    public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
        return this;
    }

    @Override
    public void setPreviousInAccessQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
    }

    @Override
    public long getWriteTime() {
        return 0;
    }

    @Override
    public void setWriteTime(long l2) {
    }

    @Override
    public LocalCache$ReferenceEntry getNextInWriteQueue() {
        return this;
    }

    @Override
    public void setNextInWriteQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
    }

    @Override
    public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
        return this;
    }

    @Override
    public void setPreviousInWriteQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
    }
}

