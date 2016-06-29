/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import y.h.aA;

public class ZyEdgeLabel
extends aA {
    private static final int SHADOW_SIZE = 5;
    private static Color m_backGroundColor = new Color(250, 250, 255);
    private static Color borderColor = Color.BLACK;
    private final ZyLabelContent m_content;
    private final int m_roundedHeight;
    private final int m_roundedWidth;
    private final double m_height;
    private final double m_width;

    public ZyEdgeLabel(ZyLabelContent zyLabelContent) {
        Preconditions.checkNotNull(zyLabelContent, "Internal Error: Content can't be null");
        this.m_content = zyLabelContent;
        this.setVisible(true);
        this.setText("A");
        this.setModel(1);
        this.setPreferredPlacement(8);
        this.setPosition(12);
        this.m_height = this.getHeight();
        this.m_width = this.getWidth();
        this.m_roundedHeight = (int)this.m_height;
        this.m_roundedWidth = (int)this.m_width;
    }

    @Override
    protected void paintBox(Graphics2D graphics2D, double d2, double d3, double d4, double d5) {
        int n2 = (int)(d2 - this.m_width / 2.0);
        int n3 = (int)(d3 - this.m_height / 2.0);
        BasicStroke basicStroke = (BasicStroke)graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(basicStroke.getLineWidth()));
        graphics2D.setColor(m_backGroundColor);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 0.8f));
        graphics2D.fillRoundRect(n2, n3, this.m_roundedWidth, this.m_roundedHeight, 5, 5);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 0.95f));
        graphics2D.setColor(borderColor);
        graphics2D.drawRoundRect(n2, n3, this.m_roundedWidth, this.m_roundedHeight, 5, 5);
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setStroke(basicStroke);
    }

    @Override
    protected void paintContent(Graphics2D graphics2D, double d2, double d3, double d4, double d5) {
        int n2 = (int)(d2 - this.m_width / 2.0);
        int n3 = (int)(d3 - this.m_height / 2.0);
        this.m_content.draw(graphics2D, n2, n3);
    }

    @Override
    public double getHeight() {
        return this.m_content.getBounds().getHeight();
    }

    public ZyLabelContent getLabelContent() {
        return this.m_content;
    }

    @Override
    public double getWidth() {
        return this.m_content.getBounds().getWidth();
    }
}

