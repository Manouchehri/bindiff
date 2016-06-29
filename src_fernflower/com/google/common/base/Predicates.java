package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import com.google.common.base.Predicates$AndPredicate;
import com.google.common.base.Predicates$AssignableFromPredicate;
import com.google.common.base.Predicates$CompositionPredicate;
import com.google.common.base.Predicates$ContainsPatternFromStringPredicate;
import com.google.common.base.Predicates$ContainsPatternPredicate;
import com.google.common.base.Predicates$InPredicate;
import com.google.common.base.Predicates$InstanceOfPredicate;
import com.google.common.base.Predicates$IsEqualToPredicate;
import com.google.common.base.Predicates$NotPredicate;
import com.google.common.base.Predicates$ObjectPredicate;
import com.google.common.base.Predicates$OrPredicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(
   emulated = true
)
public final class Predicates {
   private static final Joiner COMMA_JOINER = Joiner.on(',');

   @GwtCompatible(
      serializable = true
   )
   public static Predicate alwaysTrue() {
      return Predicates$ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
   }

   @GwtCompatible(
      serializable = true
   )
   public static Predicate alwaysFalse() {
      return Predicates$ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
   }

   @GwtCompatible(
      serializable = true
   )
   public static Predicate isNull() {
      return Predicates$ObjectPredicate.IS_NULL.withNarrowedType();
   }

   @GwtCompatible(
      serializable = true
   )
   public static Predicate notNull() {
      return Predicates$ObjectPredicate.NOT_NULL.withNarrowedType();
   }

   public static Predicate not(Predicate var0) {
      return new Predicates$NotPredicate(var0);
   }

   public static Predicate and(Iterable var0) {
      return new Predicates$AndPredicate(defensiveCopy(var0), (Predicates$1)null);
   }

   public static Predicate and(Predicate... var0) {
      return new Predicates$AndPredicate(defensiveCopy((Object[])var0), (Predicates$1)null);
   }

   public static Predicate and(Predicate var0, Predicate var1) {
      return new Predicates$AndPredicate(asList((Predicate)Preconditions.checkNotNull(var0), (Predicate)Preconditions.checkNotNull(var1)), (Predicates$1)null);
   }

   public static Predicate or(Iterable var0) {
      return new Predicates$OrPredicate(defensiveCopy(var0), (Predicates$1)null);
   }

   public static Predicate or(Predicate... var0) {
      return new Predicates$OrPredicate(defensiveCopy((Object[])var0), (Predicates$1)null);
   }

   public static Predicate or(Predicate var0, Predicate var1) {
      return new Predicates$OrPredicate(asList((Predicate)Preconditions.checkNotNull(var0), (Predicate)Preconditions.checkNotNull(var1)), (Predicates$1)null);
   }

   public static Predicate equalTo(@Nullable Object var0) {
      return (Predicate)(var0 == null?isNull():new Predicates$IsEqualToPredicate(var0, (Predicates$1)null));
   }

   @GwtIncompatible("Class.isInstance")
   public static Predicate instanceOf(Class var0) {
      return new Predicates$InstanceOfPredicate(var0, (Predicates$1)null);
   }

   @GwtIncompatible("Class.isAssignableFrom")
   @Beta
   public static Predicate assignableFrom(Class var0) {
      return new Predicates$AssignableFromPredicate(var0, (Predicates$1)null);
   }

   public static Predicate in(Collection var0) {
      return new Predicates$InPredicate(var0, (Predicates$1)null);
   }

   public static Predicate compose(Predicate var0, Function var1) {
      return new Predicates$CompositionPredicate(var0, var1, (Predicates$1)null);
   }

   @GwtIncompatible("java.util.regex.Pattern")
   public static Predicate containsPattern(String var0) {
      return new Predicates$ContainsPatternFromStringPredicate(var0);
   }

   @GwtIncompatible("java.util.regex.Pattern")
   public static Predicate contains(Pattern var0) {
      return new Predicates$ContainsPatternPredicate(var0);
   }

   private static List asList(Predicate var0, Predicate var1) {
      return Arrays.asList(new Predicate[]{var0, var1});
   }

   private static List defensiveCopy(Object... var0) {
      return defensiveCopy((Iterable)Arrays.asList(var0));
   }

   static List defensiveCopy(Iterable var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         var1.add(Preconditions.checkNotNull(var3));
      }

      return var1;
   }

   // $FF: synthetic method
   static Joiner access$800() {
      return COMMA_JOINER;
   }
}
