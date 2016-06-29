package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.Set;
import y.d.y;
import y.h.fj;

public class MoveFunctions {
   public static void centerEdgeLable(AbstractZyGraph var0, ZyGraphEdge var1) {
      Preconditions.checkNotNull(var1, "Error: Edge can\'t be null.");
      if(var1.isVisible()) {
         y var2 = var1.getRealizer().getLabel().getBox();
         double var3 = var2.c + var2.a / 2.0D;
         double var5 = var2.d + var2.b / 2.0D;
         var0.getView().focusView(var0.getView().getZoom(), new Double(var3, var5), var0.getSettings().getLayoutSettings().getAnimateLayout());
         var0.updateViews();
      } else {
         throw new IllegalStateException("Error: Edge does not belong to graph.");
      }
   }

   public static void centerNode(AbstractZyGraph var0, ZyGraphNode var1) {
      Preconditions.checkNotNull(var1, "Error: Node argument can\'t be null");
      fj var2 = var0.getGraph().t(var1.getNode());
      if(var2.isVisible()) {
         var0.getView().focusView(var0.getView().getZoom(), new Double(var2.getCenterX(), var2.getCenterY()), var0.getSettings().getLayoutSettings().getAnimateLayout());
         var0.updateViews();
      }

   }

   public static void centerNodes(AbstractZyGraph var0, Set var1) {
      Preconditions.checkNotNull(var1, "Error: Nodes argument is null");
      Preconditions.checkArgument(!var1.isEmpty(), "Error: Nodes argument is empty");
      Rectangle2D var2 = GraphHelpers.calculateBoundingBox(var1);
      var0.getView().setCenter(var2.getX() + var2.getWidth() / 2.0D, var2.getY() + var2.getHeight() / 2.0D);
      var0.updateViews();
   }

   public static void pan(AbstractZyGraph var0, double var1, double var3) {
      double var5 = 50.0D / var0.getView().getZoom();
      var1 *= var5;
      var3 *= var5;
      Double var7 = (Double)var0.getView().getCenter();
      double var8 = var7.getX() + var1;
      double var10 = var7.getY() + var3;
      if(var1 < 0.0D) {
         var1 = (double)((int)Math.floor(var1));
      } else {
         var1 = (double)((int)Math.ceil(var1) + 2);
      }

      if(var3 < 0.0D) {
         var3 = (double)((int)Math.floor(var3));
      } else {
         var3 = (double)((int)Math.ceil(var3) + 2);
      }

      Rectangle var12 = var0.getView().getWorldRect();
      Rectangle var13 = var0.getView().getVisibleRect();
      if(var13.x + (int)var1 < var12.x) {
         var8 += (double)(var12.x - (var13.x + (int)var1));
      } else if(var13.x + var13.width + (int)var1 > var12.x + var12.width) {
         var8 -= (double)(var13.x + var13.width + (int)var1 - (var12.x + var12.width));
      }

      if(var13.y + (int)var3 < var12.y) {
         var10 += (double)(var12.y - (var13.y + (int)var3));
      } else if(var13.y + var13.height + (int)var3 > var12.y + var12.height) {
         var10 -= (double)(var13.y + var13.height + (int)var3 - (var12.y + var12.height));
      }

      var0.getView().setCenter(var8, var10);
      var0.updateViews();
   }
}
