package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.ListSelectionModel;

class UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener implements IViewSearchFieldListener {
   // $FF: synthetic field
   final UnmatchedFunctionViewsFilterPanel this$0;

   private UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener(UnmatchedFunctionViewsFilterPanel var1) {
      this.this$0 = var1;
   }

   public void reset() {
      UnmatchedFunctionViewsTableModel var1 = (UnmatchedFunctionViewsTableModel)UnmatchedFunctionViewsFilterPanel.access$700(this.this$0).getTableModel();
      Diff var2 = var1.getDiff();
      HashSet var3 = new HashSet();
      var3.addAll(GraphGetter.getUnmatchedFunctions(var2.getCallgraph(UnmatchedFunctionViewsFilterPanel.access$600(this.this$0))));
      var1.setUnmatchedFunctions(var3);
      var1.fireTableDataChanged();
      UnmatchedFunctionViewsFilterPanel.access$500(this.this$0).setIcon(UnmatchedFunctionViewsFilterPanel.access$400());
      this.this$0.updateUI();
   }

   public void searched(List var1, boolean var2) {
      HashSet var3 = new HashSet();
      UnmatchedFunctionViewsTableModel var4 = (UnmatchedFunctionViewsTableModel)UnmatchedFunctionViewsFilterPanel.access$700(this.this$0).getTableModel();
      CTableSorter var5 = UnmatchedFunctionViewsFilterPanel.access$700(this.this$0).getModel();
      ListSelectionModel var6 = UnmatchedFunctionViewsFilterPanel.access$700(this.this$0).getSelectionModel();
      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         Integer var8 = (Integer)var7.next();
         int var9 = var5.modelIndex(var8.intValue());
         if(var2) {
            var6.addSelectionInterval(var8.intValue(), var8.intValue());
         } else {
            var3.add(var4.getUnmatchedFunctionAt(var9));
         }
      }

      if(!var2) {
         var4.setUnmatchedFunctions(var3);
         var4.fireTableDataChanged();
      }

      if(var1.size() > 0) {
         UnmatchedFunctionViewsFilterPanel.access$500(this.this$0).setIcon(UnmatchedFunctionViewsFilterPanel.access$800());
      } else {
         UnmatchedFunctionViewsFilterPanel.access$500(this.this$0).setIcon(UnmatchedFunctionViewsFilterPanel.access$400());
      }

      this.this$0.updateUI();
   }

   // $FF: synthetic method
   UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener(UnmatchedFunctionViewsFilterPanel var1, UnmatchedFunctionViewsFilterPanel$1 var2) {
      this(var1);
   }
}
