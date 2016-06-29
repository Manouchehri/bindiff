package com.google.protobuf;

import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil$1;
import com.google.protobuf.RpcUtil$2;

public final class RpcUtil {
   public static RpcCallback specializeCallback(RpcCallback var0) {
      return var0;
   }

   public static RpcCallback generalizeCallback(RpcCallback var0, Class var1, Message var2) {
      return new RpcUtil$1(var1, var2, var0);
   }

   private static Message copyAsType(Message var0, Message var1) {
      return var0.newBuilderForType().mergeFrom(var1).build();
   }

   public static RpcCallback newOneTimeCallback(RpcCallback var0) {
      return new RpcUtil$2(var0);
   }

   // $FF: synthetic method
   static Message access$000(Message var0, Message var1) {
      return copyAsType(var0, var1);
   }
}
