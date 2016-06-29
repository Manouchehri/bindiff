/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IBendListener;
import java.util.Iterator;

public class CBend {
    private double m_x;
    private double m_y;
    private final ListenerProvider m_listeners = new ListenerProvider();

    public CBend(double d2, double d3) {
        this.m_x = d2;
        this.m_y = d3;
    }

    public void addListener(IBendListener iBendListener) {
        this.m_listeners.addListener(iBendListener);
    }

    public boolean equals(Object object) {
        if (!(object instanceof CBend)) {
            return false;
        }
        CBend cBend = (CBend)object;
        if (Double.compare(cBend.m_x, this.m_x) != 0) return false;
        if (Double.compare(cBend.m_y, this.m_y) != 0) return false;
        return true;
    }

    public double getX() {
        return this.m_x;
    }

    public double getY() {
        return this.m_y;
    }

    public void removeListener(IBendListener iBendListener) {
        this.m_listeners.removeListener(iBendListener);
    }

    public void setX(double d2) {
        if (Double.compare(this.m_x, d2) == 0) {
            return;
        }
        this.m_x = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IBendListener iBendListener = (IBendListener)iterator.next();
            iBendListener.changedX(this, d2);
        }
    }

    public void setY(double d2) {
        if (Double.compare(this.m_y, d2) == 0) {
            return;
        }
        this.m_y = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IBendListener iBendListener = (IBendListener)iterator.next();
            iBendListener.changedY(this, d2);
        }
    }
}

