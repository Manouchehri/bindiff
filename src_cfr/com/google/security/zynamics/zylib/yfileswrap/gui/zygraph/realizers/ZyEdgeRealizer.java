/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEdgeRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEdgeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeLabel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Iterator;
import y.d.t;
import y.h.aA;
import y.h.dr;
import y.h.fJ;
import y.h.h;
import y.h.x;

public class ZyEdgeRealizer
extends fJ
implements IZyEdgeRealizer {
    private ZyEdgeData m_edgeData;
    private IEdgeRealizerUpdater m_updater;
    private boolean m_drawSloppyEdges = true;
    private boolean m_drawBends = false;
    private boolean m_isHighlighted = false;
    private boolean m_isSloppyPainting = false;
    private final ListenerProvider m_listeners = new ListenerProvider();
    private ZyLabelContent m_content;

    public ZyEdgeRealizer(ZyLabelContent zyLabelContent, IEdgeRealizerUpdater iEdgeRealizerUpdater) {
        Preconditions.checkNotNull(zyLabelContent, "Internal Error: Content cannot be null");
        this.m_content = zyLabelContent;
        this.setArrow(h.b);
        this.setSmoothedBends(true);
        if (zyLabelContent.getLineCount() > 0) {
            this.addLabel(new ZyEdgeLabel(zyLabelContent));
        }
        this.setUpdater(iEdgeRealizerUpdater);
    }

    private void notifyLocationChanged() {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyEdgeRealizerListener iZyEdgeRealizerListener = (IZyEdgeRealizerListener)iterator.next();
            try {
                iZyEdgeRealizerListener.changedLocation(this);
            }
            catch (Exception var3_3) {
                var3_3.printStackTrace();
                continue;
            }
        }
    }

    @Override
    protected void paintHighlightedBends(Graphics2D graphics2D) {
        if (!this.m_drawBends) return;
        if (this.m_isSloppyPainting) return;
        super.paintHighlightedBends(graphics2D);
    }

    public void addListener(IZyEdgeRealizerListener iZyEdgeRealizerListener) {
        this.m_listeners.addListener(iZyEdgeRealizerListener);
    }

    public void addSilent(double d2, double d3) {
        super.appendBend(d2, d3);
    }

    @Override
    public x appendBend(double d2, double d3) {
        x x2 = super.appendBend(d2, d3);
        x2.a(this.isSelected());
        return x2;
    }

    @Override
    public void bendChanged(x x2, double d2, double d3) {
        int n2 = this.bendPos(x2);
        super.bendChanged(x2, d2, d3);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyEdgeRealizerListener iZyEdgeRealizerListener = (IZyEdgeRealizerListener)iterator.next();
            try {
                iZyEdgeRealizerListener.bendChanged(n2, x2.b(), x2.c());
            }
            catch (Exception var9_7) {
                var9_7.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void clearBends() {
        super.clearBends();
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyEdgeRealizerListener iZyEdgeRealizerListener = (IZyEdgeRealizerListener)iterator.next();
            try {
                iZyEdgeRealizerListener.clearedBends();
            }
            catch (Exception var3_3) {
                var3_3.printStackTrace();
                continue;
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
    public void paint(Graphics2D graphics2D) {
        this.m_content.setSloppy(false);
        this.m_isSloppyPainting = false;
        super.paint(graphics2D);
    }

    @Override
    public void paintBends(Graphics2D graphics2D) {
    }

    @Override
    public void paintPorts(Graphics2D graphics2D) {
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D) {
        this.m_isSloppyPainting = true;
        this.m_content.setSloppy(true);
        if (!this.m_drawSloppyEdges) {
            return;
        }
        if (!this.isSelected() && !this.m_isHighlighted) {
            super.paintSloppy(graphics2D);
            return;
        }
        dr dr2 = this.getLineType();
        Color color = ZyEdgeRealizer.getSelectionColor();
        this.setLineType(dr.e);
        ZyEdgeRealizer.setSelectionColor(this.getLineColor());
        super.paint(graphics2D);
        this.setLineType(dr2);
        ZyEdgeRealizer.setSelectionColor(color);
    }

    @Override
    public void regenerate() {
        this.m_content = this.m_updater.generateContent(this);
        this.removeLabel(this.getLabel());
        if (this.m_content.getLineCount() > 0) {
            this.addLabel(new ZyEdgeLabel(this.m_content));
        }
        Iterator iterator = this.m_listeners.iterator();
        do {
            if (!iterator.hasNext()) {
                this.getLabel().repaint();
                this.repaint();
                return;
            }
            IZyEdgeRealizerListener iZyEdgeRealizerListener = (IZyEdgeRealizerListener)iterator.next();
            try {
                iZyEdgeRealizerListener.regenerated(this);
            }
            catch (Exception var3_3) {
                var3_3.printStackTrace();
                continue;
            }
            break;
        } while (true);
    }

    @Override
    public void reInsertBend(x x2, x x3, int n2) {
        int n3 = this.bendPos(x3) + n2 == 1 || x3 == null ? 0 : 1;
        super.reInsertBend(x2, x3, n2);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyEdgeRealizerListener iZyEdgeRealizerListener = (IZyEdgeRealizerListener)iterator.next();
            try {
                iZyEdgeRealizerListener.insertedBend(n3, x2.b(), x2.c());
            }
            catch (Exception var7_7) {
                var7_7.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public x removeBend(x x2) {
        int n2 = this.bendPos(x2);
        x x3 = super.removeBend(x2);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyEdgeRealizerListener iZyEdgeRealizerListener = (IZyEdgeRealizerListener)iterator.next();
            try {
                iZyEdgeRealizerListener.removedBend(this, n2);
            }
            catch (Exception var6_6) {
                var6_6.printStackTrace();
                continue;
            }
        }
        return x3;
    }

    public void removeListener(IZyEdgeRealizerListener iZyEdgeRealizerListener) {
        this.m_listeners.removeListener(iZyEdgeRealizerListener);
    }

    public void setDrawBends(boolean bl2) {
        this.m_drawBends = bl2;
    }

    public void setDrawSloppyEdges(boolean bl2) {
        this.m_drawSloppyEdges = bl2;
    }

    @Override
    public void setLineType(dr dr2) {
        this.m_isHighlighted = dr2 == dr.e || dr2 == dr.l || dr2 == dr.q || dr2 == dr.v;
        super.setLineType(dr2);
    }

    @Override
    public void setSelected(boolean bl2) {
        super.setSelected(bl2);
        int n2 = 0;
        while (n2 < this.bendCount()) {
            this.getBend(n2).a(bl2);
            ++n2;
        }
    }

    @Override
    public void setSourcePoint(t t2) {
        super.setSourcePoint(t2);
        this.notifyLocationChanged();
    }

    @Override
    public void setTargetPoint(t t2) {
        super.setTargetPoint(t2);
        this.notifyLocationChanged();
    }

    public void setUpdater(IEdgeRealizerUpdater iEdgeRealizerUpdater) {
        this.m_updater = iEdgeRealizerUpdater;
        if (iEdgeRealizerUpdater == null) return;
        iEdgeRealizerUpdater.setRealizer(this);
    }

    public void setUserData(ZyEdgeData zyEdgeData) {
        this.m_edgeData = zyEdgeData;
    }

    @Override
    public void setVisible(boolean bl2) {
        super.setVisible(bl2);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyEdgeRealizerListener iZyEdgeRealizerListener = (IZyEdgeRealizerListener)iterator.next();
            try {
                iZyEdgeRealizerListener.changedVisibility(this);
            }
            catch (Exception var4_4) {
                var4_4.printStackTrace();
                continue;
            }
        }
    }
}

