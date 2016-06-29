package org.jfree.chart.axis;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.ui.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;

public class NumberAxis3D extends NumberAxis implements Serializable
{
    private static final long serialVersionUID = -1790205852569123512L;
    
    public NumberAxis3D() {
        this(null);
    }
    
    public NumberAxis3D(final String s) {
        super(s);
        this.setAxisLineVisible(false);
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            final AxisState axisState = new AxisState(n);
            axisState.setTicks(this.refreshTicks(graphics2D, axisState, rectangle2D2, rectangleEdge));
            return axisState;
        }
        double xOffset = 0.0;
        double yOffset = 0.0;
        final Plot plot = this.getPlot();
        if (plot instanceof CategoryPlot) {
            final CategoryItemRenderer renderer = ((CategoryPlot)plot).getRenderer();
            if (renderer instanceof Effect3D) {
                final Effect3D effect3D = (Effect3D)renderer;
                xOffset = effect3D.getXOffset();
                yOffset = effect3D.getYOffset();
            }
        }
        double minX = rectangle2D2.getMinX();
        double minY = rectangle2D2.getMinY();
        final double n2 = rectangle2D2.getWidth() - xOffset;
        final double n3 = rectangle2D2.getHeight() - yOffset;
        if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.BOTTOM) {
            minY += yOffset;
        }
        else if (rectangleEdge == RectangleEdge.RIGHT || rectangleEdge == RectangleEdge.TOP) {
            minX += xOffset;
        }
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, this.drawTickMarksAndLabels(graphics2D, n, rectangle2D, new Rectangle2D.Double(minX, minY, n2, n3), rectangleEdge));
    }
}
