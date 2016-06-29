package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import com.google.common.collect.SetMultimap;
import java.util.Collections;
import java.util.Set;

class Multimaps$UnmodifiableSetMultimap extends Multimaps$UnmodifiableMultimap implements SetMultimap {
   private static final long serialVersionUID = 0L;

   Multimaps$UnmodifiableSetMultimap(SetMultimap var1) {
      super(var1);
   }

   public SetMultimap delegate() {
      return (SetMultimap)super.delegate();
   }

   public Set get(Object var1) {
      return Collections.unmodifiableSet(this.delegate().get(var1));
   }

   public Set entries() {
      return Maps.unmodifiableEntrySet(this.delegate().entries());
   }

   public Set removeAll(Object var1) {
      throw new UnsupportedOperationException();
   }

   public Set replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }
}
