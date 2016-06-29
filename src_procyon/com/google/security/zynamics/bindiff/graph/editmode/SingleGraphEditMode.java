package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;

public class SingleGraphEditMode extends ZyEditMode
{
    public SingleGraphEditMode(final AbstractZyGraph abstractZyGraph) {
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
        return new SingleGraphActionFactory();
    }
    
    @Override
    protected String getEdgeTip(final d d) {
        final SingleGraph singleGraph = (SingleGraph)this.getGraph();
        if (CTooltipUpdater.isProximityNode(singleGraph, d.c())) {
            return this.getNodeTip(d.c());
        }
        if (CTooltipUpdater.isProximityNode(singleGraph, d.d())) {
            return this.getNodeTip(d.d());
        }
        final SingleDiffEdge singleDiffEdge = (SingleDiffEdge)singleGraph.getEdge(d);
        return HtmlGenerator.getHtml(((SingleDiffNode)singleDiffEdge.getSource()).getRealizer().getNodeContent(), ((SingleDiffNode)singleDiffEdge.getTarget()).getRealizer().getNodeContent(), Fonts.NORMAL_FONT.getName(), false, true);
    }
    
    @Override
    protected String getNodeTip(final q q) {
        final SingleGraph singleGraph = (SingleGraph)this.getGraph();
        final ZyGraph2DView zyGraph2DView = (ZyGraph2DView)singleGraph.getView();
        if (CTooltipUpdater.isProximityNode(singleGraph, q)) {
            return TooltipGenerationHelper.generateProximityNodeTooltip((ZyProximityNode)((IZyNodeRealizer)singleGraph.getGraph().t(q)).getUserData().getNode());
        }
        if (zyGraph2DView.isNodeSloppyPaintMode()) {
            return HtmlGenerator.getHtml(((SingleDiffNode)singleGraph.getNode(q)).getRealizer().getNodeContent(), Fonts.NORMAL_FONT.getName(), false, true);
        }
        return null;
    }
    
    @Override
    public DerivedLabelEventHandler getLabelEventHandler() {
        return (DerivedLabelEventHandler)super.getLabelEventHandler();
    }
}
