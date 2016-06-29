package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.IViewsFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import java.util.HashSet;

class MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener implements IViewsFilterCheckboxListener {
   // $FF: synthetic field
   final MatchedFunctionsTreeNodeContextPanel this$0;

   private MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener(MatchedFunctionsTreeNodeContextPanel var1) {
      this.this$0 = var1;
   }

   public void functionViewsFilterChanged(boolean var1, boolean var2, boolean var3) {
      RawCallGraph var4 = MatchedFunctionsTreeNodeContextPanel.access$300(this.this$0).getCallgraph(ESide.PRIMARY);
      RawCallGraph var5 = MatchedFunctionsTreeNodeContextPanel.access$300(this.this$0).getCallgraph(ESide.SECONDARY);
      HashSet var6 = new HashSet();
      if(!var1 && !var2 && !var3) {
         var6.addAll(GraphGetter.getMatchedFunctionPairs(var4, var5));
      } else {
         if(var1) {
            var6.addAll(GraphGetter.getStructuralChangedFunctionPairs(var4, var5));
         }

         if(var2) {
            var6.addAll(GraphGetter.getInstructionOnlyChangedFunctionPairs(var4, var5));
         }

         if(var3) {
            var6.addAll(GraphGetter.getIdenticalFunctionPairs(var4, var5));
         }
      }

      ((MatchedFunctionsViewsTableModel)MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0).getTableModel()).setMatchedFunctionPairs(var6);
   }

   // $FF: synthetic method
   MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener(MatchedFunctionsTreeNodeContextPanel var1, MatchedFunctionsTreeNodeContextPanel$1 var2) {
      this(var1);
   }
}
