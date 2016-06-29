package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.editmode.SingleGraphActionFactory;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.TooltipGenerationHelper;
import com.google.security.zynamics.bindiff.graph.eventhandlers.DerivedLabelEventHandler;
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

public class SingleGraphEditMode extends ZyEditMode {
   public SingleGraphEditMode(AbstractZyGraph var1) {
      super(var1);
      this.assignNodeLabel(false);
      this.allowResizeNodes(false);
   }

   protected DerivedLabelEventHandler createNodeKeyHandler(AbstractZyGraph var1) {
      return new DerivedLabelEventHandler(var1);
   }

   protected IStateActionFactory createStateActionFactory() {
      return new SingleGraphActionFactory();
   }

   protected String getEdgeTip(d var1) {
      SingleGraph var2 = (SingleGraph)this.getGraph();
      if(CTooltipUpdater.isProximityNode(var2, var1.c())) {
         return this.getNodeTip(var1.c());
      } else if(CTooltipUpdater.isProximityNode(var2, var1.d())) {
         return this.getNodeTip(var1.d());
      } else {
         SingleDiffEdge var3 = (SingleDiffEdge)var2.getEdge(var1);
         SingleDiffNode var4 = (SingleDiffNode)var3.getSource();
         SingleDiffNode var5 = (SingleDiffNode)var3.getTarget();
         ZyLabelContent var6 = var4.getRealizer().getNodeContent();
         ZyLabelContent var7 = var5.getRealizer().getNodeContent();
         return HtmlGenerator.getHtml(var6, var7, Fonts.NORMAL_FONT.getName(), false, true);
      }
   }

   protected String getNodeTip(q var1) {
      SingleGraph var2 = (SingleGraph)this.getGraph();
      ZyGraph2DView var3 = (ZyGraph2DView)var2.getView();
      if(CTooltipUpdater.isProximityNode(var2, var1)) {
         IZyNodeRealizer var6 = (IZyNodeRealizer)var2.getGraph().t(var1);
         return TooltipGenerationHelper.generateProximityNodeTooltip((ZyProximityNode)var6.getUserData().getNode());
      } else if(var3.isNodeSloppyPaintMode()) {
         SingleDiffNode var4 = (SingleDiffNode)var2.getNode(var1);
         ZyLabelContent var5 = var4.getRealizer().getNodeContent();
         return HtmlGenerator.getHtml(var5, Fonts.NORMAL_FONT.getName(), false, true);
      } else {
         return null;
      }
   }

   public DerivedLabelEventHandler getLabelEventHandler() {
      return (DerivedLabelEventHandler)super.getLabelEventHandler();
   }
}
