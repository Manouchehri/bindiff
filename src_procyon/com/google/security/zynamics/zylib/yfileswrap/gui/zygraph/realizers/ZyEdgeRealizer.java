package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;
import y.h.*;
import java.awt.*;
import y.d.*;

public class ZyEdgeRealizer extends fJ implements IZyEdgeRealizer
{
    private ZyEdgeData m_edgeData;
    private IEdgeRealizerUpdater m_updater;
    private boolean m_drawSloppyEdges;
    private boolean m_drawBends;
    private boolean m_isHighlighted;
    private boolean m_isSloppyPainting;
    private final ListenerProvider m_listeners;
    private ZyLabelContent m_content;
    
    public ZyEdgeRealizer(final ZyLabelContent content, final IEdgeRealizerUpdater updater) {
        this.m_drawSloppyEdges = true;
        this.m_drawBends = false;
        this.m_isHighlighted = false;
        this.m_isSloppyPainting = false;
        this.m_listeners = new ListenerProvider();
        Preconditions.checkNotNull(content, (Object)"Internal Error: Content cannot be null");
        this.m_content = content;
        this.setArrow(h.b);
        this.setSmoothedBends(true);
        if (content.getLineCount() > 0) {
            this.addLabel(new ZyEdgeLabel(content));
        }
        this.setUpdater(updater);
    }
    
    private void notifyLocationChanged() {
        for (final IZyEdgeRealizerListener zyEdgeRealizerListener : this.m_listeners) {
            try {
                zyEdgeRealizerListener.changedLocation(this);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    protected void paintHighlightedBends(final Graphics2D graphics2D) {
        if (this.m_drawBends && !this.m_isSloppyPainting) {
            super.paintHighlightedBends(graphics2D);
        }
    }
    
    public void addListener(final IZyEdgeRealizerListener zyEdgeRealizerListener) {
        this.m_listeners.addListener(zyEdgeRealizerListener);
    }
    
    public void addSilent(final double n, final double n2) {
        super.appendBend(n, n2);
    }
    
    @Override
    public x appendBend(final double n, final double n2) {
        final x appendBend = super.appendBend(n, n2);
        appendBend.a(this.isSelected());
        return appendBend;
    }
    
    @Override
    public void bendChanged(final x x, final double n, final double n2) {
        final int bendPos = this.bendPos(x);
        super.bendChanged(x, n, n2);
        for (final IZyEdgeRealizerListener zyEdgeRealizerListener : this.m_listeners) {
            try {
                zyEdgeRealizerListener.bendChanged(bendPos, x.b(), x.c());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void clearBends() {
        super.clearBends();
        for (final IZyEdgeRealizerListener zyEdgeRealizerListener : this.m_listeners) {
            try {
                zyEdgeRealizerListener.clearedBends();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public ZyLabelContent getEdgeLabelContent() {
        return this.m_content;
    }
    
    public ZyEdgeData getUserData() {
        return this.m_edgeData;
    }
    
    @Override
    public void paint(final Graphics2D graphics2D) {
        this.m_content.setSloppy(false);
        this.m_isSloppyPainting = false;
        super.paint(graphics2D);
    }
    
    public void paintBends(final Graphics2D graphics2D) {
    }
    
    public void paintPorts(final Graphics2D graphics2D) {
    }
    
    @Override
    public void paintSloppy(final Graphics2D graphics2D) {
        this.m_isSloppyPainting = true;
        this.m_content.setSloppy(true);
        if (!this.m_drawSloppyEdges) {
            return;
        }
        if (this.isSelected() || this.m_isHighlighted) {
            final dr lineType = this.getLineType();
            final Color selectionColor = aB.getSelectionColor();
            this.setLineType(dr.e);
            aB.setSelectionColor(this.getLineColor());
            super.paint(graphics2D);
            this.setLineType(lineType);
            aB.setSelectionColor(selectionColor);
        }
        else {
            super.paintSloppy(graphics2D);
        }
    }
    
    @Override
    public void regenerate() {
        this.m_content = this.m_updater.generateContent(this);
        this.removeLabel(this.getLabel());
        if (this.m_content.getLineCount() > 0) {
            this.addLabel(new ZyEdgeLabel(this.m_content));
        }
        for (final IZyEdgeRealizerListener zyEdgeRealizerListener : this.m_listeners) {
            try {
                zyEdgeRealizerListener.regenerated(this);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        this.getLabel().repaint();
        this.repaint();
    }
    
    @Override
    public void reInsertBend(final x x, final x x2, final int n) {
        final int n2 = (this.bendPos(x2) + n != 1 && x2 != null) ? 1 : 0;
        super.reInsertBend(x, x2, n);
        for (final IZyEdgeRealizerListener zyEdgeRealizerListener : this.m_listeners) {
            try {
                zyEdgeRealizerListener.insertedBend(n2, x.b(), x.c());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public x removeBend(final x x) {
        final int bendPos = this.bendPos(x);
        final x removeBend = super.removeBend(x);
        for (final IZyEdgeRealizerListener zyEdgeRealizerListener : this.m_listeners) {
            try {
                zyEdgeRealizerListener.removedBend(this, bendPos);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return removeBend;
    }
    
    public void removeListener(final IZyEdgeRealizerListener zyEdgeRealizerListener) {
        this.m_listeners.removeListener(zyEdgeRealizerListener);
    }
    
    public void setDrawBends(final boolean drawBends) {
        this.m_drawBends = drawBends;
    }
    
    public void setDrawSloppyEdges(final boolean drawSloppyEdges) {
        this.m_drawSloppyEdges = drawSloppyEdges;
    }
    
    @Override
    public void setLineType(final dr lineType) {
        this.m_isHighlighted = (lineType == dr.e || lineType == dr.l || lineType == dr.q || lineType == dr.v);
        super.setLineType(lineType);
    }
    
    @Override
    public void setSelected(final boolean selected) {
        super.setSelected(selected);
        for (int i = 0; i < this.bendCount(); ++i) {
            this.getBend(i).a(selected);
        }
    }
    
    @Override
    public void setSourcePoint(final t sourcePoint) {
        super.setSourcePoint(sourcePoint);
        this.notifyLocationChanged();
    }
    
    @Override
    public void setTargetPoint(final t targetPoint) {
        super.setTargetPoint(targetPoint);
        this.notifyLocationChanged();
    }
    
    public void setUpdater(final IEdgeRealizerUpdater updater) {
        this.m_updater = updater;
        if (updater != null) {
            updater.setRealizer(this);
        }
    }
    
    public void setUserData(final ZyEdgeData edgeData) {
        this.m_edgeData = edgeData;
    }
    
    @Override
    public void setVisible(final boolean visible) {
        super.setVisible(visible);
        for (final IZyEdgeRealizerListener zyEdgeRealizerListener : this.m_listeners) {
            try {
                zyEdgeRealizerListener.changedVisibility(this);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
