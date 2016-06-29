package com.google.common.util.concurrent;

class AbstractService$9 extends ListenerCallQueue$Callback
{
    final /* synthetic */ Service$State val$from;
    final /* synthetic */ Throwable val$cause;
    final /* synthetic */ AbstractService this$0;
    
    AbstractService$9(final AbstractService this$0, final String s, final Service$State val$from, final Throwable val$cause) {
        this.this$0 = this$0;
        this.val$from = val$from;
        this.val$cause = val$cause;
        super(s);
    }
    
    void call(final Service$Listener service$Listener) {
        service$Listener.failed(this.val$from, this.val$cause);
    }
}
