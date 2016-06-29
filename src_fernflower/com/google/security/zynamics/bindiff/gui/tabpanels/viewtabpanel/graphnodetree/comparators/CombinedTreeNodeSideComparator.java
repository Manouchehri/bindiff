package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import java.util.Comparator;

public class CombinedTreeNodeSideComparator implements Comparator {
   private final ESortOrder order;

   public CombinedTreeNodeSideComparator(ESortOrder var1) {
      Preconditions.checkNotNull(var1);
      this.order = var1;
   }

   public int compare(ISortableTreeNode var1, ISortableTreeNode var2) {
      int var3 = 0;
      if(var1.getMatchState() == var2.getMatchState()) {
         return 0;
      } else {
         if(var1.getMatchState() == EMatchState.MATCHED) {
            var3 = -1;
         } else if(var2.getMatchState() == EMatchState.MATCHED) {
            var3 = 1;
         } else if(var1.getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
            var3 = -1;
         } else if(var1.getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
            var3 = 1;
         }

         if(this.order == ESortOrder.DESCENDING) {
            var3 *= -1;
         }

         return var3;
      }
   }
}
