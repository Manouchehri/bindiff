package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import java.util.Collections;
import java.util.List;

class Multimaps$UnmodifiableListMultimap extends Multimaps$UnmodifiableMultimap implements ListMultimap {
   private static final long serialVersionUID = 0L;

   Multimaps$UnmodifiableListMultimap(ListMultimap var1) {
      super(var1);
   }

   public ListMultimap delegate() {
      return (ListMultimap)super.delegate();
   }

   public List get(Object var1) {
      return Collections.unmodifiableList(this.delegate().get(var1));
   }

   public List removeAll(Object var1) {
      throw new UnsupportedOperationException();
   }

   public List replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }
}
