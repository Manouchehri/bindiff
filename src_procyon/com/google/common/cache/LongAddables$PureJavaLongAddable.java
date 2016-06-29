package com.google.common.cache;

import java.util.concurrent.atomic.*;

final class LongAddables$PureJavaLongAddable extends AtomicLong implements LongAddable
{
    @Override
    public void increment() {
        this.getAndIncrement();
    }
    
    @Override
    public void add(final long n) {
        this.getAndAdd(n);
    }
    
    @Override
    public long sum() {
        return this.get();
    }
}
