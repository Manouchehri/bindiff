package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.AddedAndRemovedCalledFunctionsPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MatchedFunctionsTreeNodeContextPanel extends AbstractTreeNodeContextPanel {
   private final Diff diff;
   private final JPanel tablePanel = new JPanel(new BorderLayout());
   private JPanel overviewPanel = new JPanel(new BorderLayout());
   private final MatchedFunctionViewsFilterPanel filterPanel;
   private final AddedAndRemovedCalledFunctionsPanel callerAndCallesPanel;
   private final JumpMatchesPie3dPanel jumpsPiePanel;
   private final BasicBlockMatchesPie3dPanel basicblocksPiePanel;
   private final InstructionMatchesPie3dPanel instructionsPiePanel;
   private final SimilarityBarChart2dPanel similarityBarChartPanel;
   private final MatchedFunctionsViewsTableModel matchedFunctionsTableModel;
   private final MatchedFunctionViewsTable matchedFunctionsTable;
   private final MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener tableListener = new MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener(this, (MatchedFunctionsTreeNodeContextPanel$1)null);
   private final MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener filterCheckboxListener = new MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener(this, (MatchedFunctionsTreeNodeContextPanel$1)null);
   private final MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener countsChangeListener = new MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(this, (MatchedFunctionsTreeNodeContextPanel$1)null);

   public MatchedFunctionsTreeNodeContextPanel(WorkspaceTabPanelFunctions var1, Diff var2) {
      Preconditions.checkNotNull(var2);
      this.diff = var2;
      this.basicblocksPiePanel = new BasicBlockMatchesPie3dPanel(var2, false);
      this.jumpsPiePanel = new JumpMatchesPie3dPanel(var2, false);
      this.instructionsPiePanel = new InstructionMatchesPie3dPanel(var2, false);
      this.similarityBarChartPanel = new SimilarityBarChart2dPanel(var2.getMetaData());
      this.matchedFunctionsTableModel = new MatchedFunctionsViewsTableModel(var2, true);
      this.matchedFunctionsTable = new MatchedFunctionViewsTable(this.matchedFunctionsTableModel, var1);
      this.filterPanel = new MatchedFunctionViewsFilterPanel(this.matchedFunctionsTable);
      this.callerAndCallesPanel = new AddedAndRemovedCalledFunctionsPanel(var2, var1, this.matchedFunctionsTable);
      this.filterPanel.addListener(this.filterCheckboxListener);
      this.matchedFunctionsTable.addListener(this.tableListener);
      this.matchedFunctionsTableModel.addListener(this.tableListener);
      var2.getMetaData().addListener(this.countsChangeListener);
      this.initComponents();
      this.updateCharts(this.matchedFunctionsTable);
   }

   private JPanel createOverviewPanel() {
      JPanel var1 = new JPanel(new BorderLayout(0, 0));
      var1.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
      JPanel var2 = new JPanel(new GridLayout(1, 4, 0, 0));
      var1.add(var2, "Center");
      var2.add(this.basicblocksPiePanel);
      var2.add(this.jumpsPiePanel);
      var2.add(this.instructionsPiePanel);
      var2.add(this.similarityBarChartPanel);
      return var1;
   }

   private JPanel createTablePanel() {
      JScrollPane var1 = new JScrollPane(this.matchedFunctionsTable);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(var1, "Center");
      return var2;
   }

   private void initComponents() {
      this.tablePanel.setBorder(new TitledBorder(""));
      this.overviewPanel = this.createOverviewPanel();
      this.updateBorderTitle();
      JSplitPane var1 = new JSplitPane(0, true);
      var1.setBorder((Border)null);
      var1.setOneTouchExpandable(true);
      var1.setDividerLocation(200);
      JSplitPane var2 = new JSplitPane(0, true);
      var2.setBorder((Border)null);
      var2.setOneTouchExpandable(true);
      var2.setResizeWeight(1.0D);
      var2.setDividerLocation(0.7D);
      this.tablePanel.add(this.filterPanel, "North");
      this.tablePanel.add(this.createTablePanel(), "Center");
      var1.setTopComponent(this.overviewPanel);
      var1.setBottomComponent(var2);
      var2.setTopComponent(this.tablePanel);
      var2.setBottomComponent(this.callerAndCallesPanel);
      this.add(var1, "Center");
   }

   private void updateBorderTitle() {
      ((TitledBorder)this.tablePanel.getBorder()).setTitle(String.format("%d / %d Matched Functions", new Object[]{Integer.valueOf(this.matchedFunctionsTable.getRowCount()), Integer.valueOf(this.diff.getMatches().getSizeOfMatchedFunctions())}));
      this.updateUI();
   }

   private void updateCharts(MatchedFunctionViewsTable var1) {
      Vector var2 = new Vector();
      Vector var3 = new Vector();
      int[] var4 = var1.getSelectedRows();
      int var5;
      if(var4.length == 0) {
         var4 = new int[var1.getRowCount()];

         for(var5 = 0; var5 < var1.getRowCount(); var4[var5] = var5++) {
            ;
         }
      }

      var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      int var12 = 0;
      int var13 = 0;
      int[] var14 = var4;
      int var15 = var4.length;

      for(int var16 = 0; var16 < var15; ++var16) {
         int var17 = var14[var16];
         String var18 = (String)var1.getValueAt(var17, var1.convertColumnIndexToView(3));
         CAddress var19 = new CAddress(var18, 16);
         String var20 = (String)var1.getValueAt(var17, var1.convertColumnIndexToView(6));
         CAddress var21 = new CAddress(var20, 16);
         RawFunction var22 = this.diff.getFunction(var19, ESide.PRIMARY);
         RawFunction var23 = this.diff.getFunction(var21, ESide.SECONDARY);
         var5 += var22.getSizeOfMatchedBasicblocks();
         var6 += var22.getSizeOfUnmatchedBasicblocks();
         var7 += var23.getSizeOfUnmatchedBasicblocks();
         var8 += var22.getSizeOfMatchedJumps();
         var9 += var22.getSizeOfUnmatchedJumps();
         var10 += var23.getSizeOfUnmatchedJumps();
         var11 += var22.getSizeOfMatchedInstructions();
         var12 += var22.getSizeOfUnmatchedInstructions();
         var13 += var23.getSizeOfUnmatchedInstructions();
         FunctionMatchData var24 = var22.getFunctionMatch();
         var2.add(Double.valueOf(var24.getSimilarity()));
         var3.add(Double.valueOf(var24.getConfidence()));
      }

      this.basicblocksPiePanel.updateDataset(var5, var6, var7);
      this.jumpsPiePanel.updateDataset(var8, var9, var10);
      this.instructionsPiePanel.updateDataset(var11, var12, var13);
      this.similarityBarChartPanel.updateDataset(var2);
   }

   public void dispose() {
      this.matchedFunctionsTable.removeListener(this.tableListener);
      this.filterPanel.removeListener(this.filterCheckboxListener);
      this.matchedFunctionsTable.dispose();
      this.diff.getMetaData().removeListener(this.countsChangeListener);
   }

   public List getTables() {
      ArrayList var1 = new ArrayList();
      var1.add(this.matchedFunctionsTable);
      return var1;
   }

   // $FF: synthetic method
   static Diff access$300(MatchedFunctionsTreeNodeContextPanel var0) {
      return var0.diff;
   }

   // $FF: synthetic method
   static MatchedFunctionViewsTable access$400(MatchedFunctionsTreeNodeContextPanel var0) {
      return var0.matchedFunctionsTable;
   }

   // $FF: synthetic method
   static void access$500(MatchedFunctionsTreeNodeContextPanel var0, MatchedFunctionViewsTable var1) {
      var0.updateCharts(var1);
   }

   // $FF: synthetic method
   static void access$600(MatchedFunctionsTreeNodeContextPanel var0) {
      var0.updateBorderTitle();
   }
}
