/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractIdleService$2$1;
import com.google.common.util.concurrent.AbstractIdleService$2$2;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

class AbstractIdleService$2
extends AbstractService {
    final /* synthetic */ AbstractIdleService this$0;

    AbstractIdleService$2(AbstractIdleService abstractIdleService) {
        this.this$0 = abstractIdleService;
    }

    @Override
    protected final void doStart() {
        MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$000(this.this$0)).execute(new AbstractIdleService$2$1(this));
    }

    @Override
    protected final void doStop() {
        MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$000(this.this$0)).execute(new AbstractIdleService$2$2(this));
    }
}

