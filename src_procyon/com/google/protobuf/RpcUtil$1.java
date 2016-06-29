package com.google.protobuf;

final class RpcUtil$1 implements RpcCallback
{
    final /* synthetic */ Class val$originalClass;
    final /* synthetic */ Message val$defaultInstance;
    final /* synthetic */ RpcCallback val$originalCallback;
    
    RpcUtil$1(final Class val$originalClass, final Message val$defaultInstance, final RpcCallback val$originalCallback) {
        this.val$originalClass = val$originalClass;
        this.val$defaultInstance = val$defaultInstance;
        this.val$originalCallback = val$originalCallback;
    }
    
    public void run(final Message message) {
        Message access$000;
        try {
            access$000 = this.val$originalClass.cast(message);
        }
        catch (ClassCastException ex) {
            access$000 = copyAsType(this.val$defaultInstance, message);
        }
        this.val$originalCallback.run(access$000);
    }
}
