/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
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
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=1)
public final class Futures
extends GwtFuturesCatchingSpecialization {
    private static final AsyncFunction DEREFERENCER = new Futures$4();

    private Futures() {
    }

    @CheckReturnValue
    @GwtIncompatible(value="TODO")
    public static CheckedFuture makeChecked(ListenableFuture listenableFuture, Function function) {
        return new Futures$MappingCheckedFuture((ListenableFuture)Preconditions.checkNotNull(listenableFuture), function);
    }

    @CheckReturnValue
    @GoogleInternal
    @GwtIncompatible(value="TODO")
    public static ListenableFuture transformExceptions(ListenableFuture listenableFuture, Function function) {
        return new Futures$MappingExceptionHandlingFuture(listenableFuture, function);
    }

    @CheckReturnValue
    public static ListenableFuture immediateFuture(@Nullable Object object) {
        if (object != null) return new Futures$ImmediateSuccessfulFuture(object);
        return Futures$ImmediateSuccessfulFuture.NULL;
    }

    @CheckReturnValue
    @GwtIncompatible(value="TODO")
    public static CheckedFuture immediateCheckedFuture(@Nullable Object object) {
        return new Futures$ImmediateSuccessfulCheckedFuture(object);
    }

    @CheckReturnValue
    public static ListenableFuture immediateFailedFuture(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        return new Futures$ImmediateFailedFuture(throwable);
    }

    @CheckReturnValue
    @GwtIncompatible(value="TODO")
    public static ListenableFuture immediateCancelledFuture() {
        return new Futures$ImmediateCancelledFuture();
    }

    @CheckReturnValue
    @GwtIncompatible(value="TODO")
    public static CheckedFuture immediateFailedCheckedFuture(Exception exception) {
        Preconditions.checkNotNull(exception);
        return new Futures$ImmediateFailedCheckedFuture(exception);
    }

    @Deprecated
    @CheckReturnValue
    public static ListenableFuture withFallback(ListenableFuture listenableFuture, FutureFallback futureFallback) {
        return Futures.withFallback(listenableFuture, futureFallback, MoreExecutors.directExecutor());
    }

    @Deprecated
    @CheckReturnValue
    public static ListenableFuture withFallback(ListenableFuture listenableFuture, FutureFallback futureFallback, Executor executor) {
        return Futures.catchingAsync(listenableFuture, Throwable.class, Futures.asAsyncFunction(futureFallback), executor);
    }

    @CheckReturnValue
    @GwtIncompatible(value="AVAILABLE but requires exceptionType to be Throwable.class")
    public static ListenableFuture catching(ListenableFuture listenableFuture, Class class_, Function function) {
        Futures$CatchingFuture futures$CatchingFuture = new Futures$CatchingFuture(listenableFuture, class_, function);
        listenableFuture.addListener(futures$CatchingFuture, MoreExecutors.directExecutor());
        return futures$CatchingFuture;
    }

    @CheckReturnValue
    @GwtIncompatible(value="AVAILABLE but requires exceptionType to be Throwable.class")
    public static ListenableFuture catching(ListenableFuture listenableFuture, Class class_, Function function, Executor executor) {
        Futures$CatchingFuture futures$CatchingFuture = new Futures$CatchingFuture(listenableFuture, class_, function);
        listenableFuture.addListener(futures$CatchingFuture, Futures.rejectionPropagatingExecutor(executor, futures$CatchingFuture));
        return futures$CatchingFuture;
    }

    @GwtIncompatible(value="AVAILABLE but requires exceptionType to be Throwable.class")
    public static ListenableFuture catchingAsync(ListenableFuture listenableFuture, Class class_, AsyncFunction asyncFunction) {
        Futures$AsyncCatchingFuture futures$AsyncCatchingFuture = new Futures$AsyncCatchingFuture(listenableFuture, class_, asyncFunction);
        listenableFuture.addListener(futures$AsyncCatchingFuture, MoreExecutors.directExecutor());
        return futures$AsyncCatchingFuture;
    }

    @GwtIncompatible(value="AVAILABLE but requires exceptionType to be Throwable.class")
    public static ListenableFuture catchingAsync(ListenableFuture listenableFuture, Class class_, AsyncFunction asyncFunction, Executor executor) {
        Futures$AsyncCatchingFuture futures$AsyncCatchingFuture = new Futures$AsyncCatchingFuture(listenableFuture, class_, asyncFunction);
        listenableFuture.addListener(futures$AsyncCatchingFuture, Futures.rejectionPropagatingExecutor(executor, futures$AsyncCatchingFuture));
        return futures$AsyncCatchingFuture;
    }

    @Deprecated
    static AsyncFunction asAsyncFunction(FutureFallback futureFallback) {
        Preconditions.checkNotNull(futureFallback);
        return new Futures$1(futureFallback);
    }

    @CheckReturnValue
    @GwtIncompatible(value="java.util.concurrent.ScheduledExecutorService")
    public static ListenableFuture withTimeout(ListenableFuture listenableFuture, long l2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        Futures$TimeoutFuture futures$TimeoutFuture = new Futures$TimeoutFuture(listenableFuture);
        Futures$TimeoutFuture$Fire futures$TimeoutFuture$Fire = new Futures$TimeoutFuture$Fire(futures$TimeoutFuture);
        futures$TimeoutFuture.timer = scheduledExecutorService.schedule(futures$TimeoutFuture$Fire, l2, timeUnit);
        listenableFuture.addListener(futures$TimeoutFuture$Fire, MoreExecutors.directExecutor());
        return futures$TimeoutFuture;
    }

    @Deprecated
    public static ListenableFuture transform(ListenableFuture listenableFuture, AsyncFunction asyncFunction) {
        return Futures.transformAsync(listenableFuture, asyncFunction);
    }

    @Deprecated
    public static ListenableFuture transform(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        return Futures.transformAsync(listenableFuture, asyncFunction, executor);
    }

    public static ListenableFuture transformAsync(ListenableFuture listenableFuture, AsyncFunction asyncFunction) {
        Futures$AsyncChainingFuture futures$AsyncChainingFuture = new Futures$AsyncChainingFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(futures$AsyncChainingFuture, MoreExecutors.directExecutor());
        return futures$AsyncChainingFuture;
    }

    public static ListenableFuture transformAsync(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        Futures$AsyncChainingFuture futures$AsyncChainingFuture = new Futures$AsyncChainingFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(futures$AsyncChainingFuture, Futures.rejectionPropagatingExecutor(executor, futures$AsyncChainingFuture));
        return futures$AsyncChainingFuture;
    }

    private static Executor rejectionPropagatingExecutor(Executor executor, AbstractFuture abstractFuture) {
        Preconditions.checkNotNull(executor);
        if (executor != MoreExecutors.directExecutor()) return new Futures$2(executor, abstractFuture);
        return executor;
    }

    public static ListenableFuture transform(ListenableFuture listenableFuture, Function function) {
        Preconditions.checkNotNull(function);
        Futures$ChainingFuture futures$ChainingFuture = new Futures$ChainingFuture(listenableFuture, function);
        listenableFuture.addListener(futures$ChainingFuture, MoreExecutors.directExecutor());
        return futures$ChainingFuture;
    }

    public static ListenableFuture transform(ListenableFuture listenableFuture, Function function, Executor executor) {
        Preconditions.checkNotNull(function);
        Futures$ChainingFuture futures$ChainingFuture = new Futures$ChainingFuture(listenableFuture, function);
        listenableFuture.addListener(futures$ChainingFuture, Futures.rejectionPropagatingExecutor(executor, futures$ChainingFuture));
        return futures$ChainingFuture;
    }

    @CheckReturnValue
    @GwtIncompatible(value="TODO")
    public static Future lazyTransform(Future future, Function function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Futures$3(future, function);
    }

    @CheckReturnValue
    public static ListenableFuture dereference(ListenableFuture listenableFuture) {
        return Futures.transformAsync(listenableFuture, DEREFERENCER);
    }

    @SafeVarargs
    @CheckReturnValue
    @Beta
    public static /* varargs */ ListenableFuture allAsList(ListenableFuture ... arrlistenableFuture) {
        return new Futures$ListFuture(ImmutableList.copyOf(arrlistenableFuture), true);
    }

    @CheckReturnValue
    @Beta
    public static ListenableFuture allAsList(Iterable iterable) {
        return new Futures$ListFuture(ImmutableList.copyOf(iterable), true);
    }

    @Deprecated
    @GoogleInternal
    public static /* varargs */ ListenableFuture combine(Callable callable, Executor executor, ListenableFuture ... arrlistenableFuture) {
        return Futures.combine(callable, executor, ImmutableList.copyOf(arrlistenableFuture));
    }

    @Deprecated
    @GoogleInternal
    public static ListenableFuture combine(Callable callable, Executor executor, Iterable iterable) {
        return Futures.whenAllComplete(iterable).call(callable, executor);
    }

    @SafeVarargs
    @CheckReturnValue
    @GoogleInternal
    public static /* varargs */ Futures$FutureCombiner whenAllComplete(ListenableFuture ... arrlistenableFuture) {
        return new Futures$FutureCombiner(false, ImmutableList.copyOf(arrlistenableFuture), null);
    }

    @CheckReturnValue
    @GoogleInternal
    public static Futures$FutureCombiner whenAllComplete(Iterable iterable) {
        return new Futures$FutureCombiner(false, ImmutableList.copyOf(iterable), null);
    }

    @SafeVarargs
    @CheckReturnValue
    @GoogleInternal
    public static /* varargs */ Futures$FutureCombiner whenAllSucceed(ListenableFuture ... arrlistenableFuture) {
        return new Futures$FutureCombiner(true, ImmutableList.copyOf(arrlistenableFuture), null);
    }

    @CheckReturnValue
    @GoogleInternal
    public static Futures$FutureCombiner whenAllSucceed(Iterable iterable) {
        return new Futures$FutureCombiner(true, ImmutableList.copyOf(iterable), null);
    }

    @CheckReturnValue
    @GwtIncompatible(value="TODO")
    public static ListenableFuture nonCancellationPropagating(ListenableFuture listenableFuture) {
        return new Futures$NonCancellationPropagatingFuture(listenableFuture);
    }

    @SafeVarargs
    @CheckReturnValue
    @Beta
    public static /* varargs */ ListenableFuture successfulAsList(ListenableFuture ... arrlistenableFuture) {
        return new Futures$ListFuture(ImmutableList.copyOf(arrlistenableFuture), false);
    }

    @CheckReturnValue
    @Beta
    public static ListenableFuture successfulAsList(Iterable iterable) {
        return new Futures$ListFuture(ImmutableList.copyOf(iterable), false);
    }

    @CheckReturnValue
    @GoogleInternal
    @GwtIncompatible(value="TODO")
    public static ListenableFuture allAsMap(Map map) {
        return new Futures$MapFuture(ImmutableMap.copyOf(map), true);
    }

    @CheckReturnValue
    @GoogleInternal
    @GwtIncompatible(value="TODO")
    public static ListenableFuture successfulAsMap(Map map) {
        return new Futures$MapFuture(ImmutableMap.copyOf(map), false);
    }

    @CheckReturnValue
    @Beta
    @GwtIncompatible(value="TODO")
    public static ImmutableList inCompletionOrder(Iterable iterable) {
        ConcurrentLinkedQueue concurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        SerializingExecutor serializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            ListenableFuture listenableFuture = (ListenableFuture)iterator.next();
            SettableFuture settableFuture = SettableFuture.create();
            concurrentLinkedQueue.add(settableFuture);
            listenableFuture.addListener(new Futures$5(concurrentLinkedQueue, listenableFuture), serializingExecutor);
            immutableList$Builder.add((Object)settableFuture);
        }
        return immutableList$Builder.build();
    }

    public static void addCallback(ListenableFuture listenableFuture, FutureCallback futureCallback) {
        Futures.addCallback(listenableFuture, futureCallback, MoreExecutors.directExecutor());
    }

    public static void addCallback(ListenableFuture listenableFuture, FutureCallback futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        Futures$6 futures$6 = new Futures$6(listenableFuture, futureCallback);
        listenableFuture.addListener(futures$6, executor);
    }

    @Deprecated
    @GwtIncompatible(value="reflection")
    public static Object get(Future future, Class class_) {
        return Futures.getChecked(future, class_);
    }

    @Deprecated
    @GwtIncompatible(value="reflection")
    public static Object get(Future future, long l2, TimeUnit timeUnit, Class class_) {
        return Futures.getChecked(future, class_, l2, timeUnit);
    }

    @GwtIncompatible(value="reflection")
    public static Object getChecked(Future future, Class class_) {
        return FuturesGetChecked.getChecked(future, class_);
    }

    @GwtIncompatible(value="reflection")
    public static Object getChecked(Future future, Class class_, long l2, TimeUnit timeUnit) {
        return FuturesGetChecked.getChecked(future, class_, l2, timeUnit);
    }

    @GwtIncompatible(value="TODO")
    public static Object getUnchecked(Future future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.getUninterruptibly(future);
        }
        catch (ExecutionException var1_1) {
            Futures.wrapAndThrowUnchecked(var1_1.getCause());
            throw new AssertionError();
        }
    }

    @GwtIncompatible(value="TODO")
    private static void wrapAndThrowUnchecked(Throwable throwable) {
        if (!(throwable instanceof Error)) throw new UncheckedExecutionException(throwable);
        throw new ExecutionError((Error)throwable);
    }
}

