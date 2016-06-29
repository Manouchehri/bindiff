package com.google.common.base;

import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;

class FinalizableReferenceQueue$DecoupledLoader implements FinalizableReferenceQueue$FinalizerLoader {
   private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

   public Class loadFinalizer() {
      try {
         URLClassLoader var1 = this.newLoader(this.getBaseUrl());
         return var1.loadClass("com.google.common.base.internal.Finalizer");
      } catch (Exception var2) {
         FinalizableReferenceQueue.access$000().log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", var2);
         return null;
      }
   }

   URL getBaseUrl() {
      // $FF: Couldn't be decompiled
   }

   URLClassLoader newLoader(URL var1) {
      return new URLClassLoader(new URL[]{var1}, (ClassLoader)null);
   }
}
