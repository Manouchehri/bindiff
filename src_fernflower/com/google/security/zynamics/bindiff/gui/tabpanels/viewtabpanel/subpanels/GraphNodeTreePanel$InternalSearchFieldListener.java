package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.components.treesearchfield.ITreeSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$1;

class GraphNodeTreePanel$InternalSearchFieldListener implements ITreeSearchFieldListener {
   // $FF: synthetic field
   final GraphNodeTreePanel this$0;

   private GraphNodeTreePanel$InternalSearchFieldListener(GraphNodeTreePanel var1) {
      this.this$0 = var1;
   }

   public void searchChanged(String var1) {
      TreeNodeSearcher var2 = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getSearcher();
      var2.setSearchString(var1);
      this.this$0.updateClearTreeSearchIcons();
   }

   // $FF: synthetic method
   GraphNodeTreePanel$InternalSearchFieldListener(GraphNodeTreePanel var1, GraphNodeTreePanel$1 var2) {
      this(var1);
   }
}
