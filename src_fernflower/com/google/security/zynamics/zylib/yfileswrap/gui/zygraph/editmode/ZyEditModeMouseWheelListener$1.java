package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditModeMouseWheelListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

class ZyEditModeMouseWheelListener$1 implements INodeFilter {
   // $FF: synthetic field
   final ZyEditModeMouseWheelListener this$0;

   ZyEditModeMouseWheelListener$1(ZyEditModeMouseWheelListener var1) {
      this.this$0 = var1;
   }

   public boolean qualifies(ZyGraphNode var1) {
      return var1.isSelected();
   }
}
