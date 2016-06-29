package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Sets$4;
import java.util.Iterator;

class Sets$4$1 extends AbstractIterator {
   // $FF: synthetic field
   final Iterator val$itr1;
   // $FF: synthetic field
   final Iterator val$itr2;
   // $FF: synthetic field
   final Sets$4 this$0;

   Sets$4$1(Sets$4 var1, Iterator var2, Iterator var3) {
      this.this$0 = var1;
      this.val$itr1 = var2;
      this.val$itr2 = var3;
   }

   public Object computeNext() {
      while(true) {
         Object var1;
         if(this.val$itr1.hasNext()) {
            var1 = this.val$itr1.next();
            if(this.this$0.val$set2.contains(var1)) {
               continue;
            }

            return var1;
         }

         do {
            if(!this.val$itr2.hasNext()) {
               return this.endOfData();
            }

            var1 = this.val$itr2.next();
         } while(this.this$0.val$set1.contains(var1));

         return var1;
      }
   }
}
