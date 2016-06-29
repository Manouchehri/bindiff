package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewCodeNodeBuilder;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder$1;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.labelcontent.DiffLabelContent;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.BasicBlockContentEditor;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffBasicBlockNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.realizers.CodeNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.dr;

public class ViewFlowGraphBuilder {
   protected static void addGraphEditors(FunctionMatchData var0, GraphsContainer var1) {
      SingleGraph var2 = var1.getPrimaryGraph();
      if(var2 != null) {
         Iterator var3 = var2.getNodes().iterator();

         while(var3.hasNext()) {
            SingleDiffNode var4 = (SingleDiffNode)var3.next();
            BasicBlockContentEditor var5 = new BasicBlockContentEditor(var0, var1, ESide.PRIMARY);
            var4.getRealizer().getNodeContent().setLineEditor(var5);
         }
      }

      SingleGraph var7 = var1.getSecondaryGraph();
      if(var7 != null) {
         Iterator var8 = var7.getNodes().iterator();

         while(var8.hasNext()) {
            SingleDiffNode var9 = (SingleDiffNode)var8.next();
            BasicBlockContentEditor var6 = new BasicBlockContentEditor(var0, var1, ESide.SECONDARY);
            var9.getRealizer().getNodeContent().setLineEditor(var6);
         }
      }

   }

