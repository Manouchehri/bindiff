package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.helpers.GraphAnimator;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer$1;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ZoomHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.SwingUtilities;
import y.h.ch;

public class GraphZoomer {
   public static final double ZOOM_OUT_FACTOR = 0.95D;

   private static void fitContent(ch var0) {
      var0.fitContent();
      var0.setZoom(var0.getZoom() * 0.95D);
   }

   private static void zoomToArea(BinDiffGraph var0, Rectangle2D var1) {
      ch var2 = var0.getView();
      double var3 = var2.getZoom();
      Point2D var5 = var2.getCenter();
      var2.zoomToArea(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
      var2.setZoom(var2.getZoom() * 0.95D);
      ZoomHelpers.keepZoomValid(var2);
      double var6 = var2.getZoom();
      Double var8 = new Double(var2.getCenter().getX(), var2.getCenter().getY());
      var2.setZoom(var3);
      var2.setCenter(var5.getX(), var5.getY());
      GraphAnimator.zoomGraph(var0, var8, var6);
      var2.getGraph2D().T();
   }

   private static void zoomToArea(SuperGraph var0, Rectangle2D var1, Collection var2) {
      GraphViewFitter.adoptSuperViewCanvasProperties(var0);
      ch var3 = var0.getPrimaryGraph().getView();
      ch var4 = var0.getSecondaryGraph().getView();
      double var5 = var3.getZoom();
      Point2D var7 = var3.getViewPoint2D();
      var3.zoomToArea(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
      var3.setZoom(var3.getZoom() * 0.95D);
      ZoomHelpers.keepZoomValid(var3);
      double var8 = var3.getZoom();
      var3.setZoom(var5);
      var3.setViewPoint2D(var7.getX(), var7.getY());
      double var10 = var4.getZoom();
      Point2D var12 = var4.getViewPoint2D();
      var4.zoomToArea(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
      var4.setZoom(var4.getZoom() * 0.95D);
      ZoomHelpers.keepZoomValid(var4);
      double var13 = var4.getZoom();
      var4.setZoom(var10);
      var4.setViewPoint2D(var12.getX(), var12.getY());
      GraphAnimator.zoomGraph(var0, var1, var8, var13);
      var3.getGraph2D().T();
      var4.getGraph2D().T();
   }

   private static void zoomToNodes(BinDiffGraph var0, Collection var1) {
      if(var1.size() != 0) {
         Rectangle2D var2 = GraphHelpers.calculateBoundingBox(var1);
         zoomToArea(var0, var2);
      }
   }

   public static void fitContent(BinDiffGraph var0) {
      fitContent(var0.getView());
      var0.getGraph().T();
   }

   public static void fitContent(SuperGraph var0) {
      GraphSettings var1 = var0.getSettings();
      if(var1.isSync()) {
         var0.getView().fitContent();
         GraphViewFitter.adoptSuperViewCanvasProperties(var0);
         GraphViewFitter.fitSingleViewToSuperViewContent(var0);
      } else if(var1.getFocus() == ESide.PRIMARY) {
         fitContent(var0.getPrimaryGraph().getView());
      } else {
         fitContent(var0.getSecondaryGraph().getView());
      }

      var0.getPrimaryGraph().getGraph().T();
      var0.getSecondaryGraph().getGraph().T();
   }

   public static void zoomToNode(BinDiffGraph var0, ZyGraphNode var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      if(!var1.isVisible()) {
         GraphLayoutEventHandler.handleUnhideInvisibleNode(var0, var1);
      }

      ArrayList var2 = new ArrayList();
      var2.add(var1);
      SwingUtilities.invokeLater(new GraphZoomer$1(var0, var2));
   }

   public static void zoomToNodes(CombinedGraph var0, Collection var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Iterator var2 = var1.iterator();

      CombinedDiffNode var3;
      do {
         if(!var2.hasNext()) {
            if(var1.size() == 0) {
               return;
            }

            Rectangle2D var4 = GraphHelpers.calculateBoundingBox(var1);
            zoomToArea(var0, var4);
            return;
         }

         var3 = (CombinedDiffNode)var2.next();
      } while(var3.isVisible());

      throw new IllegalArgumentException("This function does not handle invisible nodes. Each node must be visible.");
   }

   public static void zoomToNodes(SuperGraph var0, Collection var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Iterator var2 = var1.iterator();

      SuperDiffNode var3;
      do {
         if(!var2.hasNext()) {
            if(var1.size() == 0) {
               return;
            }

            GraphViewFitter.adoptSuperViewCanvasProperties(var0);
            Rectangle2D var4 = GraphHelpers.calculateBoundingBox(var1);
            if(var0.getSettings().isSync()) {
               zoomToArea(var0, var4, var1);
            } else if(var0.getSettings().getFocus() == ESide.PRIMARY) {
               zoomToArea(var0.getPrimaryGraph(), var4);
            } else {
               zoomToArea(var0.getSecondaryGraph(), var4);
            }

            var0.getPrimaryGraph().getGraph().T();
            var0.getSecondaryGraph().getGraph().T();
            return;
         }

         var3 = (SuperDiffNode)var2.next();
      } while(var3.isVisible());

      throw new IllegalArgumentException("This function does not handle invisible nodes. Each node must be visible.");
   }

   // $FF: synthetic method
   static void access$000(BinDiffGraph var0, Collection var1) {
      zoomToNodes(var0, var1);
   }
}
