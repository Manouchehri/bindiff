/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.NormalGraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CNormalViewPanel
extends JPanel {
    private static final double DEFAULT_DIVIDER_LOCATION = 0.5;
    private final JSplitPane mainSplitter = new JSplitPane(1);
    private final NormalGraphPanel primaryPanel;
    private final NormalGraphPanel secondaryPanel;
    private final ViewTabPanelFunctions controller;

    public CNormalViewPanel(Diff diff, ViewTabPanelFunctions viewTabPanelFunctions, ViewData viewData) {
        super(new BorderLayout());
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(viewData);
        this.primaryPanel = new NormalGraphPanel(viewTabPanelFunctions, diff, viewData, ESide.PRIMARY);
        this.secondaryPanel = new NormalGraphPanel(viewTabPanelFunctions, diff, viewData, ESide.SECONDARY);
        this.initPanel(viewData);
        this.showSupergraph(viewData);
    }

    private void initPanel(ViewData viewData) {
        this.mainSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.mainSplitter.setLeftComponent(this.primaryPanel);
        this.mainSplitter.setRightComponent(this.secondaryPanel);
        this.mainSplitter.setMinimumSize(new Dimension(0, 0));
        this.mainSplitter.setOneTouchExpandable(true);
        this.mainSplitter.setDoubleBuffered(true);
        this.mainSplitter.setContinuousLayout(true);
        this.mainSplitter.setResizeWeight(0.5);
        this.mainSplitter.setDividerLocation(0.5);
        this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
        this.add((Component)this.mainSplitter, "Center");
        if (!viewData.isFlowgraphView()) return;
        if (viewData.getAddress(ESide.PRIMARY) == null) {
            this.mainSplitter.setDividerLocation(0.0);
            return;
        }
        if (viewData.getAddress(ESide.SECONDARY) != null) return;
        this.mainSplitter.setDividerLocation(4192);
    }

    private void showSupergraph(ViewData viewData) {
    }

    public void dispose() {
        this.primaryPanel.dispose();
        this.secondaryPanel.dispose();
    }

    public ViewTabPanelFunctions getController() {
        return this.controller;
    }

    public NormalGraphPanel getPrimaryPanel() {
        return this.primaryPanel;
    }

    public NormalGraphPanel getSecondaryPanel() {
        return this.secondaryPanel;
    }

    public void resetDefaultPerspective() {
        this.primaryPanel.resetDefaultPerspective();
        this.secondaryPanel.resetDefaultPerspective();
        this.mainSplitter.setResizeWeight(0.5);
        this.mainSplitter.setDividerLocation(0.5);
    }

    public void toggleGraphsPerspective() {
        this.primaryPanel.toggleGraphsPerspective();
        this.secondaryPanel.toggleGraphsPerspective();
    }

    public void togglePrimaryPerspective() {
        if ((double)this.mainSplitter.getRightComponent().getSize().width == 0.0) {
            this.resetDefaultPerspective();
            return;
        }
        this.primaryPanel.setMainDividerLocationAndResizeWeight(0.2);
        this.mainSplitter.setDividerLocation(1.0);
    }

    public void toggleSecondaryPerspective() {
        if (this.mainSplitter.getDividerLocation() != 0) {
            this.secondaryPanel.setMainDividerLocationAndResizeWeight(0.8);
            this.mainSplitter.setDividerLocation(0.0);
            return;
        }
        this.resetDefaultPerspective();
    }
}

