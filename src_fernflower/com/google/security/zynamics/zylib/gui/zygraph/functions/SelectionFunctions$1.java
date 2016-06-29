package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;

final class SelectionFunctions$1 implements INodeCallback {
   // $FF: synthetic field
   final ArrayList val$toUnselect;
   // $FF: synthetic field
   final ArrayList val$toSelect;

   SelectionFunctions$1(ArrayList var1, ArrayList var2) {
      this.val$toUnselect = var1;
      this.val$toSelect = var2;
   }

   public IterationMode next(ZyGraphNode var1) {
      if(var1.isSelected()) {
         this.val$toUnselect.add(var1);
      } else {
         this.val$toSelect.add(var1);
      }

      return IterationMode.CONTINUE;
   }
}
