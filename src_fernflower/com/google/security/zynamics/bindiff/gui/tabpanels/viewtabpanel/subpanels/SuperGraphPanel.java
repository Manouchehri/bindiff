package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public class SuperGraphPanel extends GraphPanel {
   public SuperGraphPanel(ViewTabPanelFunctions var1, ViewData var2, EGraph var3) {
      super(var1, var2.getGraphs().getDiff(), var2, var2.getGraphs().getSuperGraph(), var3);
   }

   public SuperGraph getGraph() {
      return (SuperGraph)super.getGraph();
   }
}
