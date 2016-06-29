package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$CustomLabelGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$CustomTooltipGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.Pie3dPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class CallMatchesPie3dPanel extends JPanel {
   public static final int MATCHED_FUNCTIONS = 0;
   public static final int PRIMRAY_UNMATCHED_CALLS = 1;
   public static final int SECONDARY_UNMATCHED_CALLS = 2;
   private static final String[] PLOTS = new String[]{"Matched Calls", "Primary unmatched Calls", "Secondary unmatched Calls"};
   private int matchedCount;
   private int primaryUnmatchedCount;
   private int secondaryUnmatchedCount;
   private double matchedPercent;
   private double primaryUnmatchedPercent;
   private double secondaryUnmatchedPercent;
   private final Diff diff;
   private final Pie3dPanel piePanel;
   private final DefaultPieDataset dataset = new DefaultPieDataset();
   private final CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener changeListener = new CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(this, (CallMatchesPie3dPanel$1)null);

   public CallMatchesPie3dPanel(Diff var1) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      this.diff = var1;
      this.piePanel = new Pie3dPanel(this.getTitle(), this.dataset, new CallMatchesPie3dPanel$CustomLabelGenerator(this, (CallMatchesPie3dPanel$1)null));
      this.piePanel.setSectionColor(PLOTS[0], Colors.PIE_MATCHED);
      this.piePanel.setSectionColor(PLOTS[1], Colors.PIE_PRIMARY_UNMATCHED);
      this.piePanel.setSectionColor(PLOTS[2], Colors.PIE_SECONDARY_UNMATCHED);
      this.piePanel.setTooltipGenerator(new CallMatchesPie3dPanel$CustomTooltipGenerator(this, (CallMatchesPie3dPanel$1)null));
      this.add(this.piePanel, "Center");
      this.updateDataset();
      var1.getMetaData().addListener(this.changeListener);
   }

   private String getTitle() {
      return Double.isNaN(this.matchedPercent)?"Calls":String.format("%s %.1f%s", new Object[]{"Calls", Double.valueOf(this.matchedPercent), "%"});
   }

   private void updateDataset() {
      MatchData var1 = this.diff.getMatches();
      this.matchedCount = var1.getSizeOfMatchedCalls();
      this.primaryUnmatchedCount = var1.getSizeOfUnmatchedCalls(ESide.PRIMARY);
      this.secondaryUnmatchedCount = var1.getSizeOfUnmatchedCalls(ESide.SECONDARY);
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

   public void dispose() {
      this.diff.getMetaData().removeListener(this.changeListener);
   }

   public JFreeChart getChart() {
      return this.piePanel.getChart();
   }

   // $FF: synthetic method
   static String[] access$300() {
      return PLOTS;
   }

   // $FF: synthetic method
   static int access$400(CallMatchesPie3dPanel var0) {
      return var0.matchedCount;
   }

   // $FF: synthetic method
   static double access$500(CallMatchesPie3dPanel var0) {
      return var0.matchedPercent;
   }

   // $FF: synthetic method
   static int access$600(CallMatchesPie3dPanel var0) {
      return var0.primaryUnmatchedCount;
   }

   // $FF: synthetic method
   static double access$700(CallMatchesPie3dPanel var0) {
      return var0.primaryUnmatchedPercent;
   }

   // $FF: synthetic method
   static int access$800(CallMatchesPie3dPanel var0) {
      return var0.secondaryUnmatchedCount;
   }

   // $FF: synthetic method
   static double access$900(CallMatchesPie3dPanel var0) {
      return var0.secondaryUnmatchedPercent;
   }

   // $FF: synthetic method
   static void access$1000(CallMatchesPie3dPanel var0) {
      var0.updateDataset();
   }
}
