package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;

final class StandardFilters$3 implements INodeFilter {
   public boolean qualifies(ISelectableNode var1) {
      return var1.isSelected();
   }
}
