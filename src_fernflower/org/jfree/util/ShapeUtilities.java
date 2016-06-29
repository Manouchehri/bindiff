package org.jfree.util;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.Arrays;
import org.jfree.ui.RectangleAnchor;
import org.jfree.util.ObjectUtilities;

public class ShapeUtilities {
   private static final float SQRT2 = (float)Math.pow(2.0D, 0.5D);

   public static Shape clone(Shape var0) {
      if(var0 instanceof Cloneable) {
         try {
            return (Shape)ObjectUtilities.clone(var0);
         } catch (CloneNotSupportedException var2) {
            ;
         }
      }

      Object var1 = null;
      return (Shape)var1;
   }

   public static boolean equal(Shape var0, Shape var1) {
      return var0 instanceof Line2D && var1 instanceof Line2D?equal((Line2D)var0, (Line2D)var1):(var0 instanceof Ellipse2D && var1 instanceof Ellipse2D?equal((Ellipse2D)var0, (Ellipse2D)var1):(var0 instanceof Arc2D && var1 instanceof Arc2D?equal((Arc2D)var0, (Arc2D)var1):(var0 instanceof Polygon && var1 instanceof Polygon?equal((Polygon)var0, (Polygon)var1):(var0 instanceof GeneralPath && var1 instanceof GeneralPath?equal((GeneralPath)var0, (GeneralPath)var1):ObjectUtilities.equal(var0, var1)))));
   }

   public static boolean equal(Line2D var0, Line2D var1) {
      return var0 == null?var1 == null:(var1 == null?false:(!var0.getP1().equals(var1.getP1())?false:var0.getP2().equals(var1.getP2())));
   }

   public static boolean equal(Ellipse2D var0, Ellipse2D var1) {
      return var0 == null?var1 == null:(var1 == null?false:var0.getFrame().equals(var1.getFrame()));
   }

   public static boolean equal(Arc2D var0, Arc2D var1) {
      return var0 == null?var1 == null:(var1 == null?false:(!var0.getFrame().equals(var1.getFrame())?false:(var0.getAngleStart() != var1.getAngleStart()?false:(var0.getAngleExtent() != var1.getAngleExtent()?false:var0.getArcType() == var1.getArcType()))));
   }

   public static boolean equal(Polygon var0, Polygon var1) {
      return var0 == null?var1 == null:(var1 == null?false:(var0.npoints != var1.npoints?false:(!Arrays.equals(var0.xpoints, var1.xpoints)?false:Arrays.equals(var0.ypoints, var1.ypoints))));
   }

   public static boolean equal(GeneralPath var0, GeneralPath var1) {
      if(var0 == null) {
         return var1 == null;
      } else if(var1 == null) {
         return false;
      } else if(var0.getWindingRule() != var1.getWindingRule()) {
         return false;
      } else {
         PathIterator var2 = var0.getPathIterator((AffineTransform)null);
         PathIterator var3 = var0.getPathIterator((AffineTransform)null);
         double[] var4 = new double[6];
         double[] var5 = new double[6];

         for(boolean var6 = var2.isDone() && var3.isDone(); !var6; var6 = var2.isDone() && var3.isDone()) {
            if(var2.isDone() != var3.isDone()) {
               return false;
            }

            int var7 = var2.currentSegment(var4);
            int var8 = var3.currentSegment(var5);
            if(var7 != var8) {
               return false;
            }

            if(!Arrays.equals(var4, var5)) {
               return false;
            }

            var2.next();
            var3.next();
         }

         return true;
      }
   }

