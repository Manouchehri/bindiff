package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$2$1;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

final class Multisets$2 extends AbstractMultiset {
   // $FF: synthetic field
   final Multiset val$multiset1;
   // $FF: synthetic field
   final Multiset val$multiset2;

   Multisets$2(Multiset var1, Multiset var2) {
      this.val$multiset1 = var1;
      this.val$multiset2 = var2;
   }

   public int count(Object var1) {
      int var2 = this.val$multiset1.count(var1);
      return var2 == 0?0:Math.min(var2, this.val$multiset2.count(var1));
   }

   Set createElementSet() {
      return Sets.intersection(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
   }

   Iterator entryIterator() {
      Iterator var1 = this.val$multiset1.entrySet().iterator();
      return new Multisets$2$1(this, var1);
   }

   int distinctElements() {
      return this.elementSet().size();
   }
}
