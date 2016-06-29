package com.google.common.util.concurrent;

class Futures$2$1 implements Runnable
{
    final /* synthetic */ Runnable val$command;
    final /* synthetic */ Futures$2 this$0;
    
    Futures$2$1(final Futures$2 this$0, final Runnable val$command) {
        this.this$0 = this$0;
        this.val$command = val$command;
    }
    
    @Override
    public void run() {
        this.this$0.thrownFromDelegate = false;
        this.val$command.run();
    }
}
