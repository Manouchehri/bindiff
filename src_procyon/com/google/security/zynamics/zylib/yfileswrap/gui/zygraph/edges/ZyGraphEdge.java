package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import y.d.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;

public class ZyGraphEdge
{
    private d m_edge;
    private IViewEdge m_rawEdge;
    private final ZyGraphEdge$InternalListener m_listener;
    private final ZyEdgeRealizer m_realizer;
    private final bu m_graph;
    private final ZyGraphNode m_targetNode;
    private final ZyGraphNode m_sourceNode;
    
    public ZyGraphEdge(final ZyGraphNode sourceNode, final ZyGraphNode targetNode, final d edge, final ZyEdgeRealizer realizer, final IViewEdge rawEdge) {
        this.m_listener = new ZyGraphEdge$InternalListener(this, null);
        Preconditions.checkNotNull(sourceNode, (Object)"Source node cannot be null");
        Preconditions.checkNotNull(targetNode, (Object)"Target node cannot be null");
        Preconditions.checkNotNull(edge, (Object)"Edge argument cannot be null");
        Preconditions.checkNotNull(rawEdge, (Object)"Raw edge argument cannot be null");
        this.m_sourceNode = sourceNode;
        this.m_targetNode = targetNode;
        this.m_edge = edge;
        this.m_rawEdge = rawEdge;
        (this.m_realizer = realizer).setSelected(rawEdge.isSelected());
        this.m_realizer.setSourcePoint(new t(rawEdge.getX1(), rawEdge.getY1()));
        this.m_realizer.setTargetPoint(new t(rawEdge.getX2(), rawEdge.getY2()));
        (this.m_graph = (bu)edge.a()).a(edge, realizer);
        for (final CBend cBend : this.m_rawEdge.getBends()) {
            this.m_realizer.addPoint(cBend.getX(), cBend.getY());
            cBend.addListener(this.m_listener);
        }
        realizer.addListener(this.m_listener);
        rawEdge.addListener(this.m_listener);
    }
    
    private static bu getGraph(final d d) {
        return (bu)d.a();
    }
    
    private ZyEdgeRealizer getRealizer(final d d) {
        final ZyEdgeRealizer zyEdgeRealizer = (ZyEdgeRealizer)getGraph(d).i(d);
        Preconditions.checkState(zyEdgeRealizer != null, (Object)"Node does not have a realizer");
        return zyEdgeRealizer;
    }
    
    private void updateViews() {
        if (getGraph(this.m_edge) != null) {
            getGraph(this.m_edge).T();
        }
    }
    
    public void addPath(final double n, final double n2) {
        this.getRealizer(this.m_edge).addPoint(n, n2);
    }
    
    public void dispose() {
        final Iterator<CBend> iterator = this.m_rawEdge.getBends().iterator();
        while (iterator.hasNext()) {
            iterator.next().removeListener(this.m_listener);
        }
        this.m_realizer.removeListener(this.m_listener);
        this.m_rawEdge.removeListener(this.m_listener);
    }
    
    public d getEdge() {
        return this.m_edge;
    }
    
    public ArrayList getPaths() {
        final int pointCount = this.getRealizer(this.m_edge).pointCount();
        final ArrayList<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < pointCount; ++i) {
            final t point = this.getRealizer(this.m_edge).getPoint(i);
            list.add(new Pair(point.a, point.b));
        }
        return list;
    }
    
    public IViewEdge getRawEdge() {
        return this.m_rawEdge;
    }
    
    public ZyEdgeRealizer getRealizer() {
        return this.m_realizer;
    }
    
    public ZyGraphNode getSource() {
        return this.m_sourceNode;
    }
    
    public ZyGraphNode getTarget() {
        return this.m_targetNode;
    }
    
    public double getX1() {
        return this.getRealizer(this.m_edge).getSourcePoint().a;
    }
    
    public double getX2() {
        return this.getRealizer(this.m_edge).getTargetPoint().a;
    }
    
    public double getY1() {
        return this.getRealizer(this.m_edge).getSourcePoint().b;
    }
    
    public double getY2() {
        return this.getRealizer(this.m_edge).getTargetPoint().b;
    }
    
    public boolean isSelected() {
        return this.m_realizer.isSelected();
    }
    
    public boolean isVisible() {
        return this.m_edge.a() != null;
    }
    
    public void setRawEdge(final IViewEdge rawEdge) {
        this.m_rawEdge.removeListener(this.m_listener);
        (this.m_rawEdge = rawEdge).addListener(this.m_listener);
    }
    
    public void setX1(final double n) {
        this.getRealizer(this.m_edge).setSourcePoint(new t(n, this.getY1()));
    }
    
    public void setX2(final double n) {
        this.getRealizer(this.m_edge).setTargetPoint(new t(n, this.getY2()));
    }
    
    public void setY1(final double n) {
        this.getRealizer(this.m_edge).setSourcePoint(new t(this.getX1(), n));
    }
    
    public void setY2(final double n) {
        this.getRealizer(this.m_edge).setTargetPoint(new t(this.getX2(), n));
    }
}
