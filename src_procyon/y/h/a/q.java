package y.h.a;

import javax.swing.*;
import java.awt.*;

class q implements Icon
{
    public void paintIcon(final Component component, final Graphics graphics, final int n, final int n2) {
        final Color color = graphics.getColor();
        graphics.setColor(Color.white);
        graphics.fillRect(n + 1, n2 + 1, 14, 14);
        graphics.setColor(Color.black);
        graphics.drawLine(n + 8, n2 + 4, n + 8, n2 + 12);
        graphics.drawLine(n + 4, n2 + 8, n + 12, n2 + 8);
        graphics.drawRect(n + 1, n2 + 1, 14, 14);
        graphics.setColor(color);
    }
    
    public int getIconWidth() {
        return 16;
    }
    
    public int getIconHeight() {
        return 16;
    }
}
