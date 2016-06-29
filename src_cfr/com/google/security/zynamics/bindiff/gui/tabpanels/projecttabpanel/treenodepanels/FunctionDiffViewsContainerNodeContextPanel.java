/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTableModel;
import com.google.security.zynamics.bindiff.project.Workspace;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;

public class FunctionDiffViewsContainerNodeContextPanel
extends AbstractTreeNodeContextPanel {
    private final FunctionDiffViewsContainerTable allFunctionDiffsViewsTable;
    private final TableModelListener tableModelListener;

    public FunctionDiffViewsContainerNodeContextPanel(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.tableModelListener = new FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener(this, null);
        List list = ((WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions)).getWorkspace().getDiffList(true);
        FunctionDiffViewsContainerTableModel functionDiffViewsContainerTableModel = new FunctionDiffViewsContainerTableModel(list);
        this.allFunctionDiffsViewsTable = new FunctionDiffViewsContainerTable(functionDiffViewsContainerTableModel, workspaceTabPanelFunctions);
        functionDiffViewsContainerTableModel.addTableModelListener(this.tableModelListener);
        this.init();
    }

    private JPanel createTablePanel() {
        JScrollPane jScrollPane = new JScrollPane(this.allFunctionDiffsViewsTable);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)jScrollPane, "Center");
        return jPanel;
    }

    private void init() {
        this.setBorder(new TitledBorder(""));
        this.add((Component)this.createTablePanel(), "Center");
        this.updateBorderTitle();
    }

    private void updateBorderTitle() {
        ((TitledBorder)this.getBorder()).setTitle(String.format("%d Single Function Diff Views", this.allFunctionDiffsViewsTable.getRowCount()));
    }

    public void dispose() {
        this.allFunctionDiffsViewsTable.getTableModel().removeTableModelListener(this.tableModelListener);
    }

    @Override
    public List getTables() {
        ArrayList<FunctionDiffViewsContainerTable> arrayList = new ArrayList<FunctionDiffViewsContainerTable>();
        arrayList.add(this.allFunctionDiffsViewsTable);
        return arrayList;
    }

    static /* synthetic */ void access$100(FunctionDiffViewsContainerNodeContextPanel functionDiffViewsContainerNodeContextPanel) {
        functionDiffViewsContainerNodeContextPanel.updateBorderTitle();
    }
}

