/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import javax.annotation.Nullable;

class LocalCache$StrongEntry
extends LocalCache$AbstractReferenceEntry {
    final Object key;
    final int hash;
    final LocalCache$ReferenceEntry next;
    volatile LocalCache$ValueReference valueReference = LocalCache.unset();

    LocalCache$StrongEntry(Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.key = object;
        this.hash = n2;
        this.next = localCache$ReferenceEntry;
    }

    @Override
    public Object getKey() {
        return this.key;
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

