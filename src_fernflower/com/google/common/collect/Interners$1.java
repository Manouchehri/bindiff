package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import java.util.concurrent.ConcurrentMap;

final class Interners$1 implements Interner {
   // $FF: synthetic field
   final ConcurrentMap val$map;

   Interners$1(ConcurrentMap var1) {
      this.val$map = var1;
   }

   public Object intern(Object var1) {
      Object var2 = this.val$map.putIfAbsent(Preconditions.checkNotNull(var1), var1);
      return var2 == null?var1:var2;
   }
}
