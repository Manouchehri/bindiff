package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import java.util.Collection;

final class GraphSelectionUpdater$1 implements IEdgeCallback {
   // $FF: synthetic field
   final Collection val$edgesToSelect;

   GraphSelectionUpdater$1(Collection var1) {
      this.val$edgesToSelect = var1;
   }

   public IterationMode nextEdge(ZyGraphEdge var1) {
      if(var1.getSource().getRawNode().isSelected() || var1.getTarget().getRawNode().isSelected()) {
         this.val$edgesToSelect.add(var1);
      }

      return IterationMode.CONTINUE;
   }
}
