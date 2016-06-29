package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.editmode.CombinedGraphActionFactory;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.TooltipGenerationHelper;
import com.google.security.zynamics.bindiff.graph.eventhandlers.DerivedLabelEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.resources.Fonts;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.HtmlGenerator;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CTooltipUpdater;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import y.c.d;
import y.c.q;

public final class CombinedGraphEditMode extends ZyEditMode {
   public CombinedGraphEditMode(AbstractZyGraph var1) {
      super(var1);
      this.assignNodeLabel(false);
      this.allowResizeNodes(false);
   }

   protected DerivedLabelEventHandler createNodeKeyHandler(AbstractZyGraph var1) {
      return new DerivedLabelEventHandler(var1);
   }

   protected IStateActionFactory createStateActionFactory() {
      return new CombinedGraphActionFactory();
   }

   protected String getEdgeTip(d var1) {
      CombinedGraph var2 = (CombinedGraph)this.getGraph();
      if(CTooltipUpdater.isProximityNode(var2, var1.c())) {
         return this.getNodeTip(var1.c());
      } else if(CTooltipUpdater.isProximityNode(var2, var1.d())) {
         return this.getNodeTip(var1.d());
      } else {
         CombinedDiffEdge var3 = (CombinedDiffEdge)var2.getEdge(var1);
         CombinedDiffNode var4 = (CombinedDiffNode)var3.getSource();
         CombinedDiffNode var5 = (CombinedDiffNode)var3.getTarget();
         return TooltipGenerationHelper.generateCombinedEdgeTooltips(Fonts.NORMAL_FONT.getName(), var4, var5);
      }
   }

   protected String getNodeTip(q var1) {
      CombinedGraph var2 = (CombinedGraph)this.getGraph();
      ZyGraph2DView var3 = (ZyGraph2DView)var2.getView();
      if(CTooltipUpdater.isProximityNode(var2, var1)) {
         IZyNodeRealizer var7 = (IZyNodeRealizer)var2.getGraph().t(var1);
         return TooltipGenerationHelper.generateProximityNodeTooltip(Fonts.NORMAL_FONT.getName(), (ZyProximityNode)var7.getUserData().getNode());
      } else if(var3.isNodeSloppyPaintMode()) {
         SingleDiffNode var4 = ((CombinedDiffNode)var2.getNode(var1)).getPrimaryDiffNode();
         SingleDiffNode var5 = ((CombinedDiffNode)var2.getNode(var1)).getSecondaryDiffNode();
         ZyLabelContent var6;
         if(var5 == null) {
            var6 = var4.getRealizer().getNodeContent();
            return HtmlGenerator.getHtml(var6, Fonts.NORMAL_FONT.getName(), false, true);
         } else if(var4 == null) {
            var6 = var5.getRealizer().getNodeContent();
            return HtmlGenerator.getHtml(var6, Fonts.NORMAL_FONT.getName(), false, true);
         } else {
            return TooltipGenerationHelper.generateCombinedNodeTooltip(Fonts.NORMAL_FONT.getName(), var4, var5, 0, 0);
         }
      } else {
         return null;
      }
   }

   public DerivedLabelEventHandler getLabelEventHandler() {
      return (DerivedLabelEventHandler)super.getLabelEventHandler();
   }
}
