package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.io.Closer$LoggingSuppressor;
import com.google.common.io.Closer$SuppressingSuppressor;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.annotation.Nullable;

@Beta
public final class Closer implements Closeable {
   private static final Closer$Suppressor SUPPRESSOR;
   @VisibleForTesting
   final Closer$Suppressor suppressor;
   private final Deque stack = new ArrayDeque(4);
   private Throwable thrown;

   public static Closer create() {
      return new Closer(SUPPRESSOR);
   }

   @VisibleForTesting
   Closer(Closer$Suppressor var1) {
      this.suppressor = (Closer$Suppressor)Preconditions.checkNotNull(var1);
   }

   public Closeable register(@Nullable Closeable var1) {
      if(var1 != null) {
         this.stack.addFirst(var1);
      }

      return var1;
   }

   public RuntimeException rethrow(Throwable var1) {
      Preconditions.checkNotNull(var1);
      this.thrown = var1;
      Throwables.propagateIfPossible(var1, IOException.class);
      throw new RuntimeException(var1);
   }

   public RuntimeException rethrow(Throwable var1, Class var2) {
      Preconditions.checkNotNull(var1);
      this.thrown = var1;
      Throwables.propagateIfPossible(var1, IOException.class);
      Throwables.propagateIfPossible(var1, var2);
      throw new RuntimeException(var1);
   }

   public RuntimeException rethrow(Throwable var1, Class var2, Class var3) {
      Preconditions.checkNotNull(var1);
      this.thrown = var1;
      Throwables.propagateIfPossible(var1, IOException.class);
      Throwables.propagateIfPossible(var1, var2, var3);
      throw new RuntimeException(var1);
   }

   public void close() {
      Throwable var1 = this.thrown;

      while(!this.stack.isEmpty()) {
         Closeable var2 = (Closeable)this.stack.removeFirst();

         try {
            var2.close();
         } catch (Throwable var4) {
            if(var1 == null) {
               var1 = var4;
            } else {
               this.suppressor.suppress(var2, var1, var4);
            }
         }
      }

      if(this.thrown == null && var1 != null) {
         Throwables.propagateIfPossible(var1, IOException.class);
         throw new AssertionError(var1);
      }
   }

   static {
      SUPPRESSOR = (Closer$Suppressor)(Closer$SuppressingSuppressor.isAvailable()?Closer$SuppressingSuppressor.INSTANCE:Closer$LoggingSuppressor.INSTANCE);
   }
}
