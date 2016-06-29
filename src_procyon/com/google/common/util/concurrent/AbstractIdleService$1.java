package com.google.common.util.concurrent;

import com.google.common.base.*;

class AbstractIdleService$1 implements Supplier
{
    final /* synthetic */ AbstractIdleService this$0;
    
    AbstractIdleService$1(final AbstractIdleService this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public String get() {
        final String serviceName = this.this$0.serviceName();
        final String value = String.valueOf(this.this$0.state());
        return new StringBuilder(1 + String.valueOf(serviceName).length() + String.valueOf(value).length()).append(serviceName).append(" ").append(value).toString();
    }
}
