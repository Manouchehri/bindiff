package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphNodeTreePanel$InternalClearButtonListener implements ActionListener {
   // $FF: synthetic field
   final GraphNodeTreePanel this$0;

   private GraphNodeTreePanel$InternalClearButtonListener(GraphNodeTreePanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      GraphNodeMultiFilter var2 = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getFilter();
      var2.clearSettings(false);
      GraphNodeTreePanel.access$400(this.this$0).setDefaults(1);
      TreeNodeSearcher var3 = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getSearcher();
      var3.setSearchString("");
      GraphNodeTreePanel.access$500(this.this$0).clear();
      GraphNodeTreePanel.access$700(this.this$0).setIcon(GraphNodeTreePanel.access$600());
   }

   // $FF: synthetic method
   GraphNodeTreePanel$InternalClearButtonListener(GraphNodeTreePanel var1, GraphNodeTreePanel$1 var2) {
      this(var1);
   }
}
