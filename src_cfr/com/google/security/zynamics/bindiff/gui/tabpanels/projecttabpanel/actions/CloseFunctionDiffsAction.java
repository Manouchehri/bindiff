/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreeModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import com.google.security.zynamics.bindiff.project.Workspace;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class CloseFunctionDiffsAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;

    public CloseFunctionDiffsAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.controller.getWorkspace().getDiffList(true));
        this.controller.closeDiffs(hashSet);
        WorkspaceTree workspaceTree = this.controller.getWorkspaceTree();
        RootNode rootNode = workspaceTree.getModel().getRoot();
        AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)rootNode.getChildAt(0);
        allFunctionDiffViewsNode.deleteChildren();
        workspaceTree.setSelectionPath(new TreePath(allFunctionDiffViewsNode.getPath()));
        workspaceTree.updateTree();
    }
}

