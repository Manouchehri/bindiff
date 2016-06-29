/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.realizers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNodeRealizer;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import y.c.q;
import y.h.dr;
import y.h.fj;

public class CombinedNodeRealizer
extends ZyNodeRealizer {
    private static final byte SHADOW_SIZE = 8;
    private static final Color SHADOW_COLOR = Color.GRAY;
    private static final int SEPARATOR_GAP = 12;
    private final ZyLabelContent leftContent;
    private final ZyLabelContent rightContent;
    private final Rectangle2D bounds = new Rectangle();
    private ESide activeContentSide;

    public CombinedNodeRealizer(ZyLabelContent zyLabelContent, ZyLabelContent zyLabelContent2) {
        this.leftContent = zyLabelContent;
        this.rightContent = zyLabelContent2;
        this.activeContentSide = zyLabelContent != null ? ESide.PRIMARY : ESide.SECONDARY;
        this.setShapeType(1);
        this.setLineType(dr.b);
        this.setDropShadowOffsetX(8);
        this.setDropShadowOffsetY(8);
        this.setDropShadowColor(SHADOW_COLOR);
        this.setNodeSize();
    }

    private boolean isUnmatched() {
        if (this.leftContent == null) return true;
        if (this.rightContent == null) return true;
        return false;
    }

    private void setNodeSize() {
        if (this.isUnmatched()) {
            this.bounds.setRect(this.getNodeContent().getBounds());
        } else {
            double d2 = this.leftContent.getBounds().getX();
            double d3 = this.leftContent.getBounds().getY();
            double d4 = Math.max(this.leftContent.getBounds().getHeight(), this.rightContent.getBounds().getHeight());
            double d5 = this.leftContent.getBounds().getWidth() + 12.0 + this.rightContent.getBounds().getWidth();
            this.bounds.setRect(d2, d3, d5, d4);
        }
        this.setSize(this.bounds.getWidth(), this.bounds.getHeight());
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
    public void addListener(IZyNodeRealizerListener iZyNodeRealizerListener) {
    }

    @Override
    public void removeListener(IZyNodeRealizerListener iZyNodeRealizerListener) {
    }

    @Override
    public ZyLabelContent getNodeContent() {
        ZyLabelContent zyLabelContent;
        if (this.isUnmatched()) {
            ZyLabelContent zyLabelContent2;
            if (this.leftContent == null) {
                zyLabelContent2 = this.rightContent;
                return zyLabelContent2;
            }
            zyLabelContent2 = this.leftContent;
            return zyLabelContent2;
        }
        if (this.activeContentSide == ESide.PRIMARY) {
            zyLabelContent = this.leftContent;
            return zyLabelContent;
        }
        zyLabelContent = this.rightContent;
        return zyLabelContent;
    }

    @Override
    public fj getRealizer() {
        return this;
    }

    @Override
    public void paintHotSpots(Graphics2D graphics2D) {
    }

    @Override
    public void paintText(Graphics2D graphics2D) {
        if (this.leftContent != null && this.rightContent == null) {
            this.leftContent.draw(graphics2D, this.getX(), this.getY());
        } else if (this.leftContent == null && this.rightContent != null) {
            this.rightContent.draw(graphics2D, this.getX(), this.getY());
        } else {
            double d2 = this.leftContent.getBounds().getWidth();
            int n2 = (int)Math.round(this.getX() + d2 + 6.0 - 1.0);
            int n3 = (int)Math.round(this.getY() + 1.0);
            int n4 = (int)Math.round(this.getY() + this.bounds.getHeight() - 1.0);
            graphics2D.setStroke(new BasicStroke(1.0f));
            this.leftContent.draw(graphics2D, this.getX(), this.getY());
            this.rightContent.draw(graphics2D, this.getX() + 12.0 + d2, this.getY());
            graphics2D.setColor(Color.BLACK);
            graphics2D.setStroke(new BasicStroke(2.0f));
            graphics2D.drawLine(n2, n3, n2, n4);
        }
        super.paintText(graphics2D);
    }

    @Override
    public void regenerate() {
        if (this.isUnmatched()) {
            super.regenerate();
            return;
        }
        double d2 = this.leftContent.getBounds().getWidth() + 12.0 + this.rightContent.getBounds().getWidth();
        double d3 = this.leftContent.getBounds().getHeight() + this.rightContent.getBounds().getHeight();
        this.getUpdater().generateContent(this, this.leftContent);
        this.getUpdater().generateContent(this, this.rightContent);
        this.setNodeSize();
        this.scalePortCoordinates(this.getNode(), d2, this.bounds.getWidth(), d3, this.bounds.getHeight());
        this.notifyHasRegenerated();
        this.repaint();
    }

    public void setActiveContent(ESide eSide) {
        if (this.isUnmatched()) return;
        this.activeContentSide = eSide;
    }

    @Override
    public void updateContentSelectionColor() {
        if (!this.isUnmatched()) return;
        super.updateContentSelectionColor();
    }
}

