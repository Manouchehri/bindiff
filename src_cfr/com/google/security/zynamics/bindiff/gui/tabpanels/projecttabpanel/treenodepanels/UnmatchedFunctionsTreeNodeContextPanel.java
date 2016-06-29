/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.Component;
import java.util.List;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

public class UnmatchedFunctionsTreeNodeContextPanel
extends AbstractTreeNodeContextPanel {
    private final ESide side;
    private final UnmatchedFunctionViewsPanel primaryUnmatchedFunctionViewPanel;
    private final UnmatchedFunctionViewsPanel secondaryUnmatchedFunctionViewPanel;

    public UnmatchedFunctionsTreeNodeContextPanel(Diff diff, WorkspaceTabPanelFunctions workspaceTabPanelFunctions, ESide eSide) {
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(workspaceTabPanelFunctions);
        Preconditions.checkNotNull((Object)eSide);
        this.side = eSide;
        this.primaryUnmatchedFunctionViewPanel = new UnmatchedFunctionViewsPanel(diff, workspaceTabPanelFunctions, ESide.PRIMARY);
        this.secondaryUnmatchedFunctionViewPanel = new UnmatchedFunctionViewsPanel(diff, workspaceTabPanelFunctions, ESide.SECONDARY);
        this.init();
    }

    private void init() {
        JSplitPane jSplitPane = new JSplitPane(0, true);
        jSplitPane.setBorder(null);
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setResizeWeight(1.0);
        jSplitPane.setDividerLocation(0.2);
        jSplitPane.setTopComponent(this.side == ESide.PRIMARY ? this.primaryUnmatchedFunctionViewPanel : this.secondaryUnmatchedFunctionViewPanel);
        jSplitPane.setBottomComponent(this.side == ESide.PRIMARY ? this.secondaryUnmatchedFunctionViewPanel : this.primaryUnmatchedFunctionViewPanel);
        this.add((Component)jSplitPane, "Center");
    }

    @Override
    public List getTables() {
        List list;
        if (this.side == ESide.PRIMARY) {
            list = this.primaryUnmatchedFunctionViewPanel.getTables();
            return list;
        }
        list = this.secondaryUnmatchedFunctionViewPanel.getTables();
        return list;
    }
}

