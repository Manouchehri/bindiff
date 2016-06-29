package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JTree;

public class SelectionHistoryRootNode extends AbstractSelectionHistoryTreeNode {
   private static final Icon ICON_ROOT = ImageUtils.getImageIcon("data/selectionicons/root.png");
   private final ViewTabPanelFunctions controller;
   private JTree tree;
   private final BinDiffGraph graph;

   public SelectionHistoryRootNode(ViewTabPanelFunctions var1, BinDiffGraph var2, String var3) {
      super(var3);
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.graph = (BinDiffGraph)Preconditions.checkNotNull(var2);
   }

   public ViewTabPanelFunctions getController() {
      return this.controller;
   }

   public BinDiffGraph getGraph() {
      return this.graph;
   }

   public Icon getIcon() {
      return ICON_ROOT;
   }

   public JPopupMenu getPopupMenu() {
      return null;
   }

   public JTree getTree() {
      return this.tree;
   }

   public void setTree(JTree var1) {
      this.tree = var1;
   }
}
