package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.types.common.ICommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import java.awt.Font;
import java.util.HashSet;
import java.util.Iterator;
import y.c.d;
import y.c.q;
import y.c.x;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public final class ProximityBrowserUpdater implements ICommand {
   private final BinDiffGraph referenceGraph;

   public ProximityBrowserUpdater(BinDiffGraph var1) {
      this.referenceGraph = (BinDiffGraph)Preconditions.checkNotNull(var1);
   }

   private static void createNewProximityNodeAndEdge(bu var0, CombinedDiffNode var1, int var2, boolean var3) {
      if(var2 != 0) {
         ZyLabelContent var4 = new ZyLabelContent((IZyEditableObject)null);
         var4.addLineContent(new ZyLineContent(String.valueOf(var2), new Font("New Courier", 0, 12), (IZyEditableObject)null));
         ZyProximityNodeRealizer var5 = new ZyProximityNodeRealizer(var4);
         q var6 = var0.a((fj)var5);
         ZyProximityNode var7 = new ZyProximityNode(var6, var5, var1, var3);
         ZyNodeData var8 = new ZyNodeData(var7);
         var5.setUserData(var8);
         ZyEdgeRealizer var9 = new ZyEdgeRealizer(new ZyLabelContent((IZyEditableObject)null), (IEdgeRealizerUpdater)null);
         var9.setLineType(dr.b);
         d var10 = var0.a((q)(var3?var1.getNode():var7.getNode()), var3?var7.getNode():var1.getNode(), (aB)var9);
         ZyInfoEdge var11 = new ZyInfoEdge((ZyGraphNode)(var3?var1:var7), (ZyGraphNode)(var3?var7:var1), var10, var9);
         ZyEdgeData var12 = new ZyEdgeData(var11);
         var9.setUserData(var12);
      }
   }

   private static void createNewProximityNodeAndEdge(bu var0, SingleDiffNode var1, int var2, boolean var3) {
      if(var2 != 0) {
         ZyLabelContent var4 = new ZyLabelContent((IZyEditableObject)null);
         var4.addLineContent(new ZyLineContent(String.valueOf(var2), new Font("New Courier", 0, 12), (IZyEditableObject)null));
         ZyProximityNodeRealizer var5 = new ZyProximityNodeRealizer(var4);
         q var6 = var0.a((fj)var5);
         ZyProximityNode var7 = new ZyProximityNode(var6, var5, var1, var3);
         ZyNodeData var8 = new ZyNodeData(var7);
         var5.setUserData(var8);
         ZyEdgeRealizer var9 = new ZyEdgeRealizer(new ZyLabelContent((IZyEditableObject)null), (IEdgeRealizerUpdater)null);
         var9.setLineType(dr.b);
         d var10 = var0.a((q)(var3?var1.getNode():var7.getNode()), var3?var7.getNode():var1.getNode(), (aB)var9);
         ZyInfoEdge var11 = new ZyInfoEdge((ZyGraphNode)(var3?var1:var7), (ZyGraphNode)(var3?var7:var1), var10, var9);
         ZyEdgeData var12 = new ZyEdgeData(var11);
         var9.setUserData(var12);
      }
   }

   private static void unhideAllNodes(BinDiffGraph var0) {
      Iterator var1 = var0.getNodes().iterator();

      while(var1.hasNext()) {
         ZyGraphNode var2 = (ZyGraphNode)var1.next();
         if(!var2.isVisible()) {
            var2.getRawNode().setVisible(true);
         }
      }

   }

   private static void updateGraphVisibility(BinDiffGraph var0) {
      HashSet var1 = new HashSet();
      HashSet var2 = new HashSet();
      var2.addAll(var0.getNodes());
      var1.addAll(var0.getSelectedNodes());
      var2.removeAll(var1);
      var0.showNodes(var1, var2);
   }

   private static void updateProximityBrowserInAsyncMode(BinDiffGraph var0) {
      if(var0 instanceof CombinedGraph) {
         updateGraphVisibility(var0);
         deleteAllProximityNodes(var0);
         createProximityNodesAndEdges((CombinedGraph)var0);
      } else if(var0 instanceof SingleGraph) {
         updateGraphVisibility(var0);
         deleteAllProximityNodes(var0);
         createProximityNodesAndEdges((SingleGraph)var0);
      }

   }

   protected static void adoptSuperGraphVisibility(SuperGraph var0) {
      Iterator var1 = var0.getNodes().iterator();

      while(var1.hasNext()) {
         SuperDiffNode var2 = (SuperDiffNode)var1.next();
         SingleDiffNode var3 = var2.getPrimaryDiffNode();
         if(var3 != null) {
            var3.getRawNode().setVisible(var2.isVisible());
         }

         SingleDiffNode var4 = var2.getSecondaryDiffNode();
         if(var4 != null) {
            var4.getRawNode().setVisible(var2.isVisible());
         }
      }

      var1 = var0.getEdges().iterator();

      while(var1.hasNext()) {
         SuperDiffEdge var5 = (SuperDiffEdge)var1.next();
         SingleDiffEdge var6 = var5.getPrimaryDiffEdge();
         SingleDiffEdge var7 = var5.getSecondaryDiffEdge();
         if(var6 != null) {
            ((SingleViewEdge)var5.getPrimaryDiffEdge().getRawEdge()).setVisible(var5.isVisible());
         }

         if(var7 != null) {
            ((SingleViewEdge)var5.getSecondaryDiffEdge().getRawEdge()).setVisible(var5.isVisible());
         }
      }

   }

   protected static void createProximityNodesAndEdges(CombinedGraph var0) {
      bu var1 = var0.getGraph();
      Iterator var2 = var0.getNodes().iterator();

      while(true) {
         CombinedDiffNode var3;
         do {
            if(!var2.hasNext()) {
               return;
            }

            var3 = (CombinedDiffNode)var2.next();
         } while(!var3.isVisible());

         HashSet var4 = new HashSet();
         Iterator var5 = var3.getParents().iterator();

         while(var5.hasNext()) {
            CombinedDiffNode var6 = (CombinedDiffNode)var5.next();
            if(!var6.isVisible()) {
               var4.add(var6);
            }
         }

         createNewProximityNodeAndEdge(var1, var3, var4.size(), false);
         HashSet var8 = new HashSet();
         Iterator var9 = var3.getChildren().iterator();

         while(var9.hasNext()) {
            CombinedDiffNode var7 = (CombinedDiffNode)var9.next();
            if(!var7.isVisible()) {
               var8.add(var7);
            }
         }

         createNewProximityNodeAndEdge(var1, var3, var8.size(), true);
      }
   }

   protected static void createProximityNodesAndEdges(SingleGraph var0) {
      bu var1 = var0.getGraph();
      Iterator var2 = var0.getNodes().iterator();

      while(true) {
         SingleDiffNode var3;
         do {
            if(!var2.hasNext()) {
               return;
            }

            var3 = (SingleDiffNode)var2.next();
         } while(!var3.isVisible());

         HashSet var4 = new HashSet();
         Iterator var5 = var3.getParents().iterator();

         while(var5.hasNext()) {
            SingleDiffNode var6 = (SingleDiffNode)var5.next();
            if(!var6.isVisible()) {
               var4.add(var6);
            }
         }

         createNewProximityNodeAndEdge(var1, var3, var4.size(), false);
         HashSet var8 = new HashSet();
         Iterator var9 = var3.getChildren().iterator();

         while(var9.hasNext()) {
            SingleDiffNode var7 = (SingleDiffNode)var9.next();
            if(!var7.isVisible()) {
               var8.add(var7);
            }
         }

         createNewProximityNodeAndEdge(var1, var3, var8.size(), true);
      }
   }

   static void createProximityNodesAndEdges(SuperGraph var0) {
      bu var1 = var0.getPrimaryGraph().getGraph();
      bu var2 = var0.getSecondaryGraph().getGraph();
      if(var0.getSettings().getProximitySettings().getProximityBrowsing()) {
         q[] var3 = var0.getGraph().m();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            q var6 = var3[var5];
            fj var7 = var0.getGraph().t(var6);
            if(var7 instanceof ZyProximityNodeRealizer) {
               d var8;
               q var9;
               SuperDiffNode var10;
               boolean var11;
               SingleDiffNode var12;
               boolean var13;
               SingleDiffNode var14;
               int var15;
               int var16;
               if(var6.b() == 0 && var6.c() == 1) {
                  var8 = var6.f();
                  var9 = var8.d();
                  var10 = (SuperDiffNode)var0.getNode(var9);
                  var11 = false;
                  var12 = var10.getPrimaryDiffNode();
                  if(var12 != null) {
                     var15 = NodeHelpers.countInvisibleIndegreeNeighbours(var12.getRawNode());
                     createNewProximityNodeAndEdge(var1, var12, var15, false);
                  }

                  var13 = false;
                  var14 = var10.getSecondaryDiffNode();
                  if(var14 != null) {
                     var16 = NodeHelpers.countInvisibleIndegreeNeighbours(var14.getRawNode());
                     createNewProximityNodeAndEdge(var2, var14, var16, false);
                  }
               } else if(var6.b() == 1 && var6.c() == 0) {
                  var8 = var6.g();
                  var9 = var8.c();
                  var10 = (SuperDiffNode)var0.getNode(var9);
                  var11 = false;
                  var12 = var10.getPrimaryDiffNode();
                  if(var12 != null) {
                     var15 = NodeHelpers.countInvisibleOutdegreeNeighbours(var12.getRawNode());
                     createNewProximityNodeAndEdge(var1, var12, var15, true);
                  }

                  var13 = false;
                  var14 = var10.getSecondaryDiffNode();
                  if(var14 != null) {
                     var16 = NodeHelpers.countInvisibleOutdegreeNeighbours(var14.getRawNode());
                     createNewProximityNodeAndEdge(var2, var14, var16, true);
                  }
               } else {
                  Logger.logSevere("Malformed graph. Super proximity node without incoming or outgoing edge.", new Object[0]);
               }
            }
         }
      }

   }

   static void deleteAllProximityNodes(BinDiffGraph var0) {
      bu var1 = var0.getGraph();

      try {
         var1.r();
         var0.getProximityBrowser().deleteProximityNodes();

         for(x var2 = var1.o(); var2.f(); var2.g()) {
            if(var1.t(var2.e()) instanceof ZyProximityNodeRealizer) {
               if(var2.e().e() != var1) {
                  throw new GraphLayoutException("Delete proximity node failed. Couldn\'t update proximity browsing.");
               }

               var1.a((q)var2.e());
            }
         }
      } finally {
         var1.s();
      }

   }

   public static void executeStatic(BinDiffGraph var0) {
      try {
         GraphProximityBrowsingSettings var1 = var0.getSettings().getProximitySettings();
         if(var1.getProximityBrowsing() && !var1.getProximityBrowsingFrozen()) {
            boolean var2 = var0.getSettings().getLayoutSettings().getAutomaticLayouting();
            var0.getSettings().getLayoutSettings().setAutomaticLayouting(false);
            if(var0.getSettings().isSync()) {
               updateGraphVisibility(var0.getCombinedGraph());
               updateGraphVisibility(var0.getSuperGraph());
               adoptSuperGraphVisibility(var0.getSuperGraph());
               deleteAllProximityNodes(var0.getPrimaryGraph());
               deleteAllProximityNodes(var0.getSecondaryGraph());
               createProximityNodesAndEdges(var0.getSuperGraph());
            } else {
               updateProximityBrowserInAsyncMode(var0);
            }

            GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(var0);
            var0.getSettings().getLayoutSettings().setAutomaticLayouting(var2);
         } else if(!var1.getProximityBrowsing()) {
            try {
               unhideAllNodes(var0.getSuperGraph());
               unhideAllNodes(var0.getPrimaryGraph());
               unhideAllNodes(var0.getSecondaryGraph());
               unhideAllNodes(var0.getCombinedGraph());
            } catch (Exception var3) {
               throw new GraphLayoutException(var3, "Failed to unhide node. Couldn\'t update proximity browser.");
            }
         }

      } catch (GraphLayoutException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new GraphLayoutException(var5, "Failed to update proximity browser.");
      }
   }

   public void execute() {
      executeStatic(this.referenceGraph);
   }
}
