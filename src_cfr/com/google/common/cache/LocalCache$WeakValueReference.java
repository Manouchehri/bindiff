/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class LocalCache$WeakValueReference
extends WeakReference
implements LocalCache$ValueReference {
    final LocalCache$ReferenceEntry entry;

    LocalCache$WeakValueReference(ReferenceQueue referenceQueue, Object object, LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        super(object, referenceQueue);
        this.entry = localCache$ReferenceEntry;
    }

    @Override
    public int getWeight() {
        return 1;
    }

    @Override
    public LocalCache$ReferenceEntry getEntry() {
        return this.entry;
    }

    @Override
    public void notifyNewValue(Object object) {
    }

    @Override
    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeakValueReference(referenceQueue, object, localCache$ReferenceEntry);
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
}

