package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.RateLimiter;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GoogleInternal
final class RateLimitingExecutorService extends AbstractExecutorService implements ListeningExecutorService {
   private final ListeningScheduledExecutorService delegate;
   private final RateLimiter rateLimiter;
   private final int permitsPerTask;

   RateLimitingExecutorService(RateLimiter var1, ListeningScheduledExecutorService var2, int var3) {
      Preconditions.checkArgument(var3 > 0, "Requested permitsPerTask must be positive");
      this.rateLimiter = var1.checkSupportsAsync();
      this.delegate = (ListeningScheduledExecutorService)Preconditions.checkNotNull(var2);
      this.permitsPerTask = var3;
   }

   public ListenableFuture submit(Runnable var1, @Nullable Object var2) {
      Preconditions.checkNotNull(var1);
      return this.delegate.schedule(Executors.callable(var1, var2), this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
   }

   public ListenableFuture submit(Callable var1) {
      Preconditions.checkNotNull(var1);
      return this.delegate.schedule(var1, this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
   }

   public ListenableFuture submit(Runnable var1) {
      Preconditions.checkNotNull(var1);
      return this.delegate.schedule(var1, this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
   }

   public void execute(Runnable var1) {
      Preconditions.checkNotNull(var1);
      this.delegate.schedule(var1, this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
   }

   public boolean isShutdown() {
      return this.delegate.isShutdown();
   }

   public boolean isTerminated() {
      return this.delegate.isTerminated();
   }

   public void shutdown() {
      this.delegate.shutdown();
   }

   public List shutdownNow() {
      return this.delegate.shutdownNow();
   }

   public boolean awaitTermination(long var1, TimeUnit var3) {
      return this.delegate.awaitTermination(var1, var3);
   }
}
