package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible("NavigableSet")
class Sets$DescendingSet extends ForwardingNavigableSet {
   private final NavigableSet forward;

   Sets$DescendingSet(NavigableSet var1) {
      this.forward = var1;
   }

   protected NavigableSet delegate() {
      return this.forward;
   }

   public Object lower(Object var1) {
      return this.forward.higher(var1);
   }

   public Object floor(Object var1) {
      return this.forward.ceiling(var1);
   }

   public Object ceiling(Object var1) {
      return this.forward.floor(var1);
   }

   public Object higher(Object var1) {
      return this.forward.lower(var1);
   }

   public Object pollFirst() {
      return this.forward.pollLast();
   }

   public Object pollLast() {
      return this.forward.pollFirst();
   }

   public NavigableSet descendingSet() {
      return this.forward;
   }

   public Iterator descendingIterator() {
      return this.forward.iterator();
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return this.forward.subSet(var3, var4, var1, var2).descendingSet();
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return this.forward.tailSet(var1, var2).descendingSet();
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return this.forward.headSet(var1, var2).descendingSet();
   }

   public Comparator comparator() {
      Comparator var1 = this.forward.comparator();
      return var1 == null?Ordering.natural().reverse():reverse(var1);
   }

   private static Ordering reverse(Comparator var0) {
      return Ordering.from(var0).reverse();
   }

   public Object first() {
      return this.forward.last();
   }

   public SortedSet headSet(Object var1) {
      return this.standardHeadSet(var1);
   }

   public Object last() {
      return this.forward.first();
   }

   public SortedSet subSet(Object var1, Object var2) {
      return this.standardSubSet(var1, var2);
   }

   public SortedSet tailSet(Object var1) {
      return this.standardTailSet(var1);
   }

   public Iterator iterator() {
      return this.forward.descendingIterator();
   }

   public Object[] toArray() {
      return this.standardToArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.standardToArray(var1);
   }

   public String toString() {
      return this.standardToString();
   }
}
