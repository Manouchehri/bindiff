package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import java.util.List;

final class GraphHelpers$4 implements INodeCallback {
   // $FF: synthetic field
   final ICollectionFilter val$filter;
   // $FF: synthetic field
   final List val$items;

   GraphHelpers$4(ICollectionFilter var1, List var2) {
      this.val$filter = var1;
      this.val$items = var2;
   }

   public IterationMode next(Object var1) {
      if(this.val$filter.qualifies(var1)) {
         this.val$items.add(var1);
      }

      return IterationMode.CONTINUE;
   }
}
