package com.google.common.cache;

class RemovalListeners$1$1 implements Runnable
{
    final /* synthetic */ RemovalNotification val$notification;
    final /* synthetic */ RemovalListeners$1 this$0;
    
    RemovalListeners$1$1(final RemovalListeners$1 this$0, final RemovalNotification val$notification) {
        this.this$0 = this$0;
        this.val$notification = val$notification;
    }
    
    @Override
    public void run() {
        this.this$0.val$listener.onRemoval(this.val$notification);
    }
}
