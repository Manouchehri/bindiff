package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

class AbstractIdleService$3 implements Executor
{
    final /* synthetic */ AbstractIdleService this$0;
    
    AbstractIdleService$3(final AbstractIdleService this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void execute(final Runnable runnable) {
        MoreExecutors.newThread((String)this.this$0.threadNameSupplier.get(), runnable).start();
    }
}
