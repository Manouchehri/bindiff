package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.ColorsConfigItem;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.FunctionNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.resources.Fonts;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.dr;

public class ViewCallGraphBuilder {
   private static void buildCallgraphEdgeMaps(bu var0, bu var1, bu var2, bu var3, Map var4, Map var5, Map var6, Map var7, Map var8, Map var9, Map var10, Map var11, GraphSettings var12, RawCombinedCallGraph var13) {
      RawCombinedCall var15;
      for(Iterator var14 = var13.getEdges().iterator(); var14.hasNext(); colorizeCalls(var15)) {
         var15 = (RawCombinedCall)var14.next();
         RawCombinedFunction var16 = var15.getSource();
         RawCombinedFunction var17 = var15.getTarget();
         SingleDiffEdge var18 = null;
         d var19 = null;
         RawFunction var20 = var16.getRawNode(ESide.PRIMARY);
         RawFunction var21 = var17.getRawNode(ESide.PRIMARY);
         IAddress var22 = var15.getSource().getAddress(ESide.PRIMARY);
         IAddress var23 = var15.getTarget().getAddress(ESide.PRIMARY);
         RawCall var24 = var15.getPrimaryEdge();
         SingleEdgeRealizer var25 = null;
         SingleDiffNode var27;
         if(var20 != null && var21 != null && var24 != null) {
            ZyLabelContent var26 = new ZyLabelContent((IZyEditableObject)null);
            var25 = new SingleEdgeRealizer(var26, (IEdgeRealizerUpdater)null, var12);
            var27 = (SingleDiffNode)var8.get(var22);
            SingleDiffNode var28 = (SingleDiffNode)var8.get(var23);
            var19 = var0.a(var27.getNode(), var28.getNode());
            var18 = new SingleDiffEdge(var27, var28, var19, var25, var24, ESide.PRIMARY);
            SingleDiffNode.link(var27, var28);
            var25.setUserData(new ZyEdgeData(var18));
            var25.setLineType(dr.b);
            var4.put(var19, var18);
         }

         SingleDiffEdge var53 = null;
         var27 = null;
         RawFunction var55 = var16.getRawNode(ESide.SECONDARY);
         RawFunction var29 = var17.getRawNode(ESide.SECONDARY);
         RawCall var30 = var15.getSecondaryEdge();
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
            var33.setLineType(dr.b);
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
         SuperDiffEdge var56 = new SuperDiffEdge(var38, var39, var57, var37, var44, var18, var53);
         SuperDiffNode.link(var38, var39);
         var6.put(var57, var56);
         CombinedDiffEdge var45 = null;
         d var46 = null;
         ZyLabelContent var47 = new ZyLabelContent((IZyEditableObject)null);
         CombinedEdgeRealizer var48 = new CombinedEdgeRealizer(var47, (IEdgeRealizerUpdater)null, var12);
         var48.setLineType(dr.b);
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
         if(var18 != null) {
            var18.setCombinedDiffEdge(var45);
         }

         if(var53 != null) {
            var53.setCombinedDiffEdge(var45);
         }
      }

   }

