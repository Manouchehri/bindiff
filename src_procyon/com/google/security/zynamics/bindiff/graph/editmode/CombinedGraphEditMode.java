package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;

public final class CombinedGraphEditMode extends ZyEditMode
{
    public CombinedGraphEditMode(final AbstractZyGraph abstractZyGraph) {
        super(abstractZyGraph);
        this.assignNodeLabel(false);
        this.allowResizeNodes(false);
    }
    
    @Override
    protected DerivedLabelEventHandler createNodeKeyHandler(final AbstractZyGraph abstractZyGraph) {
        return new DerivedLabelEventHandler(abstractZyGraph);
    }
    
    @Override
    protected IStateActionFactory createStateActionFactory() {
        return new CombinedGraphActionFactory();
    }
    
    @Override
    protected String getEdgeTip(final d d) {
        final CombinedGraph combinedGraph = (CombinedGraph)this.getGraph();
        if (CTooltipUpdater.isProximityNode(combinedGraph, d.c())) {
            return this.getNodeTip(d.c());
        }
        if (CTooltipUpdater.isProximityNode(combinedGraph, d.d())) {
            return this.getNodeTip(d.d());
        }
        final CombinedDiffEdge combinedDiffEdge = (CombinedDiffEdge)combinedGraph.getEdge(d);
        return TooltipGenerationHelper.generateCombinedEdgeTooltips(Fonts.NORMAL_FONT.getName(), (CombinedDiffNode)combinedDiffEdge.getSource(), (CombinedDiffNode)combinedDiffEdge.getTarget());
    }
    
    @Override
    protected String getNodeTip(final q q) {
        final CombinedGraph combinedGraph = (CombinedGraph)this.getGraph();
        final ZyGraph2DView zyGraph2DView = (ZyGraph2DView)combinedGraph.getView();
        if (CTooltipUpdater.isProximityNode(combinedGraph, q)) {
            return TooltipGenerationHelper.generateProximityNodeTooltip(Fonts.NORMAL_FONT.getName(), (ZyProximityNode)((IZyNodeRealizer)combinedGraph.getGraph().t(q)).getUserData().getNode());
        }
        if (!zyGraph2DView.isNodeSloppyPaintMode()) {
            return null;
        }
        final SingleDiffNode primaryDiffNode = ((CombinedDiffNode)combinedGraph.getNode(q)).getPrimaryDiffNode();
        final SingleDiffNode secondaryDiffNode = ((CombinedDiffNode)combinedGraph.getNode(q)).getSecondaryDiffNode();
        if (secondaryDiffNode == null) {
            return HtmlGenerator.getHtml(primaryDiffNode.getRealizer().getNodeContent(), Fonts.NORMAL_FONT.getName(), false, true);
        }
        if (primaryDiffNode == null) {
            return HtmlGenerator.getHtml(secondaryDiffNode.getRealizer().getNodeContent(), Fonts.NORMAL_FONT.getName(), false, true);
        }
        return TooltipGenerationHelper.generateCombinedNodeTooltip(Fonts.NORMAL_FONT.getName(), primaryDiffNode, secondaryDiffNode, 0, 0);
    }
    
    @Override
    public DerivedLabelEventHandler getLabelEventHandler() {
        return (DerivedLabelEventHandler)super.getLabelEventHandler();
    }
}
