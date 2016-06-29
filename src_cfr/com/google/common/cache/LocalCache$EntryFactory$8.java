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
import com.google.common.cache.LocalCache$WeakAccessWriteEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class LocalCache$EntryFactory$8
extends LocalCache$EntryFactory {
    LocalCache$EntryFactory$8(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    LocalCache$ReferenceEntry newEntry(LocalCache$Segment localCache$Segment, Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeakAccessWriteEntry(localCache$Segment.keyReferenceQueue, object, n2, localCache$ReferenceEntry);
    }

    @Override
    LocalCache$ReferenceEntry copyEntry(LocalCache$Segment localCache$Segment, LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = super.copyEntry(localCache$Segment, localCache$ReferenceEntry, localCache$ReferenceEntry2);
        this.copyAccessEntry(localCache$ReferenceEntry, localCache$ReferenceEntry3);
        this.copyWriteEntry(localCache$ReferenceEntry, localCache$ReferenceEntry3);
        return localCache$ReferenceEntry3;
    }
}

