package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.types.common.ICommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y.c.q;

public final class ProximityNodeClickedUpdater implements ICommand {
   private final BinDiffGraph graph;
   private final ZyProximityNode proximityNode;

   public ProximityNodeClickedUpdater(BinDiffGraph var1, ZyProximityNode var2) {
      this.graph = (BinDiffGraph)Preconditions.checkNotNull(var1);
      this.proximityNode = (ZyProximityNode)Preconditions.checkNotNull(var2);
   }

   private static Set getNodesToShow(BinDiffGraph var0, ZyProximityNode var1) {
      q var2 = var1.getNode();
      HashSet var3 = new HashSet();
      q var4 = var2.m().e();
      ZyGraphNode var5 = var0.getNode(var4);
      Iterator var6;
      ZyGraphNode var7;
      if(var1.indegree() == 1) {
         var6 = var5.getChildren().iterator();

         while(var6.hasNext()) {
            var7 = (ZyGraphNode)var6.next();
            if(!var7.isVisible() && !ProximityHelper.isProximityNode(var0.getGraph(), var7.getNode())) {
               var3.add(var7);
            }
         }
      }

      if(var1.outdegree() == 1) {
         var6 = var5.getParents().iterator();

         while(var6.hasNext()) {
            var7 = (ZyGraphNode)var6.next();
            if(!var7.isVisible() && !ProximityHelper.isProximityNode(var0.getGraph(), var7.getNode())) {
               var3.add(var7);
            }
         }
      }

      return var3;
   }

   private static boolean showProximityNodeClickedVisibilityWarningDialog(BinDiffGraph var0, ZyProximityNode var1) {
      int var2 = getNodesToShowCount(var0, var1);
      int var3 = var0.getSettings().getLayoutSettings().getVisibilityWarningThreshold();
      if(var2 > var3) {
         int var4 = CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(var0), String.format("The selected operation makes %d more nodes visible. Do you want to continue?", new Object[]{Integer.valueOf(var2)}));
         return var4 == 0;
      } else {
         return true;
      }
   }

   private static void updateVisibility(BinDiffGraph var0, ZyProximityNode var1) {
      Set var2 = getNodesToShow(var0, var1);
      if(var0.getSettings().isSync()) {
         HashSet var3 = new HashSet();
         HashSet var4 = new HashSet();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            ZyGraphNode var6 = (ZyGraphNode)var5.next();
            if(var6 instanceof SingleDiffNode) {
               var3.add(((SingleDiffNode)var6).getCombinedDiffNode());
               var4.add(((SingleDiffNode)var6).getSuperDiffNode());
            } else if(var6 instanceof CombinedDiffNode) {
               var3.add((CombinedDiffNode)var6);
               var4.add(((CombinedDiffNode)var6).getSuperDiffNode());
            }
         }

         var0.getCombinedGraph().showNodes(var3, false);
         var0.getSuperGraph().showNodes(var4, false);
      } else {
         Iterator var7 = var2.iterator();

         while(true) {
            ZyGraphNode var8;
            do {
               if(!var7.hasNext()) {
                  return;
               }

               var8 = (ZyGraphNode)var7.next();
            } while(!(var8 instanceof SingleDiffNode) && !(var8 instanceof CombinedDiffNode));

            var8.getRawNode().setVisible(true);
         }
      }
   }

   protected static void updateProximityNodes(BinDiffGraph var0) {
      if(var0.getSettings().isSync()) {
         var0.getCombinedGraph().getProximityBrowser().deleteProximityNodes();
         var0.getSuperGraph().getProximityBrowser().deleteProximityNodes();
         ArrayList var1 = new ArrayList();
         var1.addAll(var0.getCombinedGraph().getNodes());
         ArrayList var2 = new ArrayList();
         var2.addAll(var0.getSuperGraph().getNodes());
         var0.getCombinedGraph().getProximityBrowser().createProximityNodes(var1);
         var0.getSuperGraph().getProximityBrowser().createProximityNodes(var2);
         ProximityBrowserUpdater.adoptSuperGraphVisibility(var0.getSuperGraph());
         ProximityBrowserUpdater.deleteAllProximityNodes(var0.getPrimaryGraph());
         ProximityBrowserUpdater.deleteAllProximityNodes(var0.getSecondaryGraph());
         ProximityBrowserUpdater.createProximityNodesAndEdges(var0.getSuperGraph());
      } else {
         ProximityBrowserUpdater.deleteAllProximityNodes(var0);
         if(var0 instanceof SingleGraph) {
            ProximityBrowserUpdater.createProximityNodesAndEdges((SingleGraph)var0);
         } else if(var0 instanceof CombinedGraph) {
            ProximityBrowserUpdater.createProximityNodesAndEdges((CombinedGraph)var0);
         }
      }

   }

   public static void executeStatic(BinDiffGraph var0, ZyProximityNode var1) {
      if(showProximityNodeClickedVisibilityWarningDialog(var0, var1)) {
         updateVisibility(var0, var1);
         updateProximityNodes(var0);
         GraphViewUpdater.updateViews(var0);
         GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(var0);
         if(LayoutCommandHelper.isAutolayout(var0)) {
            GraphLayoutUpdater.executeStatic(var0, true);
         }
      }

   }

   public static int getNodesToShowCount(BinDiffGraph var0, ZyProximityNode var1) {
      return getNodesToShow(var0, var1).size();
   }

   public void execute() {
      executeStatic(this.graph, this.proximityNode);
   }
}
