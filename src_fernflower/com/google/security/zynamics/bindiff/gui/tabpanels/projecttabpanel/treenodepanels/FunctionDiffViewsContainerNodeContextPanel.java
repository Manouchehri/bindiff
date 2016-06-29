package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTableModel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;

public class FunctionDiffViewsContainerNodeContextPanel extends AbstractTreeNodeContextPanel {
   private final FunctionDiffViewsContainerTable allFunctionDiffsViewsTable;
   private final TableModelListener tableModelListener = new FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener(this, (FunctionDiffViewsContainerNodeContextPanel$1)null);

   public FunctionDiffViewsContainerNodeContextPanel(WorkspaceTabPanelFunctions var1) {
      List var2 = ((WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1)).getWorkspace().getDiffList(true);
      FunctionDiffViewsContainerTableModel var3 = new FunctionDiffViewsContainerTableModel(var2);
      this.allFunctionDiffsViewsTable = new FunctionDiffViewsContainerTable(var3, var1);
      var3.addTableModelListener(this.tableModelListener);
      this.init();
   }

   private JPanel createTablePanel() {
      JScrollPane var1 = new JScrollPane(this.allFunctionDiffsViewsTable);
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
      ((TitledBorder)this.getBorder()).setTitle(String.format("%d Single Function Diff Views", new Object[]{Integer.valueOf(this.allFunctionDiffsViewsTable.getRowCount())}));
   }

   public void dispose() {
      this.allFunctionDiffsViewsTable.getTableModel().removeTableModelListener(this.tableModelListener);
   }

   public List getTables() {
      ArrayList var1 = new ArrayList();
      var1.add(this.allFunctionDiffsViewsTable);
      return var1;
   }

   // $FF: synthetic method
   static void access$100(FunctionDiffViewsContainerNodeContextPanel var0) {
      var0.updateBorderTitle();
   }
}
