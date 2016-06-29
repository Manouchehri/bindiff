package org.jfree.chart.renderer.category;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

final class MinMaxCategoryRenderer$1 implements Icon
{
    private final GeneralPath val$path;
    private final Paint val$fillPaint;
    private final Paint val$outlinePaint;
    private final int val$width;
    private final int val$height;
    private final MinMaxCategoryRenderer this$0;
    
    MinMaxCategoryRenderer$1(final MinMaxCategoryRenderer this$0, final GeneralPath val$path, final Paint val$fillPaint, final Paint val$outlinePaint, final int val$width, final int val$height) {
        this.this$0 = this$0;
        this.val$path = val$path;
        this.val$fillPaint = val$fillPaint;
        this.val$outlinePaint = val$outlinePaint;
        this.val$width = val$width;
        this.val$height = val$height;
    }
    
    public void paintIcon(final Component component, final Graphics graphics, final int n, final int n2) {
        final Graphics2D graphics2D = (Graphics2D)graphics;
        this.val$path.transform(AffineTransform.getTranslateInstance(n, n2));
        if (this.val$fillPaint != null) {
            graphics2D.setPaint(this.val$fillPaint);
            graphics2D.fill(this.val$path);
        }
        if (this.val$outlinePaint != null) {
            graphics2D.setPaint(this.val$outlinePaint);
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
