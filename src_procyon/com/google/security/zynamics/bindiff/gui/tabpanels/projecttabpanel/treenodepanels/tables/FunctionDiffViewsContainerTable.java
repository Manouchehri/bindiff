package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import javax.swing.table.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;

public class FunctionDiffViewsContainerTable extends AbstractTable
{
    public FunctionDiffViewsContainerTable(final AbstractTableModel abstractTableModel, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(abstractTableModel, workspaceTabPanelFunctions);
        this.init();
    }
    
    private void init() {
        final TableColumn column = this.getColumnModel().getColumn(0);
        final TableColumn column2 = this.getColumnModel().getColumn(1);
        final TableColumn column3 = this.getColumnModel().getColumn(2);
        final TableColumn column4 = this.getColumnModel().getColumn(3);
        final TableColumn column5 = this.getColumnModel().getColumn(4);
        final TableColumn column6 = this.getColumnModel().getColumn(5);
        column.setMinWidth(100);
        column2.setMinWidth(100);
        column3.setMinWidth(100);
        column4.setMinWidth(100);
        column5.setMinWidth(200);
        column6.setMinWidth(120);
        column.setPreferredWidth(100);
        column2.setPreferredWidth(100);
        column3.setPreferredWidth(100);
        column4.setPreferredWidth(100);
        column5.setPreferredWidth(300);
        column6.setPreferredWidth(120);
        final BackgroundCellRenderer backgroundCellRenderer = new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        column.setCellRenderer(backgroundCellRenderer);
        column2.setCellRenderer(backgroundCellRenderer);
        final BackgroundCellRenderer backgroundCellRenderer2 = new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        column3.setCellRenderer(backgroundCellRenderer2);
        column4.setCellRenderer(backgroundCellRenderer2);
        final BackgroundCellRenderer backgroundCellRenderer3 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        column5.setCellRenderer(backgroundCellRenderer3);
        column6.setCellRenderer(backgroundCellRenderer3);
    }
    
    @Override
    protected JPopupMenu getPopupMenu(final int n, final int n2) {
        return new FunctionDiffFlowGraphsViewTablePopupMenu(this, n, n2);
    }
    
    @Override
    protected void handleDoubleClick(final int n) {
        this.getController().openFunctionDiffView((MainWindow)SwingUtilities.getWindowAncestor(this), ((FunctionDiffViewsContainerTableModel)this.getTableModel()).getDiffAt(n));
    }
    
    public void addRow(final Diff diff) {
        ((FunctionDiffViewsContainerTableModel)this.getTableModel()).addRow(diff);
        this.updateUI();
    }
    
    public void removeRow(final Diff diff) {
        ((FunctionDiffViewsContainerTableModel)this.getTableModel()).removeRow(diff);
        this.updateUI();
    }
}
