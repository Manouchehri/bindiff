/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;

final class AbstractService$3
extends ListenerCallQueue$Callback {
    final /* synthetic */ Service$State val$from;

    AbstractService$3(String string, Service$State service$State) {
        this.val$from = service$State;
        super(string);
    }

    void call(Service$Listener service$Listener) {
        service$Listener.terminated(this.val$from);
    }
}

