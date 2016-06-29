/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1;

class AbstractExecutionThreadService$1$1
implements Supplier {
    final /* synthetic */ AbstractExecutionThreadService$1 this$1;

    AbstractExecutionThreadService$1$1(AbstractExecutionThreadService$1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public String get() {
        return this.this$1.this$0.serviceName();
    }
}

