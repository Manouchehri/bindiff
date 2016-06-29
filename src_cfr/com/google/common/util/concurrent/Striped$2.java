/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class Striped$2
implements Supplier {
    Striped$2() {
    }

    @Override
    public Lock get() {
        return new ReentrantLock(false);
    }
}

