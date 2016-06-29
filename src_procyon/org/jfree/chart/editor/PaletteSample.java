package org.jfree.chart.editor;

import org.jfree.chart.plot.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class PaletteSample extends JComponent implements ListCellRenderer
{
    private ColorPalette palette;
    private Dimension preferredSize;
    
    public PaletteSample(final ColorPalette palette) {
        this.palette = palette;
        this.preferredSize = new Dimension(80, 18);
    }
    
    public Component getListCellRendererComponent(final JList list, final Object o, final int n, final boolean b, final boolean b2) {
        if (o instanceof PaletteSample) {
            this.setPalette(((PaletteSample)o).getPalette());
        }
        return this;
    }
    
    public ColorPalette getPalette() {
        return this.palette;
    }
    
    public Dimension getPreferredSize() {
        return this.preferredSize;
    }
    
    public void paintComponent(final Graphics graphics) {
        final Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        final Dimension size = this.getSize();
        final Insets insets = this.getInsets();
        final double n = size.getWidth() - insets.left - insets.right;
        final double n2 = size.getHeight() - insets.top - insets.bottom;
        graphics2D.setStroke(new BasicStroke(1.0f));
        final double n3 = insets.top;
        final double n4 = n3 + n2;
        double n5 = insets.left;
        final Line2D.Double double1 = new Line2D.Double();
        int n6 = 0;
        while (n5 <= insets.left + n) {
            ++n6;
            double1.setLine(n5, n3, n5, n4);
            graphics2D.setPaint(this.palette.getColor(n6));
            graphics2D.draw(double1);
            ++n5;
        }
    }
    
    public void setPalette(final ColorPalette palette) {
        this.palette = palette;
        this.repaint();
    }
}
