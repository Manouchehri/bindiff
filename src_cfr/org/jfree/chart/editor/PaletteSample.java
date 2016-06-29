/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.jfree.chart.plot.ColorPalette;

public class PaletteSample
extends JComponent
implements ListCellRenderer {
    private ColorPalette palette;
    private Dimension preferredSize;

    public PaletteSample(ColorPalette colorPalette) {
        this.palette = colorPalette;
        this.preferredSize = new Dimension(80, 18);
    }

    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        if (!(object instanceof PaletteSample)) return this;
        PaletteSample paletteSample = (PaletteSample)object;
        this.setPalette(paletteSample.getPalette());
        return this;
    }

    public ColorPalette getPalette() {
        return this.palette;
    }

    @Override
    public Dimension getPreferredSize() {
        return this.preferredSize;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        Dimension dimension = this.getSize();
        Insets insets = this.getInsets();
        double d2 = dimension.getWidth() - (double)insets.left - (double)insets.right;
        double d3 = dimension.getHeight() - (double)insets.top - (double)insets.bottom;
        graphics2D.setStroke(new BasicStroke(1.0f));
        double d4 = insets.top;
        double d5 = d4 + d3;
        double d6 = insets.left;
        Line2D.Double double_ = new Line2D.Double();
        int n2 = 0;
        while (d6 <= (double)insets.left + d2) {
            double_.setLine(d6, d4, d6, d5);
            graphics2D.setPaint(this.palette.getColor(++n2));
            graphics2D.draw(double_);
            d6 += 1.0;
        }
    }

    public void setPalette(ColorPalette colorPalette) {
        this.palette = colorPalette;
        this.repaint();
    }
}

