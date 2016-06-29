package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

final class IteratorFunctions$5 implements INodeCallback {
   // $FF: synthetic field
   final INodeCallback val$callback;

   IteratorFunctions$5(INodeCallback var1) {
      this.val$callback = var1;
   }

   public IterationMode next(ZyGraphNode var1) {
      return !var1.isVisible()?IterationMode.CONTINUE:this.val$callback.next(var1);
   }
}
