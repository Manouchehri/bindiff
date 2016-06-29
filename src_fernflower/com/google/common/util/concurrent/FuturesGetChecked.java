package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.FuturesGetChecked$1;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

final class FuturesGetChecked {
   private static final Ordering WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new FuturesGetChecked$1()).reverse();

   static Object getChecked(Future var0, Class var1) {
      return getChecked(bestGetCheckedTypeValidator(), var0, var1);
   }

   @VisibleForTesting
   static Object getChecked(FuturesGetChecked$GetCheckedTypeValidator var0, Future var1, Class var2) {
      var0.validateClass(var2);

      try {
         return var1.get();
      } catch (InterruptedException var4) {
         Thread.currentThread().interrupt();
         throw newWithCause(var2, var4);
      } catch (ExecutionException var5) {
         wrapAndThrowExceptionOrError(var5.getCause(), var2);
         throw new AssertionError();
      }
   }

   static Object getChecked(Future var0, Class var1, long var2, TimeUnit var4) {
      bestGetCheckedTypeValidator().validateClass(var1);

      try {
         return var0.get(var2, var4);
      } catch (InterruptedException var6) {
         Thread.currentThread().interrupt();
         throw newWithCause(var1, var6);
      } catch (TimeoutException var7) {
         throw newWithCause(var1, var7);
      } catch (ExecutionException var8) {
         wrapAndThrowExceptionOrError(var8.getCause(), var1);
         throw new AssertionError();
      }
   }

   private static FuturesGetChecked$GetCheckedTypeValidator bestGetCheckedTypeValidator() {
      return FuturesGetChecked$GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
   }

   @VisibleForTesting
   static FuturesGetChecked$GetCheckedTypeValidator weakSetValidator() {
      return FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.INSTANCE;
   }

   @VisibleForTesting
   static FuturesGetChecked$GetCheckedTypeValidator classValueValidator() {
      return FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.INSTANCE;
   }

   private static void wrapAndThrowExceptionOrError(Throwable var0, Class var1) {
      if(var0 instanceof Error) {
         throw new ExecutionError((Error)var0);
      } else if(var0 instanceof RuntimeException) {
         throw new UncheckedExecutionException(var0);
      } else {
         throw newWithCause(var1, var0);
      }
   }

   private static boolean hasConstructorUsableByGetChecked(Class var0) {
      try {
         newWithCause(var0, new Exception());
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   private static Exception newWithCause(Class var0, Throwable var1) {
      List var2 = Arrays.asList(var0.getConstructors());
      Iterator var3 = preferringStrings(var2).iterator();

      Exception var5;
      do {
         if(!var3.hasNext()) {
            String var6 = String.valueOf(var0);
            throw new IllegalArgumentException((new StringBuilder(82 + String.valueOf(var6).length())).append("No appropriate constructor for exception of type ").append(var6).append(" in response to chained exception").toString(), var1);
         }

         Constructor var4 = (Constructor)var3.next();
         var5 = (Exception)newFromConstructor(var4, var1);
      } while(var5 == null);

      if(var5.getCause() == null) {
         var5.initCause(var1);
      }

      return var5;
   }

   private static List preferringStrings(List var0) {
      return WITH_STRING_PARAM_FIRST.sortedCopy(var0);
   }

   @Nullable
   private static Object newFromConstructor(Constructor var0, Throwable var1) {
      Class[] var2 = var0.getParameterTypes();
      Object[] var3 = new Object[var2.length];

      for(int var4 = 0; var4 < var2.length; ++var4) {
         Class var5 = var2[var4];
         if(var5.equals(String.class)) {
            var3[var4] = var1.toString();
         } else {
            if(!var5.equals(Throwable.class)) {
               return null;
            }

            var3[var4] = var1;
         }
      }

      try {
         return var0.newInstance(var3);
      } catch (IllegalArgumentException var6) {
         return null;
      } catch (InstantiationException var7) {
         return null;
      } catch (IllegalAccessException var8) {
         return null;
      } catch (InvocationTargetException var9) {
         return null;
      }
   }

   @VisibleForTesting
   static boolean isCheckedException(Class var0) {
      return !RuntimeException.class.isAssignableFrom(var0);
   }

   @VisibleForTesting
   static void checkExceptionClassValidity(Class var0) {
      Preconditions.checkArgument(isCheckedException(var0), "Futures.getChecked exception type (%s) must not be a RuntimeException", new Object[]{var0});
      Preconditions.checkArgument(hasConstructorUsableByGetChecked(var0), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", new Object[]{var0});
   }
}
