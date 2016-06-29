package org.jfree.text;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;

public class TextBox implements Serializable {
   private static final long serialVersionUID = 3360220213180203706L;
   private transient Paint outlinePaint;
   private transient Stroke outlineStroke;
   private RectangleInsets interiorGap;
   private transient Paint backgroundPaint;
   private transient Paint shadowPaint;
   private double shadowXOffset;
   private double shadowYOffset;
   private TextBlock textBlock;

   public TextBox() {
      this((TextBlock)null);
   }

   public TextBox(String var1) {
      this((TextBlock)null);
      if(var1 != null) {
         this.textBlock = new TextBlock();
         this.textBlock.addLine(var1, new Font("SansSerif", 0, 10), Color.black);
      }

   }

   public TextBox(TextBlock var1) {
      this.shadowXOffset = 2.0D;
      this.shadowYOffset = 2.0D;
      this.outlinePaint = Color.black;
      this.outlineStroke = new BasicStroke(1.0F);
      this.interiorGap = new RectangleInsets(1.0D, 3.0D, 1.0D, 3.0D);
      this.backgroundPaint = new Color(255, 255, 192);
      this.shadowPaint = Color.gray;
      this.shadowXOffset = 2.0D;
      this.shadowYOffset = 2.0D;
      this.textBlock = var1;
   }

   public Paint getOutlinePaint() {
      return this.outlinePaint;
   }

   public void setOutlinePaint(Paint var1) {
      this.outlinePaint = var1;
   }

   public Stroke getOutlineStroke() {
      return this.outlineStroke;
   }

   public void setOutlineStroke(Stroke var1) {
      this.outlineStroke = var1;
   }

   public RectangleInsets getInteriorGap() {
      return this.interiorGap;
   }

   public void setInteriorGap(RectangleInsets var1) {
      this.interiorGap = var1;
   }

   public Paint getBackgroundPaint() {
      return this.backgroundPaint;
   }

   public void setBackgroundPaint(Paint var1) {
      this.backgroundPaint = var1;
   }

   public Paint getShadowPaint() {
      return this.shadowPaint;
   }

   public void setShadowPaint(Paint var1) {
      this.shadowPaint = var1;
   }

   public double getShadowXOffset() {
      return this.shadowXOffset;
   }

   public void setShadowXOffset(double var1) {
      this.shadowXOffset = var1;
   }

   public double getShadowYOffset() {
      return this.shadowYOffset;
   }

   public void setShadowYOffset(double var1) {
      this.shadowYOffset = var1;
   }

   public TextBlock getTextBlock() {
      return this.textBlock;
   }

   public void setTextBlock(TextBlock var1) {
      this.textBlock = var1;
   }

   public void draw(Graphics2D var1, float var2, float var3, RectangleAnchor var4) {
      Size2D var5 = this.textBlock.calculateDimensions(var1);
      double var6 = this.interiorGap.extendWidth(var5.getWidth());
      double var8 = this.interiorGap.extendHeight(var5.getHeight());
      Size2D var10 = new Size2D(var6, var8);
      Rectangle2D var11 = RectangleAnchor.createRectangle(var10, (double)var2, (double)var3, var4);
      if(this.shadowPaint != null) {
         Double var12 = new Double(var11.getX() + this.shadowXOffset, var11.getY() + this.shadowYOffset, var11.getWidth(), var11.getHeight());
         var1.setPaint(this.shadowPaint);
         var1.fill(var12);
      }

      if(this.backgroundPaint != null) {
         var1.setPaint(this.backgroundPaint);
         var1.fill(var11);
      }

      if(this.outlinePaint != null && this.outlineStroke != null) {
         var1.setPaint(this.outlinePaint);
         var1.setStroke(this.outlineStroke);
         var1.draw(var11);
      }

      this.textBlock.draw(var1, (float)var11.getCenterX(), (float)var11.getCenterY(), TextBlockAnchor.CENTER);
   }

   public double getHeight(Graphics2D var1) {
      Size2D var2 = this.textBlock.calculateDimensions(var1);
      return this.interiorGap.extendHeight(var2.getHeight());
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TextBox)) {
         return false;
      } else {
         TextBox var2 = (TextBox)var1;
         return !ObjectUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:(!ObjectUtilities.equal(this.outlineStroke, var2.outlineStroke)?false:(!ObjectUtilities.equal(this.interiorGap, var2.interiorGap)?false:(!ObjectUtilities.equal(this.backgroundPaint, var2.backgroundPaint)?false:(!ObjectUtilities.equal(this.shadowPaint, var2.shadowPaint)?false:(this.shadowXOffset != var2.shadowXOffset?false:(this.shadowYOffset != var2.shadowYOffset?false:ObjectUtilities.equal(this.textBlock, var2.textBlock)))))));
      }
   }

   public int hashCode() {
      int var1 = this.outlinePaint != null?this.outlinePaint.hashCode():0;
      var1 = 29 * var1 + (this.outlineStroke != null?this.outlineStroke.hashCode():0);
      var1 = 29 * var1 + (this.interiorGap != null?this.interiorGap.hashCode():0);
      var1 = 29 * var1 + (this.backgroundPaint != null?this.backgroundPaint.hashCode():0);
      var1 = 29 * var1 + (this.shadowPaint != null?this.shadowPaint.hashCode():0);
      long var2 = this.shadowXOffset != 0.0D?java.lang.Double.doubleToLongBits(this.shadowXOffset):0L;
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.shadowYOffset != 0.0D?java.lang.Double.doubleToLongBits(this.shadowYOffset):0L;
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var1 = 29 * var1 + (this.textBlock != null?this.textBlock.hashCode():0);
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writeStroke(this.outlineStroke, var1);
      SerialUtilities.writePaint(this.backgroundPaint, var1);
      SerialUtilities.writePaint(this.shadowPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.outlineStroke = SerialUtilities.readStroke(var1);
      this.backgroundPaint = SerialUtilities.readPaint(var1);
      this.shadowPaint = SerialUtilities.readPaint(var1);
   }
}
