/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@GwtCompatible(emulated=1)
abstract class InterruptibleTask
implements Runnable {
    private static final AtomicReferenceFieldUpdater RUNNER = AtomicReferenceFieldUpdater.newUpdater(InterruptibleTask.class, Thread.class, "runner");
    private volatile Thread runner;
    private volatile boolean doneInterrupting;

    InterruptibleTask() {
    }

    @Override
    public final void run() {
        if (!RUNNER.compareAndSet(this, null, Thread.currentThread())) {
            return;
        }
        try {
            this.runInterruptibly();
            return;
        }
        finally {
            if (this.wasInterrupted()) {
                while (!this.doneInterrupting) {
                    Thread.yield();
                }
            }
        }
    }

    abstract void runInterruptibly();

    abstract boolean wasInterrupted();

    final void interruptTask() {
        Thread thread = this.runner;
        if (thread != null) {
            thread.interrupt();
        }
        this.doneInterrupting = true;
    }
}

