package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.io.Closer$LoggingSuppressor;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.lang.reflect.Method;

@VisibleForTesting
final class Closer$SuppressingSuppressor implements Closer$Suppressor {
   static final Closer$SuppressingSuppressor INSTANCE = new Closer$SuppressingSuppressor();
   static final Method addSuppressed = getAddSuppressed();

   static boolean isAvailable() {
      return addSuppressed != null;
   }

   private static Method getAddSuppressed() {
      try {
         return Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});
      } catch (Throwable var1) {
         return null;
      }
   }

   public void suppress(Closeable var1, Throwable var2, Throwable var3) {
      if(var2 != var3) {
         try {
            addSuppressed.invoke(var2, new Object[]{var3});
         } catch (Throwable var5) {
            Closer$LoggingSuppressor.INSTANCE.suppress(var1, var2, var3);
         }

      }
   }
}
