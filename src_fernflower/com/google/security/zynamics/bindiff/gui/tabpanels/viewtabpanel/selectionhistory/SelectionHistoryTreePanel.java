package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalGraphSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalGraphVisibilityListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalSelectionHistoryListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalTreeMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalTreeSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.BorderLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

public class SelectionHistoryTreePanel extends JPanel {
   private SelectionHistoryTree tree;
   private DefaultTreeModel model;
   private final SelectionHistoryTreePanel$InternalGraphSelectionListener graphSelectionListener = new SelectionHistoryTreePanel$InternalGraphSelectionListener(this, (SelectionHistoryTreePanel$1)null);
   private final SelectionHistoryTreePanel$InternalGraphVisibilityListener graphVisibilityListener = new SelectionHistoryTreePanel$InternalGraphVisibilityListener(this, (SelectionHistoryTreePanel$1)null);
   private final SelectionHistoryTreePanel$InternalSelectionHistoryListener selectionHistoryListener = new SelectionHistoryTreePanel$InternalSelectionHistoryListener(this, (SelectionHistoryTreePanel$1)null);
   private final SelectionHistoryTreePanel$InternalTreeSelectionListener treeSelectionListener = new SelectionHistoryTreePanel$InternalTreeSelectionListener(this, (SelectionHistoryTreePanel$1)null);
   private final SelectionHistoryTreePanel$InternalTreeMouseListener treeMouseListener = new SelectionHistoryTreePanel$InternalTreeMouseListener(this, (SelectionHistoryTreePanel$1)null);
   private int childCount = 0;
   private BinDiffGraph graph;
   private final SelectionHistory selectionHistory;

   public SelectionHistoryTreePanel(ViewTabPanelFunctions var1, BinDiffGraph var2, SelectionHistory var3) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      this.graph = (BinDiffGraph)Preconditions.checkNotNull(var2);
      this.selectionHistory = (SelectionHistory)Preconditions.checkNotNull(var3);
      this.tree = this.createTree(var1);
      this.createPanel();
      this.selectionHistory.addHistoryListener(this.selectionHistoryListener);
      var2.getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
      var2.getIntermediateListeners().addIntermediateListener((IZyGraphVisibilityListener)this.graphVisibilityListener);
      this.tree.addTreeSelectionListener(this.treeSelectionListener);
      this.tree.addMouseListener(this.treeMouseListener);
      ToolTipManager.sharedInstance().registerComponent(this.tree);
   }

   private void createPanel() {
      this.tree.setRootVisible(true);
      this.tree.setSelectionModel((TreeSelectionModel)null);
      this.add(new JScrollPane(this.tree), "Center");
   }

   private SelectionHistoryTree createTree(ViewTabPanelFunctions var1) {
      SelectionHistoryRootNode var2 = new SelectionHistoryRootNode(var1, this.graph, "Selection History");
      SelectionHistoryTree var3 = new SelectionHistoryTree(var2);
      var2.setTree(var3);
      this.model = new DefaultTreeModel(var2);
      this.model.nodeStructureChanged(var2);
      var3.setRootVisible(true);
      var3.getSelectionModel().setSelectionMode(1);
      return var3;
   }

   private void insertSnapshot(SelectionSnapshot var1) {
      SelectionHistoryTreeGroupNode var2 = new SelectionHistoryTreeGroupNode(var1, this.childCount);
      Iterator var3 = var1.getSelection().iterator();

      while(var3.hasNext()) {
         ZyGraphNode var4 = (ZyGraphNode)var3.next();
         SelectionHistoryTreeNode var5 = new SelectionHistoryTreeNode(var4);
         var2.add(var5);
      }

      ++this.childCount;
      this.model.insertNodeInto(var2, (SelectionHistoryRootNode)this.model.getRoot(), 0);
   }

   private void selectCombinedNodes(Collection var1) {
      this.graph.getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
      if(this.graph instanceof CombinedGraph) {
         List var2 = GraphNodeFilter.filterNodes((AbstractZyGraph)((CombinedGraph)this.graph), GraphNodeFilter$Criterium.SELECTED);
         ((CombinedGraph)this.graph).selectNodes(var2, false);
         ((CombinedGraph)this.graph).selectNodes(var1, true);
      }

      this.graph.getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
   }

   private void selectSingleNodes(Collection var1) {
      this.graph.getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
      if(this.graph instanceof SingleGraph) {
         List var2 = GraphNodeFilter.filterNodes((AbstractZyGraph)((SingleGraph)this.graph), GraphNodeFilter$Criterium.SELECTED);
         ((SingleGraph)this.graph).selectNodes(var2, false);
         ((SingleGraph)this.graph).selectNodes(var1, true);
      }

      this.graph.getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
   }

   private void unselectCombinedNodes(Collection var1) {
      this.graph.getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
      if(this.graph instanceof CombinedGraph) {
         ((CombinedGraph)this.graph).selectNodes(var1, false);
      }

      this.graph.getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
   }

   private void unselectSingleNodes(Collection var1) {
      this.graph.getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
      if(this.graph instanceof SingleGraph) {
         ((SingleGraph)this.graph).selectNodes(var1, false);
      }

      this.graph.getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
   }

   public void dispose() {
      this.selectionHistory.removeHistoryListener(this.selectionHistoryListener);
      this.graph.getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
      this.graph.getIntermediateListeners().removeIntermediateListener((IZyGraphVisibilityListener)this.graphVisibilityListener);
      this.tree.removeMouseListener(this.treeMouseListener);
      this.tree.removeTreeSelectionListener(this.treeSelectionListener);
      this.tree.setSelectionModel(new DefaultTreeSelectionModel());
      this.tree.setCellRenderer((TreeCellRenderer)null);
      this.tree.dispose();
      this.tree = null;
      this.graph = null;
   }

   public int getChildCount() {
      return this.childCount;
   }

   // $FF: synthetic method
   static BinDiffGraph access$500(SelectionHistoryTreePanel var0) {
      return var0.graph;
   }

   // $FF: synthetic method
   static SelectionHistory access$600(SelectionHistoryTreePanel var0) {
      return var0.selectionHistory;
   }

   // $FF: synthetic method
   static SelectionHistoryTreePanel$InternalGraphSelectionListener access$700(SelectionHistoryTreePanel var0) {
      return var0.graphSelectionListener;
   }

   // $FF: synthetic method
   static SelectionHistoryTree access$800(SelectionHistoryTreePanel var0) {
      return var0.tree;
   }

   // $FF: synthetic method
   static void access$900(SelectionHistoryTreePanel var0, SelectionSnapshot var1) {
      var0.insertSnapshot(var1);
   }

   // $FF: synthetic method
   static DefaultTreeModel access$1000(SelectionHistoryTreePanel var0) {
      return var0.model;
   }

   // $FF: synthetic method
   static void access$1100(SelectionHistoryTreePanel var0, Collection var1) {
      var0.unselectSingleNodes(var1);
   }

   // $FF: synthetic method
   static void access$1200(SelectionHistoryTreePanel var0, Collection var1) {
      var0.selectSingleNodes(var1);
   }

   // $FF: synthetic method
   static void access$1300(SelectionHistoryTreePanel var0, Collection var1) {
      var0.unselectCombinedNodes(var1);
   }

   // $FF: synthetic method
   static void access$1400(SelectionHistoryTreePanel var0, Collection var1) {
      var0.selectCombinedNodes(var1);
   }
}