   private static void buildCallgraphNodeMaps(bu var0, bu var1, bu var2, bu var3, Map var4, Map var5, Map var6, Map var7, Map var8, Map var9, Map var10, Map var11, RawCombinedCallGraph var12) {
      RawCombinedFunction var14;
      for(Iterator var13 = var12.getNodes().iterator(); var13.hasNext(); colorizeFunctions(var14)) {
         var14 = (RawCombinedFunction)var13.next();
         SingleDiffNode var15 = null;
         SingleDiffNode var16 = null;
         SuperDiffNode var17 = null;
         CombinedDiffNode var18 = null;
         q var19 = null;
         q var20 = null;
         q var21 = null;
         q var22 = null;
         RawFunction var23 = var14.getRawNode(ESide.PRIMARY);
         RawFunction var24 = var14.getRawNode(ESide.SECONDARY);
         IAddress var25 = var14.getAddress(ESide.PRIMARY);
         IAddress var26 = var14.getAddress(ESide.SECONDARY);
         ZyLabelContent var27 = null;
         if(var23 != null) {
            var27 = buildNormalCallgraphLabelContent(var23);
            ZyNormalNodeRealizer var28 = new ZyNormalNodeRealizer(var27);
            FunctionNodeRealizerUpdater var29 = new FunctionNodeRealizerUpdater();
            var28.setUpdater(var29);
            var29.setRealizer(var28);
            var19 = var0.d();
            var15 = new SingleDiffNode(var19, var28, var23, ESide.PRIMARY);
            var8.put(var25, var15);
            var28.setUserData(new ZyNodeData(var15));
            var4.put(var19, var15);
         }

         ZyLabelContent var33 = null;
         if(var24 != null) {
            var33 = buildNormalCallgraphLabelContent(var24);
            ZyNormalNodeRealizer var34 = new ZyNormalNodeRealizer(var33);
            FunctionNodeRealizerUpdater var30 = new FunctionNodeRealizerUpdater();
            var34.setUpdater(var30);
            var30.setRealizer(var34);
            var20 = var1.d();
            var16 = new SingleDiffNode(var20, var34, var24, ESide.SECONDARY);
            var34.setUserData(new ZyNodeData(var16));
            var9.put(var26, var16);
            var5.put(var20, var16);
         }

         ZyLabelContent var35 = new ZyLabelContent((IZyEditableObject)null);
         ZyNormalNodeRealizer var36 = new ZyNormalNodeRealizer(var35);
         var21 = var2.d();
         SuperViewNode var31 = new SuperViewNode(var14);
         var17 = new SuperDiffNode(var21, var36, var31, var15, var16);
         var10.put(new Pair(var25, var26), var17);
         var36.setUserData(new ZyNodeData(var17));
         var6.put(var21, var17);
         CombinedNodeRealizer var32 = new CombinedNodeRealizer(var27, var33);
         var22 = var3.d();
         var18 = new CombinedDiffNode(var22, var32, var14, var17);
         var32.setUserData(new ZyNodeData(var18));
         var11.put(new Pair(var25, var26), var18);
         var7.put(var22, var18);
         var17.setCombinedDiffNode(var18);
         if(var15 != null) {
            var15.setCombinedDiffNode(var18);
         }

         if(var16 != null) {
            var16.setCombinedDiffNode(var18);
         }
      }

   }

   private static ZyLabelContent buildNormalCallgraphLabelContent(SingleViewNode var0) {
      RawFunction var1 = (RawFunction)var0;
      ZyLabelContent var2 = new ZyLabelContent((IZyEditableObject)null);
      if(var1 != null) {
         BinDiffConfigFile var3 = BinDiffConfigFile.getInstance();
         ColorsConfigItem var4 = var3.getColorSettings();
         Color var5 = var4.getAddressColor();
         Color var6 = var4.getMnemonicColor();
         String var7 = var1.getAddress().toHexString();
         String var8 = var1.getName();
         ArrayList var9 = new ArrayList();
         var9.add(new CStyleRunData(0, var7.length(), var5));
         var9.add(new CStyleRunData(var7.length() + 1, var8.length(), var6));
         String var10 = String.format("%s %s", new Object[]{var7, var8});
         ZyLineContent var11 = new ZyLineContent(var10, Fonts.NORMAL_FONT, var9, (IZyEditableObject)null);
         var2.addLineContent(var11);
      }

      return var2;
   }

   private static Color getFunctionBorderColor(RawFunction var0, RawFunction var1) {
      Color[] var2 = new Color[]{Color.BLACK, Colors.FUNCTION_TYPE_LIBRARY.darker(), Colors.FUNCTION_TYPE_THUNK.darker(), Colors.FUNCTION_TYPE_IMPORTED.darker(), Colors.FUNCTION_TYPE_UNKNOWN, Colors.MIXED_BASE_COLOR};
      if(var0 != null && var1 != null) {
         EFunctionType var3 = var0.getFunctionType();
         if(var3 != var1.getFunctionType()) {
            return var2[5];
         }
      }

      return var0 != null?var2[EFunctionType.getOrdinal(var0.getFunctionType())]:var2[EFunctionType.getOrdinal(var1.getFunctionType())];
   }

