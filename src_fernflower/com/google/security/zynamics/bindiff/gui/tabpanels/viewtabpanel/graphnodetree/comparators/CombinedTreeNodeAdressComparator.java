package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Comparator;

public class CombinedTreeNodeAdressComparator implements Comparator {
   private final ESortOrder order;

   public CombinedTreeNodeAdressComparator(ESortOrder var1) {
      Preconditions.checkNotNull(var1);
      this.order = var1;
   }

   public int compare(ISortableTreeNode var1, ISortableTreeNode var2) {
      boolean var3 = false;
      IAddress var4 = var1.getAddress(ESide.PRIMARY);
      IAddress var5 = var1.getAddress(ESide.SECONDARY);
      IAddress var6 = var2.getAddress(ESide.PRIMARY);
      IAddress var7 = var2.getAddress(ESide.SECONDARY);
      int var8;
      if(var4 == null && var6 == null) {
         var8 = var5.compareTo(var7);
      } else if(var4 == null) {
         var8 = 1;
      } else if(var6 == null) {
         var8 = -1;
      } else {
         var8 = var4.compareTo(var6);
      }

      if(this.order == ESortOrder.DESCENDING) {
         var8 *= -1;
      }

      return var8;
   }
}
