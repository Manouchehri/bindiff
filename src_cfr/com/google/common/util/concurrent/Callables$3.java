/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;

final class Callables$3
implements Callable {
    final /* synthetic */ Supplier val$nameSupplier;
    final /* synthetic */ Callable val$callable;

    Callables$3(Supplier supplier, Callable callable) {
        this.val$nameSupplier = supplier;
        this.val$callable = callable;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object call() {
        Thread thread = Thread.currentThread();
        String string = thread.getName();
        boolean bl2 = Callables.access$000((String)this.val$nameSupplier.get(), thread);
        try {
            Object v2 = this.val$callable.call();
            return v2;
        }
        finally {
            if (bl2) {
                Callables.access$000(string, thread);
            }
        }
    }
}

