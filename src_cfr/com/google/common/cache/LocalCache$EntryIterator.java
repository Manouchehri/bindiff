/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$HashIterator;
import com.google.common.cache.LocalCache$WriteThroughEntry;
import java.util.Map;

final class LocalCache$EntryIterator
extends LocalCache$HashIterator {
    final /* synthetic */ LocalCache this$0;

    LocalCache$EntryIterator(LocalCache localCache) {
        this.this$0 = localCache;
        super(localCache);
    }

    @Override
    public Map.Entry next() {
        return this.nextEntry();
    }
}

