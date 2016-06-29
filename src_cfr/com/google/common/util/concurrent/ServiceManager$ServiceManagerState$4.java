/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager$Listener;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;

class ServiceManager$ServiceManagerState$4
extends ListenerCallQueue$Callback {
    final /* synthetic */ Service val$service;
    final /* synthetic */ ServiceManager$ServiceManagerState this$0;

    ServiceManager$ServiceManagerState$4(ServiceManager$ServiceManagerState serviceManager$ServiceManagerState, String string, Service service) {
        this.this$0 = serviceManager$ServiceManagerState;
        this.val$service = service;
        super(string);
    }

    void call(ServiceManager$Listener serviceManager$Listener) {
        serviceManager$Listener.failure(this.val$service);
    }
}

