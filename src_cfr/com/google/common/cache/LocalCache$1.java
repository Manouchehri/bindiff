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
import javax.annotation.Nullable;

final class LocalCache$1
implements LocalCache$ValueReference {
    LocalCache$1() {
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public LocalCache.ReferenceEntry getEntry() {
        return null;
    }

    @Override
    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, @Nullable Object object, LocalCache.ReferenceEntry referenceEntry) {
        return this;
    }

    @Override
    public boolean isLoading() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public Object waitForValue() {
        return null;
    }

    @Override
    public void notifyNewValue(Object object) {
    }
}

