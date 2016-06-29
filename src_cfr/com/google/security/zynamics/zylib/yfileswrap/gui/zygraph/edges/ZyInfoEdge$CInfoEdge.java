/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge$1;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class ZyInfoEdge$CInfoEdge
implements IViewEdge {
    private final List m_bends = new ArrayList();
    private final ListenerProvider m_listeners = new ListenerProvider();

    private ZyInfoEdge$CInfoEdge() {
    }

    @Override
    public void addBend(double d2, double d3) {
        CBend cBend = new CBend(d2, d3);
        this.m_bends.add(cBend);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            try {
                iViewEdgeListener.addedBend(this, cBend);
            }
            catch (Exception var8_6) {
                var8_6.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void addListener(IViewEdgeListener iViewEdgeListener) {
        this.m_listeners.addListener(iViewEdgeListener);
    }

    @Override
    public void clearBends() {
        this.m_bends.clear();
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            try {
                iViewEdgeListener.clearedBends(this);
            }
            catch (Exception var3_3) {
                var3_3.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public int getBendCount() {
        return this.m_bends.size();
    }

    @Override
    public List getBends() {
        return new ArrayList(this.m_bends);
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Object getSource() {
        return null;
    }

    @Override
    public Object getTarget() {
        return null;
    }

    @Override
    public EdgeType getType() {
        return EdgeType.TEXTNODE_EDGE;
    }

    @Override
    public double getX1() {
        return 0.0;
    }

    @Override
    public double getX2() {
        return 0.0;
    }

    @Override
    public double getY1() {
        return 0.0;
    }

    @Override
    public double getY2() {
        return 0.0;
    }

    @Override
    public void insertBend(int n2, double d2, double d3) {
        CBend cBend = new CBend(d2, d3);
        this.m_bends.add(n2, cBend);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            try {
                iViewEdgeListener.insertedBend(this, n2, cBend);
            }
            catch (Exception var9_7) {
                var9_7.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public void removeBend(int n2) {
        this.m_bends.remove(n2);
    }

    @Override
    public void removeListener(IViewEdgeListener iViewEdgeListener) {
        this.m_listeners.removeListener(iViewEdgeListener);
    }

    @Override
    public void setColor(Color color) {
    }

    @Override
    public void setEdgeType(EdgeType edgeType) {
    }

    @Override
    public void setId(int n2) {
    }

    @Override
    public void setSelected(boolean bl2) {
    }

    @Override
    public void setVisible(boolean bl2) {
    }

    @Override
    public void setX1(double d2) {
    }

    @Override
    public void setX2(double d2) {
    }

    @Override
    public void setY1(double d2) {
    }

    @Override
    public void setY2(double d2) {
    }

    /* synthetic */ ZyInfoEdge$CInfoEdge(ZyInfoEdge$1 zyInfoEdge$1) {
        this();
    }
}

