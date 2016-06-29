package com.google.common.collect;

import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Set;

final class Maps$2 extends ForwardingSet {
   // $FF: synthetic field
   final Set val$set;

   Maps$2(Set var1) {
      this.val$set = var1;
   }

   protected Set delegate() {
      return this.val$set;
   }

   public boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }
}
