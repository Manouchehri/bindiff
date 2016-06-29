package com.google.common.base;

import com.google.common.base.FinalizableReference;
import com.google.common.base.FinalizableReferenceQueue$DecoupledLoader;
import com.google.common.base.FinalizableReferenceQueue$DirectLoader;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;
import com.google.common.base.FinalizableReferenceQueue$SystemLoader;
import java.io.Closeable;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalizableReferenceQueue implements Closeable {
   private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
   private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
   private static final Method startFinalizer;
   final ReferenceQueue queue = new ReferenceQueue();
   final PhantomReference frqRef;
   final boolean threadStarted;

   public FinalizableReferenceQueue() {
      this.frqRef = new PhantomReference(this, this.queue);
      boolean var1 = false;

      try {
         startFinalizer.invoke((Object)null, new Object[]{FinalizableReference.class, this.queue, this.frqRef});
         var1 = true;
      } catch (IllegalAccessException var3) {
         throw new AssertionError(var3);
      } catch (Throwable var4) {
         logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", var4);
      }

      this.threadStarted = var1;
   }

   public void close() {
      this.frqRef.enqueue();
      this.cleanUp();
   }

   void cleanUp() {
      if(!this.threadStarted) {
         Reference var1;
         while((var1 = this.queue.poll()) != null) {
            var1.clear();

            try {
               ((FinalizableReference)var1).finalizeReferent();
            } catch (Throwable var3) {
               logger.log(Level.SEVERE, "Error cleaning up after reference.", var3);
            }
         }

      }
   }

   private static Class loadFinalizer(FinalizableReferenceQueue$FinalizerLoader... var0) {
      FinalizableReferenceQueue$FinalizerLoader[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         FinalizableReferenceQueue$FinalizerLoader var4 = var1[var3];
         Class var5 = var4.loadFinalizer();
         if(var5 != null) {
            return var5;
         }
      }

      throw new AssertionError();
   }

   static Method getStartFinalizer(Class var0) {
      try {
         return var0.getMethod("startFinalizer", new Class[]{Class.class, ReferenceQueue.class, PhantomReference.class});
      } catch (NoSuchMethodException var2) {
         throw new AssertionError(var2);
      }
   }

   // $FF: synthetic method
   static Logger access$000() {
      return logger;
   }

   static {
      Class var0 = loadFinalizer(new FinalizableReferenceQueue$FinalizerLoader[]{new FinalizableReferenceQueue$SystemLoader(), new FinalizableReferenceQueue$DecoupledLoader(), new FinalizableReferenceQueue$DirectLoader()});
      startFinalizer = getStartFinalizer(var0);
   }
}
