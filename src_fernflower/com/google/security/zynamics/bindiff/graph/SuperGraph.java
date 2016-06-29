package com.google.security.zynamics.bindiff.graph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph$1;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.SuperGraphSearcher;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import y.c.d;
import y.c.q;
import y.h.fj;

public class SuperGraph extends BinDiffGraph {
   private static int NODELABEL_PADDING = 10;
   private GraphSearcher graphSearcher = new SuperGraphSearcher();

   public SuperGraph(ZyGraph2DView var1, LinkedHashMap var2, LinkedHashMap var3, SingleGraph var4, SingleGraph var5, GraphSettings var6, EGraphType var7) {
      super(var1, var2, var3, var6, var7);
      Preconditions.checkArgument(var4 != null || var5 != null, "Primary graph and secondary graph cannot both be null");
   }

   public static SuperDiffEdge buildDiffEdge(SuperGraph var0, SuperViewEdge var1, SingleDiffEdge var2, SingleDiffEdge var3) {
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

   public static SuperDiffNode buildDiffNode(SuperGraph var0, SingleDiffNode var1, SingleDiffNode var2, SuperViewNode var3) {
      ZyLabelContent var4 = new ZyLabelContent((IZyEditableObject)null);
      ZyNormalNodeRealizer var5 = new ZyNormalNodeRealizer(var4);
      q var6 = var0.getGraph().d();
      SuperDiffNode var7 = new SuperDiffNode(var6, var5, var3, var1, var2);
      var5.setUserData(new ZyNodeData(var7));
      return var7;
   }

   private void synchronizeSize(SingleGraph var1, SingleGraph var2, SuperDiffNode var3) {
      if(var3.getRawNode().getCombinedNode().getMatchState() == EMatchState.MATCHED) {
         SingleDiffNode var4 = var3.getPrimaryDiffNode();
         ZyLabelContent var5 = var4.getRealizer().getNodeContent();
         SingleDiffNode var6 = var3.getSecondaryDiffNode();
         ZyLabelContent var7 = var6.getRealizer().getNodeContent();
         var5.setRightPadding(NODELABEL_PADDING);
         var7.setRightPadding(NODELABEL_PADDING);
         double var8 = var5.getBounds().getWidth();
         double var10 = var7.getBounds().getWidth();
         if(var8 > var10) {
            var7.setRightPadding((int)Math.round(var8 - var10) + NODELABEL_PADDING);
         } else {
            var5.setRightPadding((int)Math.round(var10 - var8) + NODELABEL_PADDING);
         }

         var6.getRealizer().regenerate();
         var4.getRealizer().regenerate();
         var1.updateViews();
         var2.updateViews();
      }
   }

   public void dispose() {
      super.dispose();
      this.graphSearcher.clearResults();
      this.graphSearcher = null;
   }

   public void doLayout() {
   }

   public GraphSearcher getGraphSearcher() {
      return this.graphSearcher;
   }

   public Set getSelectedNodes() {
      return new HashSet(CollectionHelpers.filter(super.getMappings().getNodes(), new SuperGraph$1(this)));
   }

   public void refreshAllSuperNodesSizes(SingleGraph var1, SingleGraph var2) {
      Iterator var3 = this.getMappings().getNodes().iterator();

      while(var3.hasNext()) {
         SuperDiffNode var4 = (SuperDiffNode)var3.next();
         this.refreshSuperNodeSize(var1, var2, var4);
      }

   }

   public void refreshSuperNodeSize(SingleGraph var1, SingleGraph var2, SuperDiffNode var3) {
      this.synchronizeSize(var1, var2, var3);
      SingleDiffNode var4 = var3.getPrimaryDiffNode();
      SingleDiffNode var5 = var3.getSecondaryDiffNode();
      CombinedDiffNode var6 = var3.getCombinedDiffNode();
      q var7 = var3.getNode();
      q var8 = null;
      q var9 = null;
      fj var10 = this.getGraph().t(var7);
      fj var11 = var6.getRealizer().getRealizer();
      fj var12 = null;
      fj var13 = null;
      double var14 = 0.0D;
      double var16 = 0.0D;
      double var18 = 0.0D;
      double var20 = 0.0D;
      if(var4 != null) {
         var8 = var4.getNode();
         var12 = var1.getGraph().t(var8);
         var14 = var12.getWidth();
         var16 = var12.getHeight();
      }

      if(var5 != null) {
         var9 = var5.getNode();
         var13 = var2.getGraph().t(var9);
         var18 = var13.getWidth();
         var20 = var13.getHeight();
      }

      var10.setWidth(Math.max(var14, var18));
      var10.setHeight(Math.max(var16, var20));
      if(var12 != null && var13 != null) {
         var11.setWidth(var10.getWidth() * 2.0D + 20.0D);
         var11.setHeight(var10.getHeight());
      }

      if(var4 != null) {
         var12.setWidth(var10.getWidth());
         var12.setHeight(var10.getHeight());
      }

      if(var5 != null) {
         var13.setWidth(var10.getWidth());
         var13.setHeight(var10.getHeight());
      }

   }
}
