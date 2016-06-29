/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.UIManager;

public class BevelArrowIcon
implements Icon {
    public static final int UP = 0;
    public static final int DOWN = 1;
    private static final int DEFAULT_SIZE = 11;
    private Color edge1;
    private Color edge2;
    private Color fill;
    private int size;
    private int direction;

    public BevelArrowIcon(int n2, boolean bl2, boolean bl3) {
        if (bl2) {
            if (bl3) {
                this.init(UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlDkShadow"), UIManager.getColor("controlShadow"), 11, n2);
                return;
            }
            this.init(UIManager.getColor("controlHighlight"), UIManager.getColor("controlShadow"), UIManager.getColor("control"), 11, n2);
            return;
        }
        if (bl3) {
            this.init(UIManager.getColor("controlDkShadow"), UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlShadow"), 11, n2);
            return;
        }
        this.init(UIManager.getColor("controlShadow"), UIManager.getColor("controlHighlight"), UIManager.getColor("control"), 11, n2);
    }

    public BevelArrowIcon(Color color, Color color2, Color color3, int n2, int n3) {
        this.init(color, color2, color3, n2, n3);
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        switch (this.direction) {
            case 1: {
                this.drawDownArrow(graphics, n2, n3);
                return;
            }
            case 0: {
                this.drawUpArrow(graphics, n2, n3);
            }
        }
    }

    @Override
    public int getIconWidth() {
        return this.size;
    }

    @Override
    public int getIconHeight() {
        return this.size;
    }

    private void init(Color color, Color color2, Color color3, int n2, int n3) {
        this.edge1 = color;
        this.edge2 = color2;
        this.fill = color3;
        this.size = n2;
        this.direction = n3;
    }

    private void drawDownArrow(Graphics graphics, int n2, int n3) {
        graphics.setColor(this.edge1);
        graphics.drawLine(n2, n3, n2 + this.size - 1, n3);
        graphics.drawLine(n2, n3 + 1, n2 + this.size - 3, n3 + 1);
        graphics.setColor(this.edge2);
        graphics.drawLine(n2 + this.size - 2, n3 + 1, n2 + this.size - 1, n3 + 1);
        int n4 = n2 + 1;
        int n5 = n3 + 2;
        int n6 = this.size - 6;
        do {
            if (n5 + 1 >= n3 + this.size) {
                graphics.setColor(this.edge1);
                graphics.drawLine(n2 + this.size / 2, n3 + this.size - 1, n2 + this.size / 2, n3 + this.size - 1);
                return;
            }
            graphics.setColor(this.edge1);
            graphics.drawLine(n4, n5, n4 + 1, n5);
            graphics.drawLine(n4, n5 + 1, n4 + 1, n5 + 1);
            if (0 < n6) {
                graphics.setColor(this.fill);
                graphics.drawLine(n4 + 2, n5, n4 + 1 + n6, n5);
                graphics.drawLine(n4 + 2, n5 + 1, n4 + 1 + n6, n5 + 1);
            }
            graphics.setColor(this.edge2);
            graphics.drawLine(n4 + n6 + 2, n5, n4 + n6 + 3, n5);
            graphics.drawLine(n4 + n6 + 2, n5 + 1, n4 + n6 + 3, n5 + 1);
            ++n4;
            n5 += 2;
            n6 -= 2;
        } while (true);
    }

    private void drawUpArrow(Graphics graphics, int n2, int n3) {
        graphics.setColor(this.edge1);
        int n4 = n2 + this.size / 2;
        graphics.drawLine(n4, n3, n4, n3);
        --n4;
        int n5 = n3 + 1;
        int n6 = 0;
        do {
            if (n5 + 3 >= n3 + this.size) {
                graphics.setColor(this.edge1);
                graphics.drawLine(n2, n3 + this.size - 3, n2 + 1, n3 + this.size - 3);
                graphics.setColor(this.edge2);
                graphics.drawLine(n2 + 2, n3 + this.size - 2, n2 + this.size - 1, n3 + this.size - 2);
                graphics.drawLine(n2, n3 + this.size - 1, n2 + this.size, n3 + this.size - 1);
                return;
            }
            graphics.setColor(this.edge1);
            graphics.drawLine(n4, n5, n4 + 1, n5);
            graphics.drawLine(n4, n5 + 1, n4 + 1, n5 + 1);
            if (0 < n6) {
                graphics.setColor(this.fill);
                graphics.drawLine(n4 + 2, n5, n4 + 1 + n6, n5);
                graphics.drawLine(n4 + 2, n5 + 1, n4 + 1 + n6, n5 + 1);
            }
            graphics.setColor(this.edge2);
            graphics.drawLine(n4 + n6 + 2, n5, n4 + n6 + 3, n5);
            graphics.drawLine(n4 + n6 + 2, n5 + 1, n4 + n6 + 3, n5 + 1);
            --n4;
            n5 += 2;
            n6 += 2;
        } while (true);
    }
}

