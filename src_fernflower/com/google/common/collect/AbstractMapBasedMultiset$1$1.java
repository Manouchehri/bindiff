package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.AbstractMapBasedMultiset$1;
import com.google.common.collect.Count;
import com.google.common.collect.Multisets$AbstractEntry;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$1$1 extends Multisets$AbstractEntry {
   // $FF: synthetic field
   final Entry val$mapEntry;
   // $FF: synthetic field
   final AbstractMapBasedMultiset$1 this$1;

   AbstractMapBasedMultiset$1$1(AbstractMapBasedMultiset$1 var1, Entry var2) {
      this.this$1 = var1;
      this.val$mapEntry = var2;
   }

   public Object getElement() {
      return this.val$mapEntry.getKey();
   }

   public int getCount() {
      Count var1 = (Count)this.val$mapEntry.getValue();
      if(var1 == null || var1.get() == 0) {
         Count var2 = (Count)AbstractMapBasedMultiset.access$000(this.this$1.this$0).get(this.getElement());
         if(var2 != null) {
            return var2.get();
         }
      }

      return var1 == null?0:var1.get();
   }
}
