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
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class XYPointerAnnotation extends XYTextAnnotation implements Serializable, Cloneable, PublicCloneable {
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

   public XYPointerAnnotation(String var1, double var2, double var4, double var6) {
      super(var1, var2, var4);
      this.angle = var6;
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

   public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7) {
      PlotOrientation var8 = var2.getOrientation();
      RectangleEdge var9 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var8);
      RectangleEdge var10 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var8);
      double var11 = var4.valueToJava2D(this.getX(), var3, var9);
      double var13 = var5.valueToJava2D(this.getY(), var3, var10);
      double var15;
      if(var8 == PlotOrientation.HORIZONTAL) {
         var15 = var11;
         var11 = var13;
         var13 = var15;
      }

      var15 = var11 + Math.cos(this.angle) * this.baseRadius;
      double var17 = var13 + Math.sin(this.angle) * this.baseRadius;
      double var19 = var11 + Math.cos(this.angle) * this.tipRadius;
      double var21 = var13 + Math.sin(this.angle) * this.tipRadius;
      double var23 = var19 + Math.cos(this.angle) * this.arrowLength;
      double var25 = var21 + Math.sin(this.angle) * this.arrowLength;
      double var27 = var23 + Math.cos(this.angle + 1.5707963267948966D) * this.arrowWidth;
      double var29 = var25 + Math.sin(this.angle + 1.5707963267948966D) * this.arrowWidth;
      double var31 = var23 - Math.cos(this.angle + 1.5707963267948966D) * this.arrowWidth;
      double var33 = var25 - Math.sin(this.angle + 1.5707963267948966D) * this.arrowWidth;
      GeneralPath var35 = new GeneralPath();
      var35.moveTo((float)var19, (float)var21);
      var35.lineTo((float)var27, (float)var29);
      var35.lineTo((float)var31, (float)var33);
      var35.closePath();
      var1.setStroke(this.arrowStroke);
      var1.setPaint(this.arrowPaint);
      Double var36 = new Double(var15, var17, var19, var21);
      var1.draw(var36);
      var1.fill(var35);
      var1.setFont(this.getFont());
      var1.setPaint(this.getPaint());
      double var37 = var11 + Math.cos(this.angle) * (this.baseRadius + this.labelOffset);
      double var39 = var13 + Math.sin(this.angle) * (this.baseRadius + this.labelOffset);
      Rectangle2D var41 = TextUtilities.drawAlignedString(this.getText(), var1, (float)var37, (float)var39, this.getTextAnchor());
      String var42 = this.getToolTipText();
      String var43 = this.getURL();
      if(var42 != null || var43 != null) {
         this.addEntity(var7, var41, var6, var42, var43);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYPointerAnnotation)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         XYPointerAnnotation var2 = (XYPointerAnnotation)var1;
         return this.angle != var2.angle?false:(this.tipRadius != var2.tipRadius?false:(this.baseRadius != var2.baseRadius?false:(this.arrowLength != var2.arrowLength?false:(this.arrowWidth != var2.arrowWidth?false:(!this.arrowPaint.equals(var2.arrowPaint)?false:(!ObjectUtilities.equal(this.arrowStroke, var2.arrowStroke)?false:this.labelOffset == var2.labelOffset))))));
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      long var2 = java.lang.Double.doubleToLongBits(this.angle);
      var1 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.tipRadius);
      var1 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.baseRadius);
      var1 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.arrowLength);
      var1 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.arrowWidth);
      var1 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      var1 = var1 * 37 + HashUtilities.hashCodeForPaint(this.arrowPaint);
      var1 = var1 * 37 + this.arrowStroke.hashCode();
      var2 = java.lang.Double.doubleToLongBits(this.labelOffset);
      var1 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      return super.hashCode();
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
