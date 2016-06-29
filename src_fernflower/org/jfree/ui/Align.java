package org.jfree.ui;

import java.awt.geom.Rectangle2D;

public final class Align {
   public static final int CENTER = 0;
   public static final int TOP = 1;
   public static final int BOTTOM = 2;
   public static final int LEFT = 4;
   public static final int RIGHT = 8;
   public static final int TOP_LEFT = 5;
   public static final int TOP_RIGHT = 9;
   public static final int BOTTOM_LEFT = 6;
   public static final int BOTTOM_RIGHT = 10;
   public static final int FIT_HORIZONTAL = 12;
   public static final int FIT_VERTICAL = 3;
   public static final int FIT = 15;
   public static final int NORTH = 1;
   public static final int SOUTH = 2;
   public static final int WEST = 4;
   public static final int EAST = 8;
   public static final int NORTH_WEST = 5;
   public static final int NORTH_EAST = 9;
   public static final int SOUTH_WEST = 6;
   public static final int SOUTH_EAST = 10;

   public static void align(Rectangle2D var0, Rectangle2D var1, int var2) {
      double var3 = var1.getCenterX() - var0.getWidth() / 2.0D;
      double var5 = var1.getCenterY() - var0.getHeight() / 2.0D;
      double var7 = var0.getWidth();
      double var9 = var0.getHeight();
      if((var2 & 3) == 3) {
         var9 = var1.getHeight();
      }

      if((var2 & 12) == 12) {
         var7 = var1.getWidth();
      }

      if((var2 & 1) == 1) {
         var5 = var1.getMinY();
      }

      if((var2 & 2) == 2) {
         var5 = var1.getMaxY() - var9;
      }

      if((var2 & 4) == 4) {
         var3 = var1.getX();
      }

      if((var2 & 8) == 8) {
         var3 = var1.getMaxX() - var7;
      }

      var0.setRect(var3, var5, var7, var9);
   }
}
