package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

class FilteredKeyMultimap$AddRejectingSet extends ForwardingSet {
   final Object key;

   FilteredKeyMultimap$AddRejectingSet(Object var1) {
      this.key = var1;
   }

   public boolean add(Object var1) {
      String var2 = String.valueOf(this.key);
      throw new IllegalArgumentException((new StringBuilder(32 + String.valueOf(var2).length())).append("Key does not satisfy predicate: ").append(var2).toString());
   }

   public boolean addAll(Collection var1) {
      Preconditions.checkNotNull(var1);
      String var2 = String.valueOf(this.key);
      throw new IllegalArgumentException((new StringBuilder(32 + String.valueOf(var2).length())).append("Key does not satisfy predicate: ").append(var2).toString());
   }

   protected Set delegate() {
      return Collections.emptySet();
   }
}
