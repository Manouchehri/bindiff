/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public class CombinedGraphPanel
extends GraphPanel {
    public CombinedGraphPanel(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, EGraph eGraph) {
        super(viewTabPanelFunctions, diff, viewData, viewData.getGraphs().getCombinedGraph(), eGraph);
    }

    @Override
    public CombinedGraph getGraph() {
        return (CombinedGraph)super.getGraph();
    }
}

