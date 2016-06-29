package com.google.common.util.concurrent;

import com.google.common.base.*;

class AbstractExecutionThreadService$1$1 implements Supplier
{
    final /* synthetic */ AbstractExecutionThreadService$1 this$1;
    
    AbstractExecutionThreadService$1$1(final AbstractExecutionThreadService$1 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public String get() {
        return this.this$1.this$0.serviceName();
    }
}
