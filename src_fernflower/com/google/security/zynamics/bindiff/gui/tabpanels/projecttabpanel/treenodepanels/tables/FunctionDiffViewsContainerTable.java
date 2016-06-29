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
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

public class FunctionDiffViewsContainerTable extends AbstractTable {
   public FunctionDiffViewsContainerTable(AbstractTableModel var1, WorkspaceTabPanelFunctions var2) {
      super(var1, var2);
      this.init();
   }

   private void init() {
      TableColumn var1 = this.getColumnModel().getColumn(0);
      TableColumn var2 = this.getColumnModel().getColumn(1);
      TableColumn var3 = this.getColumnModel().getColumn(2);
      TableColumn var4 = this.getColumnModel().getColumn(3);
      TableColumn var5 = this.getColumnModel().getColumn(4);
      TableColumn var6 = this.getColumnModel().getColumn(5);
      var1.setMinWidth(100);
      var2.setMinWidth(100);
      var3.setMinWidth(100);
      var4.setMinWidth(100);
      var5.setMinWidth(200);
      var6.setMinWidth(120);
      var1.setPreferredWidth(100);
      var2.setPreferredWidth(100);
      var3.setPreferredWidth(100);
      var4.setPreferredWidth(100);
      var5.setPreferredWidth(300);
      var6.setPreferredWidth(120);
      BackgroundCellRenderer var7 = new BackgroundCellRenderer(Colors.TABLE_CELL_PRIMARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
      var1.setCellRenderer(var7);
      var2.setCellRenderer(var7);
      BackgroundCellRenderer var8 = new BackgroundCellRenderer(Colors.TABLE_CELL_SECONDARY_DEFAULT_BACKGROUND, Colors.GRAY32, 2);
      var3.setCellRenderer(var8);
      var4.setCellRenderer(var8);
      BackgroundCellRenderer var9 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
      var5.setCellRenderer(var9);
      var6.setCellRenderer(var9);
   }

   protected JPopupMenu getPopupMenu(int var1, int var2) {
      return new FunctionDiffFlowGraphsViewTablePopupMenu(this, var1, var2);
   }

   protected void handleDoubleClick(int var1) {
      Diff var2 = ((FunctionDiffViewsContainerTableModel)this.getTableModel()).getDiffAt(var1);
      WorkspaceTabPanelFunctions var3 = this.getController();
      var3.openFunctionDiffView((MainWindow)SwingUtilities.getWindowAncestor(this), var2);
   }

   public void addRow(Diff var1) {
      ((FunctionDiffViewsContainerTableModel)this.getTableModel()).addRow(var1);
      this.updateUI();
   }

   public void removeRow(Diff var1) {
      ((FunctionDiffViewsContainerTableModel)this.getTableModel()).removeRow(var1);
      this.updateUI();
   }
}
