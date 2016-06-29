/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.FunctionDiffFlowGraphsViewTablePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.BackgroundCellRenderer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FunctionDiffViewsContainerTable
extends AbstractTable {
    public FunctionDiffViewsContainerTable(AbstractTableModel abstractTableModel, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(abstractTableModel, workspaceTabPanelFunctions);
        this.init();
    }

    private void init() {
        TableColumn tableColumn = this.getColumnModel().getColumn(0);
        TableColumn tableColumn2 = this.getColumnModel().getColumn(1);
        TableColumn tableColumn3 = this.getColumnModel().getColumn(2);
        TableColumn tableColumn4 = this.getColumnModel().getColumn(3);
        TableColumn tableColumn5 = this.getColumnModel().getColumn(4);
        TableColumn tableColumn6 = this.getColumnModel().getColumn(5);
        tableColumn.setMinWidth(100);
        tableColumn2.setMinWidth(100);
        tableColumn3.setMinWidth(100);
        tableColumn4.setMinWidth(100);
        tableColumn5.setMinWidth(200);
        tableColumn6.setMinWidth(120);
        tableColumn.setPreferredWidth(100);
        tableColumn2.setPreferredWidth(100);
        tableColumn3.setPreferredWidth(100);
        tableColumn4.setPreferredWidth(100);
        tableColumn5.setPreferredWidth(300);
        tableColumn6.setPreferredWidth(120);
        BackgroundCellRenderer backgroundCellRenderer = new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        tableColumn.setCellRenderer(backgroundCellRenderer);
        tableColumn2.setCellRenderer(backgroundCellRenderer);
        BackgroundCellRenderer backgroundCellRenderer2 = new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        tableColumn3.setCellRenderer(backgroundCellRenderer2);
        tableColumn4.setCellRenderer(backgroundCellRenderer2);
        BackgroundCellRenderer backgroundCellRenderer3 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        tableColumn5.setCellRenderer(backgroundCellRenderer3);
        tableColumn6.setCellRenderer(backgroundCellRenderer3);
    }

    @Override
    protected JPopupMenu getPopupMenu(int n2, int n3) {
        return new FunctionDiffFlowGraphsViewTablePopupMenu(this, n2, n3);
    }

    @Override
    protected void handleDoubleClick(int n2) {
        Diff diff = ((FunctionDiffViewsContainerTableModel)this.getTableModel()).getDiffAt(n2);
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = this.getController();
        workspaceTabPanelFunctions.openFunctionDiffView((MainWindow)SwingUtilities.getWindowAncestor(this), diff);
    }

    public void addRow(Diff diff) {
        ((FunctionDiffViewsContainerTableModel)this.getTableModel()).addRow(diff);
        this.updateUI();
    }

    public void removeRow(Diff diff) {
        ((FunctionDiffViewsContainerTableModel)this.getTableModel()).removeRow(diff);
        this.updateUI();
    }
}

