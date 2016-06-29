package com.google.protobuf;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil$AlreadyCalledException;

final class RpcUtil$2 implements RpcCallback {
   private boolean alreadyCalled;
   // $FF: synthetic field
   final RpcCallback val$originalCallback;

   RpcUtil$2(RpcCallback var1) {
      this.val$originalCallback = var1;
      this.alreadyCalled = false;
   }

   public void run(Object var1) {
      synchronized(this) {
         if(this.alreadyCalled) {
            throw new RpcUtil$AlreadyCalledException();
         }

         this.alreadyCalled = true;
      }

      this.val$originalCallback.run(var1);
   }
}
