package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.needle.ArrowNeedle;
import org.jfree.chart.needle.LineNeedle;
import org.jfree.chart.needle.LongNeedle;
import org.jfree.chart.needle.MeterNeedle;
import org.jfree.chart.needle.MiddlePinNeedle;
import org.jfree.chart.needle.PinNeedle;
import org.jfree.chart.needle.PlumNeedle;
import org.jfree.chart.needle.PointerNeedle;
import org.jfree.chart.needle.ShipNeedle;
import org.jfree.chart.needle.WindNeedle;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class CompassPlot extends Plot implements Serializable, Cloneable {
   private static final long serialVersionUID = 6924382802125527395L;
   public static final Font DEFAULT_LABEL_FONT = new Font("SansSerif", 1, 10);
   public static final int NO_LABELS = 0;
   public static final int VALUE_LABELS = 1;
   private int labelType;
   private Font labelFont;
   private boolean drawBorder;
   private transient Paint roseHighlightPaint;
   private transient Paint rosePaint;
   private transient Paint roseCenterPaint;
   private Font compassFont;
   private transient Ellipse2D circle1;
   private transient Ellipse2D circle2;
   private transient Area a1;
   private transient Area a2;
   private transient Rectangle2D rect1;
   private ValueDataset[] datasets;
   private MeterNeedle[] seriesNeedle;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
   protected double revolutionDistance;

   public CompassPlot() {
      this(new DefaultValueDataset());
   }

   public CompassPlot(ValueDataset var1) {
      this.drawBorder = false;
      this.roseHighlightPaint = Color.black;
      this.rosePaint = Color.yellow;
      this.roseCenterPaint = Color.white;
      this.compassFont = new Font("Arial", 0, 10);
      this.datasets = new ValueDataset[1];
      this.seriesNeedle = new MeterNeedle[1];
      this.revolutionDistance = 360.0D;
      if(var1 != null) {
         this.datasets[0] = var1;
         var1.addChangeListener(this);
      }

      this.circle1 = new Double();
      this.circle2 = new Double();
      this.rect1 = new java.awt.geom.Rectangle2D.Double();
      this.setSeriesNeedle(0);
   }

   public int getLabelType() {
      return this.labelType;
   }

   public void setLabelType(int var1) {
      if(var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException("MeterPlot.setLabelType(int): unrecognised type.");
      } else {
         if(this.labelType != var1) {
            this.labelType = var1;
            this.notifyListeners(new PlotChangeEvent(this));
         }

      }
   }

   public Font getLabelFont() {
      return this.labelFont;
   }

   public void setLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' not allowed.");
      } else {
         this.labelFont = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getRosePaint() {
      return this.rosePaint;
   }

   public void setRosePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.rosePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getRoseCenterPaint() {
      return this.roseCenterPaint;
   }

   public void setRoseCenterPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.roseCenterPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getRoseHighlightPaint() {
      return this.roseHighlightPaint;
   }

   public void setRoseHighlightPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.roseHighlightPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean getDrawBorder() {
      return this.drawBorder;
   }

   public void setDrawBorder(boolean var1) {
      this.drawBorder = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void setSeriesPaint(int var1, Paint var2) {
      if(var1 >= 0 && var1 < this.seriesNeedle.length) {
         this.seriesNeedle[var1].setFillPaint(var2);
      }

   }

   public void setSeriesOutlinePaint(int var1, Paint var2) {
      if(var1 >= 0 && var1 < this.seriesNeedle.length) {
         this.seriesNeedle[var1].setOutlinePaint(var2);
      }

   }

   public void setSeriesOutlineStroke(int var1, Stroke var2) {
      if(var1 >= 0 && var1 < this.seriesNeedle.length) {
         this.seriesNeedle[var1].setOutlineStroke(var2);
      }

   }

   public void setSeriesNeedle(int var1) {
      this.setSeriesNeedle(0, var1);
   }

   public void setSeriesNeedle(int var1, int var2) {
      switch(var2) {
      case 0:
         this.setSeriesNeedle(var1, new ArrowNeedle(true));
         this.setSeriesPaint(var1, Color.red);
         this.seriesNeedle[var1].setHighlightPaint(Color.white);
         break;
      case 1:
         this.setSeriesNeedle(var1, new LineNeedle());
         break;
      case 2:
         LongNeedle var3 = new LongNeedle();
         var3.setRotateY(0.5D);
         this.setSeriesNeedle(var1, var3);
         break;
      case 3:
         this.setSeriesNeedle(var1, new PinNeedle());
         break;
      case 4:
         this.setSeriesNeedle(var1, new PlumNeedle());
         break;
      case 5:
         this.setSeriesNeedle(var1, new PointerNeedle());
         break;
      case 6:
         this.setSeriesPaint(var1, (Paint)null);
         this.setSeriesOutlineStroke(var1, new BasicStroke(3.0F));
         this.setSeriesNeedle(var1, new ShipNeedle());
         break;
      case 7:
         this.setSeriesPaint(var1, Color.blue);
         this.setSeriesNeedle(var1, new WindNeedle());
         break;
      case 8:
         this.setSeriesNeedle(var1, new ArrowNeedle(true));
         break;
      case 9:
         this.setSeriesNeedle(var1, new MiddlePinNeedle());
         break;
      default:
         throw new IllegalArgumentException("Unrecognised type.");
      }

   }

   public void setSeriesNeedle(int var1, MeterNeedle var2) {
      if(var2 != null && var1 < this.seriesNeedle.length) {
         this.seriesNeedle[var1] = var2;
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public ValueDataset[] getDatasets() {
      return this.datasets;
   }

   public void addDataset(ValueDataset var1) {
      this.addDataset(var1, (MeterNeedle)null);
   }

   public void addDataset(ValueDataset var1, MeterNeedle var2) {
      if(var1 != null) {
         int var3 = this.datasets.length + 1;
         ValueDataset[] var4 = new ValueDataset[var3];
         MeterNeedle[] var5 = new MeterNeedle[var3];

         for(var3 -= 2; var3 >= 0; --var3) {
            var4[var3] = this.datasets[var3];
            var5[var3] = this.seriesNeedle[var3];
         }

         var3 = this.datasets.length;
         var4[var3] = var1;
         var5[var3] = var2 != null?var2:var5[var3 - 1];
         ValueDataset[] var6 = this.datasets;
         MeterNeedle[] var7 = this.seriesNeedle;
         this.datasets = var4;
         this.seriesNeedle = var5;
         --var3;

         while(var3 >= 0) {
            var6[var3] = null;
            var7[var3] = null;
            --var3;
         }

         var1.addChangeListener(this);
      }

   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      boolean var6 = false;
      boolean var7 = false;
      if(var5 != null) {
         var5.setPlotArea(var2);
      }

      RectangleInsets var14 = this.getInsets();
      var14.trim(var2);
      if(this.drawBorder) {
         this.drawBackground(var1, var2);
      }

      int var15 = (int)(var2.getWidth() / 2.0D);
      int var16 = (int)(var2.getHeight() / 2.0D);
      int var17 = var15;
      if(var16 < var15) {
         var17 = var16;
      }

      --var17;
      int var18 = 2 * var17;
      var15 += (int)var2.getMinX();
      var16 += (int)var2.getMinY();
      this.circle1.setFrame((double)(var15 - var17), (double)(var16 - var17), (double)var18, (double)var18);
      this.circle2.setFrame((double)(var15 - var17 + 15), (double)(var16 - var17 + 15), (double)(var18 - 30), (double)(var18 - 30));
      var1.setPaint(this.rosePaint);
      this.a1 = new Area(this.circle1);
      this.a2 = new Area(this.circle2);
      this.a1.subtract(this.a2);
      var1.fill(this.a1);
      var1.setPaint(this.roseCenterPaint);
      int var8 = var18 - 30;
      var1.fillOval(var15 - var17 + 15, var16 - var17 + 15, var8, var8);
      var1.setPaint(this.roseHighlightPaint);
      var1.drawOval(var15 - var17, var16 - var17, var18, var18);
      var8 = var18 - 20;
      var1.drawOval(var15 - var17 + 10, var16 - var17 + 10, var8, var8);
      var8 = var18 - 30;
      var1.drawOval(var15 - var17 + 15, var16 - var17 + 15, var8, var8);
      var8 = var18 - 80;
      var1.drawOval(var15 - var17 + 40, var16 - var17 + 40, var8, var8);
      int var27 = var17 - 20;
      int var29 = var17 - 32;

      int var9;
      double var12;
      int var19;
      for(var19 = 0; var19 < 360; var19 += 15) {
         var12 = Math.toRadians((double)var19);
         var8 = var15 - (int)(Math.sin(var12) * (double)var29);
         int var10 = var15 - (int)(Math.sin(var12) * (double)var27);
         var9 = var16 - (int)(Math.cos(var12) * (double)var29);
         int var11 = var16 - (int)(Math.cos(var12) * (double)var27);
         var1.drawLine(var8, var9, var10, var11);
      }

      var1.setPaint(this.roseHighlightPaint);
      var29 = var17 - 26;
      byte var28 = 7;

      for(var19 = 45; var19 < 360; var19 += 90) {
         var12 = Math.toRadians((double)var19);
         var8 = var15 - (int)(Math.sin(var12) * (double)var29);
         var9 = var16 - (int)(Math.cos(var12) * (double)var29);
         var1.fillOval(var8 - var28, var9 - var28, 2 * var28, 2 * var28);
      }

      for(var19 = 0; var19 < 360; var19 += 90) {
         var12 = Math.toRadians((double)var19);
         var8 = var15 - (int)(Math.sin(var12) * (double)var29);
         var9 = var16 - (int)(Math.cos(var12) * (double)var29);
         Polygon var20 = new Polygon();
         var20.addPoint(var8 - var28, var9);
         var20.addPoint(var8, var9 + var28);
         var20.addPoint(var8 + var28, var9);
         var20.addPoint(var8, var9 - var28);
         var1.fillPolygon(var20);
      }

      var29 = var17 - 42;
      Font var31 = this.getCompassFont(var17);
      var1.setFont(var31);
      var1.drawString("N", var15 - 5, var16 - var29 + var31.getSize());
      var1.drawString("S", var15 - 5, var16 + var29 - 5);
      var1.drawString("W", var15 - var29 + 5, var16 + 5);
      var1.drawString("E", var15 + var29 - var31.getSize(), var16 + 5);
      var9 = var17 / 2;
      var8 = var17 / 6;
      java.awt.geom.Rectangle2D.Double var30 = new java.awt.geom.Rectangle2D.Double((double)(var15 - var8), (double)(var16 - var9), (double)(2 * var8), (double)(2 * var9));
      int var21 = this.seriesNeedle.length;
      boolean var22 = false;
      double var23 = 0.0D;

      for(int var25 = this.datasets.length - 1; var25 >= 0; --var25) {
         ValueDataset var26 = this.datasets[var25];
         if(var26 != null && var26.getValue() != null) {
            var23 = var26.getValue().doubleValue() % this.revolutionDistance;
            var23 = var23 / this.revolutionDistance * 360.0D;
            int var32 = var25 % var21;
            this.seriesNeedle[var32].draw(var1, var30, var23);
         }
      }

      if(this.drawBorder) {
         this.drawOutline(var1, var2);
      }

   }

   public String getPlotType() {
      return localizationResources.getString("Compass_Plot");
   }

   public LegendItemCollection getLegendItems() {
      return null;
   }

   public void zoom(double var1) {
   }

   protected Font getCompassFont(int var1) {
      float var2 = (float)var1 / 10.0F;
      if(var2 < 8.0F) {
         var2 = 8.0F;
      }

      Font var3 = this.compassFont.deriveFont(var2);
      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CompassPlot)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         CompassPlot var2 = (CompassPlot)var1;
         return this.labelType != var2.labelType?false:(!ObjectUtilities.equal(this.labelFont, var2.labelFont)?false:(this.drawBorder != var2.drawBorder?false:(!PaintUtilities.equal(this.roseHighlightPaint, var2.roseHighlightPaint)?false:(!PaintUtilities.equal(this.rosePaint, var2.rosePaint)?false:(!PaintUtilities.equal(this.roseCenterPaint, var2.roseCenterPaint)?false:(!ObjectUtilities.equal(this.compassFont, var2.compassFont)?false:(!Arrays.equals(this.seriesNeedle, var2.seriesNeedle)?false:this.getRevolutionDistance() == var2.getRevolutionDistance())))))));
      }
   }

   public Object clone() {
      CompassPlot var1 = (CompassPlot)super.clone();
      if(this.circle1 != null) {
         var1.circle1 = (Ellipse2D)this.circle1.clone();
      }

      if(this.circle2 != null) {
         var1.circle2 = (Ellipse2D)this.circle2.clone();
      }

      if(this.a1 != null) {
         var1.a1 = (Area)this.a1.clone();
      }

      if(this.a2 != null) {
         var1.a2 = (Area)this.a2.clone();
      }

      if(this.rect1 != null) {
         var1.rect1 = (Rectangle2D)this.rect1.clone();
      }

      var1.datasets = (ValueDataset[])((ValueDataset[])this.datasets.clone());
      var1.seriesNeedle = (MeterNeedle[])((MeterNeedle[])this.seriesNeedle.clone());

      for(int var2 = 0; var2 < this.datasets.length; ++var2) {
         if(var1.datasets[var2] != null) {
            var1.datasets[var2].addChangeListener(var1);
         }
      }

      return var1;
   }

   public void setRevolutionDistance(double var1) {
      if(var1 > 0.0D) {
         this.revolutionDistance = var1;
      }

   }

   public double getRevolutionDistance() {
      return this.revolutionDistance;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.rosePaint, var1);
      SerialUtilities.writePaint(this.roseCenterPaint, var1);
      SerialUtilities.writePaint(this.roseHighlightPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.rosePaint = SerialUtilities.readPaint(var1);
      this.roseCenterPaint = SerialUtilities.readPaint(var1);
      this.roseHighlightPaint = SerialUtilities.readPaint(var1);
   }
}
