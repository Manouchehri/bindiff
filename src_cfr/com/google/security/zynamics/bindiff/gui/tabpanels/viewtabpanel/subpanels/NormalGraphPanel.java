/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public class NormalGraphPanel
extends GraphPanel {
    public NormalGraphPanel(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, ESide eSide) {
        super(viewTabPanelFunctions, diff, viewData, NormalGraphPanel.getSingleGraph(viewData.getGraphs(), eSide), NormalGraphPanel.getGraphType(eSide));
    }

    private static EGraph getGraphType(ESide eSide) {
        EGraph eGraph;
        if (eSide == ESide.PRIMARY) {
            eGraph = EGraph.PRIMARY_GRAPH;
            return eGraph;
        }
        eGraph = EGraph.SECONDARY_GRAPH;
        return eGraph;
    }

    private static BinDiffGraph getSingleGraph(GraphsContainer graphsContainer, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            return graphsContainer.getPrimaryGraph();
        }
        if (eSide != ESide.SECONDARY) throw new IllegalArgumentException("Illegal graph type.");
        return graphsContainer.getSecondaryGraph();
    }
}

