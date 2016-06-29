/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.ProximityBrowser;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphMappings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.LayoutFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import java.awt.Window;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.swing.SwingUtilities;
import y.a.a;
import y.c.d;
import y.c.e;
import y.c.q;
import y.f.O;
import y.f.V;
import y.f.X;
import y.f.ad;
import y.f.ah;
import y.f.b;
import y.f.c;
import y.h.bu;
import y.h.ch;

public abstract class BinDiffGraph
extends AbstractZyGraph {
    private GraphsIntermediateListeners intermediateListeners;
    private final ProximityBrowser proximityBrowser;
    private GraphSettings settings;
    private final EGraphType viewType;
    private GraphsContainer graphs;

    protected BinDiffGraph(ZyGraph2DView zyGraph2DView, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, GraphSettings graphSettings, EGraphType eGraphType) {
        super(zyGraph2DView, linkedHashMap, linkedHashMap2, graphSettings);
        this.settings = (GraphSettings)Preconditions.checkNotNull(graphSettings);
        this.viewType = (EGraphType)((Object)Preconditions.checkNotNull((Object)eGraphType));
        this.intermediateListeners = new GraphsIntermediateListeners(this);
        this.proximityBrowser = new ProximityBrowser(this);
        this.setProximityBrowser(this.proximityBrowser);
    }

    public static Window getParentWindow(BinDiffGraph binDiffGraph) {
        return SwingUtilities.getWindowAncestor(binDiffGraph.getView());
    }

    public void addEdgeToMappings(ZyGraphEdge zyGraphEdge) {
        d d2 = zyGraphEdge.getEdge();
        ZyGraphMappings zyGraphMappings = this.getMappings();
        zyGraphMappings.addEdge(d2, zyGraphEdge);
    }

    public void addNodeToMappings(ZyGraphNode zyGraphNode) {
        q q2 = zyGraphNode.getNode();
        ZyGraphMappings zyGraphMappings = this.getMappings();
        zyGraphMappings.addNode(q2, zyGraphNode);
    }

    public O calculateLayout() {
        O o2 = null;
        c c2 = this.getSettings().getLayoutSettings().getCurrentLayouter();
        try {
            c2.c(new V());
            c2.c(true);
            o2 = new b(c2).b(this.getGraph());
            LayoutFunctions.recalculatePorts(c2, this.getGraph());
            return o2;
        }
        catch (a var3_3) {
            Logger.logException(var3_3, var3_3.getMessage());
            return o2;
        }
        catch (Exception var3_4) {
            Logger.logException(var3_4, var3_4.getMessage());
            throw new GraphLayoutException(var3_4, "Could not calculate graph layout.");
        }
    }

    public O calculateLayout(c c2) {
        O o2 = null;
        try {
            c2.c(new V());
            c2.c(true);
            o2 = new b(c2).b(this.getGraph());
            LayoutFunctions.recalculatePorts(c2, this.getGraph());
            return o2;
        }
        catch (a var3_3) {
            Logger.logException(var3_3, var3_3.getMessage());
            return o2;
        }
        catch (Exception var3_4) {
            Logger.logException(var3_4, var3_4.getMessage());
            throw new GraphLayoutException(var3_4, "Could not calculate graph layout.");
        }
    }

    public void deleteEdge(ZyGraphEdge zyGraphEdge) {
        if (zyGraphEdge == null) {
            return;
        }
        ZyGraphNode zyGraphNode = zyGraphEdge.getSource();
        ZyGraphNode zyGraphNode2 = zyGraphEdge.getTarget();
        q q2 = null;
        if (ProximityHelper.isProximityNode(this.getGraph(), zyGraphNode.getNode())) {
            q2 = zyGraphNode.getNode();
        } else if (ProximityHelper.isProximityNode(this.getGraph(), zyGraphNode2.getNode())) {
            q2 = zyGraphNode2.getNode();
        }
        if (q2 != null) {
            this.getProximityBrowser().deleteProximityNode(q2);
            return;
        }
        zyGraphEdge.dispose();
        this.getMappings().removeEdge(zyGraphEdge);
        this.getGraph().a(zyGraphEdge.getEdge());
        if (zyGraphNode instanceof SingleDiffNode && zyGraphNode2 instanceof SingleDiffNode) {
            SingleDiffNode.unlink((SingleDiffNode)zyGraphNode, (SingleDiffNode)zyGraphNode2);
            return;
        }
        if (zyGraphNode instanceof CombinedDiffNode && zyGraphNode2 instanceof CombinedDiffNode) {
            CombinedDiffNode.unlink((CombinedDiffNode)zyGraphNode, (CombinedDiffNode)zyGraphNode2);
            return;
        }
        if (!(zyGraphNode instanceof SuperDiffNode)) return;
        if (!(zyGraphNode2 instanceof SuperDiffNode)) return;
        SuperDiffNode.unlink((SuperDiffNode)zyGraphNode, (SuperDiffNode)zyGraphNode2);
    }

    public void deleteNode(ZyGraphNode zyGraphNode) {
        if (zyGraphNode == null) {
            return;
        }
        q q2 = zyGraphNode.getNode();
        CViewNode cViewNode = (CViewNode)zyGraphNode.getRawNode();
        cViewNode.removeAllListeners();
        ZyGraphMappings zyGraphMappings = this.getMappings();
        e e2 = q2.j();
        do {
            if (!e2.f()) {
                this.getMappings().removeNode(zyGraphNode);
                this.getGraph().a(q2);
                return;
            }
            ZyGraphEdge zyGraphEdge = zyGraphMappings.getEdge(e2.a());
            this.deleteEdge(zyGraphEdge);
            e2.g();
        } while (true);
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
        if (this != this.getCombinedGraph()) return false;
        return true;
    }

    public boolean isPrimaryGraph() {
        if (this != this.getPrimaryGraph()) return false;
        return true;
    }

    public boolean isSecondaryGraph() {
        if (this != this.getSuperGraph()) return false;
        return true;
    }

    public boolean isSingleGraph() {
        if (this.isPrimaryGraph()) return true;
        if (this.isSecondaryGraph()) return true;
        return false;
    }

    public boolean isSuperGraph() {
        if (this != this.getSuperGraph()) return false;
        return true;
    }

    public void setGraphs(GraphsContainer graphsContainer) {
        this.graphs = (GraphsContainer)Preconditions.checkNotNull(graphsContainer);
    }
}

