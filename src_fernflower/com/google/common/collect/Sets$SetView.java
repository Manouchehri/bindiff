package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets$1;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

public abstract class Sets$SetView extends AbstractSet {
   private Sets$SetView() {
   }

   public ImmutableSet immutableCopy() {
      return ImmutableSet.copyOf((Collection)this);
   }

   public Set copyInto(Set var1) {
      var1.addAll(this);
      return var1;
   }

   // $FF: synthetic method
   Sets$SetView(Sets$1 var1) {
      this();
   }
}
