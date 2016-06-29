package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables$1;
import com.google.common.collect.Iterables$10;
import com.google.common.collect.Iterables$11;
import com.google.common.collect.Iterables$12;
import com.google.common.collect.Iterables$13;
import com.google.common.collect.Iterables$14;
import com.google.common.collect.Iterables$15;
import com.google.common.collect.Iterables$16;
import com.google.common.collect.Iterables$2;
import com.google.common.collect.Iterables$3;
import com.google.common.collect.Iterables$4;
import com.google.common.collect.Iterables$5;
import com.google.common.collect.Iterables$6;
import com.google.common.collect.Iterables$7;
import com.google.common.collect.Iterables$8;
import com.google.common.collect.Iterables$9;
import com.google.common.collect.Iterables$UnmodifiableIterable;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.ObjectArrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Iterables {
   public static Iterable unmodifiableIterable(Iterable var0) {
      Preconditions.checkNotNull(var0);
      return (Iterable)(!(var0 instanceof Iterables$UnmodifiableIterable) && !(var0 instanceof ImmutableCollection)?new Iterables$UnmodifiableIterable(var0, (Iterables$1)null):var0);
   }

   @Deprecated
   public static Iterable unmodifiableIterable(ImmutableCollection var0) {
      return (Iterable)Preconditions.checkNotNull(var0);
   }

   public static int size(Iterable var0) {
      return var0 instanceof Collection?((Collection)var0).size():Iterators.size(var0.iterator());
   }

   public static boolean contains(Iterable var0, @Nullable Object var1) {
      if(var0 instanceof Collection) {
         Collection var2 = (Collection)var0;
         return Collections2.safeContains(var2, var1);
      } else {
         return Iterators.contains(var0.iterator(), var1);
      }
   }

   public static boolean removeAll(Iterable var0, Collection var1) {
      return var0 instanceof Collection?((Collection)var0).removeAll((Collection)Preconditions.checkNotNull(var1)):Iterators.removeAll(var0.iterator(), var1);
   }

   public static boolean retainAll(Iterable var0, Collection var1) {
      return var0 instanceof Collection?((Collection)var0).retainAll((Collection)Preconditions.checkNotNull(var1)):Iterators.retainAll(var0.iterator(), var1);
   }

   public static boolean removeIf(Iterable var0, Predicate var1) {
      return var0 instanceof RandomAccess && var0 instanceof List?removeIfFromRandomAccessList((List)var0, (Predicate)Preconditions.checkNotNull(var1)):Iterators.removeIf(var0.iterator(), var1);
   }

   private static boolean removeIfFromRandomAccessList(List var0, Predicate var1) {
      int var2 = 0;

      int var3;
      for(var3 = 0; var2 < var0.size(); ++var2) {
         Object var4 = var0.get(var2);
         if(!var1.apply(var4)) {
            if(var2 > var3) {
               try {
                  var0.set(var3, var4);
               } catch (UnsupportedOperationException var6) {
                  slowRemoveIfForRemainingElements(var0, var1, var3, var2);
                  return true;
               }
            }

            ++var3;
         }
      }

      var0.subList(var3, var0.size()).clear();
      return var2 != var3;
   }

   private static void slowRemoveIfForRemainingElements(List var0, Predicate var1, int var2, int var3) {
      int var4;
      for(var4 = var0.size() - 1; var4 > var3; --var4) {
         if(var1.apply(var0.get(var4))) {
            var0.remove(var4);
         }
      }

      for(var4 = var3 - 1; var4 >= var2; --var4) {
         var0.remove(var4);
      }

   }

   @Nullable
   static Object removeFirstMatching(Iterable var0, Predicate var1) {
      Preconditions.checkNotNull(var1);
      Iterator var2 = var0.iterator();

      Object var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = var2.next();
      } while(!var1.apply(var3));

      var2.remove();
      return var3;
   }

   @CheckReturnValue
   public static boolean elementsEqual(Iterable var0, Iterable var1) {
      if(var0 instanceof Collection && var1 instanceof Collection) {
         Collection var2 = (Collection)var0;
         Collection var3 = (Collection)var1;
         if(var2.size() != var3.size()) {
            return false;
         }
      }

      return Iterators.elementsEqual(var0.iterator(), var1.iterator());
   }

   public static String toString(Iterable var0) {
      return Iterators.toString(var0.iterator());
   }

   public static Object getOnlyElement(Iterable var0) {
      return Iterators.getOnlyElement(var0.iterator());
   }

   @Nullable
   public static Object getOnlyElement(Iterable var0, @Nullable Object var1) {
      return Iterators.getOnlyElement(var0.iterator(), var1);
   }

   @GwtIncompatible("Array.newInstance(Class, int)")
   public static Object[] toArray(Iterable var0, Class var1) {
      Collection var2 = toCollection(var0);
      Object[] var3 = ObjectArrays.newArray(var1, var2.size());
      return var2.toArray(var3);
   }

   static Object[] toArray(Iterable var0, Object[] var1) {
      Collection var2 = toCollection(var0);
      return var2.toArray(var1);
   }

   static Object[] toArray(Iterable var0) {
      return toCollection(var0).toArray();
   }

   private static Collection toCollection(Iterable var0) {
      return (Collection)(var0 instanceof Collection?(Collection)var0:Lists.newArrayList(var0.iterator()));
   }

   public static boolean addAll(Collection var0, Iterable var1) {
      if(var1 instanceof Collection) {
         Collection var2 = Collections2.cast(var1);
         return var0.addAll(var2);
      } else {
         return Iterators.addAll(var0, ((Iterable)Preconditions.checkNotNull(var1)).iterator());
      }
   }

   public static int frequency(Iterable var0, @Nullable Object var1) {
      return var0 instanceof Multiset?((Multiset)var0).count(var1):(var0 instanceof Set?(((Set)var0).contains(var1)?1:0):Iterators.frequency(var0.iterator(), var1));
   }

   public static Iterable cycle(Iterable var0) {
      Preconditions.checkNotNull(var0);
      return new Iterables$1(var0);
   }

   public static Iterable cycle(Object... var0) {
      return cycle((Iterable)Lists.newArrayList(var0));
   }

   public static Iterable concat(Iterable var0, Iterable var1) {
      return concat((Iterable)ImmutableList.of(var0, var1));
   }

   public static Iterable concat(Iterable var0, Iterable var1, Iterable var2) {
      return concat((Iterable)ImmutableList.of(var0, var1, var2));
   }

   public static Iterable concat(Iterable var0, Iterable var1, Iterable var2, Iterable var3) {
      return concat((Iterable)ImmutableList.of(var0, var1, var2, var3));
   }

   public static Iterable concat(Iterable... var0) {
      return concat((Iterable)ImmutableList.copyOf((Object[])var0));
   }

   public static Iterable concat(Iterable var0) {
      Preconditions.checkNotNull(var0);
      return new Iterables$2(var0);
   }

   private static Iterator iterators(Iterable var0) {
      return new Iterables$3(var0.iterator());
   }

   public static Iterable partition(Iterable var0, int var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 > 0);
      return new Iterables$4(var0, var1);
   }

   public static Iterable paddedPartition(Iterable var0, int var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 > 0);
      return new Iterables$5(var0, var1);
   }

   @GoogleInternal
   public static Iterable pairUp(Iterable var0, Iterable var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Iterables$6(var0, var1);
   }

   @CheckReturnValue
   public static Iterable filter(Iterable var0, Predicate var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Iterables$7(var0, var1);
   }

   @CheckReturnValue
   @GwtIncompatible("Class.isInstance")
   public static Iterable filter(Iterable var0, Class var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Iterables$8(var0, var1);
   }

   public static boolean any(Iterable var0, Predicate var1) {
      return Iterators.any(var0.iterator(), var1);
   }

   public static boolean all(Iterable var0, Predicate var1) {
      return Iterators.all(var0.iterator(), var1);
   }

   public static Object find(Iterable var0, Predicate var1) {
      return Iterators.find(var0.iterator(), var1);
   }

   @Nullable
   public static Object find(Iterable var0, Predicate var1, @Nullable Object var2) {
      return Iterators.find(var0.iterator(), var1, var2);
   }

   public static Optional tryFind(Iterable var0, Predicate var1) {
      return Iterators.tryFind(var0.iterator(), var1);
   }

   public static int indexOf(Iterable var0, Predicate var1) {
      return Iterators.indexOf(var0.iterator(), var1);
   }

   @CheckReturnValue
   public static Iterable transform(Iterable var0, Function var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Iterables$9(var0, var1);
   }

   public static Object get(Iterable var0, int var1) {
      Preconditions.checkNotNull(var0);
      return var0 instanceof List?((List)var0).get(var1):Iterators.get(var0.iterator(), var1);
   }

   @Nullable
   public static Object get(Iterable var0, int var1, @Nullable Object var2) {
      Preconditions.checkNotNull(var0);
      Iterators.checkNonnegative(var1);
      if(var0 instanceof List) {
         List var4 = Lists.cast(var0);
         return var1 < var4.size()?var4.get(var1):var2;
      } else {
         Iterator var3 = var0.iterator();
         Iterators.advance(var3, var1);
         return Iterators.getNext(var3, var2);
      }
   }

   @Nullable
   public static Object getFirst(Iterable var0, @Nullable Object var1) {
      return Iterators.getNext(var0.iterator(), var1);
   }

   public static Object getLast(Iterable var0) {
      if(var0 instanceof List) {
         List var1 = (List)var0;
         if(var1.isEmpty()) {
            throw new NoSuchElementException();
         } else {
            return getLastInNonemptyList(var1);
         }
      } else {
         return Iterators.getLast(var0.iterator());
      }
   }

   @Nullable
   public static Object getLast(Iterable var0, @Nullable Object var1) {
      if(var0 instanceof Collection) {
         Collection var2 = Collections2.cast(var0);
         if(var2.isEmpty()) {
            return var1;
         }

         if(var0 instanceof List) {
            return getLastInNonemptyList(Lists.cast(var0));
         }
      }

      return Iterators.getLast(var0.iterator(), var1);
   }

   private static Object getLastInNonemptyList(List var0) {
      return var0.get(var0.size() - 1);
   }

   public static Iterable skip(Iterable var0, int var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 >= 0, "number to skip cannot be negative");
      if(var0 instanceof List) {
         List var2 = (List)var0;
         return new Iterables$10(var2, var1);
      } else {
         return new Iterables$11(var0, var1);
      }
   }

   public static Iterable limit(Iterable var0, int var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 >= 0, "limit is negative");
      return new Iterables$12(var0, var1);
   }

   public static Iterable consumingIterable(Iterable var0) {
      if(var0 instanceof Queue) {
         return new Iterables$13(var0);
      } else {
         Preconditions.checkNotNull(var0);
         return new Iterables$14(var0);
      }
   }

   public static boolean isEmpty(Iterable var0) {
      return var0 instanceof Collection?((Collection)var0).isEmpty():!var0.iterator().hasNext();
   }

   @Beta
   public static Iterable mergeSorted(Iterable var0, Comparator var1) {
      Preconditions.checkNotNull(var0, "iterables");
      Preconditions.checkNotNull(var1, "comparator");
      Iterables$15 var2 = new Iterables$15(var0, var1);
      return new Iterables$UnmodifiableIterable(var2, (Iterables$1)null);
   }

   private static Function toIterator() {
      return new Iterables$16();
   }

   // $FF: synthetic method
   static Iterator access$100(Iterable var0) {
      return iterators(var0);
   }

   // $FF: synthetic method
   static Function access$200() {
      return toIterator();
   }
}
