package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.awt.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import java.util.*;

public abstract class CViewNode implements IViewNode
{
    private int m_id;
    private double m_x;
    private double m_y;
    private Color m_color;
    private Color m_borderColor;
    private boolean m_selected;
    private boolean m_visible;
    private final List m_incomingEdges;
    private final List m_outgoingEdges;
    private final ListenerProvider m_listeners;
    private double m_height;
    private double m_width;
    
    public CViewNode(final int id, final double x, final double y, final double width, final double height, final Color color, final Color borderColor, final boolean selected, final boolean visible) {
        this.m_incomingEdges = new ArrayList();
        this.m_outgoingEdges = new ArrayList();
        this.m_listeners = new ListenerProvider();
        Preconditions.checkArgument(id >= -1, (Object)"Error: Node ID must be positive or -1 for unsaved nodes.");
        Preconditions.checkNotNull(color, (Object)"Error: Color argument can't be null");
        Preconditions.checkNotNull(borderColor, (Object)"Error: Border color argument can't be null");
        this.m_id = id;
        this.m_x = x;
        this.m_y = y;
        this.m_height = height;
        this.m_width = width;
        this.m_color = color;
        this.m_borderColor = borderColor;
        this.m_selected = selected;
        this.m_visible = visible;
    }
    
    protected ListenerProvider getListeners() {
        return this.m_listeners;
    }
    
    public void addIncomingEdge(final IViewEdge viewEdge) {
        Preconditions.checkNotNull(viewEdge, (Object)"Error: Edge argument can't be null");
        this.m_incomingEdges.add(viewEdge);
    }
    
    @Override
    public void addListener(final IViewNodeListener viewNodeListener) {
        this.m_listeners.addListener(viewNodeListener);
    }
    
    public void addOutgoingEdge(final IViewEdge viewEdge) {
        Preconditions.checkNotNull(viewEdge, (Object)"Error: Edge argument can not be null");
        Preconditions.checkArgument(!this.m_outgoingEdges.contains(viewEdge), (Object)"Error: Outgoing edge was added before");
        this.m_outgoingEdges.add(viewEdge);
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
        final ArrayList<IViewNodeListener> list = new ArrayList<IViewNodeListener>();
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.m_listeners.removeListener(iterator2.next());
        }
    }
    
    public void removeIncomingEdge(final IViewEdge viewEdge) {
        Preconditions.checkNotNull(viewEdge, (Object)"Error: Edge argument can not be null");
        this.m_incomingEdges.remove(viewEdge);
    }
    
    @Override
    public void removeListener(final IViewNodeListener viewNodeListener) {
        Preconditions.checkNotNull(viewNodeListener, (Object)"Error: Listener argument can not be null");
        this.m_listeners.removeListener(viewNodeListener);
    }
    
    public void removeOutgoingEdge(final IViewEdge viewEdge) {
        Preconditions.checkNotNull(viewEdge, (Object)"Error: Edge argument can not be null");
        this.m_outgoingEdges.remove(viewEdge);
    }
    
    @Override
    public void setBorderColor(final Color borderColor) {
        Preconditions.checkNotNull(borderColor, (Object)"Error: Color argument can not be null");
        if (this.m_borderColor.equals(borderColor)) {
            return;
        }
        this.m_borderColor = borderColor;
        for (final IViewNodeListener viewNodeListener : this.m_listeners) {
            try {
                viewNodeListener.changedBorderColor(this, borderColor);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void setColor(final Color color) {
        Preconditions.checkNotNull(color, (Object)"Error: Color argument can not be null");
        if (this.m_color.equals(color)) {
            return;
        }
        this.m_color = color;
        for (final IViewNodeListener viewNodeListener : this.m_listeners) {
            try {
                viewNodeListener.changedColor(this, color);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void setHeight(final double height) {
        if (this.m_height == height) {
            return;
        }
        this.m_height = height;
        for (final IViewNodeListener viewNodeListener : this.m_listeners) {
            try {
                viewNodeListener.heightChanged(this, height);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void setId(final int id) {
        this.m_id = id;
    }
    
    @Override
    public void setSelected(final boolean selected) {
        if (selected == this.m_selected) {
            return;
        }
        this.m_selected = selected;
        for (final IViewNodeListener viewNodeListener : this.m_listeners) {
            try {
                viewNodeListener.changedSelection(this, selected);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (visible == this.m_visible) {
            return;
        }
        this.m_visible = visible;
        for (final IViewNodeListener viewNodeListener : this.m_listeners) {
            try {
                viewNodeListener.changedVisibility(this, this.isVisible());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void setWidth(final double width) {
        if (this.m_width == width) {
            return;
        }
        this.m_width = width;
        for (final IViewNodeListener viewNodeListener : this.m_listeners) {
            try {
                viewNodeListener.widthChanged(this, width);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void setX(final double x) {
        if (this.m_x == x) {
            return;
        }
        this.m_x = x;
        for (final IViewNodeListener viewNodeListener : this.m_listeners) {
            try {
                viewNodeListener.xposChanged(this, x);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void setY(final double y) {
        if (this.m_y == y) {
            return;
        }
        this.m_y = y;
        for (final IViewNodeListener viewNodeListener : this.m_listeners) {
            try {
                viewNodeListener.yposChanged(this, y);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
