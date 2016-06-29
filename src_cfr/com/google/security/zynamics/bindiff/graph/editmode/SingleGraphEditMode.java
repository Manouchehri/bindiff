/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.editmode.SingleGraphActionFactory;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.TooltipGenerationHelper;
import com.google.security.zynamics.bindiff.graph.eventhandlers.DerivedLabelEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.resources.Fonts;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.HtmlGenerator;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CTooltipUpdater;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Font;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.ch;
import y.h.fj;

public class SingleGraphEditMode
extends ZyEditMode {
    public SingleGraphEditMode(AbstractZyGraph abstractZyGraph) {
        super(abstractZyGraph);
        this.assignNodeLabel(false);
        this.allowResizeNodes(false);
    }

    @Override
    protected DerivedLabelEventHandler createNodeKeyHandler(AbstractZyGraph abstractZyGraph) {
        return new DerivedLabelEventHandler(abstractZyGraph);
    }

    @Override
    protected IStateActionFactory createStateActionFactory() {
        return new SingleGraphActionFactory();
    }

    @Override
    protected String getEdgeTip(d d2) {
        SingleGraph singleGraph = (SingleGraph)this.getGraph();
        if (CTooltipUpdater.isProximityNode(singleGraph, d2.c())) {
            return this.getNodeTip(d2.c());
        }
        if (CTooltipUpdater.isProximityNode(singleGraph, d2.d())) {
            return this.getNodeTip(d2.d());
        }
        SingleDiffEdge singleDiffEdge = (SingleDiffEdge)singleGraph.getEdge(d2);
        SingleDiffNode singleDiffNode = (SingleDiffNode)singleDiffEdge.getSource();
        SingleDiffNode singleDiffNode2 = (SingleDiffNode)singleDiffEdge.getTarget();
        ZyLabelContent zyLabelContent = singleDiffNode.getRealizer().getNodeContent();
        ZyLabelContent zyLabelContent2 = singleDiffNode2.getRealizer().getNodeContent();
        return HtmlGenerator.getHtml(zyLabelContent, zyLabelContent2, Fonts.NORMAL_FONT.getName(), false, true);
    }

    @Override
    protected String getNodeTip(q q2) {
        SingleGraph singleGraph = (SingleGraph)this.getGraph();
        ZyGraph2DView zyGraph2DView = (ZyGraph2DView)singleGraph.getView();
        if (CTooltipUpdater.isProximityNode(singleGraph, q2)) {
            IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)singleGraph.getGraph().t(q2));
            return TooltipGenerationHelper.generateProximityNodeTooltip((ZyProximityNode)iZyNodeRealizer.getUserData().getNode());
        }
        if (!zyGraph2DView.isNodeSloppyPaintMode()) return null;
        SingleDiffNode singleDiffNode = (SingleDiffNode)singleGraph.getNode(q2);
        ZyLabelContent zyLabelContent = singleDiffNode.getRealizer().getNodeContent();
        return HtmlGenerator.getHtml(zyLabelContent, Fonts.NORMAL_FONT.getName(), false, true);
    }

    @Override
    public DerivedLabelEventHandler getLabelEventHandler() {
        return (DerivedLabelEventHandler)super.getLabelEventHandler();
    }
}

