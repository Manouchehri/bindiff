package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists$TransformingRandomAccessList$1;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

class Lists$TransformingRandomAccessList extends AbstractList implements Serializable, RandomAccess {
   final List fromList;
   final Function function;
   private static final long serialVersionUID = 0L;

   Lists$TransformingRandomAccessList(List var1, Function var2) {
      this.fromList = (List)Preconditions.checkNotNull(var1);
      this.function = (Function)Preconditions.checkNotNull(var2);
   }

   public void clear() {
      this.fromList.clear();
   }

   public Object get(int var1) {
      return this.function.apply(this.fromList.get(var1));
   }

   public Iterator iterator() {
      return this.listIterator();
   }

   public ListIterator listIterator(int var1) {
      return new Lists$TransformingRandomAccessList$1(this, this.fromList.listIterator(var1));
   }

   public boolean isEmpty() {
      return this.fromList.isEmpty();
   }

   public Object remove(int var1) {
      return this.function.apply(this.fromList.remove(var1));
   }

   public int size() {
      return this.fromList.size();
   }
}
