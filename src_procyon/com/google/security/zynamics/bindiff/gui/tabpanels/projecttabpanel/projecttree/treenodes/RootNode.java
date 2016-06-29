package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import javax.swing.tree.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public final class RootNode extends AbstractTreeNode
{
    private Workspace workspace;
    private final WorkspaceTree tree;
    private final DefaultTreeNodeContextPanel component;
    
    public RootNode(final WorkspaceTree workspaceTree, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(workspaceTabPanelFunctions, null);
        this.workspace = null;
        this.component = new DefaultTreeNodeContextPanel();
        this.tree = (WorkspaceTree)Preconditions.checkNotNull(workspaceTree);
        this.createChildren();
    }
    
    @Override
    protected void createChildren() {
        if (this.workspace != null) {
            this.add(new AllFunctionDiffViewsNode(this.getController()));
            for (final Diff diff : this.workspace.getDiffList()) {
                if (diff == null) {
                    throw new RuntimeException("Diff cannot be null.");
                }
                if (diff.isFunctionDiff()) {
                    continue;
                }
                this.add(new DiffNode(diff, this.getController()));
            }
        }
    }
    
    @Override
    protected void delete() {
        this.deleteChildren();
    }
    
    @Override
    protected WorkspaceTree getTree() {
        return this.tree;
    }
    
    public void addDiff(final Diff diff) {
        if (!diff.isFunctionDiff()) {
            this.add(new DiffNode(diff, this.getController()));
        }
    }
    
    @Override
    public void doubleClicked() {
    }
    
    @Override
    public Component getComponent() {
        return this.component;
    }
    
    @Override
    public Icon getIcon() {
        return null;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return null;
    }
    
    public void setWorkspace(final Workspace workspace) {
        this.workspace = workspace;
        this.createChildren();
    }
    
    @Override
    public String toString() {
        return "";
    }
}
