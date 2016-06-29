package org.jfree.ui;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.io.Serializable;
import org.jfree.ui.Size2D;

public final class RectangleAnchor implements Serializable {
   private static final long serialVersionUID = -2457494205644416327L;
   public static final RectangleAnchor CENTER = new RectangleAnchor("RectangleAnchor.CENTER");
   public static final RectangleAnchor TOP = new RectangleAnchor("RectangleAnchor.TOP");
   public static final RectangleAnchor TOP_LEFT = new RectangleAnchor("RectangleAnchor.TOP_LEFT");
   public static final RectangleAnchor TOP_RIGHT = new RectangleAnchor("RectangleAnchor.TOP_RIGHT");
   public static final RectangleAnchor BOTTOM = new RectangleAnchor("RectangleAnchor.BOTTOM");
   public static final RectangleAnchor BOTTOM_LEFT = new RectangleAnchor("RectangleAnchor.BOTTOM_LEFT");
   public static final RectangleAnchor BOTTOM_RIGHT = new RectangleAnchor("RectangleAnchor.BOTTOM_RIGHT");
   public static final RectangleAnchor LEFT = new RectangleAnchor("RectangleAnchor.LEFT");
   public static final RectangleAnchor RIGHT = new RectangleAnchor("RectangleAnchor.RIGHT");
   private String name;

   private RectangleAnchor(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof RectangleAnchor)) {
         return false;
      } else {
         RectangleAnchor var2 = (RectangleAnchor)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   public static Point2D coordinates(Rectangle2D var0, RectangleAnchor var1) {
      Double var2 = new Double();
      if(var1 == CENTER) {
         var2.setLocation(var0.getCenterX(), var0.getCenterY());
      } else if(var1 == TOP) {
         var2.setLocation(var0.getCenterX(), var0.getMinY());
      } else if(var1 == BOTTOM) {
         var2.setLocation(var0.getCenterX(), var0.getMaxY());
      } else if(var1 == LEFT) {
         var2.setLocation(var0.getMinX(), var0.getCenterY());
      } else if(var1 == RIGHT) {
         var2.setLocation(var0.getMaxX(), var0.getCenterY());
      } else if(var1 == TOP_LEFT) {
         var2.setLocation(var0.getMinX(), var0.getMinY());
      } else if(var1 == TOP_RIGHT) {
         var2.setLocation(var0.getMaxX(), var0.getMinY());
      } else if(var1 == BOTTOM_LEFT) {
         var2.setLocation(var0.getMinX(), var0.getMaxY());
      } else if(var1 == BOTTOM_RIGHT) {
         var2.setLocation(var0.getMaxX(), var0.getMaxY());
      }

      return var2;
   }

   public static Rectangle2D createRectangle(Size2D var0, double var1, double var3, RectangleAnchor var5) {
      java.awt.geom.Rectangle2D.Double var6 = null;
      double var7 = var0.getWidth();
      double var9 = var0.getHeight();
      if(var5 == CENTER) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1 - var7 / 2.0D, var3 - var9 / 2.0D, var7, var9);
      } else if(var5 == TOP) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1 - var7 / 2.0D, var3 - var9 / 2.0D, var7, var9);
      } else if(var5 == BOTTOM) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1 - var7 / 2.0D, var3 - var9 / 2.0D, var7, var9);
      } else if(var5 == LEFT) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1, var3 - var9 / 2.0D, var7, var9);
      } else if(var5 == RIGHT) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1 - var7, var3 - var9 / 2.0D, var7, var9);
      } else if(var5 == TOP_LEFT) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1 - var7 / 2.0D, var3 - var9 / 2.0D, var7, var9);
      } else if(var5 == TOP_RIGHT) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1 - var7 / 2.0D, var3 - var9 / 2.0D, var7, var9);
      } else if(var5 == BOTTOM_LEFT) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1 - var7 / 2.0D, var3 - var9 / 2.0D, var7, var9);
      } else if(var5 == BOTTOM_RIGHT) {
         var6 = new java.awt.geom.Rectangle2D.Double(var1 - var7 / 2.0D, var3 - var9 / 2.0D, var7, var9);
      }

      return var6;
   }

   private Object readResolve() {
      RectangleAnchor var1 = null;
      if(this.equals(CENTER)) {
         var1 = CENTER;
      } else if(this.equals(TOP)) {
         var1 = TOP;
      } else if(this.equals(BOTTOM)) {
         var1 = BOTTOM;
      } else if(this.equals(LEFT)) {
         var1 = LEFT;
      } else if(this.equals(RIGHT)) {
         var1 = RIGHT;
      } else if(this.equals(TOP_LEFT)) {
         var1 = TOP_LEFT;
      } else if(this.equals(TOP_RIGHT)) {
         var1 = TOP_RIGHT;
      } else if(this.equals(BOTTOM_LEFT)) {
         var1 = BOTTOM_LEFT;
      } else if(this.equals(BOTTOM_RIGHT)) {
         var1 = BOTTOM_RIGHT;
      }

      return var1;
   }
}
