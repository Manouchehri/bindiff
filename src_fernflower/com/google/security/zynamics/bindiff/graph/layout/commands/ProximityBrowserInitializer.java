package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProximityBrowserInitializer {
   private static final int EDGE_COUNT_THRESHOLD = 3;

   private static SingleDiffNode getProximityBrowsingStartNode(SingleGraph var0) {
      SingleDiffNode var1 = null;
      IAddress var2 = null;
      Iterator var3;
      SingleDiffNode var4;
      if(var0.getGraphType() == EGraphType.CALLGRAPH) {
         var3 = var0.getNodes().iterator();

         while(true) {
            IAddress var6;
            do {
               SingleViewNode var5;
               do {
                  do {
                     if(!var3.hasNext()) {
                        return var1;
                     }

                     var4 = (SingleDiffNode)var3.next();
                  } while(var4.getRawNode().getMatchState() != EMatchState.MATCHED);

                  var5 = var4.getRawNode();
               } while(var5.getIncomingEdges().size() + var5.getOutgoingEdges().size() != 3);

               var6 = var5.getAddress();
            } while(var2 != null && var2.compareTo(var6) <= 0);

            var2 = var6;
            var1 = var4;
         }
      } else {
         var3 = var0.getNodes().iterator();

         while(var3.hasNext()) {
            var4 = (SingleDiffNode)var3.next();
            RawBasicBlock var7 = (RawBasicBlock)var4.getRawNode();
            if(var7.getAddress().equals(var7.getFunctionAddr())) {
               var1 = var4;
               break;
            }
         }
      }

      return var1;
   }

   private static void getVisibleAndInvisibleNodeSets(BinDiffGraph var0, SingleDiffNode var1, SingleDiffNode var2, Collection var3, Collection var4, Collection var5, Collection var6) {
      var6.addAll(var0.getCombinedGraph().getNodes());
      var4.addAll(var0.getSuperGraph().getNodes());
      if(var1 != null || var2 != null) {
         if(var1 == null) {
            var1 = var2.getOtherSideDiffNode();
         } else if(var2 == null) {
            var2 = var1.getOtherSideDiffNode();
         } else {
            var2 = var1.getOtherSideDiffNode();
         }

         SuperDiffNode var7 = var1.getSuperDiffNode();
         var4.remove(var7);
         var3.add(var7);
         CombinedDiffNode var8 = var1.getCombinedDiffNode();
         var6.remove(var8);
         var5.add(var8);
      }
   }

   private static void initialProximityBrowsing(BinDiffGraph var0) {
      GraphProximityBrowsingSettings var1 = var0.getSettings().getProximitySettings();
      int var2 = var1.getAutoProximityBrowsingActivationThreshold();
      Collection var3 = var0.getCombinedGraph().getNodes();
      int var4 = var3.size();
      if(var4 >= var2) {
         var1.setProximityBrowsing(true);
         SingleDiffNode var5 = getProximityBrowsingStartNode(var0.getPrimaryGraph());
         SingleDiffNode var6 = getProximityBrowsingStartNode(var0.getSecondaryGraph());
         ArrayList var7 = new ArrayList();
         ArrayList var8 = new ArrayList();
         ArrayList var9 = new ArrayList();
         ArrayList var10 = new ArrayList();
         getVisibleAndInvisibleNodeSets(var0, var5, var6, var9, var10, var7, var8);
         GraphLayoutSettings var11 = var0.getSettings().getLayoutSettings();
         boolean var12 = var11.getAutomaticLayouting();
         var11.setAutomaticLayouting(false);
         var0.getSuperGraph().showNodes(var9, var10);
         var0.getCombinedGraph().showNodes(var7, var8);
         ProximityBrowserUpdater.adoptSuperGraphVisibility(var0.getSuperGraph());
         ProximityBrowserUpdater.deleteAllProximityNodes(var0.getPrimaryGraph());
         ProximityBrowserUpdater.deleteAllProximityNodes(var0.getSecondaryGraph());
         ProximityBrowserUpdater.createProximityNodesAndEdges(var0.getSuperGraph());
         var11.setAutomaticLayouting(var12);
      }
   }

   public static void executeStatic(BinDiffGraph var0) {
      initialProximityBrowsing(var0);

      try {
         GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(var0);
      } catch (Exception var2) {
         throw new GraphLayoutException(var2, var2.getMessage());
      }
   }
}
