package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CartesianList;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists$1;
import com.google.common.collect.Lists$2;
import com.google.common.collect.Lists$AbstractListWrapper;
import com.google.common.collect.Lists$CharSequenceAsList;
import com.google.common.collect.Lists$OnePlusArrayList;
import com.google.common.collect.Lists$Partition;
import com.google.common.collect.Lists$RandomAccessPartition;
import com.google.common.collect.Lists$RandomAccessReverseList;
import com.google.common.collect.Lists$ReverseList;
import com.google.common.collect.Lists$StringAsImmutableList;
import com.google.common.collect.Lists$TransformingRandomAccessList;
import com.google.common.collect.Lists$TransformingSequentialList;
import com.google.common.collect.Lists$TwoPlusArrayList;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Lists {
   @GwtCompatible(
      serializable = true
   )
   public static ArrayList newArrayList() {
      return new ArrayList();
   }

   @GwtCompatible(
      serializable = true
   )
   public static ArrayList newArrayList(Object... var0) {
      Preconditions.checkNotNull(var0);
      int var1 = computeArrayListCapacity(var0.length);
      ArrayList var2 = new ArrayList(var1);
      Collections.addAll(var2, var0);
      return var2;
   }

   @VisibleForTesting
   static int computeArrayListCapacity(int var0) {
      CollectPreconditions.checkNonnegative(var0, "arraySize");
      return Ints.saturatedCast(5L + (long)var0 + (long)(var0 / 10));
   }

   @GwtCompatible(
      serializable = true
   )
   public static ArrayList newArrayList(Iterable var0) {
      Preconditions.checkNotNull(var0);
      return var0 instanceof Collection?new ArrayList(Collections2.cast(var0)):newArrayList(var0.iterator());
   }

   @GwtCompatible(
      serializable = true
   )
   public static ArrayList newArrayList(Iterator var0) {
      ArrayList var1 = newArrayList();
      Iterators.addAll(var1, var0);
      return var1;
   }

   @GwtCompatible(
      serializable = true
   )
   public static ArrayList newArrayListWithCapacity(int var0) {
      CollectPreconditions.checkNonnegative(var0, "initialArraySize");
      return new ArrayList(var0);
   }

   @GwtCompatible(
      serializable = true
   )
   public static ArrayList newArrayListWithExpectedSize(int var0) {
      return new ArrayList(computeArrayListCapacity(var0));
   }

   @GwtCompatible(
      serializable = true
   )
   public static LinkedList newLinkedList() {
      return new LinkedList();
   }

   @GwtCompatible(
      serializable = true
   )
   @GoogleInternal
   public static LinkedList newLinkedList(Object... var0) {
      LinkedList var1 = newLinkedList();
      Collections.addAll(var1, var0);
      return var1;
   }

   @GwtCompatible(
      serializable = true
   )
   public static LinkedList newLinkedList(Iterable var0) {
      LinkedList var1 = newLinkedList();
      Iterables.addAll(var1, var0);
      return var1;
   }

   @GwtCompatible(
      serializable = true
   )
   @GoogleInternal
   public static LinkedList newLinkedList(Iterator var0) {
      LinkedList var1 = newLinkedList();
      Iterators.addAll(var1, var0);
      return var1;
   }

   @GwtIncompatible("CopyOnWriteArrayList")
   public static CopyOnWriteArrayList newCopyOnWriteArrayList() {
      return new CopyOnWriteArrayList();
   }

   @GwtIncompatible("CopyOnWriteArrayList")
   public static CopyOnWriteArrayList newCopyOnWriteArrayList(Iterable var0) {
      Object var1 = var0 instanceof Collection?Collections2.cast(var0):newArrayList(var0);
      return new CopyOnWriteArrayList((Collection)var1);
   }

   public static List asList(@Nullable Object var0, Object[] var1) {
      return new Lists$OnePlusArrayList(var0, var1);
   }

   public static List asList(@Nullable Object var0, @Nullable Object var1, Object[] var2) {
      return new Lists$TwoPlusArrayList(var0, var1, var2);
   }

   public static List cartesianProduct(List var0) {
      return CartesianList.create(var0);
   }

   public static List cartesianProduct(List... var0) {
      return cartesianProduct(Arrays.asList(var0));
   }

   @CheckReturnValue
   public static List transform(List var0, Function var1) {
      return (List)(var0 instanceof RandomAccess?new Lists$TransformingRandomAccessList(var0, var1):new Lists$TransformingSequentialList(var0, var1));
   }

   public static List partition(List var0, int var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 > 0);
      return (List)(var0 instanceof RandomAccess?new Lists$RandomAccessPartition(var0, var1):new Lists$Partition(var0, var1));
   }

   @Beta
   public static ImmutableList charactersOf(String var0) {
      return new Lists$StringAsImmutableList((String)Preconditions.checkNotNull(var0));
   }

   @Beta
   public static List charactersOf(CharSequence var0) {
      return new Lists$CharSequenceAsList((CharSequence)Preconditions.checkNotNull(var0));
   }

   @CheckReturnValue
   public static List reverse(List var0) {
      return (List)(var0 instanceof ImmutableList?((ImmutableList)var0).reverse():(var0 instanceof Lists$ReverseList?((Lists$ReverseList)var0).getForwardList():(var0 instanceof RandomAccess?new Lists$RandomAccessReverseList(var0):new Lists$ReverseList(var0))));
   }

   static int hashCodeImpl(List var0) {
      int var1 = 1;

      for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = ~(~var1)) {
         Object var3 = var2.next();
         var1 = 31 * var1 + (var3 == null?0:var3.hashCode());
      }

      return var1;
   }

   static boolean equalsImpl(List var0, @Nullable Object var1) {
      if(var1 == Preconditions.checkNotNull(var0)) {
         return true;
      } else if(!(var1 instanceof List)) {
         return false;
      } else {
         List var2 = (List)var1;
         int var3 = var0.size();
         if(var3 != var2.size()) {
            return false;
         } else if(var0 instanceof RandomAccess && var2 instanceof RandomAccess) {
            for(int var4 = 0; var4 < var3; ++var4) {
               if(!Objects.equal(var0.get(var4), var2.get(var4))) {
                  return false;
               }
            }

            return true;
         } else {
            return Iterators.elementsEqual(var0.iterator(), var2.iterator());
         }
      }
   }

   static boolean addAllImpl(List var0, int var1, Iterable var2) {
      boolean var3 = false;
      ListIterator var4 = var0.listIterator(var1);

      for(Iterator var5 = var2.iterator(); var5.hasNext(); var3 = true) {
         Object var6 = var5.next();
         var4.add(var6);
      }

      return var3;
   }

   static int indexOfImpl(List var0, @Nullable Object var1) {
      if(var0 instanceof RandomAccess) {
         return indexOfRandomAccess(var0, var1);
      } else {
         ListIterator var2 = var0.listIterator();

         do {
            if(!var2.hasNext()) {
               return -1;
            }
         } while(!Objects.equal(var1, var2.next()));

         return var2.previousIndex();
      }
   }

   private static int indexOfRandomAccess(List var0, @Nullable Object var1) {
      int var2 = var0.size();
      int var3;
      if(var1 == null) {
         for(var3 = 0; var3 < var2; ++var3) {
            if(var0.get(var3) == null) {
               return var3;
            }
         }
      } else {
         for(var3 = 0; var3 < var2; ++var3) {
            if(var1.equals(var0.get(var3))) {
               return var3;
            }
         }
      }

      return -1;
   }

   static int lastIndexOfImpl(List var0, @Nullable Object var1) {
      if(var0 instanceof RandomAccess) {
         return lastIndexOfRandomAccess(var0, var1);
      } else {
         ListIterator var2 = var0.listIterator(var0.size());

         do {
            if(!var2.hasPrevious()) {
               return -1;
            }
         } while(!Objects.equal(var1, var2.previous()));

         return var2.nextIndex();
      }
   }

   private static int lastIndexOfRandomAccess(List var0, @Nullable Object var1) {
      int var2;
      if(var1 == null) {
         for(var2 = var0.size() - 1; var2 >= 0; --var2) {
            if(var0.get(var2) == null) {
               return var2;
            }
         }
      } else {
         for(var2 = var0.size() - 1; var2 >= 0; --var2) {
            if(var1.equals(var0.get(var2))) {
               return var2;
            }
         }
      }

      return -1;
   }

   static ListIterator listIteratorImpl(List var0, int var1) {
      return (new Lists$AbstractListWrapper(var0)).listIterator(var1);
   }

   static List subListImpl(List var0, int var1, int var2) {
      Object var3;
      if(var0 instanceof RandomAccess) {
         var3 = new Lists$1(var0);
      } else {
         var3 = new Lists$2(var0);
      }

      return ((List)var3).subList(var1, var2);
   }

   static List cast(Iterable var0) {
      return (List)var0;
   }
}
