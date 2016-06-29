package com.google.common.util.concurrent;

final class AbstractService$2 extends ListenerCallQueue$Callback
{
    AbstractService$2(final String s) {
        super(s);
    }
    
    void call(final Service$Listener service$Listener) {
        service$Listener.running();
    }
}
