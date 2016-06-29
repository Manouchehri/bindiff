package com.google.common.cache;

import javax.annotation.*;

enum LocalCache$EntryFactory$6
{
    LocalCache$EntryFactory$6(final String s, final int n) {
    }
    
    @Override
    LocalCache$ReferenceEntry newEntry(final LocalCache$Segment localCache$Segment, final Object o, final int n, @Nullable final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeakAccessEntry(localCache$Segment.keyReferenceQueue, o, n, localCache$ReferenceEntry);
    }
    
    @Override
    LocalCache$ReferenceEntry copyEntry(final LocalCache$Segment localCache$Segment, final LocalCache$ReferenceEntry localCache$ReferenceEntry, final LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        final LocalCache$ReferenceEntry copyEntry = super.copyEntry(localCache$Segment, localCache$ReferenceEntry, localCache$ReferenceEntry2);
        this.copyAccessEntry(localCache$ReferenceEntry, copyEntry);
        return copyEntry;
    }
}
