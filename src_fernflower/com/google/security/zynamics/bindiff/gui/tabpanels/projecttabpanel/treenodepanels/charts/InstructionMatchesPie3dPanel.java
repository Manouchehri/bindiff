package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$CustomLabelGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$CustomTooltipGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.Pie3dPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class InstructionMatchesPie3dPanel extends JPanel {
   private static final int MATCHED_INSTRUCTIONS = 0;
   private static final int PRIMRAY_UNMATCHED_INSTRUCTIONS = 1;
   private static final int SECONDARY_UNMATCHED_INSTRUCTIONS = 2;
   private static final String[] PLOTS = new String[]{"Matched Instructions", "Primary unmatched Instructions", "Secondary unmatched Instructions"};
   private int matchedCount = 0;
   private int primaryUnmatchedCount = 0;
   private int secondaryUnmatchedCount = 0;
   private double matchedPercent = 0.0D;
   private double primaryUnmatchedPercent = 0.0D;
   private double secondaryUnmatchedPercent = 0.0D;
   private final boolean includeUnmatchedFunctions;
   private final Diff diff;
   private final Pie3dPanel piePanel;
   private final DefaultPieDataset dataset = new DefaultPieDataset();
   private final InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener changeListener = new InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(this, (InstructionMatchesPie3dPanel$1)null);

   public InstructionMatchesPie3dPanel(Diff var1, boolean var2) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      this.diff = var1;
      this.includeUnmatchedFunctions = var2;
      this.piePanel = new Pie3dPanel(this.getTitle(), this.dataset, new InstructionMatchesPie3dPanel$CustomLabelGenerator(this, (InstructionMatchesPie3dPanel$1)null));
      this.piePanel.setSectionColor(PLOTS[0], Colors.PIE_MATCHED);
      this.piePanel.setSectionColor(PLOTS[1], Colors.PIE_PRIMARY_UNMATCHED);
      this.piePanel.setSectionColor(PLOTS[2], Colors.PIE_SECONDARY_UNMATCHED);
      this.piePanel.setTooltipGenerator(new InstructionMatchesPie3dPanel$CustomTooltipGenerator(this, (InstructionMatchesPie3dPanel$1)null));
      this.add(this.piePanel, "Center");
      if(this.includeUnmatchedFunctions) {
         var1.getMetaData().addListener(this.changeListener);
         this.updateDataset();
      }

   }

   private String getTitle() {
      return Double.isNaN(this.matchedPercent)?"Instructions":String.format("%s %.1f%s", new Object[]{"Instructions", Double.valueOf(this.matchedPercent), "%"});
   }

   private void updateDataset() {
      if(this.includeUnmatchedFunctions) {
         MatchData var1 = this.diff.getMatches();
         this.matchedCount = var1.getSizeOfMatchedInstructions();
         this.primaryUnmatchedCount = var1.getSizeOfUnmatchedInstructions(ESide.PRIMARY);
         this.secondaryUnmatchedCount = var1.getSizeOfUnmatchedInstructions(ESide.SECONDARY);
         int var2 = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
         this.matchedPercent = (double)this.matchedCount / (double)var2 * 100.0D;
         this.primaryUnmatchedPercent = (double)this.primaryUnmatchedCount / (double)var2 * 100.0D;
         this.secondaryUnmatchedPercent = (double)this.secondaryUnmatchedCount / (double)var2 * 100.0D;
         this.dataset.setValue(PLOTS[0], this.matchedPercent);
         this.dataset.setValue(PLOTS[1], this.primaryUnmatchedPercent);
         this.dataset.setValue(PLOTS[2], this.secondaryUnmatchedPercent);
         this.piePanel.setTitle(this.getTitle());
         this.piePanel.fireChartChanged();
      }

   }

   public void dispose() {
      if(this.includeUnmatchedFunctions) {
         this.diff.getMetaData().removeListener(this.changeListener);
      }

   }

   public JFreeChart getChart() {
      return this.piePanel.getChart();
   }

   public void updateDataset(int var1, int var2, int var3) {
      if(!this.includeUnmatchedFunctions) {
         this.matchedCount = var1;
         this.primaryUnmatchedCount = var2;
         this.secondaryUnmatchedCount = var3;
         int var4 = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
         this.matchedPercent = (double)this.matchedCount / (double)var4 * 100.0D;
         this.primaryUnmatchedPercent = (double)this.primaryUnmatchedCount / (double)var4 * 100.0D;
         this.secondaryUnmatchedPercent = (double)this.secondaryUnmatchedCount / (double)var4 * 100.0D;
         this.dataset.setValue(PLOTS[0], this.matchedPercent);
         this.dataset.setValue(PLOTS[1], this.primaryUnmatchedPercent);
         this.dataset.setValue(PLOTS[2], this.secondaryUnmatchedPercent);
         this.piePanel.setTitle(this.getTitle());
         this.piePanel.fireChartChanged();
      }

   }

   // $FF: synthetic method
   static String[] access$300() {
      return PLOTS;
   }

   // $FF: synthetic method
   static int access$400(InstructionMatchesPie3dPanel var0) {
      return var0.matchedCount;
   }

   // $FF: synthetic method
   static double access$500(InstructionMatchesPie3dPanel var0) {
      return var0.matchedPercent;
   }

   // $FF: synthetic method
   static int access$600(InstructionMatchesPie3dPanel var0) {
      return var0.primaryUnmatchedCount;
   }

   // $FF: synthetic method
   static double access$700(InstructionMatchesPie3dPanel var0) {
      return var0.primaryUnmatchedPercent;
   }

   // $FF: synthetic method
   static int access$800(InstructionMatchesPie3dPanel var0) {
      return var0.secondaryUnmatchedCount;
   }

   // $FF: synthetic method
   static double access$900(InstructionMatchesPie3dPanel var0) {
      return var0.secondaryUnmatchedPercent;
   }

   // $FF: synthetic method
   static void access$1000(InstructionMatchesPie3dPanel var0) {
      var0.updateDataset();
   }
}
