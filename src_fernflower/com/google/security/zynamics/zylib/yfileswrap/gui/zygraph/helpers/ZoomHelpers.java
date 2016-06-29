package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import y.h.ch;

public class ZoomHelpers {
   public static final double MAX_ZOOM = 3.0D;

   private static void decreaseToMaxZoom(ch var0) {
      if(var0.getZoom() > 3.0D) {
         var0.setZoom(3.0D);
      }

   }

   private static void increaseToMinZoom(ch var0) {
      double var1 = getMinimumZoom(var0);
      if(var0.getZoom() < var1) {
         var0.setZoom(var1);
      }

   }

   public static double getMinimumZoom(ch var0) {
      double var1 = var0.getZoom();
      if(var1 < 0.0D) {
         var1 = 1.0D;
      }

      Point2D var3 = var0.getViewPoint2D();
      Rectangle var4 = var0.getGraph2D().a();
      var0.zoomToArea(var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
      double var5 = var0.getZoom();
      var0.setZoom(var1);
      var0.setViewPoint2D(var3.getX(), var3.getY());
      return var5 - var5 / 2.0D;
   }

   public static void keepZoomValid(ch var0) {
      decreaseToMaxZoom(var0);
      increaseToMinZoom(var0);
   }
}
