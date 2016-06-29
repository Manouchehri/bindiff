package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue;
import java.util.Iterator;

abstract class ListenerCallQueue$Callback {
   private final String methodCall;

   ListenerCallQueue$Callback(String var1) {
      this.methodCall = var1;
   }

   abstract void call(Object var1);

   void enqueueOn(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ListenerCallQueue var3 = (ListenerCallQueue)var2.next();
         var3.add(this);
      }

   }

   // $FF: synthetic method
   static String access$000(ListenerCallQueue$Callback var0) {
      return var0.methodCall;
   }
}
