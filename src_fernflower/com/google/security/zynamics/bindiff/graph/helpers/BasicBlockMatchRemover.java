package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EJumpType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.BasicBlockContentEditor;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUnhideNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffBasicBlockNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.realizers.CodeNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.c.d;
import y.c.q;
import y.h.bu;

public class BasicBlockMatchRemover {
   private static CombinedDiffEdge buildDiffEdge(CombinedGraph var0, SuperViewEdge var1, SuperDiffEdge var2) {
      d var3 = null;
      RawCombinedJump var4 = (RawCombinedJump)var1.getCombinedEdge();
      ZyLabelContent var5 = new ZyLabelContent((IZyEditableObject)null);
      CombinedEdgeRealizer var6 = new CombinedEdgeRealizer(var5, (IEdgeRealizerUpdater)null, var0.getSettings());
      CombinedDiffNode var7 = (CombinedDiffNode)var0.getNode(var4.getSource());
      CombinedDiffNode var8 = (CombinedDiffNode)var0.getNode(var4.getTarget());
      q var9 = var7.getNode();
      q var10 = var8.getNode();
      boolean var11 = var7.getRawNode().isVisible();
      boolean var12 = var8.getRawNode().isVisible();
      var7.getRawNode().setVisible(true);
      var8.getRawNode().setVisible(true);
      var3 = var0.getGraph().a(var9, var10);
      CombinedDiffEdge var13 = new CombinedDiffEdge(var7, var8, var3, var6, var4, var2);
      CombinedDiffNode.link(var7, var8);
      var6.setUserData(new ZyEdgeData(var13));
      var7.getRawNode().setVisible(var11);
      var8.getRawNode().setVisible(var12);
      var0.addEdgeToMappings(var13);
      if(!var11 || !var12) {
         CombinedGraph var15 = var0;
         boolean var16 = LayoutCommandHelper.deactiveAutoLayout(var0);

         try {
            ProximityBrowserUnhideNode.executeStatic(var15, var11?var7:var8);
         } finally {
            LayoutCommandHelper.activateAutoLayout(var0, var16);
         }
      }

      return var13;
   }

   private static SingleDiffEdge buildDiffEdge(SingleGraph var0, SuperViewEdge var1) {
      SingleDiffEdge var2 = null;
      d var3 = null;
      RawCombinedJump var4 = (RawCombinedJump)var1.getCombinedEdge();
      RawBasicBlock var5 = var4.getSource().getRawNode(var0.getSide());
      RawBasicBlock var6 = var4.getTarget().getRawNode(var0.getSide());
      RawJump var7 = var0.getSide() == ESide.PRIMARY?var4.getPrimaryEdge():var4.getSecondaryEdge();
      if(var7 == null) {
         return null;
      } else {
         SingleEdgeRealizer var8 = null;
         if(var5 != null && var6 != null && var7 != null) {
            ZyLabelContent var9 = new ZyLabelContent((IZyEditableObject)null);
            var8 = new SingleEdgeRealizer(var9, (IEdgeRealizerUpdater)null, var0.getSettings());
            SingleDiffNode var10 = (SingleDiffNode)var0.getNode(var5);
            SingleDiffNode var11 = (SingleDiffNode)var0.getNode(var6);
            boolean var12 = var10.getRawNode().isVisible();
            boolean var13 = var11.getRawNode().isVisible();
            var10.getRawNode().setVisible(true);
            var11.getRawNode().setVisible(true);
            var3 = var0.getGraph().a(var10.getNode(), var11.getNode());
            var2 = new SingleDiffEdge(var10, var11, var3, var8, var7, var0.getSide());
            SingleDiffNode.link(var10, var11);
            var8.setUserData(new ZyEdgeData(var2));
            var10.getRawNode().setVisible(var12);
            var11.getRawNode().setVisible(var13);
            var0.addEdgeToMappings(var2);
            if(!var12 || !var13) {
               SingleGraph var15 = var0;
               boolean var16 = LayoutCommandHelper.deactiveAutoLayout(var0);

               try {
                  ProximityBrowserUnhideNode.executeStatic(var15, var12?var10:var11);
               } finally {
                  LayoutCommandHelper.activateAutoLayout(var0, var16);
               }
            }
         }

         return var2;
      }
   }

