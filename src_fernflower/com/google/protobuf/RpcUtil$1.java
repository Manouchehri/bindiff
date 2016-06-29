package com.google.protobuf;

import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil;

final class RpcUtil$1 implements RpcCallback {
   // $FF: synthetic field
   final Class val$originalClass;
   // $FF: synthetic field
   final Message val$defaultInstance;
   // $FF: synthetic field
   final RpcCallback val$originalCallback;

   RpcUtil$1(Class var1, Message var2, RpcCallback var3) {
      this.val$originalClass = var1;
      this.val$defaultInstance = var2;
      this.val$originalCallback = var3;
   }

   public void run(Message var1) {
      Message var2;
      try {
         var2 = (Message)this.val$originalClass.cast(var1);
      } catch (ClassCastException var4) {
         var2 = RpcUtil.access$000(this.val$defaultInstance, var1);
      }

      this.val$originalCallback.run(var2);
   }
}
