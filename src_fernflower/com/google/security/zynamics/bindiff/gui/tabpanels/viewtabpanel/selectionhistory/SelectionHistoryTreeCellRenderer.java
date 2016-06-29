package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class SelectionHistoryTreeCellRenderer extends DefaultTreeCellRenderer {
   private static final Color NORMAL_FONT_COLOR = new Color(0, 0, 0);
   private static final Color INVISIBLE_FONT_COLOR = new Color(128, 128, 128);
   private static final Color SELECTED_FONT_COLOR = new Color(160, 0, 0);
   private static final Color MIXED_STATE_GROUP_NODE_COLOR = new Color(160, 120, 120);
   private final AbstractZyGraph graph;

   public SelectionHistoryTreeCellRenderer(AbstractZyGraph var1) {
      this.graph = (AbstractZyGraph)Preconditions.checkNotNull(var1);
   }

   public Component getTreeCellRendererComponent(JTree var1, Object var2, boolean var3, boolean var4, boolean var5, int var6, boolean var7) {
      this.setBackgroundSelectionColor(Color.WHITE);
      this.setBorderSelectionColor(Color.WHITE);
      super.getTreeCellRendererComponent(var1, var2, var3, var4, var5, var6, var7);
      Icon var8 = ((AbstractSelectionHistoryTreeNode)var2).getIcon();
      if(var8 != null) {
         this.setIcon(var8);
      }

      List var9 = GraphNodeFilter.filterNodes(this.graph, GraphNodeFilter$Criterium.SELECTED_VISIBLE);
      List var10 = GraphNodeFilter.filterNodes(this.graph, GraphNodeFilter$Criterium.INVISIBLE);
      this.setForeground(NORMAL_FONT_COLOR);
      if(var2 instanceof SelectionHistoryTreeGroupNode) {
         SelectionHistoryTreeGroupNode var11 = (SelectionHistoryTreeGroupNode)var2;
         if(!var11.isRoot()) {
            int var12 = 0;
            int var13 = 0;
            int var14 = 0;
            int var15 = 0;
            Collection var16 = var11.getSnapshot().getSelection();
            Iterator var17 = var16.iterator();

            while(var17.hasNext()) {
               ZyGraphNode var18 = (ZyGraphNode)var17.next();
               ++var12;
               if(var18.isVisible()) {
                  if(var18.isSelected()) {
                     ++var13;
                  } else {
                     ++var14;
                  }
               } else {
                  ++var15;
               }
            }

            if(var12 == var13) {
               this.setForeground(SELECTED_FONT_COLOR);
            } else if(var12 == var14) {
               this.setForeground(NORMAL_FONT_COLOR);
            } else if(var12 == var15) {
               this.setForeground(INVISIBLE_FONT_COLOR);
            } else {
               this.setForeground(MIXED_STATE_GROUP_NODE_COLOR);
            }
         }
      } else if(var2 instanceof SelectionHistoryTreeNode) {
         SelectionHistoryTreeNode var19 = (SelectionHistoryTreeNode)var2;
         ZyGraphNode var20 = var19.getNode();
         if(var9.contains(var20)) {
            this.setForeground(SELECTED_FONT_COLOR);
         } else if(var10.contains(var20)) {
            this.setForeground(INVISIBLE_FONT_COLOR);
         }
      }

      return this;
   }
}
