package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.*;
import com.google.security.zynamics.bindiff.log.*;
import y.a.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import y.f.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import java.util.*;

public abstract class BinDiffGraph extends AbstractZyGraph
{
    private GraphsIntermediateListeners intermediateListeners;
    private final ProximityBrowser proximityBrowser;
    private GraphSettings settings;
    private final EGraphType viewType;
    private GraphsContainer graphs;
    
    protected BinDiffGraph(final ZyGraph2DView zyGraph2DView, final LinkedHashMap linkedHashMap, final LinkedHashMap linkedHashMap2, final GraphSettings graphSettings, final EGraphType eGraphType) {
        super(zyGraph2DView, linkedHashMap, linkedHashMap2, graphSettings);
        this.settings = (GraphSettings)Preconditions.checkNotNull(graphSettings);
        this.viewType = (EGraphType)Preconditions.checkNotNull(eGraphType);
        this.intermediateListeners = new GraphsIntermediateListeners(this);
        this.setProximityBrowser(this.proximityBrowser = new ProximityBrowser(this));
    }
    
    public static Window getParentWindow(final BinDiffGraph binDiffGraph) {
        return SwingUtilities.getWindowAncestor(binDiffGraph.getView());
    }
    
    public void addEdgeToMappings(final ZyGraphEdge zyGraphEdge) {
        this.getMappings().addEdge(zyGraphEdge.getEdge(), zyGraphEdge);
    }
    
    public void addNodeToMappings(final ZyGraphNode zyGraphNode) {
        this.getMappings().addNode(zyGraphNode.getNode(), zyGraphNode);
    }
    
    public O calculateLayout() {
        O b = null;
        final c currentLayouter = this.getSettings().getLayoutSettings().getCurrentLayouter();
        try {
            currentLayouter.c(new V());
            currentLayouter.c(true);
            b = new b(currentLayouter).b(this.getGraph());
            LayoutFunctions.recalculatePorts(currentLayouter, this.getGraph());
        }
        catch (a a) {
            Logger.logException(a, a.getMessage());
        }
        catch (Exception ex) {
            Logger.logException(ex, ex.getMessage());
            throw new GraphLayoutException(ex, "Could not calculate graph layout.");
        }
        return b;
    }
    
    public O calculateLayout(final c c) {
        O b = null;
        try {
            c.c(new V());
            c.c(true);
            b = new b(c).b(this.getGraph());
            LayoutFunctions.recalculatePorts(c, this.getGraph());
        }
        catch (a a) {
            Logger.logException(a, a.getMessage());
        }
        catch (Exception ex) {
            Logger.logException(ex, ex.getMessage());
            throw new GraphLayoutException(ex, "Could not calculate graph layout.");
        }
        return b;
    }
    
    public void deleteEdge(final ZyGraphEdge zyGraphEdge) {
        if (zyGraphEdge == null) {
            return;
        }
        final ZyGraphNode source = zyGraphEdge.getSource();
        final ZyGraphNode target = zyGraphEdge.getTarget();
        q q = null;
        if (ProximityHelper.isProximityNode(this.getGraph(), source.getNode())) {
            q = source.getNode();
        }
        else if (ProximityHelper.isProximityNode(this.getGraph(), target.getNode())) {
            q = target.getNode();
        }
        if (q != null) {
            this.getProximityBrowser().deleteProximityNode(q);
        }
        else {
            zyGraphEdge.dispose();
            this.getMappings().removeEdge(zyGraphEdge);
            this.getGraph().a(zyGraphEdge.getEdge());
            if (source instanceof SingleDiffNode && target instanceof SingleDiffNode) {
                SingleDiffNode.unlink((SingleDiffNode)source, (SingleDiffNode)target);
            }
            else if (source instanceof CombinedDiffNode && target instanceof CombinedDiffNode) {
                CombinedDiffNode.unlink((CombinedDiffNode)source, (CombinedDiffNode)target);
            }
            else if (source instanceof SuperDiffNode && target instanceof SuperDiffNode) {
                SuperDiffNode.unlink((SuperDiffNode)source, (SuperDiffNode)target);
            }
        }
    }
    
    public void deleteNode(final ZyGraphNode zyGraphNode) {
        if (zyGraphNode == null) {
            return;
        }
        final q node = zyGraphNode.getNode();
        ((CViewNode)zyGraphNode.getRawNode()).removeAllListeners();
        final ZyGraphMappings mappings = this.getMappings();
        final e j = node.j();
        while (j.f()) {
            this.deleteEdge(mappings.getEdge(j.a()));
            j.g();
        }
        this.getMappings().removeNode(zyGraphNode);
        this.getGraph().a(node);
    }
    
    @Override
    public void dispose() {
        super.dispose();
        this.intermediateListeners.dispose();
        this.settings = null;
        this.intermediateListeners = null;
        this.graphs = null;
    }
    
    @Override
    public void doLayout() {
    }
    
    public CombinedGraph getCombinedGraph() {
        return this.graphs.getCombinedGraph();
    }
    
    @Override
    public Collection getEdges() {
        return super.getEdges();
    }
    
    public GraphsContainer getGraphs() {
        return this.graphs;
    }
    
    public abstract GraphSearcher getGraphSearcher();
    
    public EGraphType getGraphType() {
        return this.viewType;
    }
    
    public GraphsIntermediateListeners getIntermediateListeners() {
        return this.intermediateListeners;
    }
    
    @Override
    public Collection getNodes() {
        return super.getNodes();
    }
    
    public SingleGraph getPrimaryGraph() {
        return this.graphs.getPrimaryGraph();
    }
    
    @Override
    public ProximityBrowser getProximityBrowser() {
        return this.proximityBrowser;
    }
    
    public SingleGraph getSecondaryGraph() {
        return this.graphs.getSecondaryGraph();
    }
    
    @Override
    public abstract Set getSelectedNodes();
    
    @Override
    public GraphSettings getSettings() {
        return this.settings;
    }
    
    public SuperGraph getSuperGraph() {
        return this.graphs.getSuperGraph();
    }
    
    public boolean isCombinedGraph() {
        return this == this.getCombinedGraph();
    }
    
    public boolean isPrimaryGraph() {
        return this == this.getPrimaryGraph();
    }
    
    public boolean isSecondaryGraph() {
        return this == this.getSuperGraph();
    }
    
    public boolean isSingleGraph() {
        return this.isPrimaryGraph() || this.isSecondaryGraph();
    }
    
    public boolean isSuperGraph() {
        return this == this.getSuperGraph();
    }
    
    public void setGraphs(final GraphsContainer graphsContainer) {
        this.graphs = (GraphsContainer)Preconditions.checkNotNull(graphsContainer);
    }
}
