package com.google.common.util.concurrent;

final class ServiceManager$2 extends ListenerCallQueue$Callback
{
    ServiceManager$2(final String s) {
        super(s);
    }
    
    void call(final ServiceManager$Listener serviceManager$Listener) {
        serviceManager$Listener.stopped();
    }
}
