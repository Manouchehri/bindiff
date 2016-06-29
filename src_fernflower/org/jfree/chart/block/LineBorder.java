package org.jfree.chart.block;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.block.BlockFrame;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class LineBorder implements Serializable, BlockFrame {
   private transient Paint paint;
   private transient Stroke stroke;
   private RectangleInsets insets;

   public LineBorder() {
      this(Color.black, new BasicStroke(1.0F), new RectangleInsets(1.0D, 1.0D, 1.0D, 1.0D));
   }

   public LineBorder(Paint var1, Stroke var2, RectangleInsets var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'insets\' argument.");
      } else {
         this.paint = var1;
         this.stroke = var2;
         this.insets = var3;
      }
   }

   public Paint getPaint() {
      return this.paint;
   }

   public RectangleInsets getInsets() {
      return this.insets;
   }

   public Stroke getStroke() {
      return this.stroke;
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      double var3 = var2.getWidth();
      double var5 = var2.getHeight();
      double var7 = this.insets.calculateTopInset(var5);
      double var9 = this.insets.calculateBottomInset(var5);
      double var11 = this.insets.calculateLeftInset(var3);
      double var13 = this.insets.calculateRightInset(var3);
      double var15 = var2.getX();
      double var17 = var2.getY();
      double var19 = var15 + var11 / 2.0D;
      double var21 = var15 + var3 - var13 / 2.0D;
      double var23 = var17 + var5 - var9 / 2.0D;
      double var25 = var17 + var7 / 2.0D;
      var1.setPaint(this.getPaint());
      var1.setStroke(this.getStroke());
      Double var27 = new Double();
      if(var7 > 0.0D) {
         var27.setLine(var19, var25, var21, var25);
         var1.draw(var27);
      }

      if(var9 > 0.0D) {
         var27.setLine(var19, var23, var21, var23);
         var1.draw(var27);
      }

      if(var11 > 0.0D) {
         var27.setLine(var19, var23, var19, var25);
         var1.draw(var27);
      }

      if(var13 > 0.0D) {
         var27.setLine(var21, var23, var21, var25);
         var1.draw(var27);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LineBorder)) {
         return false;
      } else {
         LineBorder var2 = (LineBorder)var1;
         return !PaintUtilities.equal(this.paint, var2.paint)?false:(!ObjectUtilities.equal(this.stroke, var2.stroke)?false:this.insets.equals(var2.insets));
      }
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
