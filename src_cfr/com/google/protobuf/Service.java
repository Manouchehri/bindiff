/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$MethodDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;

public interface Service {
    public Descriptors$ServiceDescriptor getDescriptorForType();

    public void callMethod(Descriptors$MethodDescriptor var1, RpcController var2, Message var3, RpcCallback var4);

    public Message getRequestPrototype(Descriptors$MethodDescriptor var1);

    public Message getResponsePrototype(Descriptors$MethodDescriptor var1);
}

