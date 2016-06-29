package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.ViewNodeAdapter;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

final class ProximityRangeCalculator$1 implements ICollectionFilter {
   // $FF: synthetic field
   final IGroupNode val$parentGroup;

   ProximityRangeCalculator$1(IGroupNode var1) {
      this.val$parentGroup = var1;
   }

   public boolean qualifies(ViewNodeAdapter var1) {
      return var1.getNode() == this.val$parentGroup;
   }
}
