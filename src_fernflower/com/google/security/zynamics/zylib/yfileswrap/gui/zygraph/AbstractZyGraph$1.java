package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Comparator;

class AbstractZyGraph$1 implements Comparator {
   // $FF: synthetic field
   final AbstractZyGraph this$0;

   AbstractZyGraph$1(AbstractZyGraph var1) {
      this.this$0 = var1;
   }

   private boolean isInsideGroup(IViewNode var1, IGroupNode var2) {
      IGroupNode var3 = var1.getParentGroup();
      return var3 == null?false:(var3 == var2?true:this.isInsideGroup(var1, var2.getParentGroup()));
   }

   public int compare(ZyGraphNode var1, ZyGraphNode var2) {
      IViewNode var3 = var1.getRawNode();
      IViewNode var4 = var2.getRawNode();
      return var3 instanceof IGroupNode && var4 instanceof IGroupNode?(this.isInsideGroup(var4, (IGroupNode)var3)?1:(this.isInsideGroup(var3, (IGroupNode)var4)?-1:0)):(var3 instanceof IGroupNode?(this.isInsideGroup(var4, (IGroupNode)var3)?1:0):(var2 instanceof IGroupNode?(this.isInsideGroup(var3, (IGroupNode)var4)?1:0):0));
   }
}
