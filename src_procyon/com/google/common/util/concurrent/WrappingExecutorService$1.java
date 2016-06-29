package com.google.common.util.concurrent;

import java.util.concurrent.*;
import com.google.common.base.*;

class WrappingExecutorService$1 implements Runnable
{
    final /* synthetic */ Callable val$wrapped;
    final /* synthetic */ WrappingExecutorService this$0;
    
    WrappingExecutorService$1(final WrappingExecutorService this$0, final Callable val$wrapped) {
        this.this$0 = this$0;
        this.val$wrapped = val$wrapped;
    }
    
    @Override
    public void run() {
        try {
            this.val$wrapped.call();
        }
        catch (Exception ex) {
            Throwables.propagate(ex);
        }
    }
}
