/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import y.c.d;
import y.c.i;
import y.c.q;
import y.h.aB;
import y.h.bu;

public class ZyGraphMappings {
    private final Map m_edgeMap;
    private final Map m_rawEdgeMap;
    private final Map m_nodeMap;
    private final Map m_rawNodeMap;
    private final bu m_graph;

    public ZyGraphMappings(bu bu2, Map map, Map map2) {
        this.m_graph = bu2;
        this.m_nodeMap = Maps.newHashMap(map);
        this.m_rawNodeMap = Maps.newHashMap();
        this.m_edgeMap = Maps.newHashMap(map2);
        this.m_rawEdgeMap = Maps.newHashMap();
        for (Object object2 : map2.values()) {
            this.m_rawEdgeMap.put(object2.getRawEdge(), object2);
        }
        Iterator iterator = map.values().iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (ZyGraphNode)iterator.next();
            this.m_rawNodeMap.put(object2.getRawNode(), object2);
        }
    }

    public void addEdge(d d2, ZyGraphEdge zyGraphEdge) {
        this.m_edgeMap.put(d2, zyGraphEdge);
        this.m_rawEdgeMap.put(zyGraphEdge.getRawEdge(), zyGraphEdge);
    }

    public void addNode(q q2, ZyGraphNode zyGraphNode) {
        this.m_nodeMap.put(q2, zyGraphNode);
        this.m_rawNodeMap.put(zyGraphNode.getRawNode(), zyGraphNode);
    }

    public ZyGraphEdge getEdge(d d2) {
        if (d2.a() == this.m_graph) return (ZyGraphEdge)((ZyEdgeRealizer)this.m_graph.i(d2)).getUserData().getEdge();
        return null;
    }

    public ZyGraphEdge getEdge(Object object) {
        return (ZyGraphEdge)this.m_rawEdgeMap.get(object);
    }

    public Collection getEdges() {
        return this.m_edgeMap.values();
    }

    public ZyGraphNode getNode(q q2) {
        Preconditions.checkNotNull(q2, "Node argument cannot be null");
        return (ZyGraphNode)this.m_nodeMap.get(q2);
    }

    public ZyGraphNode getNode(Object object) {
        return (ZyGraphNode)this.m_rawNodeMap.get(object);
    }

    public Collection getNodes() {
        return this.m_nodeMap.values();
    }

    public d getYEdge(Object object) {
        return ((ZyGraphEdge)this.m_rawEdgeMap.get(object)).getEdge();
    }

    public q getYNode(Object object) {
        if (!this.m_rawNodeMap.containsKey(object)) return null;
        return ((ZyGraphNode)this.m_rawNodeMap.get(object)).getNode();
    }

    public void removeEdge(ZyGraphEdge zyGraphEdge) {
        this.m_edgeMap.remove(zyGraphEdge.getEdge());
        this.m_rawEdgeMap.remove(zyGraphEdge.getRawEdge());
    }

    public void removeNode(ZyGraphNode zyGraphNode) {
        this.m_nodeMap.remove(zyGraphNode.getNode());
        this.m_rawNodeMap.remove(zyGraphNode.getRawNode());
    }

    public void setEdge(Object object, ZyGraphEdge zyGraphEdge) {
        this.m_rawEdgeMap.put(object, zyGraphEdge);
    }

    public void setNode(Object object, ZyGraphNode zyGraphNode) {
        this.m_rawNodeMap.put(object, zyGraphNode);
    }
}

