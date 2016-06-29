package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet$1;
import com.google.common.collect.EmptyContiguousSet$SerializedForm;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
final class EmptyContiguousSet extends ContiguousSet {
   EmptyContiguousSet(DiscreteDomain var1) {
      super(var1);
   }

   public Comparable first() {
      throw new NoSuchElementException();
   }

   public Comparable last() {
      throw new NoSuchElementException();
   }

   public int size() {
      return 0;
   }

   public ContiguousSet intersection(ContiguousSet var1) {
      return this;
   }

   public Range range() {
      throw new NoSuchElementException();
   }

   public Range range(BoundType var1, BoundType var2) {
      throw new NoSuchElementException();
   }

   ContiguousSet headSetImpl(Comparable var1, boolean var2) {
      return this;
   }

   ContiguousSet subSetImpl(Comparable var1, boolean var2, Comparable var3, boolean var4) {
      return this;
   }

   ContiguousSet tailSetImpl(Comparable var1, boolean var2) {
      return this;
   }

   public boolean contains(Object var1) {
      return false;
   }

   @GwtIncompatible("not used by GWT emulation")
   int indexOf(Object var1) {
      return -1;
   }

   public UnmodifiableIterator iterator() {
      return Iterators.emptyIterator();
   }

   @GwtIncompatible("NavigableSet")
   public UnmodifiableIterator descendingIterator() {
      return Iterators.emptyIterator();
   }

   boolean isPartialView() {
      return false;
   }

   public boolean isEmpty() {
      return true;
   }

   public ImmutableList asList() {
      return ImmutableList.of();
   }

   public String toString() {
      return "[]";
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Set) {
         Set var2 = (Set)var1;
         return var2.isEmpty();
      } else {
         return false;
      }
   }

   @GwtIncompatible("not used in GWT")
   boolean isHashCodeFast() {
      return true;
   }

   public int hashCode() {
      return 0;
   }

   @GwtIncompatible("serialization")
   Object writeReplace() {
      return new EmptyContiguousSet$SerializedForm(this.domain, (EmptyContiguousSet$1)null);
   }

   @GwtIncompatible("NavigableSet")
   ImmutableSortedSet createDescendingSet() {
      return ImmutableSortedSet.emptySet(Ordering.natural().reverse());
   }
}
