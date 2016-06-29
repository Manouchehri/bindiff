/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;

final class Callables$4
implements Runnable {
    final /* synthetic */ Supplier val$nameSupplier;
    final /* synthetic */ Runnable val$task;

    Callables$4(Supplier supplier, Runnable runnable) {
        this.val$nameSupplier = supplier;
        this.val$task = runnable;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String string = thread.getName();
        boolean bl2 = Callables.access$000((String)this.val$nameSupplier.get(), thread);
        try {
            this.val$task.run();
            return;
        }
        finally {
            if (bl2) {
                Callables.access$000(string, thread);
            }
        }
    }
}

