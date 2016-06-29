package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.AggregateFuture$RunningState$1;
import com.google.common.util.concurrent.AggregateFutureState;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.annotation.Nullable;

abstract class AggregateFuture$RunningState extends AggregateFutureState implements Runnable {
   private ImmutableCollection futures;
   private final boolean allMustSucceed;
   private final boolean collectsValues;
   // $FF: synthetic field
   final AggregateFuture this$0;

   AggregateFuture$RunningState(AggregateFuture var1, ImmutableCollection var2, boolean var3, boolean var4) {
      super(var2.size());
      this.this$0 = var1;
      this.futures = (ImmutableCollection)Preconditions.checkNotNull(var2);
      this.allMustSucceed = var3;
      this.collectsValues = var4;
   }

   public final void run() {
      this.decrementCountAndMaybeComplete();
   }

   private void init() {
      if(this.futures.isEmpty()) {
         this.handleAllCompleted();
      } else {
         if(this.allMustSucceed) {
            int var1 = 0;
            UnmodifiableIterator var2 = this.futures.iterator();

            while(var2.hasNext()) {
               ListenableFuture var3 = (ListenableFuture)var2.next();
               int var4 = var1++;
               var3.addListener(new AggregateFuture$RunningState$1(this, var4, var3), MoreExecutors.directExecutor());
            }
         } else {
            UnmodifiableIterator var5 = this.futures.iterator();

            while(var5.hasNext()) {
               ListenableFuture var6 = (ListenableFuture)var5.next();
               var6.addListener(this, MoreExecutors.directExecutor());
            }
         }

      }
   }

   private void handleException(Throwable var1) {
      Preconditions.checkNotNull(var1);
      boolean var2 = false;
      boolean var3 = true;
      if(this.allMustSucceed) {
         var2 = this.this$0.setException(var1);
         if(var2) {
            this.releaseResourcesAfterFailure();
         } else {
            var3 = AggregateFuture.access$400(this.getOrInitSeenExceptions(), var1);
         }
      }

      if(var1 instanceof Error | this.allMustSucceed & !var2 & var3) {
         AggregateFuture.access$500().log(Level.SEVERE, "input future failed.", var1);
      }

   }

   final void addInitialException(Set var1) {
      if(!this.this$0.isCancelled()) {
         AggregateFuture.access$400(var1, this.this$0.trustedGetException());
      }

   }

   private void handleOneInputDone(int var1, Future var2) {
      Preconditions.checkState(this.allMustSucceed || !this.this$0.isDone() || this.this$0.isCancelled(), "Future was done before all dependencies completed");

      try {
         Preconditions.checkState(var2.isDone(), "Tried to set value from future which is not done");
         if(this.allMustSucceed) {
            if(var2.isCancelled()) {
               AggregateFuture.access$601(this.this$0, false);
            } else {
               Object var3 = Uninterruptibles.getUninterruptibly(var2);
               if(this.collectsValues) {
                  this.collectOneValue(this.allMustSucceed, var1, var3);
               }
            }
         } else if(this.collectsValues && !var2.isCancelled()) {
            this.collectOneValue(this.allMustSucceed, var1, Uninterruptibles.getUninterruptibly(var2));
         }
      } catch (ExecutionException var4) {
         this.handleException(var4.getCause());
      } catch (Throwable var5) {
         this.handleException(var5);
      }

   }

   private void decrementCountAndMaybeComplete() {
      int var1 = this.decrementRemainingAndGet();
      Preconditions.checkState(var1 >= 0, "Less than 0 remaining futures");
      if(var1 == 0) {
         this.processCompleted();
      }

   }

   private void processCompleted() {
      if(this.collectsValues & !this.allMustSucceed) {
         int var1 = 0;
         UnmodifiableIterator var2 = this.futures.iterator();

         while(var2.hasNext()) {
            ListenableFuture var3 = (ListenableFuture)var2.next();
            this.handleOneInputDone(var1++, var3);
         }
      }

      this.handleAllCompleted();
   }

   void releaseResourcesAfterFailure() {
      this.futures = null;
   }

   abstract void collectOneValue(boolean var1, int var2, @Nullable Object var3);

   abstract void handleAllCompleted();

   void interruptTask() {
   }

   // $FF: synthetic method
   static ImmutableCollection access$000(AggregateFuture$RunningState var0) {
      return var0.futures;
   }

   // $FF: synthetic method
   static void access$100(AggregateFuture$RunningState var0) {
      var0.init();
   }

   // $FF: synthetic method
   static void access$200(AggregateFuture$RunningState var0, int var1, Future var2) {
      var0.handleOneInputDone(var1, var2);
   }

   // $FF: synthetic method
   static void access$300(AggregateFuture$RunningState var0) {
      var0.decrementCountAndMaybeComplete();
   }
}
