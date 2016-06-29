package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable$InternalSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.FlowGraphViewsTablePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.BackgroundCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.FunctionTypeCellRenderer;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import javax.swing.JPopupMenu;
import javax.swing.table.TableColumn;

public class UnmatchedFunctionViewsTable extends AbstractTable {
   private final ListenerProvider listeners = new ListenerProvider();
   private final UnmatchedFunctionViewsTable$InternalSelectionListener selectionListener = new UnmatchedFunctionViewsTable$InternalSelectionListener(this, (UnmatchedFunctionViewsTable$1)null);
   private final ESide side;

   public UnmatchedFunctionViewsTable(UnmatchedFunctionViewsTableModel var1, WorkspaceTabPanelFunctions var2) {
      super(var1, var2);
      this.sortColumn(2, 1);
      this.sortColumn(0, 1);
      this.side = var1.getSide();
      this.init();
      this.getSelectionModel().addListSelectionListener(this.selectionListener);
   }

   private void init() {
      TableColumn var1 = this.getColumnModel().getColumn(0);
      TableColumn var2 = this.getColumnModel().getColumn(1);
      TableColumn var3 = this.getColumnModel().getColumn(2);
      TableColumn var4 = this.getColumnModel().getColumn(6);
      TableColumn var5 = this.getColumnModel().getColumn(7);
      TableColumn var6 = this.getColumnModel().getColumn(3);
      TableColumn var7 = this.getColumnModel().getColumn(4);
      TableColumn var8 = this.getColumnModel().getColumn(5);
      var1.setMinWidth(60);
      var2.setMinWidth(55);
      var3.setMinWidth(35);
      var4.setMinWidth(40);
      var5.setMinWidth(75);
      var6.setMinWidth(40);
      var7.setMinWidth(40);
      var8.setMinWidth(40);
      var1.setPreferredWidth(60);
      var2.setPreferredWidth(200);
      var3.setPreferredWidth(35);
      var4.setPreferredWidth(50);
      var5.setPreferredWidth(75);
      var6.setPreferredWidth(50);
      var7.setPreferredWidth(50);
      var8.setPreferredWidth(50);
      BackgroundCellRenderer var9 = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
      var1.setCellRenderer(var9);
      var2.setCellRenderer(var9);
      var3.setCellRenderer(new FunctionTypeCellRenderer());
      var4.setCellRenderer(var9);
      var6.setCellRenderer(var9);
      var7.setCellRenderer(var9);
      var8.setCellRenderer(var9);
      var5.setCellRenderer(var9);
   }

   protected JPopupMenu getPopupMenu(int var1, int var2) {
      return new FlowGraphViewsTablePopupMenu(this, var1, var2);
   }

   protected void handleDoubleClick(int var1) {
      CAddress var2 = null;
      CAddress var3 = null;
      if(this.side == ESide.PRIMARY) {
         var2 = new CAddress((String)this.getTableModel().getValueAt(var1, 0), 16);
      } else {
         var3 = new CAddress((String)this.getTableModel().getValueAt(var1, 0), 16);
      }

      this.getController().openFlowgraphView(this.getController().getMainWindow(), this.getDiff(), var2, var3);
   }

   public void addListener(IUnmatchedFunctionsViewsTableListener var1) {
      this.listeners.addListener(var1);
   }

   public ESide getSide() {
      return this.side;
   }

   public void removeListener(IUnmatchedFunctionsViewsTableListener var1) {
      this.listeners.removeListener(var1);
   }

   // $FF: synthetic method
   static ListenerProvider access$100(UnmatchedFunctionViewsTable var0) {
      return var0.listeners;
   }
}