   private static SuperDiffEdge buildDiffEdge(SuperGraph var0, SuperViewEdge var1, SingleDiffEdge var2, SingleDiffEdge var3) {
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
      boolean var11 = var7.getRawNode().isVisible();
      boolean var12 = var8.getRawNode().isVisible();
      var7.getRawNode().setVisible(true);
      var8.getRawNode().setVisible(true);
      var4 = var0.getGraph().a(var9, var10);
      SuperDiffEdge var13 = new SuperDiffEdge(var7, var8, var4, var6, var1, var2, var3);
      SuperDiffNode.link(var7, var8);
      var6.setUserData(new ZyEdgeData(var13));
      var7.getRawNode().setVisible(var11);
      var8.getRawNode().setVisible(var12);
      var0.addEdgeToMappings(var13);
      return var13;
   }

   private static CombinedDiffNode buildDiffNode(CombinedGraph var0, SingleDiffNode var1, SingleDiffNode var2, SuperDiffNode var3, RawCombinedBasicBlock var4) {
      ZyLabelContent var5 = null;
      if(var1 != null) {
         var5 = var1.getRealizer().getNodeContent();
      }

      ZyLabelContent var6 = null;
      if(var2 != null) {
         var6 = var2.getRealizer().getNodeContent();
      }

      CombinedNodeRealizer var7 = new CombinedNodeRealizer(var5, var6);
      CodeNodeRealizerUpdater var8 = new CodeNodeRealizerUpdater();
      var7.setUpdater(var8);
      var8.setRealizer(var7);
      q var9 = var0.getGraph().d();
      CombinedDiffNode var10 = new CombinedDiffNode(var9, var7, var4, var3);
      var7.setUserData(new ZyNodeData(var10));
      return var10;
   }

   private static SingleDiffNode buildDiffNode(SingleGraph var0, FunctionMatchData var1, RawCombinedFlowGraph var2, RawCombinedBasicBlock var3) {
      SingleDiffBasicBlockNode var4 = null;
      ZyLabelContent var5 = null;
      bu var6 = var0.getGraph();
      RawBasicBlock var7 = var3.getRawNode(var0.getSide());
      if(var7 != null) {
         var5 = ViewFlowGraphBuilder.buildSingleBasicblockLabelContent(var1, var2, var3, var0.getSide());
         ZyNormalNodeRealizer var8 = new ZyNormalNodeRealizer(var5);
         CodeNodeRealizerUpdater var9 = new CodeNodeRealizerUpdater();
         var8.setUpdater(var9);
         var9.setRealizer(var8);
         q var10 = var6.d();
         var4 = new SingleDiffBasicBlockNode(var10, var8, var7, var0.getSide());
         var8.setUserData(new ZyNodeData(var4));
      }

      return var4;
   }

   private static SuperDiffNode buildDiffNode(SuperGraph var0, SingleDiffNode var1, SingleDiffNode var2, SuperViewNode var3) {
      ZyLabelContent var4 = new ZyLabelContent((IZyEditableObject)null);
      ZyNormalNodeRealizer var5 = new ZyNormalNodeRealizer(var4);
      q var6 = var0.getGraph().d();
      SuperDiffNode var7 = new SuperDiffNode(var6, var5, var3, var1, var2);
      var5.setUserData(new ZyNodeData(var7));
      return var7;
   }

   private static RawCombinedFlowGraph getRawCombinedFlowgraph(GraphsContainer var0, CombinedDiffNode var1) {
      IAddress var2 = ((RawCombinedBasicBlock)var1.getRawNode()).getPrimaryFunctionAddress();
      IAddress var3 = ((RawCombinedBasicBlock)var1.getRawNode()).getSecondaryFunctionAddress();
      ViewManager var4 = var0.getDiff().getViewManager();
      FlowGraphViewData var5 = var4.getFlowgraphViewData(var2, var3);
      return var5.getCombinedRawGraph();
   }

