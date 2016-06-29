package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets$SubSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

class Sets$SubSet$1 extends UnmodifiableIterator {
   final ImmutableList elements;
   int remainingSetBits;
   // $FF: synthetic field
   final Sets$SubSet this$0;

   Sets$SubSet$1(Sets$SubSet var1) {
      this.this$0 = var1;
      this.elements = Sets$SubSet.access$100(this.this$0).keySet().asList();
      this.remainingSetBits = Sets$SubSet.access$200(this.this$0);
   }

   public boolean hasNext() {
      return this.remainingSetBits != 0;
   }

   public Object next() {
      int var1 = Integer.numberOfTrailingZeros(this.remainingSetBits);
      if(var1 == 32) {
         throw new NoSuchElementException();
      } else {
         this.remainingSetBits &= ~(1 << var1);
         return this.elements.get(var1);
      }
   }
}
