package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import javax.swing.table.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class ExtendedMatchedFunctionViewsTable extends AbstractTable
{
    public ExtendedMatchedFunctionViewsTable(final AbstractTableModel abstractTableModel, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(abstractTableModel, workspaceTabPanelFunctions);
        this.sortColumn(1, -1);
        this.sortColumn(5, 1);
        this.sortColumn(2, 1);
        this.sortColumn(3, 1);
        this.init();
    }
    
    private void init() {
        final TableColumnModel columnModel = this.getColumnModel();
        final TableColumn column = columnModel.getColumn(0);
        final TableColumn column2 = columnModel.getColumn(3);
        final TableColumn column3 = columnModel.getColumn(4);
        final TableColumn column4 = columnModel.getColumn(5);
        final TableColumn column5 = columnModel.getColumn(9);
        final TableColumn column6 = columnModel.getColumn(1);
        final TableColumn column7 = columnModel.getColumn(2);
        final TableColumn column8 = columnModel.getColumn(10);
        final TableColumn column9 = columnModel.getColumn(8);
        final TableColumn column10 = columnModel.getColumn(7);
        final TableColumn column11 = columnModel.getColumn(6);
        column.setMinWidth(18);
        column2.setMinWidth(68);
        column3.setMinWidth(55);
        column4.setMinWidth(35);
        column5.setMinWidth(75);
        column6.setMinWidth(40);
        column7.setMinWidth(40);
        column8.setMinWidth(75);
        column9.setMinWidth(35);
        column10.setMinWidth(55);
        column11.setMinWidth(68);
        column.setMaxWidth(18);
        column2.setPreferredWidth(60);
        column3.setPreferredWidth(200);
        column4.setPreferredWidth(35);
        column5.setPreferredWidth(75);
        column6.setPreferredWidth(60);
        column7.setPreferredWidth(60);
        column8.setPreferredWidth(75);
        column9.setPreferredWidth(35);
        column10.setPreferredWidth(200);
        column11.setPreferredWidth(60);
        column.setCellRenderer(new IconCellRenderer());
        final SimilarityConfidenceCellRenderer similarityConfidenceCellRenderer = new SimilarityConfidenceCellRenderer();
        column6.setCellRenderer(similarityConfidenceCellRenderer);
        column7.setCellRenderer(similarityConfidenceCellRenderer);
        final BackgroundCellRenderer backgroundCellRenderer = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        column2.setCellRenderer(backgroundCellRenderer);
        column3.setCellRenderer(backgroundCellRenderer);
        final BackgroundCellRenderer backgroundCellRenderer2 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        column11.setCellRenderer(backgroundCellRenderer2);
        column10.setCellRenderer(backgroundCellRenderer2);
        final FunctionTypeCellRenderer functionTypeCellRenderer = new FunctionTypeCellRenderer();
        column4.setCellRenderer(functionTypeCellRenderer);
        column9.setCellRenderer(functionTypeCellRenderer);
        column5.setCellRenderer(new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32));
        column8.setCellRenderer(new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32));
    }
    
    @Override
    protected JPopupMenu getPopupMenu(final int n, final int n2) {
        return new FlowGraphViewsTablePopupMenu(this, n, n2);
    }
    
    @Override
    protected void handleDoubleClick(final int n) {
        this.getController().openFlowgraphView(this.getController().getMainWindow(), this.getDiff(), new CAddress((String)this.getTableModel().getValueAt(n, 3), 16), new CAddress((String)this.getTableModel().getValueAt(n, 6), 16));
    }
    
    @Override
    public void dispose() {
    }
}
