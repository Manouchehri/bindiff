/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.ListenableFuture;

class AggregateFuture$RunningState$1
implements Runnable {
    final /* synthetic */ int val$index;
    final /* synthetic */ ListenableFuture val$listenable;
    final /* synthetic */ AggregateFuture$RunningState this$1;

    AggregateFuture$RunningState$1(AggregateFuture$RunningState runningState, int n2, ListenableFuture listenableFuture) {
        this.this$1 = runningState;
        this.val$index = n2;
        this.val$listenable = listenableFuture;
    }

    @Override
    public void run() {
        try {
            AggregateFuture$RunningState.access$200(this.this$1, this.val$index, this.val$listenable);
            return;
        }
        finally {
            AggregateFuture$RunningState.access$300(this.this$1);
        }
    }
}

