package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserDeactivator;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import java.util.HashSet;
import java.util.Iterator;

public class GraphReactivateViewSynchronization {
   private static void synchronizeNodeSelection(BinDiffGraph var0) {
      HashSet var1 = new HashSet();
      HashSet var2 = new HashSet();
      HashSet var3 = new HashSet();
      HashSet var4 = new HashSet();
      GraphSettings var5 = var0.getSettings();
      Iterator var6 = var0.getCombinedGraph().getNodes().iterator();

      while(var6.hasNext()) {
         CombinedDiffNode var7 = (CombinedDiffNode)var6.next();
         SingleDiffNode var8 = var7.getPrimaryDiffNode();
         SingleDiffNode var9 = var7.getSecondaryDiffNode();
         boolean var10 = var8 != null && var8.isSelected();
         boolean var11 = var9 != null && var9.isSelected();
         boolean var12 = var5.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && (var10 || var11);
         var12 = var12 || var5.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW && var7.isSelected();
         if(var12) {
            if(var8 != null) {
               var3.add(var8);
            }

            if(var9 != null) {
               var4.add(var9);
            }

            var1.add(var7.getSuperDiffNode());
            var2.add(var7);
         }
      }

      boolean var16 = var5.getProximitySettings().getProximityBrowsingFrozen();

      try {
         var5.getProximitySettings().setProximityBrowsingFrozen(true);
         HashSet var17 = new HashSet();
         var17.addAll(var0.getCombinedGraph().getNodes());
         var17.removeAll(var2);
         var0.getCombinedGraph().selectNodes(var2, var17);
         HashSet var18 = new HashSet();
         var18.addAll(var0.getSuperGraph().getNodes());
         var18.removeAll(var1);
         var0.getSuperGraph().selectNodes(var1, var18);
         HashSet var19 = new HashSet();
         var19.addAll(var0.getPrimaryGraph().getNodes());
         var19.removeAll(var3);
         var0.getPrimaryGraph().selectNodes(var3, var19);
         HashSet var20 = new HashSet();
         var20.addAll(var0.getSecondaryGraph().getNodes());
         var20.removeAll(var4);
         var0.getSecondaryGraph().selectNodes(var4, var20);
      } finally {
         var5.getProximitySettings().setProximityBrowsingFrozen(var16);
      }

   }

   private static void synchronizeNodeVisibility(BinDiffGraph var0) {
      HashSet var1 = new HashSet();
      HashSet var2 = new HashSet();
      if(var0.getSettings().getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
         Iterator var3 = var0.getCombinedGraph().getNodes().iterator();

         while(var3.hasNext()) {
            CombinedDiffNode var4 = (CombinedDiffNode)var3.next();
            if(var4.isVisible()) {
               var1.add(var4.getSuperDiffNode());
            } else {
               var2.add(var4.getSuperDiffNode());
            }
         }
      } else if(var0.getSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         HashSet var8 = new HashSet();
         HashSet var9 = new HashSet();
         Iterator var5 = var0.getPrimaryGraph().getNodes().iterator();

         SingleDiffNode var6;
         while(var5.hasNext()) {
            var6 = (SingleDiffNode)var5.next();
            if(var6.isVisible()) {
               var1.add(var6.getSuperDiffNode());
               var8.add(var6.getCombinedDiffNode());
            } else {
               var2.add(var6.getSuperDiffNode());
               var9.add(var6.getCombinedDiffNode());
            }
         }

         var5 = var0.getSecondaryGraph().getNodes().iterator();

         while(var5.hasNext()) {
            var6 = (SingleDiffNode)var5.next();
            if(var6.isVisible()) {
               var1.add(var6.getSuperDiffNode());
               var8.add(var6.getCombinedDiffNode());
               SingleDiffNode var7 = var6.getOtherSideDiffNode();
               if(var7 != null && !var7.isVisible()) {
                  var2.remove(var7.getSuperDiffNode());
                  var9.remove(var6.getCombinedDiffNode());
               }
            } else if(!var1.contains(var6.getSuperDiffNode())) {
               var2.add(var6.getSuperDiffNode());
               var9.add(var6.getCombinedDiffNode());
            }
         }

         var0.getCombinedGraph().showNodes(var8, var9, false);
      }

      var0.getSuperGraph().showNodes(var1, var2, false);
   }

   public static void executeStatic(BinDiffGraph var0) {
      GraphProximityBrowsingSettings var1 = var0.getSettings().getProximitySettings();
      if(var1.getProximityBrowsing()) {
         if(var0.getSettings().getDiffViewMode() != EDiffViewMode.COMBINED_VIEW) {
            ProximityBrowserUpdater.deleteAllProximityNodes(var0.getCombinedGraph());
         }

         synchronizeNodeSelection(var0);
         synchronizeNodeVisibility(var0);
         ProximityBrowserUpdater.adoptSuperGraphVisibility(var0.getSuperGraph());
         ProximityBrowserUpdater.deleteAllProximityNodes(var0.getPrimaryGraph());
         ProximityBrowserUpdater.deleteAllProximityNodes(var0.getSecondaryGraph());
         ProximityBrowserUpdater.createProximityNodesAndEdges(var0.getSuperGraph());
      } else {
         ProximityBrowserDeactivator.executeStatic(var0);
      }

      GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(var0);
      if(LayoutCommandHelper.isAutolayout(var0)) {
         GraphLayoutUpdater.executeStatic(var0, false);
      }

   }
}
