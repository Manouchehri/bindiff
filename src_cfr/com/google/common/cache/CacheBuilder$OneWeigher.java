/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.Weigher;

enum CacheBuilder$OneWeigher implements Weigher
{
    INSTANCE;
    

    private CacheBuilder$OneWeigher() {
    }

    @Override
    public int weigh(Object object, Object object2) {
        return 1;
    }
}

