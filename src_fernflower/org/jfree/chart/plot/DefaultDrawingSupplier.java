package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import org.jfree.chart.ChartColor;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class DefaultDrawingSupplier implements Serializable, Cloneable, DrawingSupplier, PublicCloneable {
   private static final long serialVersionUID = -7339847061039422538L;
   public static final Paint[] DEFAULT_PAINT_SEQUENCE = ChartColor.createDefaultPaintArray();
   public static final Paint[] DEFAULT_OUTLINE_PAINT_SEQUENCE;
   public static final Stroke[] DEFAULT_STROKE_SEQUENCE;
   public static final Stroke[] DEFAULT_OUTLINE_STROKE_SEQUENCE;
   public static final Shape[] DEFAULT_SHAPE_SEQUENCE;
   private transient Paint[] paintSequence;
   private int paintIndex;
   private transient Paint[] outlinePaintSequence;
   private int outlinePaintIndex;
   private transient Stroke[] strokeSequence;
   private int strokeIndex;
   private transient Stroke[] outlineStrokeSequence;
   private int outlineStrokeIndex;
   private transient Shape[] shapeSequence;
   private int shapeIndex;

   public DefaultDrawingSupplier() {
      this(DEFAULT_PAINT_SEQUENCE, DEFAULT_OUTLINE_PAINT_SEQUENCE, DEFAULT_STROKE_SEQUENCE, DEFAULT_OUTLINE_STROKE_SEQUENCE, DEFAULT_SHAPE_SEQUENCE);
   }

   public DefaultDrawingSupplier(Paint[] var1, Paint[] var2, Stroke[] var3, Stroke[] var4, Shape[] var5) {
      this.paintSequence = var1;
      this.outlinePaintSequence = var2;
      this.strokeSequence = var3;
      this.outlineStrokeSequence = var4;
      this.shapeSequence = var5;
   }

   public Paint getNextPaint() {
      Paint var1 = this.paintSequence[this.paintIndex % this.paintSequence.length];
      ++this.paintIndex;
      return var1;
   }

   public Paint getNextOutlinePaint() {
      Paint var1 = this.outlinePaintSequence[this.outlinePaintIndex % this.outlinePaintSequence.length];
      ++this.outlinePaintIndex;
      return var1;
   }

   public Stroke getNextStroke() {
      Stroke var1 = this.strokeSequence[this.strokeIndex % this.strokeSequence.length];
      ++this.strokeIndex;
      return var1;
   }

   public Stroke getNextOutlineStroke() {
      Stroke var1 = this.outlineStrokeSequence[this.outlineStrokeIndex % this.outlineStrokeSequence.length];
      ++this.outlineStrokeIndex;
      return var1;
   }

   public Shape getNextShape() {
      Shape var1 = this.shapeSequence[this.shapeIndex % this.shapeSequence.length];
      ++this.shapeIndex;
      return var1;
   }

   public static Shape[] createStandardSeriesShapes() {
      Shape[] var0 = new Shape[10];
      double var1 = 6.0D;
      double var3 = var1 / 2.0D;
      Object var5 = null;
      Object var6 = null;
      var0[0] = new Double(-var3, -var3, var1, var1);
      var0[1] = new java.awt.geom.Ellipse2D.Double(-var3, -var3, var1, var1);
      int[] var7 = intArray(0.0D, var3, -var3);
      int[] var8 = intArray(-var3, var3, var3);
      var0[2] = new Polygon(var7, var8, 3);
      var7 = intArray(0.0D, var3, 0.0D, -var3);
      var8 = intArray(-var3, 0.0D, var3, 0.0D);
      var0[3] = new Polygon(var7, var8, 4);
      var0[4] = new Double(-var3, -var3 / 2.0D, var1, var1 / 2.0D);
      var7 = intArray(-var3, var3, 0.0D);
      var8 = intArray(-var3, -var3, var3);
      var0[5] = new Polygon(var7, var8, 3);
      var0[6] = new java.awt.geom.Ellipse2D.Double(-var3, -var3 / 2.0D, var1, var1 / 2.0D);
      var7 = intArray(-var3, var3, -var3);
      var8 = intArray(-var3, 0.0D, var3);
      var0[7] = new Polygon(var7, var8, 3);
      var0[8] = new Double(-var3 / 2.0D, -var3, var1 / 2.0D, var1);
      var7 = intArray(-var3, var3, var3);
      var8 = intArray(0.0D, -var3, var3);
      var0[9] = new Polygon(var7, var8, 3);
      return var0;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DefaultDrawingSupplier)) {
         return false;
      } else {
         DefaultDrawingSupplier var2 = (DefaultDrawingSupplier)var1;
         return !Arrays.equals(this.paintSequence, var2.paintSequence)?false:(this.paintIndex != var2.paintIndex?false:(!Arrays.equals(this.outlinePaintSequence, var2.outlinePaintSequence)?false:(this.outlinePaintIndex != var2.outlinePaintIndex?false:(!Arrays.equals(this.strokeSequence, var2.strokeSequence)?false:(this.strokeIndex != var2.strokeIndex?false:(!Arrays.equals(this.outlineStrokeSequence, var2.outlineStrokeSequence)?false:(this.outlineStrokeIndex != var2.outlineStrokeIndex?false:(!this.equalShapes(this.shapeSequence, var2.shapeSequence)?false:this.shapeIndex == var2.shapeIndex))))))));
      }
   }

   private boolean equalShapes(Shape[] var1, Shape[] var2) {
      if(var1 == null) {
         return var2 == null;
      } else if(var2 == null) {
         return false;
      } else if(var1.length != var2.length) {
         return false;
      } else {
         for(int var3 = 0; var3 < var1.length; ++var3) {
            if(!ShapeUtilities.equal(var1[var3], var2[var3])) {
               return false;
            }
         }

         return true;
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      int var2 = this.paintSequence.length;
      var1.writeInt(var2);

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         SerialUtilities.writePaint(this.paintSequence[var3], var1);
      }

      var3 = this.outlinePaintSequence.length;
      var1.writeInt(var3);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         SerialUtilities.writePaint(this.outlinePaintSequence[var4], var1);
      }

      var4 = this.strokeSequence.length;
      var1.writeInt(var4);

      int var5;
      for(var5 = 0; var5 < var4; ++var5) {
         SerialUtilities.writeStroke(this.strokeSequence[var5], var1);
      }

      var5 = this.outlineStrokeSequence.length;
      var1.writeInt(var5);

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         SerialUtilities.writeStroke(this.outlineStrokeSequence[var6], var1);
      }

      var6 = this.shapeSequence.length;
      var1.writeInt(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         SerialUtilities.writeShape(this.shapeSequence[var7], var1);
      }

   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      int var2 = var1.readInt();
      this.paintSequence = new Paint[var2];

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         this.paintSequence[var3] = SerialUtilities.readPaint(var1);
      }

      var3 = var1.readInt();
      this.outlinePaintSequence = new Paint[var3];

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.outlinePaintSequence[var4] = SerialUtilities.readPaint(var1);
      }

      var4 = var1.readInt();
      this.strokeSequence = new Stroke[var4];

      int var5;
      for(var5 = 0; var5 < var4; ++var5) {
         this.strokeSequence[var5] = SerialUtilities.readStroke(var1);
      }

      var5 = var1.readInt();
      this.outlineStrokeSequence = new Stroke[var5];

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         this.outlineStrokeSequence[var6] = SerialUtilities.readStroke(var1);
      }

      var6 = var1.readInt();
      this.shapeSequence = new Shape[var6];

      for(int var7 = 0; var7 < var6; ++var7) {
         this.shapeSequence[var7] = SerialUtilities.readShape(var1);
      }

   }

   private static int[] intArray(double var0, double var2, double var4) {
      return new int[]{(int)var0, (int)var2, (int)var4};
   }

   private static int[] intArray(double var0, double var2, double var4, double var6) {
      return new int[]{(int)var0, (int)var2, (int)var4, (int)var6};
   }

   public Object clone() {
      DefaultDrawingSupplier var1 = (DefaultDrawingSupplier)super.clone();
      return var1;
   }

   static {
      DEFAULT_OUTLINE_PAINT_SEQUENCE = new Paint[]{Color.lightGray};
      DEFAULT_STROKE_SEQUENCE = new Stroke[]{new BasicStroke(1.0F, 2, 2)};
      DEFAULT_OUTLINE_STROKE_SEQUENCE = new Stroke[]{new BasicStroke(1.0F, 2, 2)};
      DEFAULT_SHAPE_SEQUENCE = createStandardSeriesShapes();
   }
}
