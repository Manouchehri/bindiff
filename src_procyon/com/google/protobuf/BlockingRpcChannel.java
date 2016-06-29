package com.google.protobuf;

public interface BlockingRpcChannel
{
    Message callBlockingMethod(final Descriptors$MethodDescriptor p0, final RpcController p1, final Message p2, final Message p3);
}