   private static void insertNewDiffEdges(GraphsContainer var0, SuperDiffNode var1) {
      SuperGraph var2 = var0.getSuperGraph();
      CombinedGraph var3 = var0.getCombinedGraph();
      SingleGraph var4 = var0.getPrimaryGraph();
      SingleGraph var5 = var0.getSecondaryGraph();
      SuperViewNode var6 = var1.getRawNode();
      HashSet var7 = new HashSet();
      var7.addAll(var6.getIncomingEdges());
      var7.addAll(var6.getOutgoingEdges());
      Iterator var8 = var7.iterator();

      while(var8.hasNext()) {
         SuperViewEdge var9 = (SuperViewEdge)var8.next();
         SingleDiffEdge var10 = buildDiffEdge(var4, var9);
         SingleDiffEdge var11 = buildDiffEdge(var5, var9);
         SuperDiffEdge var12 = buildDiffEdge(var2, var9, var10, var11);
         CombinedDiffEdge var13 = buildDiffEdge(var3, var9, var12);
         ZyEdgeRealizer var14 = null;
         ZyEdgeRealizer var15 = null;
         var12.setCombinedDiffEdge(var13);
         if(var10 != null) {
            var10.setCombinedDiffEdge(var13);
            var14 = var10.getRealizer();
         }

         if(var11 != null) {
            var11.setCombinedDiffEdge(var13);
            var15 = var11.getRealizer();
         }

         RawCombinedJump var16 = (RawCombinedJump)var9.getCombinedEdge();
         ViewFlowGraphBuilder.colorizeJumps(var16, var14, var15);
         ViewFlowGraphBuilder.stylizeJumps(var16, var13.getRealizer(), var14, var15);
      }

   }

   private static void insertNewDiffNodes(GraphsContainer var0, RawCombinedFlowGraph var1, SuperViewNode var2) {
      RawCombinedBasicBlock var3 = (RawCombinedBasicBlock)var2.getCombinedNode();
      ESide var4 = var3.getRawNode(ESide.PRIMARY) != null?ESide.PRIMARY:ESide.SECONDARY;
      CombinedGraph var5 = var0.getCombinedGraph();
      SingleGraph var6 = var4 == ESide.PRIMARY?var0.getPrimaryGraph():var0.getSecondaryGraph();
      SuperGraph var7 = var0.getSuperGraph();
      MatchData var8 = var0.getDiff().getMatches();
      FunctionMatchData var9 = var8.getFunctionMatch(var4 == ESide.PRIMARY?var3.getPrimaryFunctionAddress():var3.getSecondaryFunctionAddress(), var4);
      SingleDiffNode var10 = buildDiffNode(var6, var9, var1, var3);
      SuperDiffNode var11 = buildDiffNode(var7, var4 == ESide.PRIMARY?var10:null, var4 == ESide.SECONDARY?var10:null, var2);
      CombinedDiffNode var12 = buildDiffNode(var5, var4 == ESide.PRIMARY?var10:null, var4 == ESide.SECONDARY?var10:null, var11, var3);
      var11.setCombinedDiffNode(var12);
      var10.setCombinedDiffNode(var12);
      var6.addNodeToMappings(var10);
      BasicBlockContentEditor var13 = new BasicBlockContentEditor(var9, var0, var4);
      var10.getRealizer().getNodeContent().setLineEditor(var13);
      var5.addNodeToMappings(var12);
      var7.addNodeToMappings(var11);
      ViewFlowGraphBuilder.colorizeBasicblocks(var9, var3);
      ViewFlowGraphBuilder.colorizeCombinedNodeLineBorders(var5.getNodes(), var5.getPrimaryGraph().getFunctionAddress(), var5.getSecondaryGraph().getFunctionAddress());
      ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(var6.getNodes(), var6.getFunctionAddress());
      var7.refreshSuperNodeSize(var0.getPrimaryGraph(), var0.getSecondaryGraph(), var11);
      insertNewDiffEdges(var0, var11);
   }

