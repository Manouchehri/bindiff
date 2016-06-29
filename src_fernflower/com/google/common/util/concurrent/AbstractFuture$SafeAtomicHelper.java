package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$Waiter;

final class AbstractFuture$SafeAtomicHelper extends AbstractFuture$AtomicHelper {
   private AbstractFuture$SafeAtomicHelper() {
      super((AbstractFuture$1)null);
   }

   void putThread(AbstractFuture$Waiter var1, Thread var2) {
      AbstractFuture.access$600().lazySet(var1, var2);
   }

   void putNext(AbstractFuture$Waiter var1, AbstractFuture$Waiter var2) {
      AbstractFuture.access$700().lazySet(var1, var2);
   }

   boolean casWaiters(AbstractFuture var1, AbstractFuture$Waiter var2, AbstractFuture$Waiter var3) {
      return AbstractFuture.access$800().compareAndSet(var1, var2, var3);
   }

   boolean casListeners(AbstractFuture var1, AbstractFuture$Listener var2, AbstractFuture$Listener var3) {
      return AbstractFuture.access$900().compareAndSet(var1, var2, var3);
   }

   boolean casValue(AbstractFuture var1, Object var2, Object var3) {
      return AbstractFuture.access$1000().compareAndSet(var1, var2, var3);
   }

   // $FF: synthetic method
   AbstractFuture$SafeAtomicHelper(AbstractFuture$1 var1) {
      this();
   }
}
