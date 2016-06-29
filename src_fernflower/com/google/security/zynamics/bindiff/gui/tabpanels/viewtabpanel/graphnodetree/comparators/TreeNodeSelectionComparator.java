package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import java.util.Comparator;

public class TreeNodeSelectionComparator implements Comparator {
   private final ESortOrder order;

   public TreeNodeSelectionComparator(ESortOrder var1) {
      this.order = (ESortOrder)Preconditions.checkNotNull(var1);
   }

   public int compare(ISortableTreeNode var1, ISortableTreeNode var2) {
      int var3 = 0;
      if(!var1.isSelected() && var2.isSelected()) {
         var3 = 1;
      } else if(var1.isSelected() && !var2.isSelected()) {
         var3 = -1;
      }

      if(this.order == ESortOrder.DESCENDING) {
         var3 *= -1;
      }

      return var3;
   }
}
