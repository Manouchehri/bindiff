/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;

public interface XYAnnotation {
    public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7);
}

