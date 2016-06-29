/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Service$Listener;

final class AbstractService$1
extends ListenerCallQueue$Callback {
    AbstractService$1(String string) {
        super(string);
    }

    void call(Service$Listener service$Listener) {
        service$Listener.starting();
    }
}

