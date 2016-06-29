package org.jfree.chart;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class ChartFrame extends JFrame {
   private ChartPanel chartPanel;

   public ChartFrame(String var1, JFreeChart var2) {
      this(var1, var2, false);
   }

   public ChartFrame(String var1, JFreeChart var2, boolean var3) {
      super(var1);
      this.setDefaultCloseOperation(2);
      this.chartPanel = new ChartPanel(var2);
      if(var3) {
         this.setContentPane(new JScrollPane(this.chartPanel));
      } else {
         this.setContentPane(this.chartPanel);
      }

   }

   public ChartPanel getChartPanel() {
      return this.chartPanel;
   }
}
