/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.RemovalNotification;

@GwtCompatible
public interface RemovalListener {
    public void onRemoval(RemovalNotification var1);
}

