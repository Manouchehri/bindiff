package org.jfree.chart;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PolarPlot;

public class PolarChartPanel extends ChartPanel {
   private static final String POLAR_ZOOM_IN_ACTION_COMMAND = "Polar Zoom In";
   private static final String POLAR_ZOOM_OUT_ACTION_COMMAND = "Polar Zoom Out";
   private static final String POLAR_AUTO_RANGE_ACTION_COMMAND = "Polar Auto Range";

   public PolarChartPanel(JFreeChart var1) {
      this(var1, true);
   }

   public PolarChartPanel(JFreeChart var1, boolean var2) {
      super(var1, var2);
      this.checkChart(var1);
      this.setMinimumDrawWidth(200);
      this.setMinimumDrawHeight(200);
      this.setMaximumDrawWidth(2000);
      this.setMaximumDrawHeight(2000);
   }

   public void setChart(JFreeChart var1) {
      this.checkChart(var1);
      super.setChart(var1);
   }

   protected JPopupMenu createPopupMenu(boolean var1, boolean var2, boolean var3, boolean var4) {
      JPopupMenu var5 = super.createPopupMenu(var1, var2, var3, var4);
      int var6 = this.getPopupMenuItem(var5, "Zoom In");
      int var7 = this.getPopupMenuItem(var5, "Zoom Out");
      int var8 = this.getPopupMenuItem(var5, "Auto Range");
      if(var4) {
         JMenuItem var9 = new JMenuItem("Zoom In");
         var9.setActionCommand("Polar Zoom In");
         var9.addActionListener(this);
         JMenuItem var10 = new JMenuItem("Zoom Out");
         var10.setActionCommand("Polar Zoom Out");
         var10.addActionListener(this);
         JMenuItem var11 = new JMenuItem("Auto Range");
         var11.setActionCommand("Polar Auto Range");
         var11.addActionListener(this);
         if(var6 != -1) {
            var5.remove(var6);
         } else {
            var6 = var5.getComponentCount() - 1;
         }

         var5.add(var9, var6);
         if(var7 != -1) {
            var5.remove(var7);
         } else {
            var7 = var6 + 1;
         }

         var5.add(var10, var7);
         if(var8 != -1) {
            var5.remove(var8);
         } else {
            var8 = var7 + 1;
         }

         var5.add(var11, var8);
      }

      return var5;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      PolarPlot var3;
      if(var2.equals("Polar Zoom In")) {
         var3 = (PolarPlot)this.getChart().getPlot();
         var3.zoom(0.5D);
      } else if(var2.equals("Polar Zoom Out")) {
         var3 = (PolarPlot)this.getChart().getPlot();
         var3.zoom(2.0D);
      } else if(var2.equals("Polar Auto Range")) {
         var3 = (PolarPlot)this.getChart().getPlot();
         var3.getAxis().setAutoRange(true);
      } else {
         super.actionPerformed(var1);
      }

   }

   private void checkChart(JFreeChart var1) {
      Plot var2 = var1.getPlot();
      if(!(var2 instanceof PolarPlot)) {
         throw new IllegalArgumentException("plot is not a PolarPlot");
      }
   }

   private int getPopupMenuItem(JPopupMenu var1, String var2) {
      int var3 = -1;

      for(int var4 = 0; var3 == -1 && var4 < var1.getComponentCount(); ++var4) {
         Component var5 = var1.getComponent(var4);
         if(var5 instanceof JMenuItem) {
            JMenuItem var6 = (JMenuItem)var5;
            if(var2.equals(var6.getText())) {
               var3 = var4;
            }
         }
      }

      return var3;
   }
}
