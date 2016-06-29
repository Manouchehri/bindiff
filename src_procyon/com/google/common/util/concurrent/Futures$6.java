package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class Futures$6 implements Runnable
{
    final /* synthetic */ ListenableFuture val$future;
    final /* synthetic */ FutureCallback val$callback;
    
    Futures$6(final ListenableFuture val$future, final FutureCallback val$callback) {
        this.val$future = val$future;
        this.val$callback = val$callback;
    }
    
    @Override
    public void run() {
        Object uninterruptibly;
        try {
            uninterruptibly = Uninterruptibles.getUninterruptibly(this.val$future);
        }
        catch (ExecutionException ex) {
            this.val$callback.onFailure(ex.getCause());
            return;
        }
        catch (RuntimeException ex2) {
            this.val$callback.onFailure(ex2);
            return;
        }
        catch (Error error) {
            this.val$callback.onFailure(error);
            return;
        }
        this.val$callback.onSuccess(uninterruptibly);
    }
}
