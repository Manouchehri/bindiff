package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.CombinedGraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class CombinedViewPanel extends JPanel {
   private final ViewTabPanelFunctions controller;
   private final GraphPanel combinedGraphPanel;

   public CombinedViewPanel(Diff var1, ViewTabPanelFunctions var2, ViewData var3) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      this.controller = var2;
      this.combinedGraphPanel = new CombinedGraphPanel(var2, var1, var3, EGraph.COMBINED_GRAPH);
      this.add(this.combinedGraphPanel, "Center");
   }

   public void dispose() {
      this.combinedGraphPanel.dispose();
   }

   public ViewTabPanelFunctions getController() {
      return this.controller;
   }

   public GraphPanel getGraphPanel() {
      return this.combinedGraphPanel;
   }

   public void resetDefaultPerspective() {
      this.combinedGraphPanel.resetDefaultPerspective();
   }

   public void toggleGraphsPerspective() {
      this.combinedGraphPanel.toggleGraphsPerspective();
   }
}
