package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class AbstractFuture$SetFuture implements Runnable {
   final ListenableFuture future;
   // $FF: synthetic field
   final AbstractFuture this$0;

   AbstractFuture$SetFuture(AbstractFuture var1, ListenableFuture var2) {
      this.this$0 = var1;
      this.future = var2;
   }

   public void run() {
      if(AbstractFuture.access$300(this.this$0) == this) {
         AbstractFuture.access$400(this.this$0, this.future, this);
      }
   }
}
