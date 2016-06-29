/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.data.xy.XYDataset;

public interface PolarItemRenderer {
    public void drawSeries(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, PolarPlot var4, XYDataset var5, int var6);

    public void drawAngularGridLines(Graphics2D var1, PolarPlot var2, List var3, Rectangle2D var4);

    public void drawRadialGridLines(Graphics2D var1, PolarPlot var2, ValueAxis var3, List var4, Rectangle2D var5);

    public LegendItem getLegendItem(int var1);

    public PolarPlot getPlot();

    public void setPlot(PolarPlot var1);

    public void addChangeListener(RendererChangeListener var1);

    public void removeChangeListener(RendererChangeListener var1);
}

