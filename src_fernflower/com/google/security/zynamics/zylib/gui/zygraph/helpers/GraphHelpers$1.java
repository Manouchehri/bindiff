package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import java.util.ArrayList;

final class GraphHelpers$1 implements INodeCallback {
   // $FF: synthetic field
   final INodeFilter val$filter;
   // $FF: synthetic field
   final ArrayList val$lameHack;

   GraphHelpers$1(INodeFilter var1, ArrayList var2) {
      this.val$filter = var1;
      this.val$lameHack = var2;
   }

   public IterationMode next(Object var1) {
      if(this.val$filter.qualifies(var1)) {
         this.val$lameHack.add(var1);
         return IterationMode.STOP;
      } else {
         return IterationMode.CONTINUE;
      }
   }
}
