package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.atomic.*;

@GwtCompatible(emulated = true)
abstract class InterruptibleTask implements Runnable
{
    private static final AtomicReferenceFieldUpdater RUNNER;
    private volatile Thread runner;
    private volatile boolean doneInterrupting;
    
    @Override
    public final void run() {
        if (!InterruptibleTask.RUNNER.compareAndSet(this, null, Thread.currentThread())) {
            return;
        }
        try {
            this.runInterruptibly();
            if (this.wasInterrupted()) {
                while (!this.doneInterrupting) {
                    Thread.yield();
                }
            }
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
        final Thread runner = this.runner;
        if (runner != null) {
            runner.interrupt();
        }
        this.doneInterrupting = true;
    }
    
    static {
        RUNNER = AtomicReferenceFieldUpdater.newUpdater(InterruptibleTask.class, Thread.class, "runner");
    }
}
