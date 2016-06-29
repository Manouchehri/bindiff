package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.io.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.collect.*;

public class DirectedGraph implements IDirectedGraph, Iterable
{
    private final List m_nodes;
    private final List m_edges;
    private final HashMultimap m_incomingEdges;
    private final HashMultimap m_outgoingEdges;
    
    public DirectedGraph(final List nodes, final List edges) {
        this.m_incomingEdges = HashMultimap.create();
        this.m_outgoingEdges = HashMultimap.create();
        Preconditions.checkNotNull(nodes, (Object)"Error: Nodes argument can not be null");
        Preconditions.checkNotNull(edges, (Object)"Error: Edges argument can not be null");
        final Iterator<IGraphNode> iterator = nodes.iterator();
        while (iterator.hasNext()) {
            Preconditions.checkNotNull(iterator.next(), (Object)"Error: Node list contains null-nodes");
        }
        for (final IGraphEdge graphEdge : edges) {
            this.m_outgoingEdges.put(graphEdge.getSource(), graphEdge);
            this.m_incomingEdges.put(graphEdge.getTarget(), graphEdge);
        }
        this.m_nodes = nodes;
        this.m_edges = edges;
    }
    
    @Override
    public int edgeCount() {
        return this.m_edges.size();
    }
    
    @Override
    public List getEdges() {
        return Collections.unmodifiableList((List<?>)this.m_edges);
    }
    
    public Set getIncomingEdges(final IGraphNode graphNode) {
        return this.m_incomingEdges.get(graphNode);
    }
    
    @Override
    public List getNodes() {
        return Collections.unmodifiableList((List<?>)this.m_nodes);
    }
    
    public Set getOutgoingEdges(final IGraphNode graphNode) {
        return this.m_outgoingEdges.get(graphNode);
    }
    
    @Override
    public Iterator iterator() {
        return this.m_nodes.iterator();
    }
    
    @Override
    public int nodeCount() {
        return this.m_nodes.size();
    }
}
