/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

final class IncrementableCountDownLatch$Sync
extends AbstractQueuedSynchronizer {
    private static final long serialVersionUID = 0;

    IncrementableCountDownLatch$Sync(int n2) {
        this.setState(n2);
    }

    int getCount() {
        return this.getState();
    }

    @Override
    public int tryAcquireShared(int n2) {
        if (this.getState() != 0) return -1;
        return 1;
    }

    @Override
    public boolean tryReleaseShared(int n2) {
        int n3;
        int n4;
        do {
            if ((n3 = this.getState()) == 0) {
                return false;
            }
            if (n2 <= n3) continue;
            return false;
        } while (!this.compareAndSetState(n3, n4 = n3 - n2));
        if (n4 != 0) return false;
        return true;
    }

    void increaseCount(int n2) {
        int n3;
        int n4;
        do {
            n3 = this.getState();
            n4 = n3 + n2;
            if (n3 == 0) {
                throw new IllegalStateException("already counted down to zero");
            }
            if (n4 >= n3) continue;
            throw new IllegalArgumentException("count overflow");
        } while (!this.compareAndSetState(n3, n4));
    }
}

