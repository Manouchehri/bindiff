package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityNodeClickedUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityRangeCalculator;
import com.google.security.zynamics.zylib.types.common.ICommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y.c.q;

public class ProximityBrowserUnhideNode implements ICommand {
   private final BinDiffGraph graph;
   private final ZyGraphNode nodeToShow;

   public ProximityBrowserUnhideNode(BinDiffGraph var1, ZyGraphNode var2) {
      this.graph = (BinDiffGraph)Preconditions.checkNotNull(var1);
      this.nodeToShow = (ZyGraphNode)Preconditions.checkNotNull(var2);
   }

   private static void updateVisibility(BinDiffGraph var0, Set var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         if(!var3.isVisible()) {
            q var4;
            q var5;
            if(var3 instanceof SingleDiffNode) {
               var4 = ((SingleDiffNode)var3).getCombinedDiffNode().getNode();
               var5 = ((SingleDiffNode)var3).getSuperDiffNode().getNode();
               if(!((CombinedDiffNode)var0.getCombinedGraph().getNode(var4)).getRawNode().isVisible()) {
                  ((CombinedDiffNode)var0.getCombinedGraph().getNode(var4)).getRawNode().setVisible(true);
               }

               if(!((SuperDiffNode)var0.getSuperGraph().getNode(var5)).getRawNode().isVisible()) {
                  ((SuperDiffNode)var0.getSuperGraph().getNode(var5)).getRawNode().setVisible(true);
               }
            } else if(var3 instanceof CombinedDiffNode) {
               var4 = ((CombinedDiffNode)var3).getNode();
               var5 = ((CombinedDiffNode)var3).getSuperDiffNode().getNode();
               if(!((CombinedDiffNode)var0.getCombinedGraph().getNode(var4)).getRawNode().isVisible()) {
                  ((CombinedDiffNode)var0.getCombinedGraph().getNode(var4)).getRawNode().setVisible(true);
               }

               if(!((SuperDiffNode)var0.getSuperGraph().getNode(var5)).getRawNode().isVisible()) {
                  ((SuperDiffNode)var0.getSuperGraph().getNode(var5)).getRawNode().setVisible(true);
               }
            }
         }
      }

   }

   public static void executeStatic(BinDiffGraph var0, ZyGraphNode var1) {
      HashSet var2 = new HashSet();
      var2.add(var1);
      GraphProximityBrowsingSettings var3 = var0.getSettings().getProximitySettings();
      Set var4 = ProximityRangeCalculator.getNeighbors(var0, var2, var3.getProximityBrowsingChildren(), var3.getProximityBrowsingParents());
      updateVisibility(var0, var4);
      ProximityNodeClickedUpdater.updateProximityNodes(var0);
      GraphViewUpdater.updateViews(var0);
      GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(var0);
      if(LayoutCommandHelper.isAutolayout(var0)) {
         GraphLayoutUpdater.executeStatic(var0, true);
      }

   }

   public void execute() {
      executeStatic(this.graph, this.nodeToShow);
   }
}
