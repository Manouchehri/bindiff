package org.jfree.chart.axis;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class SubCategoryAxis extends CategoryAxis implements Serializable, Cloneable {
   private static final long serialVersionUID = -1279463299793228344L;
   private List subCategories;
   private Font subLabelFont = new Font("SansSerif", 0, 10);
   private transient Paint subLabelPaint;

   public SubCategoryAxis(String var1) {
      super(var1);
      this.subLabelPaint = Color.black;
      this.subCategories = new ArrayList();
   }

   public void addSubCategory(Comparable var1) {
      this.subCategories.add(var1);
   }

   public Font getSubLabelFont() {
      return this.subLabelFont;
   }

   public void setSubLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.subLabelFont = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Paint getSubLabelPaint() {
      return this.subLabelPaint;
   }

   public void setSubLabelPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.subLabelPaint = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public AxisSpace reserveSpace(Graphics2D var1, Plot var2, Rectangle2D var3, RectangleEdge var4, AxisSpace var5) {
      if(var5 == null) {
         var5 = new AxisSpace();
      }

      if(!this.isVisible()) {
         return var5;
      } else {
         var5 = super.reserveSpace(var1, var2, var3, var4, var5);
         double var6 = this.getMaxDim(var1, var4);
         if(RectangleEdge.isTopOrBottom(var4)) {
            var5.add(var6, var4);
         } else if(RectangleEdge.isLeftOrRight(var4)) {
            var5.add(var6, var4);
         }

         return var5;
      }
   }

   private double getMaxDim(Graphics2D var1, RectangleEdge var2) {
      double var3 = 0.0D;
      var1.setFont(this.subLabelFont);
      FontMetrics var5 = var1.getFontMetrics();

      double var10;
      for(Iterator var6 = this.subCategories.iterator(); var6.hasNext(); var3 = Math.max(var3, var10)) {
         Comparable var7 = (Comparable)var6.next();
         String var8 = var7.toString();
         Rectangle2D var9 = TextUtilities.getTextBounds(var8, var1, var5);
         var10 = 0.0D;
         if(RectangleEdge.isLeftOrRight(var2)) {
            var10 = var9.getWidth();
         } else {
            var10 = var9.getHeight();
         }
      }

      return var3;
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      if(!this.isVisible()) {
         return new AxisState(var2);
      } else {
         if(this.isAxisLineVisible()) {
            this.drawAxisLine(var1, var2, var5, var6);
         }

         AxisState var8 = new AxisState(var2);
         var8 = this.drawSubCategoryLabels(var1, var4, var5, var6, var8, var7);
         var8 = this.drawCategoryLabels(var1, var4, var5, var6, var8, var7);
         var8 = this.drawLabel(this.getLabel(), var1, var4, var5, var6, var8);
         return var8;
      }
   }

   protected AxisState drawSubCategoryLabels(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, RectangleEdge var4, AxisState var5, PlotRenderingInfo var6) {
      if(var5 == null) {
         throw new IllegalArgumentException("Null \'state\' argument.");
      } else {
         var1.setFont(this.subLabelFont);
         var1.setPaint(this.subLabelPaint);
         CategoryPlot var7 = (CategoryPlot)this.getPlot();
         CategoryDataset var8 = var7.getDataset();
         int var9 = var8.getColumnCount();
         double var10 = this.getMaxDim(var1, var4);

         for(int var12 = 0; var12 < var9; ++var12) {
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;
            double var19 = 0.0D;
            if(var4 == RectangleEdge.TOP) {
               var13 = this.getCategoryStart(var12, var9, var3, var4);
               var15 = this.getCategoryEnd(var12, var9, var3, var4);
               var19 = var5.getCursor();
               var17 = var19 - var10;
            } else if(var4 == RectangleEdge.BOTTOM) {
               var13 = this.getCategoryStart(var12, var9, var3, var4);
               var15 = this.getCategoryEnd(var12, var9, var3, var4);
               var17 = var5.getCursor();
               var19 = var17 + var10;
            } else if(var4 == RectangleEdge.LEFT) {
               var17 = this.getCategoryStart(var12, var9, var3, var4);
               var19 = this.getCategoryEnd(var12, var9, var3, var4);
               var15 = var5.getCursor();
               var13 = var15 - var10;
            } else if(var4 == RectangleEdge.RIGHT) {
               var17 = this.getCategoryStart(var12, var9, var3, var4);
               var19 = this.getCategoryEnd(var12, var9, var3, var4);
               var13 = var5.getCursor();
               var15 = var13 + var10;
            }

            Double var21 = new Double(var13, var17, var15 - var13, var19 - var17);
            int var22 = this.subCategories.size();
            float var23 = (float)((var15 - var13) / (double)var22);
            float var24 = (float)((var19 - var17) / (double)var22);
            float var25 = 0.0F;
            float var26 = 0.0F;

            for(int var27 = 0; var27 < var22; ++var27) {
               if(RectangleEdge.isTopOrBottom(var4)) {
                  var25 = (float)(var13 + ((double)var27 + 0.5D) * (double)var23);
                  var26 = (float)var21.getCenterY();
               } else {
                  var25 = (float)var21.getCenterX();
                  var26 = (float)(var17 + ((double)var27 + 0.5D) * (double)var24);
               }

               String var28 = this.subCategories.get(var27).toString();
               TextUtilities.drawRotatedString(var28, var1, var25, var26, TextAnchor.CENTER, 0.0D, TextAnchor.CENTER);
            }
         }

         if(var4.equals(RectangleEdge.TOP)) {
            var5.cursorUp(var10);
         } else if(var4.equals(RectangleEdge.BOTTOM)) {
            var5.cursorDown(var10);
         } else if(var4 == RectangleEdge.LEFT) {
            var5.cursorLeft(var10);
         } else if(var4 == RectangleEdge.RIGHT) {
            var5.cursorRight(var10);
         }

         return var5;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof SubCategoryAxis && super.equals(var1)) {
         SubCategoryAxis var2 = (SubCategoryAxis)var1;
         return !this.subCategories.equals(var2.subCategories)?false:(!this.subLabelFont.equals(var2.subLabelFont)?false:this.subLabelPaint.equals(var2.subLabelPaint));
      } else {
         return false;
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.subLabelPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.subLabelPaint = SerialUtilities.readPaint(var1);
   }
}
