package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;
import java.util.List;

class MapConstraints$ConstrainedListMultimap extends MapConstraints$ConstrainedMultimap implements ListMultimap {
   MapConstraints$ConstrainedListMultimap(ListMultimap var1, MapConstraint var2) {
      super(var1, var2);
   }

   public List get(Object var1) {
      return (List)super.get(var1);
   }

   public List removeAll(Object var1) {
      return (List)super.removeAll(var1);
   }

   public List replaceValues(Object var1, Iterable var2) {
      return (List)super.replaceValues(var1, var2);
   }
}
