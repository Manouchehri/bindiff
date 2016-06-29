/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

enum CacheBuilder$NullListener implements RemovalListener
{
    INSTANCE;
    

    private CacheBuilder$NullListener() {
    }

    @Override
    public void onRemoval(RemovalNotification removalNotification) {
    }
}

