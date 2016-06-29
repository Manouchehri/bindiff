package com.google.security.zynamics.zylib.gui.zygraph.edges;

import java.awt.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import java.util.*;

public class CViewEdge implements IViewEdge
{
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
    protected final ListenerProvider m_listeners;
    
    public CViewEdge(final int id, final Object o, final Object o2, final EdgeType type, final double x1, final double y1, final double x2, final double y2, final Color color, final boolean selected, final boolean visible, final List paths) {
        this.m_listeners = new ListenerProvider();
        this.m_sourceNode = Preconditions.checkNotNull(o, (Object)"Error: Source node argument can't be null");
        this.m_targetNode = Preconditions.checkNotNull(o2, (Object)"Error: Target node argument can't be null");
        this.m_id = id;
        this.m_type = type;
        this.m_x1 = x1;
        this.m_y1 = y1;
        this.m_x2 = x2;
        this.m_y2 = y2;
        this.m_color = color;
        this.m_visible = visible;
        this.m_selected = selected;
        this.m_paths = paths;
    }
    
    @Override
    public void addBend(final double n, final double n2) {
        final CBend cBend = new CBend(n, n2);
        this.m_paths.add(cBend);
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
        this.m_paths.clear();
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
    public void insertBend(final int n, final double n2, final double n3) {
        final CBend cBend = new CBend(n2, n3);
        this.m_paths.add(n, cBend);
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
        return this.m_selected;
    }
    
    @Override
    public boolean isVisible() {
        return this.m_visible;
    }
    
    public void removeAllListeners() {
        final ArrayList<IViewEdgeListener> list = new ArrayList<IViewEdgeListener>();
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.removeListener(iterator2.next());
        }
    }
    
    @Override
    public void removeBend(final int n) {
        final CBend cBend = this.m_paths.get(n);
        this.m_paths.remove(n);
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().removedBend(this, n, cBend);
        }
    }
    
    @Override
    public void removeListener(final IViewEdgeListener viewEdgeListener) {
        this.m_listeners.removeListener(viewEdgeListener);
    }
    
    @Override
    public void setColor(final Color color) {
        Preconditions.checkNotNull(color, (Object)"Error: Color argument can not be null");
        if (this.m_color.equals(color)) {
            return;
        }
        this.m_color = color;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedColor(this, color);
        }
    }
    
    @Override
    public void setEdgeType(final EdgeType type) {
        Preconditions.checkNotNull(type, (Object)"Error: Type argument can't be null");
        if (type == this.m_type) {
            return;
        }
        this.m_type = type;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedType(this, type);
        }
    }
    
    @Override
    public void setId(final int id) {
        this.m_id = id;
    }
    
    @Override
    public void setSelected(final boolean selected) {
        if (this.m_selected == selected) {
            return;
        }
        this.m_selected = selected;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedSelection(this, selected);
        }
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (this.m_visible == visible) {
            return;
        }
        this.m_visible = visible;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedVisibility(this, this.m_visible);
        }
    }
    
    @Override
    public void setX1(final double x1) {
        if (Double.compare(this.m_x1, x1) == 0) {
            return;
        }
        this.m_x1 = x1;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedSourceX(this, x1);
        }
    }
    
    @Override
    public void setX2(final double x2) {
        if (Double.compare(this.m_x2, x2) == 0) {
            return;
        }
        this.m_x2 = x2;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedTargetX(this, x2);
        }
    }
    
    @Override
    public void setY1(final double y1) {
        if (Double.compare(this.m_y1, y1) == 0) {
            return;
        }
        this.m_y1 = y1;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedSourceY(this, y1);
        }
    }
    
    @Override
    public void setY2(final double y2) {
        if (Double.compare(this.m_y2, y2) == 0) {
            return;
        }
        this.m_y2 = y2;
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedTargetY(this, y2);
        }
    }
}
