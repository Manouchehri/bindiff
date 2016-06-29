package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2$FilteredCollection;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;

class Sets$FilteredSet extends Collections2$FilteredCollection implements Set {
   Sets$FilteredSet(Set var1, Predicate var2) {
      super(var1, var2);
   }

   public boolean equals(@Nullable Object var1) {
      return Sets.equalsImpl(this, var1);
   }

   public int hashCode() {
      return Sets.hashCodeImpl(this);
   }
}
