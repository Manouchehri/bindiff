package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import y.h.bu;
import y.h.ch;

public class GraphViewFitter {
   public static void adoptSuperViewCanvasProperties(SuperGraph var0) {
      if(var0.getSettings().isSync()) {
         SingleGraph var1 = var0.getPrimaryGraph();
         SingleGraph var2 = var0.getSecondaryGraph();
         ch var3 = var0.getView();
         Rectangle var4 = var3.getWorldRect();
         Point2D var5 = var3.getViewPoint2D();
         ch var6 = var1.getView();
         var6.setWorldRect((int)var4.getX(), (int)var4.getY(), (int)var4.getWidth(), (int)var4.getHeight());
         var6.setZoom(var3.getZoom());
         ch var7 = var2.getView();
         var7.setWorldRect((int)var4.getX(), (int)var4.getY(), (int)var4.getWidth(), (int)var4.getHeight());
         var7.setZoom(var3.getZoom());
         if(var6.getWidth() > var7.getWidth()) {
            var6.setViewPoint((int)var5.getX(), (int)var5.getY());
            var7.setCenter(var3.getCenter().getX(), var3.getCenter().getY());
         } else if(var6.getWidth() < var7.getWidth()) {
            var7.setViewPoint((int)var5.getX(), (int)var5.getY());
            var6.setCenter(var3.getCenter().getX(), var3.getCenter().getY());
         } else {
            var6.setViewPoint((int)var5.getX(), (int)var5.getY());
            var7.setViewPoint((int)var5.getX(), (int)var5.getY());
         }
      }

   }

   public static void fitSingleViewToSuperViewContent(SuperGraph var0) {
      if(var0.getSettings().isSync()) {
         SingleGraph var1 = var0.getPrimaryGraph();
         SingleGraph var2 = var0.getSecondaryGraph();
         int var3 = (int)Math.round(var1.getView().getSize().getWidth());
         int var4 = (int)Math.round(var2.getView().getSize().getWidth());
         bu var5;
         double var6;
         Point var8;
         if(var3 > var4 && var1.getNodes().size() > 0) {
            var5 = var1.getView().getGraph2D();
            var1.getView().setGraph2D(var0.getGraph());
            var1.getGraph().T();
            var1.getView().fitContent();
            var6 = var1.getView().getZoom();
            var8 = var1.getView().getViewPoint();
            var1.getView().setGraph2D(var5);
            var1.getView().setViewPoint2D(var8.getX(), var8.getY());
            var1.getView().setZoom(var6 * 0.95D);
         } else {
            var5 = var2.getView().getGraph2D();
            var2.getView().setGraph2D(var0.getGraph());
            var2.getGraph().T();
            var2.getView().fitContent();
            var6 = var2.getView().getZoom();
            var8 = var2.getView().getViewPoint();
            var2.getView().setGraph2D(var5);
            var2.getView().setViewPoint2D(var8.getX(), var8.getY());
            var2.getView().setZoom(var6 * 0.95D);
         }
      }

   }
}
