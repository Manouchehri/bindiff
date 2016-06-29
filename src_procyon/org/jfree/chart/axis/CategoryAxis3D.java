package org.jfree.chart.axis;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.ui.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.*;
import org.jfree.chart.renderer.category.*;

public class CategoryAxis3D extends CategoryAxis implements Serializable, Cloneable
{
    private static final long serialVersionUID = 4114732251353700972L;
    
    public CategoryAxis3D() {
        this(null);
    }
    
    public CategoryAxis3D(final String s) {
        super(s);
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rect, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            return new AxisState(n);
        }
        final CategoryPlot categoryPlot = (CategoryPlot)this.getPlot();
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        if (categoryPlot.getRenderer() instanceof Effect3D) {
            final Effect3D effect3D = (Effect3D)categoryPlot.getRenderer();
            double minX = rect.getMinX();
            double minY = rect.getMinY();
            final double n2 = rect.getWidth() - effect3D.getXOffset();
            final double n3 = rect.getHeight() - effect3D.getYOffset();
            if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.BOTTOM) {
                minY += effect3D.getYOffset();
            }
            else if (rectangleEdge == RectangleEdge.RIGHT || rectangleEdge == RectangleEdge.TOP) {
                minX += effect3D.getXOffset();
            }
            double1.setRect(minX, minY, n2, n3);
        }
        else {
            double1.setRect(rect);
        }
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rect, rectangleEdge, this.drawCategoryLabels(graphics2D, rectangle2D, double1, rectangleEdge, new AxisState(n), plotRenderingInfo));
    }
    
    public double getCategoryJava2DCoordinate(final CategoryAnchor categoryAnchor, final int n, final int n2, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n3 = 0.0;
        Rectangle2D rectangle2D2 = rectangle2D;
        final CategoryItemRenderer renderer = ((CategoryPlot)this.getPlot()).getRenderer();
        if (renderer instanceof Effect3D) {
            final Effect3D effect3D = (Effect3D)renderer;
            double minX = rectangle2D.getMinX();
            double minY = rectangle2D.getMinY();
            final double n4 = rectangle2D.getWidth() - effect3D.getXOffset();
            final double n5 = rectangle2D.getHeight() - effect3D.getYOffset();
            if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.BOTTOM) {
                minY += effect3D.getYOffset();
            }
            else if (rectangleEdge == RectangleEdge.RIGHT || rectangleEdge == RectangleEdge.TOP) {
                minX += effect3D.getXOffset();
            }
            rectangle2D2 = new Rectangle2D.Double(minX, minY, n4, n5);
        }
        if (categoryAnchor == CategoryAnchor.START) {
            n3 = this.getCategoryStart(n, n2, rectangle2D2, rectangleEdge);
        }
        else if (categoryAnchor == CategoryAnchor.MIDDLE) {
            n3 = this.getCategoryMiddle(n, n2, rectangle2D2, rectangleEdge);
        }
        else if (categoryAnchor == CategoryAnchor.END) {
            n3 = this.getCategoryEnd(n, n2, rectangle2D2, rectangleEdge);
        }
        return n3;
    }
    
    public Object clone() {
        return super.clone();
    }
}
