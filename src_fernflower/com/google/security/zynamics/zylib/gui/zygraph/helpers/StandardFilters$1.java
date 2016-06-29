package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.CProximityNode;

final class StandardFilters$1 implements INodeFilter {
   public boolean qualifies(Object var1) {
      return var1 instanceof CProximityNode;
   }
}
