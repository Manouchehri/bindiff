package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable$1;
import com.google.common.collect.FluentIterable$FromIterableFunction;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public abstract class FluentIterable implements Iterable {
   private final Iterable iterable;

   protected FluentIterable() {
      this.iterable = this;
   }

   FluentIterable(Iterable var1) {
      this.iterable = (Iterable)Preconditions.checkNotNull(var1);
   }

   @CheckReturnValue
   public static FluentIterable from(Iterable var0) {
      return (FluentIterable)(var0 instanceof FluentIterable?(FluentIterable)var0:new FluentIterable$1(var0, var0));
   }

   @Deprecated
   @CheckReturnValue
   public static FluentIterable from(FluentIterable var0) {
      return (FluentIterable)Preconditions.checkNotNull(var0);
   }

   @CheckReturnValue
   @GoogleInternal
   public static FluentIterable of() {
      return from((Iterable)ImmutableList.of());
   }

   @CheckReturnValue
   @Beta
   public static FluentIterable of(Object[] var0) {
      return from((Iterable)Lists.newArrayList(var0));
   }

   @CheckReturnValue
   @GoogleInternal
   public static FluentIterable of(@Nullable Object var0, Object... var1) {
      return from((Iterable)Lists.asList(var0, var1));
   }

   @CheckReturnValue
   public String toString() {
      return Iterables.toString(this.iterable);
   }

   @CheckReturnValue
   public final int size() {
      return Iterables.size(this.iterable);
   }

   @CheckReturnValue
   public final boolean contains(@Nullable Object var1) {
      return Iterables.contains(this.iterable, var1);
   }

   @CheckReturnValue
   @GoogleInternal
   public final Object getOnlyElement() {
      return Iterables.getOnlyElement(this.iterable);
   }

   @Nullable
   @CheckReturnValue
   @GoogleInternal
   public final Object getOnlyElement(@Nullable Object var1) {
      return Iterables.getOnlyElement(this.iterable, var1);
   }

   @CheckReturnValue
   public final FluentIterable cycle() {
      return from(Iterables.cycle(this.iterable));
   }

   @CheckReturnValue
   @Beta
   public final FluentIterable append(Iterable var1) {
      return from(Iterables.concat(this.iterable, var1));
   }

   @CheckReturnValue
   @Beta
   public final FluentIterable append(Object... var1) {
      return from(Iterables.concat(this.iterable, Arrays.asList(var1)));
   }

   @CheckReturnValue
   @GoogleInternal
   public final FluentIterable partition(int var1) {
      return from(Iterables.partition(this.iterable, var1)).transform(new FluentIterable$FromIterableFunction((FluentIterable$1)null));
   }

   @CheckReturnValue
   @GoogleInternal
   public final FluentIterable partitionWithPadding(int var1) {
      return from(Iterables.paddedPartition(this.iterable, var1)).transform(new FluentIterable$FromIterableFunction((FluentIterable$1)null));
   }

   @CheckReturnValue
   public final FluentIterable filter(Predicate var1) {
      return from(Iterables.filter(this.iterable, var1));
   }

   @CheckReturnValue
   @GwtIncompatible("Class.isInstance")
   public final FluentIterable filter(Class var1) {
      return from(Iterables.filter(this.iterable, var1));
   }

   @CheckReturnValue
   public final boolean anyMatch(Predicate var1) {
      return Iterables.any(this.iterable, var1);
   }

   @CheckReturnValue
   public final boolean allMatch(Predicate var1) {
      return Iterables.all(this.iterable, var1);
   }

   @CheckReturnValue
   public final Optional firstMatch(Predicate var1) {
      return Iterables.tryFind(this.iterable, var1);
   }

   @CheckReturnValue
   public final FluentIterable transform(Function var1) {
      return from(Iterables.transform(this.iterable, var1));
   }

   @CheckReturnValue
   public FluentIterable transformAndConcat(Function var1) {
      return from(Iterables.concat((Iterable)this.transform(var1)));
   }

   @CheckReturnValue
   public final Optional first() {
      Iterator var1 = this.iterable.iterator();
      return var1.hasNext()?Optional.of(var1.next()):Optional.absent();
   }

   @CheckReturnValue
   public final Optional last() {
      if(this.iterable instanceof List) {
         List var3 = (List)this.iterable;
         return var3.isEmpty()?Optional.absent():Optional.of(var3.get(var3.size() - 1));
      } else {
         Iterator var1 = this.iterable.iterator();
         if(!var1.hasNext()) {
            return Optional.absent();
         } else if(this.iterable instanceof SortedSet) {
            SortedSet var4 = (SortedSet)this.iterable;
            return Optional.of(var4.last());
         } else {
            Object var2;
            do {
               var2 = var1.next();
            } while(var1.hasNext());

            return Optional.of(var2);
         }
      }
   }

   @CheckReturnValue
   public final FluentIterable skip(int var1) {
      return from(Iterables.skip(this.iterable, var1));
   }

   @CheckReturnValue
   public final FluentIterable limit(int var1) {
      return from(Iterables.limit(this.iterable, var1));
   }

   @CheckReturnValue
   public final boolean isEmpty() {
      return !this.iterable.iterator().hasNext();
   }

   @CheckReturnValue
   public final ImmutableList toList() {
      return ImmutableList.copyOf(this.iterable);
   }

   @CheckReturnValue
   public final ImmutableList toSortedList(Comparator var1) {
      return Ordering.from(var1).immutableSortedCopy(this.iterable);
   }

   @CheckReturnValue
   public final ImmutableSet toSet() {
      return ImmutableSet.copyOf(this.iterable);
   }

   @CheckReturnValue
   public final ImmutableSortedSet toSortedSet(Comparator var1) {
      return ImmutableSortedSet.copyOf(var1, this.iterable);
   }

   @CheckReturnValue
   public final ImmutableMultiset toMultiset() {
      return ImmutableMultiset.copyOf(this.iterable);
   }

   @CheckReturnValue
   public final ImmutableMap toMap(Function var1) {
      return Maps.toMap(this.iterable, var1);
   }

   @CheckReturnValue
   public final ImmutableListMultimap index(Function var1) {
      return Multimaps.index(this.iterable, var1);
   }

   @CheckReturnValue
   public final ImmutableMap uniqueIndex(Function var1) {
      return Maps.uniqueIndex(this.iterable, var1);
   }

   @CheckReturnValue
   @GwtIncompatible("Array.newArray(Class, int)")
   public final Object[] toArray(Class var1) {
      return Iterables.toArray(this.iterable, var1);
   }

   public final Collection copyInto(Collection var1) {
      Preconditions.checkNotNull(var1);
      if(this.iterable instanceof Collection) {
         var1.addAll(Collections2.cast(this.iterable));
      } else {
         Iterator var2 = this.iterable.iterator();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            var1.add(var3);
         }
      }

      return var1;
   }

   @CheckReturnValue
   @Beta
   public final String join(Joiner var1) {
      return var1.join((Iterable)this);
   }

   @CheckReturnValue
   public final Object get(int var1) {
      return Iterables.get(this.iterable, var1);
   }
}
