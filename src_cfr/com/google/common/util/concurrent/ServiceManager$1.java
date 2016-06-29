/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.ServiceManager$Listener;

final class ServiceManager$1
extends ListenerCallQueue$Callback {
    ServiceManager$1(String string) {
        super(string);
    }

    void call(ServiceManager$Listener serviceManager$Listener) {
        serviceManager$Listener.healthy();
    }
}

