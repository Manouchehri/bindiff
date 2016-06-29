package com.google.common.util.concurrent;

import com.google.common.util.concurrent.UncaughtExceptionHandlers$Exiter;
import java.lang.Thread.UncaughtExceptionHandler;

public final class UncaughtExceptionHandlers {
   public static UncaughtExceptionHandler systemExit() {
      return new UncaughtExceptionHandlers$Exiter(Runtime.getRuntime());
   }
}
