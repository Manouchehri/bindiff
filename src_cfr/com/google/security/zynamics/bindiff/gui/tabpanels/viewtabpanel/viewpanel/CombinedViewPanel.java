/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.CombinedGraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class CombinedViewPanel
extends JPanel {
    private final ViewTabPanelFunctions controller;
    private final GraphPanel combinedGraphPanel;

    public CombinedViewPanel(Diff diff, ViewTabPanelFunctions viewTabPanelFunctions, ViewData viewData) {
        super(new BorderLayout());
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(viewData);
        this.controller = viewTabPanelFunctions;
        this.combinedGraphPanel = new CombinedGraphPanel(viewTabPanelFunctions, diff, viewData, EGraph.COMBINED_GRAPH);
        this.add((Component)this.combinedGraphPanel, "Center");
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

