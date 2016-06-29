package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables$1;
import com.google.common.util.concurrent.Callables$2;
import com.google.common.util.concurrent.Callables$3;
import com.google.common.util.concurrent.Callables$4;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Callables {
   public static Callable returning(@Nullable Object var0) {
      return new Callables$1(var0);
   }

   @GoogleInternal
   public static Callable throwing(Exception var0) {
      Preconditions.checkNotNull(var0);
      return new Callables$2(var0);
   }

   @GwtIncompatible("threads")
   public static Callable threadRenaming(Callable var0, Supplier var1) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var0);
      return new Callables$3(var1, var0);
   }

   @GwtIncompatible("threads")
   public static Runnable threadRenaming(Runnable var0, Supplier var1) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var0);
      return new Callables$4(var1, var0);
   }

   @GwtIncompatible("threads")
   private static boolean trySetName(String var0, Thread var1) {
      try {
         var1.setName(var0);
         return true;
      } catch (SecurityException var3) {
         return false;
      }
   }

   // $FF: synthetic method
   static boolean access$000(String var0, Thread var1) {
      return trySetName(var0, var1);
   }
}
