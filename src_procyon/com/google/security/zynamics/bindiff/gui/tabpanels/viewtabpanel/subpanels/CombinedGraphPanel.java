package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.*;

public class CombinedGraphPanel extends GraphPanel
{
    public CombinedGraphPanel(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final EGraph eGraph) {
        super(viewTabPanelFunctions, diff, viewData, viewData.getGraphs().getCombinedGraph(), eGraph);
    }
    
    @Override
    public CombinedGraph getGraph() {
        return (CombinedGraph)super.getGraph();
    }
}
