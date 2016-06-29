package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2$1;
import com.google.common.collect.Collections2$FilteredCollection;
import com.google.common.collect.Collections2$OrderedPermutationCollection;
import com.google.common.collect.Collections2$PermutationCollection;
import com.google.common.collect.Collections2$TransformedCollection;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Collections2 {
   static final Joiner STANDARD_JOINER = Joiner.on(", ").useForNull("null");

   @CheckReturnValue
   public static Collection filter(Collection var0, Predicate var1) {
      return var0 instanceof Collections2$FilteredCollection?((Collections2$FilteredCollection)var0).createCombined(var1):new Collections2$FilteredCollection((Collection)Preconditions.checkNotNull(var0), (Predicate)Preconditions.checkNotNull(var1));
   }

   static boolean safeContains(Collection var0, @Nullable Object var1) {
      Preconditions.checkNotNull(var0);

      try {
         return var0.contains(var1);
      } catch (ClassCastException var3) {
         return false;
      } catch (NullPointerException var4) {
         return false;
      }
   }

   static boolean safeRemove(Collection var0, @Nullable Object var1) {
      Preconditions.checkNotNull(var0);

      try {
         return var0.remove(var1);
      } catch (ClassCastException var3) {
         return false;
      } catch (NullPointerException var4) {
         return false;
      }
   }

   public static Collection transform(Collection var0, Function var1) {
      return new Collections2$TransformedCollection(var0, var1);
   }

   static boolean containsAllImpl(Collection var0, Collection var1) {
      return Iterables.all(var1, Predicates.in(var0));
   }

   static String toStringImpl(Collection var0) {
      StringBuilder var1 = newStringBuilderForCollection(var0.size()).append('[');
      STANDARD_JOINER.appendTo(var1, Iterables.transform(var0, new Collections2$1(var0)));
      return var1.append(']').toString();
   }

   static StringBuilder newStringBuilderForCollection(int var0) {
      CollectPreconditions.checkNonnegative(var0, "size");
      return new StringBuilder((int)Math.min((long)var0 * 8L, 1073741824L));
   }

   static Collection cast(Iterable var0) {
      return (Collection)var0;
   }

   @Beta
   public static Collection orderedPermutations(Iterable var0) {
      return orderedPermutations(var0, Ordering.natural());
   }

   @Beta
   public static Collection orderedPermutations(Iterable var0, Comparator var1) {
      return new Collections2$OrderedPermutationCollection(var0, var1);
   }

   @Beta
   public static Collection permutations(Collection var0) {
      return new Collections2$PermutationCollection(ImmutableList.copyOf(var0));
   }

   private static boolean isPermutation(List var0, List var1) {
      if(var0.size() != var1.size()) {
         return false;
      } else {
         HashMultiset var2 = HashMultiset.create(var0);
         HashMultiset var3 = HashMultiset.create(var1);
         return var2.equals(var3);
      }
   }

   private static boolean isPositiveInt(long var0) {
      return var0 >= 0L && var0 <= 2147483647L;
   }

   // $FF: synthetic method
   static boolean access$000(long var0) {
      return isPositiveInt(var0);
   }

   // $FF: synthetic method
   static boolean access$100(List var0, List var1) {
      return isPermutation(var0, var1);
   }
}
