package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ConsumingQueueIterator;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators$1;
import com.google.common.collect.Iterators$10;
import com.google.common.collect.Iterators$11;
import com.google.common.collect.Iterators$12;
import com.google.common.collect.Iterators$13;
import com.google.common.collect.Iterators$14;
import com.google.common.collect.Iterators$15;
import com.google.common.collect.Iterators$2;
import com.google.common.collect.Iterators$3;
import com.google.common.collect.Iterators$4;
import com.google.common.collect.Iterators$5;
import com.google.common.collect.Iterators$6;
import com.google.common.collect.Iterators$7;
import com.google.common.collect.Iterators$8;
import com.google.common.collect.Iterators$9;
import com.google.common.collect.Iterators$MergingIterator;
import com.google.common.collect.Iterators$PeekingImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Iterators {
   static final UnmodifiableListIterator EMPTY_LIST_ITERATOR = new Iterators$1();
   private static final Iterator EMPTY_MODIFIABLE_ITERATOR = new Iterators$2();

   @Deprecated
   static UnmodifiableIterator emptyIterator() {
      return emptyListIterator();
   }

   static UnmodifiableListIterator emptyListIterator() {
      return EMPTY_LIST_ITERATOR;
   }

   static Iterator emptyModifiableIterator() {
      return EMPTY_MODIFIABLE_ITERATOR;
   }

   public static UnmodifiableIterator unmodifiableIterator(Iterator var0) {
      Preconditions.checkNotNull(var0);
      return (UnmodifiableIterator)(var0 instanceof UnmodifiableIterator?(UnmodifiableIterator)var0:new Iterators$3(var0));
   }

   @Deprecated
   public static UnmodifiableIterator unmodifiableIterator(UnmodifiableIterator var0) {
      return (UnmodifiableIterator)Preconditions.checkNotNull(var0);
   }

   public static int size(Iterator var0) {
      int var1;
      for(var1 = 0; var0.hasNext(); ++var1) {
         var0.next();
      }

      return var1;
   }

   public static boolean contains(Iterator var0, @Nullable Object var1) {
      return any(var0, Predicates.equalTo(var1));
   }

   public static boolean removeAll(Iterator var0, Collection var1) {
      return removeIf(var0, Predicates.in(var1));
   }

   public static boolean removeIf(Iterator var0, Predicate var1) {
      Preconditions.checkNotNull(var1);
      boolean var2 = false;

      while(var0.hasNext()) {
         if(var1.apply(var0.next())) {
            var0.remove();
            var2 = true;
         }
      }

      return var2;
   }

   public static boolean retainAll(Iterator var0, Collection var1) {
      return removeIf(var0, Predicates.not(Predicates.in(var1)));
   }

   public static boolean elementsEqual(Iterator var0, Iterator var1) {
      while(true) {
         if(var0.hasNext()) {
            if(!var1.hasNext()) {
               return false;
            }

            Object var2 = var0.next();
            Object var3 = var1.next();
            if(Objects.equal(var2, var3)) {
               continue;
            }

            return false;
         }

         return !var1.hasNext();
      }
   }

   public static String toString(Iterator var0) {
      return Collections2.STANDARD_JOINER.appendTo((new StringBuilder()).append('['), var0).append(']').toString();
   }

   public static Object getOnlyElement(Iterator var0) {
      Object var1 = var0.next();
      if(!var0.hasNext()) {
         return var1;
      } else {
         StringBuilder var2 = new StringBuilder();
         String var3 = String.valueOf(var1);
         var2.append((new StringBuilder(31 + String.valueOf(var3).length())).append("expected one element but was: <").append(var3).toString());

         for(int var5 = 0; var5 < 4 && var0.hasNext(); ++var5) {
            String var4 = String.valueOf(var0.next());
            var2.append((new StringBuilder(2 + String.valueOf(var4).length())).append(", ").append(var4).toString());
         }

         if(var0.hasNext()) {
            var2.append(", ...");
         }

         var2.append('>');
         throw new IllegalArgumentException(var2.toString());
      }
   }

   @Nullable
   public static Object getOnlyElement(Iterator var0, @Nullable Object var1) {
      return var0.hasNext()?getOnlyElement(var0):var1;
   }

   @GwtIncompatible("Array.newInstance(Class, int)")
   public static Object[] toArray(Iterator var0, Class var1) {
      ArrayList var2 = Lists.newArrayList(var0);
      return Iterables.toArray(var2, (Class)var1);
   }

   public static boolean addAll(Collection var0, Iterator var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);

      boolean var2;
      for(var2 = false; var1.hasNext(); var2 |= var0.add(var1.next())) {
         ;
      }

      return var2;
   }

   public static int frequency(Iterator var0, @Nullable Object var1) {
      return size(filter(var0, Predicates.equalTo(var1)));
   }

   public static Iterator cycle(Iterable var0) {
      Preconditions.checkNotNull(var0);
      return new Iterators$4(var0);
   }

   public static Iterator cycle(Object... var0) {
      return cycle((Iterable)Lists.newArrayList(var0));
   }

   public static Iterator concat(Iterator var0, Iterator var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return concat((Iterator)(new ConsumingQueueIterator(new Iterator[]{var0, var1})));
   }

   public static Iterator concat(Iterator var0, Iterator var1, Iterator var2) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      return concat((Iterator)(new ConsumingQueueIterator(new Iterator[]{var0, var1, var2})));
   }

   public static Iterator concat(Iterator var0, Iterator var1, Iterator var2, Iterator var3) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      return concat((Iterator)(new ConsumingQueueIterator(new Iterator[]{var0, var1, var2, var3})));
   }

   public static Iterator concat(Iterator... var0) {
      Iterator[] var1 = (Iterator[])Preconditions.checkNotNull(var0);
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Iterator var4 = var1[var3];
         Preconditions.checkNotNull(var4);
      }

      return concat((Iterator)(new ConsumingQueueIterator(var0)));
   }

   public static Iterator concat(Iterator var0) {
      Preconditions.checkNotNull(var0);
      return new Iterators$5(var0);
   }

   public static UnmodifiableIterator partition(Iterator var0, int var1) {
      return partitionImpl(var0, var1, false);
   }

   public static UnmodifiableIterator paddedPartition(Iterator var0, int var1) {
      return partitionImpl(var0, var1, true);
   }

   private static UnmodifiableIterator partitionImpl(Iterator var0, int var1, boolean var2) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 > 0);
      return new Iterators$6(var0, var1, var2);
   }

   @GoogleInternal
   public static Iterator pairUp(Iterator var0, Iterator var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Iterators$7(var0, var1);
   }

   @CheckReturnValue
   public static UnmodifiableIterator filter(Iterator var0, Predicate var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Iterators$8(var0, var1);
   }

   @CheckReturnValue
   @GwtIncompatible("Class.isInstance")
   public static UnmodifiableIterator filter(Iterator var0, Class var1) {
      return filter(var0, Predicates.instanceOf(var1));
   }

   public static boolean any(Iterator var0, Predicate var1) {
      return indexOf(var0, var1) != -1;
   }

   public static boolean all(Iterator var0, Predicate var1) {
      Preconditions.checkNotNull(var1);

      Object var2;
      do {
         if(!var0.hasNext()) {
            return true;
         }

         var2 = var0.next();
      } while(var1.apply(var2));

      return false;
   }

   public static Object find(Iterator var0, Predicate var1) {
      return filter(var0, var1).next();
   }

   @Nullable
   public static Object find(Iterator var0, Predicate var1, @Nullable Object var2) {
      return getNext(filter(var0, var1), var2);
   }

   public static Optional tryFind(Iterator var0, Predicate var1) {
      UnmodifiableIterator var2 = filter(var0, var1);
      return var2.hasNext()?Optional.of(var2.next()):Optional.absent();
   }

   public static int indexOf(Iterator var0, Predicate var1) {
      Preconditions.checkNotNull(var1, "predicate");

      for(int var2 = 0; var0.hasNext(); ++var2) {
         Object var3 = var0.next();
         if(var1.apply(var3)) {
            return var2;
         }
      }

      return -1;
   }

   public static Iterator transform(Iterator var0, Function var1) {
      Preconditions.checkNotNull(var1);
      return new Iterators$9(var0, var1);
   }

   public static Object get(Iterator var0, int var1) {
      checkNonnegative(var1);
      int var2 = advance(var0, var1);
      if(!var0.hasNext()) {
         throw new IndexOutOfBoundsException((new StringBuilder(91)).append("position (").append(var1).append(") must be less than the number of elements that remained (").append(var2).append(")").toString());
      } else {
         return var0.next();
      }
   }

   static void checkNonnegative(int var0) {
      if(var0 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(43)).append("position (").append(var0).append(") must not be negative").toString());
      }
   }

   @Nullable
   public static Object get(Iterator var0, int var1, @Nullable Object var2) {
      checkNonnegative(var1);
      advance(var0, var1);
      return getNext(var0, var2);
   }

   @Nullable
   public static Object getNext(Iterator var0, @Nullable Object var1) {
      return var0.hasNext()?var0.next():var1;
   }

   public static Object getLast(Iterator var0) {
      Object var1;
      do {
         var1 = var0.next();
      } while(var0.hasNext());

      return var1;
   }

   @Nullable
   public static Object getLast(Iterator var0, @Nullable Object var1) {
      return var0.hasNext()?getLast(var0):var1;
   }

   public static int advance(Iterator var0, int var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 >= 0, "numberToAdvance must be nonnegative");

      int var2;
      for(var2 = 0; var2 < var1 && var0.hasNext(); ++var2) {
         var0.next();
      }

      return var2;
   }

   public static Iterator limit(Iterator var0, int var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 >= 0, "limit is negative");
      return new Iterators$10(var1, var0);
   }

   public static Iterator consumingIterator(Iterator var0) {
      Preconditions.checkNotNull(var0);
      return new Iterators$11(var0);
   }

   @Nullable
   static Object pollNext(Iterator var0) {
      if(var0.hasNext()) {
         Object var1 = var0.next();
         var0.remove();
         return var1;
      } else {
         return null;
      }
   }

   static void clear(Iterator var0) {
      Preconditions.checkNotNull(var0);

      while(var0.hasNext()) {
         var0.next();
         var0.remove();
      }

   }

   public static UnmodifiableIterator forArray(Object... var0) {
      return forArray(var0, 0, var0.length, 0);
   }

   static UnmodifiableListIterator forArray(Object[] var0, int var1, int var2, int var3) {
      Preconditions.checkArgument(var2 >= 0);
      int var4 = var1 + var2;
      Preconditions.checkPositionIndexes(var1, var4, var0.length);
      Preconditions.checkPositionIndex(var3, var2);
      return (UnmodifiableListIterator)(var2 == 0?emptyListIterator():new Iterators$12(var2, var3, var0, var1));
   }

   public static UnmodifiableIterator singletonIterator(@Nullable Object var0) {
      return new Iterators$13(var0);
   }

   public static UnmodifiableIterator forEnumeration(Enumeration var0) {
      Preconditions.checkNotNull(var0);
      return new Iterators$14(var0);
   }

   public static Enumeration asEnumeration(Iterator var0) {
      Preconditions.checkNotNull(var0);
      return new Iterators$15(var0);
   }

   public static PeekingIterator peekingIterator(Iterator var0) {
      if(var0 instanceof Iterators$PeekingImpl) {
         Iterators$PeekingImpl var1 = (Iterators$PeekingImpl)var0;
         return var1;
      } else {
         return new Iterators$PeekingImpl(var0);
      }
   }

   @Deprecated
   public static PeekingIterator peekingIterator(PeekingIterator var0) {
      return (PeekingIterator)Preconditions.checkNotNull(var0);
   }

   @Beta
   public static UnmodifiableIterator mergeSorted(Iterable var0, Comparator var1) {
      Preconditions.checkNotNull(var0, "iterators");
      Preconditions.checkNotNull(var1, "comparator");
      return new Iterators$MergingIterator(var0, var1);
   }

   static ListIterator cast(Iterator var0) {
      return (ListIterator)var0;
   }
}
