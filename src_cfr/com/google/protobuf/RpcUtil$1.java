/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil;

final class RpcUtil$1
implements RpcCallback {
    final /* synthetic */ Class val$originalClass;
    final /* synthetic */ Message val$defaultInstance;
    final /* synthetic */ RpcCallback val$originalCallback;

    RpcUtil$1(Class class_, Message message, RpcCallback rpcCallback) {
        this.val$originalClass = class_;
        this.val$defaultInstance = message;
        this.val$originalCallback = rpcCallback;
    }

    public void run(Message message) {
        Message message2;
        try {
            message2 = (Message)this.val$originalClass.cast(message);
        }
        catch (ClassCastException var3_3) {
            message2 = RpcUtil.access$000(this.val$defaultInstance, message);
        }
        this.val$originalCallback.run(message2);
    }
}