   public static Shape createTranslatedShape(Shape var0, double var1, double var3) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else {
         AffineTransform var5 = AffineTransform.getTranslateInstance(var1, var3);
         return var5.createTransformedShape(var0);
      }
   }

   public static Shape createTranslatedShape(Shape var0, RectangleAnchor var1, double var2, double var4) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         Point2D var6 = RectangleAnchor.coordinates(var0.getBounds2D(), var1);
         AffineTransform var7 = AffineTransform.getTranslateInstance(var2 - var6.getX(), var4 - var6.getY());
         return var7.createTransformedShape(var0);
      }
   }

   public static Shape rotateShape(Shape var0, double var1, float var3, float var4) {
      if(var0 == null) {
         return null;
      } else {
         AffineTransform var5 = AffineTransform.getRotateInstance(var1, (double)var3, (double)var4);
         Shape var6 = var5.createTransformedShape(var0);
         return var6;
      }
   }

   public static void drawRotatedShape(Graphics2D var0, Shape var1, double var2, float var4, float var5) {
      AffineTransform var6 = var0.getTransform();
      AffineTransform var7 = AffineTransform.getRotateInstance(var2, (double)var4, (double)var5);
      var0.transform(var7);
      var0.draw(var1);
      var0.setTransform(var6);
   }

   public static Shape createDiagonalCross(float var0, float var1) {
      GeneralPath var2 = new GeneralPath();
      var2.moveTo(-var0 - var1, -var0 + var1);
      var2.lineTo(-var0 + var1, -var0 - var1);
      var2.lineTo(0.0F, -var1 * SQRT2);
      var2.lineTo(var0 - var1, -var0 - var1);
      var2.lineTo(var0 + var1, -var0 + var1);
      var2.lineTo(var1 * SQRT2, 0.0F);
      var2.lineTo(var0 + var1, var0 - var1);
      var2.lineTo(var0 - var1, var0 + var1);
      var2.lineTo(0.0F, var1 * SQRT2);
      var2.lineTo(-var0 + var1, var0 + var1);
      var2.lineTo(-var0 - var1, var0 - var1);
      var2.lineTo(-var1 * SQRT2, 0.0F);
      var2.closePath();
      return var2;
   }

   public static Shape createRegularCross(float var0, float var1) {
      GeneralPath var2 = new GeneralPath();
      var2.moveTo(-var0, var1);
      var2.lineTo(-var1, var1);
      var2.lineTo(-var1, var0);
      var2.lineTo(var1, var0);
      var2.lineTo(var1, var1);
      var2.lineTo(var0, var1);
      var2.lineTo(var0, -var1);
      var2.lineTo(var1, -var1);
      var2.lineTo(var1, -var0);
      var2.lineTo(-var1, -var0);
      var2.lineTo(-var1, -var1);
      var2.lineTo(-var0, -var1);
      var2.closePath();
      return var2;
   }

   public static Shape createDiamond(float var0) {
      GeneralPath var1 = new GeneralPath();
      var1.moveTo(0.0F, -var0);
      var1.lineTo(var0, 0.0F);
      var1.lineTo(0.0F, var0);
      var1.lineTo(-var0, 0.0F);
      var1.closePath();
      return var1;
   }

   public static Shape createUpTriangle(float var0) {
      GeneralPath var1 = new GeneralPath();
      var1.moveTo(0.0F, -var0);
      var1.lineTo(var0, var0);
      var1.lineTo(-var0, var0);
      var1.closePath();
      return var1;
   }

   public static Shape createDownTriangle(float var0) {
      GeneralPath var1 = new GeneralPath();
      var1.moveTo(0.0F, var0);
      var1.lineTo(var0, -var0);
      var1.lineTo(-var0, -var0);
      var1.closePath();
      return var1;
   }

   public static Shape createLineRegion(Line2D var0, float var1) {
      GeneralPath var2 = new GeneralPath();
      float var3 = (float)var0.getX1();
      float var4 = (float)var0.getX2();
      float var5 = (float)var0.getY1();
      float var6 = (float)var0.getY2();
      if((double)(var4 - var3) != 0.0D) {
         double var7 = Math.atan((double)((var6 - var5) / (var4 - var3)));
         float var9 = (float)Math.sin(var7) * var1;
         float var10 = (float)Math.cos(var7) * var1;
         var2.moveTo(var3 - var9, var5 + var10);
         var2.lineTo(var3 + var9, var5 - var10);
         var2.lineTo(var4 + var9, var6 - var10);
         var2.lineTo(var4 - var9, var6 + var10);
         var2.closePath();
      } else {
         var2.moveTo(var3 - var1 / 2.0F, var5);
         var2.lineTo(var3 + var1 / 2.0F, var5);
         var2.lineTo(var4 + var1 / 2.0F, var6);
         var2.lineTo(var4 - var1 / 2.0F, var6);
         var2.closePath();
      }

      return var2;
   }

   public static Point2D getPointInRectangle(double var0, double var2, Rectangle2D var4) {
      var0 = Math.max(var4.getMinX(), Math.min(var0, var4.getMaxX()));
      var2 = Math.max(var4.getMinY(), Math.min(var2, var4.getMaxY()));
      return new Double(var0, var2);
   }

   public static boolean contains(Rectangle2D var0, Rectangle2D var1) {
      double var2 = var0.getX();
      double var4 = var0.getY();
      double var6 = var1.getX();
      double var8 = var1.getY();
      double var10 = var1.getWidth();
      double var12 = var1.getHeight();
      return var6 >= var2 && var8 >= var4 && var6 + var10 <= var2 + var0.getWidth() && var8 + var12 <= var4 + var0.getHeight();
   }

   public static boolean intersects(Rectangle2D var0, Rectangle2D var1) {
      double var2 = var0.getX();
      double var4 = var0.getY();
      double var6 = var1.getX();
      double var8 = var1.getWidth();
      double var10 = var1.getY();
      double var12 = var1.getHeight();
      return var6 + var8 >= var2 && var10 + var12 >= var4 && var6 <= var2 + var0.getWidth() && var10 <= var4 + var0.getHeight();
   }
}
