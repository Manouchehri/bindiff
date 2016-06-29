package com.google.protobuf;

import com.google.protobuf.RpcCallback;

public interface RpcController {
   void reset();

   boolean failed();

   String errorText();

   void startCancel();

   void setFailed(String var1);

   boolean isCanceled();

   void notifyOnCancel(RpcCallback var1);
}
