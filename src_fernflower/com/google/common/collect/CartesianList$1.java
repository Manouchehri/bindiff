package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CartesianList;
import com.google.common.collect.ImmutableList;
import java.util.List;

class CartesianList$1 extends ImmutableList {
   // $FF: synthetic field
   final int val$index;
   // $FF: synthetic field
   final CartesianList this$0;

   CartesianList$1(CartesianList var1, int var2) {
      this.this$0 = var1;
      this.val$index = var2;
   }

   public int size() {
      return CartesianList.access$000(this.this$0).size();
   }

   public Object get(int var1) {
      Preconditions.checkElementIndex(var1, this.size());
      int var2 = CartesianList.access$100(this.this$0, this.val$index, var1);
      return ((List)CartesianList.access$000(this.this$0).get(var1)).get(var2);
   }

   boolean isPartialView() {
      return true;
   }
}
