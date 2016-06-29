package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.AddNodeMatchAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CopyBasicBlockAddressAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.DeleteNodeMatchAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ZoomToNodeAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class FlowGraphPopupMenu extends JPopupMenu {
   public FlowGraphPopupMenu(ViewTabPanelFunctions var1, BinDiffGraph var2, ZyGraphNode var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("Graph argument cannot be null");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Node argument cannot be null");
      } else {
         JMenuItem var4 = new JMenuItem(new AddNodeMatchAction(var1, var2, var3));
         JMenuItem var5 = new JMenuItem(new DeleteNodeMatchAction(var1, var2, var3));
         JMenuItem var6 = new JMenuItem(new ZoomToNodeAction(var2, var3));
         var4.setEnabled(ViewTabPanelFunctions.isNodeSelectionMatchAddable(var2, var3));
         var5.setEnabled(ViewTabPanelFunctions.isNodeSelectionMatchDeleteable(var2, var3));
         this.add(var4);
         this.add(var5);
         this.add(new JSeparator());
         this.add(var6);
         this.add(new JSeparator());
         if(var3 instanceof CombinedDiffNode) {
            CombinedDiffNode var7 = (CombinedDiffNode)var3;
            JMenuItem var8;
            if(var7.getPrimaryDiffNode() != null) {
               var8 = new JMenuItem(new CopyBasicBlockAddressAction(var7, ESide.PRIMARY));
               this.add(var8);
            }

            if(var7.getSecondaryDiffNode() != null) {
               var8 = new JMenuItem(new CopyBasicBlockAddressAction(var7, ESide.SECONDARY));
               this.add(var8);
            }
         } else if(var3 instanceof SingleDiffNode) {
            JMenuItem var9 = new JMenuItem(new CopyBasicBlockAddressAction((SingleDiffNode)var3));
            this.add(var9);
         }

      }
   }
}
