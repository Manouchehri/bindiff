/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import y.c.d;
import y.c.i;
import y.c.q;
import y.d.t;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.fL;
import y.h.gn;

public abstract class ZyNodeRealizer
extends gn
implements IZyNodeRealizer {
    private ZyNodeData m_userData;
    private IRealizerUpdater m_updater;
    private final ListenerProvider m_listeners = new ListenerProvider();
    protected boolean m_isHighLighted = false;

    private void notifyLocationChanged(double d2, double d3) {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.changedLocation(this, d2, d3);
            }
            catch (Exception var7_5) {}
        }
    }

    protected void notifyHasRegenerated() {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.regenerated(this);
            }
            catch (Exception var3_3) {}
        }
    }

    protected void scalePortCoordinates(q q2, double d2, double d3, double d4, double d5) {
        double d6;
        d d7;
        aB aB2;
        fL fL2;
        double d8;
        bu bu2 = (bu)q2.e();
        double d9 = d2 > 0.0 ? d3 / d2 : 1.0;
        double d10 = d4 > 0.0 ? d5 / d4 : 1.0;
        for (d7 = q2.f(); d7 != null; d7 = d7.g()) {
            aB2 = bu2.i(d7);
            fL2 = aB2.getSourcePort();
            d8 = fL2.g() * d9;
            d6 = fL2.h() * d10;
            fL2.b(d8, d6);
            bu2.a(d7, new t(d8, d6));
        }
        d7 = q2.g();
        while (d7 != null) {
            aB2 = bu2.i(d7);
            fL2 = aB2.getTargetPort();
            d8 = fL2.g() * d9;
            d6 = fL2.h() * d10;
            fL2.b(d8, d6);
            bu2.b(d7, new t(d8, d6));
            d7 = d7.h();
        }
    }

    @Override
    public void addListener(IZyNodeRealizerListener iZyNodeRealizerListener) {
        this.m_listeners.addListener(iZyNodeRealizerListener);
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
    public void moveBy(double d2, double d3) {
        super.moveBy(d2, d3);
        this.notifyLocationChanged(this.getX(), this.getY());
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D) {
        if (!this.isSelected() && !this.m_isHighLighted) {
            this.paintFilledShape(graphics2D);
            this.paintShapeBorder(graphics2D);
            return;
        }
        dr dr2 = this.getLineType();
        this.setLineType(dr.e);
        this.paintFilledShape(graphics2D);
        this.paintShapeBorder(graphics2D);
        this.setLineType(dr2);
    }

    @Override
    public int positionToRow(double d2) {
        ZyLabelContent zyLabelContent = this.getNodeContent();
        Rectangle2D rectangle2D = this.getNodeContent().getBounds();
        double d3 = this.getHeight() / rectangle2D.getHeight();
        int n2 = (int)((d2 / d3 - (double)zyLabelContent.getPaddingTop()) / zyLabelContent.getLineHeight());
        if (n2 >= zyLabelContent.getLineCount()) {
            return -1;
        }
        int n3 = n2;
        return n3;
    }

    @Override
    public void regenerate() {
        ZyLabelContent zyLabelContent = this.getNodeContent();
        double d2 = zyLabelContent.getBounds().getWidth();
        double d3 = zyLabelContent.getBounds().getHeight();
        if (this.m_updater != null) {
            this.m_updater.generateContent(this, zyLabelContent);
        }
        Rectangle2D rectangle2D = zyLabelContent.getBounds();
        this.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
        this.scalePortCoordinates(this.getNode(), d2, rectangle2D.getWidth(), d3, rectangle2D.getHeight());
        this.notifyHasRegenerated();
        this.repaint();
    }

    @Override
    public void removeListener(IZyNodeRealizerListener iZyNodeRealizerListener) {
        this.m_listeners.removeListener(iZyNodeRealizerListener);
    }

    @Override
    public double rowToPosition(int n2) {
        ZyLabelContent zyLabelContent = this.getNodeContent();
        return (double)zyLabelContent.getPaddingTop() + (double)n2 * zyLabelContent.getLineHeight();
    }

    @Override
    public void setCenter(double d2, double d3) {
        super.setCenter(d2, d3);
        this.notifyLocationChanged(this.getX(), this.getY());
    }

    @Override
    public void setFillColor(Color color) {
        if (super.getFillColor() == color) return;
        super.setFillColor(color);
        this.updateContentSelectionColor();
    }

    @Override
    public void setLineType(dr dr2) {
        this.m_isHighLighted = dr2 == dr.e || dr2 == dr.l || dr2 == dr.q || dr2 == dr.v;
        super.setLineType(dr2);
    }

    @Override
    public void setLocation(double d2, double d3) {
        super.setLocation(d2, d3);
        this.notifyLocationChanged(d2, d3);
    }

    @Override
    public void setSelected(boolean bl2) {
        if (super.isSelected() == bl2) return;
        super.setSelected(bl2);
        this.updateContentSelectionColor();
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.changedSelection(this);
            }
            catch (Exception var4_4) {}
        }
    }

    @Override
    public void setSize(double d2, double d3) {
        if (super.getX() == d2) {
            if (super.getY() == d3) return;
        }
        super.setSize(d2, d3);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.changedSize(this, d2, d3);
            }
            catch (Exception var7_5) {}
        }
    }

    @Override
    public void setUpdater(IRealizerUpdater iRealizerUpdater) {
        this.m_updater = iRealizerUpdater;
        if (iRealizerUpdater == null) return;
        iRealizerUpdater.setRealizer(this);
    }

    @Override
    public void setUserData(ZyNodeData zyNodeData) {
        Preconditions.checkNotNull(zyNodeData, "Error: Invalid node data");
        this.m_userData = zyNodeData;
    }

    @Override
    public void setVisible(boolean bl2) {
        if (super.isVisible() == bl2) return;
        super.setVisible(bl2);
        this.updateContentSelectionColor();
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IZyNodeRealizerListener iZyNodeRealizerListener = (IZyNodeRealizerListener)iterator.next();
            try {
                iZyNodeRealizerListener.changedVisibility(this);
            }
            catch (Exception var4_4) {}
        }
    }

    @Override
    public void updateContentSelectionColor() {
        ZyLabelContent zyLabelContent = this.getNodeContent();
        if (!zyLabelContent.isSelectable()) return;
        zyLabelContent.updateContentSelectionColor(this.getFillColor(), this.isSelected());
    }
}

