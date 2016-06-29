package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.layout.*;
import com.google.security.zynamics.bindiff.graph.layout.commands.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.bindiff.graph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.bindiff.graph.editmode.*;
import com.google.security.zynamics.zylib.types.common.*;
import java.util.*;

public class SingleGraph extends BinDiffGraph
{
    private SelectionHistory selectionHistory;
    private GraphSearcher graphSearcher;
    private final IAddress functionAddress;
    private final ESide side;
    
    public SingleGraph(final ZyGraph2DView zyGraph2DView, final IAddress functionAddress, final LinkedHashMap linkedHashMap, final LinkedHashMap linkedHashMap2, final GraphSettings graphSettings, final ESide side, final EGraphType eGraphType) {
        super(zyGraph2DView, linkedHashMap, linkedHashMap2, graphSettings, eGraphType);
        this.selectionHistory = new SelectionHistory(this, 30);
        this.graphSearcher = new GraphSearcher();
        Preconditions.checkNotNull(side);
        this.functionAddress = functionAddress;
        this.side = side;
    }
    
    public static SingleDiffEdge buildDiffEdge(final SingleGraph singleGraph, final SuperViewEdge superViewEdge) {
        SingleDiffEdge singleDiffEdge = null;
        final RawCombinedJump rawCombinedJump = (RawCombinedJump)superViewEdge.getCombinedEdge();
        final RawBasicBlock rawNode = rawCombinedJump.getSource().getRawNode(singleGraph.getSide());
        final RawBasicBlock rawNode2 = rawCombinedJump.getTarget().getRawNode(singleGraph.getSide());
        final RawJump rawJump = (singleGraph.getSide() == ESide.PRIMARY) ? rawCombinedJump.getPrimaryEdge() : rawCombinedJump.getSecondaryEdge();
        if (rawJump == null) {
            return null;
        }
        if (rawNode != null && rawNode2 != null && rawJump != null) {
            final SingleEdgeRealizer singleEdgeRealizer = new SingleEdgeRealizer(new ZyLabelContent(null), null, singleGraph.getSettings());
            final SingleDiffNode singleDiffNode = (SingleDiffNode)singleGraph.getNode(rawNode);
            final SingleDiffNode singleDiffNode2 = (SingleDiffNode)singleGraph.getNode(rawNode2);
            final boolean visible = singleDiffNode.getRawNode().isVisible();
            final boolean visible2 = singleDiffNode2.getRawNode().isVisible();
            singleDiffNode.getRawNode().setVisible(true);
            singleDiffNode2.getRawNode().setVisible(true);
            singleDiffEdge = new SingleDiffEdge(singleDiffNode, singleDiffNode2, singleGraph.getGraph().a(singleDiffNode.getNode(), singleDiffNode2.getNode()), singleEdgeRealizer, rawJump, singleGraph.getSide());
            SingleDiffNode.link(singleDiffNode, singleDiffNode2);
            singleEdgeRealizer.setUserData(new ZyEdgeData(singleDiffEdge));
            singleDiffNode.getRawNode().setVisible(visible);
            singleDiffNode2.getRawNode().setVisible(visible2);
            singleGraph.addEdgeToMappings(singleDiffEdge);
            if (!visible || !visible2) {
                final boolean deactiveAutoLayout = LayoutCommandHelper.deactiveAutoLayout(singleGraph);
                try {
                    ProximityBrowserUnhideNode.executeStatic(singleGraph, visible ? singleDiffNode : singleDiffNode2);
                }
                finally {
                    LayoutCommandHelper.activateAutoLayout(singleGraph, deactiveAutoLayout);
                }
            }
        }
        return singleDiffEdge;
    }
    
    public static SingleDiffNode buildDiffNode(final SingleGraph singleGraph, final FunctionMatchData functionMatchData, final RawCombinedFlowGraph rawCombinedFlowGraph, final RawCombinedBasicBlock rawCombinedBasicBlock) {
        ZyGraphNode zyGraphNode = null;
        final bu graph = singleGraph.getGraph();
        final RawBasicBlock rawNode = rawCombinedBasicBlock.getRawNode(singleGraph.getSide());
        if (rawNode != null) {
            final ZyNormalNodeRealizer realizer = new ZyNormalNodeRealizer(ViewFlowGraphBuilder.buildSingleBasicblockLabelContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, singleGraph.getSide()));
            final CodeNodeRealizerUpdater updater = new CodeNodeRealizerUpdater();
            realizer.setUpdater(updater);
            updater.setRealizer(realizer);
            zyGraphNode = new SingleDiffBasicBlockNode(graph.d(), realizer, rawNode, singleGraph.getSide());
            realizer.setUserData(new ZyNodeData(zyGraphNode));
        }
        return (SingleDiffNode)zyGraphNode;
    }
    
    @Override
    protected ZyEditMode createEditMode() {
        return new SingleGraphEditMode(this);
    }
    
    @Override
    public void dispose() {
        this.selectionHistory.dispose();
        super.dispose();
        this.graphSearcher.clearResults();
        this.selectionHistory = null;
        this.graphSearcher = null;
    }
    
    public IAddress getFunctionAddress() {
        return this.functionAddress;
    }
    
    @Override
    public GraphSearcher getGraphSearcher() {
        return this.graphSearcher;
    }
    
    public SingleGraph getOtherSideGraph() {
        return (this.side == ESide.PRIMARY) ? this.getSecondaryGraph() : this.getPrimaryGraph();
    }
    
    @Override
    public Set getSelectedNodes() {
        return new HashSet(CollectionHelpers.filter(super.getMappings().getNodes(), new SingleGraph$1(this)));
    }
    
    public SelectionHistory getSelectionHistory() {
        return this.selectionHistory;
    }
    
    public ESide getSide() {
        return this.side;
    }
}
