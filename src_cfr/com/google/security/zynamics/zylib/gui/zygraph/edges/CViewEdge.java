/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CViewEdge
implements IViewEdge {
    private final Object m_sourceNode;
    private final Object m_targetNode;
    private EdgeType m_type;
    private double m_x1;
    private double m_y1;
    private double m_x2;
    private double m_y2;
    private Color m_color;
    private boolean m_visible;
    private boolean m_selected;
    private int m_id;
    private final List m_paths;
    protected final ListenerProvider m_listeners = new ListenerProvider();

    public CViewEdge(int n2, Object object, Object object2, EdgeType edgeType, double d2, double d3, double d4, double d5, Color color, boolean bl2, boolean bl3, List list) {
        this.m_sourceNode = Preconditions.checkNotNull(object, "Error: Source node argument can't be null");
        this.m_targetNode = Preconditions.checkNotNull(object2, "Error: Target node argument can't be null");
        this.m_id = n2;
        this.m_type = edgeType;
        this.m_x1 = d2;
        this.m_y1 = d3;
        this.m_x2 = d4;
        this.m_y2 = d5;
        this.m_color = color;
        this.m_visible = bl3;
        this.m_selected = bl2;
        this.m_paths = list;
    }

    @Override
    public void addBend(double d2, double d3) {
        CBend cBend = new CBend(d2, d3);
        this.m_paths.add(cBend);
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
        this.m_paths.clear();
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
        return this.m_paths.size();
    }

    @Override
    public List getBends() {
        return new ArrayList(this.m_paths);
    }

    @Override
    public Color getColor() {
        return this.m_color;
    }

    @Override
    public int getId() {
        return this.m_id;
    }

    @Override
    public Object getSource() {
        return this.m_sourceNode;
    }

    @Override
    public Object getTarget() {
        return this.m_targetNode;
    }

    @Override
    public EdgeType getType() {
        return this.m_type;
    }

    @Override
    public double getX1() {
        return this.m_x1;
    }

    @Override
    public double getX2() {
        return this.m_x2;
    }

    @Override
    public double getY1() {
        return this.m_y1;
    }

    @Override
    public double getY2() {
        return this.m_y2;
    }

    @Override
    public void insertBend(int n2, double d2, double d3) {
        CBend cBend = new CBend(d2, d3);
        this.m_paths.add(n2, cBend);
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
        return this.m_selected;
    }

    @Override
    public boolean isVisible() {
        return this.m_visible;
    }

    public void removeAllListeners() {
        ArrayList<IViewEdgeListener> arrayList = new ArrayList<IViewEdgeListener>();
        for (IViewEdgeListener iViewEdgeListener2 : this.m_listeners) {
            arrayList.add(iViewEdgeListener2);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener2;
            iViewEdgeListener2 = (IViewEdgeListener)iterator.next();
            this.removeListener(iViewEdgeListener2);
        }
    }

    @Override
    public void removeBend(int n2) {
        CBend cBend = (CBend)this.m_paths.get(n2);
        this.m_paths.remove(n2);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.removedBend(this, n2, cBend);
        }
    }

    @Override
    public void removeListener(IViewEdgeListener iViewEdgeListener) {
        this.m_listeners.removeListener(iViewEdgeListener);
    }

    @Override
    public void setColor(Color color) {
        Preconditions.checkNotNull(color, "Error: Color argument can not be null");
        if (this.m_color.equals(color)) {
            return;
        }
        this.m_color = color;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.changedColor(this, color);
        }
    }

    @Override
    public void setEdgeType(EdgeType edgeType) {
        Preconditions.checkNotNull((Object)edgeType, "Error: Type argument can't be null");
        if (edgeType == this.m_type) {
            return;
        }
        this.m_type = edgeType;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.changedType(this, edgeType);
        }
    }

    @Override
    public void setId(int n2) {
        this.m_id = n2;
    }

    @Override
    public void setSelected(boolean bl2) {
        if (this.m_selected == bl2) {
            return;
        }
        this.m_selected = bl2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.changedSelection(this, bl2);
        }
    }

    @Override
    public void setVisible(boolean bl2) {
        if (this.m_visible == bl2) {
            return;
        }
        this.m_visible = bl2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.changedVisibility(this, this.m_visible);
        }
    }

    @Override
    public void setX1(double d2) {
        if (Double.compare(this.m_x1, d2) == 0) {
            return;
        }
        this.m_x1 = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.changedSourceX(this, d2);
        }
    }

    @Override
    public void setX2(double d2) {
        if (Double.compare(this.m_x2, d2) == 0) {
            return;
        }
        this.m_x2 = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.changedTargetX(this, d2);
        }
    }

    @Override
    public void setY1(double d2) {
        if (Double.compare(this.m_y1, d2) == 0) {
            return;
        }
        this.m_y1 = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.changedSourceY(this, d2);
        }
    }

    @Override
    public void setY2(double d2) {
        if (Double.compare(this.m_y2, d2) == 0) {
            return;
        }
        this.m_y2 = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewEdgeListener iViewEdgeListener = (IViewEdgeListener)iterator.next();
            iViewEdgeListener.changedTargetY(this, d2);
        }
    }
}

