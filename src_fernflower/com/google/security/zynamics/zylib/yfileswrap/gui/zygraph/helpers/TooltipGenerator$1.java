package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

final class TooltipGenerator$1 implements ICollectionFilter {
   public boolean qualifies(Object var1) {
      return !((IViewNode)var1).isVisible();
   }
}
