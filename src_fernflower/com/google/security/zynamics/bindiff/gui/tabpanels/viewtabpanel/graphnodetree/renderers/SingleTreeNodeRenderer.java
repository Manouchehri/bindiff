package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.SingleTreeNodeRenderer$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class SingleTreeNodeRenderer extends DefaultTreeCellRenderer {
   private static final Font NORMAL_FONT;
   private static final Font BOLD_FONT;

   public SingleTreeNodeRenderer() {
      this.setBackgroundSelectionColor(Color.WHITE);
      this.setBorderSelectionColor(Color.GRAY);
   }

   public Component getTreeCellRendererComponent(JTree var1, Object var2, boolean var3, boolean var4, boolean var5, int var6, boolean var7) {
      super.getTreeCellRendererComponent(var1, var2, var3, var4, var5, var6, var7);
      AbstractTreeNode var8 = (AbstractTreeNode)var2;
      Icon var9 = var8.getIcon();
      if(var9 != null) {
         this.setIcon(var9);
      }

      this.setFont(var8.isSelected()?BOLD_FONT:NORMAL_FONT);
      this.setForeground(var8.isVisible()?Color.BLACK:Color.GRAY);
      Color var10 = Color.WHITE;
      EFunctionType var11 = null;
      if(var8 instanceof SingleCallGraphFunctionTreeNode) {
         SingleCallGraphFunctionTreeNode var12 = (SingleCallGraphFunctionTreeNode)var8;
         var11 = var12.getFunction().getFunctionType();
      } else if(var8 instanceof SingleFlowGraphBaseTreeNode) {
         FlowGraphViewData var15 = (FlowGraphViewData)var8.getRootNode().getView();
         ESide var13 = var8.getRootNode().getSide();
         RawFlowGraph var14 = var15.getRawGraph(var13);
         var11 = var14.getFunctionType();
      }

      if(var11 != null) {
         switch(SingleTreeNodeRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[var11.ordinal()]) {
         case 1:
            var10 = Colors.FUNCTION_TYPE_NORMAL;
            break;
         case 2:
            var10 = Colors.FUNCTION_TYPE_IMPORTED;
            break;
         case 3:
            var10 = Colors.FUNCTION_TYPE_LIBRARY;
            break;
         case 4:
            var10 = Colors.FUNCTION_TYPE_THUNK;
            break;
         case 5:
            var10 = Colors.FUNCTION_TYPE_UNKNOWN;
         }
      }

      this.setBackgroundSelectionColor(var10);
      this.setBackgroundNonSelectionColor(var10);
      this.setBorderSelectionColor(var10);
      this.setToolTipText(var8.getTooltipText());
      return this;
   }

   static {
      NORMAL_FONT = GuiHelper.DEFAULT_FONT;
      BOLD_FONT = new Font(NORMAL_FONT.getName(), 1, NORMAL_FONT.getSize());
   }
}
