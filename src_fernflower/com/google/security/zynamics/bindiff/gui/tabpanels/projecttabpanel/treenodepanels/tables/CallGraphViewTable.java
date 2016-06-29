package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.CallGraphViewsPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.BackgroundCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.PercentageThreeBarCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.SimilarityConfidenceCellRenderer;
import com.google.security.zynamics.bindiff.resources.Colors;
import javax.swing.JPopupMenu;
import javax.swing.table.TableColumn;

public class CallGraphViewTable extends AbstractTable {
   public CallGraphViewTable(AbstractTableModel var1, WorkspaceTabPanelFunctions var2) {
      super(var1, var2);
      TableColumn var3 = this.getColumnModel().getColumn(2);
      TableColumn var4 = this.getColumnModel().getColumn(4);
      TableColumn var5 = this.getColumnModel().getColumn(0);
      TableColumn var6 = this.getColumnModel().getColumn(1);
      TableColumn var7 = this.getColumnModel().getColumn(5);
      TableColumn var8 = this.getColumnModel().getColumn(3);
      var3.setMinWidth(60);
      var4.setMinWidth(75);
      var5.setMinWidth(40);
      var6.setMinWidth(40);
      var7.setMinWidth(75);
      var8.setMinWidth(60);
      var3.setPreferredWidth(200);
      var4.setPreferredWidth(75);
      var5.setPreferredWidth(60);
      var6.setPreferredWidth(60);
      var7.setPreferredWidth(75);
      var8.setPreferredWidth(200);
      SimilarityConfidenceCellRenderer var9 = new SimilarityConfidenceCellRenderer();
      var5.setCellRenderer(var9);
      var6.setCellRenderer(var9);
      BackgroundCellRenderer var10 = new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
      var3.setCellRenderer(var10);
      BackgroundCellRenderer var11 = new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
      var8.setCellRenderer(var11);
      PercentageThreeBarCellRenderer var12 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
      var4.setCellRenderer(var12);
      PercentageThreeBarCellRenderer var13 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
      var7.setCellRenderer(var13);
   }

   protected JPopupMenu getPopupMenu(int var1, int var2) {
      return new CallGraphViewsPopupMenu(this, var2);
   }

   protected void handleDoubleClick(int var1) {
      WorkspaceTabPanelFunctions var2 = this.getController();
      var2.openCallgraphView(var2.getMainWindow(), this.getDiff());
   }
}
