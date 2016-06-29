package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public class CombinedGraphPanel extends GraphPanel {
   public CombinedGraphPanel(ViewTabPanelFunctions var1, Diff var2, ViewData var3, EGraph var4) {
      super(var1, var2, var3, var3.getGraphs().getCombinedGraph(), var4);
   }

   public CombinedGraph getGraph() {
      return (CombinedGraph)super.getGraph();
   }
}
