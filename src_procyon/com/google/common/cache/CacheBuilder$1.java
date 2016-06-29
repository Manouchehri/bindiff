package com.google.common.cache;

final class CacheBuilder$1 implements AbstractCache$StatsCounter
{
    @Override
    public void recordHits(final int n) {
    }
    
    @Override
    public void recordMisses(final int n) {
    }
    
    @Override
    public void recordLoadSuccess(final long n) {
    }
    
    @Override
    public void recordLoadException(final long n) {
    }
    
    @Override
    public void recordEviction() {
    }
    
    @Override
    public CacheStats snapshot() {
        return CacheBuilder.EMPTY_STATS;
    }
}
