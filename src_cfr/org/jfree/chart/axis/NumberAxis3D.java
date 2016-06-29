/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.List;
import org.jfree.chart.Effect3D;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.ui.RectangleEdge;

public class NumberAxis3D
extends NumberAxis
implements Serializable {
    private static final long serialVersionUID = -1790205852569123512L;

    public NumberAxis3D() {
        this(null);
    }

    public NumberAxis3D(String string) {
        super(string);
        this.setAxisLineVisible(false);
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        CategoryItemRenderer categoryItemRenderer;
        CategoryPlot categoryPlot;
        if (!this.isVisible()) {
            AxisState axisState = new AxisState(d2);
            List list = this.refreshTicks(graphics2D, axisState, rectangle2D2, rectangleEdge);
            axisState.setTicks(list);
            return axisState;
        }
        double d3 = 0.0;
        double d4 = 0.0;
        Plot plot = this.getPlot();
        if (plot instanceof CategoryPlot && (categoryItemRenderer = (categoryPlot = (CategoryPlot)plot).getRenderer()) instanceof Effect3D) {
            Effect3D effect3D = (Effect3D)((Object)categoryItemRenderer);
            d3 = effect3D.getXOffset();
            d4 = effect3D.getYOffset();
        }
        double d5 = rectangle2D2.getMinX();
        double d6 = rectangle2D2.getMinY();
        double d7 = rectangle2D2.getWidth() - d3;
        double d8 = rectangle2D2.getHeight() - d4;
        if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.BOTTOM) {
            d6 += d4;
        } else if (rectangleEdge == RectangleEdge.RIGHT || rectangleEdge == RectangleEdge.TOP) {
            d5 += d3;
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(d5, d6, d7, d8);
        AxisState axisState = this.drawTickMarksAndLabels(graphics2D, d2, rectangle2D, double_, rectangleEdge);
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState);
    }
}

