package com.google.common.util.concurrent;

class ServiceManager$ServiceManagerState$4 extends ListenerCallQueue$Callback
{
    final /* synthetic */ Service val$service;
    final /* synthetic */ ServiceManager$ServiceManagerState this$0;
    
    ServiceManager$ServiceManagerState$4(final ServiceManager$ServiceManagerState this$0, final String s, final Service val$service) {
        this.this$0 = this$0;
        this.val$service = val$service;
        super(s);
    }
    
    void call(final ServiceManager$Listener serviceManager$Listener) {
        serviceManager$Listener.failure(this.val$service);
    }
}
