package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$1;
import java.util.Iterator;

class Multisets$1$1 extends AbstractIterator {
   // $FF: synthetic field
   final Iterator val$iterator1;
   // $FF: synthetic field
   final Iterator val$iterator2;
   // $FF: synthetic field
   final Multisets$1 this$0;

   Multisets$1$1(Multisets$1 var1, Iterator var2, Iterator var3) {
      this.this$0 = var1;
      this.val$iterator1 = var2;
      this.val$iterator2 = var3;
   }

   protected Multiset$Entry computeNext() {
      Multiset$Entry var1;
      Object var2;
      if(this.val$iterator1.hasNext()) {
         var1 = (Multiset$Entry)this.val$iterator1.next();
         var2 = var1.getElement();
         int var3 = Math.max(var1.getCount(), this.this$0.val$multiset2.count(var2));
         return Multisets.immutableEntry(var2, var3);
      } else {
         do {
            if(!this.val$iterator2.hasNext()) {
               return (Multiset$Entry)this.endOfData();
            }

            var1 = (Multiset$Entry)this.val$iterator2.next();
            var2 = var1.getElement();
         } while(this.this$0.val$multiset1.contains(var2));

         return Multisets.immutableEntry(var2, var1.getCount());
      }
   }
}
