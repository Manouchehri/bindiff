package org.jfree.chart.block;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.block.BlockFrame;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.PaintUtilities;

public class BlockBorder implements Serializable, BlockFrame {
   private static final long serialVersionUID = 4961579220410228283L;
   public static final BlockBorder NONE;
   private RectangleInsets insets;
   private transient Paint paint;

   public BlockBorder() {
      this(Color.black);
   }

   public BlockBorder(Paint var1) {
      this(new RectangleInsets(1.0D, 1.0D, 1.0D, 1.0D), var1);
   }

   public BlockBorder(double var1, double var3, double var5, double var7) {
      this(new RectangleInsets(var1, var3, var5, var7), Color.black);
   }

   public BlockBorder(double var1, double var3, double var5, double var7, Paint var9) {
      this(new RectangleInsets(var1, var3, var5, var7), var9);
   }

   public BlockBorder(RectangleInsets var1, Paint var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'insets\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.insets = var1;
         this.paint = var2;
      }
   }

   public RectangleInsets getInsets() {
      return this.insets;
   }

   public Paint getPaint() {
      return this.paint;
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      double var3 = this.insets.calculateTopInset(var2.getHeight());
      double var5 = this.insets.calculateBottomInset(var2.getHeight());
      double var7 = this.insets.calculateLeftInset(var2.getWidth());
      double var9 = this.insets.calculateRightInset(var2.getWidth());
      double var11 = var2.getX();
      double var13 = var2.getY();
      double var15 = var2.getWidth();
      double var17 = var2.getHeight();
      var1.setPaint(this.paint);
      Double var19 = new Double();
      if(var3 > 0.0D) {
         var19.setRect(var11, var13, var15, var3);
         var1.fill(var19);
      }

      if(var5 > 0.0D) {
         var19.setRect(var11, var13 + var17 - var5, var15, var5);
         var1.fill(var19);
      }

      if(var7 > 0.0D) {
         var19.setRect(var11, var13, var7, var17);
         var1.fill(var19);
      }

      if(var9 > 0.0D) {
         var19.setRect(var11 + var15 - var9, var13, var9, var17);
         var1.fill(var19);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BlockBorder)) {
         return false;
      } else {
         BlockBorder var2 = (BlockBorder)var1;
         return !this.insets.equals(var2.insets)?false:PaintUtilities.equal(this.paint, var2.paint);
      }
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
      NONE = new BlockBorder(RectangleInsets.ZERO_INSETS, Color.white);
   }
}
