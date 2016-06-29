package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

final class Iterators$8 extends AbstractIterator {
   // $FF: synthetic field
   final Iterator val$unfiltered;
   // $FF: synthetic field
   final Predicate val$predicate;

   Iterators$8(Iterator var1, Predicate var2) {
      this.val$unfiltered = var1;
      this.val$predicate = var2;
   }

   protected Object computeNext() {
      while(true) {
         if(this.val$unfiltered.hasNext()) {
            Object var1 = this.val$unfiltered.next();
            if(!this.val$predicate.apply(var1)) {
               continue;
            }

            return var1;
         }

         return this.endOfData();
      }
   }
}
