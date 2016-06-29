package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.layout.*;
import com.google.security.zynamics.bindiff.graph.layout.commands.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import y.c.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.graph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.editmode.*;
import com.google.security.zynamics.zylib.types.common.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;

public final class CombinedGraph extends BinDiffGraph
{
    private SelectionHistory selectionHistory;
    private GraphSearcher graphSearcher;
    
    public CombinedGraph(final ZyGraph2DView zyGraph2DView, final LinkedHashMap linkedHashMap, final LinkedHashMap linkedHashMap2, final GraphSettings graphSettings, final EGraphType eGraphType) {
        super(zyGraph2DView, linkedHashMap, linkedHashMap2, graphSettings, eGraphType);
        this.selectionHistory = new SelectionHistory(this, 30);
        this.graphSearcher = new CombinedGraphSearcher();
    }
    
    public static CombinedDiffEdge buildDiffEdge(final CombinedGraph combinedGraph, final SuperViewEdge superViewEdge, final SuperDiffEdge superDiffEdge) {
        final RawCombinedJump rawCombinedJump = (RawCombinedJump)superViewEdge.getCombinedEdge();
        final CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(new ZyLabelContent(null), null, combinedGraph.getSettings());
        final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(rawCombinedJump.getSource());
        final CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)combinedGraph.getNode(rawCombinedJump.getTarget());
        final q node = combinedDiffNode.getNode();
        final q node2 = combinedDiffNode2.getNode();
        final boolean visible = combinedDiffNode.getRawNode().isVisible();
        final boolean visible2 = combinedDiffNode2.getRawNode().isVisible();
        combinedDiffNode.getRawNode().setVisible(true);
        combinedDiffNode2.getRawNode().setVisible(true);
        final CombinedDiffEdge combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, combinedGraph.getGraph().a(node, node2), combinedEdgeRealizer, rawCombinedJump, superDiffEdge);
        CombinedDiffNode.link(combinedDiffNode, combinedDiffNode2);
        combinedEdgeRealizer.setUserData(new ZyEdgeData(combinedDiffEdge));
        combinedDiffNode.getRawNode().setVisible(visible);
        combinedDiffNode2.getRawNode().setVisible(visible2);
        combinedGraph.addEdgeToMappings(combinedDiffEdge);
        if (!visible || !visible2) {
            final boolean deactiveAutoLayout = LayoutCommandHelper.deactiveAutoLayout(combinedGraph);
            try {
                ProximityBrowserUnhideNode.executeStatic(combinedGraph, visible ? combinedDiffNode : combinedDiffNode2);
            }
            finally {
                LayoutCommandHelper.activateAutoLayout(combinedGraph, deactiveAutoLayout);
            }
        }
        return combinedDiffEdge;
    }
    
    public static CombinedDiffNode buildDiffNode(final CombinedGraph combinedGraph, final SingleDiffNode singleDiffNode, final SingleDiffNode singleDiffNode2, final SuperDiffNode superDiffNode, final RawCombinedBasicBlock rawCombinedBasicBlock) {
        ZyLabelContent nodeContent = null;
        if (singleDiffNode != null) {
            nodeContent = singleDiffNode.getRealizer().getNodeContent();
        }
        ZyLabelContent nodeContent2 = null;
        if (singleDiffNode2 != null) {
            nodeContent2 = singleDiffNode2.getRealizer().getNodeContent();
        }
        final CombinedNodeRealizer realizer = new CombinedNodeRealizer(nodeContent, nodeContent2);
        final CodeNodeRealizerUpdater updater = new CodeNodeRealizerUpdater();
        realizer.setUpdater(updater);
        updater.setRealizer(realizer);
        final CombinedDiffNode combinedDiffNode = new CombinedDiffNode(combinedGraph.getGraph().d(), realizer, rawCombinedBasicBlock, superDiffNode);
        realizer.setUserData(new ZyNodeData(combinedDiffNode));
        return combinedDiffNode;
    }
    
    @Override
    protected CombinedGraphEditMode createEditMode() {
        return new CombinedGraphEditMode(this);
    }
    
    @Override
    public void dispose() {
        this.selectionHistory.dispose();
        super.dispose();
        this.graphSearcher.clearResults();
        this.selectionHistory = null;
        this.graphSearcher = null;
    }
    
    @Override
    public GraphSearcher getGraphSearcher() {
        return this.graphSearcher;
    }
    
    @Override
    public Set getSelectedNodes() {
        return new HashSet(CollectionHelpers.filter(this.getNodes(), new CombinedGraph$1(this)));
    }
    
    public SelectionHistory getSelectionHistory() {
        return this.selectionHistory;
    }
}
