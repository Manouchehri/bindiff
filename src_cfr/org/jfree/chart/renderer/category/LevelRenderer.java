/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class LevelRenderer
extends AbstractCategoryItemRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -8204856624355025117L;
    public static final double DEFAULT_ITEM_MARGIN = 0.2;
    private double itemMargin = 0.2;
    private double maxItemWidth = 1.0;

    public double getItemMargin() {
        return this.itemMargin;
    }

    public void setItemMargin(double d2) {
        this.itemMargin = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getMaxItemWidth() {
        return this.maxItemWidth;
    }

    public void setMaxItemWidth(double d2) {
        this.maxItemWidth = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getMaximumItemWidth() {
        return this.getMaxItemWidth();
    }

    public void setMaximumItemWidth(double d2) {
        this.setMaxItemWidth(d2);
    }

    @Override
    public CategoryItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, CategoryPlot categoryPlot, int n2, PlotRenderingInfo plotRenderingInfo) {
        CategoryItemRendererState categoryItemRendererState = super.initialise(graphics2D, rectangle2D, categoryPlot, n2, plotRenderingInfo);
        this.calculateItemWidth(categoryPlot, rectangle2D, n2, categoryItemRendererState);
        return categoryItemRendererState;
    }

    protected void calculateItemWidth(CategoryPlot categoryPlot, Rectangle2D rectangle2D, int n2, CategoryItemRendererState categoryItemRendererState) {
        CategoryAxis categoryAxis = this.getDomainAxis(categoryPlot, n2);
        CategoryDataset categoryDataset = categoryPlot.getDataset(n2);
        if (categoryDataset == null) return;
        int n3 = categoryDataset.getColumnCount();
        int n4 = categoryDataset.getRowCount();
        double d2 = 0.0;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d2 = rectangle2D.getHeight();
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d2 = rectangle2D.getWidth();
        }
        double d3 = d2 * this.getMaxItemWidth();
        double d4 = 0.0;
        double d5 = 0.0;
        if (n3 > 1) {
            d4 = categoryAxis.getCategoryMargin();
        }
        if (n4 > 1) {
            d5 = this.getItemMargin();
        }
        double d6 = d2 * (1.0 - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin() - d4 - d5);
        if (n4 * n3 > 0) {
            categoryItemRendererState.setBarWidth(Math.min(d6 / (double)(n4 * n3), d3));
            return;
        }
        categoryItemRendererState.setBarWidth(Math.min(d6, d3));
    }

    protected double calculateBarW0(CategoryPlot categoryPlot, PlotOrientation plotOrientation, Rectangle2D rectangle2D, CategoryAxis categoryAxis, CategoryItemRendererState categoryItemRendererState, int n2, int n3) {
        double d2 = 0.0;
        d2 = plotOrientation == PlotOrientation.HORIZONTAL ? rectangle2D.getHeight() : rectangle2D.getWidth();
        double d3 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        int n4 = this.getRowCount();
        int n5 = this.getColumnCount();
        if (n4 <= 1) return categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        double d4 = d2 * this.getItemMargin() / (double)(n5 * (n4 - 1));
        double d5 = this.calculateSeriesWidth(d2, categoryAxis, n5, n4);
        return d3 + (double)n2 * (d5 + d4) + d5 / 2.0 - categoryItemRendererState.getBarWidth() / 2.0;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        double d2 = number.doubleValue();
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d3 = this.calculateBarW0(categoryPlot, plotOrientation, rectangle2D, categoryAxis, categoryItemRendererState, n2, n3);
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        Line2D.Double double_ = null;
        double d5 = 0.0;
        double d6 = 0.0;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d5 = d4;
            d6 = d3 + categoryItemRendererState.getBarWidth() / 2.0;
            double_ = new Line2D.Double(d4, d3, d4, d3 + categoryItemRendererState.getBarWidth());
        } else {
            d5 = d3 + categoryItemRendererState.getBarWidth() / 2.0;
            d6 = d4;
            double_ = new Line2D.Double(d3, d4, d3 + categoryItemRendererState.getBarWidth(), d4);
        }
        Stroke stroke = this.getItemStroke(n2, n3);
        Paint paint = this.getItemPaint(n2, n3);
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double_);
        CategoryItemLabelGenerator categoryItemLabelGenerator = this.getItemLabelGenerator(n2, n3);
        if (categoryItemLabelGenerator != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, plotOrientation, categoryDataset, n2, n3, d5, d6, d2 < 0.0);
        }
        if (categoryItemRendererState.getInfo() == null) return;
        EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection == null) return;
        String string = null;
        CategoryToolTipGenerator categoryToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (categoryToolTipGenerator != null) {
            string = categoryToolTipGenerator.generateToolTip(categoryDataset, n2, n3);
        }
        String string2 = null;
        if (this.getItemURLGenerator(n2, n3) != null) {
            string2 = this.getItemURLGenerator(n2, n3).generateURL(categoryDataset, n2, n3);
        }
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(double_.getBounds(), string, string2, categoryDataset, n2, categoryDataset.getColumnKey(n3), n3);
        entityCollection.add(categoryItemEntity);
    }

    protected double calculateSeriesWidth(double d2, CategoryAxis categoryAxis, int n2, int n3) {
        double d3 = 1.0 - this.getItemMargin() - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin();
        if (n2 <= 1) return d2 * d3 / (double)(n2 * n3);
        d3 -= categoryAxis.getCategoryMargin();
        return d2 * d3 / (double)(n2 * n3);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LevelRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        LevelRenderer levelRenderer = (LevelRenderer)object;
        if (this.itemMargin != levelRenderer.itemMargin) {
            return false;
        }
        if (this.maxItemWidth == levelRenderer.maxItemWidth) return true;
        return false;
    }
}

