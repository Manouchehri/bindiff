package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets$SetView;
import java.util.Iterator;
import java.util.Set;

final class Sets$1 extends Sets$SetView {
   // $FF: synthetic field
   final Set val$set1;
   // $FF: synthetic field
   final Set val$set2minus1;
   // $FF: synthetic field
   final Set val$set2;

   Sets$1(Set var1, Set var2, Set var3) {
      super((Sets$1)null);
      this.val$set1 = var1;
      this.val$set2minus1 = var2;
      this.val$set2 = var3;
   }

   public int size() {
      return this.val$set1.size() + this.val$set2minus1.size();
   }

   public boolean isEmpty() {
      return this.val$set1.isEmpty() && this.val$set2.isEmpty();
   }

   public Iterator iterator() {
      return Iterators.unmodifiableIterator(Iterators.concat(this.val$set1.iterator(), this.val$set2minus1.iterator()));
   }

   public boolean contains(Object var1) {
      return this.val$set1.contains(var1) || this.val$set2.contains(var1);
   }

   public Set copyInto(Set var1) {
      var1.addAll(this.val$set1);
      var1.addAll(this.val$set2);
      return var1;
   }

   public ImmutableSet immutableCopy() {
      return (new ImmutableSet$Builder()).addAll((Iterable)this.val$set1).addAll((Iterable)this.val$set2).build();
   }
}
