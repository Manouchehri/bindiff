/*
 * Decompiled with CFR 0_115.
 */
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
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphMappings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.fj;

public class SuperGraph
extends BinDiffGraph {
    private static int NODELABEL_PADDING = 10;
    private GraphSearcher graphSearcher = new SuperGraphSearcher();

    public SuperGraph(ZyGraph2DView zyGraph2DView, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, SingleGraph singleGraph, SingleGraph singleGraph2, GraphSettings graphSettings, EGraphType eGraphType) {
        super(zyGraph2DView, linkedHashMap, linkedHashMap2, graphSettings, eGraphType);
        Preconditions.checkArgument(singleGraph != null || singleGraph2 != null, "Primary graph and secondary graph cannot both be null");
    }

    public static SuperDiffEdge buildDiffEdge(SuperGraph superGraph, SuperViewEdge superViewEdge, SingleDiffEdge singleDiffEdge, SingleDiffEdge singleDiffEdge2) {
        d d2 = null;
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(zyLabelContent, null);
        ZyGraphNode zyGraphNode = null;
        ZyGraphNode zyGraphNode2 = null;
        if (singleDiffEdge != null) {
            zyGraphNode = ((SingleDiffNode)singleDiffEdge.getSource()).getSuperDiffNode();
            zyGraphNode2 = ((SingleDiffNode)singleDiffEdge.getTarget()).getSuperDiffNode();
        } else if (singleDiffEdge2 != null) {
            zyGraphNode = ((SingleDiffNode)singleDiffEdge2.getSource()).getSuperDiffNode();
            zyGraphNode2 = ((SingleDiffNode)singleDiffEdge2.getTarget()).getSuperDiffNode();
        }
        q q2 = zyGraphNode.getNode();
        q q3 = zyGraphNode2.getNode();
        boolean bl2 = zyGraphNode.getRawNode().isVisible();
        boolean bl3 = zyGraphNode2.getRawNode().isVisible();
        zyGraphNode.getRawNode().setVisible(true);
        zyGraphNode2.getRawNode().setVisible(true);
        d2 = superGraph.getGraph().a(q2, q3);
        SuperDiffEdge superDiffEdge = new SuperDiffEdge((SuperDiffNode)zyGraphNode, (SuperDiffNode)zyGraphNode2, d2, zyEdgeRealizer, superViewEdge, singleDiffEdge, singleDiffEdge2);
        SuperDiffNode.link((SuperDiffNode)zyGraphNode, (SuperDiffNode)zyGraphNode2);
        zyEdgeRealizer.setUserData(new ZyEdgeData(superDiffEdge));
        zyGraphNode.getRawNode().setVisible(bl2);
        zyGraphNode2.getRawNode().setVisible(bl3);
        superGraph.addEdgeToMappings(superDiffEdge);
        return superDiffEdge;
    }

    public static SuperDiffNode buildDiffNode(SuperGraph superGraph, SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2, SuperViewNode superViewNode) {
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        ZyNormalNodeRealizer zyNormalNodeRealizer = new ZyNormalNodeRealizer(zyLabelContent);
        q q2 = superGraph.getGraph().d();
        SuperDiffNode superDiffNode = new SuperDiffNode(q2, zyNormalNodeRealizer, superViewNode, singleDiffNode, singleDiffNode2);
        zyNormalNodeRealizer.setUserData(new ZyNodeData(superDiffNode));
        return superDiffNode;
    }

    private void synchronizeSize(SingleGraph singleGraph, SingleGraph singleGraph2, SuperDiffNode superDiffNode) {
        if (superDiffNode.getRawNode().getCombinedNode().getMatchState() != EMatchState.MATCHED) {
            return;
        }
        SingleDiffNode singleDiffNode = superDiffNode.getPrimaryDiffNode();
        ZyLabelContent zyLabelContent = singleDiffNode.getRealizer().getNodeContent();
        SingleDiffNode singleDiffNode2 = superDiffNode.getSecondaryDiffNode();
        ZyLabelContent zyLabelContent2 = singleDiffNode2.getRealizer().getNodeContent();
        zyLabelContent.setRightPadding(NODELABEL_PADDING);
        zyLabelContent2.setRightPadding(NODELABEL_PADDING);
        double d2 = zyLabelContent.getBounds().getWidth();
        double d3 = zyLabelContent2.getBounds().getWidth();
        if (d2 > d3) {
            zyLabelContent2.setRightPadding((int)Math.round(d2 - d3) + NODELABEL_PADDING);
        } else {
            zyLabelContent.setRightPadding((int)Math.round(d3 - d2) + NODELABEL_PADDING);
        }
        singleDiffNode2.getRealizer().regenerate();
        singleDiffNode.getRealizer().regenerate();
        singleGraph.updateViews();
        singleGraph2.updateViews();
    }

    @Override
    public void dispose() {
        super.dispose();
        this.graphSearcher.clearResults();
        this.graphSearcher = null;
    }

    @Override
    public void doLayout() {
    }

    @Override
    public GraphSearcher getGraphSearcher() {
        return this.graphSearcher;
    }

    @Override
    public Set getSelectedNodes() {
        return new HashSet(CollectionHelpers.filter(super.getMappings().getNodes(), new SuperGraph$1(this)));
    }

    public void refreshAllSuperNodesSizes(SingleGraph singleGraph, SingleGraph singleGraph2) {
        Iterator iterator = this.getMappings().getNodes().iterator();
        while (iterator.hasNext()) {
            SuperDiffNode superDiffNode = (SuperDiffNode)iterator.next();
            this.refreshSuperNodeSize(singleGraph, singleGraph2, superDiffNode);
        }
    }

    public void refreshSuperNodeSize(SingleGraph singleGraph, SingleGraph singleGraph2, SuperDiffNode superDiffNode) {
        this.synchronizeSize(singleGraph, singleGraph2, superDiffNode);
        SingleDiffNode singleDiffNode = superDiffNode.getPrimaryDiffNode();
        SingleDiffNode singleDiffNode2 = superDiffNode.getSecondaryDiffNode();
        CombinedDiffNode combinedDiffNode = superDiffNode.getCombinedDiffNode();
        q q2 = superDiffNode.getNode();
        q q3 = null;
        q q4 = null;
        fj fj2 = this.getGraph().t(q2);
        fj fj3 = combinedDiffNode.getRealizer().getRealizer();
        fj fj4 = null;
        fj fj5 = null;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        if (singleDiffNode != null) {
            q3 = singleDiffNode.getNode();
            fj4 = singleGraph.getGraph().t(q3);
            d2 = fj4.getWidth();
            d3 = fj4.getHeight();
        }
        if (singleDiffNode2 != null) {
            q4 = singleDiffNode2.getNode();
            fj5 = singleGraph2.getGraph().t(q4);
            d4 = fj5.getWidth();
            d5 = fj5.getHeight();
        }
        fj2.setWidth(Math.max(d2, d4));
        fj2.setHeight(Math.max(d3, d5));
        if (fj4 != null && fj5 != null) {
            fj3.setWidth(fj2.getWidth() * 2.0 + 20.0);
            fj3.setHeight(fj2.getHeight());
        }
        if (singleDiffNode != null) {
            fj4.setWidth(fj2.getWidth());
            fj4.setHeight(fj2.getHeight());
        }
        if (singleDiffNode2 == null) return;
        fj5.setWidth(fj2.getWidth());
        fj5.setHeight(fj2.getHeight());
    }
}

