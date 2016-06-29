package com.google.common.collect;

import javax.annotation.*;

enum MapMakerInternalMap$EntryFactory
{
    STRONG("STRONG", 0), 
    STRONG_EXPIRABLE("STRONG_EXPIRABLE", 1), 
    STRONG_EVICTABLE("STRONG_EVICTABLE", 2), 
    STRONG_EXPIRABLE_EVICTABLE("STRONG_EXPIRABLE_EVICTABLE", 3), 
    WEAK("WEAK", 4), 
    WEAK_EXPIRABLE("WEAK_EXPIRABLE", 5), 
    WEAK_EVICTABLE("WEAK_EVICTABLE", 6), 
    WEAK_EXPIRABLE_EVICTABLE("WEAK_EXPIRABLE_EVICTABLE", 7);
    
    static final int EXPIRABLE_MASK = 1;
    static final int EVICTABLE_MASK = 2;
    static final MapMakerInternalMap$EntryFactory[][] factories;
    
    private MapMakerInternalMap$EntryFactory(final String s, final int n) {
    }
    
    static MapMakerInternalMap$EntryFactory getFactory(final MapMakerInternalMap$Strength mapMakerInternalMap$Strength, final boolean b, final boolean b2) {
        return MapMakerInternalMap$EntryFactory.factories[mapMakerInternalMap$Strength.ordinal()][(b ? 1 : 0) | (b2 ? 2 : 0)];
    }
    
    abstract MapMakerInternalMap$ReferenceEntry newEntry(final MapMakerInternalMap$Segment p0, final Object p1, final int p2, @Nullable final MapMakerInternalMap$ReferenceEntry p3);
    
    MapMakerInternalMap$ReferenceEntry copyEntry(final MapMakerInternalMap$Segment mapMakerInternalMap$Segment, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        return this.newEntry(mapMakerInternalMap$Segment, mapMakerInternalMap$ReferenceEntry.getKey(), mapMakerInternalMap$ReferenceEntry.getHash(), mapMakerInternalMap$ReferenceEntry2);
    }
    
    void copyExpirableEntry(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        mapMakerInternalMap$ReferenceEntry2.setExpirationTime(mapMakerInternalMap$ReferenceEntry.getExpirationTime());
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry.getPreviousExpirable(), mapMakerInternalMap$ReferenceEntry2);
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry.getNextExpirable());
        MapMakerInternalMap.nullifyExpirable(mapMakerInternalMap$ReferenceEntry);
    }
    
    void copyEvictableEntry(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry.getPreviousEvictable(), mapMakerInternalMap$ReferenceEntry2);
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry.getNextEvictable());
        MapMakerInternalMap.nullifyEvictable(mapMakerInternalMap$ReferenceEntry);
    }
    
    static {
        factories = new MapMakerInternalMap$EntryFactory[][] { { MapMakerInternalMap$EntryFactory.STRONG, MapMakerInternalMap$EntryFactory.STRONG_EXPIRABLE, MapMakerInternalMap$EntryFactory.STRONG_EVICTABLE, MapMakerInternalMap$EntryFactory.STRONG_EXPIRABLE_EVICTABLE }, new MapMakerInternalMap$EntryFactory[0], { MapMakerInternalMap$EntryFactory.WEAK, MapMakerInternalMap$EntryFactory.WEAK_EXPIRABLE, MapMakerInternalMap$EntryFactory.WEAK_EVICTABLE, MapMakerInternalMap$EntryFactory.WEAK_EXPIRABLE_EVICTABLE } };
    }
}
