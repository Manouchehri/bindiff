package com.google.common.base;

import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;

class FinalizableReferenceQueue$DirectLoader implements FinalizableReferenceQueue$FinalizerLoader {
   public Class loadFinalizer() {
      try {
         return Class.forName("com.google.common.base.internal.Finalizer");
      } catch (ClassNotFoundException var2) {
         throw new AssertionError(var2);
      }
   }
}