   protected static void buildFlowgraphEdgeMaps(bu var0, bu var1, bu var2, bu var3, Map var4, Map var5, Map var6, Map var7, Map var8, Map var9, Map var10, Map var11, GraphSettings var12, RawCombinedFlowGraph var13) {
      Iterator var14 = var13.getEdges().iterator();

      while(var14.hasNext()) {
         RawCombinedJump var15 = (RawCombinedJump)var14.next();
         RawCombinedBasicBlock var16 = var15.getSource();
         RawCombinedBasicBlock var17 = var15.getTarget();
         RawBasicBlock var18 = var16.getRawNode(ESide.PRIMARY);
         RawBasicBlock var19 = var17.getRawNode(ESide.PRIMARY);
         SingleDiffEdge var20 = null;
         d var21 = null;
         IAddress var22 = var15.getSource().getAddress(ESide.PRIMARY);
         IAddress var23 = var15.getTarget().getAddress(ESide.PRIMARY);
         RawJump var24 = var15.getPrimaryEdge();
         SingleEdgeRealizer var25 = null;
         SingleDiffNode var27;
         if(var18 != null && var19 != null && var24 != null) {
            ZyLabelContent var26 = new ZyLabelContent((IZyEditableObject)null);
            var25 = new SingleEdgeRealizer(var26, (IEdgeRealizerUpdater)null, var12);
            var27 = (SingleDiffNode)var8.get(var22);
            SingleDiffNode var28 = (SingleDiffNode)var8.get(var23);
            var21 = var0.a(var27.getNode(), var28.getNode());
            var20 = new SingleDiffEdge(var27, var28, var21, var25, var24, ESide.PRIMARY);
            SingleDiffNode.link(var27, var28);
            var25.setUserData(new ZyEdgeData(var20));
            var4.put(var21, var20);
         }

         SingleDiffEdge var53 = null;
         var27 = null;
         RawBasicBlock var55 = var16.getRawNode(ESide.SECONDARY);
         RawBasicBlock var29 = var17.getRawNode(ESide.SECONDARY);
         RawJump var30 = var15.getSecondaryEdge();
         IAddress var31 = var15.getSource().getAddress(ESide.SECONDARY);
         IAddress var32 = var15.getTarget().getAddress(ESide.SECONDARY);
         SingleEdgeRealizer var33 = null;
         ZyLabelContent var34;
         SingleDiffNode var35;
         if(var55 != null && var29 != null && var30 != null) {
            var34 = new ZyLabelContent((IZyEditableObject)null);
            var33 = new SingleEdgeRealizer(var34, (IEdgeRealizerUpdater)null, var12);
            var35 = (SingleDiffNode)var9.get(var31);
            SingleDiffNode var36 = (SingleDiffNode)var9.get(var32);
            d var54 = var1.a(var35.getNode(), var36.getNode());
            var53 = new SingleDiffEdge(var35, var36, var54, var33, var30, ESide.SECONDARY);
            SingleDiffNode.link(var35, var36);
            var33.setUserData(new ZyEdgeData(var53));
            var5.put(var54, var53);
         }

         var34 = null;
         var35 = null;
         ZyLabelContent var58 = new ZyLabelContent((IZyEditableObject)null);
         ZyEdgeRealizer var37 = new ZyEdgeRealizer(var58, (IEdgeRealizerUpdater)null);
         SuperDiffNode var38 = (SuperDiffNode)var10.get(new Pair(var22, var31));
         SuperDiffNode var39 = (SuperDiffNode)var10.get(new Pair(var23, var32));
         q var40 = var38.getNode();
         q var41 = var39.getNode();
         d var57 = var2.a(var40, var41);
         SuperViewNode var42 = var38.getRawNode();
         SuperViewNode var43 = var39.getRawNode();
         SuperViewEdge var44 = new SuperViewEdge(var15, var42, var43);
         SuperDiffEdge var56 = new SuperDiffEdge(var38, var39, var57, var37, var44, var20, var53);
         SuperDiffNode.link(var38, var39);
         var37.setUserData(new ZyEdgeData(var56));
         var6.put(var57, var56);
         CombinedDiffEdge var45 = null;
         d var46 = null;
         ZyLabelContent var47 = new ZyLabelContent((IZyEditableObject)null);
         CombinedEdgeRealizer var48 = new CombinedEdgeRealizer(var47, (IEdgeRealizerUpdater)null, var12);
         CombinedDiffNode var49 = (CombinedDiffNode)var11.get(new Pair(var22, var31));
         CombinedDiffNode var50 = (CombinedDiffNode)var11.get(new Pair(var23, var32));
         q var51 = var49.getNode();
         q var52 = var50.getNode();
         var46 = var3.a(var51, var52);
         var45 = new CombinedDiffEdge(var49, var50, var46, var48, var15, var56);
         CombinedDiffNode.link(var49, var50);
         var7.put(var46, var45);
         var48.setUserData(new ZyEdgeData(var45));
         var56.setCombinedDiffEdge(var45);
         if(var20 != null) {
            var20.setCombinedDiffEdge(var45);
         }

         if(var53 != null) {
            var53.setCombinedDiffEdge(var45);
         }

         colorizeJumps(var15, var25, var33);
         stylizeJumps(var15, var48, var25, var33);
      }

   }

