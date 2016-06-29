package com.google.common.cache;

import javax.annotation.*;

enum LocalCache$EntryFactory$5
{
    LocalCache$EntryFactory$5(final String s, final int n) {
    }
    
    @Override
    LocalCache$ReferenceEntry newEntry(final LocalCache$Segment localCache$Segment, final Object o, final int n, @Nullable final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeakEntry(localCache$Segment.keyReferenceQueue, o, n, localCache$ReferenceEntry);
    }
}
