package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.util.ArrayList;

final class GraphHelpers$13 implements INodeCallback {
   // $FF: synthetic field
   final ArrayList val$deselect;

   GraphHelpers$13(ArrayList var1) {
      this.val$deselect = var1;
   }

   public IterationMode next(IGraphNode var1) {
      if(GraphHelpers.areAllParentsDeselected(var1) && !this.val$deselect.contains(var1)) {
         this.val$deselect.add(var1);
      }

      return IterationMode.CONTINUE;
   }
}
