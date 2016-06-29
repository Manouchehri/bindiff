package com.google.common.collect;

import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;
import com.google.common.collect.SetMultimap;
import java.util.Set;

class MapConstraints$ConstrainedSetMultimap extends MapConstraints$ConstrainedMultimap implements SetMultimap {
   MapConstraints$ConstrainedSetMultimap(SetMultimap var1, MapConstraint var2) {
      super(var1, var2);
   }

   public Set get(Object var1) {
      return (Set)super.get(var1);
   }

   public Set entries() {
      return (Set)super.entries();
   }

   public Set removeAll(Object var1) {
      return (Set)super.removeAll(var1);
   }

   public Set replaceValues(Object var1, Iterable var2) {
      return (Set)super.replaceValues(var1, var2);
   }
}
