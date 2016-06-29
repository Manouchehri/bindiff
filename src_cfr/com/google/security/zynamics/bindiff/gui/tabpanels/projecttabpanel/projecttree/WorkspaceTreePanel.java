/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class WorkspaceTreePanel
extends JPanel {
    private final WorkspaceTree workspaceTree;

    public WorkspaceTreePanel(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(new BorderLayout());
        Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.workspaceTree = new WorkspaceTree(workspaceTabPanelFunctions);
        JScrollPane jScrollPane = new JScrollPane(this.workspaceTree);
        jScrollPane.setBorder(null);
        this.add((Component)jScrollPane, "Center");
    }

    public WorkspaceTree getWorkspaceTree() {
        return this.workspaceTree;
    }
}