   protected static void buildFlowgraphNodeMaps(FunctionMatchData var0, bu var1, bu var2, bu var3, bu var4, Map var5, Map var6, Map var7, Map var8, Map var9, Map var10, Map var11, Map var12, RawCombinedFlowGraph var13) {
      RawCombinedBasicBlock var15;
      for(Iterator var14 = var13.iterator(); var14.hasNext(); colorizeBasicblocks(var0, var15)) {
         var15 = (RawCombinedBasicBlock)var14.next();
         SingleDiffBasicBlockNode var16 = null;
         SingleDiffBasicBlockNode var17 = null;
         SuperDiffNode var18 = null;
         CombinedDiffNode var19 = null;
         q var20 = null;
         q var21 = null;
         q var22 = null;
         q var23 = null;
         IAddress var24 = var15.getAddress(ESide.SECONDARY);
         IAddress var25 = var15.getAddress(ESide.PRIMARY);
         RawBasicBlock var26 = var15.getRawNode(ESide.PRIMARY);
         RawBasicBlock var27 = var15.getRawNode(ESide.SECONDARY);
         ZyLabelContent var28 = null;
         if(var26 != null) {
            var28 = buildSingleBasicblockLabelContent(var0, var13, var15, ESide.PRIMARY);
            ZyNormalNodeRealizer var29 = new ZyNormalNodeRealizer(var28);
            CodeNodeRealizerUpdater var30 = new CodeNodeRealizerUpdater();
            var29.setUpdater(var30);
            var30.setRealizer(var29);
            var20 = var1.d();
            var16 = new SingleDiffBasicBlockNode(var20, var29, var26, ESide.PRIMARY);
            var29.setUserData(new ZyNodeData(var16));
            var9.put(var25, var16);
            var5.put(var20, var16);
         }

         ZyLabelContent var35 = null;
         if(var27 != null) {
            var35 = buildSingleBasicblockLabelContent(var0, var13, var15, ESide.SECONDARY);
            ZyNormalNodeRealizer var36 = new ZyNormalNodeRealizer(var35);
            CodeNodeRealizerUpdater var31 = new CodeNodeRealizerUpdater();
            var36.setUpdater(var31);
            var31.setRealizer(var36);
            var21 = var2.d();
            var17 = new SingleDiffBasicBlockNode(var21, var36, var27, ESide.SECONDARY);
            var36.setUserData(new ZyNodeData(var17));
            var10.put(var24, var17);
            var6.put(var21, var17);
         }

         ZyLabelContent var37 = new ZyLabelContent((IZyEditableObject)null);
         ZyNormalNodeRealizer var38 = new ZyNormalNodeRealizer(var37);
         var22 = var3.d();
         SuperViewNode var32 = new SuperViewNode(var15);
         var18 = new SuperDiffNode(var22, var38, var32, var16, var17);
         var38.setUserData(new ZyNodeData(var18));
         var11.put(new Pair(var25, var24), var18);
         var7.put(var22, var18);
         CombinedNodeRealizer var33 = new CombinedNodeRealizer(var28, var35);
         CodeNodeRealizerUpdater var34 = new CodeNodeRealizerUpdater();
         var33.setUpdater(var34);
         var34.setRealizer(var33);
         var23 = var4.d();
         var19 = new CombinedDiffNode(var23, var33, var15, var18);
         var33.setUserData(new ZyNodeData(var19));
         var12.put(new Pair(var25, var24), var19);
         var8.put(var23, var19);
         var18.setCombinedDiffNode(var19);
         if(var16 != null) {
            var16.setCombinedDiffNode(var19);
         }

         if(var17 != null) {
            var17.setCombinedDiffNode(var19);
         }
      }

   }

   public static ZyLabelContent buildSingleBasicblockLabelContent(FunctionMatchData var0, RawCombinedFlowGraph var1, RawCombinedBasicBlock var2, ESide var3) {
      BasicBlockLineObject var4 = new BasicBlockLineObject(var2.getRawNode(var3));
      DiffLabelContent var5 = new DiffLabelContent(var4, true, false);
      ViewCodeNodeBuilder.buildSingleCodeNodeContent(var0, var1, var2, var5, var3);
      return var5;
   }

