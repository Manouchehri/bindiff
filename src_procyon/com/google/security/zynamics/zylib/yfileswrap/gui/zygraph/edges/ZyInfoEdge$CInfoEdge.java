package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.security.zynamics.zylib.general.*;
import java.util.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;

class ZyInfoEdge$CInfoEdge implements IViewEdge
{
    private final List m_bends;
    private final ListenerProvider m_listeners;
    
    private ZyInfoEdge$CInfoEdge() {
        this.m_bends = new ArrayList();
        this.m_listeners = new ListenerProvider();
    }
    
    @Override
    public void addBend(final double n, final double n2) {
        final CBend cBend = new CBend(n, n2);
        this.m_bends.add(cBend);
        for (final IViewEdgeListener viewEdgeListener : this.m_listeners) {
            try {
                viewEdgeListener.addedBend(this, cBend);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void addListener(final IViewEdgeListener viewEdgeListener) {
        this.m_listeners.addListener(viewEdgeListener);
    }
    
    @Override
    public void clearBends() {
        this.m_bends.clear();
        for (final IViewEdgeListener viewEdgeListener : this.m_listeners) {
            try {
                viewEdgeListener.clearedBends(this);
            }
            catch (Exception ex) {
                ex.printStackTrace();
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
    public void insertBend(final int n, final double n2, final double n3) {
        final CBend cBend = new CBend(n2, n3);
        this.m_bends.add(n, cBend);
        for (final IViewEdgeListener viewEdgeListener : this.m_listeners) {
            try {
                viewEdgeListener.insertedBend(this, n, cBend);
            }
            catch (Exception ex) {
                ex.printStackTrace();
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
    public void removeBend(final int n) {
        this.m_bends.remove(n);
    }
    
    @Override
    public void removeListener(final IViewEdgeListener viewEdgeListener) {
        this.m_listeners.removeListener(viewEdgeListener);
    }
    
    @Override
    public void setColor(final Color color) {
    }
    
    @Override
    public void setEdgeType(final EdgeType edgeType) {
    }
    
    @Override
    public void setId(final int n) {
    }
    
    @Override
    public void setSelected(final boolean b) {
    }
    
    @Override
    public void setVisible(final boolean b) {
    }
    
    @Override
    public void setX1(final double n) {
    }
    
    @Override
    public void setX2(final double n) {
    }
    
    @Override
    public void setY1(final double n) {
    }
    
    @Override
    public void setY2(final double n) {
    }
}
