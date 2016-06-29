package com.google.common.cache;

public interface AbstractCache$StatsCounter
{
    void recordHits(final int p0);
    
    void recordMisses(final int p0);
    
    void recordLoadSuccess(final long p0);
    
    void recordLoadException(final long p0);
    
    void recordEviction();
    
    CacheStats snapshot();
}