   private static void insertNewRawNodes(RawCombinedFlowGraph var0, RawFlowGraph var1, Set var2, SuperViewNode var3, RawBasicBlock var4, RawCombinedBasicBlock var5, SuperViewNode var6) {
      var0.addNode(var5);
      var1.addNode(var4);
      ESide var7 = var1.getSide();
      Iterator var8 = var2.iterator();

      while(var8.hasNext()) {
         SuperViewEdge var9 = (SuperViewEdge)var8.next();
         if(var9.getSingleEdge(var7) != null) {
            SuperViewNode var10 = (SuperViewNode)var9.getSource();
            RawCombinedBasicBlock var11 = (RawCombinedBasicBlock)var10.getCombinedNode();
            RawBasicBlock var12 = var11.getRawNode(var7);
            SuperViewNode var13 = (SuperViewNode)var9.getTarget();
            RawCombinedBasicBlock var14 = (RawCombinedBasicBlock)var13.getCombinedNode();
            RawBasicBlock var15 = var14.getRawNode(var7);
            if(var13 == var3) {
               var13 = var6;
               var14 = var5;
               var15 = var4;
            }

            if(var10 == var3) {
               var10 = var6;
               var11 = var5;
               var12 = var4;
            }

            RawJump var16 = null;
            EJumpType var17 = ((RawJump)var9.getSingleEdge(var7)).getJumpType();
            var16 = new RawJump(var12, var15, var17);
            var1.addEdge(var16);
            RawCombinedJump var18 = new RawCombinedJump(var11, var14, var7 == ESide.PRIMARY?var16:null, var7 == ESide.SECONDARY?var16:null);
            var0.addEdge(var18);
            new SuperViewEdge(var18, var10, var13);
         }
      }

   }

   private static void removeBasicblockMatch(GraphsContainer var0, RawCombinedBasicBlock var1) {
      MatchData var2 = var0.getDiff().getMatches();
      FunctionMatchData var3 = var2.getFunctionMatch(var1.getPrimaryFunctionAddress(), ESide.PRIMARY);
      var3.removeBasicblockMatch(var0.getDiff(), var1);
   }

   protected static void syncBasicblockVisibility(GraphsContainer var0, CombinedDiffNode var1) {
      GraphSettings var2 = var0.getSettings();
      if(var2.isAsync()) {
         boolean var3 = LayoutCommandHelper.deactiveAutoLayout(var0.getCombinedGraph());

         try {
            if(var2.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
               var1.getPrimaryRawNode().setVisible(true);
               var1.getSecondaryRawNode().setVisible(true);
               var1.getSuperRawNode().setVisible(true);
            } else if(var2.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
               var1.getRawNode().setVisible(true);
               var1.getPrimaryRawNode().setVisible(true);
               var1.getSecondaryRawNode().setVisible(true);
               var1.getSuperRawNode().setVisible(true);
            }
         } finally {
            LayoutCommandHelper.activateAutoLayout(var0.getCombinedGraph(), var3);
         }
      }

   }

   public static void doSynchronizedLayout(CombinedGraph var0) {
      if(LayoutCommandHelper.isAutolayout(var0)) {
         GraphSettings var1 = var0.getSettings();
         if(!var1.isSync() && var1.getDiffViewMode() != EDiffViewMode.COMBINED_VIEW) {
            if(var1.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
               if(var1.getFocus() == ESide.PRIMARY) {
                  GraphLayoutUpdater.executeStatic(var0.getPrimaryGraph(), true);
               }

               if(var1.getFocus() == ESide.SECONDARY) {
                  GraphLayoutUpdater.executeStatic(var0.getSecondaryGraph(), true);
               }
            }
         } else {
            GraphLayoutUpdater.executeStatic(var0, true);
         }
      }

   }

