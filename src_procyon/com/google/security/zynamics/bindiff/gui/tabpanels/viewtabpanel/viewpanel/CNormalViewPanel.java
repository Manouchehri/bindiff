package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.border.*;
import java.awt.*;

public class CNormalViewPanel extends JPanel
{
    private static final double DEFAULT_DIVIDER_LOCATION = 0.5;
    private final JSplitPane mainSplitter;
    private final NormalGraphPanel primaryPanel;
    private final NormalGraphPanel secondaryPanel;
    private final ViewTabPanelFunctions controller;
    
    public CNormalViewPanel(final Diff diff, final ViewTabPanelFunctions viewTabPanelFunctions, final ViewData viewData) {
        super(new BorderLayout());
        this.mainSplitter = new JSplitPane(1);
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(viewData);
        this.primaryPanel = new NormalGraphPanel(viewTabPanelFunctions, diff, viewData, ESide.PRIMARY);
        this.secondaryPanel = new NormalGraphPanel(viewTabPanelFunctions, diff, viewData, ESide.SECONDARY);
        this.initPanel(viewData);
        this.showSupergraph(viewData);
    }
    
    private void initPanel(final ViewData viewData) {
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
        this.add(this.mainSplitter, "Center");
        if (viewData.isFlowgraphView()) {
            if (viewData.getAddress(ESide.PRIMARY) == null) {
                this.mainSplitter.setDividerLocation(0.0);
            }
            else if (viewData.getAddress(ESide.SECONDARY) == null) {
                this.mainSplitter.setDividerLocation(4192);
            }
        }
    }
    
    private void showSupergraph(final ViewData viewData) {
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
        if (this.mainSplitter.getRightComponent().getSize().width == 0.0) {
            this.resetDefaultPerspective();
        }
        else {
            this.primaryPanel.setMainDividerLocationAndResizeWeight(0.2);
            this.mainSplitter.setDividerLocation(1.0);
        }
    }
    
    public void toggleSecondaryPerspective() {
        if (this.mainSplitter.getDividerLocation() != 0) {
            this.secondaryPanel.setMainDividerLocationAndResizeWeight(0.8);
            this.mainSplitter.setDividerLocation(0.0);
        }
        else {
            this.resetDefaultPerspective();
        }
    }
}
