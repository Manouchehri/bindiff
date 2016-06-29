package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.grouping.GroupHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Collection;

public class SelectedVisibleFilter implements ICollectionFilter {
   public static Collection filter(Collection var0) {
      return CollectionHelpers.filter(var0, new SelectedVisibleFilter());
   }

   public boolean qualifies(ZyGraphNode var1) {
      IViewNode var2 = var1.getRawNode();
      return var2.getParentGroup() == null || GroupHelpers.isExpanded(var2.getParentGroup());
   }
}
