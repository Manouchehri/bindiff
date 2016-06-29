package org.jfree.ui;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class PaintSample extends JComponent
{
    private Paint paint;
    private Dimension preferredSize;
    
    public PaintSample(final Paint paint) {
        this.paint = paint;
        this.preferredSize = new Dimension(80, 12);
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public void setPaint(final Paint paint) {
        this.paint = paint;
        this.repaint();
    }
    
    public Dimension getPreferredSize() {
        return this.preferredSize;
    }
    
    public void paintComponent(final Graphics graphics) {
        final Graphics2D graphics2D = (Graphics2D)graphics;
        final Dimension size = this.getSize();
        final Insets insets = this.getInsets();
        final Rectangle2D.Double double1 = new Rectangle2D.Double(insets.left, insets.top, size.getWidth() - insets.left - insets.right - 1.0, size.getHeight() - insets.top - insets.bottom - 1.0);
        graphics2D.setPaint(this.paint);
        graphics2D.fill(double1);
        graphics2D.setPaint(Color.black);
        graphics2D.draw(double1);
    }
}
