package com.google.protobuf;

final class RpcUtil$2 implements RpcCallback
{
    private boolean alreadyCalled;
    final /* synthetic */ RpcCallback val$originalCallback;
    
    RpcUtil$2(final RpcCallback val$originalCallback) {
        this.val$originalCallback = val$originalCallback;
        this.alreadyCalled = false;
    }
    
    public void run(final Object o) {
        synchronized (this) {
            if (this.alreadyCalled) {
                throw new RpcUtil$AlreadyCalledException();
            }
            this.alreadyCalled = true;
        }
        this.val$originalCallback.run(o);
    }
}
