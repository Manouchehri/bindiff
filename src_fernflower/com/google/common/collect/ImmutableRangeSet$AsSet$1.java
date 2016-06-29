package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableRangeSet$AsSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Range;
import java.util.Iterator;

class ImmutableRangeSet$AsSet$1 extends AbstractIterator {
   final Iterator rangeItr;
   Iterator elemItr;
   // $FF: synthetic field
   final ImmutableRangeSet$AsSet this$1;

   ImmutableRangeSet$AsSet$1(ImmutableRangeSet$AsSet var1) {
      this.this$1 = var1;
      this.rangeItr = ImmutableRangeSet.access$000(this.this$1.this$0).iterator();
      this.elemItr = Iterators.emptyIterator();
   }

   protected Comparable computeNext() {
      while(true) {
         if(!this.elemItr.hasNext()) {
            if(this.rangeItr.hasNext()) {
               this.elemItr = ContiguousSet.create((Range)this.rangeItr.next(), ImmutableRangeSet$AsSet.access$100(this.this$1)).iterator();
               continue;
            }

            return (Comparable)this.endOfData();
         }

         return (Comparable)this.elemItr.next();
      }
   }
}
