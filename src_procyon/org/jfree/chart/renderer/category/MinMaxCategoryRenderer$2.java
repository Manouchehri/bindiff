package org.jfree.chart.renderer.category;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

final class MinMaxCategoryRenderer$2 implements Icon
{
    private final GeneralPath val$path;
    private final boolean val$fill;
    private final boolean val$outline;
    private final int val$width;
    private final int val$height;
    private final MinMaxCategoryRenderer this$0;
    
    MinMaxCategoryRenderer$2(final MinMaxCategoryRenderer this$0, final GeneralPath val$path, final boolean val$fill, final boolean val$outline, final int val$width, final int val$height) {
        this.this$0 = this$0;
        this.val$path = val$path;
        this.val$fill = val$fill;
        this.val$outline = val$outline;
        this.val$width = val$width;
        this.val$height = val$height;
    }
    
    public void paintIcon(final Component component, final Graphics graphics, final int n, final int n2) {
        final Graphics2D graphics2D = (Graphics2D)graphics;
        this.val$path.transform(AffineTransform.getTranslateInstance(n, n2));
        if (this.val$fill) {
            graphics2D.fill(this.val$path);
        }
        if (this.val$outline) {
            graphics2D.draw(this.val$path);
        }
        this.val$path.transform(AffineTransform.getTranslateInstance(-n, -n2));
    }
    
    public int getIconWidth() {
        return this.val$width;
    }
    
    public int getIconHeight() {
        return this.val$height;
    }
}
