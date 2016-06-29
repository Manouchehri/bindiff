package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;
import javax.swing.tree.*;

public final class WorkspaceTreeModel extends DefaultTreeModel
{
    private final RootNode rootNode;
    private final WorkspaceTree tree;
    
    public WorkspaceTreeModel(final WorkspaceTree tree, final RootNode rootNode) {
        super(rootNode);
        if (tree == null) {
            throw new IllegalArgumentException("Project tree cannot be null.)");
        }
        this.tree = tree;
        this.rootNode = rootNode;
    }
    
    @Override
    public RootNode getRoot() {
        return this.rootNode;
    }
    
    public WorkspaceTree getTree() {
        return this.tree;
    }
}
