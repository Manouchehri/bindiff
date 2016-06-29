package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.*;
import java.util.*;

public class MutableDirectedGraph implements IDirectedGraph, Iterable
{
    private final List m_nodes;
    private final List m_edges;
    private final Map m_nodeToEdges;
    
    public MutableDirectedGraph(final List list, final List list2) {
        this.m_nodeToEdges = new HashMap();
        this.m_nodes = (List)Preconditions.checkNotNull(list, (Object)"Nodes argument can not be null");
        this.m_edges = (List)Preconditions.checkNotNull(list2, (Object)"Edges argument can not be null");
        for (final Object next : list) {
            Preconditions.checkNotNull(next, (Object)"Node list contains null-nodes");
            this.m_nodeToEdges.put(next, new ArrayList());
        }
        final Iterator<IGraphEdge> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            this.updateNodeToEdgeMapping(iterator2.next());
        }
    }
    
    private void updateNodeToEdgeMapping(final IGraphEdge graphEdge) {
        Preconditions.checkNotNull(graphEdge, (Object)"Error: edge argument can not be null");
        if (this.m_nodeToEdges.get(graphEdge.getSource()) == null) {
            throw new IllegalStateException("Error: The given edge has a source node which is not known to the graph.");
        }
        this.m_nodeToEdges.get(graphEdge.getSource()).add(graphEdge);
        if (this.m_nodeToEdges.get(graphEdge.getTarget()) != null) {
            this.m_nodeToEdges.get(graphEdge.getTarget()).add(graphEdge);
            return;
        }
        throw new IllegalStateException("Error: the given edge has a target node which is not known to the graph.");
    }
    
    public void addEdge(final IGraphEdge graphEdge) {
        Preconditions.checkNotNull(graphEdge, (Object)"Edge argument can not be null");
        this.m_edges.add(graphEdge);
        this.updateNodeToEdgeMapping(graphEdge);
    }
    
    public void addNode(final Object o) {
        Preconditions.checkNotNull(o, (Object)"Node argument can not be null");
        this.m_nodes.add(o);
        this.m_nodeToEdges.put(o, new ArrayList());
    }
    
    @Override
    public int edgeCount() {
        return this.m_edges.size();
    }
    
    @Override
    public List getEdges() {
        return Collections.unmodifiableList((List<?>)this.m_edges);
    }
    
    @Override
    public List getNodes() {
        return Collections.unmodifiableList((List<?>)this.m_nodes);
    }
    
    @Override
    public Iterator iterator() {
        return this.m_nodes.iterator();
    }
    
    @Override
    public int nodeCount() {
        return this.m_nodes.size();
    }
    
    public void removeEdge(final IGraphEdge graphEdge) {
        Preconditions.checkArgument(this.m_edges.remove(graphEdge), (Object)"Error: Edge was not part of the graph");
        this.m_nodeToEdges.get(graphEdge.getSource()).remove(graphEdge);
        this.m_nodeToEdges.get(graphEdge.getTarget()).remove(graphEdge);
    }
    
    public void removeNode(final Object o) {
        Preconditions.checkArgument(this.m_nodes.remove(o), (Object)String.format("Error: Node '%s' was not part of the graph", o));
        this.m_edges.removeAll(this.m_nodeToEdges.get(o));
        this.m_nodeToEdges.remove(o);
    }
}
