package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.general.*;
import java.awt.geom.*;
import y.h.a.*;
import y.c.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.common.base.*;

public class ZyGroupNodeRealizer extends p implements IZyNodeRealizer
{
    private static final byte SHADOW_SIZE = 8;
    private static final Color SHADOW_COLOR;
    private final ZyLabelContent m_content;
    private ZyNodeData m_userData;
    private IRealizerUpdater m_updater;
    private final ListenerProvider m_listeners;
    
    public ZyGroupNodeRealizer(final ZyLabelContent content, final boolean groupClosed) {
        this.m_listeners = new ListenerProvider();
        this.setShapeType((byte)1);
        this.setLineType(dr.b);
        this.setDropShadowOffsetX((byte)8);
        this.setDropShadowOffsetY((byte)8);
        this.setDropShadowColor(ZyGroupNodeRealizer.SHADOW_COLOR);
        this.m_content = content;
        final Rectangle2D bounds = this.getNodeContent().getBounds();
        this.setSize(bounds.getWidth(), bounds.getHeight());
        this.setGroupClosed(groupClosed);
    }
    
    private void addChildren(final v v, final q q, final y y) {
        final x p3 = v.p(q);
        while (p3.f()) {
            final q e = p3.e();
            if (v.k(e)) {
                this.addChildren(v, e, y);
            }
            else {
                y.add(e);
            }
            p3.g();
        }
    }
    
    private void moveContent(final double n, final double n2) {
        final bu bu = (bu)this.m_userData.getNode().getNode().e();
        final v c = bu.C();
        final y y = new y();
        this.addChildren(c, this.getNode(), y);
        this.moveNodes(bu, y.a(), n, n2);
    }
    
    private void moveNodes(final bu bu, final x x, final double n, final double n2) {
        while (x.f()) {
            final fj t = bu.t(x.e());
            if (t.getAutoBoundsFeature() == null || !t.getAutoBoundsFeature().isAutoBoundsEnabled()) {
                t.moveBy(n, n2);
            }
            x.g();
        }
    }
    
    private void notifyLocationChanged(final double n, final double n2) {
        for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
            try {
                zyNodeRealizerListener.changedLocation(this, n, n2);
            }
            catch (Exception ex) {}
        }
    }
    
    @Override
    public void addListener(final IZyNodeRealizerListener zyNodeRealizerListener) {
        this.m_listeners.addListener(zyNodeRealizerListener);
    }
    
    @Override
    public ZyLabelContent getNodeContent() {
        return this.m_content;
    }
    
    @Override
    public fj getRealizer() {
        return this;
    }
    
    @Override
    public IRealizerUpdater getUpdater() {
        return this.m_updater;
    }
    
    @Override
    public ZyNodeData getUserData() {
        return this.m_userData;
    }
    
    @Override
    public void moveBy(final double n, final double n2) {
        this.moveContent(n, n2);
        super.moveBy(n, n2);
        this.notifyLocationChanged(this.getX(), this.getY());
    }
    
    @Override
    public void paintHotSpots(final Graphics2D graphics2D) {
    }
    
    public void paintNode(final Graphics2D graphics2D) {
        super.paintNode(graphics2D);
        if (((IGroupNode)this.m_userData.getNode().getRawNode()).isCollapsed()) {
            this.getNodeContent().draw(graphics2D, this.getX(), this.getY() + 8.0);
        }
    }
    
    @Override
    public int positionToRow(final double n) {
        return 0;
    }
    
    @Override
    public void regenerate() {
        this.m_updater.generateContent(this, this.m_content);
        final Rectangle2D bounds = this.m_content.getBounds();
        final double x = this.getX();
        final double y = this.getY();
        this.setSize(bounds.getWidth(), bounds.getHeight());
        this.setX(x);
        this.setY(y);
        for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
            try {
                zyNodeRealizerListener.regenerated(this);
            }
            catch (Exception ex) {}
        }
        this.repaint();
    }
    
    @Override
    public void removeListener(final IZyNodeRealizerListener zyNodeRealizerListener) {
        this.m_listeners.removeListener(zyNodeRealizerListener);
    }
    
    @Override
    public double rowToPosition(final int n) {
        return this.m_content.getPaddingTop() + n * this.m_content.getLineHeight();
    }
    
    @Override
    public void setCenter(final double n, final double n2) {
        super.setCenter(n, n2);
        this.notifyLocationChanged(n, n2);
    }
    
    @Override
    public void setCenterX(final double centerX) {
        super.setCenterX(centerX);
        this.notifyLocationChanged(centerX, this.y);
    }
    
    @Override
    public void setFillColor(final Color fillColor) {
        super.setFillColor(fillColor);
        this.updateContentSelectionColor();
    }
    
    @Override
    public void setGroupClosed(final boolean groupClosed) {
        super.setGroupClosed(groupClosed);
        if (groupClosed) {
            final Rectangle2D bounds = this.m_content.getBounds();
            this.setSize(bounds.getWidth(), bounds.getHeight());
        }
    }
    
    @Override
    public void setLocation(final double n, final double n2) {
        super.setLocation(n, n2);
        this.notifyLocationChanged(n, n2);
    }
    
    @Override
    public void setSelected(final boolean selected) {
        super.setSelected(selected);
        this.updateContentSelectionColor();
        for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
            try {
                zyNodeRealizerListener.changedSelection(this);
            }
            catch (Exception ex) {}
        }
    }
    
    @Override
    public void setUpdater(final IRealizerUpdater updater) {
        this.m_updater = updater;
        if (updater != null) {
            updater.setRealizer(this);
        }
    }
    
    @Override
    public void setUserData(final ZyNodeData userData) {
        Preconditions.checkNotNull(userData, (Object)"Error: Invalid node data");
        Preconditions.checkArgument(userData.getNode().getRawNode() instanceof IGroupNode, (Object)"Error: User data does not contain a group node");
        this.m_userData = userData;
    }
    
    @Override
    public void setVisible(final boolean visible) {
        super.setVisible(visible);
        this.updateContentSelectionColor();
        for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
            try {
                zyNodeRealizerListener.changedVisibility(this);
            }
            catch (Exception ex) {}
        }
    }
    
    @Override
    public void updateContentSelectionColor() {
        if (this.m_content.isSelectable()) {
            this.m_content.updateContentSelectionColor(this.getFillColor(), this.isSelected());
        }
    }
    
    static {
        SHADOW_COLOR = Color.GRAY;
    }
}
