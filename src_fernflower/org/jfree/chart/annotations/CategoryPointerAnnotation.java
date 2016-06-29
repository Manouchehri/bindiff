package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class CategoryPointerAnnotation extends CategoryTextAnnotation implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -4031161445009858551L;
   public static final double DEFAULT_TIP_RADIUS = 10.0D;
   public static final double DEFAULT_BASE_RADIUS = 30.0D;
   public static final double DEFAULT_LABEL_OFFSET = 3.0D;
   public static final double DEFAULT_ARROW_LENGTH = 5.0D;
   public static final double DEFAULT_ARROW_WIDTH = 3.0D;
   private double angle;
   private double tipRadius;
   private double baseRadius;
   private double arrowLength;
   private double arrowWidth;
   private transient Stroke arrowStroke;
   private transient Paint arrowPaint;
   private double labelOffset;

   public CategoryPointerAnnotation(String var1, Comparable var2, double var3, double var5) {
      super(var1, var2, var3);
      this.angle = var5;
      this.tipRadius = 10.0D;
      this.baseRadius = 30.0D;
      this.arrowLength = 5.0D;
      this.arrowWidth = 3.0D;
      this.labelOffset = 3.0D;
      this.arrowStroke = new BasicStroke(1.0F);
      this.arrowPaint = Color.black;
   }

   public double getAngle() {
      return this.angle;
   }

   public void setAngle(double var1) {
      this.angle = var1;
   }

   public double getTipRadius() {
      return this.tipRadius;
   }

   public void setTipRadius(double var1) {
      this.tipRadius = var1;
   }

   public double getBaseRadius() {
      return this.baseRadius;
   }

   public void setBaseRadius(double var1) {
      this.baseRadius = var1;
   }

   public double getLabelOffset() {
      return this.labelOffset;
   }

   public void setLabelOffset(double var1) {
      this.labelOffset = var1;
   }

   public double getArrowLength() {
      return this.arrowLength;
   }

   public void setArrowLength(double var1) {
      this.arrowLength = var1;
   }

   public double getArrowWidth() {
      return this.arrowWidth;
   }

   public void setArrowWidth(double var1) {
      this.arrowWidth = var1;
   }

   public Stroke getArrowStroke() {
      return this.arrowStroke;
   }

   public void setArrowStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' not permitted.");
      } else {
         this.arrowStroke = var1;
      }
   }

   public Paint getArrowPaint() {
      return this.arrowPaint;
   }

   public void setArrowPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.arrowPaint = var1;
      }
   }

   public void draw(Graphics2D var1, CategoryPlot var2, Rectangle2D var3, CategoryAxis var4, ValueAxis var5) {
      PlotOrientation var6 = var2.getOrientation();
      RectangleEdge var7 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var6);
      RectangleEdge var8 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var6);
      CategoryDataset var9 = var2.getDataset();
      int var10 = var9.getColumnIndex(this.getCategory());
      int var11 = var9.getColumnCount();
      double var12 = var4.getCategoryMiddle(var10, var11, var3, var7);
      double var14 = var5.valueToJava2D(this.getValue(), var3, var8);
      double var16;
      if(var6 == PlotOrientation.HORIZONTAL) {
         var16 = var12;
         var12 = var14;
         var14 = var16;
      }

      var16 = var12 + Math.cos(this.angle) * this.baseRadius;
      double var18 = var14 + Math.sin(this.angle) * this.baseRadius;
      double var20 = var12 + Math.cos(this.angle) * this.tipRadius;
      double var22 = var14 + Math.sin(this.angle) * this.tipRadius;
      double var24 = var20 + Math.cos(this.angle) * this.arrowLength;
      double var26 = var22 + Math.sin(this.angle) * this.arrowLength;
      double var28 = var24 + Math.cos(this.angle + 1.5707963267948966D) * this.arrowWidth;
      double var30 = var26 + Math.sin(this.angle + 1.5707963267948966D) * this.arrowWidth;
      double var32 = var24 - Math.cos(this.angle + 1.5707963267948966D) * this.arrowWidth;
      double var34 = var26 - Math.sin(this.angle + 1.5707963267948966D) * this.arrowWidth;
      GeneralPath var36 = new GeneralPath();
      var36.moveTo((float)var20, (float)var22);
      var36.lineTo((float)var28, (float)var30);
      var36.lineTo((float)var32, (float)var34);
      var36.closePath();
      var1.setStroke(this.arrowStroke);
      var1.setPaint(this.arrowPaint);
      Double var37 = new Double(var16, var18, var20, var22);
      var1.draw(var37);
      var1.fill(var36);
      var1.setFont(this.getFont());
      var1.setPaint(this.getPaint());
      double var38 = var12 + Math.cos(this.angle) * (this.baseRadius + this.labelOffset);
      double var40 = var14 + Math.sin(this.angle) * (this.baseRadius + this.labelOffset);
      TextUtilities.drawAlignedString(this.getText(), var1, (float)var38, (float)var40, this.getTextAnchor());
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CategoryPointerAnnotation)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         CategoryPointerAnnotation var2 = (CategoryPointerAnnotation)var1;
         return this.angle != var2.angle?false:(this.tipRadius != var2.tipRadius?false:(this.baseRadius != var2.baseRadius?false:(this.arrowLength != var2.arrowLength?false:(this.arrowWidth != var2.arrowWidth?false:(!this.arrowPaint.equals(var2.arrowPaint)?false:(!ObjectUtilities.equal(this.arrowStroke, var2.arrowStroke)?false:this.labelOffset == var2.labelOffset))))));
      }
   }

   public int hashCode() {
      short var1 = 193;
      long var2 = java.lang.Double.doubleToLongBits(this.angle);
      int var4 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.tipRadius);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.baseRadius);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.arrowLength);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.arrowWidth);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var4 = 37 * var4 + HashUtilities.hashCodeForPaint(this.arrowPaint);
      var4 = 37 * var4 + this.arrowStroke.hashCode();
      var2 = java.lang.Double.doubleToLongBits(this.labelOffset);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      return var4;
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.arrowPaint, var1);
      SerialUtilities.writeStroke(this.arrowStroke, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.arrowPaint = SerialUtilities.readPaint(var1);
      this.arrowStroke = SerialUtilities.readStroke(var1);
   }
}
