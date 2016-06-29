/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.editmode.CombinedGraphActionFactory;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.TooltipGenerationHelper;
import com.google.security.zynamics.bindiff.graph.eventhandlers.DerivedLabelEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
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

public final class CombinedGraphEditMode
extends ZyEditMode {
    public CombinedGraphEditMode(AbstractZyGraph abstractZyGraph) {
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
        return new CombinedGraphActionFactory();
    }

    @Override
    protected String getEdgeTip(d d2) {
        CombinedGraph combinedGraph = (CombinedGraph)this.getGraph();
        if (CTooltipUpdater.isProximityNode(combinedGraph, d2.c())) {
            return this.getNodeTip(d2.c());
        }
        if (CTooltipUpdater.isProximityNode(combinedGraph, d2.d())) {
            return this.getNodeTip(d2.d());
        }
        CombinedDiffEdge combinedDiffEdge = (CombinedDiffEdge)combinedGraph.getEdge(d2);
        CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedDiffEdge.getSource();
        CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)combinedDiffEdge.getTarget();
        return TooltipGenerationHelper.generateCombinedEdgeTooltips(Fonts.NORMAL_FONT.getName(), combinedDiffNode, combinedDiffNode2);
    }

    @Override
    protected String getNodeTip(q q2) {
        CombinedGraph combinedGraph = (CombinedGraph)this.getGraph();
        ZyGraph2DView zyGraph2DView = (ZyGraph2DView)combinedGraph.getView();
        if (CTooltipUpdater.isProximityNode(combinedGraph, q2)) {
            IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)combinedGraph.getGraph().t(q2));
            return TooltipGenerationHelper.generateProximityNodeTooltip(Fonts.NORMAL_FONT.getName(), (ZyProximityNode)iZyNodeRealizer.getUserData().getNode());
        }
        if (!zyGraph2DView.isNodeSloppyPaintMode()) return null;
        SingleDiffNode singleDiffNode = ((CombinedDiffNode)combinedGraph.getNode(q2)).getPrimaryDiffNode();
        SingleDiffNode singleDiffNode2 = ((CombinedDiffNode)combinedGraph.getNode(q2)).getSecondaryDiffNode();
        if (singleDiffNode2 == null) {
            ZyLabelContent zyLabelContent = singleDiffNode.getRealizer().getNodeContent();
            return HtmlGenerator.getHtml(zyLabelContent, Fonts.NORMAL_FONT.getName(), false, true);
        }
        if (singleDiffNode != null) return TooltipGenerationHelper.generateCombinedNodeTooltip(Fonts.NORMAL_FONT.getName(), singleDiffNode, singleDiffNode2, 0, 0);
        ZyLabelContent zyLabelContent = singleDiffNode2.getRealizer().getNodeContent();
        return HtmlGenerator.getHtml(zyLabelContent, Fonts.NORMAL_FONT.getName(), false, true);
    }

    @Override
    public DerivedLabelEventHandler getLabelEventHandler() {
        return (DerivedLabelEventHandler)super.getLabelEventHandler();
    }
}

