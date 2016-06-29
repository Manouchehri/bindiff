package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ZoomHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.Collection;
import y.d.y;
import y.h.aA;
import y.h.fj;

public class ZoomFunctions {
   public static void zoomToEdgeLabel(AbstractZyGraph var0, ZyGraphEdge var1) {
      aA var2 = var1.getRealizer().getLabel();
      y var3 = var2.getBox();
      Rectangle var4 = var0.getView().getBounds();
      double var5 = var4.getWidth() / var3.a();
      double var7 = var4.getHeight() / var3.b();
      double var9 = var0.getView().getZoom();
      var0.getView().setZoom(0.8D * Math.min(var5, var7));
      ZoomHelpers.keepZoomValid(var0.getView());
      double var11 = var0.getView().getZoom();
      var0.getView().setZoom(var9);
      Double var13 = new Double(var3.c() + 0.5D * var3.a(), var3.d() + 0.5D * var3.b());
      var0.getView().focusView(var11, var13, true);
      var0.updateViews();
   }

   public static void zoomToNode(AbstractZyGraph var0, ZyGraphNode var1) {
      Preconditions.checkNotNull(var1, "Error: Node argument can\'t be null");
      fj var2 = var0.getGraph().t(var1.getNode());
      Preconditions.checkNotNull(var2, "Error: Node does not belong to the graph");
      if(!var1.isVisible()) {
         var0.showNode(var1, true);
      }

      double var3 = var0.getView().getZoom();
      Point2D var5 = var0.getView().getViewPoint2D();
      var0.getView().zoomToArea(var2.getCenterX() - var2.getWidth(), var2.getCenterY() - var2.getHeight(), var2.getWidth() * 2.0D, var2.getHeight() * 2.0D);
      ZoomHelpers.keepZoomValid(var0.getView());
      double var6 = var0.getView().getZoom();
      Point2D var8 = var0.getView().getCenter();
      var0.getView().setZoom(var3);
      var0.getView().setViewPoint((int)var5.getX(), (int)var5.getY());
      var0.getView().focusView(var6, var8, var0.getSettings().getLayoutSettings().getAnimateLayout());
      var0.updateViews();
   }

   public static void zoomToNode(AbstractZyGraph var0, ZyGraphNode var1, int var2, boolean var3) {
      Preconditions.checkNotNull(var1, "Error: Node argument can\'t be null");
      IZyNodeRealizer var4 = var1.getRealizer();
      Preconditions.checkNotNull(var4, "Error: Node does not belong to the graph");
      double var5 = var4.getNodeContent().getLineHeight() * (double)var2;
      Point2D var7 = var0.getView().getViewPoint2D();
      var0.getView().setCenter(var4.getCenterX(), var4.getCenterY() - var4.getHeight() / 2.0D + var5);
      if(var3) {
         Point2D var8 = var0.getView().getCenter();
         var0.getView().setViewPoint((int)var7.getX(), (int)var7.getY());
         var0.getView().focusView(var0.getView().getZoom(), var8, var0.getSettings().getLayoutSettings().getAnimateLayout());
      }

      var0.updateViews();
   }

   public static void zoomToNodes(AbstractZyGraph var0, Collection var1) {
      Preconditions.checkNotNull(var1, "Error: nodes argument can not be null");
      if(var1.size() != 0) {
         double var2 = var0.getView().getZoom();
         Point2D var4 = var0.getView().getViewPoint2D();
         Rectangle2D var5 = GraphHelpers.calculateBoundingBox(var1);
         var0.getView().zoomToArea(var5.getX(), var5.getY(), var5.getWidth(), var5.getHeight());
         ZoomHelpers.keepZoomValid(var0.getView());
         var0.zoomOut();
         double var6 = var0.getView().getZoom();
         Point2D var8 = var0.getView().getCenter();
         var0.getView().setZoom(var2);
         var0.getView().setViewPoint((int)var4.getX(), (int)var4.getY());
         var0.getView().focusView(var6, var8, var0.getSettings().getLayoutSettings().getAnimateLayout());
         var0.updateViews();
      }
   }

   public static void zoomToScreen(AbstractZyGraph var0) {
      var0.getView().fitContent();
      ZoomHelpers.keepZoomValid(var0.getView());
      var0.updateViews();
   }
}
