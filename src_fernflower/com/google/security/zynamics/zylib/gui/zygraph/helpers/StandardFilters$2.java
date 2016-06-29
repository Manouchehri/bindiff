package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;

final class StandardFilters$2 implements INodeFilter {
   // $FF: synthetic field
   final INodeFilter val$filter;

   StandardFilters$2(INodeFilter var1) {
      this.val$filter = var1;
   }

   public boolean qualifies(Object var1) {
      return !this.val$filter.qualifies(var1);
   }
}
