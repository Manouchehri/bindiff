package org.jfree.chart.annotations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.chart.annotations.AbstractXYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class XYTextAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -2946063342782506328L;
   public static final Font DEFAULT_FONT = new Font("SansSerif", 0, 10);
   public static final Paint DEFAULT_PAINT;
   public static final TextAnchor DEFAULT_TEXT_ANCHOR;
   public static final TextAnchor DEFAULT_ROTATION_ANCHOR;
   public static final double DEFAULT_ROTATION_ANGLE = 0.0D;
   private String text;
   private Font font;
   private transient Paint paint;
   private double x;
   private double y;
   private TextAnchor textAnchor;
   private TextAnchor rotationAnchor;
   private double rotationAngle;

   public XYTextAnnotation(String var1, double var2, double var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'text\' argument.");
      } else {
         this.text = var1;
         this.font = DEFAULT_FONT;
         this.paint = DEFAULT_PAINT;
         this.x = var2;
         this.y = var4;
         this.textAnchor = DEFAULT_TEXT_ANCHOR;
         this.rotationAnchor = DEFAULT_ROTATION_ANCHOR;
         this.rotationAngle = 0.0D;
      }
   }

   public String getText() {
      return this.text;
   }

   public void setText(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'text\' argument.");
      } else {
         this.text = var1;
      }
   }

   public Font getFont() {
      return this.font;
   }

   public void setFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.font = var1;
      }
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

   public TextAnchor getTextAnchor() {
      return this.textAnchor;
   }

   public void setTextAnchor(TextAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.textAnchor = var1;
      }
   }

   public TextAnchor getRotationAnchor() {
      return this.rotationAnchor;
   }

   public void setRotationAnchor(TextAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.rotationAnchor = var1;
      }
   }

   public double getRotationAngle() {
      return this.rotationAngle;
   }

   public void setRotationAngle(double var1) {
      this.rotationAngle = var1;
   }

   public double getX() {
      return this.x;
   }

   public void setX(double var1) {
      this.x = var1;
   }

   public double getY() {
      return this.y;
   }

   public void setY(double var1) {
      this.y = var1;
   }

   public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7) {
      PlotOrientation var8 = var2.getOrientation();
      RectangleEdge var9 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var8);
      RectangleEdge var10 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var8);
      float var11 = (float)var4.valueToJava2D(this.x, var3, var9);
      float var12 = (float)var5.valueToJava2D(this.y, var3, var10);
      if(var8 == PlotOrientation.HORIZONTAL) {
         float var13 = var11;
         var11 = var12;
         var12 = var13;
      }

      var1.setFont(this.getFont());
      var1.setPaint(this.getPaint());
      TextUtilities.drawRotatedString(this.getText(), var1, var11, var12, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
      Shape var16 = TextUtilities.calculateRotatedStringBounds(this.getText(), var1, var11, var12, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
      String var14 = this.getToolTipText();
      String var15 = this.getURL();
      if(var14 != null || var15 != null) {
         this.addEntity(var7, var16, var6, var14, var15);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYTextAnnotation)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         XYTextAnnotation var2 = (XYTextAnnotation)var1;
         return !this.text.equals(var2.text)?false:(this.x != var2.x?false:(this.y != var2.y?false:(!this.font.equals(var2.font)?false:(!PaintUtilities.equal(this.paint, var2.paint)?false:(!this.rotationAnchor.equals(var2.rotationAnchor)?false:(this.rotationAngle != var2.rotationAngle?false:this.textAnchor.equals(var2.textAnchor)))))));
      }
   }

   public int hashCode() {
      boolean var1 = true;
      int var4 = 37 * this.text.hashCode();
      var4 = 37 * this.font.hashCode();
      var4 = 37 * var4 + HashUtilities.hashCodeForPaint(this.paint);
      long var2 = Double.doubleToLongBits(this.x);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.y);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var4 = 37 * var4 + this.textAnchor.hashCode();
      var4 = 37 * var4 + this.rotationAnchor.hashCode();
      var2 = Double.doubleToLongBits(this.rotationAngle);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      return var4;
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
   }

   static {
      DEFAULT_PAINT = Color.black;
      DEFAULT_TEXT_ANCHOR = TextAnchor.CENTER;
      DEFAULT_ROTATION_ANCHOR = TextAnchor.CENTER;
   }
}
