package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.swing.tree.TreePath;

class SelectionHistoryTreePanel$InternalTreeMouseListener extends MouseAdapter {
   // $FF: synthetic field
   final SelectionHistoryTreePanel this$0;

   private SelectionHistoryTreePanel$InternalTreeMouseListener(SelectionHistoryTreePanel var1) {
      this.this$0 = var1;
   }

   private TreePath getTreePath(MouseEvent var1) {
      return SelectionHistoryTreePanel.access$800(this.this$0).getPathForLocation(var1.getX(), var1.getY());
   }

   public void mousePressed(MouseEvent var1) {
      TreePath var2 = this.getTreePath(var1);
      if(var2 != null) {
         Object var3 = var2.getLastPathComponent();
         if(var1.getButton() == 1) {
            SelectionHistoryTreePanel.access$500(this.this$0).getPrimaryGraph().getSelectionHistory().setEnabled(false);
            SelectionHistoryTreePanel.access$500(this.this$0).getSecondaryGraph().getSelectionHistory().setEnabled(false);
            SelectionHistoryTreePanel.access$500(this.this$0).getCombinedGraph().getSelectionHistory().setEnabled(false);
            if(var3 instanceof SelectionHistoryTreeGroupNode) {
               SelectionHistoryTreeGroupNode var4 = (SelectionHistoryTreeGroupNode)var3;
               Collection var5;
               List var6;
               if(SelectionHistoryTreePanel.access$500(this.this$0) instanceof SingleGraph) {
                  var5 = var4.getSnapshot().getSingleGraphSelection();
                  var6 = GraphNodeFilter.filterNodes((AbstractZyGraph)((SingleGraph)SelectionHistoryTreePanel.access$500(this.this$0)), GraphNodeFilter$Criterium.SELECTED);
                  if((new HashSet(var5)).equals(new HashSet(var6))) {
                     SelectionHistoryTreePanel.access$1100(this.this$0, var5);
                  } else {
                     SelectionHistoryTreePanel.access$1200(this.this$0, var5);
                  }
               } else if(SelectionHistoryTreePanel.access$500(this.this$0) instanceof CombinedGraph) {
                  var5 = var4.getSnapshot().getCombinedGraphSelection();
                  var6 = GraphNodeFilter.filterNodes((AbstractZyGraph)((CombinedGraph)SelectionHistoryTreePanel.access$500(this.this$0)), GraphNodeFilter$Criterium.SELECTED);
                  if((new HashSet(var5)).equals(new HashSet(var6))) {
                     SelectionHistoryTreePanel.access$1300(this.this$0, var5);
                  } else {
                     SelectionHistoryTreePanel.access$1400(this.this$0, var5);
                  }
               }
            } else if(var3 instanceof SelectionHistoryTreeNode) {
               SelectionHistoryTreeNode var7 = (SelectionHistoryTreeNode)var3;
               ZyGraphNode var8 = var7.getNode();
               boolean var9 = var8.isSelected();
               SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)SelectionHistoryTreePanel.access$700(this.this$0));
               if(var8 instanceof SingleDiffNode) {
                  ((SingleGraph)SelectionHistoryTreePanel.access$500(this.this$0)).selectNode((SingleDiffNode)var8, !var9);
               } else if(var8 instanceof CombinedDiffNode) {
                  ((CombinedGraph)SelectionHistoryTreePanel.access$500(this.this$0)).selectNode((CombinedDiffNode)var8, !var9);
               }

               SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)SelectionHistoryTreePanel.access$700(this.this$0));
            }

            SelectionHistoryTreePanel.access$500(this.this$0).getPrimaryGraph().getSelectionHistory().setEnabled(true);
            SelectionHistoryTreePanel.access$500(this.this$0).getSecondaryGraph().getSelectionHistory().setEnabled(true);
            SelectionHistoryTreePanel.access$500(this.this$0).getCombinedGraph().getSelectionHistory().setEnabled(true);
         }

      }
   }

   // $FF: synthetic method
   SelectionHistoryTreePanel$InternalTreeMouseListener(SelectionHistoryTreePanel var1, SelectionHistoryTreePanel$1 var2) {
      this(var1);
   }
}
