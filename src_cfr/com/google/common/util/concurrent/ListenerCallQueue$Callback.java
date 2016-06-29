/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue;
import java.util.Iterator;

abstract class ListenerCallQueue$Callback {
    private final String methodCall;

    ListenerCallQueue$Callback(String string) {
        this.methodCall = string;
    }

    abstract void call(Object var1);

    void enqueueOn(Iterable iterable) {
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            ListenerCallQueue listenerCallQueue = (ListenerCallQueue)iterator.next();
            listenerCallQueue.add(this);
        }
    }

    static /* synthetic */ String access$000(ListenerCallQueue$Callback listenerCallQueue$Callback) {
        return listenerCallQueue$Callback.methodCall;
    }
}

