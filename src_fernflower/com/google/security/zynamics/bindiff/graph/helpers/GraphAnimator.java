package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import y.b.b;
import y.b.c;
import y.b.d;
import y.b.e;
import y.b.l;
import y.g.an;
import y.g.w;
import y.h.ch;
import y.h.gJ;

public class GraphAnimator {
   public static void moveGraph(BinDiffGraph var0, Double var1) {
      GraphSettings var2 = var0.getSettings();
      boolean var3 = var2.getLayoutSettings().getAnimateLayout();
      if(!var2.isAsync() && var0 instanceof SingleGraph) {
         SingleGraph var4 = (SingleGraph)var0;
         ch var5 = var4.getPrimaryGraph().getView();
         ch var6 = var4.getSecondaryGraph().getView();
         e var7 = new e();
         var7.a(false);
         var7.a((c)var5);
         var7.a((c)var6);
         boolean var8 = true;
         int var9 = var2.getDisplaySettings().getAnimationSpeed();
         l var10 = b.a();
         an var11 = w.a(var1);
         d var12 = (new gJ(var5)).a(var5.getZoom(), var11, (long)(100 * var9));
         d var13 = (new gJ(var6)).a(var6.getZoom(), var11, (long)(100 * var9));
         var10.a(var12);
         var10.a(var13);
         var7.a((d)var10);
      } else {
         var0.getView().focusView(var0.getView().getZoom(), var1, var3);
      }

   }

   public static void zoomGraph(BinDiffGraph var0, Double var1, double var2) {
      GraphSettings var4 = var0.getSettings();
      boolean var5 = var4.getLayoutSettings().getAnimateLayout();
      if(!var4.isAsync() && var0 instanceof SingleGraph) {
         SingleGraph var6 = (SingleGraph)var0;
         ch var7 = var6.getPrimaryGraph().getView();
         ch var8 = var6.getSecondaryGraph().getView();
         e var9 = new e();
         var9.a(false);
         var9.a((c)var7);
         var9.a((c)var8);
         boolean var10 = true;
         int var11 = var4.getDisplaySettings().getAnimationSpeed();
         l var12 = b.a();
         an var13 = w.a(var1);
         d var14 = (new gJ(var7)).a(var2, var13, (long)(100 * var11));
         d var15 = (new gJ(var8)).a(var2, var13, (long)(100 * var11));
         var12.a(var14);
         var12.a(var15);
         var9.a((d)var12);
      } else {
         var0.getView().focusView(var2, var1, var5);
      }

   }

   public static void zoomGraph(SuperGraph var0, Rectangle2D var1, double var2, double var4) {
      ch var6 = var0.getPrimaryGraph().getView();
      ch var7 = var0.getSecondaryGraph().getView();
      w var8 = w.a(var1.getCenterX(), var1.getCenterY());
      int var9 = 100 * var0.getSettings().getDisplaySettings().getAnimationSpeed();
      d var10 = (new gJ(var6)).a(Math.max(var2, var4), var8, (long)var9);
      d var11 = (new gJ(var7)).a(Math.max(var2, var4), var8, (long)var9);
      l var12 = b.a();
      var12.a(var10);
      var12.a(var11);
      e var13 = new e();
      var13.a(false);
      var13.a((c)var6);
      var13.a((c)var7);
      var13.a((d)var12);
   }
}
