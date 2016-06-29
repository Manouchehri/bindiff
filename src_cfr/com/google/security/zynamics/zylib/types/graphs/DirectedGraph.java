/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DirectedGraph
implements IDirectedGraph,
Iterable {
    private final List m_nodes;
    private final List m_edges;
    private final HashMultimap m_incomingEdges = HashMultimap.create();
    private final HashMultimap m_outgoingEdges = HashMultimap.create();

    public DirectedGraph(List list, List list2) {
        Preconditions.checkNotNull(list, "Error: Nodes argument can not be null");
        Preconditions.checkNotNull(list2, "Error: Edges argument can not be null");
        for (Object object2 : list) {
            Preconditions.checkNotNull(object2, "Error: Node list contains null-nodes");
        }
        Iterator iterator = list2.iterator();
        do {
            Object object2;
            if (!iterator.hasNext()) {
                this.m_nodes = list;
                this.m_edges = list2;
                return;
            }
            object2 = (IGraphEdge)iterator.next();
            this.m_outgoingEdges.put(object2.getSource(), object2);
            this.m_incomingEdges.put(object2.getTarget(), object2);
        } while (true);
    }

    @Override
    public int edgeCount() {
        return this.m_edges.size();
    }

    @Override
    public List getEdges() {
        return Collections.unmodifiableList(this.m_edges);
    }

    public Set getIncomingEdges(IGraphNode iGraphNode) {
        return this.m_incomingEdges.get(iGraphNode);
    }

    @Override
    public List getNodes() {
        return Collections.unmodifiableList(this.m_nodes);
    }

    public Set getOutgoingEdges(IGraphNode iGraphNode) {
        return this.m_outgoingEdges.get(iGraphNode);
    }

    public Iterator iterator() {
        return this.m_nodes.iterator();
    }

    @Override
    public int nodeCount() {
        return this.m_nodes.size();
    }
}

