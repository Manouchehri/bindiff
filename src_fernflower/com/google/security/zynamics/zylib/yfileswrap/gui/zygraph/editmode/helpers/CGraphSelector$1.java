package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.base.Function;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import y.c.q;

final class CGraphSelector$1 implements Function {
   public q apply(ZyGraphNode var1) {
      return var1.getNode();
   }
}
