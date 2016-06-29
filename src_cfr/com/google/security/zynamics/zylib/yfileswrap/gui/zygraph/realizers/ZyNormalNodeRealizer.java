/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNodeRealizer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import y.h.dr;
import y.h.fj;

public class ZyNormalNodeRealizer
extends ZyNodeRealizer {
    private static final byte SHADOW_SIZE = 8;
    private static final Color SHADOW_COLOR = Color.GRAY;
    private final ZyLabelContent m_content;

    public ZyNormalNodeRealizer(ZyLabelContent zyLabelContent) {
        Preconditions.checkNotNull(zyLabelContent, "Error: Node content can't be null.");
        this.m_content = zyLabelContent;
        this.setShapeType(1);
        this.setLineType(dr.b);
        this.setDropShadowOffsetX(8);
        this.setDropShadowOffsetY(8);
        this.setDropShadowColor(SHADOW_COLOR);
        Rectangle2D rectangle2D = this.getNodeContent().getBounds();
        this.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override
    protected void paintShadow(Graphics2D graphics2D) {
        if (this.isSelected()) return;
        if (!this.isDropShadowVisible()) return;
        graphics2D.setColor(SHADOW_COLOR);
        this.setDropShadowOffsetX(8);
        this.setDropShadowOffsetY(8);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 0.7f));
        super.paintShadow(graphics2D);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
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

    public String toString() {
        return this.m_content.toString();
    }
}

