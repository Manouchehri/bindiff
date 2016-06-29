package com.google.common.util.concurrent;

final class AbstractService$1 extends ListenerCallQueue$Callback
{
    AbstractService$1(final String s) {
        super(s);
    }
    
    void call(final Service$Listener service$Listener) {
        service$Listener.starting();
    }
}
