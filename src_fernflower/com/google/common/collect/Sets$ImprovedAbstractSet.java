package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Collection;

abstract class Sets$ImprovedAbstractSet extends AbstractSet {
   public boolean removeAll(Collection var1) {
      return Sets.removeAllImpl(this, (Collection)var1);
   }

   public boolean retainAll(Collection var1) {
      return super.retainAll((Collection)Preconditions.checkNotNull(var1));
   }
}
