package com.google.common.util.concurrent;

import com.google.common.base.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;

@Beta
@GwtCompatible(emulated = true)
public final class Futures extends GwtFuturesCatchingSpecialization
{
    private static final AsyncFunction DEREFERENCER;
    
    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static CheckedFuture makeChecked(final ListenableFuture listenableFuture, final Function function) {
        return new Futures$MappingCheckedFuture((ListenableFuture)Preconditions.checkNotNull(listenableFuture), function);
    }
    
    @CheckReturnValue
    @GoogleInternal
    @GwtIncompatible("TODO")
    public static ListenableFuture transformExceptions(final ListenableFuture listenableFuture, final Function function) {
        return new Futures$MappingExceptionHandlingFuture(listenableFuture, function);
    }
    
    @CheckReturnValue
    public static ListenableFuture immediateFuture(@Nullable final Object o) {
        if (o == null) {
            return Futures$ImmediateSuccessfulFuture.NULL;
        }
        return new Futures$ImmediateSuccessfulFuture(o);
    }
    
    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static CheckedFuture immediateCheckedFuture(@Nullable final Object o) {
        return new Futures$ImmediateSuccessfulCheckedFuture(o);
    }
    
    @CheckReturnValue
    public static ListenableFuture immediateFailedFuture(final Throwable t) {
        Preconditions.checkNotNull(t);
        return new Futures$ImmediateFailedFuture(t);
    }
    
    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static ListenableFuture immediateCancelledFuture() {
        return new Futures$ImmediateCancelledFuture();
    }
    
    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static CheckedFuture immediateFailedCheckedFuture(final Exception ex) {
        Preconditions.checkNotNull(ex);
        return new Futures$ImmediateFailedCheckedFuture(ex);
    }
    
    @Deprecated
    @CheckReturnValue
    public static ListenableFuture withFallback(final ListenableFuture listenableFuture, final FutureFallback futureFallback) {
        return withFallback(listenableFuture, futureFallback, MoreExecutors.directExecutor());
    }
    
    @Deprecated
    @CheckReturnValue
    public static ListenableFuture withFallback(final ListenableFuture listenableFuture, final FutureFallback futureFallback, final Executor executor) {
        return catchingAsync(listenableFuture, Throwable.class, asAsyncFunction(futureFallback), executor);
    }
    
    @CheckReturnValue
    @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static ListenableFuture catching(final ListenableFuture listenableFuture, final Class clazz, final Function function) {
        final Futures$CatchingFuture futures$CatchingFuture = new Futures$CatchingFuture(listenableFuture, clazz, function);
        listenableFuture.addListener(futures$CatchingFuture, MoreExecutors.directExecutor());
        return futures$CatchingFuture;
    }
    
    @CheckReturnValue
    @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static ListenableFuture catching(final ListenableFuture listenableFuture, final Class clazz, final Function function, final Executor executor) {
        final Futures$CatchingFuture futures$CatchingFuture = new Futures$CatchingFuture(listenableFuture, clazz, function);
        listenableFuture.addListener(futures$CatchingFuture, rejectionPropagatingExecutor(executor, futures$CatchingFuture));
        return futures$CatchingFuture;
    }
    
    @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static ListenableFuture catchingAsync(final ListenableFuture listenableFuture, final Class clazz, final AsyncFunction asyncFunction) {
        final Futures$AsyncCatchingFuture futures$AsyncCatchingFuture = new Futures$AsyncCatchingFuture(listenableFuture, clazz, asyncFunction);
        listenableFuture.addListener(futures$AsyncCatchingFuture, MoreExecutors.directExecutor());
        return futures$AsyncCatchingFuture;
    }
    
    @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static ListenableFuture catchingAsync(final ListenableFuture listenableFuture, final Class clazz, final AsyncFunction asyncFunction, final Executor executor) {
        final Futures$AsyncCatchingFuture futures$AsyncCatchingFuture = new Futures$AsyncCatchingFuture(listenableFuture, clazz, asyncFunction);
        listenableFuture.addListener(futures$AsyncCatchingFuture, rejectionPropagatingExecutor(executor, futures$AsyncCatchingFuture));
        return futures$AsyncCatchingFuture;
    }
    
    @Deprecated
    static AsyncFunction asAsyncFunction(final FutureFallback futureFallback) {
        Preconditions.checkNotNull(futureFallback);
        return new Futures$1(futureFallback);
    }
    
