/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class StackedAreaRenderer
extends AreaRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -3595635038460823663L;
    private boolean renderAsPercentages;

    public StackedAreaRenderer() {
        this(false);
    }

    public StackedAreaRenderer(boolean bl2) {
        this.renderAsPercentages = bl2;
    }

    public boolean getRenderAsPercentages() {
        return this.renderAsPercentages;
    }

    public void setRenderAsPercentages(boolean bl2) {
        this.renderAsPercentages = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public int getPassCount() {
        return 2;
    }

    @Override
    public Range findRangeBounds(CategoryDataset categoryDataset) {
        if (!this.renderAsPercentages) return DatasetUtilities.findStackedRangeBounds(categoryDataset);
        return new Range(0.0, 1.0);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        Object object;
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        double d2 = number.doubleValue();
        double d3 = 0.0;
        if (this.renderAsPercentages) {
            d3 = DataUtilities.calculateColumnTotal(categoryDataset, n3);
            d2 /= d3;
        }
        double d4 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d5 = this.getPreviousHeight(categoryDataset, n2, n3);
        double d6 = d2 + d5;
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        double d7 = valueAxis.valueToJava2D(d6, rectangle2D, rectangleEdge);
        graphics2D.setPaint(this.getItemPaint(n2, n3));
        graphics2D.setStroke(this.getItemStroke(n2, n3));
        if (n3 == 0) {
            if (n4 == 1 && this.isItemLabelVisible(n2, n3)) {
                this.drawItemLabel(graphics2D, categoryPlot.getOrientation(), categoryDataset, n2, n3, d4, d7, d6 < 0.0);
            }
        } else {
            object = categoryDataset.getValue(n2, n3 - 1);
            if (object != null) {
                double d8 = categoryAxis.getCategoryMiddle(n3 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
                double d9 = object.doubleValue();
                if (this.renderAsPercentages) {
                    d3 = DataUtilities.calculateColumnTotal(categoryDataset, n3 - 1);
                    d9 /= d3;
                }
                double d10 = this.getPreviousHeight(categoryDataset, n2, n3 - 1);
                double d11 = valueAxis.valueToJava2D(d10, rectangle2D, rectangleEdge);
                double d12 = valueAxis.valueToJava2D(d5, rectangle2D, rectangleEdge);
                double d13 = valueAxis.valueToJava2D(d9 += d10, rectangle2D, rectangleEdge);
                if (n4 == 0) {
                    Polygon polygon = null;
                    PlotOrientation plotOrientation = categoryPlot.getOrientation();
                    if (plotOrientation == PlotOrientation.HORIZONTAL) {
                        polygon = new Polygon();
                        polygon.addPoint((int)d13, (int)d8);
                        polygon.addPoint((int)d7, (int)d4);
                        polygon.addPoint((int)d12, (int)d4);
                        polygon.addPoint((int)d11, (int)d8);
                    } else if (plotOrientation == PlotOrientation.VERTICAL) {
                        polygon = new Polygon();
                        polygon.addPoint((int)d8, (int)d13);
                        polygon.addPoint((int)d4, (int)d7);
                        polygon.addPoint((int)d4, (int)d12);
                        polygon.addPoint((int)d8, (int)d11);
                    }
                    graphics2D.setPaint(this.getItemPaint(n2, n3));
                    graphics2D.setStroke(this.getItemStroke(n2, n3));
                    graphics2D.fill(polygon);
                } else if (this.isItemLabelVisible(n2, n3)) {
                    this.drawItemLabel(graphics2D, categoryPlot.getOrientation(), categoryDataset, n2, n3, d4, d7, d6 < 0.0);
                }
            }
        }
        if ((object = categoryItemRendererState.getEntityCollection()) == null) return;
        Rectangle2D.Double double_ = new Rectangle2D.Double(d4 - 3.0, d7 - 3.0, 6.0, 6.0);
        this.addItemEntity((EntityCollection)object, categoryDataset, n2, n3, double_);
    }

    protected double getPreviousHeight(CategoryDataset categoryDataset, int n2, int n3) {
        double d2 = 0.0;
        double d3 = 0.0;
        if (this.renderAsPercentages) {
            d3 = DataUtilities.calculateColumnTotal(categoryDataset, n3);
        }
        int n4 = 0;
        while (n4 < n2) {
            Number number = categoryDataset.getValue(n4, n3);
            if (number != null) {
                double d4 = number.doubleValue();
                if (this.renderAsPercentages) {
                    d4 /= d3;
                }
                d2 += d4;
            }
            ++n4;
        }
        return d2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StackedAreaRenderer)) {
            return false;
        }
        StackedAreaRenderer stackedAreaRenderer = (StackedAreaRenderer)object;
        if (this.renderAsPercentages == stackedAreaRenderer.renderAsPercentages) return super.equals(object);
        return false;
    }
}

