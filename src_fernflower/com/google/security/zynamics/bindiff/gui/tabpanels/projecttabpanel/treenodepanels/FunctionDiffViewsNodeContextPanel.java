package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel$InternalTableModelListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTableModel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;

public class FunctionDiffViewsNodeContextPanel extends AbstractTreeNodeContextPanel {
   private final FunctionDiffViewsTable functionDiffViewsTable;
   private final TableModelListener tableModelListener = new FunctionDiffViewsNodeContextPanel$InternalTableModelListener(this, (FunctionDiffViewsNodeContextPanel$1)null);

   public FunctionDiffViewsNodeContextPanel(WorkspaceTabPanelFunctions var1, List var2) {
      FunctionDiffViewsTableModel var3 = new FunctionDiffViewsTableModel(var2);
      this.functionDiffViewsTable = new FunctionDiffViewsTable(var3, var1);
      this.functionDiffViewsTable.getTableModel().addTableModelListener(this.tableModelListener);
      this.init();
   }

   private JPanel createTablePanel() {
      JScrollPane var1 = new JScrollPane(this.functionDiffViewsTable);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(var1, "Center");
      return var2;
   }

   private void init() {
      this.setBorder(new TitledBorder(""));
      this.add(this.createTablePanel(), "Center");
      this.updateBorderTitle();
   }

   private void updateBorderTitle() {
      ((TitledBorder)this.getBorder()).setTitle(String.format("%d Single Function Diff Views", new Object[]{Integer.valueOf(this.functionDiffViewsTable.getRowCount())}));
   }

   public void dispose() {
      this.functionDiffViewsTable.getTableModel().removeTableModelListener(this.tableModelListener);
   }

   public FunctionDiffViewsTableModel getFunctionViewsTableModel() {
      return (FunctionDiffViewsTableModel)this.functionDiffViewsTable.getTableModel();
   }

   public List getTables() {
      ArrayList var1 = new ArrayList();
      var1.add(this.functionDiffViewsTable);
      return var1;
   }

   // $FF: synthetic method
   static void access$100(FunctionDiffViewsNodeContextPanel var0) {
      var0.updateBorderTitle();
   }
}
