package org.jfree.chart.needle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public abstract class MeterNeedle implements Serializable {
   private static final long serialVersionUID = 5203064851510951052L;
   private transient Paint outlinePaint;
   private transient Stroke outlineStroke;
   private transient Paint fillPaint;
   private transient Paint highlightPaint;
   private int size;
   private double rotateX;
   private double rotateY;
   protected static AffineTransform transform = new AffineTransform();

   public MeterNeedle() {
      this((Paint)null, (Paint)null, (Paint)null);
   }

   public MeterNeedle(Paint var1, Paint var2, Paint var3) {
      this.outlinePaint = Color.black;
      this.outlineStroke = new BasicStroke(2.0F);
      this.fillPaint = null;
      this.highlightPaint = null;
      this.size = 5;
      this.rotateX = 0.5D;
      this.rotateY = 0.5D;
      this.fillPaint = var2;
      this.highlightPaint = var3;
      this.outlinePaint = var1;
   }

   public Paint getOutlinePaint() {
      return this.outlinePaint;
   }

   public void setOutlinePaint(Paint var1) {
      if(var1 != null) {
         this.outlinePaint = var1;
      }

   }

   public Stroke getOutlineStroke() {
      return this.outlineStroke;
   }

   public void setOutlineStroke(Stroke var1) {
      if(var1 != null) {
         this.outlineStroke = var1;
      }

   }

   public Paint getFillPaint() {
      return this.fillPaint;
   }

   public void setFillPaint(Paint var1) {
      if(var1 != null) {
         this.fillPaint = var1;
      }

   }

   public Paint getHighlightPaint() {
      return this.highlightPaint;
   }

   public void setHighlightPaint(Paint var1) {
      if(var1 != null) {
         this.highlightPaint = var1;
      }

   }

   public double getRotateX() {
      return this.rotateX;
   }

   public void setRotateX(double var1) {
      this.rotateX = var1;
   }

   public void setRotateY(double var1) {
      this.rotateY = var1;
   }

   public double getRotateY() {
      return this.rotateY;
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      this.draw(var1, var2, 0.0D);
   }

   public void draw(Graphics2D var1, Rectangle2D var2, double var3) {
      Double var5 = new Double();
      var5.setLocation(var2.getMinX() + this.rotateX * var2.getWidth(), var2.getMinY() + this.rotateY * var2.getHeight());
      this.draw(var1, var2, var5, var3);
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      Color var6 = var1.getColor();
      Stroke var7 = var1.getStroke();
      this.drawNeedle(var1, var2, var3, Math.toRadians(var4));
      var1.setStroke(var7);
      var1.setPaint(var6);
   }

   protected abstract void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4);

   protected void defaultDisplay(Graphics2D var1, Shape var2) {
      if(this.fillPaint != null) {
         var1.setPaint(this.fillPaint);
         var1.fill(var2);
      }

      if(this.outlinePaint != null) {
         var1.setStroke(this.outlineStroke);
         var1.setPaint(this.outlinePaint);
         var1.draw(var2);
      }

   }

   public int getSize() {
      return this.size;
   }

   public void setSize(int var1) {
      this.size = var1;
   }

   public AffineTransform getTransform() {
      return transform;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MeterNeedle)) {
         return false;
      } else {
         MeterNeedle var2 = (MeterNeedle)var1;
         return !PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:(!ObjectUtilities.equal(this.outlineStroke, var2.outlineStroke)?false:(!PaintUtilities.equal(this.fillPaint, var2.fillPaint)?false:(!PaintUtilities.equal(this.highlightPaint, var2.highlightPaint)?false:(this.size != var2.size?false:(this.rotateX != var2.rotateX?false:this.rotateY == var2.rotateY)))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.outlineStroke, var1);
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writePaint(this.fillPaint, var1);
      SerialUtilities.writePaint(this.highlightPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.outlineStroke = SerialUtilities.readStroke(var1);
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.fillPaint = SerialUtilities.readPaint(var1);
      this.highlightPaint = SerialUtilities.readPaint(var1);
   }
}
