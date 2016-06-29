package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.event.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;

public class XYDotRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -2764344339073566425L;
    private int dotWidth;
    private int dotHeight;
    
    public XYDotRenderer() {
        this.dotWidth = 1;
        this.dotHeight = 1;
    }
    
    public int getDotWidth() {
        return this.dotWidth;
    }
    
    public void setDotWidth(final int dotWidth) {
        if (dotWidth < 1) {
            throw new IllegalArgumentException("Requires w > 0.");
        }
        this.dotWidth = dotWidth;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public int getDotHeight() {
        return this.dotHeight;
    }
    
    public void setDotHeight(final int dotHeight) {
        if (dotHeight < 1) {
            throw new IllegalArgumentException("Requires h > 0.");
        }
        this.dotHeight = dotHeight;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final double xValue = xyDataset.getXValue(n, n2);
        final double yValue = xyDataset.getYValue(n, n2);
        final double n4 = (this.dotWidth - 1) / 2.0;
        final double n5 = (this.dotHeight - 1) / 2.0;
        if (!Double.isNaN(yValue)) {
            final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
            final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
            final double n6 = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge) - n4;
            final double n7 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge) - n5;
            graphics2D.setPaint(this.getItemPaint(n, n2));
            final PlotOrientation orientation = xyPlot.getOrientation();
            if (orientation == PlotOrientation.HORIZONTAL) {
                graphics2D.fillRect((int)n7, (int)n6, this.dotHeight, this.dotWidth);
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                graphics2D.fillRect((int)n6, (int)n7, this.dotWidth, this.dotHeight);
            }
            this.updateCrosshairValues(crosshairState, xValue, yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), n6, n7, orientation);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYDotRenderer)) {
            return false;
        }
        final XYDotRenderer xyDotRenderer = (XYDotRenderer)o;
        return this.dotWidth == xyDotRenderer.dotWidth && this.dotHeight == xyDotRenderer.dotHeight && super.equals(o);
    }
    
    public Object clone() {
        return super.clone();
    }
}
