package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$CustomLabelGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$CustomTooltipGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.Pie3dPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class FunctionMatchesPie3dPanel extends JPanel {
   private static final String MATCHED_FUNCTIONS = "Matched Functions";
   private static final String PRIMRAY_UNMATCHED_FUNCTIONS = "Primary unmatched Functions";
   private static final String SECONDARY_UNMATCHED_FUNCTIONS = "Secondary unmatched Functions";
   private final Pie3dPanel piePanel;
   private final int matchedCount;
   private final int primaryUnmatchedCount;
   private final int secondaryUnmatchedCount;
   private final double matchedPercent;
   private final double primaryUnmatchedPercent;
   private final double secondaryUnmatchedPercent;

   public FunctionMatchesPie3dPanel(Diff var1) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      MatchData var2 = var1.getMatches();
      this.matchedCount = var2.getSizeOfMatchedFunctions();
      this.primaryUnmatchedCount = var2.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
      this.secondaryUnmatchedCount = var2.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
      int var3 = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
      this.matchedPercent = (double)this.matchedCount / (double)var3 * 100.0D;
      this.primaryUnmatchedPercent = (double)this.primaryUnmatchedCount / (double)var3 * 100.0D;
      this.secondaryUnmatchedPercent = (double)this.secondaryUnmatchedCount / (double)var3 * 100.0D;
      DefaultPieDataset var4 = new DefaultPieDataset();
      var4.setValue("Matched Functions", this.matchedPercent);
      var4.setValue("Primary unmatched Functions", this.primaryUnmatchedPercent);
      var4.setValue("Secondary unmatched Functions", this.secondaryUnmatchedPercent);
      this.piePanel = new Pie3dPanel(this.getTitle(), var4, new FunctionMatchesPie3dPanel$CustomLabelGenerator(this, (FunctionMatchesPie3dPanel$1)null));
      this.piePanel.setSectionColor("Matched Functions", Colors.PIE_MATCHED);
      this.piePanel.setSectionColor("Primary unmatched Functions", Colors.PIE_PRIMARY_UNMATCHED);
      this.piePanel.setSectionColor("Secondary unmatched Functions", Colors.PIE_SECONDARY_UNMATCHED);
      this.piePanel.setTooltipGenerator(new FunctionMatchesPie3dPanel$CustomTooltipGenerator(this, (FunctionMatchesPie3dPanel$1)null));
      this.add(this.piePanel, "Center");
   }

   private String getTitle() {
      return Double.isNaN(this.matchedPercent)?"Functions":String.format("%s %.1f%s", new Object[]{"Functions", Double.valueOf(this.matchedPercent), "%"});
   }

   public FunctionMatchesPie3dPanel(DiffMetaData var1) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      this.matchedCount = var1.getSizeOfMatchedFunctions();
      this.primaryUnmatchedCount = var1.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
      this.secondaryUnmatchedCount = var1.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
      int var2 = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
      this.matchedPercent = (double)this.matchedCount / (double)var2 * 100.0D;
      this.primaryUnmatchedPercent = (double)this.primaryUnmatchedCount / (double)var2 * 100.0D;
      this.secondaryUnmatchedPercent = (double)this.secondaryUnmatchedCount / (double)var2 * 100.0D;
      DefaultPieDataset var3 = new DefaultPieDataset();
      var3.setValue("Matched Functions", this.matchedPercent);
      var3.setValue("Primary unmatched Functions", this.primaryUnmatchedPercent);
      var3.setValue("Secondary unmatched Functions", this.secondaryUnmatchedPercent);
      this.piePanel = new Pie3dPanel(String.format("%s %.1f%s", new Object[]{"Functions", Double.valueOf(this.matchedPercent), "%"}), var3, new FunctionMatchesPie3dPanel$CustomLabelGenerator(this, (FunctionMatchesPie3dPanel$1)null));
      this.piePanel.setSectionColor("Matched Functions", Colors.PIE_MATCHED);
      this.piePanel.setSectionColor("Primary unmatched Functions", Colors.PIE_PRIMARY_UNMATCHED);
      this.piePanel.setSectionColor("Secondary unmatched Functions", Colors.PIE_SECONDARY_UNMATCHED);
      this.piePanel.setTooltipGenerator(new FunctionMatchesPie3dPanel$CustomTooltipGenerator(this, (FunctionMatchesPie3dPanel$1)null));
      this.add(this.piePanel, "Center");
   }

   public JFreeChart getChart() {
      return this.piePanel.getChart();
   }

   // $FF: synthetic method
   static int access$200(FunctionMatchesPie3dPanel var0) {
      return var0.matchedCount;
   }

   // $FF: synthetic method
   static double access$300(FunctionMatchesPie3dPanel var0) {
      return var0.matchedPercent;
   }

   // $FF: synthetic method
   static int access$400(FunctionMatchesPie3dPanel var0) {
      return var0.primaryUnmatchedCount;
   }

   // $FF: synthetic method
   static double access$500(FunctionMatchesPie3dPanel var0) {
      return var0.primaryUnmatchedPercent;
   }

   // $FF: synthetic method
   static int access$600(FunctionMatchesPie3dPanel var0) {
      return var0.secondaryUnmatchedCount;
   }

   // $FF: synthetic method
   static double access$700(FunctionMatchesPie3dPanel var0) {
      return var0.secondaryUnmatchedPercent;
   }
}
