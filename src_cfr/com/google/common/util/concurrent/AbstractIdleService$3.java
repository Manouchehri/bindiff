/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

class AbstractIdleService$3
implements Executor {
    final /* synthetic */ AbstractIdleService this$0;

    AbstractIdleService$3(AbstractIdleService abstractIdleService) {
        this.this$0 = abstractIdleService;
    }

    @Override
    public void execute(Runnable runnable) {
        MoreExecutors.newThread((String)AbstractIdleService.access$000(this.this$0).get(), runnable).start();
    }
}