   public static GraphsContainer buildViewFlowgraphs(Diff var0, FunctionMatchData var1, RawCombinedFlowGraph var2) {
      GraphSettings var3 = new GraphSettings(BinDiffConfigFile.getInstance().getInitialFlowgraphSettings());
      ZyGraph2DView var4 = new ZyGraph2DView();
      ZyGraph2DView var5 = new ZyGraph2DView();
      ZyGraph2DView var6 = new ZyGraph2DView();
      ZyGraph2DView var7 = new ZyGraph2DView();
      bu var8 = new bu();
      bu var9 = new bu();
      bu var10 = new bu();
      bu var11 = new bu();
      var4.setGraph2D(var8);
      var5.setGraph2D(var9);
      var7.setGraph2D(var11);
      var6.setGraph2D(var10);
      LinkedHashMap var12 = new LinkedHashMap();
      LinkedHashMap var13 = new LinkedHashMap();
      LinkedHashMap var14 = new LinkedHashMap();
      LinkedHashMap var15 = new LinkedHashMap();
      LinkedHashMap var16 = new LinkedHashMap();
      LinkedHashMap var17 = new LinkedHashMap();
      LinkedHashMap var18 = new LinkedHashMap();
      LinkedHashMap var19 = new LinkedHashMap();
      HashMap var20 = new HashMap();
      HashMap var21 = new HashMap();
      HashMap var22 = new HashMap();
      HashMap var23 = new HashMap();
      buildFlowgraphNodeMaps(var1, var8, var9, var11, var10, var12, var13, var14, var15, var20, var21, var23, var22, var2);
      buildFlowgraphEdgeMaps(var8, var9, var11, var10, var16, var17, var18, var19, var20, var21, var23, var22, var3, var2);
      IAddress var24 = var2.getPrimaryAddress();
      IAddress var25 = var2.getSecondaryAddress();
      colorizeSingleNodeLineBorders(var12.values(), var24);
      colorizeSingleNodeLineBorders(var13.values(), var25);
      colorizeCombinedNodeLineBorders(var15.values(), var24, var25);
      CombinedGraph var26 = new CombinedGraph(var6, var15, var19, var3, EGraphType.FLOWGRAPH);
      SingleGraph var27 = new SingleGraph(var4, var24, var12, var16, var3, ESide.PRIMARY, EGraphType.FLOWGRAPH);
      SingleGraph var28 = new SingleGraph(var5, var25, var13, var17, var3, ESide.SECONDARY, EGraphType.FLOWGRAPH);
      SuperGraph var29 = new SuperGraph(var7, var14, var18, var27, var28, var3, EGraphType.FLOWGRAPH);
      GraphsContainer var30 = new GraphsContainer(var0, var29, var26, var27, var28);
      var29.refreshAllSuperNodesSizes(var27, var28);
      addGraphEditors(var1, var30);
      return var30;
   }

   public static void colorizeBasicblocks(FunctionMatchData var0, RawCombinedBasicBlock var1) {
      EMatchState var2 = var1.getMatchState();
      if(var2 == EMatchState.PRIMARY_UNMATCHED) {
         var1.setColor(Colors.PRIMARY_BASE);
         var1.getRawNode(ESide.PRIMARY).setColor(Colors.PRIMARY_BASE);
      } else if(var2 == EMatchState.SECONDRAY_UNMATCHED) {
         var1.setColor(Colors.SECONDARY_BASE);
         var1.getRawNode(ESide.SECONDARY).setColor(Colors.SECONDARY_BASE);
      } else {
         IAddress var3 = var1.getAddress(ESide.PRIMARY);
         BasicBlockMatchData var4 = var0.getBasicblockMatch(var3, ESide.PRIMARY);
         int var5 = var4.getSizeOfMatchedInstructions();
         Color var6 = Colors.MATCHED_BASE;
         if(var1.getRawNode(ESide.PRIMARY).getInstructions().size() > var5 || var1.getRawNode(ESide.SECONDARY).getInstructions().size() > var5) {
            var6 = Colors.CHANGED_BASE;
         }

         var1.setColor(var6);
         var1.setColor(var6);
         var1.getRawNode(ESide.PRIMARY).setColor(var6);
         var1.getRawNode(ESide.SECONDARY).setColor(var6);
      }

   }

