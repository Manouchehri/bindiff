/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;

class AbstractService$9
extends ListenerCallQueue$Callback {
    final /* synthetic */ Service$State val$from;
    final /* synthetic */ Throwable val$cause;
    final /* synthetic */ AbstractService this$0;

    AbstractService$9(AbstractService abstractService, String string, Service$State service$State, Throwable throwable) {
        this.this$0 = abstractService;
        this.val$from = service$State;
        this.val$cause = throwable;
        super(string);
    }

    void call(Service$Listener service$Listener) {
        service$Listener.failed(this.val$from, this.val$cause);
    }
}

