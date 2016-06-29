package org.jfree.ui;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public final class RectangleEdge implements Serializable {
   private static final long serialVersionUID = -7400988293691093548L;
   public static final RectangleEdge TOP = new RectangleEdge("RectangleEdge.TOP");
   public static final RectangleEdge BOTTOM = new RectangleEdge("RectangleEdge.BOTTOM");
   public static final RectangleEdge LEFT = new RectangleEdge("RectangleEdge.LEFT");
   public static final RectangleEdge RIGHT = new RectangleEdge("RectangleEdge.RIGHT");
   private String name;

   private RectangleEdge(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof RectangleEdge)) {
         return false;
      } else {
         RectangleEdge var2 = (RectangleEdge)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   public static boolean isTopOrBottom(RectangleEdge var0) {
      return var0 == TOP || var0 == BOTTOM;
   }

   public static boolean isLeftOrRight(RectangleEdge var0) {
      return var0 == LEFT || var0 == RIGHT;
   }

   public static RectangleEdge opposite(RectangleEdge var0) {
      RectangleEdge var1 = null;
      if(var0 == TOP) {
         var1 = BOTTOM;
      } else if(var0 == BOTTOM) {
         var1 = TOP;
      } else if(var0 == LEFT) {
         var1 = RIGHT;
      } else if(var0 == RIGHT) {
         var1 = LEFT;
      }

      return var1;
   }

   public static double coordinate(Rectangle2D var0, RectangleEdge var1) {
      double var2 = 0.0D;
      if(var1 == TOP) {
         var2 = var0.getMinY();
      } else if(var1 == BOTTOM) {
         var2 = var0.getMaxY();
      } else if(var1 == LEFT) {
         var2 = var0.getMinX();
      } else if(var1 == RIGHT) {
         var2 = var0.getMaxX();
      }

      return var2;
   }

   private Object readResolve() {
      RectangleEdge var1 = null;
      if(this.equals(TOP)) {
         var1 = TOP;
      } else if(this.equals(BOTTOM)) {
         var1 = BOTTOM;
      } else if(this.equals(LEFT)) {
         var1 = LEFT;
      } else if(this.equals(RIGHT)) {
         var1 = RIGHT;
      }

      return var1;
   }
}
