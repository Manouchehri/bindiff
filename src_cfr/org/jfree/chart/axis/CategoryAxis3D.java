/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.Effect3D;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.ui.RectangleEdge;

public class CategoryAxis3D
extends CategoryAxis
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 4114732251353700972L;

    public CategoryAxis3D() {
        this(null);
    }

    public CategoryAxis3D(String string) {
        super(string);
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        Object object;
        if (!this.isVisible()) {
            return new AxisState(d2);
        }
        CategoryPlot categoryPlot = (CategoryPlot)this.getPlot();
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        if (categoryPlot.getRenderer() instanceof Effect3D) {
            object = (Effect3D)((Object)categoryPlot.getRenderer());
            double d3 = rectangle2D2.getMinX();
            double d4 = rectangle2D2.getMinY();
            double d5 = rectangle2D2.getWidth() - object.getXOffset();
            double d6 = rectangle2D2.getHeight() - object.getYOffset();
            if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.BOTTOM) {
                d4 += object.getYOffset();
            } else if (rectangleEdge == RectangleEdge.RIGHT || rectangleEdge == RectangleEdge.TOP) {
                d3 += object.getXOffset();
            }
            double_.setRect(d3, d4, d5, d6);
        } else {
            double_.setRect(rectangle2D2);
        }
        object = new AxisState(d2);
        object = this.drawCategoryLabels(graphics2D, rectangle2D, double_, rectangleEdge, (AxisState)object, plotRenderingInfo);
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, (AxisState)object);
    }

    @Override
    public double getCategoryJava2DCoordinate(CategoryAnchor categoryAnchor, int n2, int n3, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        Rectangle2D rectangle2D2 = rectangle2D;
        CategoryPlot categoryPlot = (CategoryPlot)this.getPlot();
        CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        if (categoryItemRenderer instanceof Effect3D) {
            Effect3D effect3D = (Effect3D)((Object)categoryItemRenderer);
            double d3 = rectangle2D.getMinX();
            double d4 = rectangle2D.getMinY();
            double d5 = rectangle2D.getWidth() - effect3D.getXOffset();
            double d6 = rectangle2D.getHeight() - effect3D.getYOffset();
            if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.BOTTOM) {
                d4 += effect3D.getYOffset();
            } else if (rectangleEdge == RectangleEdge.RIGHT || rectangleEdge == RectangleEdge.TOP) {
                d3 += effect3D.getXOffset();
            }
            rectangle2D2 = new Rectangle2D.Double(d3, d4, d5, d6);
        }
        if (categoryAnchor == CategoryAnchor.START) {
            return this.getCategoryStart(n2, n3, rectangle2D2, rectangleEdge);
        }
        if (categoryAnchor == CategoryAnchor.MIDDLE) {
            return this.getCategoryMiddle(n2, n3, rectangle2D2, rectangleEdge);
        }
        if (categoryAnchor != CategoryAnchor.END) return d2;
        return this.getCategoryEnd(n2, n3, rectangle2D2, rectangleEdge);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

