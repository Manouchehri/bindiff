/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class CViewNode
implements IViewNode {
    private int m_id;
    private double m_x;
    private double m_y;
    private Color m_color;
    private Color m_borderColor;
    private boolean m_selected;
    private boolean m_visible;
    private final List m_incomingEdges = new ArrayList();
    private final List m_outgoingEdges = new ArrayList();
    private final ListenerProvider m_listeners = new ListenerProvider();
    private double m_height;
    private double m_width;

    public CViewNode(int n2, double d2, double d3, double d4, double d5, Color color, Color color2, boolean bl2, boolean bl3) {
        Preconditions.checkArgument(n2 >= -1, "Error: Node ID must be positive or -1 for unsaved nodes.");
        Preconditions.checkNotNull(color, "Error: Color argument can't be null");
        Preconditions.checkNotNull(color2, "Error: Border color argument can't be null");
        this.m_id = n2;
        this.m_x = d2;
        this.m_y = d3;
        this.m_height = d5;
        this.m_width = d4;
        this.m_color = color;
        this.m_borderColor = color2;
        this.m_selected = bl2;
        this.m_visible = bl3;
    }

    protected ListenerProvider getListeners() {
        return this.m_listeners;
    }

    public void addIncomingEdge(IViewEdge iViewEdge) {
        Preconditions.checkNotNull(iViewEdge, "Error: Edge argument can't be null");
        this.m_incomingEdges.add(iViewEdge);
    }

    @Override
    public void addListener(IViewNodeListener iViewNodeListener) {
        this.m_listeners.addListener(iViewNodeListener);
    }

    public void addOutgoingEdge(IViewEdge iViewEdge) {
        Preconditions.checkNotNull(iViewEdge, "Error: Edge argument can not be null");
        Preconditions.checkArgument(!this.m_outgoingEdges.contains(iViewEdge), "Error: Outgoing edge was added before");
        this.m_outgoingEdges.add(iViewEdge);
    }

    @Override
    public Color getBorderColor() {
        return new Color(this.m_borderColor.getRGB());
    }

    @Override
    public Color getColor() {
        return new Color(this.m_color.getRGB());
    }

    @Override
    public double getHeight() {
        return this.m_height;
    }

    @Override
    public int getId() {
        return this.m_id;
    }

    @Override
    public List getIncomingEdges() {
        return new ArrayList(this.m_incomingEdges);
    }

    @Override
    public List getOutgoingEdges() {
        return new ArrayList(this.m_outgoingEdges);
    }

    @Override
    public double getWidth() {
        return this.m_width;
    }

    @Override
    public double getX() {
        return this.m_x;
    }

    @Override
    public double getY() {
        return this.m_y;
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
        ArrayList<IViewNodeListener> arrayList = new ArrayList<IViewNodeListener>();
        for (IViewNodeListener iViewNodeListener2 : this.m_listeners) {
            arrayList.add(iViewNodeListener2);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            IViewNodeListener iViewNodeListener2;
            iViewNodeListener2 = (IViewNodeListener)iterator.next();
            this.m_listeners.removeListener(iViewNodeListener2);
        }
    }

    public void removeIncomingEdge(IViewEdge iViewEdge) {
        Preconditions.checkNotNull(iViewEdge, "Error: Edge argument can not be null");
        this.m_incomingEdges.remove(iViewEdge);
    }

    @Override
    public void removeListener(IViewNodeListener iViewNodeListener) {
        Preconditions.checkNotNull(iViewNodeListener, "Error: Listener argument can not be null");
        this.m_listeners.removeListener(iViewNodeListener);
    }

    public void removeOutgoingEdge(IViewEdge iViewEdge) {
        Preconditions.checkNotNull(iViewEdge, "Error: Edge argument can not be null");
        this.m_outgoingEdges.remove(iViewEdge);
    }

    @Override
    public void setBorderColor(Color color) {
        Preconditions.checkNotNull(color, "Error: Color argument can not be null");
        if (this.m_borderColor.equals(color)) {
            return;
        }
        this.m_borderColor = color;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewNodeListener iViewNodeListener = (IViewNodeListener)iterator.next();
            try {
                iViewNodeListener.changedBorderColor(this, color);
            }
            catch (Exception var4_4) {
                var4_4.printStackTrace();
                continue;
            }
        }
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
            IViewNodeListener iViewNodeListener = (IViewNodeListener)iterator.next();
            try {
                iViewNodeListener.changedColor(this, color);
            }
            catch (Exception var4_4) {
                var4_4.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void setHeight(double d2) {
        if (this.m_height == d2) {
            return;
        }
        this.m_height = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewNodeListener iViewNodeListener = (IViewNodeListener)iterator.next();
            try {
                iViewNodeListener.heightChanged(this, d2);
            }
            catch (Exception var5_4) {
                var5_4.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void setId(int n2) {
        this.m_id = n2;
    }

    @Override
    public void setSelected(boolean bl2) {
        if (bl2 == this.m_selected) {
            return;
        }
        this.m_selected = bl2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewNodeListener iViewNodeListener = (IViewNodeListener)iterator.next();
            try {
                iViewNodeListener.changedSelection(this, bl2);
            }
            catch (Exception var4_4) {
                var4_4.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void setVisible(boolean bl2) {
        if (bl2 == this.m_visible) {
            return;
        }
        this.m_visible = bl2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewNodeListener iViewNodeListener = (IViewNodeListener)iterator.next();
            try {
                iViewNodeListener.changedVisibility(this, this.isVisible());
            }
            catch (Exception var4_4) {
                var4_4.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void setWidth(double d2) {
        if (this.m_width == d2) {
            return;
        }
        this.m_width = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewNodeListener iViewNodeListener = (IViewNodeListener)iterator.next();
            try {
                iViewNodeListener.widthChanged(this, d2);
            }
            catch (Exception var5_4) {
                var5_4.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void setX(double d2) {
        if (this.m_x == d2) {
            return;
        }
        this.m_x = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewNodeListener iViewNodeListener = (IViewNodeListener)iterator.next();
            try {
                iViewNodeListener.xposChanged(this, d2);
            }
            catch (Exception var5_4) {
                var5_4.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void setY(double d2) {
        if (this.m_y == d2) {
            return;
        }
        this.m_y = d2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IViewNodeListener iViewNodeListener = (IViewNodeListener)iterator.next();
            try {
                iViewNodeListener.yposChanged(this, d2);
            }
            catch (Exception var5_4) {
                var5_4.printStackTrace();
                continue;
            }
        }
    }
}

