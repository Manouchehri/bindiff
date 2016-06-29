package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Comparator;

public class SingleTreeNodeAdressComparator implements Comparator {
   private final ESortOrder order;

   public SingleTreeNodeAdressComparator(ESortOrder var1) {
      this.order = (ESortOrder)Preconditions.checkNotNull(var1);
   }

   public int compare(ISortableTreeNode var1, ISortableTreeNode var2) {
      boolean var3 = false;
      IAddress var4 = var1.getAddress();
      IAddress var5 = var2.getAddress();
      int var6 = var4.compareTo(var5);
      if(this.order == ESortOrder.DESCENDING) {
         var6 *= -1;
      }

      return var6;
   }
}
