package com.google.common.collect;

import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedEntries;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedEntrySet extends MapConstraints$ConstrainedEntries implements Set {
   MapConstraints$ConstrainedEntrySet(Set var1, MapConstraint var2) {
      super(var1, var2);
   }

   public boolean equals(@Nullable Object var1) {
      return Sets.equalsImpl(this, var1);
   }

   public int hashCode() {
      return Sets.hashCodeImpl(this);
   }
}
