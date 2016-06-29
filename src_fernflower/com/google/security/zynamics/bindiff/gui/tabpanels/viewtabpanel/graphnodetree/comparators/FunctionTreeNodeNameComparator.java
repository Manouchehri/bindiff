package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import java.util.Comparator;

public class FunctionTreeNodeNameComparator implements Comparator {
   private final ESortOrder order;

   public FunctionTreeNodeNameComparator(ESortOrder var1) {
      this.order = (ESortOrder)Preconditions.checkNotNull(var1);
   }

   public int compare(ISortableTreeNode var1, ISortableTreeNode var2) {
      boolean var3 = false;
      int var4 = var1.getFunctionName().compareTo(var2.getFunctionName());
      if(this.order == ESortOrder.DESCENDING) {
         var4 *= -1;
      }

      return var4;
   }
}
