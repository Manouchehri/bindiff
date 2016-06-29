package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.IconCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable$InternalSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.FlowGraphViewsTablePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.BackgroundCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.FunctionTypeCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.PercentageThreeBarCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.SimilarityConfidenceCellRenderer;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import javax.swing.JPopupMenu;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MatchedFunctionViewsTable extends AbstractTable {
   private final ListenerProvider listeners = new ListenerProvider();
   private final MatchedFunctionViewsTable$InternalSelectionListener selectionListener = new MatchedFunctionViewsTable$InternalSelectionListener(this, (MatchedFunctionViewsTable$1)null);

   public MatchedFunctionViewsTable(AbstractTableModel var1, WorkspaceTabPanelFunctions var2) {
      super(var1, var2);
      this.sortColumn(1, -1);
      this.sortColumn(5, 1);
      this.sortColumn(2, 1);
      this.sortColumn(3, 1);
      this.init();
      this.getSelectionModel().addListSelectionListener(this.selectionListener);
   }

   private void init() {
      TableColumnModel var1 = this.getColumnModel();
      TableColumn var2 = var1.getColumn(0);
      TableColumn var3 = var1.getColumn(3);
      TableColumn var4 = var1.getColumn(4);
      TableColumn var5 = var1.getColumn(5);
      TableColumn var6 = var1.getColumn(9);
      TableColumn var7 = var1.getColumn(1);
      TableColumn var8 = var1.getColumn(2);
      TableColumn var9 = var1.getColumn(10);
      TableColumn var10 = var1.getColumn(8);
      TableColumn var11 = var1.getColumn(7);
      TableColumn var12 = var1.getColumn(6);
      var2.setMinWidth(18);
      var3.setMinWidth(68);
      var4.setMinWidth(55);
      var5.setMinWidth(35);
      var6.setMinWidth(75);
      var7.setMinWidth(40);
      var8.setMinWidth(40);
      var9.setMinWidth(75);
      var10.setMinWidth(35);
      var11.setMinWidth(55);
      var12.setMinWidth(68);
      var2.setMaxWidth(18);
      var2.setPreferredWidth(18);
      var3.setPreferredWidth(60);
      var4.setPreferredWidth(200);
      var5.setPreferredWidth(35);
      var6.setPreferredWidth(75);
      var7.setPreferredWidth(60);
      var8.setPreferredWidth(60);
      var9.setPreferredWidth(75);
      var10.setPreferredWidth(35);
      var11.setPreferredWidth(200);
      var12.setPreferredWidth(60);
      IconCellRenderer var13 = new IconCellRenderer();
      var2.setCellRenderer(var13);
      SimilarityConfidenceCellRenderer var14 = new SimilarityConfidenceCellRenderer();
      var7.setCellRenderer(var14);
      var8.setCellRenderer(var14);
      BackgroundCellRenderer var15 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
      var3.setCellRenderer(var15);
      var4.setCellRenderer(var15);
      BackgroundCellRenderer var16 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
      var12.setCellRenderer(var16);
      var11.setCellRenderer(var16);
      FunctionTypeCellRenderer var17 = new FunctionTypeCellRenderer();
      var5.setCellRenderer(var17);
      var10.setCellRenderer(var17);
      PercentageThreeBarCellRenderer var18 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
      var6.setCellRenderer(var18);
      PercentageThreeBarCellRenderer var19 = new PercentageThreeBarCellRenderer(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.TABLE_CELL_SECONDARY_UNMATCHED_BACKGROUND, Colors.TABLE_CELL_MATCHED_BACKGROUND, Colors.GRAY32);
      var9.setCellRenderer(var19);
   }

   protected JPopupMenu getPopupMenu(int var1, int var2) {
      return new FlowGraphViewsTablePopupMenu(this, var1, var2);
   }

   protected void handleDoubleClick(int var1) {
      CAddress var2 = new CAddress((String)this.getTableModel().getValueAt(var1, 3), 16);
      CAddress var3 = new CAddress((String)this.getTableModel().getValueAt(var1, 6), 16);
      this.getController().openFlowgraphView(this.getController().getMainWindow(), this.getDiff(), var2, var3);
   }

   public void addListener(IMatchedFunctionsViewsTableListener var1) {
      this.listeners.addListener(var1);
   }

   public void dispose() {
      this.getSelectionModel().removeListSelectionListener(this.selectionListener);
   }

   public void removeListener(IMatchedFunctionsViewsTableListener var1) {
      this.listeners.removeListener(var1);
   }

   // $FF: synthetic method
   static ListenerProvider access$100(MatchedFunctionViewsTable var0) {
      return var0.listeners;
   }
}
