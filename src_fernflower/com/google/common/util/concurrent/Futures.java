package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.FutureFallback;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$2;
import com.google.common.util.concurrent.Futures$3;
import com.google.common.util.concurrent.Futures$4;
import com.google.common.util.concurrent.Futures$5;
import com.google.common.util.concurrent.Futures$6;
import com.google.common.util.concurrent.Futures$AsyncCatchingFuture;
import com.google.common.util.concurrent.Futures$AsyncChainingFuture;
import com.google.common.util.concurrent.Futures$CatchingFuture;
import com.google.common.util.concurrent.Futures$ChainingFuture;
import com.google.common.util.concurrent.Futures$FutureCombiner;
import com.google.common.util.concurrent.Futures$ImmediateCancelledFuture;
import com.google.common.util.concurrent.Futures$ImmediateFailedCheckedFuture;
import com.google.common.util.concurrent.Futures$ImmediateFailedFuture;
import com.google.common.util.concurrent.Futures$ImmediateSuccessfulCheckedFuture;
import com.google.common.util.concurrent.Futures$ImmediateSuccessfulFuture;
import com.google.common.util.concurrent.Futures$ListFuture;
import com.google.common.util.concurrent.Futures$MapFuture;
import com.google.common.util.concurrent.Futures$MappingCheckedFuture;
import com.google.common.util.concurrent.Futures$MappingExceptionHandlingFuture;
import com.google.common.util.concurrent.Futures$NonCancellationPropagatingFuture;
import com.google.common.util.concurrent.Futures$TimeoutFuture;
import com.google.common.util.concurrent.Futures$TimeoutFuture$Fire;
import com.google.common.util.concurrent.FuturesGetChecked;
import com.google.common.util.concurrent.GwtFuturesCatchingSpecialization;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SerializingExecutor;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(
   emulated = true
)
public final class Futures extends GwtFuturesCatchingSpecialization {
   private static final AsyncFunction DEREFERENCER = new Futures$4();

   @CheckReturnValue
   @GwtIncompatible("TODO")
   public static CheckedFuture makeChecked(ListenableFuture var0, Function var1) {
      return new Futures$MappingCheckedFuture((ListenableFuture)Preconditions.checkNotNull(var0), var1);
   }

   @CheckReturnValue
   @GoogleInternal
   @GwtIncompatible("TODO")
   public static ListenableFuture transformExceptions(ListenableFuture var0, Function var1) {
      return new Futures$MappingExceptionHandlingFuture(var0, var1);
   }

   @CheckReturnValue
   public static ListenableFuture immediateFuture(@Nullable Object var0) {
      if(var0 == null) {
         Futures$ImmediateSuccessfulFuture var1 = Futures$ImmediateSuccessfulFuture.NULL;
         return var1;
      } else {
         return new Futures$ImmediateSuccessfulFuture(var0);
      }
   }

   @CheckReturnValue
   @GwtIncompatible("TODO")
   public static CheckedFuture immediateCheckedFuture(@Nullable Object var0) {
      return new Futures$ImmediateSuccessfulCheckedFuture(var0);
   }

   @CheckReturnValue
   public static ListenableFuture immediateFailedFuture(Throwable var0) {
      Preconditions.checkNotNull(var0);
      return new Futures$ImmediateFailedFuture(var0);
   }

   @CheckReturnValue
   @GwtIncompatible("TODO")
   public static ListenableFuture immediateCancelledFuture() {
      return new Futures$ImmediateCancelledFuture();
   }

   @CheckReturnValue
   @GwtIncompatible("TODO")
   public static CheckedFuture immediateFailedCheckedFuture(Exception var0) {
      Preconditions.checkNotNull(var0);
      return new Futures$ImmediateFailedCheckedFuture(var0);
   }

   @Deprecated
   @CheckReturnValue
   public static ListenableFuture withFallback(ListenableFuture var0, FutureFallback var1) {
      return withFallback(var0, var1, MoreExecutors.directExecutor());
   }

   @Deprecated
   @CheckReturnValue
   public static ListenableFuture withFallback(ListenableFuture var0, FutureFallback var1, Executor var2) {
      return catchingAsync(var0, Throwable.class, asAsyncFunction(var1), var2);
   }

   @CheckReturnValue
   @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
   public static ListenableFuture catching(ListenableFuture var0, Class var1, Function var2) {
      Futures$CatchingFuture var3 = new Futures$CatchingFuture(var0, var1, var2);
      var0.addListener(var3, MoreExecutors.directExecutor());
      return var3;
   }

