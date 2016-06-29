package com.google.common.util.concurrent;

import java.util.concurrent.locks.*;

final class IncrementableCountDownLatch$Sync extends AbstractQueuedSynchronizer
{
    private static final long serialVersionUID = 0L;
    
    IncrementableCountDownLatch$Sync(final int state) {
        this.setState(state);
    }
    
    int getCount() {
        return this.getState();
    }
    
    public int tryAcquireShared(final int n) {
        return (this.getState() == 0) ? 1 : -1;
    }
    
    public boolean tryReleaseShared(final int n) {
        while (true) {
            final int state = this.getState();
            if (state == 0) {
                return false;
            }
            if (n > state) {
                return false;
            }
            final int n2 = state - n;
            if (this.compareAndSetState(state, n2)) {
                return n2 == 0;
            }
        }
    }
    
    void increaseCount(final int n) {
        while (true) {
            final int state = this.getState();
            final int n2 = state + n;
            if (state == 0) {
                throw new IllegalStateException("already counted down to zero");
            }
            if (n2 < state) {
                throw new IllegalArgumentException("count overflow");
            }
            if (this.compareAndSetState(state, n2)) {
                return;
            }
        }
    }
}
