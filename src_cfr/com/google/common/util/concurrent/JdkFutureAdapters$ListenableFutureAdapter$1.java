/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter;
import com.google.common.util.concurrent.Uninterruptibles;

class JdkFutureAdapters$ListenableFutureAdapter$1
implements Runnable {
    final /* synthetic */ JdkFutureAdapters$ListenableFutureAdapter this$0;

    JdkFutureAdapters$ListenableFutureAdapter$1(JdkFutureAdapters$ListenableFutureAdapter listenableFutureAdapter) {
        this.this$0 = listenableFutureAdapter;
    }

    @Override
    public void run() {
        try {
            Uninterruptibles.getUninterruptibly(JdkFutureAdapters$ListenableFutureAdapter.access$000(this.this$0));
        }
        catch (Error var1_1) {
            throw var1_1;
        }
        catch (Throwable var1_2) {
            // empty catch block
        }
        JdkFutureAdapters$ListenableFutureAdapter.access$100(this.this$0).execute();
    }
}

