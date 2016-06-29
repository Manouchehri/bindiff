package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets$1;
import com.google.common.collect.Sets$4$1;
import com.google.common.collect.Sets$SetView;
import java.util.Iterator;
import java.util.Set;

final class Sets$4 extends Sets$SetView {
   // $FF: synthetic field
   final Set val$set1;
   // $FF: synthetic field
   final Set val$set2;

   Sets$4(Set var1, Set var2) {
      super((Sets$1)null);
      this.val$set1 = var1;
      this.val$set2 = var2;
   }

   public Iterator iterator() {
      Iterator var1 = this.val$set1.iterator();
      Iterator var2 = this.val$set2.iterator();
      return new Sets$4$1(this, var1, var2);
   }

   public int size() {
      return Iterators.size(this.iterator());
   }

   public boolean isEmpty() {
      return this.val$set1.equals(this.val$set2);
   }

   public boolean contains(Object var1) {
      return this.val$set1.contains(var1) ^ this.val$set2.contains(var1);
   }
}
