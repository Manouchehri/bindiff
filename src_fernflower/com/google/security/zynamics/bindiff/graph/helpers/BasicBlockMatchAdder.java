package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.database.MatchesDatabase;
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
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder$1;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder$InternalStruct;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchRemover;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.BasicBlockContentEditor;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
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
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class BasicBlockMatchAdder {
   private static BasicBlockMatchData createBasicblockMatchData(RawCombinedBasicBlock var0, RawCombinedBasicBlock var1) {
      long var2 = var0.getAddress(ESide.PRIMARY).toLong();
      long var4 = var1.getAddress(ESide.SECONDARY).toLong();
      int var6 = MatchesDatabase.UNSAVED_BASICBLOCKMATCH_ALGORITH_ID;
      Matches var7 = new Matches(getNewInstructionMatches());
      return new BasicBlockMatchData(var2, var4, var6, var7);
   }

   private static List getNewInstructionMatches() {
      return new ArrayList();
   }

   private static RawCombinedFlowGraph getRawCombinedFlowgraph(GraphsContainer var0, CombinedDiffNode var1, CombinedDiffNode var2) {
      IAddress var3 = ((RawCombinedBasicBlock)var1.getRawNode()).getPrimaryFunctionAddress();
      IAddress var4 = ((RawCombinedBasicBlock)var2.getRawNode()).getSecondaryFunctionAddress();
      ViewManager var5 = var0.getDiff().getViewManager();
      FlowGraphViewData var6 = var5.getFlowgraphViewData(var3, var4);
      return var6.getCombinedRawGraph();
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
         SingleDiffEdge var10 = SingleGraph.buildDiffEdge(var4, var9);
         SingleDiffEdge var11 = SingleGraph.buildDiffEdge(var5, var9);
         SuperDiffEdge var12 = SuperGraph.buildDiffEdge(var2, var9, var10, var11);
         CombinedDiffEdge var13 = CombinedGraph.buildDiffEdge(var3, var9, var12);
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

   private static void insertNewDiffNodesAndEdges(GraphsContainer var0, RawCombinedFlowGraph var1, SuperViewNode var2) {
      RawCombinedBasicBlock var3 = (RawCombinedBasicBlock)var2.getCombinedNode();
      CombinedGraph var4 = var0.getCombinedGraph();
      SuperGraph var5 = var0.getSuperGraph();
      SingleGraph var6 = var0.getPrimaryGraph();
      SingleGraph var7 = var0.getSecondaryGraph();
      MatchData var8 = var0.getDiff().getMatches();
      FunctionMatchData var9 = var8.getFunctionMatch(var3.getPrimaryFunctionAddress(), ESide.PRIMARY);
      SingleDiffNode var10 = SingleGraph.buildDiffNode(var6, var9, var1, var3);
      SingleDiffNode var11 = SingleGraph.buildDiffNode(var7, var9, var1, var3);
      SuperDiffNode var12 = SuperGraph.buildDiffNode(var5, var10, var11, var2);
      CombinedDiffNode var13 = CombinedGraph.buildDiffNode(var4, var10, var11, var12, var3);
      var12.setCombinedDiffNode(var13);
      var10.setCombinedDiffNode(var13);
      var11.setCombinedDiffNode(var13);
      var6.addNodeToMappings(var10);
      var7.addNodeToMappings(var11);
      var4.addNodeToMappings(var13);
      var5.addNodeToMappings(var12);
      BasicBlockContentEditor var14 = new BasicBlockContentEditor(var9, var0, ESide.PRIMARY);
      var10.getRealizer().getNodeContent().setLineEditor(var14);
      BasicBlockContentEditor var15 = new BasicBlockContentEditor(var9, var0, ESide.SECONDARY);
      var11.getRealizer().getNodeContent().setLineEditor(var15);
      ViewFlowGraphBuilder.colorizeBasicblocks(var9, var3);
      ViewFlowGraphBuilder.colorizeCombinedNodeLineBorders(var4.getNodes(), var4.getPrimaryGraph().getFunctionAddress(), var4.getSecondaryGraph().getFunctionAddress());
      ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(var6.getNodes(), var6.getFunctionAddress());
      ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(var7.getNodes(), var7.getFunctionAddress());
      var5.refreshSuperNodeSize(var0.getPrimaryGraph(), var0.getSecondaryGraph(), var12);
      insertNewDiffEdges(var0, var12);
   }

   private static void insertNewRawNodesAndEdges(RawCombinedFlowGraph var0, Set var1, SuperViewNode var2, SuperViewNode var3, RawBasicBlock var4, RawBasicBlock var5, RawCombinedBasicBlock var6, SuperViewNode var7) {
      RawFlowGraph var8 = var0.getPrimaryFlowgraph();
      RawFlowGraph var9 = var0.getSecondaryFlowgraph();
      var8.addNode(var4);
      var9.addNode(var5);
      var0.addNode(var6);
      HashMap var10 = new HashMap();
      Iterator var11 = var1.iterator();

      while(var11.hasNext()) {
         SuperViewEdge var12 = (SuperViewEdge)var11.next();
         SuperViewNode var13 = (SuperViewNode)var12.getSource();
         RawCombinedBasicBlock var14 = (RawCombinedBasicBlock)var13.getCombinedNode();
         RawBasicBlock var15 = var14.getRawNode(ESide.PRIMARY);
         RawBasicBlock var16 = var14.getRawNode(ESide.SECONDARY);
         SuperViewNode var17 = (SuperViewNode)var12.getTarget();
         RawCombinedBasicBlock var18 = (RawCombinedBasicBlock)var17.getCombinedNode();
         RawBasicBlock var19 = var18.getRawNode(ESide.PRIMARY);
         RawBasicBlock var20 = var18.getRawNode(ESide.SECONDARY);
         if(var17 == var2 || var17 == var3) {
            var17 = var7;
            var18 = var6;
            var19 = var4;
            var20 = var5;
         }

         if(var13 == var2 || var13 == var3) {
            var13 = var7;
            var14 = var6;
            var15 = var4;
            var16 = var5;
         }

         BasicBlockMatchAdder$InternalStruct var21 = null;
         Object var22 = (List)var10.get(var13);
         if(var22 != null) {
            Iterator var23 = ((List)var22).iterator();

            while(var23.hasNext()) {
               BasicBlockMatchAdder$InternalStruct var24 = (BasicBlockMatchAdder$InternalStruct)var23.next();
               if(var24.superTarget == var17) {
                  var21 = var24;
                  break;
               }
            }
         }

         if(var21 == null) {
            var21 = new BasicBlockMatchAdder$InternalStruct((BasicBlockMatchAdder$1)null);
            var21.superTarget = var17;
            var21.combinedSource = var14;
            var21.combinedTarget = var18;
            var21.priSource = var15;
            var21.priTarget = var19;
            var21.secSource = var16;
            var21.secTarget = var20;
            if(var22 == null) {
               var22 = new ArrayList();
               var10.put(var13, var22);
            }

            ((List)var22).add(var21);
         } else if(var15 != null && var19 != null) {
            var21.priSource = var15;
            var21.priTarget = var19;
         } else {
            var21.secSource = var16;
            var21.secTarget = var20;
         }

         if(var12.getSingleEdge(ESide.PRIMARY) != null) {
            var21.priJumpType = ((RawJump)var12.getSingleEdge(ESide.PRIMARY)).getJumpType();
         }

         if(var12.getSingleEdge(ESide.SECONDARY) != null) {
            var21.secJumpType = ((RawJump)var12.getSingleEdge(ESide.SECONDARY)).getJumpType();
         }
      }

      var11 = var10.entrySet().iterator();

      while(var11.hasNext()) {
         Entry var25 = (Entry)var11.next();
         Iterator var26 = ((List)var25.getValue()).iterator();

         while(var26.hasNext()) {
            BasicBlockMatchAdder$InternalStruct var27 = (BasicBlockMatchAdder$InternalStruct)var26.next();
            RawJump var28 = null;
            if(var27.priJumpType != null) {
               var28 = new RawJump(var27.priSource, var27.priTarget, var27.priJumpType);
               var8.addEdge(var28);
            }

            RawJump var29 = null;
            if(var27.secJumpType != null) {
               var29 = new RawJump(var27.secSource, var27.secTarget, var27.secJumpType);
               var9.addEdge(var29);
            }

            RawCombinedJump var30 = new RawCombinedJump(var27.combinedSource, var27.combinedTarget, var28, var29);
            var0.addEdge(var30);
            new SuperViewEdge(var30, (SuperViewNode)var25.getKey(), var27.superTarget);
         }
      }

   }

   public static void addBasicblockMatch(GraphsContainer var0, CombinedDiffNode var1, CombinedDiffNode var2) {
      var0.getCombinedGraph().getIntermediateListeners().blockZyLibVisibilityListeners();
      var0.getCombinedGraph().getIntermediateListeners().blockZyLibSelectionListeners();

      try {
         SuperDiffNode var3 = var1.getSuperDiffNode();
         SuperDiffNode var4 = var2.getSuperDiffNode();
         SingleDiffNode var5 = var1.getPrimaryDiffNode();
         SingleDiffNode var6 = var2.getSecondaryDiffNode();
         RawCombinedBasicBlock var7 = (RawCombinedBasicBlock)var1.getRawNode();
         RawCombinedBasicBlock var8 = (RawCombinedBasicBlock)var2.getRawNode();
         RawBasicBlock var9 = (RawBasicBlock)var5.getRawNode();
         RawBasicBlock var10 = (RawBasicBlock)var6.getRawNode();
         SuperViewNode var11 = var3.getRawNode();
         SuperViewNode var12 = var4.getRawNode();
         RawCombinedFlowGraph var13 = getRawCombinedFlowgraph(var0, var1, var2);
         RawFlowGraph var14 = var13.getPrimaryFlowgraph();
         RawFlowGraph var15 = var13.getSecondaryFlowgraph();
         BasicBlockMatchRemover.syncBasicblockVisibility(var0, var1);
         BasicBlockMatchRemover.syncBasicblockVisibility(var0, var2);
         HashSet var16 = new HashSet();
         var16.addAll(var11.getIncomingEdges());
         var16.addAll(var11.getOutgoingEdges());
         var16.addAll(var12.getIncomingEdges());
         var16.addAll(var12.getOutgoingEdges());
         var13.removeNode(var7);
         var13.removeNode(var8);
         var11.removeNode();
         var12.removeNode();
         var14.removeNode(var9);
         var15.removeNode(var10);
         var0.getCombinedGraph().deleteNode(var1);
         var0.getCombinedGraph().deleteNode(var2);
         var0.getSuperGraph().deleteNode(var3);
         var0.getSuperGraph().deleteNode(var4);
         var0.getPrimaryGraph().deleteNode(var5);
         var0.getSecondaryGraph().deleteNode(var6);
         BasicBlockMatchData var17 = createBasicblockMatchData(var7, var8);
         RawBasicBlock var18 = var9.clone(EMatchState.MATCHED);
         RawBasicBlock var19 = var10.clone(EMatchState.MATCHED);
         RawCombinedBasicBlock var20 = new RawCombinedBasicBlock(var18, var19, var17, var18.getFunctionAddr(), var19.getFunctionAddr());
         SuperViewNode var21 = new SuperViewNode(var20);
         insertNewRawNodesAndEdges(var13, var16, var11, var12, var18, var19, var20, var21);
         FunctionMatchData var22 = var0.getDiff().getMatches().getFunctionMatch(var20.getPrimaryFunctionAddress(), ESide.PRIMARY);
         var22.addBasicblockMatch(var0.getDiff(), var17, var20);
         insertNewDiffNodesAndEdges(var0, var13, var21);
         var0.getDiff().getMatches().notifyBasicblockMatchAddedListener(var18.getFunctionAddr(), var19.getFunctionAddr(), var18.getAddress(), var19.getAddress());
      } finally {
         var0.getCombinedGraph().getIntermediateListeners().freeZyLibVisibilityListeners();
         var0.getCombinedGraph().getIntermediateListeners().freeZyLibSelectionListeners();
      }

      BasicBlockMatchRemover.doSynchronizedLayout(var0.getCombinedGraph());
   }

   public static Pair getAffectedCombinedNodes(BinDiffGraph var0) {
      CombinedDiffNode var1 = null;
      CombinedDiffNode var2 = null;
      int var3 = 0;
      if(var0 instanceof CombinedGraph) {
         Iterator var4 = ((CombinedGraph)var0).getSelectedNodes().iterator();

         while(var4.hasNext()) {
            CombinedDiffNode var5 = (CombinedDiffNode)var4.next();
            if(var5.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
               ++var3;
               var1 = var5;
            } else if(var5.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
               ++var3;
               var2 = var5;
            }
         }

         if(var3 == 2 && var1 != null && var2 != null && var1.isVisible() && var2.isVisible()) {
            return new Pair(var1, var2);
         }
      } else if(var0 instanceof SingleGraph) {
         SingleGraph var8 = var0.getPrimaryGraph();
         SingleGraph var9 = var0.getSecondaryGraph();
         Iterator var6 = var8.getSelectedNodes().iterator();

         SingleDiffNode var7;
         while(var6.hasNext()) {
            var7 = (SingleDiffNode)var6.next();
            if(var7.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
               ++var3;
               var1 = var7.getCombinedDiffNode();
            }
         }

         if(var3 == 1) {
            var6 = var9.getSelectedNodes().iterator();

            while(var6.hasNext()) {
               var7 = (SingleDiffNode)var6.next();
               if(var7.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
                  ++var3;
                  var2 = var7.getCombinedDiffNode();
               }
            }
         }
      }

      return var3 == 2 && var1 != null && var2 != null && var1.getPrimaryDiffNode().isVisible() && var2.getSecondaryDiffNode().isVisible()?new Pair(var1, var2):null;
   }

   public static Pair getAffectedCombinedNodes(BinDiffGraph var0, ZyGraphNode var1) {
      CombinedDiffNode var2 = null;
      CombinedDiffNode var3 = null;
      int var4 = 0;
      int var5 = 0;
      Iterator var7;
      if(var1 instanceof CombinedDiffNode) {
         CombinedDiffNode var6 = (CombinedDiffNode)var1;
         CombinedDiffNode var8;
         if(var6.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
            var2 = var6;
            var7 = var0.getCombinedGraph().getSelectedNodes().iterator();

            while(var7.hasNext()) {
               var8 = (CombinedDiffNode)var7.next();
               if(var8 == var2) {
                  ++var4;
               } else if(var8.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
                  ++var5;
                  var3 = var8;
               }
            }
         } else if(var6.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
            var3 = var6;
            var7 = var0.getCombinedGraph().getSelectedNodes().iterator();

            while(var7.hasNext()) {
               var8 = (CombinedDiffNode)var7.next();
               if(var8.isVisible()) {
                  if(var8 == var3) {
                     ++var5;
                  } else if(var8.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
                     ++var4;
                     var2 = var8;
                  }
               }
            }
         }
      } else if(var1 instanceof SingleDiffNode) {
         SingleDiffNode var9 = (SingleDiffNode)var1;
         if(var9.isSelected() && var9.isVisible()) {
            SingleDiffNode var10;
            if(var9.getSide() == ESide.PRIMARY) {
               var2 = var9.getCombinedDiffNode();
               var4 = 1;
               var7 = var0.getSecondaryGraph().getSelectedNodes().iterator();

               while(var7.hasNext()) {
                  var10 = (SingleDiffNode)var7.next();
                  if(var10.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED && var10.isVisible()) {
                     ++var5;
                     var3 = var10.getCombinedDiffNode();
                  }
               }
            } else {
               var3 = var9.getCombinedDiffNode();
               var5 = 1;
               var7 = var0.getPrimaryGraph().getSelectedNodes().iterator();

               while(var7.hasNext()) {
                  var10 = (SingleDiffNode)var7.next();
                  if(var10.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED && var10.isVisible()) {
                     ++var4;
                     var2 = var10.getCombinedDiffNode();
                  }
               }
            }
         }
      }

      return var4 == 1 && var5 == 1 && var2 != null && var3 != null?new Pair(var2, var3):null;
   }
}
