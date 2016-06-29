package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphNodeTreePanel$InternalOptionsButtonListener implements ActionListener {
   // $FF: synthetic field
   final GraphNodeTreePanel this$0;

   private GraphNodeTreePanel$InternalOptionsButtonListener(GraphNodeTreePanel var1) {
      this.this$0 = var1;
   }

   private void setFilter(boolean var1) {
      GraphNodeMultiFilter var2 = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getFilter();
      var2.setFilter(GraphNodeTreePanel.access$400(this.this$0).getStartAddress(), GraphNodeTreePanel.access$400(this.this$0).getEndAddress(), GraphNodeTreePanel.access$400(this.this$0).getMatchStateFilter(), GraphNodeTreePanel.access$400(this.this$0).getSelectionFilter(), GraphNodeTreePanel.access$400(this.this$0).getVisibilityFilter(), GraphNodeTreePanel.access$400(this.this$0).getSideFilter(), false);
      if(var1) {
         var2.notifyListeners();
      }

   }

   private void setSearcher(boolean var1) {
      TreeNodeSearcher var2 = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getSearcher();
      boolean var3 = GraphNodeTreePanel.access$400(this.this$0).getRegEx();
      boolean var4 = GraphNodeTreePanel.access$400(this.this$0).getCaseSensitive();
      boolean var5 = GraphNodeTreePanel.access$400(this.this$0).getPrimarySide();
      boolean var6 = GraphNodeTreePanel.access$400(this.this$0).getSecondarySide();
      boolean var7 = GraphNodeTreePanel.access$400(this.this$0).getHighlightGraphNodes();
      boolean var8 = GraphNodeTreePanel.access$400(this.this$0).getUseTemporaryResult();
      var2.setSearchSettings(var3, var4, var5, var6, var8, var7);
      if(var1) {
         var2.notifyListeners();
      }

   }

   private void setSorter(boolean var1) {
      TreeNodeMultiSorter var2 = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getSorter();

      for(int var3 = 0; var3 < 5; ++var3) {
         ESortByCriterium var4 = GraphNodeTreePanel.access$400(this.this$0).getSortByCriterium(var3);
         ESortOrder var5 = GraphNodeTreePanel.access$400(this.this$0).getSortOrder(var3);
         var2.setCriterium(var4, var5, var3, false);
      }

      if(var1) {
         var2.notifyListeners();
      }

   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource().equals(GraphNodeTreePanel.access$800(this.this$0))) {
         GraphNodeTreePanel.access$400(this.this$0).setVisible(true);
         if(GraphNodeTreePanel.access$400(this.this$0).getOkPressed()) {
            this.setSearcher(false);
            this.setFilter(false);
            this.setSorter(true);
            this.this$0.updateClearTreeSearchIcons();
         }
      }

   }

   // $FF: synthetic method
   GraphNodeTreePanel$InternalOptionsButtonListener(GraphNodeTreePanel var1, GraphNodeTreePanel$1 var2) {
      this(var1);
   }
}
