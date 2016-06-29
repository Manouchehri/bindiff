package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Cancellation;
import com.google.common.util.concurrent.AbstractFuture$Failure;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$SafeAtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$SetFuture;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Waiter;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public abstract class AbstractFuture implements ListenableFuture {
   private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
   private static final long SPIN_THRESHOLD_NANOS = 1000L;
   private static final AbstractFuture$AtomicHelper ATOMIC_HELPER;
   private static final AtomicReferenceFieldUpdater WAITER_THREAD_UPDATER;
   private static final AtomicReferenceFieldUpdater WAITER_NEXT_UPDATER;
   private static final AtomicReferenceFieldUpdater WAITERS_UPDATER;
   private static final AtomicReferenceFieldUpdater LISTENERS_UPDATER;
   private static final AtomicReferenceFieldUpdater VALUE_UPDATER;
   private static final Object NULL;
   private volatile Object value;
   private volatile AbstractFuture$Listener listeners;
   private volatile AbstractFuture$Waiter waiters;

   private void removeWaiter(AbstractFuture$Waiter var1) {
      var1.thread = null;

      label28:
      while(true) {
         AbstractFuture$Waiter var2 = null;
         AbstractFuture$Waiter var3 = this.waiters;
         if(var3 == AbstractFuture$Waiter.TOMBSTONE) {
            return;
         }

         AbstractFuture$Waiter var4;
         for(; var3 != null; var3 = var4) {
            var4 = var3.next;
            if(var3.thread != null) {
               var2 = var3;
            } else if(var2 != null) {
               var2.next = var4;
               if(var2.thread == null) {
                  continue label28;
               }
            } else if(!ATOMIC_HELPER.casWaiters(this, var3, var4)) {
               continue label28;
            }
         }

         return;
      }
   }

   public Object get(long var1, TimeUnit var3) {
      long var4 = var3.toNanos(var1);
      if(Thread.interrupted()) {
         throw new InterruptedException();
      } else {
         Object var6 = this.value;
         if(var6 != null & !(var6 instanceof AbstractFuture$SetFuture)) {
            return this.getDoneValue(var6);
         } else {
            long var7 = var4 > 0L?System.nanoTime() + var4:0L;
            if(var4 >= 1000L) {
               label117: {
                  AbstractFuture$Waiter var9 = this.waiters;
                  if(var9 != AbstractFuture$Waiter.TOMBSTONE) {
                     AbstractFuture$Waiter var10 = new AbstractFuture$Waiter();

                     do {
                        var10.setNext(var9);
                        if(ATOMIC_HELPER.casWaiters(this, var9, var10)) {
                           do {
                              LockSupport.parkNanos(this, var4);
                              if(Thread.interrupted()) {
                                 this.removeWaiter(var10);
                                 throw new InterruptedException();
                              }

                              var6 = this.value;
                              if(var6 != null & !(var6 instanceof AbstractFuture$SetFuture)) {
                                 return this.getDoneValue(var6);
                              }

                              var4 = var7 - System.nanoTime();
                           } while(var4 >= 1000L);

                           this.removeWaiter(var10);
                           break label117;
                        }

                        var9 = this.waiters;
                     } while(var9 != AbstractFuture$Waiter.TOMBSTONE);
                  }

                  return this.getDoneValue(this.value);
               }
            }

            while(var4 > 0L) {
               var6 = this.value;
               if(var6 != null & !(var6 instanceof AbstractFuture$SetFuture)) {
                  return this.getDoneValue(var6);
               }

               if(Thread.interrupted()) {
                  throw new InterruptedException();
               }

               var4 = var7 - System.nanoTime();
            }

            throw new TimeoutException();
         }
      }
   }

   public Object get() {
      if(Thread.interrupted()) {
         throw new InterruptedException();
      } else {
         Object var1 = this.value;
         if(var1 != null & !(var1 instanceof AbstractFuture$SetFuture)) {
            return this.getDoneValue(var1);
         } else {
            AbstractFuture$Waiter var2 = this.waiters;
            if(var2 != AbstractFuture$Waiter.TOMBSTONE) {
               AbstractFuture$Waiter var3 = new AbstractFuture$Waiter();

               do {
                  var3.setNext(var2);
                  if(ATOMIC_HELPER.casWaiters(this, var2, var3)) {
                     do {
                        LockSupport.park(this);
                        if(Thread.interrupted()) {
                           this.removeWaiter(var3);
                           throw new InterruptedException();
                        }

                        var1 = this.value;
                     } while(!(var1 != null & !(var1 instanceof AbstractFuture$SetFuture)));

                     return this.getDoneValue(var1);
                  }

                  var2 = this.waiters;
               } while(var2 != AbstractFuture$Waiter.TOMBSTONE);
            }

            return this.getDoneValue(this.value);
         }
      }
   }

   private Object getDoneValue(Object var1) {
      if(var1 instanceof AbstractFuture$Cancellation) {
         throw cancellationExceptionWithCause("Task was cancelled.", ((AbstractFuture$Cancellation)var1).cause);
      } else if(var1 instanceof AbstractFuture$Failure) {
         throw new ExecutionException(((AbstractFuture$Failure)var1).exception);
      } else {
         return var1 == NULL?null:var1;
      }
   }

   public boolean isDone() {
      Object var1 = this.value;
      return var1 != null & !(var1 instanceof AbstractFuture$SetFuture);
   }

   public boolean isCancelled() {
      Object var1 = this.value;
      return var1 instanceof AbstractFuture$Cancellation;
   }

   public boolean cancel(boolean var1) {
      Object var2 = this.value;
      if(var2 == null | var2 instanceof AbstractFuture$SetFuture) {
         AbstractFuture$Cancellation var3 = new AbstractFuture$Cancellation(var1, this.newCancellationCause());

         do {
            if(ATOMIC_HELPER.casValue(this, var2, var3)) {
               if(var1) {
                  this.interruptTask();
               }

               this.complete();
               if(var2 instanceof AbstractFuture$SetFuture) {
                  ((AbstractFuture$SetFuture)var2).future.cancel(var1);
               }

               return true;
            }

            var2 = this.value;
         } while(var2 instanceof AbstractFuture$SetFuture);
      }

      return false;
   }

   @Beta
   @ForOverride
   protected Throwable newCancellationCause() {
      return new CancellationException("Future.cancel() was called.");
   }

   protected void interruptTask() {
   }

   protected final boolean wasInterrupted() {
      Object var1 = this.value;
      return var1 instanceof AbstractFuture$Cancellation && ((AbstractFuture$Cancellation)var1).wasInterrupted;
   }

   public void addListener(Runnable var1, Executor var2) {
      Preconditions.checkNotNull(var1, "Runnable was null.");
      Preconditions.checkNotNull(var2, "Executor was null.");
      AbstractFuture$Listener var3 = this.listeners;
      if(var3 != AbstractFuture$Listener.TOMBSTONE) {
         AbstractFuture$Listener var4 = new AbstractFuture$Listener(var1, var2);

         do {
            var4.next = var3;
            if(ATOMIC_HELPER.casListeners(this, var3, var4)) {
               return;
            }

            var3 = this.listeners;
         } while(var3 != AbstractFuture$Listener.TOMBSTONE);
      }

      executeListener(var1, var2);
   }

   protected boolean set(@Nullable Object var1) {
      Object var2 = var1 == null?NULL:var1;
      if(ATOMIC_HELPER.casValue(this, (Object)null, var2)) {
         this.complete();
         return true;
      } else {
         return false;
      }
   }

   protected boolean setException(Throwable var1) {
      AbstractFuture$Failure var2 = new AbstractFuture$Failure((Throwable)Preconditions.checkNotNull(var1));
      if(ATOMIC_HELPER.casValue(this, (Object)null, var2)) {
         this.complete();
         return true;
      } else {
         return false;
      }
   }

   @Beta
   protected boolean setFuture(ListenableFuture var1) {
      Preconditions.checkNotNull(var1);
      Object var2 = this.value;
      if(var2 == null) {
         if(var1.isDone()) {
            return this.completeWithFuture(var1, (Object)null);
         }

         AbstractFuture$SetFuture var3 = new AbstractFuture$SetFuture(this, var1);
         if(ATOMIC_HELPER.casValue(this, (Object)null, var3)) {
            try {
               var1.addListener(var3, MoreExecutors.directExecutor());
            } catch (Throwable var8) {
               Throwable var4 = var8;

               AbstractFuture$Failure var5;
               try {
                  var5 = new AbstractFuture$Failure(var4);
               } catch (Throwable var7) {
                  var5 = AbstractFuture$Failure.FALLBACK_INSTANCE;
               }

               ATOMIC_HELPER.casValue(this, var3, var5);
            }

            return true;
         }

         var2 = this.value;
      }

      if(var2 instanceof AbstractFuture$Cancellation) {
         var1.cancel(((AbstractFuture$Cancellation)var2).wasInterrupted);
      }

      return false;
   }

   private boolean completeWithFuture(ListenableFuture var1, Object var2) {
      Object var3;
      if(var1 instanceof AbstractFuture$TrustedFuture) {
         var3 = ((AbstractFuture)var1).value;
      } else {
         try {
            Object var4 = Uninterruptibles.getUninterruptibly(var1);
            var3 = var4 == null?NULL:var4;
         } catch (ExecutionException var5) {
            var3 = new AbstractFuture$Failure(var5.getCause());
         } catch (CancellationException var6) {
            var3 = new AbstractFuture$Cancellation(false, var6);
         } catch (Throwable var7) {
            var3 = new AbstractFuture$Failure(var7);
         }
      }

      if(ATOMIC_HELPER.casValue(this, var2, var3)) {
         this.complete();
         return true;
      } else {
         return false;
      }
   }

   private void complete() {
      for(AbstractFuture$Waiter var1 = this.clearWaiters(); var1 != null; var1 = var1.next) {
         var1.unpark();
      }

      AbstractFuture$Listener var4 = this.clearListeners();

      AbstractFuture$Listener var2;
      AbstractFuture$Listener var3;
      for(var2 = null; var4 != null; var2 = var3) {
         var3 = var4;
         var4 = var4.next;
         var3.next = var2;
      }

      while(var2 != null) {
         executeListener(var2.task, var2.executor);
         var2 = var2.next;
      }

      this.done();
   }

   void done() {
   }

   final Throwable trustedGetException() {
      return ((AbstractFuture$Failure)this.value).exception;
   }

   final void maybePropagateCancellation(@Nullable Future var1) {
      if(var1 != null & this.isCancelled()) {
         var1.cancel(this.wasInterrupted());
      }

   }

   private AbstractFuture$Waiter clearWaiters() {
      AbstractFuture$Waiter var1;
      do {
         var1 = this.waiters;
      } while(!ATOMIC_HELPER.casWaiters(this, var1, AbstractFuture$Waiter.TOMBSTONE));

      return var1;
   }

   private AbstractFuture$Listener clearListeners() {
      AbstractFuture$Listener var1;
      do {
         var1 = this.listeners;
      } while(!ATOMIC_HELPER.casListeners(this, var1, AbstractFuture$Listener.TOMBSTONE));

      return var1;
   }

   private static void executeListener(Runnable var0, Executor var1) {
      try {
         var1.execute(var0);
      } catch (RuntimeException var5) {
         Logger var10000 = log;
         Level var10001 = Level.SEVERE;
         String var3 = String.valueOf(var0);
         String var4 = String.valueOf(var1);
         var10000.log(var10001, (new StringBuilder(57 + String.valueOf(var3).length() + String.valueOf(var4).length())).append("RuntimeException while executing runnable ").append(var3).append(" with executor ").append(var4).toString(), var5);
      }

   }

   static final CancellationException cancellationExceptionWithCause(@Nullable String var0, @Nullable Throwable var1) {
      CancellationException var2 = new CancellationException(var0);
      var2.initCause(var1);
      return var2;
   }

   // $FF: synthetic method
   static AbstractFuture$AtomicHelper access$200() {
      return ATOMIC_HELPER;
   }

   // $FF: synthetic method
   static Object access$300(AbstractFuture var0) {
      return var0.value;
   }

   // $FF: synthetic method
   static boolean access$400(AbstractFuture var0, ListenableFuture var1, Object var2) {
      return var0.completeWithFuture(var1, var2);
   }

   // $FF: synthetic method
   static AtomicReferenceFieldUpdater access$600() {
      return WAITER_THREAD_UPDATER;
   }

   // $FF: synthetic method
   static AtomicReferenceFieldUpdater access$700() {
      return WAITER_NEXT_UPDATER;
   }

   // $FF: synthetic method
   static AtomicReferenceFieldUpdater access$800() {
      return WAITERS_UPDATER;
   }

   // $FF: synthetic method
   static AtomicReferenceFieldUpdater access$900() {
      return LISTENERS_UPDATER;
   }

   // $FF: synthetic method
   static AtomicReferenceFieldUpdater access$1000() {
      return VALUE_UPDATER;
   }

   static {
      Object var0 = null;

      try {
         var0 = new AbstractFuture$UnsafeAtomicHelper((AbstractFuture$1)null);
      } catch (Throwable var2) {
         ;
      }

      if(var0 == null) {
         WAITER_THREAD_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture$Waiter.class, Thread.class, "thread");
         WAITER_NEXT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture$Waiter.class, AbstractFuture$Waiter.class, "next");
         WAITERS_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, AbstractFuture$Waiter.class, "waiters");
         LISTENERS_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, AbstractFuture$Listener.class, "listeners");
         VALUE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value");
         var0 = new AbstractFuture$SafeAtomicHelper((AbstractFuture$1)null);
      } else {
         WAITER_THREAD_UPDATER = null;
         WAITER_NEXT_UPDATER = null;
         WAITERS_UPDATER = null;
         LISTENERS_UPDATER = null;
         VALUE_UPDATER = null;
      }

      ATOMIC_HELPER = (AbstractFuture$AtomicHelper)var0;
      Class var1 = LockSupport.class;
      NULL = new Object();
   }
}
