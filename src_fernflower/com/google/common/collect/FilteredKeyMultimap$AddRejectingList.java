package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class FilteredKeyMultimap$AddRejectingList extends ForwardingList {
   final Object key;

   FilteredKeyMultimap$AddRejectingList(Object var1) {
      this.key = var1;
   }

   public boolean add(Object var1) {
      this.add(0, var1);
      return true;
   }

   public boolean addAll(Collection var1) {
      this.addAll(0, var1);
      return true;
   }

   public void add(int var1, Object var2) {
      Preconditions.checkPositionIndex(var1, 0);
      String var3 = String.valueOf(this.key);
      throw new IllegalArgumentException((new StringBuilder(32 + String.valueOf(var3).length())).append("Key does not satisfy predicate: ").append(var3).toString());
   }

   public boolean addAll(int var1, Collection var2) {
      Preconditions.checkNotNull(var2);
      Preconditions.checkPositionIndex(var1, 0);
      String var3 = String.valueOf(this.key);
      throw new IllegalArgumentException((new StringBuilder(32 + String.valueOf(var3).length())).append("Key does not satisfy predicate: ").append(var3).toString());
   }

   protected List delegate() {
      return Collections.emptyList();
   }
}
