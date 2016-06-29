package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import y.h.*;
import com.google.common.collect.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import java.util.*;
import com.google.common.base.*;

public class ZyGraphMappings
{
    private final Map m_edgeMap;
    private final Map m_rawEdgeMap;
    private final Map m_nodeMap;
    private final Map m_rawNodeMap;
    private final bu m_graph;
    
    public ZyGraphMappings(final bu graph, final Map map, final Map map2) {
        this.m_graph = graph;
        this.m_nodeMap = Maps.newHashMap(map);
        this.m_rawNodeMap = Maps.newHashMap();
        this.m_edgeMap = Maps.newHashMap(map2);
        this.m_rawEdgeMap = Maps.newHashMap();
        for (final ZyGraphEdge zyGraphEdge : map2.values()) {
            this.m_rawEdgeMap.put(zyGraphEdge.getRawEdge(), zyGraphEdge);
        }
        for (final ZyGraphNode zyGraphNode : map.values()) {
            this.m_rawNodeMap.put(zyGraphNode.getRawNode(), zyGraphNode);
        }
    }
    
    public void addEdge(final d d, final ZyGraphEdge zyGraphEdge) {
        this.m_edgeMap.put(d, zyGraphEdge);
        this.m_rawEdgeMap.put(zyGraphEdge.getRawEdge(), zyGraphEdge);
    }
    
    public void addNode(final q q, final ZyGraphNode zyGraphNode) {
        this.m_nodeMap.put(q, zyGraphNode);
        this.m_rawNodeMap.put(zyGraphNode.getRawNode(), zyGraphNode);
    }
    
    public ZyGraphEdge getEdge(final d d) {
        if (d.a() != this.m_graph) {
            return null;
        }
        return (ZyGraphEdge)((ZyEdgeRealizer)this.m_graph.i(d)).getUserData().getEdge();
    }
    
    public ZyGraphEdge getEdge(final Object o) {
        return this.m_rawEdgeMap.get(o);
    }
    
    public Collection getEdges() {
        return this.m_edgeMap.values();
    }
    
    public ZyGraphNode getNode(final q q) {
        Preconditions.checkNotNull(q, (Object)"Node argument cannot be null");
        return this.m_nodeMap.get(q);
    }
    
    public ZyGraphNode getNode(final Object o) {
        return this.m_rawNodeMap.get(o);
    }
    
    public Collection getNodes() {
        return this.m_nodeMap.values();
    }
    
    public d getYEdge(final Object o) {
        return this.m_rawEdgeMap.get(o).getEdge();
    }
    
    public q getYNode(final Object o) {
        if (this.m_rawNodeMap.containsKey(o)) {
            return this.m_rawNodeMap.get(o).getNode();
        }
        return null;
    }
    
    public void removeEdge(final ZyGraphEdge zyGraphEdge) {
        this.m_edgeMap.remove(zyGraphEdge.getEdge());
        this.m_rawEdgeMap.remove(zyGraphEdge.getRawEdge());
    }
    
    public void removeNode(final ZyGraphNode zyGraphNode) {
        this.m_nodeMap.remove(zyGraphNode.getNode());
        this.m_rawNodeMap.remove(zyGraphNode.getRawNode());
    }
    
    public void setEdge(final Object o, final ZyGraphEdge zyGraphEdge) {
        this.m_rawEdgeMap.put(o, zyGraphEdge);
    }
    
    public void setNode(final Object o, final ZyGraphNode zyGraphNode) {
        this.m_rawNodeMap.put(o, zyGraphNode);
    }
}
