package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.SwingInvoker;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode$InternalListener;

class ZyGraphNode$InternalListener$1 extends SwingInvoker {
   // $FF: synthetic field
   final IViewNode val$node;
   // $FF: synthetic field
   final boolean val$visible;
   // $FF: synthetic field
   final ZyGraphNode$InternalListener this$1;

   ZyGraphNode$InternalListener$1(ZyGraphNode$InternalListener var1, IViewNode var2, boolean var3) {
      this.this$1 = var1;
      this.val$node = var2;
      this.val$visible = var3;
   }

   protected void operation() {
      ZyGraphNode$InternalListener.access$400(this.this$1, this.val$node, this.val$visible);
   }
}
