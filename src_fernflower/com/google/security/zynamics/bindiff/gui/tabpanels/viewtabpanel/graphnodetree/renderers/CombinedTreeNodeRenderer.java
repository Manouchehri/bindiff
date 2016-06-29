package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.CombinedTreeNodeRenderer$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CombinedTreeNodeRenderer extends DefaultTreeCellRenderer {
   private static final Font NORMAL_FONT;
   private static final Font BOLD_FONT;

   public CombinedTreeNodeRenderer() {
      this.setBackgroundSelectionColor(Color.WHITE);
      this.setBorderSelectionColor(Color.GRAY);
   }

   private static EFunctionType getFunctionType(RawCombinedFunction var0) {
      RawFunction var1 = var0.getRawNode(ESide.PRIMARY);
      RawFunction var2 = var0.getRawNode(ESide.SECONDARY);
      return getFunctionType(var1, var2);
   }

   private static EFunctionType getFunctionType(RawFunction var0, RawFunction var1) {
      if(var0 != null && var1 != null && var0.getFunctionType() != var1.getFunctionType()) {
         return EFunctionType.MIXED;
      } else {
         RawFunction var2 = var0;
         if(var0 == null) {
            var2 = var1;
         }

         return var2.getFunctionType();
      }
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
      if(var8 instanceof CombinedCallGraphFunctionTreeNode) {
         CombinedCallGraphFunctionTreeNode var12 = (CombinedCallGraphFunctionTreeNode)var8;
         var11 = getFunctionType(var12.getCombinedFunction());
      } else if(var8 instanceof CombinedFlowGraphBaseTreeNode) {
         CombinedFlowGraphBaseTreeNode var17 = (CombinedFlowGraphBaseTreeNode)var8;
         CombinedFlowGraphRootTreeNode var13 = var17.getRootNode();
         FlowGraphViewData var14 = var13.getView();
         EFunctionType var15 = null;
         EFunctionType var16 = null;
         if(var14.getRawGraph(ESide.PRIMARY) != null) {
            var15 = var14.getRawGraph(ESide.PRIMARY).getFunctionType();
         }

         if(var14.getRawGraph(ESide.SECONDARY) != null) {
            var16 = var14.getRawGraph(ESide.SECONDARY).getFunctionType();
         }

         var11 = var15 == var16?var15:EFunctionType.MIXED;
      }

      if(var11 != null) {
         switch(CombinedTreeNodeRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[var11.ordinal()]) {
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
            break;
         case 6:
            var10 = Colors.TABLE_CELL_CHANGED_BACKGROUND;
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
