package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public class SelectionHistoryTreeNode extends AbstractSelectionHistoryTreeNode {
   private static final ImageIcon ICON_SELECTED_GRAPHNODE = ImageUtils.getImageIcon("data/selectionicons/graphnode-selection.png");
   private static final ImageIcon ICON_NO_SELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/no-selected-graphnodes.png");
   private static final ImageIcon ICON_NO_SELECTED_GRAPHNODES_GRAY = ImageUtils.getImageIcon("data/selectionicons/no-selected-graphnodes-gray.png");
   private final ZyGraphNode node;

   public SelectionHistoryTreeNode(ZyGraphNode var1) {
      super(getNodeName(var1));
      this.node = var1;
   }

   private static String getCombinedNodeName(CombinedDiffNode var0) {
      // $FF: Couldn't be decompiled
   }

   private static String getNodeName(ZyGraphNode var0) {
      // $FF: Couldn't be decompiled
   }

   private static String getSingleNodeName(SingleViewNode var0) {
      String var1 = "";
      String var2;
      String var3;
      if(var0 instanceof RawFunction) {
         var2 = String.valueOf(var1);
         var3 = String.valueOf(var0.getAddress());
         String var4 = ((RawFunction)var0).getName();
         var1 = (new StringBuilder(1 + String.valueOf(var2).length() + String.valueOf(var3).length() + String.valueOf(var4).length())).append(var2).append(var3).append(" ").append(var4).toString();
      } else if(var0 instanceof RawBasicBlock) {
         var2 = String.valueOf(var1);
         var3 = String.valueOf(var0.getAddress());
         var1 = (new StringBuilder(0 + String.valueOf(var2).length() + String.valueOf(var3).length())).append(var2).append(var3).toString();
      }

      return var1;
   }

   public ImageIcon getIcon() {
      return !this.node.isVisible()?ICON_NO_SELECTED_GRAPHNODES_GRAY:(this.node.isSelected()?ICON_SELECTED_GRAPHNODE:ICON_NO_SELECTED_GRAPHNODES);
   }

   public ZyGraphNode getNode() {
      return this.node;
   }

   public JPopupMenu getPopupMenu() {
      SelectionHistoryRootNode var1 = this.getRootNode();
      BinDiffGraph var2 = var1.getGraph();
      return (JPopupMenu)(var2.getGraphType() == EGraphType.CALLGRAPH?new CallGraphPopupMenu(this.getRootNode().getController(), var2, this.node):(var2.getGraphType() == EGraphType.FLOWGRAPH?new FlowGraphPopupMenu(this.getRootNode().getController(), var2, this.node):null));
   }
}
