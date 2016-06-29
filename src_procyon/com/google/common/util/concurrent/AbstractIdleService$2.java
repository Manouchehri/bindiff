package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

class AbstractIdleService$2 extends AbstractService
{
    final /* synthetic */ AbstractIdleService this$0;
    
    AbstractIdleService$2(final AbstractIdleService this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    protected final void doStart() {
        MoreExecutors.renamingDecorator(this.this$0.executor(), this.this$0.threadNameSupplier).execute(new AbstractIdleService$2$1(this));
    }
    
    @Override
    protected final void doStop() {
        MoreExecutors.renamingDecorator(this.this$0.executor(), this.this$0.threadNameSupplier).execute(new AbstractIdleService$2$2(this));
    }
}
