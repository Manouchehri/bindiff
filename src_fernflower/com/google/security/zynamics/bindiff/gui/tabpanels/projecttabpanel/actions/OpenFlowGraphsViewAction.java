package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class OpenFlowGraphsViewAction extends AbstractAction {
   private final ViewTabPanelFunctions controller;
   private final ZyGraphNode node;

   public OpenFlowGraphsViewAction(ViewTabPanelFunctions var1, ZyGraphNode var2) {
      super("Open Flow Graphs View");
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.node = (ZyGraphNode)Preconditions.checkNotNull(var2);
   }

   public void actionPerformed(ActionEvent var1) {
      this.controller.openFlowgraphsViews(this.node);
   }
}
