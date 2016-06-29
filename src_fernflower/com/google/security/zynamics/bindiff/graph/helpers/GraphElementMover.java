package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.synchronizer.GraphViewCanvasSynchronizer;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.c.q;

public class GraphElementMover {
   private static List getAffectedSuperDiffNodes(AbstractZyGraph var0, SingleDiffNode var1) {
      HashSet var2 = new HashSet();
      Iterator var9;
      if(var1.isSelected()) {
         Iterator var3 = var0.getSelectedNodes().iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var2.add((SingleDiffNode)var4);
         }

         SingleGraph var7 = var1.getSide() == ESide.PRIMARY?((BinDiffGraph)var0).getSecondaryGraph():((BinDiffGraph)var0).getPrimaryGraph();
         var9 = var7.getSelectedNodes().iterator();

         while(var9.hasNext()) {
            Object var5 = var9.next();
            if(((SingleDiffNode)var5).getCombinedRawNode().getMatchState() != EMatchState.MATCHED) {
               var2.add((SingleDiffNode)var5);
            }
         }
      } else {
         var2.add(var1);
      }

      ArrayList var8 = new ArrayList();
      var9 = var2.iterator();

      while(var9.hasNext()) {
         SingleDiffNode var10 = (SingleDiffNode)var9.next();
         SuperDiffNode var6 = var10.getSuperDiffNode();
         var8.add(var6);
      }

      return var8;
   }

   private static void moveBends(List var0, ESide var1, double var2, double var4) {
      HashSet var6 = new HashSet();
      Iterator var7 = var0.iterator();

      SuperDiffNode var8;
      while(var7.hasNext()) {
         var8 = (SuperDiffNode)var7.next();
         Iterator var9 = var8.getRawNode().getOutgoingEdges().iterator();

         SuperViewEdge var10;
         while(var9.hasNext()) {
            var10 = (SuperViewEdge)var9.next();
            var6.addAll(var10.getBends());
         }

         var9 = var8.getRawNode().getIncomingEdges().iterator();

         while(var9.hasNext()) {
            var10 = (SuperViewEdge)var9.next();
            var6.addAll(var10.getBends());
         }
      }

      var7 = var0.iterator();

      while(var7.hasNext()) {
         var8 = (SuperDiffNode)var7.next();
         SingleDiffNode var14 = var8.getPrimaryDiffNode();
         if(var1 == ESide.PRIMARY) {
            var14 = var8.getSecondaryDiffNode();
         }

         if(var14 != null) {
            Iterator var12 = var14.getRawNode().getOutgoingEdges().iterator();

            SingleViewEdge var11;
            while(var12.hasNext()) {
               var11 = (SingleViewEdge)var12.next();
               var6.addAll(var11.getBends());
            }

            var12 = var14.getRawNode().getIncomingEdges().iterator();

            while(var12.hasNext()) {
               var11 = (SingleViewEdge)var12.next();
               var6.addAll(var11.getBends());
            }
         }
      }

      var7 = var6.iterator();

      while(var7.hasNext()) {
         CBend var13 = (CBend)var7.next();
         var13.setX(var13.getX() + var2);
         var13.setY(var13.getY() + var4);
      }

   }

   public static void moveNodes(AbstractZyGraph var0, q var1, double var2, double var4) {
      ZyGraphNode var6 = var0.getNode(var1);
      if(var6 instanceof SingleDiffNode && ((BinDiffGraph)var0).getSettings().isSync()) {
         SingleDiffNode var7 = (SingleDiffNode)var6;
         List var8 = getAffectedSuperDiffNodes(var0, var7);
         Iterator var9 = var8.iterator();

         while(var9.hasNext()) {
            SuperDiffNode var10 = (SuperDiffNode)var9.next();
            IZyNodeRealizer var11 = var10.getRealizer();
            var11.setX(var11.getX() + var2);
            var11.setY(var11.getY() + var4);
            GraphViewCanvasSynchronizer.adoptSuperWorldRect(((BinDiffGraph)var0).getSuperGraph());
            SingleDiffNode var12;
            if(var7.getSide() != ESide.PRIMARY) {
               var12 = var10.getPrimaryDiffNode();
               if(var12 != null) {
                  var12.getRealizer().setX(var10.getX());
                  var12.getRealizer().setY(var10.getY());
               }
            } else if(var7.getSide() != ESide.SECONDARY) {
               var12 = var10.getSecondaryDiffNode();
               if(var12 != null) {
                  var12.getRealizer().setX(var10.getX());
                  var12.getRealizer().setY(var10.getY());
               }
            }
         }

         moveBends(var8, var7.getSide(), var2, var4);
      }

      ((BinDiffGraph)var0).getPrimaryGraph().getGraph().T();
      ((BinDiffGraph)var0).getSecondaryGraph().getGraph().T();
   }
}
