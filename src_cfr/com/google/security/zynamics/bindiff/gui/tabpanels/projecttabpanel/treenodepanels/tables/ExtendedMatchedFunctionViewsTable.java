/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.IconCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.FlowGraphViewsTablePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.BackgroundCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.FunctionTypeCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.PercentageThreeBarCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.SimilarityConfidenceCellRenderer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import javax.swing.JPopupMenu;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ExtendedMatchedFunctionViewsTable
extends AbstractTable {
    public ExtendedMatchedFunctionViewsTable(AbstractTableModel abstractTableModel, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(abstractTableModel, workspaceTabPanelFunctions);
        this.sortColumn(1, -1);
        this.sortColumn(5, 1);
        this.sortColumn(2, 1);
        this.sortColumn(3, 1);
        this.init();
    }

    private void init() {
        TableColumnModel tableColumnModel = this.getColumnModel();
        TableColumn tableColumn = tableColumnModel.getColumn(0);
        TableColumn tableColumn2 = tableColumnModel.getColumn(3);
        TableColumn tableColumn3 = tableColumnModel.getColumn(4);
        TableColumn tableColumn4 = tableColumnModel.getColumn(5);
        TableColumn tableColumn5 = tableColumnModel.getColumn(9);
        TableColumn tableColumn6 = tableColumnModel.getColumn(1);
        TableColumn tableColumn7 = tableColumnModel.getColumn(2);
        TableColumn tableColumn8 = tableColumnModel.getColumn(10);
        TableColumn tableColumn9 = tableColumnModel.getColumn(8);
        TableColumn tableColumn10 = tableColumnModel.getColumn(7);
        TableColumn tableColumn11 = tableColumnModel.getColumn(6);
        tableColumn.setMinWidth(18);
        tableColumn2.setMinWidth(68);
        tableColumn3.setMinWidth(55);
        tableColumn4.setMinWidth(35);
        tableColumn5.setMinWidth(75);
        tableColumn6.setMinWidth(40);
        tableColumn7.setMinWidth(40);
        tableColumn8.setMinWidth(75);
        tableColumn9.setMinWidth(35);
        tableColumn10.setMinWidth(55);
        tableColumn11.setMinWidth(68);
        tableColumn.setMaxWidth(18);
        tableColumn2.setPreferredWidth(60);
        tableColumn3.setPreferredWidth(200);
        tableColumn4.setPreferredWidth(35);
        tableColumn5.setPreferredWidth(75);
        tableColumn6.setPreferredWidth(60);
        tableColumn7.setPreferredWidth(60);
        tableColumn8.setPreferredWidth(75);
        tableColumn9.setPreferredWidth(35);
        tableColumn10.setPreferredWidth(200);
        tableColumn11.setPreferredWidth(60);
        IconCellRenderer iconCellRenderer = new IconCellRenderer();
        tableColumn.setCellRenderer(iconCellRenderer);
        SimilarityConfidenceCellRenderer similarityConfidenceCellRenderer = new SimilarityConfidenceCellRenderer();
        tableColumn6.setCellRenderer(similarityConfidenceCellRenderer);
        tableColumn7.setCellRenderer(similarityConfidenceCellRenderer);
        BackgroundCellRenderer backgroundCellRenderer = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        tableColumn2.setCellRenderer(backgroundCellRenderer);
        tableColumn3.setCellRenderer(backgroundCellRenderer);
        BackgroundCellRenderer backgroundCellRenderer2 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        tableColumn11.setCellRenderer(backgroundCellRenderer2);
        tableColumn10.setCellRenderer(backgroundCellRenderer2);
        FunctionTypeCellRenderer functionTypeCellRenderer = new FunctionTypeCellRenderer();
        tableColumn4.setCellRenderer(functionTypeCellRenderer);
        tableColumn9.setCellRenderer(functionTypeCellRenderer);
        PercentageThreeBarCellRenderer percentageThreeBarCellRenderer = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
        tableColumn5.setCellRenderer(percentageThreeBarCellRenderer);
        PercentageThreeBarCellRenderer percentageThreeBarCellRenderer2 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
        tableColumn8.setCellRenderer(percentageThreeBarCellRenderer2);
    }

    @Override
    protected JPopupMenu getPopupMenu(int n2, int n3) {
        return new FlowGraphViewsTablePopupMenu(this, n2, n3);
    }

    @Override
    protected void handleDoubleClick(int n2) {
        CAddress cAddress = new CAddress((String)this.getTableModel().getValueAt(n2, 3), 16);
        CAddress cAddress2 = new CAddress((String)this.getTableModel().getValueAt(n2, 6), 16);
        this.getController().openFlowgraphView(this.getController().getMainWindow(), this.getDiff(), cAddress, cAddress2);
    }

    @Override
    public void dispose() {
    }
}

