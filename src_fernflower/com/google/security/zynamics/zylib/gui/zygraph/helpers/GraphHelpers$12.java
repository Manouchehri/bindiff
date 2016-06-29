package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IFilteredItemCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;

final class GraphHelpers$12 implements INodeCallback {
   // $FF: synthetic field
   final IFilteredItemCallback val$callback;

   GraphHelpers$12(IFilteredItemCallback var1) {
      this.val$callback = var1;
   }

   public IterationMode next(Object var1) {
      return this.val$callback.qualifies(var1)?this.val$callback.next(var1):IterationMode.CONTINUE;
   }
}
