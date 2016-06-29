package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.types.graphs.GraphAlgorithms;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.util.ArrayList;

final class GraphHelpers$3 implements INodeCallback {
   // $FF: synthetic field
   final ArrayList val$toSelect;
   // $FF: synthetic field
   final INodeFilter val$deselectedFilter;

   GraphHelpers$3(ArrayList var1, INodeFilter var2) {
      this.val$toSelect = var1;
      this.val$deselectedFilter = var2;
   }

   public IterationMode next(IGraphNode var1) {
      this.val$toSelect.addAll(GraphAlgorithms.collectParents(var1, this.val$deselectedFilter));
      return IterationMode.CONTINUE;
   }
}
