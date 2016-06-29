/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IBendListener;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEdgeRealizerListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import y.c.d;
import y.c.i;
import y.c.q;
import y.d.t;
import y.h.a.v;
import y.h.aB;
import y.h.x;

class ZyGraphEdge$InternalListener
implements IBendListener,
IViewEdgeListener,
IZyEdgeRealizerListener {
    final /* synthetic */ ZyGraphEdge this$0;

    private ZyGraphEdge$InternalListener(ZyGraphEdge zyGraphEdge) {
        this.this$0 = zyGraphEdge;
    }

    @Override
    public void addedBend(double d2, double d3) {
        ZyGraphEdge.access$100(this.this$0).addBend(d2, d3);
    }

    @Override
    public void addedBend(IViewEdge iViewEdge, CBend cBend) {
        cBend.addListener(ZyGraphEdge.access$200(this.this$0));
        if (ZyGraphEdge.access$300(this.this$0).bendCount() == iViewEdge.getBendCount()) {
            return;
        }
        ZyGraphEdge.access$300(this.this$0).appendBend(cBend.getX(), cBend.getY());
    }

    @Override
    public void bendChanged(int n2, double d2, double d3) {
        CBend cBend = (CBend)ZyGraphEdge.access$100(this.this$0).getBends().get(n2);
        cBend.setX(d2);
        cBend.setY(d3);
    }

    @Override
    public void changedColor(CViewEdge cViewEdge, Color color) {
        ZyGraphEdge.access$300(this.this$0).setLineColor(color);
        ZyGraphEdge.access$400(this.this$0);
    }

    @Override
    public void changedLocation(ZyEdgeRealizer zyEdgeRealizer) {
        t t2 = zyEdgeRealizer.getSourcePoint();
        ZyGraphEdge.access$100(this.this$0).setX1(t2.a);
        ZyGraphEdge.access$100(this.this$0).setY1(t2.b);
        t t3 = zyEdgeRealizer.getTargetPoint();
        ZyGraphEdge.access$100(this.this$0).setX2(t3.a);
        ZyGraphEdge.access$100(this.this$0).setY2(t3.b);
    }

    @Override
    public void changedSelection(IViewEdge iViewEdge, boolean bl2) {
        ZyGraphEdge.access$300(this.this$0).setSelected(bl2);
        ZyGraphEdge.access$400(this.this$0);
    }

    @Override
    public void changedSourceX(CViewEdge cViewEdge, double d2) {
        t t2 = ZyGraphEdge.access$300(this.this$0).getSourcePoint();
        ZyGraphEdge.access$300(this.this$0).setSourcePoint(new t(d2, t2.b));
        ZyGraphEdge.access$400(this.this$0);
    }

    @Override
    public void changedSourceY(CViewEdge cViewEdge, double d2) {
        t t2 = ZyGraphEdge.access$300(this.this$0).getSourcePoint();
        ZyGraphEdge.access$300(this.this$0).setSourcePoint(new t(t2.a, d2));
        ZyGraphEdge.access$400(this.this$0);
    }

    @Override
    public void changedTargetX(CViewEdge cViewEdge, double d2) {
        t t2 = ZyGraphEdge.access$300(this.this$0).getTargetPoint();
        ZyGraphEdge.access$300(this.this$0).setTargetPoint(new t(d2, t2.b));
        ZyGraphEdge.access$400(this.this$0);
    }

    @Override
    public void changedTargetY(CViewEdge cViewEdge, double d2) {
        t t2 = ZyGraphEdge.access$300(this.this$0).getTargetPoint();
        ZyGraphEdge.access$300(this.this$0).setTargetPoint(new t(t2.a, d2));
        ZyGraphEdge.access$400(this.this$0);
    }

    @Override
    public void changedType(CViewEdge cViewEdge, EdgeType edgeType) {
    }

    @Override
    public void changedVisibility(IViewEdge iViewEdge, boolean bl2) {
        if (!bl2) {
            if (ZyGraphEdge.access$800(this.this$0).a() != ZyGraphEdge.access$700(this.this$0)) return;
            ZyGraphEdge.access$700(this.this$0).a(ZyGraphEdge.access$800(this.this$0));
            return;
        }
        q q2 = ZyGraphEdge.access$500(this.this$0).getNode();
        q q3 = ZyGraphEdge.access$600(this.this$0).getNode();
        if (q2.e() == null) return;
        if (q3.e() == null) {
            return;
        }
        v v2 = ZyGraphEdge.access$700(this.this$0).C();
        d d2 = v2.a(q2, q3);
        ZyGraphEdge.access$700(this.this$0).a(d2, (aB)ZyGraphEdge.access$300(this.this$0));
        ZyGraphEdge.access$802(this.this$0, d2);
    }

    @Override
    public void changedVisibility(ZyEdgeRealizer zyEdgeRealizer) {
        ZyGraphEdge.access$100(this.this$0).setVisible(zyEdgeRealizer.isVisible());
    }

    @Override
    public void changedX(CBend cBend, double d2) {
        int n2 = ZyGraphEdge.access$100(this.this$0).getBends().indexOf(cBend);
        x x2 = ZyGraphEdge.access$300(this.this$0).getBend(n2);
        x2.a(d2, x2.c());
    }

    @Override
    public void changedY(CBend cBend, double d2) {
        int n2 = ZyGraphEdge.access$100(this.this$0).getBends().indexOf(cBend);
        x x2 = ZyGraphEdge.access$300(this.this$0).getBend(n2);
        x2.a(x2.b(), d2);
    }

    @Override
    public void clearedBends() {
        Iterator iterator = ZyGraphEdge.access$100(this.this$0).getBends().iterator();
        do {
            if (!iterator.hasNext()) {
                ZyGraphEdge.access$100(this.this$0).clearBends();
                return;
            }
            CBend cBend = (CBend)iterator.next();
            cBend.removeListener(this);
        } while (true);
    }

    @Override
    public void clearedBends(IViewEdge iViewEdge) {
        if (ZyGraphEdge.access$300(this.this$0).bendCount() == 0) return;
        ZyGraphEdge.access$300(this.this$0).clearBends();
    }

    @Override
    public void insertedBend(int n2, double d2, double d3) {
        if (ZyGraphEdge.access$300(this.this$0).bendCount() == ZyGraphEdge.access$100(this.this$0).getBendCount()) {
            return;
        }
        ZyGraphEdge.access$100(this.this$0).insertBend(n2, d2, d3);
    }

    @Override
    public void insertedBend(IViewEdge iViewEdge, int n2, CBend cBend) {
        Preconditions.checkNotNull(iViewEdge, "Edge cannot be null");
        Preconditions.checkNotNull(cBend, "Error: bend argument can not be null");
        cBend.addListener(ZyGraphEdge.access$200(this.this$0));
        if (ZyGraphEdge.access$300(this.this$0).bendCount() == iViewEdge.getBendCount()) {
            return;
        }
        if (iViewEdge != this) return;
        ZyGraphEdge.access$300(this.this$0).insertBend(cBend.getX(), cBend.getY());
    }

    @Override
    public void regenerated(ZyEdgeRealizer zyEdgeRealizer) {
    }

    @Override
    public void removedBend(CViewEdge cViewEdge, int n2, CBend cBend) {
        cBend.removeListener(ZyGraphEdge.access$200(this.this$0));
        if (ZyGraphEdge.access$300(this.this$0).bendCount() == ZyGraphEdge.access$100(this.this$0).getBendCount()) {
            return;
        }
        ZyGraphEdge.access$300(this.this$0).removeBend(ZyGraphEdge.access$300(this.this$0).getBend(n2));
    }

    @Override
    public void removedBend(ZyEdgeRealizer zyEdgeRealizer, int n2) {
        ZyGraphEdge.access$100(this.this$0).removeBend(n2);
    }

    /* synthetic */ ZyGraphEdge$InternalListener(ZyGraphEdge zyGraphEdge, ZyGraphEdge$1 zyGraphEdge$1) {
        this(zyGraphEdge);
    }
}

