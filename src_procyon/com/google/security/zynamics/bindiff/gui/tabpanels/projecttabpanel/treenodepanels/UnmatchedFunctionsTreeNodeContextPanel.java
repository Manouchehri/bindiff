package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;

public class UnmatchedFunctionsTreeNodeContextPanel extends AbstractTreeNodeContextPanel
{
    private final ESide side;
    private final UnmatchedFunctionViewsPanel primaryUnmatchedFunctionViewPanel;
    private final UnmatchedFunctionViewsPanel secondaryUnmatchedFunctionViewPanel;
    
    public UnmatchedFunctionsTreeNodeContextPanel(final Diff diff, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final ESide side) {
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(workspaceTabPanelFunctions);
        Preconditions.checkNotNull(side);
        this.side = side;
        this.primaryUnmatchedFunctionViewPanel = new UnmatchedFunctionViewsPanel(diff, workspaceTabPanelFunctions, ESide.PRIMARY);
        this.secondaryUnmatchedFunctionViewPanel = new UnmatchedFunctionViewsPanel(diff, workspaceTabPanelFunctions, ESide.SECONDARY);
        this.init();
    }
    
    private void init() {
        final JSplitPane splitPane = new JSplitPane(0, true);
        splitPane.setBorder(null);
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(1.0);
        splitPane.setDividerLocation(0.2);
        splitPane.setTopComponent((this.side == ESide.PRIMARY) ? this.primaryUnmatchedFunctionViewPanel : this.secondaryUnmatchedFunctionViewPanel);
        splitPane.setBottomComponent((this.side == ESide.PRIMARY) ? this.secondaryUnmatchedFunctionViewPanel : this.primaryUnmatchedFunctionViewPanel);
        this.add(splitPane, "Center");
    }
    
    @Override
    public List getTables() {
        return (this.side == ESide.PRIMARY) ? this.primaryUnmatchedFunctionViewPanel.getTables() : this.secondaryUnmatchedFunctionViewPanel.getTables();
    }
}
