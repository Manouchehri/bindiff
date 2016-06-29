package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.general.*;
import java.util.*;

public class CBend
{
    private double m_x;
    private double m_y;
    private final ListenerProvider m_listeners;
    
    public CBend(final double x, final double y) {
        this.m_listeners = new ListenerProvider();
        this.m_x = x;
        this.m_y = y;
    }
    
    public void addListener(final IBendListener bendListener) {
        this.m_listeners.addListener(bendListener);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof CBend)) {
            return false;
        }
        final CBend cBend = (CBend)o;
        return Double.compare(cBend.m_x, this.m_x) == 0 && Double.compare(cBend.m_y, this.m_y) == 0;
    }
    
    public double getX() {
        return this.m_x;
    }
    
    public double getY() {
        return this.m_y;
    }
    
    public void removeListener(final IBendListener bendListener) {
        this.m_listeners.removeListener(bendListener);
    }
    
    public void setX(final double x) {
        if (Double.compare(this.m_x, x) == 0) {
            return;
        }
        this.m_x = x;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedX(this, x);
        }
    }
    
    public void setY(final double y) {
        if (Double.compare(this.m_y, y) == 0) {
            return;
        }
        this.m_y = y;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedY(this, y);
        }
    }
}
