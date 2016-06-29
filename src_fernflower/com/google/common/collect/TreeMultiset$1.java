package com.google.common.collect;

import com.google.common.collect.Multisets$AbstractEntry;
import com.google.common.collect.TreeMultiset;
import com.google.common.collect.TreeMultiset$AvlNode;

class TreeMultiset$1 extends Multisets$AbstractEntry {
   // $FF: synthetic field
   final TreeMultiset$AvlNode val$baseEntry;
   // $FF: synthetic field
   final TreeMultiset this$0;

   TreeMultiset$1(TreeMultiset var1, TreeMultiset$AvlNode var2) {
      this.this$0 = var1;
      this.val$baseEntry = var2;
   }

   public Object getElement() {
      return this.val$baseEntry.getElement();
   }

   public int getCount() {
      int var1 = this.val$baseEntry.getCount();
      return var1 == 0?this.this$0.count(this.getElement()):var1;
   }
}
