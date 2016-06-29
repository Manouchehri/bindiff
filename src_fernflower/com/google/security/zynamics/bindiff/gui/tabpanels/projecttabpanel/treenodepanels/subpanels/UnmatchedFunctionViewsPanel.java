package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel$InternalViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class UnmatchedFunctionViewsPanel extends JPanel {
   private final Diff diff;
   private final ESide side;
   private final UnmatchedFunctionViewsTable unmatchedFunctionsTable;
   private final UnmatchedFunctionViewsFilterPanel filterPanel;
   private final UnmatchedFunctionViewsPanel$InternalViewsTableListener tableListener = new UnmatchedFunctionViewsPanel$InternalViewsTableListener(this, (UnmatchedFunctionViewsPanel$1)null);
   private final UnmatchedFunctionViewsTableModel unmatchedFunctionsTableModel;

   public UnmatchedFunctionViewsPanel(Diff var1, WorkspaceTabPanelFunctions var2, ESide var3) {
      super(new BorderLayout());
      this.diff = (Diff)Preconditions.checkNotNull(var1);
      this.side = (ESide)Preconditions.checkNotNull(var3);
      this.unmatchedFunctionsTableModel = new UnmatchedFunctionViewsTableModel(var1, var3, true);
      this.unmatchedFunctionsTable = new UnmatchedFunctionViewsTable(this.unmatchedFunctionsTableModel, (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var2));
      this.filterPanel = new UnmatchedFunctionViewsFilterPanel(this.unmatchedFunctionsTable, var3);
      this.unmatchedFunctionsTable.addListener(this.tableListener);
      this.unmatchedFunctionsTableModel.addListener(this.tableListener);
      this.init();
   }

   private void init() {
      this.setBorder(new TitledBorder(""));
      this.updateBorderTitle();
      JScrollPane var1 = new JScrollPane(this.unmatchedFunctionsTable);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(this.filterPanel, "North");
      var2.add(var1, "Center");
      this.add(var2, "Center");
   }

   private void updateBorderTitle() {
      ((TitledBorder)this.getBorder()).setTitle(String.format("%d / %d %s Unmatched Functions", new Object[]{Integer.valueOf(this.unmatchedFunctionsTableModel.getRowCount()), Integer.valueOf(this.diff.getMatches().getSizeOfUnmatchedFunctions(this.side)), this.side == ESide.PRIMARY?"Primary":"Secondary"}));
      this.updateUI();
   }

   public List getTables() {
      ArrayList var1 = new ArrayList();
      var1.add(this.unmatchedFunctionsTable);
      return var1;
   }

   // $FF: synthetic method
   static void access$100(UnmatchedFunctionViewsPanel var0) {
      var0.updateBorderTitle();
   }
}
