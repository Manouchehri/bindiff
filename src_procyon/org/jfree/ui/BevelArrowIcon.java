package org.jfree.ui;

import javax.swing.*;
import java.awt.*;

public class BevelArrowIcon implements Icon
{
    public static final int UP = 0;
    public static final int DOWN = 1;
    private static final int DEFAULT_SIZE = 11;
    private Color edge1;
    private Color edge2;
    private Color fill;
    private int size;
    private int direction;
    
    public BevelArrowIcon(final int n, final boolean b, final boolean b2) {
        if (b) {
            if (b2) {
                this.init(UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlDkShadow"), UIManager.getColor("controlShadow"), 11, n);
            }
            else {
                this.init(UIManager.getColor("controlHighlight"), UIManager.getColor("controlShadow"), UIManager.getColor("control"), 11, n);
            }
        }
        else if (b2) {
            this.init(UIManager.getColor("controlDkShadow"), UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlShadow"), 11, n);
        }
        else {
            this.init(UIManager.getColor("controlShadow"), UIManager.getColor("controlHighlight"), UIManager.getColor("control"), 11, n);
        }
    }
    
    public BevelArrowIcon(final Color color, final Color color2, final Color color3, final int n, final int n2) {
        this.init(color, color2, color3, n, n2);
    }
    
    public void paintIcon(final Component component, final Graphics graphics, final int n, final int n2) {
        switch (this.direction) {
            case 1: {
                this.drawDownArrow(graphics, n, n2);
                break;
            }
            case 0: {
                this.drawUpArrow(graphics, n, n2);
                break;
            }
        }
    }
    
    public int getIconWidth() {
        return this.size;
    }
    
    public int getIconHeight() {
        return this.size;
    }
    
    private void init(final Color edge1, final Color edge2, final Color fill, final int size, final int direction) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.fill = fill;
        this.size = size;
        this.direction = direction;
    }
    
    private void drawDownArrow(final Graphics graphics, final int n, final int n2) {
        graphics.setColor(this.edge1);
        graphics.drawLine(n, n2, n + this.size - 1, n2);
        graphics.drawLine(n, n2 + 1, n + this.size - 3, n2 + 1);
        graphics.setColor(this.edge2);
        graphics.drawLine(n + this.size - 2, n2 + 1, n + this.size - 1, n2 + 1);
        int n3 = n + 1;
        for (int n4 = n2 + 2, n5 = this.size - 6; n4 + 1 < n2 + this.size; n4 += 2, n5 -= 2) {
            graphics.setColor(this.edge1);
            graphics.drawLine(n3, n4, n3 + 1, n4);
            graphics.drawLine(n3, n4 + 1, n3 + 1, n4 + 1);
            if (0 < n5) {
                graphics.setColor(this.fill);
                graphics.drawLine(n3 + 2, n4, n3 + 1 + n5, n4);
                graphics.drawLine(n3 + 2, n4 + 1, n3 + 1 + n5, n4 + 1);
            }
            graphics.setColor(this.edge2);
            graphics.drawLine(n3 + n5 + 2, n4, n3 + n5 + 3, n4);
            graphics.drawLine(n3 + n5 + 2, n4 + 1, n3 + n5 + 3, n4 + 1);
            ++n3;
        }
        graphics.setColor(this.edge1);
        graphics.drawLine(n + this.size / 2, n2 + this.size - 1, n + this.size / 2, n2 + this.size - 1);
    }
    
    private void drawUpArrow(final Graphics graphics, final int n, final int n2) {
        graphics.setColor(this.edge1);
        int n3 = n + this.size / 2;
        graphics.drawLine(n3, n2, n3, n2);
        --n3;
        for (int n4 = n2 + 1, n5 = 0; n4 + 3 < n2 + this.size; n4 += 2, n5 += 2) {
            graphics.setColor(this.edge1);
            graphics.drawLine(n3, n4, n3 + 1, n4);
            graphics.drawLine(n3, n4 + 1, n3 + 1, n4 + 1);
            if (0 < n5) {
                graphics.setColor(this.fill);
                graphics.drawLine(n3 + 2, n4, n3 + 1 + n5, n4);
                graphics.drawLine(n3 + 2, n4 + 1, n3 + 1 + n5, n4 + 1);
            }
            graphics.setColor(this.edge2);
            graphics.drawLine(n3 + n5 + 2, n4, n3 + n5 + 3, n4);
            graphics.drawLine(n3 + n5 + 2, n4 + 1, n3 + n5 + 3, n4 + 1);
            --n3;
        }
        graphics.setColor(this.edge1);
        graphics.drawLine(n, n2 + this.size - 3, n + 1, n2 + this.size - 3);
        graphics.setColor(this.edge2);
        graphics.drawLine(n + 2, n2 + this.size - 2, n + this.size - 1, n2 + this.size - 2);
        graphics.drawLine(n, n2 + this.size - 1, n + this.size, n2 + this.size - 1);
    }
}
