package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphSelectionUpdater$1;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityRangeCalculator;
import com.google.security.zynamics.zylib.types.common.ICommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GraphSelectionUpdater implements ICommand {
   private final BinDiffGraph referenceGraph;

   public GraphSelectionUpdater(BinDiffGraph var1) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(!(var1 instanceof SuperGraph), "Reference graph cannot be a super graph");
      this.referenceGraph = var1;
   }

   private static void selectRawEdges(AbstractZyGraph var0) {
      ArrayList var1 = new ArrayList();
      var0.iterateEdges(new GraphSelectionUpdater$1(var1));
      var0.getGraph().P();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ZyGraphEdge var3 = (ZyGraphEdge)var2.next();
         var3.getRawEdge().setSelected(true);
         var0.getGraph().i(var3.getEdge()).setSelected(true);
      }

   }

   private static void selectRawGraph(CombinedGraph var0, Collection var1, Collection var2) {
      var0.selectNodes(var1, var2);
      selectRawNodes(var0);
      selectRawEdges(var0);
   }

   private static void selectRawGraph(SingleGraph var0, Collection var1, Collection var2) {
      var0.selectNodes(var1, var2);
      selectRawNodes(var0);
      selectRawEdges(var0);
   }

   private static void selectRawGraph(SuperGraph var0, Collection var1, Collection var2) {
      var0.selectNodes(var1, var2);
      selectRawNodes(var0);
      selectRawEdges(var0);
   }

   private static void selectRawNodes(AbstractZyGraph var0) {
      Iterator var1 = var0.getSelectedNodes().iterator();

      while(var1.hasNext()) {
         ZyGraphNode var2 = (ZyGraphNode)var1.next();
         if(var2 instanceof CombinedDiffNode) {
            ((CombinedDiffNode)var2).getRawNode().setSelected(true);
         }

         if(var2 instanceof SuperDiffNode) {
            ((SuperDiffNode)var2).getRawNode().setSelected(true);
         }
      }

   }

   private static boolean showVisibilityWarningDialog(BinDiffGraph var0) {
      int var1 = var0.getSettings().getProximitySettings().getProximityBrowsingChildren();
      int var2 = var0.getSettings().getProximitySettings().getProximityBrowsingParents();
      List var3 = GraphNodeFilter.filterNodes((AbstractZyGraph)var0, GraphNodeFilter$Criterium.VISIBLE);
      List var4 = GraphNodeFilter.filterNodes((AbstractZyGraph)var0, GraphNodeFilter$Criterium.SELECTED_VISIBLE);
      Set var5 = ProximityRangeCalculator.getNeighbors(var0, var4, var1, var2);
      HashSet var6 = new HashSet();
      int var7 = 0;
      Iterator var8 = var5.iterator();

      while(var8.hasNext()) {
         ZyGraphNode var9 = (ZyGraphNode)var8.next();
         if(!var9.isVisible()) {
            ++var7;
         } else {
            var6.add(var9);
         }
      }

      var3.removeAll(var4);
      var3.removeAll(var6);
      int var12 = var3.size();
      int var13 = var7 - var12;
      int var10 = var0.getSettings().getLayoutSettings().getVisibilityWarningThreshold();
      if(var13 >= var10) {
         int var11 = CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(var0), String.format("The selected operation makes %d more nodes visible. Do you want to continue?", new Object[]{Integer.valueOf(var13)}));
         return var11 == 0;
      } else {
         return true;
      }
   }

   private static void synchronizeNodesSelection(CombinedGraph var0, Set var1) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      ArrayList var8 = new ArrayList();
      ArrayList var9 = new ArrayList();
      Iterator var10 = var0.getNodes().iterator();

      while(var10.hasNext()) {
         CombinedDiffNode var11 = (CombinedDiffNode)var10.next();
         boolean var12 = var1.contains(var11);
         SingleDiffNode var13 = var11.getPrimaryDiffNode();
         SingleDiffNode var14 = var11.getSecondaryDiffNode();
         SuperDiffNode var15 = var11.getSuperDiffNode();
         ArrayList var16 = var12?var4:var5;
         ArrayList var17 = var12?var2:var3;
         ArrayList var18 = var12?var6:var7;
         ArrayList var19 = var12?var8:var9;
         var17.add(var11);
         var16.add(var15);
         if(var13 != null) {
            var18.add(var13);
         }

         if(var14 != null) {
            var19.add(var14);
         }
      }

      var0.selectNodes(var2, var3);
      selectRawEdges(var0);
      selectRawGraph((SuperGraph)var0.getSuperGraph(), var4, var5);
      selectRawGraph((SingleGraph)var0.getPrimaryGraph(), var6, var7);
      selectRawGraph((SingleGraph)var0.getSecondaryGraph(), var8, var9);
      updateAllGraphViews(var0);
   }

   private static void synchronizeNodesSelection(SingleGraph var0, Set var1) {
      ESide var2 = var0.getSide();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      ArrayList var8 = new ArrayList();
      Iterator var9 = var0.getCombinedGraph().getNodes().iterator();

      while(var9.hasNext()) {
         CombinedDiffNode var10 = (CombinedDiffNode)var9.next();
         SingleDiffNode var11 = var2 == ESide.PRIMARY?var10.getPrimaryDiffNode():var10.getSecondaryDiffNode();
         SingleDiffNode var12 = var2 == ESide.SECONDARY?var10.getPrimaryDiffNode():var10.getSecondaryDiffNode();
         SuperDiffNode var13 = var10.getSuperDiffNode();
         boolean var14 = var11 == null && var12.isSelected() || var11 != null && var1.contains(var11);
         ArrayList var15 = var14?var5:var6;
         ArrayList var16 = var14?var3:var4;
         ArrayList var17 = var14?var7:var8;
         var16.add(var10);
         var15.add(var13);
         if(var12 != null) {
            var17.add(var12);
         }
      }

      selectRawGraph((SingleGraph)var0.getOtherSideGraph(), var7, var8);
      selectRawGraph((CombinedGraph)var0.getCombinedGraph(), var3, var4);
      selectRawGraph((SuperGraph)var0.getSuperGraph(), var5, var6);
      selectRawEdges(var0);
      updateAllGraphViews(var0);
   }

   private static void updateAllGraphViews(BinDiffGraph var0) {
      var0.getPrimaryGraph().getGraph().T();
      var0.getSecondaryGraph().getGraph().T();
      var0.getSuperGraph().getGraph().T();
      var0.getCombinedGraph().getGraph().T();
   }

   private static boolean willChangeNodeVisibility(BinDiffGraph var0, Set var1) {
      GraphProximityBrowsingSettings var2 = var0.getSettings().getProximitySettings();
      if(var2.getProximityBrowsing() && !var2.getProximityBrowsingFrozen()) {
         int var3 = var2.getProximityBrowsingChildren();
         int var4 = var2.getProximityBrowsingParents();
         Set var5 = ProximityRangeCalculator.getNeighbors(var0, var1, var3, var4);
         Iterator var6 = var0.getNodes().iterator();

         while(var6.hasNext()) {
            ZyGraphNode var7 = (ZyGraphNode)var6.next();
            if(var7.isVisible()) {
               if(!var1.contains(var7) && !var5.contains(var7)) {
                  return true;
               }
            } else if(var1.contains(var7) || var5.contains(var7)) {
               return true;
            }
         }
      }

      return false;
   }

   public static void executeStatic(BinDiffGraph var0) {
      if(var0.getSettings().isSync()) {
         if(var0 instanceof SingleGraph) {
            synchronizeNodesSelection((SingleGraph)var0, ((SingleGraph)var0).getSelectedNodes());
         } else if(var0 instanceof CombinedGraph) {
            synchronizeNodesSelection((CombinedGraph)var0, ((CombinedGraph)var0).getSelectedNodes());
         }

         updateAllGraphViews(var0);
      } else {
         if(var0 instanceof CombinedGraph) {
            CombinedGraph var1 = (CombinedGraph)var0;
            Set var2 = var1.getSelectedNodes();
            HashSet var3 = new HashSet();
            var3.addAll(var1.getNodes());
            var3.removeAll(var2);
            var1.selectNodes(var2, var3);
         }

         selectRawEdges(var0);
      }

      GraphsIntermediateListeners.notifyIntermediateSelectionListeners(var0);
      if(LayoutCommandHelper.hasSelectedNodes(var0) && willChangeNodeVisibility(var0, var0.getSelectedNodes()) && showVisibilityWarningDialog(var0)) {
         ProximityBrowserUpdater.executeStatic(var0);
         if(LayoutCommandHelper.isAutolayout(var0) && !LayoutCommandHelper.isProximityBrowsingFrozen(var0)) {
            GraphLayoutUpdater.executeStatic(var0, true);
         }
      }

   }

   public void execute() {
      executeStatic(this.referenceGraph);
   }
}
