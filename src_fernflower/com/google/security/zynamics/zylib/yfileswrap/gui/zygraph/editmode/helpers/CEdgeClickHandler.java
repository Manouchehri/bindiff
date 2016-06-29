package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D.Double;
import y.c.d;
import y.h.aB;
import y.h.fj;

public class CEdgeClickHandler {
   private static void zoomEdgeNode(AbstractZyGraph var0, d var1, double var2, double var4) {
      assert var1 != null;

      AbstractZyGraphSettings var6 = var0.getSettings();
      boolean var7 = var6.getLayoutSettings().getAnimateLayout();
      aB var8 = var0.getGraph().i(var1);
      fj var9 = var0.getGraph().t(var1.c());
      fj var10 = var0.getGraph().t(var1.d());
      double var11 = var8.getSourcePort().a(var9);
      double var13 = var8.getSourcePort().b(var9);
      double var15 = var8.getSourcePort().a(var10);
      double var17 = var8.getSourcePort().b(var10);
      double var19 = Math.abs(var11 - var2);
      double var21 = Math.abs(var13 - var4);
      double var23 = Math.abs(var15 - var2);
      double var25 = Math.abs(var17 - var4);
      double var27 = Math.sqrt(Math.pow(var19, 2.0D) + Math.pow(var21, 2.0D));
      double var29 = Math.sqrt(Math.pow(var23, 2.0D) + Math.pow(var25, 2.0D));
      Double var31;
      if(var27 > var29) {
         var31 = new Double(var9.getCenterX(), var9.getCenterY());
         var0.getView().focusView(var0.getView().getZoom(), var31, var7);
      } else {
         var31 = new Double(var10.getCenterX(), var10.getCenterY());
         var0.getView().focusView(var0.getView().getZoom(), var31, var7);
      }

   }

   public static void handleEdgeClicks(AbstractZyGraph var0, ZyGraphEdge var1, MouseEvent var2) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Error: Edge argument can not be null");
      Preconditions.checkNotNull(var2, "Error: Event argument can not be null");
      if(var2.getButton() == 1 && var2.isShiftDown()) {
         var0.getGraph().a(var1.getEdge(), !var1.isSelected());
      } else if(var2.getButton() == 1 && !var2.isShiftDown() && var1.getSource() != var1.getTarget()) {
         double var3 = var0.getView().toWorldCoordX(var2.getX());
         double var5 = var0.getView().toWorldCoordY(var2.getY());
         zoomEdgeNode(var0, var1.getEdge(), var3, var5);
      }

   }
}
