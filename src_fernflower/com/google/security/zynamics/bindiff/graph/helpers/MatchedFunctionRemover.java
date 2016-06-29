package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewCallGraphBuilder;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;
import y.c.q;

public class MatchedFunctionRemover {
   private static CombinedDiffEdge buildDiffEdge(CombinedGraph var0, RawCombinedCall var1, SuperDiffEdge var2) {
      d var3 = null;
      ZyLabelContent var4 = new ZyLabelContent((IZyEditableObject)null);
      CombinedEdgeRealizer var5 = new CombinedEdgeRealizer(var4, (IEdgeRealizerUpdater)null, var0.getSettings());
      CombinedDiffNode var6 = (CombinedDiffNode)var0.getNode(var1.getSource());
      CombinedDiffNode var7 = (CombinedDiffNode)var0.getNode(var1.getTarget());
      q var8 = var6.getNode();
      q var9 = var7.getNode();
      var3 = var0.getGraph().a(var8, var9);
      CombinedDiffEdge var10 = new CombinedDiffEdge(var6, var7, var3, var5, var1, var2);
      CombinedDiffNode.link(var6, var7);
      var5.setUserData(new ZyEdgeData(var10));
      var0.addEdgeToMappings(var10);
      return var10;
   }

   private static SingleDiffEdge buildDiffEdge(SingleGraph var0, RawCombinedCall var1) {
      SingleDiffEdge var2 = null;
      d var3 = null;
      RawFunction var4 = var1.getSource().getRawNode(var0.getSide());
      RawFunction var5 = var1.getTarget().getRawNode(var0.getSide());
      RawCall var6 = var0.getSide() == ESide.PRIMARY?var1.getPrimaryEdge():var1.getSecondaryEdge();
      SingleEdgeRealizer var7 = null;
      if(var4 != null && var5 != null && var1 != null && var6 != null) {
         ZyLabelContent var8 = new ZyLabelContent((IZyEditableObject)null);
         var7 = new SingleEdgeRealizer(var8, (IEdgeRealizerUpdater)null, var0.getSettings());
         SingleDiffNode var9 = (SingleDiffNode)var0.getNode(var4);
         SingleDiffNode var10 = (SingleDiffNode)var0.getNode(var5);
         var3 = var0.getGraph().a(var9.getNode(), var10.getNode());
         var2 = new SingleDiffEdge(var9, var10, var3, var7, var6, var0.getSide());
         SingleDiffNode.link(var9, var10);
         var7.setUserData(new ZyEdgeData(var2));
         var0.addEdgeToMappings(var2);
      }

      return var2;
   }

   private static SuperDiffEdge buildDiffEdge(SuperGraph var0, RawCombinedCall var1, SingleDiffEdge var2, SingleDiffEdge var3) {
      d var4 = null;
      ZyLabelContent var5 = new ZyLabelContent((IZyEditableObject)null);
      ZyEdgeRealizer var6 = new ZyEdgeRealizer(var5, (IEdgeRealizerUpdater)null);
      SuperDiffNode var7 = null;
      SuperDiffNode var8 = null;
      if(var2 != null) {
         var7 = ((SingleDiffNode)var2.getSource()).getSuperDiffNode();
         var8 = ((SingleDiffNode)var2.getTarget()).getSuperDiffNode();
      } else if(var3 != null) {
         var7 = ((SingleDiffNode)var3.getSource()).getSuperDiffNode();
         var8 = ((SingleDiffNode)var3.getTarget()).getSuperDiffNode();
      }

      q var9 = var7.getNode();
      q var10 = var8.getNode();
      var4 = var0.getGraph().a(var9, var10);
      SuperViewNode var11 = var7.getRawNode();
      SuperViewNode var12 = var8.getRawNode();
      SuperViewEdge var13 = new SuperViewEdge(var1, var11, var12);
      SuperDiffEdge var14 = new SuperDiffEdge(var7, var8, var4, var6, var13, var2, var3);
      SuperDiffNode.link(var7, var8);
      var6.setUserData(new ZyEdgeData(var14));
      var0.addEdgeToMappings(var14);
      return var14;
   }

   public static void buildCalls(BinDiffGraph var0, RawCombinedCall var1) {
      SingleGraph var2 = var0.getPrimaryGraph();
      SingleGraph var3 = var0.getSecondaryGraph();
      SuperGraph var4 = var0.getSuperGraph();
      CombinedGraph var5 = var0.getCombinedGraph();
      SingleDiffEdge var6 = buildDiffEdge(var2, var1);
      SingleDiffEdge var7 = buildDiffEdge(var3, var1);
      SuperDiffEdge var8 = buildDiffEdge(var4, var1, var6, var7);
      CombinedDiffEdge var9 = buildDiffEdge(var5, var1, var8);
      var8.setCombinedDiffEdge(var9);
      if(var6 != null) {
         var6.setCombinedDiffEdge(var9);
      }

      if(var7 != null) {
         var7.setCombinedDiffEdge(var9);
      }

      ViewCallGraphBuilder.colorizeCalls(var1);
   }
}
