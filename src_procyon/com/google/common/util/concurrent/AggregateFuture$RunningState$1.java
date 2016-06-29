package com.google.common.util.concurrent;

import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.logging.*;
import java.util.*;
import java.util.concurrent.*;
import javax.annotation.*;

class AggregateFuture$RunningState$1 implements Runnable
{
    final /* synthetic */ int val$index;
    final /* synthetic */ ListenableFuture val$listenable;
    final /* synthetic */ AggregateFuture$RunningState this$1;
    
    AggregateFuture$RunningState$1(final AggregateFuture$RunningState this$1, final int val$index, final ListenableFuture val$listenable) {
        this.this$1 = this$1;
        this.val$index = val$index;
        this.val$listenable = val$listenable;
    }
    
    @Override
    public void run() {
        try {
            this.this$1.handleOneInputDone(this.val$index, this.val$listenable);
        }
        finally {
            this.this$1.decrementCountAndMaybeComplete();
        }
    }
}
