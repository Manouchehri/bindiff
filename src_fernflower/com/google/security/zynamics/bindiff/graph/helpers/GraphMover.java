package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.helpers.GraphAnimator;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import y.c.d;
import y.c.q;
import y.h.aB;
import y.h.fj;

public class GraphMover {
   public static void moveToEdgeNode(BinDiffGraph var0, d var1, double var2, double var4) {
      aB var6 = var0.getGraph().i(var1);
      fj var7 = var0.getGraph().t(var1.c());
      fj var8 = var0.getGraph().t(var1.d());
      double var9 = var6.getSourcePort().a(var7);
      double var11 = var6.getSourcePort().b(var7);
      double var13 = var6.getSourcePort().a(var8);
      double var15 = var6.getSourcePort().b(var8);
      double var17 = Math.abs(var9 - var2);
      double var19 = Math.abs(var11 - var4);
      double var21 = Math.abs(var13 - var2);
      double var23 = Math.abs(var15 - var4);
      double var25 = Math.sqrt(Math.pow(var17, 2.0D) + Math.pow(var19, 2.0D));
      double var27 = Math.sqrt(Math.pow(var21, 2.0D) + Math.pow(var23, 2.0D));
      Double var29;
      if(var25 > var27) {
         var29 = new Double(var7.getCenterX(), var7.getCenterY());
      } else {
         var29 = new Double(var8.getCenterX(), var8.getCenterY());
      }

      GraphAnimator.moveGraph(var0, var29);
   }

   public static void moveToNode(BinDiffGraph var0, ZyGraphNode var1) {
      if(!var1.isVisible()) {
         GraphLayoutEventHandler.handleUnhideInvisibleNode(var0, var1);
      }

      ArrayList var2 = new ArrayList();
      var2.add(var1);
      q var3 = var1.getNode();
      fj var4 = var0.getGraph().t(var3);
      Double var5 = new Double(var4.getCenterX(), var4.getCenterY());
      GraphAnimator.moveGraph(var0, var5);
   }
}
