/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.WrappingExecutorService;
import java.util.concurrent.Callable;

class WrappingExecutorService$1
implements Runnable {
    final /* synthetic */ Callable val$wrapped;
    final /* synthetic */ WrappingExecutorService this$0;

    WrappingExecutorService$1(WrappingExecutorService wrappingExecutorService, Callable callable) {
        this.this$0 = wrappingExecutorService;
        this.val$wrapped = callable;
    }

    @Override
    public void run() {
        try {
            this.val$wrapped.call();
            return;
        }
        catch (Exception var1_1) {
            Throwables.propagate(var1_1);
        }
    }
}