   public static List getAffectedCombinedNodes(BinDiffGraph var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2;
      if(var0 instanceof CombinedGraph) {
         var2 = ((CombinedGraph)var0).getSelectedNodes().iterator();

         while(var2.hasNext()) {
            CombinedDiffNode var3 = (CombinedDiffNode)var2.next();
            if(var3.getRawNode().getMatchState() == EMatchState.MATCHED) {
               var1.add(var3);
            }
         }
      } else if(var0 instanceof SingleGraph) {
         var2 = ((SingleGraph)var0).getSelectedNodes().iterator();

         while(var2.hasNext()) {
            SingleDiffNode var4 = (SingleDiffNode)var2.next();
            if(var4.getRawNode().getMatchState() == EMatchState.MATCHED && var4.isSelected() && var4.isVisible() && var4.getOtherSideDiffNode().isSelected() && var4.getOtherSideDiffNode().isVisible()) {
               var1.add(var4.getCombinedDiffNode());
            }
         }
      }

      return var1.size() != 0?var1:null;
   }

   public static List getAffectedCombinedNodes(BinDiffGraph var0, ZyGraphNode var1) {
      return var1.isSelected()?getAffectedCombinedNodes(var0):null;
   }

   public static void removeBasicblockMatch(GraphsContainer var0, CombinedDiffNode var1) {
      var0.getCombinedGraph().getIntermediateListeners().blockZyLibVisibilityListeners();
      var0.getCombinedGraph().getIntermediateListeners().blockZyLibSelectionListeners();

      try {
         SuperDiffNode var2 = var1.getSuperDiffNode();
         SingleDiffNode var3 = var1.getPrimaryDiffNode();
         SingleDiffNode var4 = var1.getSecondaryDiffNode();
         RawCombinedBasicBlock var5 = (RawCombinedBasicBlock)var1.getRawNode();
         SuperViewNode var6 = var2.getRawNode();
         RawBasicBlock var7 = (RawBasicBlock)var3.getRawNode();
         RawBasicBlock var8 = (RawBasicBlock)var4.getRawNode();
         RawCombinedFlowGraph var9 = getRawCombinedFlowgraph(var0, var1);
         RawFlowGraph var10 = var9.getPrimaryFlowgraph();
         RawFlowGraph var11 = var9.getSecondaryFlowgraph();
         syncBasicblockVisibility(var0, var1);
         HashSet var12 = new HashSet();
         var12.addAll(var6.getIncomingEdges());
         var12.addAll(var6.getOutgoingEdges());
         var9.removeNode(var5);
         var6.removeNode();
         var10.removeNode(var7);
         var11.removeNode(var8);
         var0.getCombinedGraph().deleteNode(var1);
         var0.getSuperGraph().deleteNode(var2);
         var0.getPrimaryGraph().deleteNode(var3);
         var0.getSecondaryGraph().deleteNode(var4);
         RawBasicBlock var13 = var7.clone(EMatchState.PRIMARY_UNMATCHED);
         RawBasicBlock var14 = var8.clone(EMatchState.SECONDRAY_UNMATCHED);
         RawCombinedBasicBlock var15 = new RawCombinedBasicBlock(var13, (RawBasicBlock)null, (BasicBlockMatchData)null, var7.getFunctionAddr(), (IAddress)null);
         RawCombinedBasicBlock var16 = new RawCombinedBasicBlock((RawBasicBlock)null, var14, (BasicBlockMatchData)null, (IAddress)null, var8.getFunctionAddr());
         SuperViewNode var17 = new SuperViewNode(var15);
         SuperViewNode var18 = new SuperViewNode(var16);
         insertNewRawNodes(var9, var10, var12, var6, var13, var15, var17);
         insertNewRawNodes(var9, var11, var12, var6, var14, var16, var18);
         removeBasicblockMatch(var0, var5);
         insertNewDiffNodes(var0, var9, var17);
         insertNewDiffNodes(var0, var9, var18);
         var0.getDiff().getMatches().notifyBasicblockMatchRemovedListener(var13.getFunctionAddr(), var14.getFunctionAddr(), var13.getAddress(), var14.getAddress());
      } finally {
         var0.getCombinedGraph().getIntermediateListeners().freeZyLibVisibilityListeners();
         var0.getCombinedGraph().getIntermediateListeners().freeZyLibSelectionListeners();
      }

      doSynchronizedLayout(var0.getCombinedGraph());
   }
}
