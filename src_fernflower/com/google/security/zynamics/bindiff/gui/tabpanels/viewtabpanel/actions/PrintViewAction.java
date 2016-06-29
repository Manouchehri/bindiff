package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class PrintViewAction extends AbstractAction {
   private final ViewTabPanelFunctions controller;
   private final BinDiffGraph graph;

   public PrintViewAction(ViewTabPanelFunctions var1, BinDiffGraph var2) {
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.graph = (BinDiffGraph)Preconditions.checkNotNull(var2);
   }

   public void actionPerformed(ActionEvent var1) {
      this.controller.printView(this.graph);
   }
}
