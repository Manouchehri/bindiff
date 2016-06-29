package com.google.common.base;

import com.google.common.base.AbstractIterator;
import com.google.common.base.Optional;
import com.google.common.base.Optional$1;
import com.google.common.base.Preconditions;
import java.util.Iterator;

class Optional$1$1 extends AbstractIterator {
   private final Iterator iterator;
   // $FF: synthetic field
   final Optional$1 this$0;

   Optional$1$1(Optional$1 var1) {
      this.this$0 = var1;
      this.iterator = (Iterator)Preconditions.checkNotNull(this.this$0.val$optionals.iterator());
   }

   protected Object computeNext() {
      while(true) {
         if(this.iterator.hasNext()) {
            Optional var1 = (Optional)this.iterator.next();
            if(!var1.isPresent()) {
               continue;
            }

            return var1.get();
         }

         return this.endOfData();
      }
   }
}
