/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$WeakEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class LocalCache$EntryFactory$5
extends LocalCache$EntryFactory {
    LocalCache$EntryFactory$5(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    LocalCache$ReferenceEntry newEntry(LocalCache$Segment localCache$Segment, Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeakEntry(localCache$Segment.keyReferenceQueue, object, n2, localCache$ReferenceEntry);
    }
}

