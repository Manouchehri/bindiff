/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel$InternalTableModelListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTableModel;
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

public class FunctionDiffViewsNodeContextPanel
extends AbstractTreeNodeContextPanel {
    private final FunctionDiffViewsTable functionDiffViewsTable;
    private final TableModelListener tableModelListener;

    public FunctionDiffViewsNodeContextPanel(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, List list) {
        this.tableModelListener = new FunctionDiffViewsNodeContextPanel$InternalTableModelListener(this, null);
        FunctionDiffViewsTableModel functionDiffViewsTableModel = new FunctionDiffViewsTableModel(list);
        this.functionDiffViewsTable = new FunctionDiffViewsTable(functionDiffViewsTableModel, workspaceTabPanelFunctions);
        this.functionDiffViewsTable.getTableModel().addTableModelListener(this.tableModelListener);
        this.init();
    }

    private JPanel createTablePanel() {
        JScrollPane jScrollPane = new JScrollPane(this.functionDiffViewsTable);
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
        ((TitledBorder)this.getBorder()).setTitle(String.format("%d Single Function Diff Views", this.functionDiffViewsTable.getRowCount()));
    }

    public void dispose() {
        this.functionDiffViewsTable.getTableModel().removeTableModelListener(this.tableModelListener);
    }

    public FunctionDiffViewsTableModel getFunctionViewsTableModel() {
        return (FunctionDiffViewsTableModel)this.functionDiffViewsTable.getTableModel();
    }

    @Override
    public List getTables() {
        ArrayList<FunctionDiffViewsTable> arrayList = new ArrayList<FunctionDiffViewsTable>();
        arrayList.add(this.functionDiffViewsTable);
        return arrayList;
    }

    static /* synthetic */ void access$100(FunctionDiffViewsNodeContextPanel functionDiffViewsNodeContextPanel) {
        functionDiffViewsNodeContextPanel.updateBorderTitle();
    }
}

