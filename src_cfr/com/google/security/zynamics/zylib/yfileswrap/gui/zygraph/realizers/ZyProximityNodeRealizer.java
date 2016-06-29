/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNodeRealizer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import y.h.dr;
import y.h.fj;

public class ZyProximityNodeRealizer
extends ZyNodeRealizer {
    private static Color m_backGroundColor = new Color(250, 250, 255);
    private final ZyLabelContent m_content;

    public ZyProximityNodeRealizer(ZyLabelContent zyLabelContent) {
        Preconditions.checkNotNull(zyLabelContent, "Error: Node content can't be null.");
        this.m_content = zyLabelContent;
        this.setShapeType(2);
        this.setLineType(dr.b);
        this.setDropShadowOffsetX(0);
        this.setDropShadowOffsetY(0);
        this.setFillColor(m_backGroundColor);
        ZyProximityNodeRealizer.setSloppySelectionColor(m_backGroundColor);
        Rectangle2D rectangle2D = this.getNodeContent().getBounds();
        double d2 = Math.max(rectangle2D.getWidth(), rectangle2D.getHeight());
        this.setSize(d2, d2);
    }

    @Override
    protected void paintFilledShape(Graphics2D graphics2D) {
        graphics2D.setComposite(AlphaComposite.getInstance(3, 0.66f));
        super.paintFilledShape(graphics2D);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
    }

    @Override
    public void addListener(IZyNodeRealizerListener iZyNodeRealizerListener) {
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
    public void paintHotSpots(Graphics2D graphics2D) {
    }

    @Override
    public void paintNode(Graphics2D graphics2D) {
        super.paintNode(graphics2D);
        Rectangle2D rectangle2D = this.getNodeContent().getBounds();
        double d2 = this.getWidth() / rectangle2D.getWidth();
        double d3 = this.getHeight() / rectangle2D.getHeight();
        graphics2D.scale(d2, d3);
        this.getNodeContent().draw(graphics2D, this.getX() * 1.0 / d2, this.getY() * 1.0 / d3);
        graphics2D.scale(1.0 / d2, 1.0 / d3);
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D) {
        super.paintFilledShape(graphics2D);
        super.paintShapeBorder(graphics2D);
    }

    @Override
    public void removeListener(IZyNodeRealizerListener iZyNodeRealizerListener) {
    }

    @Override
    public void setSelected(boolean bl2) {
    }

    @Override
    public void setUpdater(IRealizerUpdater iRealizerUpdater) {
    }
}

