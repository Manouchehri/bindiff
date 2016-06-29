package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@VisibleForTesting
final class UncaughtExceptionHandlers$Exiter implements UncaughtExceptionHandler {
   private static final Logger logger = Logger.getLogger(UncaughtExceptionHandlers$Exiter.class.getName());
   private final Runtime runtime;

   UncaughtExceptionHandlers$Exiter(Runtime var1) {
      this.runtime = var1;
   }

   public void uncaughtException(Thread var1, Throwable var2) {
      try {
         logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[]{var1}), var2);
      } catch (Throwable var7) {
         System.err.println(var2.getMessage());
         System.err.println(var7.getMessage());
      } finally {
         this.runtime.exit(1);
      }

   }
}
