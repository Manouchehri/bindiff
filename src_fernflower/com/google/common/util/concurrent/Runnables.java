package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.Runnables$1;

@Beta
@GwtCompatible
public final class Runnables {
   private static final Runnable EMPTY_RUNNABLE = new Runnables$1();

   public static Runnable doNothing() {
      return EMPTY_RUNNABLE;
   }
}
