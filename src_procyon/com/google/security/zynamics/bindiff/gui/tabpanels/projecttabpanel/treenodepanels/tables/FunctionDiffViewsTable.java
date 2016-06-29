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

public class FunctionDiffViewsTable extends AbstractTable
{
    public FunctionDiffViewsTable(final AbstractTableModel abstractTableModel, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(abstractTableModel, workspaceTabPanelFunctions);
        this.init();
    }
    
    private void init() {
        final TableColumn column = this.getColumnModel().getColumn(0);
        final TableColumn column2 = this.getColumnModel().getColumn(3);
        final TableColumn column3 = this.getColumnModel().getColumn(4);
        final TableColumn column4 = this.getColumnModel().getColumn(7);
        final TableColumn column5 = this.getColumnModel().getColumn(1);
        final TableColumn column6 = this.getColumnModel().getColumn(2);
        final TableColumn column7 = this.getColumnModel().getColumn(8);
        final TableColumn column8 = this.getColumnModel().getColumn(6);
        final TableColumn column9 = this.getColumnModel().getColumn(5);
        column.setMinWidth(80);
        column2.setMinWidth(68);
        column3.setMinWidth(50);
        column4.setMinWidth(75);
        column5.setMinWidth(40);
        column6.setMinWidth(40);
        column7.setMinWidth(75);
        column8.setMinWidth(50);
        column9.setMinWidth(68);
        column.setPreferredWidth(300);
        column2.setPreferredWidth(60);
        column3.setPreferredWidth(150);
        column4.setPreferredWidth(75);
        column5.setPreferredWidth(60);
        column6.setPreferredWidth(60);
        column7.setPreferredWidth(75);
        column8.setPreferredWidth(150);
        column9.setPreferredWidth(60);
        final SimilarityConfidenceCellRenderer similarityConfidenceCellRenderer = new SimilarityConfidenceCellRenderer();
        column5.setCellRenderer(similarityConfidenceCellRenderer);
        column6.setCellRenderer(similarityConfidenceCellRenderer);
        column.setCellRenderer(new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2));
        final BackgroundCellRenderer backgroundCellRenderer = new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        column2.setCellRenderer(backgroundCellRenderer);
        column3.setCellRenderer(backgroundCellRenderer);
        final BackgroundCellRenderer backgroundCellRenderer2 = new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        column9.setCellRenderer(backgroundCellRenderer2);
        column8.setCellRenderer(backgroundCellRenderer2);
        column4.setCellRenderer(new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32));
        column7.setCellRenderer(new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32));
    }
    
    @Override
    protected JPopupMenu getPopupMenu(final int n, final int n2) {
        return new FunctionDiffFlowGraphsViewTablePopupMenu(this, n, n2);
    }
    
    @Override
    protected void handleDoubleClick(final int n) {
        this.getController().openFunctionDiffView((MainWindow)SwingUtilities.getWindowAncestor(this), ((FunctionDiffViewsTableModel)this.getTableModel()).getDiffAt(n));
    }
    
    public void addRow(final Diff diff) {
        ((FunctionDiffViewsTableModel)this.getTableModel()).addRow(diff);
        this.updateUI();
    }
    
    public void removeRow(final Diff diff) {
        ((FunctionDiffViewsTableModel)this.getTableModel()).removeRow(diff);
        this.updateUI();
    }
}
