package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.*;

public class SuperGraphPanel extends GraphPanel
{
    public SuperGraphPanel(final ViewTabPanelFunctions viewTabPanelFunctions, final ViewData viewData, final EGraph eGraph) {
        super(viewTabPanelFunctions, viewData.getGraphs().getDiff(), viewData, viewData.getGraphs().getSuperGraph(), eGraph);
    }
    
    @Override
    public SuperGraph getGraph() {
        return (SuperGraph)super.getGraph();
    }
}
