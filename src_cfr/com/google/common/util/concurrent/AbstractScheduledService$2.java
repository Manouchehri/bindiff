/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ThreadFactory;

class AbstractScheduledService$2
implements ThreadFactory {
    final /* synthetic */ AbstractScheduledService this$0;

    AbstractScheduledService$2(AbstractScheduledService abstractScheduledService) {
        this.this$0 = abstractScheduledService;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return MoreExecutors.newThread(this.this$0.serviceName(), runnable);
    }
}

