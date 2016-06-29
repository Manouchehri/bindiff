package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.types.lists.IFilledList;

final class GraphHelpers$9 implements INodeCallback {
   // $FF: synthetic field
   final IFilledList val$nodes;

   GraphHelpers$9(IFilledList var1) {
      this.val$nodes = var1;
   }

   public IterationMode next(ISelectableNode var1) {
      this.val$nodes.add(var1);
      return IterationMode.CONTINUE;
   }
}
