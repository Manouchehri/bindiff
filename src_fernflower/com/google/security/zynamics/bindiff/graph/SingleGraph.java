package com.google.security.zynamics.bindiff.graph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph$1;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.editmode.SingleGraphEditMode;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUnhideNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffBasicBlockNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.realizers.CodeNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import y.c.d;
import y.c.q;
import y.h.bu;

public class SingleGraph extends BinDiffGraph {
   private SelectionHistory selectionHistory = new SelectionHistory(this, 30);
   private GraphSearcher graphSearcher = new GraphSearcher();
   private final IAddress functionAddress;
   private final ESide side;

   public SingleGraph(ZyGraph2DView var1, IAddress var2, LinkedHashMap var3, LinkedHashMap var4, GraphSettings var5, ESide var6, EGraphType var7) {
      super(var1, var3, var4, var5, var7);
      Preconditions.checkNotNull(var6);
      this.functionAddress = var2;
      this.side = var6;
   }

   public static SingleDiffEdge buildDiffEdge(SingleGraph var0, SuperViewEdge var1) {
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

   public static SingleDiffNode buildDiffNode(SingleGraph var0, FunctionMatchData var1, RawCombinedFlowGraph var2, RawCombinedBasicBlock var3) {
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

   protected ZyEditMode createEditMode() {
      return new SingleGraphEditMode(this);
   }

   public void dispose() {
      this.selectionHistory.dispose();
      super.dispose();
      this.graphSearcher.clearResults();
      this.selectionHistory = null;
      this.graphSearcher = null;
   }

   public IAddress getFunctionAddress() {
      return this.functionAddress;
   }

   public GraphSearcher getGraphSearcher() {
      return this.graphSearcher;
   }

   public SingleGraph getOtherSideGraph() {
      return this.side == ESide.PRIMARY?this.getSecondaryGraph():this.getPrimaryGraph();
   }

   public Set getSelectedNodes() {
      return new HashSet(CollectionHelpers.filter(super.getMappings().getNodes(), new SingleGraph$1(this)));
   }

   public SelectionHistory getSelectionHistory() {
      return this.selectionHistory;
   }

   public ESide getSide() {
      return this.side;
   }
}
