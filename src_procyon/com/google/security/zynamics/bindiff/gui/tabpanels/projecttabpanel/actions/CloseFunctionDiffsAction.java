package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;

public class CloseFunctionDiffsAction extends AbstractAction
{
    private final WorkspaceTabPanelFunctions controller;
    
    public CloseFunctionDiffsAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final HashSet set = new HashSet();
        set.addAll(this.controller.getWorkspace().getDiffList(true));
        this.controller.closeDiffs(set);
        final WorkspaceTree workspaceTree = this.controller.getWorkspaceTree();
        final AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)workspaceTree.getModel().getRoot().getChildAt(0);
        allFunctionDiffViewsNode.deleteChildren();
        workspaceTree.setSelectionPath(new TreePath(allFunctionDiffViewsNode.getPath()));
        workspaceTree.updateTree();
    }
}
