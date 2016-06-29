package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.chart.annotations.CategoryAnnotation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class CategoryLineAnnotation implements Serializable, Cloneable, CategoryAnnotation {
   private Comparable category1;
   private double value1;
   private Comparable category2;
   private double value2;
   private transient Paint paint;
   private transient Stroke stroke;

   public CategoryLineAnnotation(Comparable var1, double var2, Comparable var4, double var5, Paint var7, Stroke var8) {
      this.paint = Color.black;
      this.stroke = new BasicStroke(1.0F);
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category1\' argument.");
      } else if(var4 == null) {
         throw new IllegalArgumentException("Null \'category2\' argument.");
      } else if(var7 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else if(var8 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.category1 = var1;
         this.value1 = var2;
         this.category2 = var4;
         this.value2 = var5;
         this.paint = var7;
         this.stroke = var8;
      }
   }

   public Comparable getCategory1() {
      return this.category1;
   }

   public void setCategory1(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         this.category1 = var1;
      }
   }

   public double getValue1() {
      return this.value1;
   }

   public void setValue1(double var1) {
      this.value1 = var1;
   }

   public Comparable getCategory2() {
      return this.category2;
   }

   public void setCategory2(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         this.category2 = var1;
      }
   }

   public double getValue2() {
      return this.value2;
   }

   public void setValue2(double var1) {
      this.value2 = var1;
   }

   public Paint getPaint() {
      return this.paint;
   }

   public void setPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.paint = var1;
      }
   }

   public Stroke getStroke() {
      return this.stroke;
   }

   public void setStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.stroke = var1;
      }
   }

   public void draw(Graphics2D var1, CategoryPlot var2, Rectangle2D var3, CategoryAxis var4, ValueAxis var5) {
      CategoryDataset var6 = var2.getDataset();
      int var7 = var6.getColumnIndex(this.category1);
      int var8 = var6.getColumnIndex(this.category2);
      int var9 = var6.getColumnCount();
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      PlotOrientation var18 = var2.getOrientation();
      RectangleEdge var19 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var18);
      RectangleEdge var20 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var18);
      if(var18 == PlotOrientation.HORIZONTAL) {
         var12 = var4.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, var7, var9, var3, var19);
         var10 = var5.valueToJava2D(this.value1, var3, var20);
         var16 = var4.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, var8, var9, var3, var19);
         var14 = var5.valueToJava2D(this.value2, var3, var20);
      } else if(var18 == PlotOrientation.VERTICAL) {
         var10 = var4.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, var7, var9, var3, var19);
         var12 = var5.valueToJava2D(this.value1, var3, var20);
         var14 = var4.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, var8, var9, var3, var19);
         var16 = var5.valueToJava2D(this.value2, var3, var20);
      }

      var1.setPaint(this.paint);
      var1.setStroke(this.stroke);
      var1.drawLine((int)var10, (int)var12, (int)var14, (int)var16);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CategoryLineAnnotation)) {
         return false;
      } else {
         CategoryLineAnnotation var2 = (CategoryLineAnnotation)var1;
         return !this.category1.equals(var2.getCategory1())?false:(this.value1 != var2.getValue1()?false:(!this.category2.equals(var2.getCategory2())?false:(this.value2 != var2.getValue2()?false:(!PaintUtilities.equal(this.paint, var2.paint)?false:ObjectUtilities.equal(this.stroke, var2.stroke)))));
      }
   }

   public int hashCode() {
      short var1 = 193;
      int var4 = 37 * var1 + this.category1.hashCode();
      long var2 = Double.doubleToLongBits(this.value1);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var4 = 37 * var4 + this.category2.hashCode();
      var2 = Double.doubleToLongBits(this.value2);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var4 = 37 * var4 + HashUtilities.hashCodeForPaint(this.paint);
      var4 = 37 * var4 + this.stroke.hashCode();
      return var4;
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
      SerialUtilities.writeStroke(this.stroke, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
      this.stroke = SerialUtilities.readStroke(var1);
   }
}
