/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MutableDirectedGraph
implements IDirectedGraph,
Iterable {
    private final List m_nodes;
    private final List m_edges;
    private final Map m_nodeToEdges = new HashMap();

    public MutableDirectedGraph(List list, List list2) {
        this.m_nodes = (List)Preconditions.checkNotNull(list, "Nodes argument can not be null");
        this.m_edges = (List)Preconditions.checkNotNull(list2, "Edges argument can not be null");
        for (Object object2 : list) {
            Preconditions.checkNotNull(object2, "Node list contains null-nodes");
            this.m_nodeToEdges.put(object2, new ArrayList());
        }
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (IGraphEdge)iterator.next();
            this.updateNodeToEdgeMapping((IGraphEdge)object2);
        }
    }

    private void updateNodeToEdgeMapping(IGraphEdge iGraphEdge) {
        Preconditions.checkNotNull(iGraphEdge, "Error: edge argument can not be null");
        if (this.m_nodeToEdges.get(iGraphEdge.getSource()) == null) throw new IllegalStateException("Error: The given edge has a source node which is not known to the graph.");
        ((List)this.m_nodeToEdges.get(iGraphEdge.getSource())).add(iGraphEdge);
        if (this.m_nodeToEdges.get(iGraphEdge.getTarget()) == null) throw new IllegalStateException("Error: the given edge has a target node which is not known to the graph.");
        ((List)this.m_nodeToEdges.get(iGraphEdge.getTarget())).add(iGraphEdge);
    }

    public void addEdge(IGraphEdge iGraphEdge) {
        Preconditions.checkNotNull(iGraphEdge, "Edge argument can not be null");
        this.m_edges.add(iGraphEdge);
        this.updateNodeToEdgeMapping(iGraphEdge);
    }

    public void addNode(Object object) {
        Preconditions.checkNotNull(object, "Node argument can not be null");
        this.m_nodes.add(object);
        this.m_nodeToEdges.put(object, new ArrayList());
    }

    @Override
    public int edgeCount() {
        return this.m_edges.size();
    }

    @Override
    public List getEdges() {
        return Collections.unmodifiableList(this.m_edges);
    }

    @Override
    public List getNodes() {
        return Collections.unmodifiableList(this.m_nodes);
    }

    public Iterator iterator() {
        return this.m_nodes.iterator();
    }

    @Override
    public int nodeCount() {
        return this.m_nodes.size();
    }

    public void removeEdge(IGraphEdge iGraphEdge) {
        Preconditions.checkArgument(this.m_edges.remove(iGraphEdge), "Error: Edge was not part of the graph");
        ((List)this.m_nodeToEdges.get(iGraphEdge.getSource())).remove(iGraphEdge);
        ((List)this.m_nodeToEdges.get(iGraphEdge.getTarget())).remove(iGraphEdge);
    }

    public void removeNode(Object object) {
        Preconditions.checkArgument(this.m_nodes.remove(object), String.format("Error: Node '%s' was not part of the graph", object));
        this.m_edges.removeAll((Collection)this.m_nodeToEdges.get(object));
        this.m_nodeToEdges.remove(object);
    }
}

