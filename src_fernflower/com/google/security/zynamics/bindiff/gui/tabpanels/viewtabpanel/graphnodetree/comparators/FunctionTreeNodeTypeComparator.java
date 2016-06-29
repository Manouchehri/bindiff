package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import java.util.Comparator;

public class FunctionTreeNodeTypeComparator implements Comparator {
   private final ESortOrder order;

   public FunctionTreeNodeTypeComparator(ESortOrder var1) {
      this.order = (ESortOrder)Preconditions.checkNotNull(var1);
   }

   public int compare(ISortableTreeNode var1, ISortableTreeNode var2) {
      Integer var3 = Integer.valueOf(EFunctionType.getOrdinal(var1.getFunctionType()));
      Integer var4 = Integer.valueOf(EFunctionType.getOrdinal(var2.getFunctionType()));
      int var5 = var3.compareTo(var4);
      if(this.order == ESortOrder.DESCENDING) {
         var5 *= -1;
      }

      return var5;
   }
}
