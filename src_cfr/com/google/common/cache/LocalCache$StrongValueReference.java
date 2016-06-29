/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;

class LocalCache$StrongValueReference
implements LocalCache$ValueReference {
    final Object referent;

    LocalCache$StrongValueReference(Object object) {
        this.referent = object;
    }

    @Override
    public Object get() {
        return this.referent;
    }

    @Override
    public int getWeight() {
        return 1;
    }

    @Override
    public LocalCache$ReferenceEntry getEntry() {
        return null;
    }

    @Override
    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return this;
    }

    @Override
    public boolean isLoading() {
        return false;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public Object waitForValue() {
        return this.get();
    }

    @Override
    public void notifyNewValue(Object object) {
    }
}

