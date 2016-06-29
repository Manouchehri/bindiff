package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel;

import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import javax.swing.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import com.google.security.zynamics.bindiff.utils.*;

public class WorkspaceTabPanel extends TabPanel
{
    private static final Icon ICON;
    private final WorkspaceMenuBar menuBar;
    private final JSplitPane splitPanel;
    private final JPanel treeNodeContextContainer;
    private final WorkspaceTreePanel workspaceTreePanel;
    private final WorkspaceTabPanelFunctions controller;
    
    public WorkspaceTabPanel(final MainWindow mainWindow, final Workspace workspace) {
        this.splitPanel = new JSplitPane(1, true);
        this.treeNodeContextContainer = new JPanel(new BorderLayout());
        Preconditions.checkNotNull(workspace);
        this.controller = new WorkspaceTabPanelFunctions((MainWindow)Preconditions.checkNotNull(mainWindow), workspace);
        this.workspaceTreePanel = new WorkspaceTreePanel(this.controller);
        mainWindow.setJMenuBar(this.menuBar = new WorkspaceMenuBar(this.controller));
        this.initPanel();
        this.controller.loadDefaultWorkspace();
    }
    
    private void initPanel() {
        this.setBorder(new LineBorder(Color.GRAY));
        this.splitPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.treeNodeContextContainer.add(new DefaultTreeNodeContextPanel());
        this.splitPanel.setOneTouchExpandable(true);
        this.splitPanel.setRightComponent(this.treeNodeContextContainer);
        this.splitPanel.setLeftComponent(this.workspaceTreePanel);
        this.splitPanel.setDividerLocation(BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceTreeDividerPosition());
        this.add(this.splitPanel, "Center");
    }
    
    public WorkspaceTabPanelFunctions getController() {
        return this.controller;
    }
    
    public int getDividerLocation() {
        return this.splitPanel.getDividerLocation();
    }
    
    @Override
    public Icon getIcon() {
        return WorkspaceTabPanel.ICON;
    }
    
    @Override
    public JMenuBar getMenuBar() {
        return this.menuBar;
    }
    
    @Override
    public String getTitle() {
        return "Workspace";
    }
    
    public JPanel getTreeNodeContextContainer() {
        return this.treeNodeContextContainer;
    }
    
    public WorkspaceTree getWorkspaceTree() {
        return this.workspaceTreePanel.getWorkspaceTree();
    }
    
    static {
        ICON = ImageUtils.getImageIcon("data/tabicons/workspace-tab.png");
    }
}
