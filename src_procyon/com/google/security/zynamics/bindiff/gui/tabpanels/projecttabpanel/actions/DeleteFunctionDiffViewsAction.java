package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import java.io.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;

public class DeleteFunctionDiffViewsAction extends AbstractAction
{
    private final FunctionDiffViewsNode viewsNode;
    
    public DeleteFunctionDiffViewsAction(final FunctionDiffViewsNode functionDiffViewsNode) {
        this.viewsNode = (FunctionDiffViewsNode)Preconditions.checkNotNull(functionDiffViewsNode);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final FunctionDiffViewsTable functionDiffViewsTable = this.viewsNode.getComponent().getTables().get(0);
        final WorkspaceTabPanelFunctions controller = functionDiffViewsTable.getController();
        final ArrayList<Diff> list = new ArrayList<Diff>();
        for (int i = 0; i < functionDiffViewsTable.getRowCount(); ++i) {
            list.add(AbstractTable.getRowDiff(functionDiffViewsTable, i));
        }
        controller.deleteFunctionDiffs(list);
        try {
            if (this.viewsNode.getViewDirectory().exists()) {
                CFileUtils.deleteDirectory(this.viewsNode.getViewDirectory());
            }
        }
        catch (IOException ex) {
            Logger.logException(ex, "Couldn't delete function diff's directory.");
            CMessageBox.showError(controller.getMainWindow(), "Couldn't delete function diff's directory.");
        }
    }
}
