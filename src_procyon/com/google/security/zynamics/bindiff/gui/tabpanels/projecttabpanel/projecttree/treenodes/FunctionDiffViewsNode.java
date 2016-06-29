package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.*;
import java.io.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;

public class FunctionDiffViewsNode extends AbstractTreeNode
{
    private static final ImageIcon ICON;
    private final FunctionDiffViewsNodeContextPanel component;
    private final File viewDirectory;
    
    public FunctionDiffViewsNode(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final File file, final List list) {
        super(workspaceTabPanelFunctions, null);
        this.viewDirectory = (File)Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(list);
        this.component = new FunctionDiffViewsNodeContextPanel(this.getController(), list);
    }
    
    @Override
    protected void createChildren() {
    }
    
    public void delete() {
        this.component.dispose();
    }
    
    @Override
    public void doubleClicked() {
    }
    
    @Override
    public FunctionDiffViewsNodeContextPanel getComponent() {
        return this.component;
    }
    
    @Override
    public Icon getIcon() {
        return FunctionDiffViewsNode.ICON;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return new FunctionDiffNodePopupMenu(this);
    }
    
    public File getViewDirectory() {
        return this.viewDirectory;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d)", this.viewDirectory.getName(), this.component.getFunctionViewsTableModel().getRowCount());
    }
    
    static {
        ICON = ImageUtils.getImageIcon("data/treeicons/function-diff-views.png");
    }
}
