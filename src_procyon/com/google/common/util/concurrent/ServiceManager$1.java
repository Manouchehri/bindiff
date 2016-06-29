package com.google.common.util.concurrent;

final class ServiceManager$1 extends ListenerCallQueue$Callback
{
    ServiceManager$1(final String s) {
        super(s);
    }
    
    void call(final ServiceManager$Listener serviceManager$Listener) {
        serviceManager$Listener.healthy();
    }
}
