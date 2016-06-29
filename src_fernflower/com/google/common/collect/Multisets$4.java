package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$4$1;
import java.util.Iterator;
import javax.annotation.Nullable;

final class Multisets$4 extends AbstractMultiset {
   // $FF: synthetic field
   final Multiset val$multiset1;
   // $FF: synthetic field
   final Multiset val$multiset2;

   Multisets$4(Multiset var1, Multiset var2) {
      this.val$multiset1 = var1;
      this.val$multiset2 = var2;
   }

   public int count(@Nullable Object var1) {
      int var2 = this.val$multiset1.count(var1);
      return var2 == 0?0:Math.max(0, var2 - this.val$multiset2.count(var1));
   }

   Iterator entryIterator() {
      Iterator var1 = this.val$multiset1.entrySet().iterator();
      return new Multisets$4$1(this, var1);
   }

   int distinctElements() {
      return Iterators.size(this.entryIterator());
   }
}
