/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class XYDotRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -2764344339073566425L;
    private int dotWidth = 1;
    private int dotHeight = 1;

    public int getDotWidth() {
        return this.dotWidth;
    }

    public void setDotWidth(int n2) {
        if (n2 < 1) {
            throw new IllegalArgumentException("Requires w > 0.");
        }
        this.dotWidth = n2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public int getDotHeight() {
        return this.dotHeight;
    }

    public void setDotHeight(int n2) {
        if (n2 < 1) {
            throw new IllegalArgumentException("Requires h > 0.");
        }
        this.dotHeight = n2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double d2 = xYDataset.getXValue(n2, n3);
        double d3 = xYDataset.getYValue(n2, n3);
        double d4 = (double)(this.dotWidth - 1) / 2.0;
        double d5 = (double)(this.dotHeight - 1) / 2.0;
        if (Double.isNaN(d3)) return;
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d6 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge) - d4;
        double d7 = valueAxis2.valueToJava2D(d3, rectangle2D, rectangleEdge2) - d5;
        graphics2D.setPaint(this.getItemPaint(n2, n3));
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            graphics2D.fillRect((int)d7, (int)d6, this.dotHeight, this.dotWidth);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            graphics2D.fillRect((int)d6, (int)d7, this.dotWidth, this.dotHeight);
        }
        int n5 = xYPlot.getDomainAxisIndex(valueAxis);
        int n6 = xYPlot.getRangeAxisIndex(valueAxis2);
        this.updateCrosshairValues(crosshairState, d2, d3, n5, n6, d6, d7, plotOrientation);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYDotRenderer)) {
            return false;
        }
        XYDotRenderer xYDotRenderer = (XYDotRenderer)object;
        if (this.dotWidth != xYDotRenderer.dotWidth) {
            return false;
        }
        if (this.dotHeight == xYDotRenderer.dotHeight) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

