package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class BackgroundIcon implements Icon
{
    private final String text;
    private final int horizontalAlignment;
    private final int height;
    private final int xOffset;
    private final int yOffset;
    private int width;
    private final Color backgroundColor;
    private final Color selectionColor;
    private final Color textColor;
    private final boolean selected;
    
    public BackgroundIcon(final String text, final int horizontalAlignment, final Color textColor, final Color backgroundColor, final Color selectionColor, final boolean selected, final int xOffset, final int yOffset, final int width, final int height) {
        this.text = text;
        this.horizontalAlignment = horizontalAlignment;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.selectionColor = selectionColor;
        this.selected = selected;
        this.width = width;
        this.height = height;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    private void drawText(final Graphics2D graphics2D) {
        final Color color = graphics2D.getColor();
        graphics2D.setColor(this.textColor);
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.text, graphics2D);
        final double n = 4.0 + rectangle2D.getWidth() + 4.0;
        int n2 = 4;
        final int n3 = (int)((this.height - rectangle2D.getHeight()) / 2.0 + rectangle2D.getHeight()) - 2;
        if (n < this.width) {
            if (this.horizontalAlignment == 0) {
                n2 = (int)((this.width - rectangle2D.getWidth()) / 2.0) + 1;
            }
            else if (this.horizontalAlignment == 4) {
                n2 = (int)(this.width - rectangle2D.getWidth() - 4.0);
            }
            graphics2D.drawString(this.text, n2, n3);
        }
        else {
            String concat = "...";
            String s = this.text;
            while (s.length() > 2) {
                s = s.substring(0, s.length() - 2);
                rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(String.valueOf(s).concat("..."), graphics2D);
                if (rectangle2D.getWidth() + 8.0 < this.width) {
                    concat = String.valueOf(s).concat("...");
                    break;
                }
            }
            int n4 = 4;
            if (this.horizontalAlignment == 0) {
                n4 = (int)((this.width - rectangle2D.getWidth()) / 2.0) + 1;
            }
            else if (this.horizontalAlignment == 4) {
                n4 = (int)(this.width - rectangle2D.getWidth() - 4.0);
            }
            graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(concat, graphics2D);
            graphics2D.drawString(concat, n4, n3);
        }
        graphics2D.setComposite(composite);
        graphics2D.setColor(color);
    }
    
    @Override
    public int getIconHeight() {
        return this.height;
    }
    
    @Override
    public int getIconWidth() {
        return this.width;
    }
    
    @Override
    public void paintIcon(final Component component, final Graphics graphics, final int n, final int n2) {
        final int n3 = n + this.xOffset;
        final int n4 = n2 + this.yOffset;
        graphics.translate(n3, n4);
        final Graphics2D graphics2D = (Graphics2D)graphics;
        final Color color = graphics2D.getColor();
        graphics2D.setColor(this.backgroundColor);
        graphics2D.fillRect(n3, n4, this.width, this.height);
        if (this.selected) {
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.6f));
            graphics2D.setColor(this.selectionColor);
            graphics2D.fillRect(n3, n4, this.width, this.height);
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            graphics2D.drawRect(n3, n4, this.width - 1, this.height - 1);
            graphics2D.setComposite(composite);
        }
        this.drawText(graphics2D);
        graphics2D.setColor(color);
        graphics.translate(-n3, -n4);
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
