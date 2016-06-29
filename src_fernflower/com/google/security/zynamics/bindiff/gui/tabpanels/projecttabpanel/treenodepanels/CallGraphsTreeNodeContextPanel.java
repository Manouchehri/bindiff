package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedLabel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarLabel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.CallGraphViewTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.CallGraphViewTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CallGraphsTreeNodeContextPanel extends AbstractTreeNodeContextPanel {
   private static final int TEXTFIELDHEIGHT = 25;
   private static final int TEXTFIELDLABELWIDTH = 100;
   private final Diff diff;
   private final CallGraphViewTable callgraphTable;
   private final CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener countsChangeListener = new CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(this, (CallGraphsTreeNodeContextPanel$1)null);
   private PercentageTwoBarExtendedLabel primaryFunctions;
   private PercentageTwoBarExtendedLabel secondaryFunctions;
   private PercentageTwoBarExtendedLabel primaryCalls;
   private PercentageTwoBarExtendedLabel secondaryCalls;
   private PercentageTwoBarLabel primaryBasicblocks;
   private PercentageTwoBarLabel secondaryBasicblocks;
   private PercentageTwoBarLabel primaryJumps;
   private PercentageTwoBarLabel secondaryJumps;
   private PercentageTwoBarLabel primaryInstructions;
   private PercentageTwoBarLabel secondaryInstructions;

   public CallGraphsTreeNodeContextPanel(Diff var1, WorkspaceTabPanelFunctions var2) {
      Preconditions.checkNotNull(var1);
      this.diff = var1;
      this.callgraphTable = new CallGraphViewTable(new CallGraphViewTableModel(var1), var2);
      this.init();
      var1.getMetaData().addListener(this.countsChangeListener);
   }

   private JPanel createChartsPanel() {
      JPanel var1 = new JPanel(new BorderLayout(0, 0));
      var1.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
      JPanel var2 = new JPanel(new GridLayout(2, 3, 0, 0));
      var2.setBackground(Color.WHITE);
      var1.add(var2, "Center");
      var2.add(new FunctionMatchesPie3dPanel(this.diff));
      var2.add(new CallMatchesPie3dPanel(this.diff));
      var2.add(new SimilarityBarChart2dPanel(this.diff.getDiffMetaData()));
      var2.add(new BasicBlockMatchesPie3dPanel(this.diff, true));
      var2.add(new JumpMatchesPie3dPanel(this.diff, true));
      var2.add(new InstructionMatchesPie3dPanel(this.diff, true));
      return var1;
   }

   private JPanel createInfoPanel() {
      MatchData var1 = this.diff.getMatches();
      int var2 = var1.getSizeOfMatchedFunctions();
      int var3 = var1.getSizeOfChangedFunctions();
      int var4 = var1.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
      int var5 = var1.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
      PercentageTwoBarExtendedCellData var6 = new PercentageTwoBarExtendedCellData(var2, var3, var4);
      PercentageTwoBarExtendedCellData var7 = new PercentageTwoBarExtendedCellData(var2, var3, var5);
      this.primaryFunctions = new PercentageTwoBarExtendedLabel(var6, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
      this.secondaryFunctions = new PercentageTwoBarExtendedLabel(var7, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
      int var8 = var1.getSizeOfMatchedCalls();
      int var9 = var1.getSizeOfChangedCalls();
      int var10 = var1.getSizeOfUnmatchedCalls(ESide.PRIMARY);
      int var11 = var1.getSizeOfUnmatchedCalls(ESide.SECONDARY);
      PercentageTwoBarExtendedCellData var12 = new PercentageTwoBarExtendedCellData(var8, var9, var10);
      PercentageTwoBarExtendedCellData var13 = new PercentageTwoBarExtendedCellData(var8, var9, var11);
      this.primaryCalls = new PercentageTwoBarExtendedLabel(var12, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
      this.secondaryCalls = new PercentageTwoBarExtendedLabel(var13, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
      int var14 = var1.getSizeOfMatchedBasicblocks();
      int var15 = var1.getSizeOfUnmatchedBasicblocks(ESide.PRIMARY);
      int var16 = var1.getSizeOfUnmatchedBasicblocks(ESide.SECONDARY);
      PercentageTwoBarCellData var17 = new PercentageTwoBarCellData(var14, var15);
      PercentageTwoBarCellData var18 = new PercentageTwoBarCellData(var14, var16);
      this.primaryBasicblocks = new PercentageTwoBarLabel(var17, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
      this.secondaryBasicblocks = new PercentageTwoBarLabel(var18, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
      int var19 = var1.getSizeOfMatchedJumps();
      int var20 = var1.getSizeOfUnmatchedJumps(ESide.PRIMARY);
      int var21 = var1.getSizeOfUnmatchedJumps(ESide.SECONDARY);
      PercentageTwoBarCellData var22 = new PercentageTwoBarCellData(var19, var20);
      PercentageTwoBarCellData var23 = new PercentageTwoBarCellData(var19, var21);
      this.primaryJumps = new PercentageTwoBarLabel(var22, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
      this.secondaryJumps = new PercentageTwoBarLabel(var23, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
      int var24 = var1.getSizeOfMatchedInstructions();
      int var25 = var1.getSizeOfUnmatchedInstructions(ESide.PRIMARY);
      int var26 = var1.getSizeOfUnmatchedInstructions(ESide.SECONDARY);
      PercentageTwoBarCellData var27 = new PercentageTwoBarCellData(var24, var25);
      PercentageTwoBarCellData var28 = new PercentageTwoBarCellData(var24, var26);
      this.primaryInstructions = new PercentageTwoBarLabel(var27, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
      this.secondaryInstructions = new PercentageTwoBarLabel(var28, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
      JLabel var29 = new JLabel(this.diff.getMetaData().getImageName(ESide.PRIMARY));
      JLabel var30 = new JLabel(this.diff.getMetaData().getImageName(ESide.SECONDARY));
      JPanel var31 = new JPanel(new GridLayout(1, 2, 2, 2));
      JPanel var32 = new JPanel(new BorderLayout());
      var32.setBorder(new TitledBorder("Primary Call Graph"));
      JPanel var33 = new JPanel(new GridLayout(6, 1, 2, 2));
      var33.setBorder(new LineBorder(Color.GRAY));
      var33.setBackground(Color.WHITE);
      var33.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, (JLabel)var29, 25));
      var33.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, (JLabel)this.primaryFunctions, 25));
      var33.add(GuiUtils.createHorizontalNamedLabelPanel("Calls", 100, (JLabel)this.primaryCalls, 25));
      var33.add(GuiUtils.createHorizontalNamedLabelPanel("Basic Blocks", 100, (JLabel)this.primaryBasicblocks, 25));
      var33.add(GuiUtils.createHorizontalNamedLabelPanel("Jumps", 100, (JLabel)this.primaryJumps, 25));
      var33.add(GuiUtils.createHorizontalNamedLabelPanel("Instructions", 100, (JLabel)this.primaryInstructions, 25));
      var32.add(var33, "Center");
      JPanel var34 = new JPanel(new BorderLayout());
      var34.setBorder(new TitledBorder("Secondary Call Graph"));
      JPanel var35 = new JPanel(new GridLayout(6, 1, 2, 2));
      var35.setBorder(new LineBorder(Color.GRAY));
      var35.setBackground(Color.WHITE);
      var35.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, (JLabel)var30, 25));
      var35.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, (JLabel)this.secondaryFunctions, 25));
      var35.add(GuiUtils.createHorizontalNamedLabelPanel("Calls", 100, (JLabel)this.secondaryCalls, 25));
      var35.add(GuiUtils.createHorizontalNamedLabelPanel("Basic Blocks", 100, (JLabel)this.secondaryBasicblocks, 25));
      var35.add(GuiUtils.createHorizontalNamedLabelPanel("Jumps", 100, (JLabel)this.secondaryJumps, 25));
      var35.add(GuiUtils.createHorizontalNamedLabelPanel("Instructions", 100, (JLabel)this.secondaryInstructions, 25));
      var34.add(var35, "Center");
      var31.add(var32);
      var31.add(var34);
      return var31;
   }

   private JPanel createTablePanel() {
      this.callgraphTable.setPreferredSize(new Dimension(this.callgraphTable.getPreferredSize().width, 40));
      JScrollPane var1 = new JScrollPane(this.callgraphTable);
      var1.setVerticalScrollBarPolicy(21);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new TitledBorder(String.format("%d Call Graph View", new Object[]{Integer.valueOf(1)})));
      var2.add(var1, "Center");
      var2.setPreferredSize(new Dimension(var2.getPreferredSize().width, 60));
      return var2;
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(this.createChartsPanel(), "North");
      var1.add(this.createInfoPanel(), "Center");
      var1.add(this.createTablePanel(), "South");
      this.add(var1, "North");
   }

   public void dipose() {
      this.diff.getMetaData().removeListener(this.countsChangeListener);
   }

   public List getTables() {
      ArrayList var1 = new ArrayList();
      var1.add(this.callgraphTable);
      return var1;
   }

   // $FF: synthetic method
   static Diff access$100(CallGraphsTreeNodeContextPanel var0) {
      return var0.diff;
   }

   // $FF: synthetic method
   static PercentageTwoBarLabel access$200(CallGraphsTreeNodeContextPanel var0) {
      return var0.primaryBasicblocks;
   }

   // $FF: synthetic method
   static PercentageTwoBarLabel access$300(CallGraphsTreeNodeContextPanel var0) {
      return var0.secondaryBasicblocks;
   }

   // $FF: synthetic method
   static PercentageTwoBarExtendedLabel access$400(CallGraphsTreeNodeContextPanel var0) {
      return var0.primaryCalls;
   }

   // $FF: synthetic method
   static PercentageTwoBarExtendedLabel access$500(CallGraphsTreeNodeContextPanel var0) {
      return var0.secondaryCalls;
   }

   // $FF: synthetic method
   static PercentageTwoBarExtendedLabel access$600(CallGraphsTreeNodeContextPanel var0) {
      return var0.primaryFunctions;
   }

   // $FF: synthetic method
   static PercentageTwoBarExtendedLabel access$700(CallGraphsTreeNodeContextPanel var0) {
      return var0.secondaryFunctions;
   }

   // $FF: synthetic method
   static PercentageTwoBarLabel access$800(CallGraphsTreeNodeContextPanel var0) {
      return var0.primaryInstructions;
   }

   // $FF: synthetic method
   static PercentageTwoBarLabel access$900(CallGraphsTreeNodeContextPanel var0) {
      return var0.secondaryInstructions;
   }

   // $FF: synthetic method
   static PercentageTwoBarLabel access$1000(CallGraphsTreeNodeContextPanel var0) {
      return var0.primaryJumps;
   }

   // $FF: synthetic method
   static PercentageTwoBarLabel access$1100(CallGraphsTreeNodeContextPanel var0) {
      return var0.secondaryJumps;
   }
}
