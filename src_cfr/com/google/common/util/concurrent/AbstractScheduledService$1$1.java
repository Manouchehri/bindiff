/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.Service$State;

class AbstractScheduledService$1$1
implements Supplier {
    final /* synthetic */ AbstractScheduledService$1 this$1;

    AbstractScheduledService$1$1(AbstractScheduledService$1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public String get() {
        String string = this.this$1.this$0.serviceName();
        String string2 = String.valueOf((Object)this.this$1.state());
        return new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" ").append(string2).toString();
    }
}

