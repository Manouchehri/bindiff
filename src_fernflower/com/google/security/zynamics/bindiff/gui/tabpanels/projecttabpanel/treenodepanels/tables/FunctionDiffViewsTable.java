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
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

public class FunctionDiffViewsTable extends AbstractTable {
   public FunctionDiffViewsTable(AbstractTableModel var1, WorkspaceTabPanelFunctions var2) {
      super(var1, var2);
      this.init();
   }

   private void init() {
      TableColumn var1 = this.getColumnModel().getColumn(0);
      TableColumn var2 = this.getColumnModel().getColumn(3);
      TableColumn var3 = this.getColumnModel().getColumn(4);
      TableColumn var4 = this.getColumnModel().getColumn(7);
      TableColumn var5 = this.getColumnModel().getColumn(1);
      TableColumn var6 = this.getColumnModel().getColumn(2);
      TableColumn var7 = this.getColumnModel().getColumn(8);
      TableColumn var8 = this.getColumnModel().getColumn(6);
      TableColumn var9 = this.getColumnModel().getColumn(5);
      var1.setMinWidth(80);
      var2.setMinWidth(68);
      var3.setMinWidth(50);
      var4.setMinWidth(75);
      var5.setMinWidth(40);
      var6.setMinWidth(40);
      var7.setMinWidth(75);
      var8.setMinWidth(50);
      var9.setMinWidth(68);
      var1.setPreferredWidth(300);
      var2.setPreferredWidth(60);
      var3.setPreferredWidth(150);
      var4.setPreferredWidth(75);
      var5.setPreferredWidth(60);
      var6.setPreferredWidth(60);
      var7.setPreferredWidth(75);
      var8.setPreferredWidth(150);
      var9.setPreferredWidth(60);
      SimilarityConfidenceCellRenderer var10 = new SimilarityConfidenceCellRenderer();
      var5.setCellRenderer(var10);
      var6.setCellRenderer(var10);
      BackgroundCellRenderer var11 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
      var1.setCellRenderer(var11);
      BackgroundCellRenderer var12 = new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
      var2.setCellRenderer(var12);
      var3.setCellRenderer(var12);
      BackgroundCellRenderer var13 = new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
      var9.setCellRenderer(var13);
      var8.setCellRenderer(var13);
      PercentageThreeBarCellRenderer var14 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
      var4.setCellRenderer(var14);
      PercentageThreeBarCellRenderer var15 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
      var7.setCellRenderer(var15);
   }

   protected JPopupMenu getPopupMenu(int var1, int var2) {
      return new FunctionDiffFlowGraphsViewTablePopupMenu(this, var1, var2);
   }

   protected void handleDoubleClick(int var1) {
      Diff var2 = ((FunctionDiffViewsTableModel)this.getTableModel()).getDiffAt(var1);
      WorkspaceTabPanelFunctions var3 = this.getController();
      var3.openFunctionDiffView((MainWindow)SwingUtilities.getWindowAncestor(this), var2);
   }

   public void addRow(Diff var1) {
      ((FunctionDiffViewsTableModel)this.getTableModel()).addRow(var1);
      this.updateUI();
   }

   public void removeRow(Diff var1) {
      ((FunctionDiffViewsTableModel)this.getTableModel()).removeRow(var1);
      this.updateUI();
   }
}
