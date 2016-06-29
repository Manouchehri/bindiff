package com.google.common.cache;

public final class AbstractCache$SimpleStatsCounter implements AbstractCache$StatsCounter
{
    private final LongAddable hitCount;
    private final LongAddable missCount;
    private final LongAddable loadSuccessCount;
    private final LongAddable loadExceptionCount;
    private final LongAddable totalLoadTime;
    private final LongAddable evictionCount;
    
    public AbstractCache$SimpleStatsCounter() {
        this.hitCount = LongAddables.create();
        this.missCount = LongAddables.create();
        this.loadSuccessCount = LongAddables.create();
        this.loadExceptionCount = LongAddables.create();
        this.totalLoadTime = LongAddables.create();
        this.evictionCount = LongAddables.create();
    }
    
    @Override
    public void recordHits(final int n) {
        this.hitCount.add(n);
    }
    
    @Override
    public void recordMisses(final int n) {
        this.missCount.add(n);
    }
    
    @Override
    public void recordLoadSuccess(final long n) {
        this.loadSuccessCount.increment();
        this.totalLoadTime.add(n);
    }
    
    @Override
    public void recordLoadException(final long n) {
        this.loadExceptionCount.increment();
        this.totalLoadTime.add(n);
    }
    
    @Override
    public void recordEviction() {
        this.evictionCount.increment();
    }
    
    @Override
    public CacheStats snapshot() {
        return new CacheStats(this.hitCount.sum(), this.missCount.sum(), this.loadSuccessCount.sum(), this.loadExceptionCount.sum(), this.totalLoadTime.sum(), this.evictionCount.sum());
    }
    
    public void incrementBy(final AbstractCache$StatsCounter abstractCache$StatsCounter) {
        final CacheStats snapshot = abstractCache$StatsCounter.snapshot();
        this.hitCount.add(snapshot.hitCount());
        this.missCount.add(snapshot.missCount());
        this.loadSuccessCount.add(snapshot.loadSuccessCount());
        this.loadExceptionCount.add(snapshot.loadExceptionCount());
        this.totalLoadTime.add(snapshot.totalLoadTime());
        this.evictionCount.add(snapshot.evictionCount());
    }
}
