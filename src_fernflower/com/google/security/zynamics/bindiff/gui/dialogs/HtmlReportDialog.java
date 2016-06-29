package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.components.LimitedTextField;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class HtmlReportDialog extends BaseDialog {
   private static int DIALOG_WIDTH = 425;
   private static int DIALOG_HEIGHT = 560;
   private static int COMMENTPANEL_HEIGHT = 100;
   private final JTextField headline = new JTextField("HTML Report");
   private final LimitedTextField comment = new LimitedTextField("");
   private final JCheckBox showCharts = new JCheckBox("Show charts");
   private final JCheckBox showStatsTable = new JCheckBox("Show stats table");
   private final JCheckBox showMatchedFunctionsList = new JCheckBox("Show matched functions list");
   private final JCheckBox showPrimaryUnmatchedFunctionsList = new JCheckBox("Show primary unmatched functions list");
   private final JCheckBox showSecondaryUnmatchedFunctionsList = new JCheckBox("Show secondary unmatched functions list");
   private final JCheckBox showMatchedFunctionsIdenticalBasicblocks = new JCheckBox("Show identical basicblocks (of matched functions)");
   private final JCheckBox showMatchedFunctionsChangedBasicblocks = new JCheckBox("Show changed basicblocks (of matched functions)");
   private final JCheckBox showMatchedFunctionsUnmatchedBasicblocks = new JCheckBox("Show unmatched basicblocks of matched functions");
   private final JCheckBox showPrimaryUnmatchedFunctionsBasicblocks = new JCheckBox("Show primary basicblocks of unmatched functions");
   private final JCheckBox showSecondaryUnmatchedFunctionsBasicblocks = new JCheckBox("Show secondary basicblocks of unmatched functions");
   private final String fileNameAddition;

   public HtmlReportDialog(WorkspaceTabPanelFunctions var1, Window var2, Diff var3) {
      super(var2, "HTML Report");
      this.fileNameAddition = "BinDiff HTML Report";
      this.init();
      this.pack();
      GuiHelper.centerChildToParent(var2, this, true);
   }

   public HtmlReportDialog(WorkspaceTabPanelFunctions var1, Window var2, Diff var3, String var4, String var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13, boolean var14, boolean var15) {
      super(var2, "HTML Report");
      this.fileNameAddition = var4;
      this.init();
      this.pack();
      GuiHelper.centerChildToParent(var2, this, true);
      this.headline.setText(var5);
      this.showCharts.setSelected(var6);
      this.showStatsTable.setSelected(var7);
      this.showMatchedFunctionsList.setSelected(var8);
      this.showPrimaryUnmatchedFunctionsList.setSelected(var9);
      this.showSecondaryUnmatchedFunctionsList.setSelected(var10);
      this.showMatchedFunctionsIdenticalBasicblocks.setSelected(var11);
      this.showMatchedFunctionsChangedBasicblocks.setSelected(var12);
      this.showMatchedFunctionsUnmatchedBasicblocks.setSelected(var13);
      this.showPrimaryUnmatchedFunctionsBasicblocks.setSelected(var14);
      this.showSecondaryUnmatchedFunctionsBasicblocks.setSelected(var15);
   }

   private JPanel createBasicblocksPanel() {
      JPanel var1 = new JPanel(new GridLayout(5, 1));
      var1.setBorder(new TitledBorder("Basic Blocks"));
      var1.add(this.showMatchedFunctionsIdenticalBasicblocks);
      var1.add(this.showMatchedFunctionsChangedBasicblocks);
      var1.add(this.showMatchedFunctionsUnmatchedBasicblocks);
      var1.add(this.showPrimaryUnmatchedFunctionsBasicblocks);
      var1.add(this.showSecondaryUnmatchedFunctionsBasicblocks);
      return var1;
   }

   private JPanel createButtonsPanel() {
      JPanel var1 = new JPanel(new GridLayout(1, 2, 5, 5));
      return var1;
   }

   private JPanel createFunctionListsSettingsPanel() {
      JPanel var1 = new JPanel(new GridLayout(3, 1));
      var1.setBorder(new TitledBorder("Function Lists"));
      var1.add(this.showMatchedFunctionsList);
      var1.add(this.showPrimaryUnmatchedFunctionsList);
      var1.add(this.showSecondaryUnmatchedFunctionsList);
      return var1;
   }

   private JPanel createHeadlinePanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Headline"));
      var1.add(this.headline, "Center");
      return var1;
   }

   private JPanel createNotesPanel() {
      this.comment.setPreferredSize(new Dimension(this.comment.getPreferredSize().width, COMMENTPANEL_HEIGHT));
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Notes"));
      var1.add(new JScrollPane(this.comment));
      return var1;
   }

   private JPanel createStatsSettingsPanel() {
      JPanel var1 = new JPanel(new GridLayout(2, 1));
      var1.setBorder(new TitledBorder("Statistics"));
      var1.add(this.showCharts);
      var1.add(this.showStatsTable);
      return var1;
   }

   private void init() {
      this.setSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
      this.setMinimumSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
      JPanel var1 = new JPanel(new BorderLayout());
      JPanel var2 = this.createHeadlinePanel();
      JPanel var3 = this.createNotesPanel();
      JPanel var4 = this.createStatsSettingsPanel();
      JPanel var5 = this.createFunctionListsSettingsPanel();
      JPanel var6 = this.createBasicblocksPanel();
      JPanel var7 = this.createButtonsPanel();
      JPanel var8 = new JPanel(new BorderLayout());
      JPanel var9 = new JPanel(new BorderLayout());
      JPanel var10 = new JPanel(new BorderLayout());
      JPanel var11 = new JPanel(new BorderLayout());
      JPanel var12 = new JPanel(new BorderLayout());
      var8.add(var2, "North");
      var8.add(var9, "Center");
      var9.add(var3, "North");
      var9.add(var10, "Center");
      var10.add(var4, "North");
      var10.add(var11, "Center");
      var11.add(var5, "North");
      var11.add(var12, "Center");
      var12.add(var6, "North");
      var1.add(var8, "North");
      var1.add(var7, "South");
      this.getContentPane().add(var1);
   }

   public void dispose() {
      this.setVisible(false);
      super.dispose();
   }

   public String getComment() {
      return this.comment.getText();
   }

   public String getFileNameAddition() {
      return this.fileNameAddition;
   }

   public String getHeadline() {
      return this.headline.getText();
   }

   public boolean getShowChangedBasicblocks() {
      return this.showMatchedFunctionsChangedBasicblocks.isSelected();
   }

   public boolean getShowCharts() {
      return this.showCharts.isSelected();
   }

   public boolean getShowIdenticalBasicblocks() {
      return this.showMatchedFunctionsIdenticalBasicblocks.isSelected();
   }

   public boolean getShowMatchedFunctionsList() {
      return this.showMatchedFunctionsList.isSelected();
   }

   public boolean getShowPrimaryUnmatchedBasicblocksOfUmatchedFunctions() {
      return this.showPrimaryUnmatchedFunctionsBasicblocks.isSelected();
   }

   public boolean getShowPrimaryUnmatchedFunctionsList() {
      return this.showPrimaryUnmatchedFunctionsList.isSelected();
   }

   public boolean getShowSecondaryUnmatchedBasicblocksOfUnmatchedFunctions() {
      return this.showSecondaryUnmatchedFunctionsBasicblocks.isSelected();
   }

   public boolean getShowSecondaryUnmatchedFunctionsList() {
      return this.showSecondaryUnmatchedFunctionsList.isSelected();
   }

   public boolean getShowStatsTablel() {
      return this.showStatsTable.isSelected();
   }

   public boolean getShowUnmatchedBasicblocksOfMatchedFunctions() {
      return this.showMatchedFunctionsUnmatchedBasicblocks.isSelected();
   }
}
