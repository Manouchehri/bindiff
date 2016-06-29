package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.*;
import java.awt.*;

public class CombinedViewPanel extends JPanel
{
    private final ViewTabPanelFunctions controller;
    private final GraphPanel combinedGraphPanel;
    
    public CombinedViewPanel(final Diff diff, final ViewTabPanelFunctions controller, final ViewData viewData) {
        super(new BorderLayout());
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(controller);
        Preconditions.checkNotNull(viewData);
        this.controller = controller;
        this.add(this.combinedGraphPanel = new CombinedGraphPanel(controller, diff, viewData, EGraph.COMBINED_GRAPH), "Center");
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
