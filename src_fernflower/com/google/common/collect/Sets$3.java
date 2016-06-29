package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets$1;
import com.google.common.collect.Sets$SetView;
import java.util.Iterator;
import java.util.Set;

final class Sets$3 extends Sets$SetView {
   // $FF: synthetic field
   final Set val$set1;
   // $FF: synthetic field
   final Predicate val$notInSet2;
   // $FF: synthetic field
   final Set val$set2;

   Sets$3(Set var1, Predicate var2, Set var3) {
      super((Sets$1)null);
      this.val$set1 = var1;
      this.val$notInSet2 = var2;
      this.val$set2 = var3;
   }

   public Iterator iterator() {
      return Iterators.filter(this.val$set1.iterator(), this.val$notInSet2);
   }

   public int size() {
      return Iterators.size(this.iterator());
   }

   public boolean isEmpty() {
      return this.val$set2.containsAll(this.val$set1);
   }

   public boolean contains(Object var1) {
      return this.val$set1.contains(var1) && !this.val$set2.contains(var1);
   }
}
