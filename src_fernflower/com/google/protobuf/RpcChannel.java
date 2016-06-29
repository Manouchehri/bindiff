package com.google.protobuf;

import com.google.protobuf.Descriptors$MethodDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;

public interface RpcChannel {
   void callMethod(Descriptors$MethodDescriptor var1, RpcController var2, Message var3, Message var4, RpcCallback var5);
}
