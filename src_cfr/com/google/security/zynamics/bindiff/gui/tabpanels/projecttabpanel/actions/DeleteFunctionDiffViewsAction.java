/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;

public class DeleteFunctionDiffViewsAction
extends AbstractAction {
    private final FunctionDiffViewsNode viewsNode;

    public DeleteFunctionDiffViewsAction(FunctionDiffViewsNode functionDiffViewsNode) {
        this.viewsNode = (FunctionDiffViewsNode)Preconditions.checkNotNull(functionDiffViewsNode);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        FunctionDiffViewsNodeContextPanel functionDiffViewsNodeContextPanel = this.viewsNode.getComponent();
        FunctionDiffViewsTable functionDiffViewsTable = (FunctionDiffViewsTable)functionDiffViewsNodeContextPanel.getTables().get(0);
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = functionDiffViewsTable.getController();
        ArrayList<Diff> arrayList = new ArrayList<Diff>();
        for (int i2 = 0; i2 < functionDiffViewsTable.getRowCount(); ++i2) {
            arrayList.add(AbstractTable.getRowDiff(functionDiffViewsTable, i2));
        }
        workspaceTabPanelFunctions.deleteFunctionDiffs(arrayList);
        try {
            if (!this.viewsNode.getViewDirectory().exists()) return;
            CFileUtils.deleteDirectory(this.viewsNode.getViewDirectory());
            return;
        }
        catch (IOException var6_7) {
            Logger.logException(var6_7, "Couldn't delete function diff's directory.");
            CMessageBox.showError(workspaceTabPanelFunctions.getMainWindow(), "Couldn't delete function diff's directory.");
        }
    }
}

