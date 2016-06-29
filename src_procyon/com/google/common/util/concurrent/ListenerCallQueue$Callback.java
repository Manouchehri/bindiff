package com.google.common.util.concurrent;

import java.util.*;

abstract class ListenerCallQueue$Callback
{
    private final String methodCall;
    
    ListenerCallQueue$Callback(final String methodCall) {
        this.methodCall = methodCall;
    }
    
    abstract void call(final Object p0);
    
    void enqueueOn(final Iterable iterable) {
        final Iterator<ListenerCallQueue> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            iterator.next().add(this);
        }
    }
}
