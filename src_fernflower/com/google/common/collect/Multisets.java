package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$1;
import com.google.common.collect.Multisets$2;
import com.google.common.collect.Multisets$3;
import com.google.common.collect.Multisets$4;
import com.google.common.collect.Multisets$5;
import com.google.common.collect.Multisets$FilteredMultiset;
import com.google.common.collect.Multisets$ImmutableEntry;
import com.google.common.collect.Multisets$MultisetIteratorImpl;
import com.google.common.collect.Multisets$UnmodifiableMultiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.UnmodifiableSortedMultiset;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class Multisets {
   private static final Ordering DECREASING_COUNT_ORDERING = new Multisets$5();

   public static Multiset unmodifiableMultiset(Multiset var0) {
      return (Multiset)(!(var0 instanceof Multisets$UnmodifiableMultiset) && !(var0 instanceof ImmutableMultiset)?new Multisets$UnmodifiableMultiset((Multiset)Preconditions.checkNotNull(var0)):var0);
   }

   @Deprecated
   public static Multiset unmodifiableMultiset(ImmutableMultiset var0) {
      return (Multiset)Preconditions.checkNotNull(var0);
   }

   @Beta
   public static SortedMultiset unmodifiableSortedMultiset(SortedMultiset var0) {
      return new UnmodifiableSortedMultiset((SortedMultiset)Preconditions.checkNotNull(var0));
   }

   public static Multiset$Entry immutableEntry(@Nullable Object var0, int var1) {
      return new Multisets$ImmutableEntry(var0, var1);
   }

   @CheckReturnValue
   @Beta
   public static Multiset filter(Multiset var0, Predicate var1) {
      if(var0 instanceof Multisets$FilteredMultiset) {
         Multisets$FilteredMultiset var2 = (Multisets$FilteredMultiset)var0;
         Predicate var3 = Predicates.and(var2.predicate, var1);
         return new Multisets$FilteredMultiset(var2.unfiltered, var3);
      } else {
         return new Multisets$FilteredMultiset(var0, var1);
      }
   }

   static int inferDistinctElements(Iterable var0) {
      return var0 instanceof Multiset?((Multiset)var0).elementSet().size():11;
   }

   @Beta
   public static Multiset union(Multiset var0, Multiset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Multisets$1(var0, var1);
   }

   public static Multiset intersection(Multiset var0, Multiset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Multisets$2(var0, var1);
   }

   @Beta
   public static Multiset sum(Multiset var0, Multiset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Multisets$3(var0, var1);
   }

   @Beta
   public static Multiset difference(Multiset var0, Multiset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Multisets$4(var0, var1);
   }

   public static boolean containsOccurrences(Multiset var0, Multiset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Iterator var2 = var1.entrySet().iterator();

      Multiset$Entry var3;
      int var4;
      do {
         if(!var2.hasNext()) {
            return true;
         }

         var3 = (Multiset$Entry)var2.next();
         var4 = var0.count(var3.getElement());
      } while(var4 >= var3.getCount());

      return false;
   }

   public static boolean retainOccurrences(Multiset var0, Multiset var1) {
      return retainOccurrencesImpl(var0, var1);
   }

   private static boolean retainOccurrencesImpl(Multiset var0, Multiset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Iterator var2 = var0.entrySet().iterator();
      boolean var3 = false;

      while(var2.hasNext()) {
         Multiset$Entry var4 = (Multiset$Entry)var2.next();
         int var5 = var1.count(var4.getElement());
         if(var5 == 0) {
            var2.remove();
            var3 = true;
         } else if(var5 < var4.getCount()) {
            var0.setCount(var4.getElement(), var5);
            var3 = true;
         }
      }

      return var3;
   }

   public static boolean removeOccurrences(Multiset var0, Iterable var1) {
      if(var1 instanceof Multiset) {
         return removeOccurrences(var0, (Multiset)var1);
      } else {
         Preconditions.checkNotNull(var0);
         Preconditions.checkNotNull(var1);
         boolean var2 = false;

         Object var4;
         for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 |= var0.remove(var4)) {
            var4 = var3.next();
         }

         return var2;
      }
   }

   public static boolean removeOccurrences(Multiset var0, Multiset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      boolean var2 = false;
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Multiset$Entry var4 = (Multiset$Entry)var3.next();
         int var5 = var1.count(var4.getElement());
         if(var5 >= var4.getCount()) {
            var3.remove();
            var2 = true;
         } else if(var5 > 0) {
            var0.remove(var4.getElement(), var5);
            var2 = true;
         }
      }

      return var2;
   }

   static boolean equalsImpl(Multiset var0, @Nullable Object var1) {
      if(var1 == var0) {
         return true;
      } else if(var1 instanceof Multiset) {
         Multiset var2 = (Multiset)var1;
         if(var0.size() == var2.size() && var0.entrySet().size() == var2.entrySet().size()) {
            Iterator var3 = var2.entrySet().iterator();

            Multiset$Entry var4;
            do {
               if(!var3.hasNext()) {
                  return true;
               }

               var4 = (Multiset$Entry)var3.next();
            } while(var0.count(var4.getElement()) == var4.getCount());

            return false;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   static boolean addAllImpl(Multiset var0, Collection var1) {
      if(var1.isEmpty()) {
         return false;
      } else {
         if(var1 instanceof Multiset) {
            Multiset var2 = cast(var1);
            Iterator var3 = var2.entrySet().iterator();

            while(var3.hasNext()) {
               Multiset$Entry var4 = (Multiset$Entry)var3.next();
               var0.add(var4.getElement(), var4.getCount());
            }
         } else {
            Iterators.addAll(var0, var1.iterator());
         }

         return true;
      }
   }

   static boolean removeAllImpl(Multiset var0, Collection var1) {
      Object var2 = var1 instanceof Multiset?((Multiset)var1).elementSet():var1;
      return var0.elementSet().removeAll((Collection)var2);
   }

   static boolean retainAllImpl(Multiset var0, Collection var1) {
      Preconditions.checkNotNull(var1);
      Object var2 = var1 instanceof Multiset?((Multiset)var1).elementSet():var1;
      return var0.elementSet().retainAll((Collection)var2);
   }

   static int setCountImpl(Multiset var0, Object var1, int var2) {
      CollectPreconditions.checkNonnegative(var2, "count");
      int var3 = var0.count(var1);
      int var4 = var2 - var3;
      if(var4 > 0) {
         var0.add(var1, var4);
      } else if(var4 < 0) {
         var0.remove(var1, -var4);
      }

      return var3;
   }

   static boolean setCountImpl(Multiset var0, Object var1, int var2, int var3) {
      CollectPreconditions.checkNonnegative(var2, "oldCount");
      CollectPreconditions.checkNonnegative(var3, "newCount");
      if(var0.count(var1) == var2) {
         var0.setCount(var1, var3);
         return true;
      } else {
         return false;
      }
   }

   static Iterator iteratorImpl(Multiset var0) {
      return new Multisets$MultisetIteratorImpl(var0, var0.entrySet().iterator());
   }

   static int sizeImpl(Multiset var0) {
      long var1 = 0L;

      Multiset$Entry var4;
      for(Iterator var3 = var0.entrySet().iterator(); var3.hasNext(); var1 += (long)var4.getCount()) {
         var4 = (Multiset$Entry)var3.next();
      }

      return Ints.saturatedCast(var1);
   }

   static Multiset cast(Iterable var0) {
      return (Multiset)var0;
   }

   @Beta
   public static ImmutableMultiset copyHighestCountFirst(Multiset var0) {
      ImmutableList var1 = DECREASING_COUNT_ORDERING.immutableSortedCopy(var0.entrySet());
      return ImmutableMultiset.copyFromEntries(var1);
   }
}
