/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.FunctionDiffFlowGraphsViewTablePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.BackgroundCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.PercentageThreeBarCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.SimilarityConfidenceCellRenderer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FunctionDiffViewsTable
extends AbstractTable {
    public FunctionDiffViewsTable(AbstractTableModel abstractTableModel, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(abstractTableModel, workspaceTabPanelFunctions);
        this.init();
    }

    private void init() {
        TableColumn tableColumn = this.getColumnModel().getColumn(0);
        TableColumn tableColumn2 = this.getColumnModel().getColumn(3);
        TableColumn tableColumn3 = this.getColumnModel().getColumn(4);
        TableColumn tableColumn4 = this.getColumnModel().getColumn(7);
        TableColumn tableColumn5 = this.getColumnModel().getColumn(1);
        TableColumn tableColumn6 = this.getColumnModel().getColumn(2);
        TableColumn tableColumn7 = this.getColumnModel().getColumn(8);
        TableColumn tableColumn8 = this.getColumnModel().getColumn(6);
        TableColumn tableColumn9 = this.getColumnModel().getColumn(5);
        tableColumn.setMinWidth(80);
        tableColumn2.setMinWidth(68);
        tableColumn3.setMinWidth(50);
        tableColumn4.setMinWidth(75);
        tableColumn5.setMinWidth(40);
        tableColumn6.setMinWidth(40);
        tableColumn7.setMinWidth(75);
        tableColumn8.setMinWidth(50);
        tableColumn9.setMinWidth(68);
        tableColumn.setPreferredWidth(300);
        tableColumn2.setPreferredWidth(60);
        tableColumn3.setPreferredWidth(150);
        tableColumn4.setPreferredWidth(75);
        tableColumn5.setPreferredWidth(60);
        tableColumn6.setPreferredWidth(60);
        tableColumn7.setPreferredWidth(75);
        tableColumn8.setPreferredWidth(150);
        tableColumn9.setPreferredWidth(60);
        SimilarityConfidenceCellRenderer similarityConfidenceCellRenderer = new SimilarityConfidenceCellRenderer();
        tableColumn5.setCellRenderer(similarityConfidenceCellRenderer);
        tableColumn6.setCellRenderer(similarityConfidenceCellRenderer);
        BackgroundCellRenderer backgroundCellRenderer = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        tableColumn.setCellRenderer(backgroundCellRenderer);
        BackgroundCellRenderer backgroundCellRenderer2 = new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        tableColumn2.setCellRenderer(backgroundCellRenderer2);
        tableColumn3.setCellRenderer(backgroundCellRenderer2);
        BackgroundCellRenderer backgroundCellRenderer3 = new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        tableColumn9.setCellRenderer(backgroundCellRenderer3);
        tableColumn8.setCellRenderer(backgroundCellRenderer3);
        PercentageThreeBarCellRenderer percentageThreeBarCellRenderer = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
        tableColumn4.setCellRenderer(percentageThreeBarCellRenderer);
        PercentageThreeBarCellRenderer percentageThreeBarCellRenderer2 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
        tableColumn7.setCellRenderer(percentageThreeBarCellRenderer2);
    }

    @Override
    protected JPopupMenu getPopupMenu(int n2, int n3) {
        return new FunctionDiffFlowGraphsViewTablePopupMenu(this, n2, n3);
    }

    @Override
    protected void handleDoubleClick(int n2) {
        Diff diff = ((FunctionDiffViewsTableModel)this.getTableModel()).getDiffAt(n2);
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = this.getController();
        workspaceTabPanelFunctions.openFunctionDiffView((MainWindow)SwingUtilities.getWindowAncestor(this), diff);
    }

    public void addRow(Diff diff) {
        ((FunctionDiffViewsTableModel)this.getTableModel()).addRow(diff);
        this.updateUI();
    }

    public void removeRow(Diff diff) {
        ((FunctionDiffViewsTableModel)this.getTableModel()).removeRow(diff);
        this.updateUI();
    }
}

