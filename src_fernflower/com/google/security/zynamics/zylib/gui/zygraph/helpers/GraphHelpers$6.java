package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import java.util.ArrayList;

final class GraphHelpers$6 implements INodeCallback {
   // $FF: synthetic field
   final ArrayList val$nodes;

   GraphHelpers$6(ArrayList var1) {
      this.val$nodes = var1;
   }

   public IterationMode next(ISelectableNode var1) {
      this.val$nodes.add(var1);
      return IterationMode.CONTINUE;
   }
}
