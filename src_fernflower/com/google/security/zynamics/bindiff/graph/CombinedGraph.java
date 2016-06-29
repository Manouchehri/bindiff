package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph$1;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.editmode.CombinedGraphEditMode;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUnhideNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.realizers.CodeNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.bindiff.graph.searchers.CombinedGraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import y.c.d;
import y.c.q;

public final class CombinedGraph extends BinDiffGraph {
   private SelectionHistory selectionHistory = new SelectionHistory(this, 30);
   private GraphSearcher graphSearcher = new CombinedGraphSearcher();

   public CombinedGraph(ZyGraph2DView var1, LinkedHashMap var2, LinkedHashMap var3, GraphSettings var4, EGraphType var5) {
      super(var1, var2, var3, var4, var5);
   }

   public static CombinedDiffEdge buildDiffEdge(CombinedGraph var0, SuperViewEdge var1, SuperDiffEdge var2) {
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

   public static CombinedDiffNode buildDiffNode(CombinedGraph var0, SingleDiffNode var1, SingleDiffNode var2, SuperDiffNode var3, RawCombinedBasicBlock var4) {
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

   protected CombinedGraphEditMode createEditMode() {
      return new CombinedGraphEditMode(this);
   }

   public void dispose() {
      this.selectionHistory.dispose();
      super.dispose();
      this.graphSearcher.clearResults();
      this.selectionHistory = null;
      this.graphSearcher = null;
   }

   public GraphSearcher getGraphSearcher() {
      return this.graphSearcher;
   }

   public Set getSelectedNodes() {
      return new HashSet(CollectionHelpers.filter(this.getNodes(), new CombinedGraph$1(this)));
   }

   public SelectionHistory getSelectionHistory() {
      return this.selectionHistory;
   }
}
