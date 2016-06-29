package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.TreeBasedTable;
import java.util.Iterator;
import java.util.Map;

class TreeBasedTable$1 implements Function {
   // $FF: synthetic field
   final TreeBasedTable this$0;

   TreeBasedTable$1(TreeBasedTable var1) {
      this.this$0 = var1;
   }

   public Iterator apply(Map var1) {
      return var1.keySet().iterator();
   }
}
