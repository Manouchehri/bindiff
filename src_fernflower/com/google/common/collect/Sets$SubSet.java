package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets$SubSet$1;
import java.util.AbstractSet;
import java.util.Iterator;
import javax.annotation.Nullable;

final class Sets$SubSet extends AbstractSet {
   private final ImmutableMap inputSet;
   private final int mask;

   Sets$SubSet(ImmutableMap var1, int var2) {
      this.inputSet = var1;
      this.mask = var2;
   }

   public Iterator iterator() {
      return new Sets$SubSet$1(this);
   }

   public int size() {
      return Integer.bitCount(this.mask);
   }

   public boolean contains(@Nullable Object var1) {
      Integer var2 = (Integer)this.inputSet.get(var1);
      return var2 != null && (this.mask & 1 << var2.intValue()) != 0;
   }

   // $FF: synthetic method
   static ImmutableMap access$100(Sets$SubSet var0) {
      return var0.inputSet;
   }

   // $FF: synthetic method
   static int access$200(Sets$SubSet var0) {
      return var0.mask;
   }
}
