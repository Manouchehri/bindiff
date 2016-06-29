package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists$TransformingSequentialList$1;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

class Lists$TransformingSequentialList extends AbstractSequentialList implements Serializable {
   final List fromList;
   final Function function;
   private static final long serialVersionUID = 0L;

   Lists$TransformingSequentialList(List var1, Function var2) {
      this.fromList = (List)Preconditions.checkNotNull(var1);
      this.function = (Function)Preconditions.checkNotNull(var2);
   }

   public void clear() {
      this.fromList.clear();
   }

   public int size() {
      return this.fromList.size();
   }

   public ListIterator listIterator(int var1) {
      return new Lists$TransformingSequentialList$1(this, this.fromList.listIterator(var1));
   }
}
