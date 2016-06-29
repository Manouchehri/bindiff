package com.google.protobuf;

public interface RpcChannel
{
    void callMethod(final Descriptors$MethodDescriptor p0, final RpcController p1, final Message p2, final Message p3, final RpcCallback p4);
}
