package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.io.Closeables;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.util.logging.Level;
import java.util.logging.Logger;

@VisibleForTesting
final class Closer$LoggingSuppressor implements Closer$Suppressor {
   static final Closer$LoggingSuppressor INSTANCE = new Closer$LoggingSuppressor();

   public void suppress(Closeable var1, Throwable var2, Throwable var3) {
      Logger var10000 = Closeables.logger;
      Level var10001 = Level.WARNING;
      String var4 = String.valueOf(var1);
      var10000.log(var10001, (new StringBuilder(42 + String.valueOf(var4).length())).append("Suppressing exception thrown when closing ").append(var4).toString(), var3);
   }
}
