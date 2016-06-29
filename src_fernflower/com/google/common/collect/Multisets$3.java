package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$3$1;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$3 extends AbstractMultiset {
   // $FF: synthetic field
   final Multiset val$multiset1;
   // $FF: synthetic field
   final Multiset val$multiset2;

   Multisets$3(Multiset var1, Multiset var2) {
      this.val$multiset1 = var1;
      this.val$multiset2 = var2;
   }

   public boolean contains(@Nullable Object var1) {
      return this.val$multiset1.contains(var1) || this.val$multiset2.contains(var1);
   }

   public boolean isEmpty() {
      return this.val$multiset1.isEmpty() && this.val$multiset2.isEmpty();
   }

   public int size() {
      return this.val$multiset1.size() + this.val$multiset2.size();
   }

   public int count(Object var1) {
      return this.val$multiset1.count(var1) + this.val$multiset2.count(var1);
   }

   Set createElementSet() {
      return Sets.union(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
   }

   Iterator entryIterator() {
      Iterator var1 = this.val$multiset1.entrySet().iterator();
      Iterator var2 = this.val$multiset2.entrySet().iterator();
      return new Multisets$3$1(this, var1, var2);
   }

   int distinctElements() {
      return this.elementSet().size();
   }
}
