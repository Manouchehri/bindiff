package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;

class FinalizableReferenceQueue$SystemLoader implements FinalizableReferenceQueue$FinalizerLoader {
   @VisibleForTesting
   static boolean disabled;

   public Class loadFinalizer() {
      if(disabled) {
         return null;
      } else {
         ClassLoader var1;
         try {
            var1 = ClassLoader.getSystemClassLoader();
         } catch (SecurityException var4) {
            FinalizableReferenceQueue.access$000().info("Not allowed to access system class loader.");
            return null;
         }

         if(var1 != null) {
            try {
               return var1.loadClass("com.google.common.base.internal.Finalizer");
            } catch (ClassNotFoundException var3) {
               return null;
            }
         } else {
            return null;
         }
      }
   }
}
