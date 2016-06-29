/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public class SuperGraphPanel
extends GraphPanel {
    public SuperGraphPanel(ViewTabPanelFunctions viewTabPanelFunctions, ViewData viewData, EGraph eGraph) {
        super(viewTabPanelFunctions, viewData.getGraphs().getDiff(), viewData, viewData.getGraphs().getSuperGraph(), eGraph);
    }

    @Override
    public SuperGraph getGraph() {
        return (SuperGraph)super.getGraph();
    }
}

