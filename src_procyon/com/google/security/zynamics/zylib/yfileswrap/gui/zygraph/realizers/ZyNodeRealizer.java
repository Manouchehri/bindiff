package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;
import y.d.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import y.h.*;
import java.awt.geom.*;
import java.awt.*;
import com.google.common.base.*;

public abstract class ZyNodeRealizer extends gn implements IZyNodeRealizer
{
    private ZyNodeData m_userData;
    private IRealizerUpdater m_updater;
    private final ListenerProvider m_listeners;
    protected boolean m_isHighLighted;
    
    public ZyNodeRealizer() {
        this.m_listeners = new ListenerProvider();
        this.m_isHighLighted = false;
    }
    
    private void notifyLocationChanged(final double n, final double n2) {
        for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
            try {
                zyNodeRealizerListener.changedLocation(this, n, n2);
            }
            catch (Exception ex) {}
        }
    }
    
    protected void notifyHasRegenerated() {
        for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
            try {
                zyNodeRealizerListener.regenerated(this);
            }
            catch (Exception ex) {}
        }
    }
    
    protected void scalePortCoordinates(final q q, final double n, final double n2, final double n3, final double n4) {
        final bu bu = (bu)q.e();
        final double n5 = (n > 0.0) ? (n2 / n) : 1.0;
        final double n6 = (n3 > 0.0) ? (n4 / n3) : 1.0;
        for (d d = q.f(); d != null; d = d.g()) {
            final fL sourcePort = bu.i(d).getSourcePort();
            final double n7 = sourcePort.g() * n5;
            final double n8 = sourcePort.h() * n6;
            sourcePort.b(n7, n8);
            bu.a(d, new t(n7, n8));
        }
        for (d d2 = q.g(); d2 != null; d2 = d2.h()) {
            final fL targetPort = bu.i(d2).getTargetPort();
            final double n9 = targetPort.g() * n5;
            final double n10 = targetPort.h() * n6;
            targetPort.b(n9, n10);
            bu.b(d2, new t(n9, n10));
        }
    }
    
    @Override
    public void addListener(final IZyNodeRealizerListener zyNodeRealizerListener) {
        this.m_listeners.addListener(zyNodeRealizerListener);
    }
    
    @Override
    public abstract ZyLabelContent getNodeContent();
    
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
        super.moveBy(n, n2);
        this.notifyLocationChanged(this.getX(), this.getY());
    }
    
    @Override
    public void paintSloppy(final Graphics2D graphics2D) {
        if (this.isSelected() || this.m_isHighLighted) {
            final dr lineType = this.getLineType();
            this.setLineType(dr.e);
            this.paintFilledShape(graphics2D);
            this.paintShapeBorder(graphics2D);
            this.setLineType(lineType);
        }
        else {
            this.paintFilledShape(graphics2D);
            this.paintShapeBorder(graphics2D);
        }
    }
    
    @Override
    public int positionToRow(final double n) {
        final ZyLabelContent nodeContent = this.getNodeContent();
        final int n2 = (int)((n / (this.getHeight() / this.getNodeContent().getBounds().getHeight()) - nodeContent.getPaddingTop()) / nodeContent.getLineHeight());
        return (n2 >= nodeContent.getLineCount()) ? -1 : n2;
    }
    
    @Override
    public void regenerate() {
        final ZyLabelContent nodeContent = this.getNodeContent();
        final double width = nodeContent.getBounds().getWidth();
        final double height = nodeContent.getBounds().getHeight();
        if (this.m_updater != null) {
            this.m_updater.generateContent(this, nodeContent);
        }
        final Rectangle2D bounds = nodeContent.getBounds();
        this.setSize(bounds.getWidth(), bounds.getHeight());
        this.scalePortCoordinates(this.getNode(), width, bounds.getWidth(), height, bounds.getHeight());
        this.notifyHasRegenerated();
        this.repaint();
    }
    
    @Override
    public void removeListener(final IZyNodeRealizerListener zyNodeRealizerListener) {
        this.m_listeners.removeListener(zyNodeRealizerListener);
    }
    
    @Override
    public double rowToPosition(final int n) {
        final ZyLabelContent nodeContent = this.getNodeContent();
        return nodeContent.getPaddingTop() + n * nodeContent.getLineHeight();
    }
    
    @Override
    public void setCenter(final double n, final double n2) {
        super.setCenter(n, n2);
        this.notifyLocationChanged(this.getX(), this.getY());
    }
    
    @Override
    public void setFillColor(final Color fillColor) {
        if (super.getFillColor() != fillColor) {
            super.setFillColor(fillColor);
            this.updateContentSelectionColor();
        }
    }
    
    @Override
    public void setLineType(final dr lineType) {
        this.m_isHighLighted = (lineType == dr.e || lineType == dr.l || lineType == dr.q || lineType == dr.v);
        super.setLineType(lineType);
    }
    
    @Override
    public void setLocation(final double n, final double n2) {
        super.setLocation(n, n2);
        this.notifyLocationChanged(n, n2);
    }
    
    @Override
    public void setSelected(final boolean selected) {
        if (super.isSelected() != selected) {
            super.setSelected(selected);
            this.updateContentSelectionColor();
            for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
                try {
                    zyNodeRealizerListener.changedSelection(this);
                }
                catch (Exception ex) {}
            }
        }
    }
    
    @Override
    public void setSize(final double n, final double n2) {
        if (super.getX() != n || super.getY() != n2) {
            super.setSize(n, n2);
            for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
                try {
                    zyNodeRealizerListener.changedSize(this, n, n2);
                }
                catch (Exception ex) {}
            }
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
        this.m_userData = userData;
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (super.isVisible() != visible) {
            super.setVisible(visible);
            this.updateContentSelectionColor();
            for (final IZyNodeRealizerListener zyNodeRealizerListener : this.m_listeners) {
                try {
                    zyNodeRealizerListener.changedVisibility(this);
                }
                catch (Exception ex) {}
            }
        }
    }
    
    @Override
    public void updateContentSelectionColor() {
        final ZyLabelContent nodeContent = this.getNodeContent();
        if (nodeContent.isSelectable()) {
            nodeContent.updateContentSelectionColor(this.getFillColor(), this.isSelected());
        }
    }
}
