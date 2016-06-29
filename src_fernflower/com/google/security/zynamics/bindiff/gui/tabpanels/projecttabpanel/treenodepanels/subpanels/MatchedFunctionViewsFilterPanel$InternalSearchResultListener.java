package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.ListSelectionModel;

class MatchedFunctionViewsFilterPanel$InternalSearchResultListener implements IViewSearchFieldListener {
   // $FF: synthetic field
   final MatchedFunctionViewsFilterPanel this$0;

   private MatchedFunctionViewsFilterPanel$InternalSearchResultListener(MatchedFunctionViewsFilterPanel var1) {
      this.this$0 = var1;
   }

   public void reset() {
      MatchedFunctionsViewsTableModel var1 = (MatchedFunctionsViewsTableModel)MatchedFunctionViewsFilterPanel.access$1100(this.this$0).getTableModel();
      Diff var2 = var1.getDiff();
      RawCallGraph var3 = var2.getCallgraph(ESide.PRIMARY);
      RawCallGraph var4 = var2.getCallgraph(ESide.SECONDARY);
      HashSet var5 = new HashSet();
      if(MatchedFunctionViewsFilterPanel.access$700(this.this$0).isSelected() && MatchedFunctionViewsFilterPanel.access$800(this.this$0).isSelected() && MatchedFunctionViewsFilterPanel.access$900(this.this$0).isSelected()) {
         var5.addAll(GraphGetter.getMatchedFunctionPairs(var3, var4));
      } else {
         if(MatchedFunctionViewsFilterPanel.access$700(this.this$0).isSelected()) {
            var5.addAll(GraphGetter.getStructuralChangedFunctionPairs(var3, var4));
         }

         if(MatchedFunctionViewsFilterPanel.access$800(this.this$0).isSelected()) {
            var5.addAll(GraphGetter.getInstructionOnlyChangedFunctionPairs(var3, var4));
         }

         if(MatchedFunctionViewsFilterPanel.access$900(this.this$0).isSelected()) {
            var5.addAll(GraphGetter.getIdenticalFunctionPairs(var3, var4));
         }
      }

      var1.setMatchedFunctionPairs(var5);
      var1.fireTableDataChanged();
      MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$500());
      this.this$0.updateUI();
   }

   public void searched(List var1, boolean var2) {
      HashSet var3 = new HashSet();
      MatchedFunctionsViewsTableModel var4 = (MatchedFunctionsViewsTableModel)MatchedFunctionViewsFilterPanel.access$1100(this.this$0).getTableModel();
      CTableSorter var5 = MatchedFunctionViewsFilterPanel.access$1100(this.this$0).getModel();
      ListSelectionModel var6 = MatchedFunctionViewsFilterPanel.access$1100(this.this$0).getSelectionModel();
      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         Integer var8 = (Integer)var7.next();
         int var9 = var5.modelIndex(var8.intValue());
         if(var2) {
            var6.addSelectionInterval(var8.intValue(), var8.intValue());
         } else {
            var3.add(var4.getMatchedFunctionPairAt(var9));
         }
      }

      if(!var2) {
         var4.setMatchedFunctionPairs(var3);
         var4.fireTableDataChanged();
      }

      if(var1.size() > 0) {
         MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$1200());
      } else {
         MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$500());
      }

      this.this$0.updateUI();
   }

   // $FF: synthetic method
   MatchedFunctionViewsFilterPanel$InternalSearchResultListener(MatchedFunctionViewsFilterPanel var1, MatchedFunctionViewsFilterPanel$1 var2) {
      this(var1);
   }
}
