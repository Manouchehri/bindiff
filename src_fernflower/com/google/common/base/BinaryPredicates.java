package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.BinaryPredicate;
import com.google.common.base.BinaryPredicates$AlwaysFalse;
import com.google.common.base.BinaryPredicates$AlwaysTrue;
import com.google.common.base.BinaryPredicates$And;
import com.google.common.base.BinaryPredicates$Equality;
import com.google.common.base.BinaryPredicates$First;
import com.google.common.base.BinaryPredicates$Identity;
import com.google.common.base.BinaryPredicates$Not;
import com.google.common.base.BinaryPredicates$Or;
import com.google.common.base.BinaryPredicates$Second;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GoogleInternal
@GwtCompatible
public final class BinaryPredicates {
   @GwtCompatible(
      serializable = true
   )
   public static BinaryPredicate alwaysTrue() {
      return restrict(BinaryPredicates$AlwaysTrue.AlwaysTrue);
   }

   @GwtCompatible(
      serializable = true
   )
   public static BinaryPredicate alwaysFalse() {
      return restrict(BinaryPredicates$AlwaysFalse.AlwaysFalse);
   }

   @GwtCompatible(
      serializable = true
   )
   public static BinaryPredicate equality() {
      return restrict(BinaryPredicates$Equality.Equality);
   }

   @GwtCompatible(
      serializable = true
   )
   public static BinaryPredicate identity() {
      return restrict(BinaryPredicates$Identity.Identity);
   }

   public static BinaryPredicate first(Predicate var0) {
      return new BinaryPredicates$First(var0);
   }

   public static BinaryPredicate second(Predicate var0) {
      return new BinaryPredicates$Second(var0);
   }

   public static BinaryPredicate and(BinaryPredicate var0, BinaryPredicate var1) {
      BinaryPredicate var2 = restrict(var0);
      BinaryPredicate var3 = restrict(var1);
      List var4 = Arrays.asList(new BinaryPredicate[]{var2, var3});
      return new BinaryPredicates$And(var4);
   }

   public static BinaryPredicate and(BinaryPredicate... var0) {
      return new BinaryPredicates$And(Arrays.asList(var0));
   }

   public static BinaryPredicate and(Iterable var0) {
      return new BinaryPredicates$And(var0);
   }

   public static BinaryPredicate or(BinaryPredicate var0, BinaryPredicate var1) {
      BinaryPredicate var2 = restrict(var0);
      BinaryPredicate var3 = restrict(var1);
      List var4 = Arrays.asList(new BinaryPredicate[]{var2, var3});
      return new BinaryPredicates$Or(var4);
   }

   public static BinaryPredicate or(BinaryPredicate... var0) {
      return new BinaryPredicates$Or(Arrays.asList(var0));
   }

   public static BinaryPredicate or(Iterable var0) {
      return new BinaryPredicates$Or(var0);
   }

   public static BinaryPredicate not(BinaryPredicate var0) {
      return new BinaryPredicates$Not(var0);
   }

   private static BinaryPredicate restrict(@Nullable BinaryPredicate var0) {
      return var0;
   }

   private static boolean iterableElementsEqual(Iterable var0, Iterable var1) {
      Iterator var2 = var0.iterator();
      Iterator var3 = var1.iterator();

      do {
         if(!var2.hasNext()) {
            return !var3.hasNext();
         }

         if(!var3.hasNext()) {
            return false;
         }
      } while(var2.next().equals(var3.next()));

      return false;
   }

   private static int iterableAsListHashCode(Iterable var0) {
      Iterator var1 = var0.iterator();

      int var2;
      Object var3;
      for(var2 = 1; var1.hasNext(); var2 = 31 * var2 + var3.hashCode()) {
         var3 = var1.next();
      }

      return var2;
   }

   // $FF: synthetic method
   static boolean access$000(Iterable var0, Iterable var1) {
      return iterableElementsEqual(var0, var1);
   }

   // $FF: synthetic method
   static int access$100(Iterable var0) {
      return iterableAsListHashCode(var0);
   }
}