    @CheckReturnValue
    @GwtIncompatible("java.util.concurrent.ScheduledExecutorService")
    public static ListenableFuture withTimeout(final ListenableFuture listenableFuture, final long n, final TimeUnit timeUnit, final ScheduledExecutorService scheduledExecutorService) {
        final Futures$TimeoutFuture futures$TimeoutFuture = new Futures$TimeoutFuture(listenableFuture);
        final Futures$TimeoutFuture$Fire futures$TimeoutFuture$Fire = new Futures$TimeoutFuture$Fire(futures$TimeoutFuture);
        futures$TimeoutFuture.timer = scheduledExecutorService.schedule(futures$TimeoutFuture$Fire, n, timeUnit);
        listenableFuture.addListener(futures$TimeoutFuture$Fire, MoreExecutors.directExecutor());
        return futures$TimeoutFuture;
    }
    
    @Deprecated
    public static ListenableFuture transform(final ListenableFuture listenableFuture, final AsyncFunction asyncFunction) {
        return transformAsync(listenableFuture, asyncFunction);
    }
    
    @Deprecated
    public static ListenableFuture transform(final ListenableFuture listenableFuture, final AsyncFunction asyncFunction, final Executor executor) {
        return transformAsync(listenableFuture, asyncFunction, executor);
    }
    
    public static ListenableFuture transformAsync(final ListenableFuture listenableFuture, final AsyncFunction asyncFunction) {
        final Futures$AsyncChainingFuture futures$AsyncChainingFuture = new Futures$AsyncChainingFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(futures$AsyncChainingFuture, MoreExecutors.directExecutor());
        return futures$AsyncChainingFuture;
    }
    
    public static ListenableFuture transformAsync(final ListenableFuture listenableFuture, final AsyncFunction asyncFunction, final Executor executor) {
        Preconditions.checkNotNull(executor);
        final Futures$AsyncChainingFuture futures$AsyncChainingFuture = new Futures$AsyncChainingFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(futures$AsyncChainingFuture, rejectionPropagatingExecutor(executor, futures$AsyncChainingFuture));
        return futures$AsyncChainingFuture;
    }
    
    private static Executor rejectionPropagatingExecutor(final Executor executor, final AbstractFuture abstractFuture) {
        Preconditions.checkNotNull(executor);
        if (executor == MoreExecutors.directExecutor()) {
            return executor;
        }
        return new Futures$2(executor, abstractFuture);
    }
    
    public static ListenableFuture transform(final ListenableFuture listenableFuture, final Function function) {
        Preconditions.checkNotNull(function);
        final Futures$ChainingFuture futures$ChainingFuture = new Futures$ChainingFuture(listenableFuture, function);
        listenableFuture.addListener(futures$ChainingFuture, MoreExecutors.directExecutor());
        return futures$ChainingFuture;
    }
    
    public static ListenableFuture transform(final ListenableFuture listenableFuture, final Function function, final Executor executor) {
        Preconditions.checkNotNull(function);
        final Futures$ChainingFuture futures$ChainingFuture = new Futures$ChainingFuture(listenableFuture, function);
        listenableFuture.addListener(futures$ChainingFuture, rejectionPropagatingExecutor(executor, futures$ChainingFuture));
        return futures$ChainingFuture;
    }
    
    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static Future lazyTransform(final Future future, final Function function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Futures$3(future, function);
    }
    
    @CheckReturnValue
    public static ListenableFuture dereference(final ListenableFuture listenableFuture) {
        return transformAsync(listenableFuture, Futures.DEREFERENCER);
    }
    
    @SafeVarargs
    @CheckReturnValue
    @Beta
    public static ListenableFuture allAsList(final ListenableFuture... array) {
        return new Futures$ListFuture(ImmutableList.copyOf(array), true);
    }
    
    @CheckReturnValue
    @Beta
    public static ListenableFuture allAsList(final Iterable iterable) {
        return new Futures$ListFuture(ImmutableList.copyOf(iterable), true);
    }
    
    @Deprecated
    @GoogleInternal
    public static ListenableFuture combine(final Callable callable, final Executor executor, final ListenableFuture... array) {
        return combine(callable, executor, ImmutableList.copyOf(array));
    }
    
    @Deprecated
    @GoogleInternal
    public static ListenableFuture combine(final Callable callable, final Executor executor, final Iterable iterable) {
        return whenAllComplete(iterable).call(callable, executor);
    }
    
