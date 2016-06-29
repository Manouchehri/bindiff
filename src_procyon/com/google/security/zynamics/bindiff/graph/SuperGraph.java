package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.types.common.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import y.h.*;

public class SuperGraph extends BinDiffGraph
{
    private static int NODELABEL_PADDING;
    private GraphSearcher graphSearcher;
    
    public SuperGraph(final ZyGraph2DView zyGraph2DView, final LinkedHashMap linkedHashMap, final LinkedHashMap linkedHashMap2, final SingleGraph singleGraph, final SingleGraph singleGraph2, final GraphSettings graphSettings, final EGraphType eGraphType) {
        super(zyGraph2DView, linkedHashMap, linkedHashMap2, graphSettings, eGraphType);
        this.graphSearcher = new SuperGraphSearcher();
        Preconditions.checkArgument(singleGraph != null || singleGraph2 != null, (Object)"Primary graph and secondary graph cannot both be null");
    }
    
    public static SuperDiffEdge buildDiffEdge(final SuperGraph superGraph, final SuperViewEdge superViewEdge, final SingleDiffEdge singleDiffEdge, final SingleDiffEdge singleDiffEdge2) {
        final ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
        SuperDiffNode superDiffNode = null;
        SuperDiffNode superDiffNode2 = null;
        if (singleDiffEdge != null) {
            superDiffNode = ((SingleDiffNode)singleDiffEdge.getSource()).getSuperDiffNode();
            superDiffNode2 = ((SingleDiffNode)singleDiffEdge.getTarget()).getSuperDiffNode();
        }
        else if (singleDiffEdge2 != null) {
            superDiffNode = ((SingleDiffNode)singleDiffEdge2.getSource()).getSuperDiffNode();
            superDiffNode2 = ((SingleDiffNode)singleDiffEdge2.getTarget()).getSuperDiffNode();
        }
        final q node = superDiffNode.getNode();
        final q node2 = superDiffNode2.getNode();
        final boolean visible = superDiffNode.getRawNode().isVisible();
        final boolean visible2 = superDiffNode2.getRawNode().isVisible();
        superDiffNode.getRawNode().setVisible(true);
        superDiffNode2.getRawNode().setVisible(true);
        final SuperDiffEdge superDiffEdge = new SuperDiffEdge(superDiffNode, superDiffNode2, superGraph.getGraph().a(node, node2), zyEdgeRealizer, superViewEdge, singleDiffEdge, singleDiffEdge2);
        SuperDiffNode.link(superDiffNode, superDiffNode2);
        zyEdgeRealizer.setUserData(new ZyEdgeData(superDiffEdge));
        superDiffNode.getRawNode().setVisible(visible);
        superDiffNode2.getRawNode().setVisible(visible2);
        superGraph.addEdgeToMappings(superDiffEdge);
        return superDiffEdge;
    }
    
    public static SuperDiffNode buildDiffNode(final SuperGraph superGraph, final SingleDiffNode singleDiffNode, final SingleDiffNode singleDiffNode2, final SuperViewNode superViewNode) {
        final ZyNormalNodeRealizer zyNormalNodeRealizer = new ZyNormalNodeRealizer(new ZyLabelContent(null));
        final SuperDiffNode superDiffNode = new SuperDiffNode(superGraph.getGraph().d(), zyNormalNodeRealizer, superViewNode, singleDiffNode, singleDiffNode2);
        zyNormalNodeRealizer.setUserData(new ZyNodeData(superDiffNode));
        return superDiffNode;
    }
    
    private void synchronizeSize(final SingleGraph singleGraph, final SingleGraph singleGraph2, final SuperDiffNode superDiffNode) {
        if (superDiffNode.getRawNode().getCombinedNode().getMatchState() != EMatchState.MATCHED) {
            return;
        }
        final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
        final ZyLabelContent nodeContent = primaryDiffNode.getRealizer().getNodeContent();
        final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
        final ZyLabelContent nodeContent2 = secondaryDiffNode.getRealizer().getNodeContent();
        nodeContent.setRightPadding(SuperGraph.NODELABEL_PADDING);
        nodeContent2.setRightPadding(SuperGraph.NODELABEL_PADDING);
        final double width = nodeContent.getBounds().getWidth();
        final double width2 = nodeContent2.getBounds().getWidth();
        if (width > width2) {
            nodeContent2.setRightPadding((int)Math.round(width - width2) + SuperGraph.NODELABEL_PADDING);
        }
        else {
            nodeContent.setRightPadding((int)Math.round(width2 - width) + SuperGraph.NODELABEL_PADDING);
        }
        secondaryDiffNode.getRealizer().regenerate();
        primaryDiffNode.getRealizer().regenerate();
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
    
    public void refreshAllSuperNodesSizes(final SingleGraph singleGraph, final SingleGraph singleGraph2) {
        final Iterator<SuperDiffNode> iterator = this.getMappings().getNodes().iterator();
        while (iterator.hasNext()) {
            this.refreshSuperNodeSize(singleGraph, singleGraph2, iterator.next());
        }
    }
    
    public void refreshSuperNodeSize(final SingleGraph singleGraph, final SingleGraph singleGraph2, final SuperDiffNode superDiffNode) {
        this.synchronizeSize(singleGraph, singleGraph2, superDiffNode);
        final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
        final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
        final CombinedDiffNode combinedDiffNode = superDiffNode.getCombinedDiffNode();
        final fj t = this.getGraph().t(superDiffNode.getNode());
        final fj realizer = combinedDiffNode.getRealizer().getRealizer();
        fj t2 = null;
        fj t3 = null;
        double width = 0.0;
        double height = 0.0;
        double width2 = 0.0;
        double height2 = 0.0;
        if (primaryDiffNode != null) {
            t2 = singleGraph.getGraph().t(primaryDiffNode.getNode());
            width = t2.getWidth();
            height = t2.getHeight();
        }
        if (secondaryDiffNode != null) {
            t3 = singleGraph2.getGraph().t(secondaryDiffNode.getNode());
            width2 = t3.getWidth();
            height2 = t3.getHeight();
        }
        t.setWidth(Math.max(width, width2));
        t.setHeight(Math.max(height, height2));
        if (t2 != null && t3 != null) {
            realizer.setWidth(t.getWidth() * 2.0 + 20.0);
            realizer.setHeight(t.getHeight());
        }
        if (primaryDiffNode != null) {
            t2.setWidth(t.getWidth());
            t2.setHeight(t.getHeight());
        }
        if (secondaryDiffNode != null) {
            t3.setWidth(t.getWidth());
            t3.setHeight(t.getHeight());
        }
    }
    
    static {
        SuperGraph.NODELABEL_PADDING = 10;
    }
}
