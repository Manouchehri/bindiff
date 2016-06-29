package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter;
import com.google.common.util.concurrent.Uninterruptibles;

class JdkFutureAdapters$ListenableFutureAdapter$1 implements Runnable {
   // $FF: synthetic field
   final JdkFutureAdapters$ListenableFutureAdapter this$0;

   JdkFutureAdapters$ListenableFutureAdapter$1(JdkFutureAdapters$ListenableFutureAdapter var1) {
      this.this$0 = var1;
   }

   public void run() {
      try {
         Uninterruptibles.getUninterruptibly(JdkFutureAdapters$ListenableFutureAdapter.access$000(this.this$0));
      } catch (Error var2) {
         throw var2;
      } catch (Throwable var3) {
         ;
      }

      JdkFutureAdapters$ListenableFutureAdapter.access$100(this.this$0).execute();
   }
}