   @CheckReturnValue
   @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
   public static ListenableFuture catching(ListenableFuture var0, Class var1, Function var2, Executor var3) {
      Futures$CatchingFuture var4 = new Futures$CatchingFuture(var0, var1, var2);
      var0.addListener(var4, rejectionPropagatingExecutor(var3, var4));
      return var4;
   }

   @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
   public static ListenableFuture catchingAsync(ListenableFuture var0, Class var1, AsyncFunction var2) {
      Futures$AsyncCatchingFuture var3 = new Futures$AsyncCatchingFuture(var0, var1, var2);
      var0.addListener(var3, MoreExecutors.directExecutor());
      return var3;
   }

   @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
   public static ListenableFuture catchingAsync(ListenableFuture var0, Class var1, AsyncFunction var2, Executor var3) {
      Futures$AsyncCatchingFuture var4 = new Futures$AsyncCatchingFuture(var0, var1, var2);
      var0.addListener(var4, rejectionPropagatingExecutor(var3, var4));
      return var4;
   }

   @Deprecated
   static AsyncFunction asAsyncFunction(FutureFallback var0) {
      Preconditions.checkNotNull(var0);
      return new Futures$1(var0);
   }

   @CheckReturnValue
   @GwtIncompatible("java.util.concurrent.ScheduledExecutorService")
   public static ListenableFuture withTimeout(ListenableFuture var0, long var1, TimeUnit var3, ScheduledExecutorService var4) {
      Futures$TimeoutFuture var5 = new Futures$TimeoutFuture(var0);
      Futures$TimeoutFuture$Fire var6 = new Futures$TimeoutFuture$Fire(var5);
      var5.timer = var4.schedule(var6, var1, var3);
      var0.addListener(var6, MoreExecutors.directExecutor());
      return var5;
   }

   @Deprecated
   public static ListenableFuture transform(ListenableFuture var0, AsyncFunction var1) {
      return transformAsync(var0, var1);
   }

   @Deprecated
   public static ListenableFuture transform(ListenableFuture var0, AsyncFunction var1, Executor var2) {
      return transformAsync(var0, var1, var2);
   }

   public static ListenableFuture transformAsync(ListenableFuture var0, AsyncFunction var1) {
      Futures$AsyncChainingFuture var2 = new Futures$AsyncChainingFuture(var0, var1);
      var0.addListener(var2, MoreExecutors.directExecutor());
      return var2;
   }

   public static ListenableFuture transformAsync(ListenableFuture var0, AsyncFunction var1, Executor var2) {
      Preconditions.checkNotNull(var2);
      Futures$AsyncChainingFuture var3 = new Futures$AsyncChainingFuture(var0, var1);
      var0.addListener(var3, rejectionPropagatingExecutor(var2, var3));
      return var3;
   }

   private static Executor rejectionPropagatingExecutor(Executor var0, AbstractFuture var1) {
      Preconditions.checkNotNull(var0);
      return (Executor)(var0 == MoreExecutors.directExecutor()?var0:new Futures$2(var0, var1));
   }

   public static ListenableFuture transform(ListenableFuture var0, Function var1) {
      Preconditions.checkNotNull(var1);
      Futures$ChainingFuture var2 = new Futures$ChainingFuture(var0, var1);
      var0.addListener(var2, MoreExecutors.directExecutor());
      return var2;
   }

   public static ListenableFuture transform(ListenableFuture var0, Function var1, Executor var2) {
      Preconditions.checkNotNull(var1);
      Futures$ChainingFuture var3 = new Futures$ChainingFuture(var0, var1);
      var0.addListener(var3, rejectionPropagatingExecutor(var2, var3));
      return var3;
   }

   @CheckReturnValue
   @GwtIncompatible("TODO")
   public static Future lazyTransform(Future var0, Function var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Futures$3(var0, var1);
   }

   @CheckReturnValue
   public static ListenableFuture dereference(ListenableFuture var0) {
      return transformAsync(var0, DEREFERENCER);
   }

   @SafeVarargs
   @CheckReturnValue
   @Beta
   public static ListenableFuture allAsList(ListenableFuture... var0) {
      return new Futures$ListFuture(ImmutableList.copyOf((Object[])var0), true);
   }

   @CheckReturnValue
   @Beta
   public static ListenableFuture allAsList(Iterable var0) {
      return new Futures$ListFuture(ImmutableList.copyOf(var0), true);
   }

   @Deprecated
   @GoogleInternal
   public static ListenableFuture combine(Callable var0, Executor var1, ListenableFuture... var2) {
      return combine(var0, var1, (Iterable)ImmutableList.copyOf((Object[])var2));
   }

   @Deprecated
   @GoogleInternal
   public static ListenableFuture combine(Callable var0, Executor var1, Iterable var2) {
      return whenAllComplete(var2).call(var0, var1);
   }

