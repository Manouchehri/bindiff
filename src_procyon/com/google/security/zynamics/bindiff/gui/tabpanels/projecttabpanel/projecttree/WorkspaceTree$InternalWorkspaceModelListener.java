package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.project.diff.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import javax.swing.tree.*;
import javax.swing.border.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import java.io.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;
import com.google.security.zynamics.zylib.gui.jtree.*;
import java.awt.*;

class WorkspaceTree$InternalWorkspaceModelListener extends WorkspaceAdapter
{
    final /* synthetic */ WorkspaceTree this$0;
    
    private WorkspaceTree$InternalWorkspaceModelListener(final WorkspaceTree this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void addedDiff(final Diff diff) {
        if (!diff.isFunctionDiff()) {
            this.this$0.rootNode.addDiff(diff);
            this.this$0.updateTree();
        }
        else {
            final AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)this.this$0.rootNode.getFirstChild();
            ((FunctionDiffViewsContainerTable)allFunctionDiffViewsNode.getComponent().getTables().get(0)).addRow(diff);
            final boolean expanded = this.this$0.isExpanded(new TreePath(allFunctionDiffViewsNode.getPath()));
            final TreePath selectionPath = this.this$0.getSelectionPath();
            allFunctionDiffViewsNode.addDiff(diff);
            this.this$0.updateTree();
            for (int i = 0; i < allFunctionDiffViewsNode.getChildCount(); ++i) {
                final FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(i);
                if (functionDiffViewsNode.getViewDirectory().equals(diff.getMatchesDatabase().getParentFile())) {
                    ((FunctionDiffViewsTable)functionDiffViewsNode.getComponent().getTables().get(0)).addRow(diff);
                    break;
                }
            }
            if (expanded) {
                this.this$0.expandPath(new TreePath(allFunctionDiffViewsNode.getPath()));
            }
            this.this$0.setSelectionPath(selectionPath);
        }
    }
    
    @Override
    public void closedWorkspace() {
        this.this$0.rootNode.deleteChildren();
        this.this$0.getSelectionModel().setSelectionPath(new TreePath(this.this$0.rootNode.getPath()));
        this.this$0.updateTree();
    }
    
    @Override
    public void loadedWorkspace(final Workspace workspace) {
        this.this$0.rootNode.setWorkspace(workspace);
        this.this$0.getModel().nodeStructureChanged(this.this$0.rootNode);
    }
    
    @Override
    public void removedDiff(final Diff diff) {
        if (diff.isFunctionDiff()) {
            final AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)this.this$0.rootNode.getFirstChild();
            ((FunctionDiffViewsContainerTable)allFunctionDiffViewsNode.getComponent().getTables().get(0)).removeRow(diff);
            for (int i = 0; i < allFunctionDiffViewsNode.getChildCount(); ++i) {
                final FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(i);
                if (functionDiffViewsNode.getViewDirectory().equals(diff.getMatchesDatabase().getParentFile())) {
                    ((FunctionDiffViewsTable)functionDiffViewsNode.getComponent().getTables().get(0)).removeRow(diff);
                    break;
                }
            }
            for (int j = 0; j < allFunctionDiffViewsNode.getChildCount(); ++j) {
                final FunctionDiffViewsNode functionDiffViewsNode2 = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(j);
                if (functionDiffViewsNode2.getViewDirectory().equals(diff.getMatchesDatabase().getParentFile())) {
                    ((FunctionDiffViewsTable)functionDiffViewsNode2.getComponent().getTables().get(0)).addRow(diff);
                    break;
                }
            }
        }
    }
}
