package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

class Lists$AbstractListWrapper extends AbstractList {
   final List backingList;

   Lists$AbstractListWrapper(List var1) {
      this.backingList = (List)Preconditions.checkNotNull(var1);
   }

   public void add(int var1, Object var2) {
      this.backingList.add(var1, var2);
   }

   public boolean addAll(int var1, Collection var2) {
      return this.backingList.addAll(var1, var2);
   }

   public Object get(int var1) {
      return this.backingList.get(var1);
   }

   public Object remove(int var1) {
      return this.backingList.remove(var1);
   }

   public Object set(int var1, Object var2) {
      return this.backingList.set(var1, var2);
   }

   public boolean contains(Object var1) {
      return this.backingList.contains(var1);
   }

   public int size() {
      return this.backingList.size();
   }
}
