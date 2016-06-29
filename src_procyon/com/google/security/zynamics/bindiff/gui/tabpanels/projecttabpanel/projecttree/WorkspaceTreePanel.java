package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class WorkspaceTreePanel extends JPanel
{
    private final WorkspaceTree workspaceTree;
    
    public WorkspaceTreePanel(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(new BorderLayout());
        Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.workspaceTree = new WorkspaceTree(workspaceTabPanelFunctions);
        final JScrollPane scrollPane = new JScrollPane(this.workspaceTree);
        scrollPane.setBorder(null);
        this.add(scrollPane, "Center");
    }
    
    public WorkspaceTree getWorkspaceTree() {
        return this.workspaceTree;
    }
}
