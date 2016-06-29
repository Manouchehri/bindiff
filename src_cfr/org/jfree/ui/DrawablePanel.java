/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.ui.Drawable;
import org.jfree.ui.ExtendedDrawable;

public class DrawablePanel
extends JPanel {
    private Drawable drawable;

    public DrawablePanel() {
        this.setOpaque(false);
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        this.revalidate();
        this.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        if (!(this.drawable instanceof ExtendedDrawable)) return super.getPreferredSize();
        ExtendedDrawable extendedDrawable = (ExtendedDrawable)this.drawable;
        return extendedDrawable.getPreferredSize();
    }

    @Override
    public Dimension getMinimumSize() {
        if (!(this.drawable instanceof ExtendedDrawable)) return super.getMinimumSize();
        ExtendedDrawable extendedDrawable = (ExtendedDrawable)this.drawable;
        return extendedDrawable.getPreferredSize();
    }

    @Override
    public boolean isOpaque() {
        if (this.drawable != null) return super.isOpaque();
        return false;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.drawable == null) {
            return;
        }
        Graphics2D graphics2D = (Graphics2D)graphics.create(0, 0, this.getWidth(), this.getHeight());
        this.drawable.draw(graphics2D, new Rectangle2D.Double(0.0, 0.0, this.getWidth(), this.getHeight()));
        graphics2D.dispose();
    }
}

