package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;

final class NodeFunctions$1 implements INodeCallback {
   // $FF: synthetic field
   final ArrayList val$nodes;

   NodeFunctions$1(ArrayList var1) {
      this.val$nodes = var1;
   }

   public IterationMode next(ZyGraphNode var1) {
      this.val$nodes.add(var1);
      return IterationMode.CONTINUE;
   }
}
