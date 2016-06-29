package org.jfree.chart.plot;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.Serializable;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.RectangleInsets;

public class JThermometer extends JPanel implements Serializable {
   private static final long serialVersionUID = 1079905665515589820L;
   private DefaultValueDataset data;
   private JFreeChart chart;
   private ChartPanel panel;
   private ThermometerPlot plot = new ThermometerPlot();

   public JThermometer() {
      super(new CardLayout());
      this.plot.setInsets(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
      this.data = new DefaultValueDataset();
      this.plot.setDataset(this.data);
      this.chart = new JFreeChart((String)null, JFreeChart.DEFAULT_TITLE_FONT, this.plot, false);
      this.panel = new ChartPanel(this.chart);
      this.add(this.panel, "Panel");
      this.setBackground(this.getBackground());
   }

   public void addSubtitle(Title var1) {
      this.chart.addSubtitle(var1);
   }

   public void addSubtitle(String var1) {
      this.chart.addSubtitle(new TextTitle(var1));
   }

   public void addSubtitle(String var1, Font var2) {
      this.chart.addSubtitle(new TextTitle(var1, var2));
   }

   public void setValueFormat(DecimalFormat var1) {
      this.plot.setValueFormat(var1);
   }

   public void setRange(double var1, double var3) {
      this.plot.setRange(var1, var3);
   }

   public void setSubrangeInfo(int var1, double var2, double var4) {
      this.plot.setSubrangeInfo(var1, var2, var4);
   }

   public void setSubrangeInfo(int var1, double var2, double var4, double var6, double var8) {
      this.plot.setSubrangeInfo(var1, var2, var4, var6, var8);
   }

   public void setValueLocation(int var1) {
      this.plot.setValueLocation(var1);
      this.panel.repaint();
   }

   public void setValuePaint(Paint var1) {
      this.plot.setValuePaint(var1);
   }

   public Number getValue() {
      return this.data != null?this.data.getValue():null;
   }

   public void setValue(double var1) {
      this.setValue(new Double(var1));
   }

   public void setValue(Number var1) {
      if(this.data != null) {
         this.data.setValue(var1);
      }

   }

   public void setUnits(int var1) {
      if(this.plot != null) {
         this.plot.setUnits(var1);
      }

   }

   public void setOutlinePaint(Paint var1) {
      if(this.plot != null) {
         this.plot.setOutlinePaint(var1);
      }

   }

   public void setForeground(Color var1) {
      super.setForeground(var1);
      if(this.plot != null) {
         this.plot.setThermometerPaint(var1);
      }

   }

   public void setBackground(Color var1) {
      super.setBackground(var1);
      if(this.plot != null) {
         this.plot.setBackgroundPaint(var1);
      }

      if(this.chart != null) {
         this.chart.setBackgroundPaint(var1);
      }

      if(this.panel != null) {
         this.panel.setBackground(var1);
      }

   }

   public void setValueFont(Font var1) {
      if(this.plot != null) {
         this.plot.setValueFont(var1);
      }

   }

   public Font getTickLabelFont() {
      ValueAxis var1 = this.plot.getRangeAxis();
      return var1.getTickLabelFont();
   }

   public void setTickLabelFont(Font var1) {
      ValueAxis var2 = this.plot.getRangeAxis();
      var2.setTickLabelFont(var1);
   }

   public void changeTickFontSize(int var1) {
      Font var2 = this.getTickLabelFont();
      String var3 = var2.getFontName();
      Font var4 = new Font(var3, var2.getStyle(), var2.getSize() + var1);
      this.setTickLabelFont(var4);
   }

   public void setTickFontStyle(int var1) {
      Font var2 = this.getTickLabelFont();
      String var3 = var2.getFontName();
      Font var4 = new Font(var3, var1, var2.getSize());
      this.setTickLabelFont(var4);
   }

   public void setFollowDataInSubranges(boolean var1) {
      this.plot.setFollowDataInSubranges(var1);
   }

   public void setShowValueLines(boolean var1) {
      this.plot.setShowValueLines(var1);
   }

   public void setShowAxisLocation(int var1) {
      this.plot.setAxisLocation(var1);
   }

   public int getShowAxisLocation() {
      return this.plot.getAxisLocation();
   }
}
