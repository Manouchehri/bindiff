package com.google.common.collect;

import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.SortedSet;

final class Maps$4 extends ForwardingNavigableSet {
   // $FF: synthetic field
   final NavigableSet val$set;

   Maps$4(NavigableSet var1) {
      this.val$set = var1;
   }

   protected NavigableSet delegate() {
      return this.val$set;
   }

   public boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public SortedSet headSet(Object var1) {
      return Maps.access$300(super.headSet(var1));
   }

   public SortedSet subSet(Object var1, Object var2) {
      return Maps.access$300(super.subSet(var1, var2));
   }

   public SortedSet tailSet(Object var1) {
      return Maps.access$300(super.tailSet(var1));
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return Maps.access$400(super.headSet(var1, var2));
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return Maps.access$400(super.tailSet(var1, var2));
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return Maps.access$400(super.subSet(var1, var2, var3, var4));
   }

   public NavigableSet descendingSet() {
      return Maps.access$400(super.descendingSet());
   }
}
