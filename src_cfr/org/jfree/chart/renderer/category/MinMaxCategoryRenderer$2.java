/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javax.swing.Icon;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer;

final class MinMaxCategoryRenderer$2
implements Icon {
    private final GeneralPath val$path;
    private final boolean val$fill;
    private final boolean val$outline;
    private final int val$width;
    private final int val$height;
    private final MinMaxCategoryRenderer this$0;

    MinMaxCategoryRenderer$2(MinMaxCategoryRenderer minMaxCategoryRenderer, GeneralPath generalPath, boolean bl2, boolean bl3, int n2, int n3) {
        this.this$0 = minMaxCategoryRenderer;
        this.val$path = generalPath;
        this.val$fill = bl2;
        this.val$outline = bl3;
        this.val$width = n2;
        this.val$height = n3;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        this.val$path.transform(AffineTransform.getTranslateInstance(n2, n3));
        if (this.val$fill) {
            graphics2D.fill(this.val$path);
        }
        if (this.val$outline) {
            graphics2D.draw(this.val$path);
        }
        this.val$path.transform(AffineTransform.getTranslateInstance(- n2, - n3));
    }

    @Override
    public int getIconWidth() {
        return this.val$width;
    }

    @Override
    public int getIconHeight() {
        return this.val$height;
    }
}

