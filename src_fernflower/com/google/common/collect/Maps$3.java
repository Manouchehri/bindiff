package com.google.common.collect;

import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.SortedSet;

final class Maps$3 extends ForwardingSortedSet {
   // $FF: synthetic field
   final SortedSet val$set;

   Maps$3(SortedSet var1) {
      this.val$set = var1;
   }

   protected SortedSet delegate() {
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
}
