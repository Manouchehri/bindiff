package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.logging.Logger;

@GwtCompatible
abstract class AggregateFuture extends AbstractFuture$TrustedFuture {
   private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
   private AggregateFuture$RunningState runningState;

   final void done() {
      super.done();
      this.runningState = null;
   }

   public final boolean cancel(boolean var1) {
      AggregateFuture$RunningState var2 = this.runningState;
      ImmutableCollection var3 = var2 != null?AggregateFuture$RunningState.access$000(var2):null;
      boolean var4 = super.cancel(var1);
      if(var4 & var3 != null) {
         UnmodifiableIterator var5 = var3.iterator();

         while(var5.hasNext()) {
            ListenableFuture var6 = (ListenableFuture)var5.next();
            var6.cancel(var1);
         }
      }

      return var4;
   }

   @GwtIncompatible("Interruption not supported")
   protected final void interruptTask() {
      AggregateFuture$RunningState var1 = this.runningState;
      if(var1 != null) {
         var1.interruptTask();
      }

   }

   final void init(AggregateFuture$RunningState var1) {
      this.runningState = var1;
      AggregateFuture$RunningState.access$100(var1);
   }

   private static boolean addCausalChain(Set var0, Throwable var1) {
      while(var1 != null) {
         boolean var2 = var0.add(var1);
         if(!var2) {
            return false;
         }

         var1 = var1.getCause();
      }

      return true;
   }

   // $FF: synthetic method
   static boolean access$400(Set var0, Throwable var1) {
      return addCausalChain(var0, var1);
   }

   // $FF: synthetic method
   static Logger access$500() {
      return logger;
   }

   // $FF: synthetic method
   static boolean access$601(AggregateFuture var0, boolean var1) {
      return var0.cancel(var1);
   }
}
