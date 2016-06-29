package com.google.common.cache;

import javax.annotation.*;

enum LocalCache$EntryFactory$1
{
    LocalCache$EntryFactory$1(final String s, final int n) {
    }
    
    @Override
    LocalCache$ReferenceEntry newEntry(final LocalCache$Segment localCache$Segment, final Object o, final int n, @Nullable final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$StrongEntry(o, n, localCache$ReferenceEntry);
    }
}
