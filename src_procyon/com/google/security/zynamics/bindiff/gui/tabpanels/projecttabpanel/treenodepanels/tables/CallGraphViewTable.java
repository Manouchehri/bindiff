package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import javax.swing.table.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.*;

public class CallGraphViewTable extends AbstractTable
{
    public CallGraphViewTable(final AbstractTableModel abstractTableModel, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(abstractTableModel, workspaceTabPanelFunctions);
        final TableColumn column = this.getColumnModel().getColumn(2);
        final TableColumn column2 = this.getColumnModel().getColumn(4);
        final TableColumn column3 = this.getColumnModel().getColumn(0);
        final TableColumn column4 = this.getColumnModel().getColumn(1);
        final TableColumn column5 = this.getColumnModel().getColumn(5);
        final TableColumn column6 = this.getColumnModel().getColumn(3);
        column.setMinWidth(60);
        column2.setMinWidth(75);
        column3.setMinWidth(40);
        column4.setMinWidth(40);
        column5.setMinWidth(75);
        column6.setMinWidth(60);
        column.setPreferredWidth(200);
        column2.setPreferredWidth(75);
        column3.setPreferredWidth(60);
        column4.setPreferredWidth(60);
        column5.setPreferredWidth(75);
        column6.setPreferredWidth(200);
        final SimilarityConfidenceCellRenderer similarityConfidenceCellRenderer = new SimilarityConfidenceCellRenderer();
        column3.setCellRenderer(similarityConfidenceCellRenderer);
        column4.setCellRenderer(similarityConfidenceCellRenderer);
        column.setCellRenderer(new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2));
        column6.setCellRenderer(new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2));
        column2.setCellRenderer(new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32));
        column5.setCellRenderer(new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32));
    }
    
    @Override
    protected JPopupMenu getPopupMenu(final int n, final int n2) {
        return new CallGraphViewsPopupMenu(this, n2);
    }
    
    @Override
    protected void handleDoubleClick(final int n) {
        final WorkspaceTabPanelFunctions controller = this.getController();
        controller.openCallgraphView(controller.getMainWindow(), this.getDiff());
    }
}
