/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

interface LocalCache$ValueReference {
    @Nullable
    public Object get();

    public Object waitForValue();

    public int getWeight();

    @Nullable
    public LocalCache$ReferenceEntry getEntry();

    public LocalCache$ValueReference copyFor(ReferenceQueue var1, @Nullable Object var2, LocalCache$ReferenceEntry var3);

    public void notifyNewValue(@Nullable Object var1);

    public boolean isLoading();

    public boolean isActive();
}

