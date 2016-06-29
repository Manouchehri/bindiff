package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$2;
import java.util.Iterator;

class Multisets$2$1 extends AbstractIterator {
   // $FF: synthetic field
   final Iterator val$iterator1;
   // $FF: synthetic field
   final Multisets$2 this$0;

   Multisets$2$1(Multisets$2 var1, Iterator var2) {
      this.this$0 = var1;
      this.val$iterator1 = var2;
   }

   protected Multiset$Entry computeNext() {
      while(true) {
         if(this.val$iterator1.hasNext()) {
            Multiset$Entry var1 = (Multiset$Entry)this.val$iterator1.next();
            Object var2 = var1.getElement();
            int var3 = Math.min(var1.getCount(), this.this$0.val$multiset2.count(var2));
            if(var3 <= 0) {
               continue;
            }

            return Multisets.immutableEntry(var2, var3);
         }

         return (Multiset$Entry)this.endOfData();
      }
   }
}
