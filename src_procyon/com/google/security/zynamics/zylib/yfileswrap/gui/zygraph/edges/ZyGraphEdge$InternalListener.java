package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import y.d.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import y.c.*;
import com.google.common.base.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;

class ZyGraphEdge$InternalListener implements IBendListener, IViewEdgeListener, IZyEdgeRealizerListener
{
    final /* synthetic */ ZyGraphEdge this$0;
    
    private ZyGraphEdge$InternalListener(final ZyGraphEdge this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void addedBend(final double n, final double n2) {
        this.this$0.m_rawEdge.addBend(n, n2);
    }
    
    @Override
    public void addedBend(final IViewEdge viewEdge, final CBend cBend) {
        cBend.addListener(this.this$0.m_listener);
        if (this.this$0.m_realizer.bendCount() == viewEdge.getBendCount()) {
            return;
        }
        this.this$0.m_realizer.appendBend(cBend.getX(), cBend.getY());
    }
    
    @Override
    public void bendChanged(final int n, final double x, final double y) {
        final CBend cBend = this.this$0.m_rawEdge.getBends().get(n);
        cBend.setX(x);
        cBend.setY(y);
    }
    
    @Override
    public void changedColor(final CViewEdge cViewEdge, final Color lineColor) {
        this.this$0.m_realizer.setLineColor(lineColor);
        this.this$0.updateViews();
    }
    
    @Override
    public void changedLocation(final ZyEdgeRealizer zyEdgeRealizer) {
        final t sourcePoint = zyEdgeRealizer.getSourcePoint();
        this.this$0.m_rawEdge.setX1(sourcePoint.a);
        this.this$0.m_rawEdge.setY1(sourcePoint.b);
        final t targetPoint = zyEdgeRealizer.getTargetPoint();
        this.this$0.m_rawEdge.setX2(targetPoint.a);
        this.this$0.m_rawEdge.setY2(targetPoint.b);
    }
    
    @Override
    public void changedSelection(final IViewEdge viewEdge, final boolean selected) {
        this.this$0.m_realizer.setSelected(selected);
        this.this$0.updateViews();
    }
    
    @Override
    public void changedSourceX(final CViewEdge cViewEdge, final double n) {
        this.this$0.m_realizer.setSourcePoint(new t(n, this.this$0.m_realizer.getSourcePoint().b));
        this.this$0.updateViews();
    }
    
    @Override
    public void changedSourceY(final CViewEdge cViewEdge, final double n) {
        this.this$0.m_realizer.setSourcePoint(new t(this.this$0.m_realizer.getSourcePoint().a, n));
        this.this$0.updateViews();
    }
    
    @Override
    public void changedTargetX(final CViewEdge cViewEdge, final double n) {
        this.this$0.m_realizer.setTargetPoint(new t(n, this.this$0.m_realizer.getTargetPoint().b));
        this.this$0.updateViews();
    }
    
    @Override
    public void changedTargetY(final CViewEdge cViewEdge, final double n) {
        this.this$0.m_realizer.setTargetPoint(new t(this.this$0.m_realizer.getTargetPoint().a, n));
        this.this$0.updateViews();
    }
    
    @Override
    public void changedType(final CViewEdge cViewEdge, final EdgeType edgeType) {
    }
    
    @Override
    public void changedVisibility(final IViewEdge viewEdge, final boolean b) {
        if (b) {
            final q node = this.this$0.m_sourceNode.getNode();
            final q node2 = this.this$0.m_targetNode.getNode();
            if (node.e() == null || node2.e() == null) {
                return;
            }
            final d a = this.this$0.m_graph.C().a(node, node2);
            this.this$0.m_graph.a(a, this.this$0.m_realizer);
            this.this$0.m_edge = a;
        }
        else if (this.this$0.m_edge.a() == this.this$0.m_graph) {
            this.this$0.m_graph.a(this.this$0.m_edge);
        }
    }
    
    @Override
    public void changedVisibility(final ZyEdgeRealizer zyEdgeRealizer) {
        this.this$0.m_rawEdge.setVisible(zyEdgeRealizer.isVisible());
    }
    
    @Override
    public void changedX(final CBend cBend, final double n) {
        final x bend = this.this$0.m_realizer.getBend(this.this$0.m_rawEdge.getBends().indexOf(cBend));
        bend.a(n, bend.c());
    }
    
    @Override
    public void changedY(final CBend cBend, final double n) {
        final x bend = this.this$0.m_realizer.getBend(this.this$0.m_rawEdge.getBends().indexOf(cBend));
        bend.a(bend.b(), n);
    }
    
    @Override
    public void clearedBends() {
        final Iterator<CBend> iterator = this.this$0.m_rawEdge.getBends().iterator();
        while (iterator.hasNext()) {
            iterator.next().removeListener(this);
        }
        this.this$0.m_rawEdge.clearBends();
    }
    
    @Override
    public void clearedBends(final IViewEdge viewEdge) {
        if (this.this$0.m_realizer.bendCount() != 0) {
            this.this$0.m_realizer.clearBends();
        }
    }
    
    @Override
    public void insertedBend(final int n, final double n2, final double n3) {
        if (this.this$0.m_realizer.bendCount() == this.this$0.m_rawEdge.getBendCount()) {
            return;
        }
        this.this$0.m_rawEdge.insertBend(n, n2, n3);
    }
    
    @Override
    public void insertedBend(final IViewEdge viewEdge, final int n, final CBend cBend) {
        Preconditions.checkNotNull(viewEdge, (Object)"Edge cannot be null");
        Preconditions.checkNotNull(cBend, (Object)"Error: bend argument can not be null");
        cBend.addListener(this.this$0.m_listener);
        if (this.this$0.m_realizer.bendCount() == viewEdge.getBendCount()) {
            return;
        }
        if (viewEdge == this) {
            this.this$0.m_realizer.insertBend(cBend.getX(), cBend.getY());
        }
    }
    
    @Override
    public void regenerated(final ZyEdgeRealizer zyEdgeRealizer) {
    }
    
    @Override
    public void removedBend(final CViewEdge cViewEdge, final int n, final CBend cBend) {
        cBend.removeListener(this.this$0.m_listener);
        if (this.this$0.m_realizer.bendCount() == this.this$0.m_rawEdge.getBendCount()) {
            return;
        }
        this.this$0.m_realizer.removeBend(this.this$0.m_realizer.getBend(n));
    }
    
    @Override
    public void removedBend(final ZyEdgeRealizer zyEdgeRealizer, final int n) {
        this.this$0.m_rawEdge.removeBend(n);
    }
}
