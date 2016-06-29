package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphConverters;
import com.google.security.zynamics.zylib.types.graphs.GraphAlgorithms;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GraphSelector {
   private static void deselectNodes(BinDiffGraph var0, Collection var1) {
      HashSet var2 = new HashSet();
      HashSet var3 = new HashSet();
      var2.addAll(var0.getSelectedNodes());
      boolean var4 = var0.getSettings().getProximitySettings().getProximityBrowsing() && var0.getSettings().getProximitySettings().getProximityBrowsingFrozen();
      Iterator var5 = var1.iterator();

      while(true) {
         ZyGraphNode var6;
         do {
            if(!var5.hasNext()) {
               var3.addAll(var0.getNodes());
               var3.removeAll(var2);
               var0.selectNodes(var2, var3);
               return;
            }

            var6 = (ZyGraphNode)var5.next();
         } while(!var6.isVisible() && var4);

         var2.remove(var6);
      }
   }

   private static Set getSelectedLeafNodes(CombinedGraph var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getSelectedNodes().iterator();

      while(var2.hasNext()) {
         CombinedDiffNode var3 = (CombinedDiffNode)var2.next();
         boolean var4 = false;
         Iterator var5 = GraphAlgorithms.getSuccessors((IGraphNode)var3.getRawNode(), 1).iterator();

         while(var5.hasNext()) {
            CombinedViewNode var6 = (CombinedViewNode)var5.next();
            if(var6.isSelected()) {
               var4 = true;
            }
         }

         if(!var4) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private static Collection getSelectedLeafNodes(SingleGraph var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getSelectedNodes().iterator();

      while(var2.hasNext()) {
         SingleDiffNode var3 = (SingleDiffNode)var2.next();
         boolean var4 = false;
         Iterator var5 = GraphAlgorithms.getSuccessors((IGraphNode)var3.getRawNode(), 1).iterator();

         while(var5.hasNext()) {
            SingleViewNode var6 = (SingleViewNode)var5.next();
            if(var6.isSelected()) {
               var4 = true;
            }
         }

         if(!var4) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private static Set getSelectedRootNodes(CombinedGraph var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getSelectedNodes().iterator();

      while(var2.hasNext()) {
         CombinedDiffNode var3 = (CombinedDiffNode)var2.next();
         boolean var4 = false;
         Iterator var5 = GraphAlgorithms.getPredecessors((IGraphNode)var3.getRawNode(), 1).iterator();

         while(var5.hasNext()) {
            CombinedViewNode var6 = (CombinedViewNode)var5.next();
            if(var6.isSelected()) {
               var4 = true;
            }
         }

         if(!var4) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private static Set getSelectedRootNodes(SingleGraph var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getSelectedNodes().iterator();

      while(var2.hasNext()) {
         SingleDiffNode var3 = (SingleDiffNode)var2.next();
         boolean var4 = false;
         Iterator var5 = GraphAlgorithms.getPredecessors((IGraphNode)var3.getRawNode(), 1).iterator();

         while(var5.hasNext()) {
            SingleViewNode var6 = (SingleViewNode)var5.next();
            if(var6.isSelected()) {
               var4 = true;
            }
         }

         if(!var4) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private static void selectNodes(BinDiffGraph var0, Collection var1) {
      HashSet var2 = new HashSet();
      HashSet var3 = new HashSet();
      var3.addAll(var0.getNodes());
      var2.addAll(var0.getSelectedNodes());
      boolean var4 = var0.getSettings().getProximitySettings().getProximityBrowsing() && var0.getSettings().getProximitySettings().getProximityBrowsingFrozen();
      Iterator var5 = var1.iterator();

      while(true) {
         ZyGraphNode var6;
         do {
            if(!var5.hasNext()) {
               var3.removeAll(var2);
               var0.selectNodes(var2, var3);
               return;
            }

            var6 = (ZyGraphNode)var5.next();
         } while(!var6.isVisible() && var4);

         var2.add(var6);
      }
   }

   public static void deselectLeafs(CombinedGraph var0) {
      deselectNodes(var0, getSelectedLeafNodes(var0));
   }

   public static void deselectLeafs(SingleGraph var0) {
      deselectNodes(var0, getSelectedLeafNodes(var0));
   }

   public static void deselectPeriphery(CombinedGraph var0) {
      Set var1 = getSelectedRootNodes(var0);
      var1.addAll(getSelectedLeafNodes(var0));
      deselectNodes(var0, var1);
   }

   public static void deselectPeriphery(SingleGraph var0) {
      Set var1 = getSelectedRootNodes(var0);
      var1.addAll(getSelectedLeafNodes(var0));
      deselectNodes(var0, var1);
   }

   public static void deselectRoots(CombinedGraph var0) {
      deselectNodes(var0, getSelectedRootNodes(var0));
   }

   public static void deselectRoots(SingleGraph var0) {
      deselectNodes(var0, getSelectedRootNodes(var0));
   }

   public static void invertSelection(CombinedGraph var0) {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      boolean var3 = var0.getSettings().getProximitySettings().getProximityBrowsing() && var0.getSettings().getProximitySettings().getProximityBrowsingFrozen();
      Iterator var4 = var0.getNodes().iterator();

      while(true) {
         CombinedDiffNode var5;
         do {
            if(!var4.hasNext()) {
               var0.selectNodes(var1, var2);
               return;
            }

            var5 = (CombinedDiffNode)var4.next();
         } while(var3 && !var5.isVisible());

         if(var5.isSelected()) {
            var2.add(var5);
         } else {
            var1.add(var5);
         }
      }
   }

   public static void invertSelection(SingleGraph var0) {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      boolean var3 = var0.getSettings().getProximitySettings().getProximityBrowsing() && var0.getSettings().getProximitySettings().getProximityBrowsingFrozen();
      Iterator var4 = var0.getNodes().iterator();

      while(true) {
         SingleDiffNode var5;
         do {
            if(!var4.hasNext()) {
               var0.selectNodes(var1, var2);
               return;
            }

            var5 = (SingleDiffNode)var4.next();
         } while(var3 && !var5.isVisible());

         if(var5.isSelected()) {
            var2.add(var5);
         } else {
            var1.add(var5);
         }
      }
   }

   public static void selectAncestorsOfSelection(CombinedGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      selectNodes(var0, GraphConverters.convert(var0, GraphAlgorithms.getPredecessors((Collection)var1)));
   }

   public static void selectAncestorsOfSelection(SingleGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      selectNodes(var0, GraphConverters.convert(var0, GraphAlgorithms.getPredecessors((Collection)var1)));
   }

   public static void selectChildrenOfSelection(CombinedGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      selectNodes(var0, GraphConverters.convert(var0, GraphAlgorithms.getSuccessors((Iterable)var1, 1)));
   }

   public static void selectChildrenOfSelection(SingleGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      selectNodes(var0, GraphConverters.convert(var0, GraphAlgorithms.getSuccessors((Iterable)var1, 1)));
   }

   public static void selectNeighboursOfSelection(CombinedGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      HashSet var2 = new HashSet();
      var2.addAll(GraphConverters.convert(var0, GraphAlgorithms.getPredecessors((Iterable)var1, 1)));
      var2.addAll(GraphConverters.convert(var0, GraphAlgorithms.getSuccessors((Iterable)var1, 1)));
      selectNodes(var0, var2);
   }

   public static void selectNeighboursOfSelection(SingleGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      HashSet var2 = new HashSet();
      var2.addAll(GraphConverters.convert(var0, GraphAlgorithms.getPredecessors((Iterable)var1, 1)));
      var2.addAll(GraphConverters.convert(var0, GraphAlgorithms.getSuccessors((Iterable)var1, 1)));
      selectNodes(var0, var2);
   }

   public static void selectParentsOfSelection(CombinedGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      selectNodes(var0, GraphConverters.convert(var0, GraphAlgorithms.getPredecessors((Iterable)var1, 1)));
   }

   public static void selectParentsOfSelection(SingleGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      selectNodes(var0, GraphConverters.convert(var0, GraphAlgorithms.getPredecessors((Iterable)var1, 1)));
   }

   public static void selectSuccessorsOfSelection(CombinedGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      selectNodes(var0, GraphConverters.convert(var0, GraphAlgorithms.getSuccessors((Collection)var1)));
   }

   public static void selectSuccessorsOfSelection(SingleGraph var0) {
      List var1 = GraphConverters.convert(var0.getSelectedNodes());
      selectNodes(var0, GraphConverters.convert(var0, GraphAlgorithms.getSuccessors((Collection)var1)));
   }
}