    @SafeVarargs
    @CheckReturnValue
    @GoogleInternal
    public static Futures$FutureCombiner whenAllComplete(final ListenableFuture... array) {
        return new Futures$FutureCombiner(false, ImmutableList.copyOf(array), null);
    }
    
    @CheckReturnValue
    @GoogleInternal
    public static Futures$FutureCombiner whenAllComplete(final Iterable iterable) {
        return new Futures$FutureCombiner(false, ImmutableList.copyOf(iterable), null);
    }
    
    @SafeVarargs
    @CheckReturnValue
    @GoogleInternal
    public static Futures$FutureCombiner whenAllSucceed(final ListenableFuture... array) {
        return new Futures$FutureCombiner(true, ImmutableList.copyOf(array), null);
    }
    
    @CheckReturnValue
    @GoogleInternal
    public static Futures$FutureCombiner whenAllSucceed(final Iterable iterable) {
        return new Futures$FutureCombiner(true, ImmutableList.copyOf(iterable), null);
    }
    
    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static ListenableFuture nonCancellationPropagating(final ListenableFuture listenableFuture) {
        return new Futures$NonCancellationPropagatingFuture(listenableFuture);
    }
    
    @SafeVarargs
    @CheckReturnValue
    @Beta
    public static ListenableFuture successfulAsList(final ListenableFuture... array) {
        return new Futures$ListFuture(ImmutableList.copyOf(array), false);
    }
    
    @CheckReturnValue
    @Beta
    public static ListenableFuture successfulAsList(final Iterable iterable) {
        return new Futures$ListFuture(ImmutableList.copyOf(iterable), false);
    }
    
    @CheckReturnValue
    @GoogleInternal
    @GwtIncompatible("TODO")
    public static ListenableFuture allAsMap(final Map map) {
        return new Futures$MapFuture(ImmutableMap.copyOf(map), true);
    }
    
    @CheckReturnValue
    @GoogleInternal
    @GwtIncompatible("TODO")
    public static ListenableFuture successfulAsMap(final Map map) {
        return new Futures$MapFuture(ImmutableMap.copyOf(map), false);
    }
    
    @CheckReturnValue
    @Beta
    @GwtIncompatible("TODO")
    public static ImmutableList inCompletionOrder(final Iterable iterable) {
        final ConcurrentLinkedQueue concurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
        final ImmutableList$Builder builder = ImmutableList.builder();
        final SerializingExecutor serializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
        for (final ListenableFuture listenableFuture : iterable) {
            final SettableFuture create = SettableFuture.create();
            concurrentLinkedQueue.add(create);
            listenableFuture.addListener(new Futures$5(concurrentLinkedQueue, listenableFuture), serializingExecutor);
            builder.add(create);
        }
        return builder.build();
    }
    
    public static void addCallback(final ListenableFuture listenableFuture, final FutureCallback futureCallback) {
        addCallback(listenableFuture, futureCallback, MoreExecutors.directExecutor());
    }
    
    public static void addCallback(final ListenableFuture listenableFuture, final FutureCallback futureCallback, final Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new Futures$6(listenableFuture, futureCallback), executor);
    }
    
    @Deprecated
    @GwtIncompatible("reflection")
    public static Object get(final Future future, final Class clazz) {
        return getChecked(future, clazz);
    }
    
    @Deprecated
    @GwtIncompatible("reflection")
    public static Object get(final Future future, final long n, final TimeUnit timeUnit, final Class clazz) {
        return getChecked(future, clazz, n, timeUnit);
    }
    
    @GwtIncompatible("reflection")
    public static Object getChecked(final Future future, final Class clazz) {
        return FuturesGetChecked.getChecked(future, clazz);
    }
    
    @GwtIncompatible("reflection")
    public static Object getChecked(final Future future, final Class clazz, final long n, final TimeUnit timeUnit) {
        return FuturesGetChecked.getChecked(future, clazz, n, timeUnit);
    }
    
    @GwtIncompatible("TODO")
    public static Object getUnchecked(final Future future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.getUninterruptibly(future);
        }
        catch (ExecutionException ex) {
            wrapAndThrowUnchecked(ex.getCause());
            throw new AssertionError();
        }
    }
    
    @GwtIncompatible("TODO")
    private static void wrapAndThrowUnchecked(final Throwable t) {
        if (t instanceof Error) {
            throw new ExecutionError((Error)t);
        }
        throw new UncheckedExecutionException(t);
    }
    
    static {
        DEREFERENCER = new Futures$4();
    }
}
