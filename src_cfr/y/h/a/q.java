/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

class q
implements Icon {
    q() {
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        Color color = graphics.getColor();
        graphics.setColor(Color.white);
        graphics.fillRect(n2 + 1, n3 + 1, 14, 14);
        graphics.setColor(Color.black);
        graphics.drawLine(n2 + 8, n3 + 4, n2 + 8, n3 + 12);
        graphics.drawLine(n2 + 4, n3 + 8, n2 + 12, n3 + 8);
        graphics.drawRect(n2 + 1, n3 + 1, 14, 14);
        graphics.setColor(color);
    }

    @Override
    public int getIconWidth() {
        return 16;
    }

    @Override
    public int getIconHeight() {
        return 16;
    }
}

