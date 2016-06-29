package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.*;

public class NormalGraphPanel extends GraphPanel
{
    public NormalGraphPanel(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final ESide eSide) {
        super(viewTabPanelFunctions, diff, viewData, getSingleGraph(viewData.getGraphs(), eSide), getGraphType(eSide));
    }
    
    private static EGraph getGraphType(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? EGraph.PRIMARY_GRAPH : EGraph.SECONDARY_GRAPH;
    }
    
    private static BinDiffGraph getSingleGraph(final GraphsContainer graphsContainer, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            return graphsContainer.getPrimaryGraph();
        }
        if (eSide == ESide.SECONDARY) {
            return graphsContainer.getSecondaryGraph();
        }
        throw new IllegalArgumentException("Illegal graph type.");
    }
}
