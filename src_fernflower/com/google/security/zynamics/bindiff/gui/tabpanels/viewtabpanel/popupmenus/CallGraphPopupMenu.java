package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.OpenFlowGraphsViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CopyFunctionAddressAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CopyFunctionNameAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ZoomToNodeAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class CallGraphPopupMenu extends JPopupMenu {
   public CallGraphPopupMenu(ViewTabPanelFunctions var1, BinDiffGraph var2, ZyGraphNode var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      JMenuItem var4 = new JMenuItem(new OpenFlowGraphsViewAction(var1, var3));
      JMenuItem var5 = new JMenuItem(new ZoomToNodeAction(var2, var3));
      this.add(var4);
      this.add(new JSeparator());
      this.add(var5);
      this.add(new JSeparator());
      JMenuItem var7;
      if(var3 instanceof CombinedDiffNode) {
         CombinedDiffNode var6 = (CombinedDiffNode)var3;
         JMenuItem var8;
         if(var6.getPrimaryDiffNode() != null) {
            var7 = new JMenuItem(new CopyFunctionAddressAction(var6, ESide.PRIMARY));
            var8 = new JMenuItem(new CopyFunctionNameAction(var6, ESide.PRIMARY));
            this.add(var7);
            this.add(var8);
         }

         if(var6.getSecondaryDiffNode() != null) {
            var7 = new JMenuItem(new CopyFunctionAddressAction(var6, ESide.SECONDARY));
            var8 = new JMenuItem(new CopyFunctionNameAction(var6, ESide.SECONDARY));
            this.add(var7);
            this.add(var8);
         }
      } else if(var3 instanceof SingleDiffNode) {
         JMenuItem var9 = new JMenuItem(new CopyFunctionAddressAction((SingleDiffNode)var3));
         var7 = new JMenuItem(new CopyFunctionNameAction((SingleDiffNode)var3));
         this.add(var9);
         this.add(var7);
      }

   }
}
