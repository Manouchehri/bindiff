package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public abstract class AbstractTreeNode extends DefaultMutableTreeNode
{
    private final WorkspaceTabPanelFunctions controller;
    private final Diff diff;
    
    public AbstractTreeNode(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Diff diff) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.diff = diff;
    }
    
    protected abstract void createChildren();
    
    protected abstract void delete();
    
    protected WorkspaceTabPanelFunctions getController() {
        return this.controller;
    }
    
    protected WorkspaceTree getTree() {
        return this.controller.getWorkspaceTree();
    }
    
    protected WorkspaceTreeModel getTreeModel() {
        return this.controller.getWorkspaceTree().getModel();
    }
    
    public void deleteChildren() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            ((AbstractTreeNode)this.getChildAt(i)).delete();
        }
        this.removeAllChildren();
    }
    
    public abstract void doubleClicked();
    
    public abstract Component getComponent();
    
    public Diff getDiff() {
        return this.diff;
    }
    
    public abstract Icon getIcon();
    
    public abstract JPopupMenu getPopupMenu();
    
    @Override
    public RootNode getRoot() {
        return this.controller.getWorkspaceTree().getModel().getRoot();
    }
    
    @Override
    public abstract String toString();
}
