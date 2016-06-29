/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.Service$State;

class AbstractIdleService$1
implements Supplier {
    final /* synthetic */ AbstractIdleService this$0;

    AbstractIdleService$1(AbstractIdleService abstractIdleService) {
        this.this$0 = abstractIdleService;
    }

    @Override
    public String get() {
        String string = this.this$0.serviceName();
        String string2 = String.valueOf((Object)this.this$0.state());
        return new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" ").append(string2).toString();
    }
}