   public static GraphsContainer buildDiffCallgraphs(Diff var0, RawCombinedCallGraph var1) {
      GraphSettings var2 = new GraphSettings(BinDiffConfigFile.getInstance().getInitialCallgraphSettings());
      ZyGraph2DView var3 = new ZyGraph2DView();
      ZyGraph2DView var4 = new ZyGraph2DView();
      ZyGraph2DView var5 = new ZyGraph2DView();
      ZyGraph2DView var6 = new ZyGraph2DView();
      bu var7 = new bu();
      bu var8 = new bu();
      bu var9 = new bu();
      bu var10 = new bu();
      var3.setGraph2D(var7);
      var4.setGraph2D(var8);
      var6.setGraph2D(var10);
      var5.setGraph2D(var9);
      LinkedHashMap var11 = new LinkedHashMap();
      LinkedHashMap var12 = new LinkedHashMap();
      LinkedHashMap var13 = new LinkedHashMap();
      LinkedHashMap var14 = new LinkedHashMap();
      LinkedHashMap var15 = new LinkedHashMap();
      LinkedHashMap var16 = new LinkedHashMap();
      LinkedHashMap var17 = new LinkedHashMap();
      LinkedHashMap var18 = new LinkedHashMap();
      HashMap var19 = new HashMap();
      HashMap var20 = new HashMap();
      HashMap var21 = new HashMap();
      HashMap var22 = new HashMap();
      buildCallgraphNodeMaps(var7, var8, var10, var9, var11, var12, var13, var14, var19, var20, var22, var21, var1);
      buildCallgraphEdgeMaps(var7, var8, var10, var9, var15, var16, var17, var18, var19, var20, var22, var21, var2, var1);
      CombinedGraph var23 = new CombinedGraph(var5, var14, var18, var2, EGraphType.CALLGRAPH);
      SingleGraph var24 = new SingleGraph(var3, (IAddress)null, var11, var15, var2, ESide.PRIMARY, EGraphType.CALLGRAPH);
      SingleGraph var25 = new SingleGraph(var4, (IAddress)null, var12, var16, var2, ESide.SECONDARY, EGraphType.CALLGRAPH);
      SuperGraph var26 = new SuperGraph(var6, var13, var17, var24, var25, var2, EGraphType.CALLGRAPH);
      GraphsContainer var27 = new GraphsContainer(var0, var26, var23, var24, var25);
      var26.refreshAllSuperNodesSizes(var24, var25);
      return var27;
   }

   public static void colorizeCalls(RawCombinedCall var0) {
      EMatchState var1 = var0.getMatchState();
      if(var1 == EMatchState.PRIMARY_UNMATCHED) {
         var0.setColor(var0.isChanged()?Colors.MIXED_BASE_COLOR:Colors.CALL_PRIMARY_UNMATCHED);
         var0.getPrimaryEdge().setColor(Color.BLACK);
         var0.getPrimaryEdge().setColor(var0.isChanged()?Colors.MIXED_BASE_COLOR:Colors.CALL_PRIMARY_UNMATCHED);
      } else if(var1 == EMatchState.SECONDRAY_UNMATCHED) {
         var0.setColor(var0.isChanged()?Colors.MIXED_BASE_COLOR:Colors.CALL_SECONDRAY_UNMATCHED);
         var0.getSecondaryEdge().setColor(Color.BLACK);
         var0.getSecondaryEdge().setColor(var0.isChanged()?Colors.MIXED_BASE_COLOR:Colors.CALL_SECONDRAY_UNMATCHED);
      } else {
         var0.setColor(Colors.CALL_MATCHED);
         var0.getPrimaryEdge().setColor(Color.BLACK);
         var0.getSecondaryEdge().setColor(Color.BLACK);
         var0.getPrimaryEdge().setColor(Colors.CALL_MATCHED);
         var0.getSecondaryEdge().setColor(Colors.CALL_MATCHED);
      }

   }

   public static void colorizeFunctions(RawCombinedFunction var0) {
      RawFunction var1 = var0.getRawNode(ESide.PRIMARY);
      RawFunction var2 = var0.getRawNode(ESide.SECONDARY);
      Color var3 = getFunctionBorderColor(var1, var2);
      var0.setBorderColor(var3);
      EMatchState var4 = var0.getMatchState();
      if(var4 == EMatchState.PRIMARY_UNMATCHED) {
         var0.setColor(Colors.PRIMARY_BASE);
         var1.setColor(Colors.PRIMARY_BASE);
         var1.setBorderColor(var3);
      } else if(var4 == EMatchState.SECONDRAY_UNMATCHED) {
         var0.setColor(Colors.SECONDARY_BASE);
         var2.setColor(Colors.SECONDARY_BASE);
         var2.setBorderColor(var3);
      } else {
         Color var5 = Colors.MATCHED_BASE;
         if(var0.isChanged()) {
            if(MatchesGetter.isStructuralChangedFunctionPair(var1, var2)) {
               var5 = Colors.CHANGED_BASE;
            } else {
               var5 = Colors.INSTRUCTIONS_ONLY_CHANGED_COLOR;
            }
         }

         var0.setColor(var5);
         var1.setColor(var5);
         var2.setColor(var5);
         var1.setBorderColor(var3);
         var2.setBorderColor(var3);
      }

   }
}
