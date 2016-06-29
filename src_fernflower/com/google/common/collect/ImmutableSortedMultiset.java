package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.DescendingImmutableSortedMultiset;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableSortedMultiset$Builder;
import com.google.common.collect.ImmutableSortedMultiset$SerializedForm;
import com.google.common.collect.ImmutableSortedMultisetFauxverideShim;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedMultiset;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@Beta
@GwtIncompatible("hasn\'t been tested yet")
public abstract class ImmutableSortedMultiset extends ImmutableSortedMultisetFauxverideShim implements SortedMultiset {
   private static final Comparator NATURAL_ORDER = Ordering.natural();
   private static final ImmutableSortedMultiset NATURAL_EMPTY_MULTISET;
   @LazyInit
   transient ImmutableSortedMultiset descendingMultiset;

   public static ImmutableSortedMultiset of() {
      return NATURAL_EMPTY_MULTISET;
   }

   public static ImmutableSortedMultiset of(Comparable var0) {
      RegularImmutableSortedSet var1 = (RegularImmutableSortedSet)ImmutableSortedSet.of(var0);
      long[] var2 = new long[]{0L, 1L};
      return new RegularImmutableSortedMultiset(var1, var2, 0, 1);
   }

   public static ImmutableSortedMultiset of(Comparable var0, Comparable var1) {
      return copyOf(Ordering.natural(), (Iterable)Arrays.asList(new Comparable[]{var0, var1}));
   }

   public static ImmutableSortedMultiset of(Comparable var0, Comparable var1, Comparable var2) {
      return copyOf(Ordering.natural(), (Iterable)Arrays.asList(new Comparable[]{var0, var1, var2}));
   }

   public static ImmutableSortedMultiset of(Comparable var0, Comparable var1, Comparable var2, Comparable var3) {
      return copyOf(Ordering.natural(), (Iterable)Arrays.asList(new Comparable[]{var0, var1, var2, var3}));
   }

   public static ImmutableSortedMultiset of(Comparable var0, Comparable var1, Comparable var2, Comparable var3, Comparable var4) {
      return copyOf(Ordering.natural(), (Iterable)Arrays.asList(new Comparable[]{var0, var1, var2, var3, var4}));
   }

   public static ImmutableSortedMultiset of(Comparable var0, Comparable var1, Comparable var2, Comparable var3, Comparable var4, Comparable var5, Comparable... var6) {
      int var7 = var6.length + 6;
      ArrayList var8 = Lists.newArrayListWithCapacity(var7);
      Collections.addAll(var8, new Comparable[]{var0, var1, var2, var3, var4, var5});
      Collections.addAll(var8, var6);
      return copyOf(Ordering.natural(), (Iterable)var8);
   }

   public static ImmutableSortedMultiset copyOf(Comparable[] var0) {
      return copyOf(Ordering.natural(), (Iterable)Arrays.asList(var0));
   }

   public static ImmutableSortedMultiset copyOf(Iterable var0) {
      Ordering var1 = Ordering.natural();
      return copyOf(var1, (Iterable)var0);
   }

   public static ImmutableSortedMultiset copyOf(Iterator var0) {
      Ordering var1 = Ordering.natural();
      return copyOf(var1, (Iterator)var0);
   }

   public static ImmutableSortedMultiset copyOf(Comparator var0, Iterator var1) {
      Preconditions.checkNotNull(var0);
      return (new ImmutableSortedMultiset$Builder(var0)).addAll(var1).build();
   }

   public static ImmutableSortedMultiset copyOf(Comparator var0, Iterable var1) {
      if(var1 instanceof ImmutableSortedMultiset) {
         ImmutableSortedMultiset var2 = (ImmutableSortedMultiset)var1;
         if(var0.equals(var2.comparator())) {
            if(var2.isPartialView()) {
               return copyOfSortedEntries(var0, var2.entrySet().asList());
            }

            return var2;
         }
      }

      ArrayList var3 = Lists.newArrayList(var1);
      TreeMultiset var4 = TreeMultiset.create((Comparator)Preconditions.checkNotNull(var0));
      Iterables.addAll(var4, var3);
      return copyOfSortedEntries(var0, var4.entrySet());
   }

   public static ImmutableSortedMultiset copyOfSorted(SortedMultiset var0) {
      return copyOfSortedEntries(var0.comparator(), Lists.newArrayList((Iterable)var0.entrySet()));
   }

   private static ImmutableSortedMultiset copyOfSortedEntries(Comparator var0, Collection var1) {
      if(var1.isEmpty()) {
         return emptyMultiset(var0);
      } else {
         ImmutableList$Builder var2 = new ImmutableList$Builder(var1.size());
         long[] var3 = new long[var1.size() + 1];
         int var4 = 0;

         for(Iterator var5 = var1.iterator(); var5.hasNext(); ++var4) {
            Multiset$Entry var6 = (Multiset$Entry)var5.next();
            var2.add(var6.getElement());
            var3[var4 + 1] = var3[var4] + (long)var6.getCount();
         }

         return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(var2.build(), var0), var3, 0, var1.size());
      }
   }

   static ImmutableSortedMultiset emptyMultiset(Comparator var0) {
      return (ImmutableSortedMultiset)(NATURAL_ORDER.equals(var0)?NATURAL_EMPTY_MULTISET:new RegularImmutableSortedMultiset(var0));
   }

   public final Comparator comparator() {
      return this.elementSet().comparator();
   }

   public abstract ImmutableSortedSet elementSet();

   public ImmutableSortedMultiset descendingMultiset() {
      ImmutableSortedMultiset var1 = this.descendingMultiset;
      return var1 == null?(this.descendingMultiset = (ImmutableSortedMultiset)(this.isEmpty()?emptyMultiset(Ordering.from(this.comparator()).reverse()):new DescendingImmutableSortedMultiset(this))):var1;
   }

   @Deprecated
   public final Multiset$Entry pollFirstEntry() {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final Multiset$Entry pollLastEntry() {
      throw new UnsupportedOperationException();
   }

   public abstract ImmutableSortedMultiset headMultiset(Object var1, BoundType var2);

   public ImmutableSortedMultiset subMultiset(Object var1, BoundType var2, Object var3, BoundType var4) {
      Preconditions.checkArgument(this.comparator().compare(var1, var3) <= 0, "Expected lowerBound <= upperBound but %s > %s", new Object[]{var1, var3});
      return this.tailMultiset(var1, var2).headMultiset(var3, var4);
   }

   public abstract ImmutableSortedMultiset tailMultiset(Object var1, BoundType var2);

   public static ImmutableSortedMultiset$Builder orderedBy(Comparator var0) {
      return new ImmutableSortedMultiset$Builder(var0);
   }

   public static ImmutableSortedMultiset$Builder reverseOrder() {
      return new ImmutableSortedMultiset$Builder(Ordering.natural().reverse());
   }

   public static ImmutableSortedMultiset$Builder naturalOrder() {
      return new ImmutableSortedMultiset$Builder(Ordering.natural());
   }

   Object writeReplace() {
      return new ImmutableSortedMultiset$SerializedForm(this);
   }

   static {
      NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(NATURAL_ORDER);
   }
}
