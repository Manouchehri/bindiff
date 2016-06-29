/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.CallGraphViewsPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.BackgroundCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.PercentageThreeBarCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.SimilarityConfidenceCellRenderer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import javax.swing.JPopupMenu;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CallGraphViewTable
extends AbstractTable {
    public CallGraphViewTable(AbstractTableModel abstractTableModel, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(abstractTableModel, workspaceTabPanelFunctions);
        TableColumn tableColumn = this.getColumnModel().getColumn(2);
        TableColumn tableColumn2 = this.getColumnModel().getColumn(4);
        TableColumn tableColumn3 = this.getColumnModel().getColumn(0);
        TableColumn tableColumn4 = this.getColumnModel().getColumn(1);
        TableColumn tableColumn5 = this.getColumnModel().getColumn(5);
        TableColumn tableColumn6 = this.getColumnModel().getColumn(3);
        tableColumn.setMinWidth(60);
        tableColumn2.setMinWidth(75);
        tableColumn3.setMinWidth(40);
        tableColumn4.setMinWidth(40);
        tableColumn5.setMinWidth(75);
        tableColumn6.setMinWidth(60);
        tableColumn.setPreferredWidth(200);
        tableColumn2.setPreferredWidth(75);
        tableColumn3.setPreferredWidth(60);
        tableColumn4.setPreferredWidth(60);
        tableColumn5.setPreferredWidth(75);
        tableColumn6.setPreferredWidth(200);
        SimilarityConfidenceCellRenderer similarityConfidenceCellRenderer = new SimilarityConfidenceCellRenderer();
        tableColumn3.setCellRenderer(similarityConfidenceCellRenderer);
        tableColumn4.setCellRenderer(similarityConfidenceCellRenderer);
        BackgroundCellRenderer backgroundCellRenderer = new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        tableColumn.setCellRenderer(backgroundCellRenderer);
        BackgroundCellRenderer backgroundCellRenderer2 = new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
        tableColumn6.setCellRenderer(backgroundCellRenderer2);
        PercentageThreeBarCellRenderer percentageThreeBarCellRenderer = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
        tableColumn2.setCellRenderer(percentageThreeBarCellRenderer);
        PercentageThreeBarCellRenderer percentageThreeBarCellRenderer2 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
        tableColumn5.setCellRenderer(percentageThreeBarCellRenderer2);
    }

    @Override
    protected JPopupMenu getPopupMenu(int n2, int n3) {
        return new CallGraphViewsPopupMenu(this, n3);
    }

    @Override
    protected void handleDoubleClick(int n2) {
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = this.getController();
        workspaceTabPanelFunctions.openCallgraphView(workspaceTabPanelFunctions.getMainWindow(), this.getDiff());
    }
}

