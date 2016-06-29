package org.jfree.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawablePanel extends JPanel
{
    private Drawable drawable;
    
    public DrawablePanel() {
        this.setOpaque(false);
    }
    
    public Drawable getDrawable() {
        return this.drawable;
    }
    
    public void setDrawable(final Drawable drawable) {
        this.drawable = drawable;
        this.revalidate();
        this.repaint();
    }
    
    public Dimension getPreferredSize() {
        if (this.drawable instanceof ExtendedDrawable) {
            return ((ExtendedDrawable)this.drawable).getPreferredSize();
        }
        return super.getPreferredSize();
    }
    
    public Dimension getMinimumSize() {
        if (this.drawable instanceof ExtendedDrawable) {
            return ((ExtendedDrawable)this.drawable).getPreferredSize();
        }
        return super.getMinimumSize();
    }
    
    public boolean isOpaque() {
        return this.drawable != null && super.isOpaque();
    }
    
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        if (this.drawable == null) {
            return;
        }
        final Graphics2D graphics2D = (Graphics2D)graphics.create(0, 0, this.getWidth(), this.getHeight());
        this.drawable.draw(graphics2D, new Rectangle2D.Double(0.0, 0.0, this.getWidth(), this.getHeight()));
        graphics2D.dispose();
    }
}
