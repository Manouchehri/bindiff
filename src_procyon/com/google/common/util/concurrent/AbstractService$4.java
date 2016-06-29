package com.google.common.util.concurrent;

final class AbstractService$4 extends ListenerCallQueue$Callback
{
    final /* synthetic */ Service$State val$from;
    
    AbstractService$4(final String s, final Service$State val$from) {
        this.val$from = val$from;
        super(s);
    }
    
    void call(final Service$Listener service$Listener) {
        service$Listener.stopping(this.val$from);
    }
}
