/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.ui.RectangleInsets;

public interface BlockFrame {
    public RectangleInsets getInsets();

    public void draw(Graphics2D var1, Rectangle2D var2);
}

