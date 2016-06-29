package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public class NormalGraphPanel extends GraphPanel {
   public NormalGraphPanel(ViewTabPanelFunctions var1, Diff var2, ViewData var3, ESide var4) {
      super(var1, var2, var3, getSingleGraph(var3.getGraphs(), var4), getGraphType(var4));
   }

   private static EGraph getGraphType(ESide var0) {
      return var0 == ESide.PRIMARY?EGraph.PRIMARY_GRAPH:EGraph.SECONDARY_GRAPH;
   }

   private static BinDiffGraph getSingleGraph(GraphsContainer var0, ESide var1) {
      if(var1 == ESide.PRIMARY) {
         return var0.getPrimaryGraph();
      } else if(var1 == ESide.SECONDARY) {
         return var0.getSecondaryGraph();
      } else {
         throw new IllegalArgumentException("Illegal graph type.");
      }
   }
}
