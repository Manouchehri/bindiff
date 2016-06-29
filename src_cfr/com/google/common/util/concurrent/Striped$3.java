/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$PaddedSemaphore;
import java.util.concurrent.Semaphore;

final class Striped$3
implements Supplier {
    final /* synthetic */ int val$permits;

    Striped$3(int n2) {
        this.val$permits = n2;
    }

    @Override
    public Semaphore get() {
        return new Striped$PaddedSemaphore(this.val$permits);
    }
}

