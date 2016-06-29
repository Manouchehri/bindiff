/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$2;

class Futures$2$1
implements Runnable {
    final /* synthetic */ Runnable val$command;
    final /* synthetic */ Futures$2 this$0;

    Futures$2$1(Futures$2 var1_1, Runnable runnable) {
        this.this$0 = var1_1;
        this.val$command = runnable;
    }

    @Override
    public void run() {
        this.this$0.thrownFromDelegate = false;
        this.val$command.run();
    }
}

