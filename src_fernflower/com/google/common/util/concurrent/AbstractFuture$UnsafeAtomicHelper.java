package com.google.common.util.concurrent;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1;
import com.google.common.util.concurrent.AbstractFuture$Waiter;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

final class AbstractFuture$UnsafeAtomicHelper extends AbstractFuture$AtomicHelper {
   static final Unsafe UNSAFE;
   static final long LISTENERS_OFFSET;
   static final long WAITERS_OFFSET;
   static final long VALUE_OFFSET;
   static final long WAITER_THREAD_OFFSET;
   static final long WAITER_NEXT_OFFSET;

   private AbstractFuture$UnsafeAtomicHelper() {
      super((AbstractFuture$1)null);
   }

   void putThread(AbstractFuture$Waiter var1, Thread var2) {
      UNSAFE.putObject(var1, WAITER_THREAD_OFFSET, var2);
   }

   void putNext(AbstractFuture$Waiter var1, AbstractFuture$Waiter var2) {
      UNSAFE.putObject(var1, WAITER_NEXT_OFFSET, var2);
   }

   boolean casWaiters(AbstractFuture var1, AbstractFuture$Waiter var2, AbstractFuture$Waiter var3) {
      return UNSAFE.compareAndSwapObject(var1, WAITERS_OFFSET, var2, var3);
   }

   boolean casListeners(AbstractFuture var1, AbstractFuture$Listener var2, AbstractFuture$Listener var3) {
      return UNSAFE.compareAndSwapObject(var1, LISTENERS_OFFSET, var2, var3);
   }

   boolean casValue(AbstractFuture var1, Object var2, Object var3) {
      return UNSAFE.compareAndSwapObject(var1, VALUE_OFFSET, var2, var3);
   }

   // $FF: synthetic method
   AbstractFuture$UnsafeAtomicHelper(AbstractFuture$1 var1) {
      this();
   }

   static {
      Unsafe var0 = null;

      try {
         var0 = Unsafe.getUnsafe();
      } catch (SecurityException var5) {
         try {
            var0 = (Unsafe)AccessController.doPrivileged(new AbstractFuture$UnsafeAtomicHelper$1());
         } catch (PrivilegedActionException var4) {
            throw new RuntimeException("Could not initialize intrinsics", var4.getCause());
         }
      }

      try {
         Class var1 = AbstractFuture.class;
         WAITERS_OFFSET = var0.objectFieldOffset(var1.getDeclaredField("waiters"));
         LISTENERS_OFFSET = var0.objectFieldOffset(var1.getDeclaredField("listeners"));
         VALUE_OFFSET = var0.objectFieldOffset(var1.getDeclaredField("value"));
         WAITER_THREAD_OFFSET = var0.objectFieldOffset(AbstractFuture$Waiter.class.getDeclaredField("thread"));
         WAITER_NEXT_OFFSET = var0.objectFieldOffset(AbstractFuture$Waiter.class.getDeclaredField("next"));
         UNSAFE = var0;
      } catch (Exception var3) {
         throw Throwables.propagate(var3);
      }
   }
}
