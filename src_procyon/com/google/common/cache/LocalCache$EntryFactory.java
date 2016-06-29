package com.google.common.cache;

import javax.annotation.*;

enum LocalCache$EntryFactory
{
    STRONG("STRONG", 0), 
    STRONG_ACCESS("STRONG_ACCESS", 1), 
    STRONG_WRITE("STRONG_WRITE", 2), 
    STRONG_ACCESS_WRITE("STRONG_ACCESS_WRITE", 3), 
    WEAK("WEAK", 4), 
    WEAK_ACCESS("WEAK_ACCESS", 5), 
    WEAK_WRITE("WEAK_WRITE", 6), 
    WEAK_ACCESS_WRITE("WEAK_ACCESS_WRITE", 7);
    
    static final int ACCESS_MASK = 1;
    static final int WRITE_MASK = 2;
    static final int WEAK_MASK = 4;
    static final LocalCache$EntryFactory[] factories;
    
    private LocalCache$EntryFactory(final String s, final int n) {
    }
    
    static LocalCache$EntryFactory getFactory(final LocalCache$Strength localCache$Strength, final boolean b, final boolean b2) {
        return LocalCache$EntryFactory.factories[((localCache$Strength == LocalCache$Strength.WEAK) ? 4 : 0) | (b ? 1 : 0) | (b2 ? 2 : 0)];
    }
    
    abstract LocalCache$ReferenceEntry newEntry(final LocalCache$Segment p0, final Object p1, final int p2, @Nullable final LocalCache$ReferenceEntry p3);
    
    LocalCache$ReferenceEntry copyEntry(final LocalCache$Segment localCache$Segment, final LocalCache$ReferenceEntry localCache$ReferenceEntry, final LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        return this.newEntry(localCache$Segment, localCache$ReferenceEntry.getKey(), localCache$ReferenceEntry.getHash(), localCache$ReferenceEntry2);
    }
    
    void copyAccessEntry(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        localCache$ReferenceEntry2.setAccessTime(localCache$ReferenceEntry.getAccessTime());
        LocalCache.connectAccessOrder(localCache$ReferenceEntry.getPreviousInAccessQueue(), localCache$ReferenceEntry2);
        LocalCache.connectAccessOrder(localCache$ReferenceEntry2, localCache$ReferenceEntry.getNextInAccessQueue());
        LocalCache.nullifyAccessOrder(localCache$ReferenceEntry);
    }
    
    void copyWriteEntry(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        localCache$ReferenceEntry2.setWriteTime(localCache$ReferenceEntry.getWriteTime());
        LocalCache.connectWriteOrder(localCache$ReferenceEntry.getPreviousInWriteQueue(), localCache$ReferenceEntry2);
        LocalCache.connectWriteOrder(localCache$ReferenceEntry2, localCache$ReferenceEntry.getNextInWriteQueue());
        LocalCache.nullifyWriteOrder(localCache$ReferenceEntry);
    }
    
    static {
        factories = new LocalCache$EntryFactory[] { LocalCache$EntryFactory.STRONG, LocalCache$EntryFactory.STRONG_ACCESS, LocalCache$EntryFactory.STRONG_WRITE, LocalCache$EntryFactory.STRONG_ACCESS_WRITE, LocalCache$EntryFactory.WEAK, LocalCache$EntryFactory.WEAK_ACCESS, LocalCache$EntryFactory.WEAK_WRITE, LocalCache$EntryFactory.WEAK_ACCESS_WRITE };
    }
}
