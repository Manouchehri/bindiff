/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreeModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.tree.TreeNode;

public class DeleteFunctionDiffViewAction
extends AbstractAction {
    private final AbstractTable table;
    private final int hitRowIndex;

    public DeleteFunctionDiffViewAction(AbstractTable abstractTable, int n2) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
        this.hitRowIndex = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = this.table.getController();
        Diff diff = AbstractTable.getRowDiff(this.table, this.hitRowIndex);
        ArrayList<Diff> arrayList = new ArrayList<Diff>();
        arrayList.add(diff);
        if (!workspaceTabPanelFunctions.deleteFunctionDiffs(arrayList)) return;
        WorkspaceTree workspaceTree = workspaceTabPanelFunctions.getWorkspaceTree();
        if (!(this.table instanceof FunctionDiffViewsContainerTable)) {
            if (!(this.table instanceof FunctionDiffViewsTable)) throw new IllegalArgumentException("Table must be an instance of FunctionDiffViewsContainerTable or FunctionDiffViewsTable.");
            ((FunctionDiffViewsTable)this.table).removeRow(diff);
            AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)workspaceTree.getModel().getRoot().getChildAt(0);
            FunctionDiffViewsContainerNodeContextPanel functionDiffViewsContainerNodeContextPanel = allFunctionDiffViewsNode.getComponent();
            FunctionDiffViewsContainerTable functionDiffViewsContainerTable = (FunctionDiffViewsContainerTable)functionDiffViewsContainerNodeContextPanel.getTables().get(0);
            functionDiffViewsContainerTable.removeRow(diff);
            return;
        }
        ((FunctionDiffViewsContainerTable)this.table).removeRow(diff);
        AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)workspaceTree.getModel().getRoot().getChildAt(0);
        int n2 = 0;
        while (n2 < allFunctionDiffViewsNode.getChildCount()) {
            FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(n2);
            FunctionDiffViewsNodeContextPanel functionDiffViewsNodeContextPanel = functionDiffViewsNode.getComponent();
            FunctionDiffViewsTable functionDiffViewsTable = (FunctionDiffViewsTable)functionDiffViewsNodeContextPanel.getTables().get(0);
            functionDiffViewsTable.removeRow(diff);
            ++n2;
        }
    }
}

