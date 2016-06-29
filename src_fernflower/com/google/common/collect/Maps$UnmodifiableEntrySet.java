package com.google.common.collect;

import com.google.common.collect.Maps$UnmodifiableEntries;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$UnmodifiableEntrySet extends Maps$UnmodifiableEntries implements Set {
   Maps$UnmodifiableEntrySet(Set var1) {
      super(var1);
   }

   public boolean equals(@Nullable Object var1) {
      return Sets.equalsImpl(this, var1);
   }

   public int hashCode() {
      return Sets.hashCodeImpl(this);
   }
}
