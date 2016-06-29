/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreeModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.io.File;
import java.util.List;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

class WorkspaceTree$InternalWorkspaceModelListener
extends WorkspaceAdapter {
    final /* synthetic */ WorkspaceTree this$0;

    private WorkspaceTree$InternalWorkspaceModelListener(WorkspaceTree workspaceTree) {
        this.this$0 = workspaceTree;
    }

    @Override
    public void addedDiff(Diff diff) {
        if (!diff.isFunctionDiff()) {
            WorkspaceTree.access$600(this.this$0).addDiff(diff);
            this.this$0.updateTree();
            return;
        }
        AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)WorkspaceTree.access$600(this.this$0).getFirstChild();
        ((FunctionDiffViewsContainerTable)allFunctionDiffViewsNode.getComponent().getTables().get(0)).addRow(diff);
        TreePath treePath = new TreePath(allFunctionDiffViewsNode.getPath());
        boolean bl2 = this.this$0.isExpanded(treePath);
        TreePath treePath2 = this.this$0.getSelectionPath();
        allFunctionDiffViewsNode.addDiff(diff);
        this.this$0.updateTree();
        for (int i2 = 0; i2 < allFunctionDiffViewsNode.getChildCount(); ++i2) {
            FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(i2);
            if (!functionDiffViewsNode.getViewDirectory().equals(diff.getMatchesDatabase().getParentFile())) continue;
            ((FunctionDiffViewsTable)functionDiffViewsNode.getComponent().getTables().get(0)).addRow(diff);
            break;
        }
        if (bl2) {
            this.this$0.expandPath(new TreePath(allFunctionDiffViewsNode.getPath()));
        }
        this.this$0.setSelectionPath(treePath2);
    }

    @Override
    public void closedWorkspace() {
        WorkspaceTree.access$600(this.this$0).deleteChildren();
        TreePath treePath = new TreePath(WorkspaceTree.access$600(this.this$0).getPath());
        this.this$0.getSelectionModel().setSelectionPath(treePath);
        this.this$0.updateTree();
    }

    @Override
    public void loadedWorkspace(Workspace workspace) {
        WorkspaceTree.access$600(this.this$0).setWorkspace(workspace);
        this.this$0.getModel().nodeStructureChanged(WorkspaceTree.access$600(this.this$0));
    }

    @Override
    public void removedDiff(Diff diff) {
        FunctionDiffViewsNode functionDiffViewsNode;
        int n2;
        if (!diff.isFunctionDiff()) return;
        AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)WorkspaceTree.access$600(this.this$0).getFirstChild();
        FunctionDiffViewsContainerTable functionDiffViewsContainerTable = (FunctionDiffViewsContainerTable)allFunctionDiffViewsNode.getComponent().getTables().get(0);
        functionDiffViewsContainerTable.removeRow(diff);
        for (n2 = 0; n2 < allFunctionDiffViewsNode.getChildCount(); ++n2) {
            functionDiffViewsNode = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(n2);
            if (!functionDiffViewsNode.getViewDirectory().equals(diff.getMatchesDatabase().getParentFile())) continue;
            ((FunctionDiffViewsTable)functionDiffViewsNode.getComponent().getTables().get(0)).removeRow(diff);
            break;
        }
        n2 = 0;
        while (n2 < allFunctionDiffViewsNode.getChildCount()) {
            functionDiffViewsNode = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(n2);
            if (functionDiffViewsNode.getViewDirectory().equals(diff.getMatchesDatabase().getParentFile())) {
                ((FunctionDiffViewsTable)functionDiffViewsNode.getComponent().getTables().get(0)).addRow(diff);
                return;
            }
            ++n2;
        }
    }

    /* synthetic */ WorkspaceTree$InternalWorkspaceModelListener(WorkspaceTree workspaceTree, WorkspaceTree$1 workspaceTree$1) {
        this(workspaceTree);
    }
}

