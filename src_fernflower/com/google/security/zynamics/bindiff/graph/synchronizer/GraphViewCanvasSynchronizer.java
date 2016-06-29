package com.google.security.zynamics.bindiff.graph.synchronizer;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphViewsListenerManager;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import y.h.ch;

public class GraphViewCanvasSynchronizer {
   private static void addListener(GraphViewsListenerManager var0, SingleGraph var1) {
      if(var1.getSide() == ESide.PRIMARY) {
         var0.addViewCanvasListener(var1.getSecondaryGraph());
      } else {
         var0.addViewCanvasListener(var1.getPrimaryGraph());
      }

   }

   private static void adoptViewPoint(SingleGraph var0, Point2D var1, boolean var2) {
      SingleGraph var3 = getTargetGraph(var0);
      ch var4 = var0.getView();
      ch var5 = var3.getView();
      Point2D var6 = var4.getViewPoint2D();
      double var7 = var1.getX() - var6.getX();
      double var9 = var1.getY() - var6.getY();
      Point2D var11 = var5.getViewPoint2D();
      var5.setViewPoint2D(var11.getX() - var7, var11.getY() - var9);
      if(!var2) {
         var5.getGraph2D().T();
      }

   }

   private static void adoptZoom(SingleGraph var0) {
      SingleGraph var1 = getTargetGraph(var0);
      SuperGraph var2 = var0.getSuperGraph();
      adoptSuperWorldRect(var2);
      var1.getView().focusView(var0.getView().getZoom(), var0.getView().getCenter(), false);
   }

   private static SingleGraph getTargetGraph(SingleGraph var0) {
      return var0 == var0.getPrimaryGraph()?var0.getSecondaryGraph():var0.getPrimaryGraph();
   }

   private static void removeListener(GraphViewsListenerManager var0, SingleGraph var1) {
      if(var1.getSide() == ESide.PRIMARY) {
         var0.removeViewCanvasListener(var1.getSecondaryGraph());
      } else {
         var0.removeViewCanvasListener(var1.getPrimaryGraph());
      }

   }

   public static void adoptSuperWorldRect(SuperGraph var0) {
      if(var0.getSettings().isSync()) {
         Rectangle var1 = var0.getView().getWorldRect();
         SingleGraph var2 = var0.getPrimaryGraph();
         SingleGraph var3 = var0.getSecondaryGraph();
         var2.getView().setWorldRect(var1.x, var1.y, var1.width, var1.height);
         var3.getView().setWorldRect(var1.x, var1.y, var1.width, var1.height);
      }

   }

   public static void adoptViewPoint(GraphViewsListenerManager var0, SingleGraph var1, Point2D var2, boolean var3) {
      if(var1.getSettings().isSync()) {
         removeListener(var0, var1);
         adoptViewPoint(var1, var2, var3);
         addListener(var0, var1);
      }

   }

   public static void adoptZoom(GraphViewsListenerManager var0, SingleGraph var1) {
      if(var1.getSettings().isSync()) {
         removeListener(var0, var1);
         adoptZoom(var1);
         addListener(var0, var1);
      }

   }
}
