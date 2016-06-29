/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$StrongEntry;
import javax.annotation.Nullable;

final class LocalCache$EntryFactory$1
extends LocalCache$EntryFactory {
    LocalCache$EntryFactory$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    LocalCache$ReferenceEntry newEntry(LocalCache.Segment segment, Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$StrongEntry(object, n2, localCache$ReferenceEntry);
    }
}

