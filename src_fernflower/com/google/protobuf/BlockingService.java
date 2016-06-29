package com.google.protobuf;

import com.google.protobuf.Descriptors$MethodDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;

public interface BlockingService {
   Descriptors$ServiceDescriptor getDescriptorForType();

   Message callBlockingMethod(Descriptors$MethodDescriptor var1, RpcController var2, Message var3);

   Message getRequestPrototype(Descriptors$MethodDescriptor var1);

   Message getResponsePrototype(Descriptors$MethodDescriptor var1);
}
