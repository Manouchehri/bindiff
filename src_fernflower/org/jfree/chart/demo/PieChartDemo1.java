package org.jfree.chart.demo;

import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo1 extends ApplicationFrame {
   public PieChartDemo1(String var1) {
      super(var1);
      this.setContentPane(createDemoPanel());
   }

   private static PieDataset createDataset() {
      DefaultPieDataset var0 = new DefaultPieDataset();
      var0.setValue("One", new Double(43.2D));
      var0.setValue("Two", new Double(10.0D));
      var0.setValue("Three", new Double(27.5D));
      var0.setValue("Four", new Double(17.5D));
      var0.setValue("Five", new Double(11.0D));
      var0.setValue("Six", new Double(19.4D));
      return var0;
   }

   private static JFreeChart createChart(PieDataset var0) {
      JFreeChart var1 = ChartFactory.createPieChart("Pie Chart Demo 1", var0, true, true, false);
      PiePlot var2 = (PiePlot)var1.getPlot();
      var2.setSectionOutlinesVisible(false);
      var2.setLabelFont(new Font("SansSerif", 0, 12));
      var2.setNoDataMessage("No data available");
      var2.setCircular(false);
      var2.setLabelGap(0.02D);
      return var1;
   }

   public static JPanel createDemoPanel() {
      JFreeChart var0 = createChart(createDataset());
      return new ChartPanel(var0);
   }

   public static void main(String[] var0) {
      PieChartDemo1 var1 = new PieChartDemo1("Pie Chart Demo 1");
      var1.pack();
      RefineryUtilities.centerFrameOnScreen(var1);
      var1.setVisible(true);
   }
}
