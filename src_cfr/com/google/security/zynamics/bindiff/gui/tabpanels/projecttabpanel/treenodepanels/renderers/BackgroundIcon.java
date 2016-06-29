/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class BackgroundIcon
implements Icon {
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

    public BackgroundIcon(String string, int n2, Color color, Color color2, Color color3, boolean bl2, int n3, int n4, int n5, int n6) {
        this.text = string;
        this.horizontalAlignment = n2;
        this.textColor = color;
        this.backgroundColor = color2;
        this.selectionColor = color3;
        this.selected = bl2;
        this.width = n5;
        this.height = n6;
        this.xOffset = n3;
        this.yOffset = n4;
    }

    private void drawText(Graphics2D graphics2D) {
        Color color = graphics2D.getColor();
        graphics2D.setColor(this.textColor);
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.text, graphics2D);
        double d2 = 4.0 + rectangle2D.getWidth() + 4.0;
        int n2 = 4;
        int n3 = (int)(((double)this.height - rectangle2D.getHeight()) / 2.0 + rectangle2D.getHeight()) - 2;
        if (d2 < (double)this.width) {
            if (this.horizontalAlignment == 0) {
                n2 = (int)(((double)this.width - rectangle2D.getWidth()) / 2.0) + 1;
            } else if (this.horizontalAlignment == 4) {
                n2 = (int)((double)this.width - rectangle2D.getWidth() - 4.0);
            }
            graphics2D.drawString(this.text, n2, n3);
        } else {
            String string = "...";
            String string2 = this.text;
            while (string2.length() > 2) {
                string2 = string2.substring(0, string2.length() - 2);
                rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(String.valueOf(string2).concat("..."), graphics2D);
                if (rectangle2D.getWidth() + 8.0 >= (double)this.width) continue;
                string = String.valueOf(string2).concat("...");
                break;
            }
            n2 = 4;
            if (this.horizontalAlignment == 0) {
                n2 = (int)(((double)this.width - rectangle2D.getWidth()) / 2.0) + 1;
            } else if (this.horizontalAlignment == 4) {
                n2 = (int)((double)this.width - rectangle2D.getWidth() - 4.0);
            }
            rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(string, graphics2D);
            graphics2D.drawString(string, n2, n3);
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
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        int n4 = n2 + this.xOffset;
        int n5 = n3 + this.yOffset;
        graphics.translate(n4, n5);
        Graphics2D graphics2D = (Graphics2D)graphics;
        Color color = graphics2D.getColor();
        graphics2D.setColor(this.backgroundColor);
        graphics2D.fillRect(n4, n5, this.width, this.height);
        if (this.selected) {
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.6f));
            graphics2D.setColor(this.selectionColor);
            graphics2D.fillRect(n4, n5, this.width, this.height);
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            graphics2D.drawRect(n4, n5, this.width - 1, this.height - 1);
            graphics2D.setComposite(composite);
        }
        this.drawText(graphics2D);
        graphics2D.setColor(color);
        graphics.translate(- n4, - n5);
    }

    public void setWidth(int n2) {
        this.width = n2;
    }
}

