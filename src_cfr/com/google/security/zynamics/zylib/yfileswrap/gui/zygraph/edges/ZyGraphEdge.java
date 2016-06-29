/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IBendListener;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEdgeRealizerListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge$InternalListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.c.d;
import y.c.i;
import y.d.t;
import y.h.aB;
import y.h.bu;

public class ZyGraphEdge {
    private d m_edge;
    private IViewEdge m_rawEdge;
    private final ZyGraphEdge$InternalListener m_listener;
    private final ZyEdgeRealizer m_realizer;
    private final bu m_graph;
    private final ZyGraphNode m_targetNode;
    private final ZyGraphNode m_sourceNode;

    public ZyGraphEdge(ZyGraphNode zyGraphNode, ZyGraphNode zyGraphNode2, d d2, ZyEdgeRealizer zyEdgeRealizer, IViewEdge iViewEdge) {
        this.m_listener = new ZyGraphEdge$InternalListener(this, null);
        Preconditions.checkNotNull(zyGraphNode, "Source node cannot be null");
        Preconditions.checkNotNull(zyGraphNode2, "Target node cannot be null");
        Preconditions.checkNotNull(d2, "Edge argument cannot be null");
        Preconditions.checkNotNull(iViewEdge, "Raw edge argument cannot be null");
        this.m_sourceNode = zyGraphNode;
        this.m_targetNode = zyGraphNode2;
        this.m_edge = d2;
        this.m_rawEdge = iViewEdge;
        this.m_realizer = zyEdgeRealizer;
        this.m_realizer.setSelected(iViewEdge.isSelected());
        this.m_realizer.setSourcePoint(new t(iViewEdge.getX1(), iViewEdge.getY1()));
        this.m_realizer.setTargetPoint(new t(iViewEdge.getX2(), iViewEdge.getY2()));
        this.m_graph = (bu)d2.a();
        this.m_graph.a(d2, (aB)zyEdgeRealizer);
        Iterator iterator = this.m_rawEdge.getBends().iterator();
        do {
            if (!iterator.hasNext()) {
                zyEdgeRealizer.addListener(this.m_listener);
                iViewEdge.addListener(this.m_listener);
                return;
            }
            CBend cBend = (CBend)iterator.next();
            this.m_realizer.addPoint(cBend.getX(), cBend.getY());
            cBend.addListener(this.m_listener);
        } while (true);
    }

    private static bu getGraph(d d2) {
        return (bu)d2.a();
    }

    private ZyEdgeRealizer getRealizer(d d2) {
        ZyEdgeRealizer zyEdgeRealizer = (ZyEdgeRealizer)ZyGraphEdge.getGraph(d2).i(d2);
        Preconditions.checkState(zyEdgeRealizer != null, "Node does not have a realizer");
        return zyEdgeRealizer;
    }

    private void updateViews() {
        if (ZyGraphEdge.getGraph(this.m_edge) == null) return;
        ZyGraphEdge.getGraph(this.m_edge).T();
    }

    public void addPath(double d2, double d3) {
        this.getRealizer(this.m_edge).addPoint(d2, d3);
    }

    public void dispose() {
        Iterator iterator = this.m_rawEdge.getBends().iterator();
        do {
            if (!iterator.hasNext()) {
                this.m_realizer.removeListener(this.m_listener);
                this.m_rawEdge.removeListener(this.m_listener);
                return;
            }
            CBend cBend = (CBend)iterator.next();
            cBend.removeListener(this.m_listener);
        } while (true);
    }

    public d getEdge() {
        return this.m_edge;
    }

    public ArrayList getPaths() {
        int n2 = this.getRealizer(this.m_edge).pointCount();
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        int n3 = 0;
        while (n3 < n2) {
            t t2 = this.getRealizer(this.m_edge).getPoint(n3);
            arrayList.add(new Pair(t2.a, t2.b));
            ++n3;
        }
        return arrayList;
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
        return this.getRealizer((d)this.m_edge).getSourcePoint().a;
    }

    public double getX2() {
        return this.getRealizer((d)this.m_edge).getTargetPoint().a;
    }

    public double getY1() {
        return this.getRealizer((d)this.m_edge).getSourcePoint().b;
    }

    public double getY2() {
        return this.getRealizer((d)this.m_edge).getTargetPoint().b;
    }

    public boolean isSelected() {
        return this.m_realizer.isSelected();
    }

    public boolean isVisible() {
        if (this.m_edge.a() == null) return false;
        return true;
    }

    public void setRawEdge(IViewEdge iViewEdge) {
        this.m_rawEdge.removeListener(this.m_listener);
        this.m_rawEdge = iViewEdge;
        this.m_rawEdge.addListener(this.m_listener);
    }

    public void setX1(double d2) {
        this.getRealizer(this.m_edge).setSourcePoint(new t(d2, this.getY1()));
    }

    public void setX2(double d2) {
        this.getRealizer(this.m_edge).setTargetPoint(new t(d2, this.getY2()));
    }

    public void setY1(double d2) {
        this.getRealizer(this.m_edge).setSourcePoint(new t(this.getX1(), d2));
    }

    public void setY2(double d2) {
        this.getRealizer(this.m_edge).setTargetPoint(new t(this.getX2(), d2));
    }

    static /* synthetic */ IViewEdge access$100(ZyGraphEdge zyGraphEdge) {
        return zyGraphEdge.m_rawEdge;
    }

    static /* synthetic */ ZyGraphEdge$InternalListener access$200(ZyGraphEdge zyGraphEdge) {
        return zyGraphEdge.m_listener;
    }

    static /* synthetic */ ZyEdgeRealizer access$300(ZyGraphEdge zyGraphEdge) {
        return zyGraphEdge.m_realizer;
    }

    static /* synthetic */ void access$400(ZyGraphEdge zyGraphEdge) {
        zyGraphEdge.updateViews();
    }

    static /* synthetic */ ZyGraphNode access$500(ZyGraphEdge zyGraphEdge) {
        return zyGraphEdge.m_sourceNode;
    }

    static /* synthetic */ ZyGraphNode access$600(ZyGraphEdge zyGraphEdge) {
        return zyGraphEdge.m_targetNode;
    }

    static /* synthetic */ bu access$700(ZyGraphEdge zyGraphEdge) {
        return zyGraphEdge.m_graph;
    }

    static /* synthetic */ d access$802(ZyGraphEdge zyGraphEdge, d d2) {
        zyGraphEdge.m_edge = d2;
        return zyGraphEdge.m_edge;
    }

    static /* synthetic */ d access$800(ZyGraphEdge zyGraphEdge) {
        return zyGraphEdge.m_edge;
    }
}

