/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$HashIterator;
import com.google.common.cache.LocalCache$WriteThroughEntry;

final class LocalCache$KeyIterator
extends LocalCache$HashIterator {
    final /* synthetic */ LocalCache this$0;

    LocalCache$KeyIterator(LocalCache localCache) {
        this.this$0 = localCache;
        super(localCache);
    }

    @Override
    public Object next() {
        return this.nextEntry().getKey();
    }
}

