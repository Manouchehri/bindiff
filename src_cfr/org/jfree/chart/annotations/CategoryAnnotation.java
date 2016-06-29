/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;

public interface CategoryAnnotation {
    public void draw(Graphics2D var1, CategoryPlot var2, Rectangle2D var3, CategoryAxis var4, ValueAxis var5);
}

