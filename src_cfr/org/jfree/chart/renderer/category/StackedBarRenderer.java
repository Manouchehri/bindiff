/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PublicCloneable;

public class StackedBarRenderer
extends BarRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    static final long serialVersionUID = 6402943811500067531L;
    private boolean renderAsPercentages;

    public StackedBarRenderer() {
        this(false);
    }

    public StackedBarRenderer(boolean bl2) {
        this.renderAsPercentages = bl2;
        ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
        this.setBasePositiveItemLabelPosition(itemLabelPosition);
        this.setBaseNegativeItemLabelPosition(itemLabelPosition);
        this.setPositiveItemLabelPositionFallback(null);
        this.setNegativeItemLabelPositionFallback(null);
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
        if (!this.renderAsPercentages) return DatasetUtilities.findStackedRangeBounds(categoryDataset, this.getBase());
        return new Range(0.0, 1.0);
    }

    @Override
    protected void calculateBarWidth(CategoryPlot categoryPlot, Rectangle2D rectangle2D, int n2, CategoryItemRendererState categoryItemRendererState) {
        CategoryAxis categoryAxis = categoryPlot.getDomainAxisForDataset(n2);
        CategoryDataset categoryDataset = categoryPlot.getDataset(n2);
        if (categoryDataset == null) return;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d2 = 0.0;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d2 = rectangle2D.getHeight();
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d2 = rectangle2D.getWidth();
        }
        double d3 = d2 * this.getMaximumBarWidth();
        int n3 = categoryDataset.getColumnCount();
        double d4 = 0.0;
        if (n3 > 1) {
            d4 = categoryAxis.getCategoryMargin();
        }
        double d5 = d2 * (1.0 - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin() - d4);
        if (n3 > 0) {
            categoryItemRendererState.setBarWidth(Math.min(d5 / (double)n3, d3));
            return;
        }
        categoryItemRendererState.setBarWidth(Math.min(d5, d3));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        double d2;
        double d3;
        double d4;
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        double d5 = number.doubleValue();
        double d6 = 0.0;
        if (this.renderAsPercentages) {
            d6 = DataUtilities.calculateColumnTotal(categoryDataset, n3);
            d5 /= d6;
        }
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d7 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        double d8 = d2 = this.getBase();
        for (int i2 = 0; i2 < n2; ++i2) {
            Number number2 = categoryDataset.getValue(i2, n3);
            if (number2 == null) continue;
            d4 = number2.doubleValue();
            if (this.renderAsPercentages) {
                d4 /= d6;
            }
            if (d4 > 0.0) {
                d2 += d4;
                continue;
            }
            d8 += d4;
        }
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        if (d5 >= 0.0) {
            d3 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
            d4 = valueAxis.valueToJava2D(d2 + d5, rectangle2D, rectangleEdge);
        } else {
            d3 = valueAxis.valueToJava2D(d8, rectangle2D, rectangleEdge);
            d4 = valueAxis.valueToJava2D(d8 + d5, rectangle2D, rectangleEdge);
        }
        double d9 = Math.min(d3, d4);
        double d10 = Math.max(Math.abs(d4 - d3), this.getMinimumBarLength());
        Rectangle2D.Double double_ = null;
        double_ = plotOrientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(d9, d7, d10, categoryItemRendererState.getBarWidth()) : new Rectangle2D.Double(d7, d9, categoryItemRendererState.getBarWidth(), d10);
        if (n4 == 0) {
            EntityCollection entityCollection;
            Paint paint = this.getItemPaint(n2, n3);
            GradientPaintTransformer gradientPaintTransformer = this.getGradientPaintTransformer();
            if (gradientPaintTransformer != null && paint instanceof GradientPaint) {
                paint = gradientPaintTransformer.transform((GradientPaint)paint, double_);
            }
            graphics2D.setPaint(paint);
            graphics2D.fill(double_);
            if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
                graphics2D.setStroke(this.getItemOutlineStroke(n2, n3));
                graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
                graphics2D.draw(double_);
            }
            if ((entityCollection = categoryItemRendererState.getEntityCollection()) == null) return;
            this.addItemEntity(entityCollection, categoryDataset, n2, n3, double_);
            return;
        }
        if (n4 != 1) return;
        CategoryItemLabelGenerator categoryItemLabelGenerator = this.getItemLabelGenerator(n2, n3);
        if (categoryItemLabelGenerator == null) return;
        if (!this.isItemLabelVisible(n2, n3)) return;
        this.drawItemLabel(graphics2D, categoryDataset, n2, n3, categoryPlot, categoryItemLabelGenerator, double_, d5 < 0.0);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StackedBarRenderer)) {
            return false;
        }
        StackedBarRenderer stackedBarRenderer = (StackedBarRenderer)object;
        if (this.renderAsPercentages == stackedBarRenderer.renderAsPercentages) return super.equals(object);
        return false;
    }
}

