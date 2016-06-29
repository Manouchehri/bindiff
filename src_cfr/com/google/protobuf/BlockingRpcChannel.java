/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$MethodDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;

public interface BlockingRpcChannel {
    public Message callBlockingMethod(Descriptors.MethodDescriptor var1, RpcController var2, Message var3, Message var4);
}

