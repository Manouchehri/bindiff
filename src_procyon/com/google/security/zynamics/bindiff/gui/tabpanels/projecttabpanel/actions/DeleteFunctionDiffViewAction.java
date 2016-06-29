package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;

public class DeleteFunctionDiffViewAction extends AbstractAction
{
    private final AbstractTable table;
    private final int hitRowIndex;
    
    public DeleteFunctionDiffViewAction(final AbstractTable abstractTable, final int hitRowIndex) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
        this.hitRowIndex = hitRowIndex;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final WorkspaceTabPanelFunctions controller = this.table.getController();
        final Diff rowDiff = AbstractTable.getRowDiff(this.table, this.hitRowIndex);
        final ArrayList<Diff> list = new ArrayList<Diff>();
        list.add(rowDiff);
        if (controller.deleteFunctionDiffs(list)) {
            final WorkspaceTree workspaceTree = controller.getWorkspaceTree();
            if (this.table instanceof FunctionDiffViewsContainerTable) {
                ((FunctionDiffViewsContainerTable)this.table).removeRow(rowDiff);
                final AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)workspaceTree.getModel().getRoot().getChildAt(0);
                for (int i = 0; i < allFunctionDiffViewsNode.getChildCount(); ++i) {
                    ((FunctionDiffViewsTable)((FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(i)).getComponent().getTables().get(0)).removeRow(rowDiff);
                }
            }
            else {
                if (!(this.table instanceof FunctionDiffViewsTable)) {
                    throw new IllegalArgumentException("Table must be an instance of FunctionDiffViewsContainerTable or FunctionDiffViewsTable.");
                }
                ((FunctionDiffViewsTable)this.table).removeRow(rowDiff);
                ((FunctionDiffViewsContainerTable)((AllFunctionDiffViewsNode)workspaceTree.getModel().getRoot().getChildAt(0)).getComponent().getTables().get(0)).removeRow(rowDiff);
            }
        }
    }
}