   public static void colorizeCombinedNodeLineBorders(Collection var0, IAddress var1, IAddress var2) {
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         CombinedDiffNode var4 = (CombinedDiffNode)var3.next();
         if(var0.size() == 1) {
            var4.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
            break;
         }

         SingleViewNode var5 = var4.getPrimaryRawNode();
         SingleViewNode var6 = var4.getSecondaryRawNode();
         if(var4.getRawNode().getMatchState() != EMatchState.MATCHED) {
            if(var5 != null) {
               if(var5.getAddress().equals(var1)) {
                  var4.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
               }

               if(var5.getChildren().size() == 0) {
                  var4.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
               }
            } else if(var6 != null) {
               if(var6.getAddress().equals(var2)) {
                  var4.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
               }

               if(var6.getChildren().size() == 0) {
                  var4.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
               }
            }
         } else {
            if(var5.getAddress().equals(var1) && var6.getAddress().equals(var2)) {
               var4.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
            } else if(var5.getAddress().equals(var1) || var6.getAddress().equals(var2)) {
               var4.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
            }

            if(var5.getChildren().size() == 0 && var6.getChildren().size() == 0) {
               var4.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
            } else if(var5.getChildren().size() == 0 || var6.getChildren().size() == 0) {
               var4.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
            }
         }
      }

   }

   public static void colorizeJumps(RawCombinedJump var0, ZyEdgeRealizer var1, ZyEdgeRealizer var2) {
      RawJump var3 = var0.getPrimaryEdge();
      if(var3 != null) {
         switch(ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[var3.getJumpType().ordinal()]) {
         case 1:
            var1.setLineColor(Colors.JUMP_CONDITIONAL_TRUE);
            var0.setColor(Colors.JUMP_CONDITIONAL_TRUE);
            break;
         case 2:
            var1.setLineColor(Colors.JUMP_CONDITIONAL_FALSE);
            var0.setColor(Colors.JUMP_CONDITIONAL_FALSE);
            break;
         case 3:
            var1.setLineColor(Colors.JUMP_SWITCH);
            var0.setColor(Colors.JUMP_SWITCH);
            break;
         default:
            var1.setLineColor(Colors.JUMP_UNCONDITIONAL);
            var0.setColor(Colors.JUMP_UNCONDITIONAL);
         }
      }

      RawJump var4 = var0.getSecondaryEdge();
      if(var4 != null) {
         switch(ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[var4.getJumpType().ordinal()]) {
         case 1:
            var2.setLineColor(Colors.JUMP_CONDITIONAL_TRUE);
            var0.setColor(Colors.JUMP_CONDITIONAL_TRUE);
            break;
         case 2:
            var2.setLineColor(Colors.JUMP_CONDITIONAL_FALSE);
            var0.setColor(Colors.JUMP_CONDITIONAL_FALSE);
            break;
         case 3:
            var2.setLineColor(Colors.JUMP_SWITCH);
            var0.setColor(Colors.JUMP_SWITCH);
            break;
         default:
            var2.setLineColor(Colors.JUMP_UNCONDITIONAL);
            var0.setColor(Colors.JUMP_UNCONDITIONAL);
         }
      }

      if(var0.getMatchState() == EMatchState.MATCHED && var0.getPrimaryEdge().getJumpType() != var0.getSecondaryEdge().getJumpType()) {
         var1.setLineColor(Colors.MIXED_BASE_COLOR);
         var2.setLineColor(Colors.MIXED_BASE_COLOR);
         var0.setColor(Colors.MIXED_BASE_COLOR);
      }

   }

   public static void colorizeSingleNodeLineBorders(Collection var0, IAddress var1) {
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         SingleDiffNode var3 = (SingleDiffNode)var2.next();
         if(var0.size() == 1) {
            var3.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
            break;
         }

         if(var3.getRawNode().getAddress().equals(var1)) {
            var3.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
         } else if(var3.getRawNode().getChildren().size() == 0) {
            var3.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
         }
      }

   }

   public static void stylizeJumps(RawCombinedJump var0, ZyEdgeRealizer var1, ZyEdgeRealizer var2, ZyEdgeRealizer var3) {
      var1.setReversedPathRenderingEnabled(true);
      if(var0.getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
         var1.setLineType(dr.i);
      } else if(var0.getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
         var1.setLineType(dr.n);
      } else {
         var1.setLineType(dr.b);
      }

      if(var2 != null && var3 == null) {
         var2.setLineType(dr.i);
      } else if(var3 != null && var2 == null) {
         var3.setLineType(dr.i);
      } else {
         var2.setLineType(dr.b);
         var3.setLineType(dr.b);
      }

   }
}
