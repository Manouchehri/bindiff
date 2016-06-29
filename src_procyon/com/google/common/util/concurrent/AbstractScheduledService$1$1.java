package com.google.common.util.concurrent;

import com.google.common.base.*;

class AbstractScheduledService$1$1 implements Supplier
{
    final /* synthetic */ AbstractScheduledService$1 this$1;
    
    AbstractScheduledService$1$1(final AbstractScheduledService$1 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public String get() {
        final String serviceName = this.this$1.this$0.serviceName();
        final String value = String.valueOf(this.this$1.state());
        return new StringBuilder(1 + String.valueOf(serviceName).length() + String.valueOf(value).length()).append(serviceName).append(" ").append(value).toString();
    }
}