   @SafeVarargs
   @CheckReturnValue
   @GoogleInternal
   public static Futures$FutureCombiner whenAllComplete(ListenableFuture... var0) {
      return new Futures$FutureCombiner(false, ImmutableList.copyOf((Object[])var0), (Futures$1)null);
   }

   @CheckReturnValue
   @GoogleInternal
   public static Futures$FutureCombiner whenAllComplete(Iterable var0) {
      return new Futures$FutureCombiner(false, ImmutableList.copyOf(var0), (Futures$1)null);
   }

   @SafeVarargs
   @CheckReturnValue
   @GoogleInternal
   public static Futures$FutureCombiner whenAllSucceed(ListenableFuture... var0) {
      return new Futures$FutureCombiner(true, ImmutableList.copyOf((Object[])var0), (Futures$1)null);
   }

   @CheckReturnValue
   @GoogleInternal
   public static Futures$FutureCombiner whenAllSucceed(Iterable var0) {
      return new Futures$FutureCombiner(true, ImmutableList.copyOf(var0), (Futures$1)null);
   }

   @CheckReturnValue
   @GwtIncompatible("TODO")
   public static ListenableFuture nonCancellationPropagating(ListenableFuture var0) {
      return new Futures$NonCancellationPropagatingFuture(var0);
   }

   @SafeVarargs
   @CheckReturnValue
   @Beta
   public static ListenableFuture successfulAsList(ListenableFuture... var0) {
      return new Futures$ListFuture(ImmutableList.copyOf((Object[])var0), false);
   }

   @CheckReturnValue
   @Beta
   public static ListenableFuture successfulAsList(Iterable var0) {
      return new Futures$ListFuture(ImmutableList.copyOf(var0), false);
   }

   @CheckReturnValue
   @GoogleInternal
   @GwtIncompatible("TODO")
   public static ListenableFuture allAsMap(Map var0) {
      return new Futures$MapFuture(ImmutableMap.copyOf(var0), true);
   }

   @CheckReturnValue
   @GoogleInternal
   @GwtIncompatible("TODO")
   public static ListenableFuture successfulAsMap(Map var0) {
      return new Futures$MapFuture(ImmutableMap.copyOf(var0), false);
   }

   @CheckReturnValue
   @Beta
   @GwtIncompatible("TODO")
   public static ImmutableList inCompletionOrder(Iterable var0) {
      ConcurrentLinkedQueue var1 = Queues.newConcurrentLinkedQueue();
      ImmutableList$Builder var2 = ImmutableList.builder();
      SerializingExecutor var3 = new SerializingExecutor(MoreExecutors.directExecutor());
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         ListenableFuture var5 = (ListenableFuture)var4.next();
         SettableFuture var6 = SettableFuture.create();
         var1.add(var6);
         var5.addListener(new Futures$5(var1, var5), var3);
         var2.add((Object)var6);
      }

      return var2.build();
   }

   public static void addCallback(ListenableFuture var0, FutureCallback var1) {
      addCallback(var0, var1, MoreExecutors.directExecutor());
   }

   public static void addCallback(ListenableFuture var0, FutureCallback var1, Executor var2) {
      Preconditions.checkNotNull(var1);
      Futures$6 var3 = new Futures$6(var0, var1);
      var0.addListener(var3, var2);
   }

   @Deprecated
   @GwtIncompatible("reflection")
   public static Object get(Future var0, Class var1) {
      return getChecked(var0, var1);
   }

   @Deprecated
   @GwtIncompatible("reflection")
   public static Object get(Future var0, long var1, TimeUnit var3, Class var4) {
      return getChecked(var0, var4, var1, var3);
   }

   @GwtIncompatible("reflection")
   public static Object getChecked(Future var0, Class var1) {
      return FuturesGetChecked.getChecked(var0, var1);
   }

   @GwtIncompatible("reflection")
   public static Object getChecked(Future var0, Class var1, long var2, TimeUnit var4) {
      return FuturesGetChecked.getChecked(var0, var1, var2, var4);
   }

   @GwtIncompatible("TODO")
   public static Object getUnchecked(Future var0) {
      Preconditions.checkNotNull(var0);

      try {
         return Uninterruptibles.getUninterruptibly(var0);
      } catch (ExecutionException var2) {
         wrapAndThrowUnchecked(var2.getCause());
         throw new AssertionError();
      }
   }

   @GwtIncompatible("TODO")
   private static void wrapAndThrowUnchecked(Throwable var0) {
      if(var0 instanceof Error) {
         throw new ExecutionError((Error)var0);
      } else {
         throw new UncheckedExecutionException(var0);
      }
   }
}
