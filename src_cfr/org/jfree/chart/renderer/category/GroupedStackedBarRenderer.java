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
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class GroupedStackedBarRenderer
extends StackedBarRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -2725921399005922939L;
    private KeyToGroupMap seriesToGroupMap = new KeyToGroupMap();

    public void setSeriesToGroupMap(KeyToGroupMap keyToGroupMap) {
        if (keyToGroupMap == null) {
            throw new IllegalArgumentException("Null 'map' argument.");
        }
        this.seriesToGroupMap = keyToGroupMap;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public Range findRangeBounds(CategoryDataset categoryDataset) {
        return DatasetUtilities.findStackedRangeBounds(categoryDataset, this.seriesToGroupMap);
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
        int n3 = this.seriesToGroupMap.getGroupCount();
        int n4 = categoryDataset.getColumnCount();
        int n5 = n3 * n4;
        double d4 = 0.0;
        double d5 = 0.0;
        if (n4 > 1) {
            d4 = categoryAxis.getCategoryMargin();
        }
        if (n3 > 1) {
            d5 = this.getItemMargin();
        }
        double d6 = d2 * (1.0 - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin() - d4 - d5);
        if (n5 > 0) {
            categoryItemRendererState.setBarWidth(Math.min(d6 / (double)n5, d3));
            return;
        }
        categoryItemRendererState.setBarWidth(Math.min(d6, d3));
    }

    @Override
    protected double calculateBarW0(CategoryPlot categoryPlot, PlotOrientation plotOrientation, Rectangle2D rectangle2D, CategoryAxis categoryAxis, CategoryItemRendererState categoryItemRendererState, int n2, int n3) {
        double d2 = 0.0;
        d2 = plotOrientation == PlotOrientation.HORIZONTAL ? rectangle2D.getHeight() : rectangle2D.getWidth();
        double d3 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        int n4 = this.seriesToGroupMap.getGroupCount();
        int n5 = this.seriesToGroupMap.getGroupIndex(this.seriesToGroupMap.getGroup(categoryPlot.getDataset().getRowKey(n2)));
        int n6 = this.getColumnCount();
        if (n4 <= 1) return categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        double d4 = d2 * this.getItemMargin() / (double)(n6 * (n4 - 1));
        double d5 = this.calculateSeriesWidth(d2, categoryAxis, n6, n4);
        return d3 + (double)n5 * (d5 + d4) + d5 / 2.0 - categoryItemRendererState.getBarWidth() / 2.0;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        double d2;
        Object object;
        double d3;
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        double d4 = number.doubleValue();
        Comparable comparable = this.seriesToGroupMap.getGroup(categoryDataset.getRowKey(n2));
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d5 = this.calculateBarW0(categoryPlot, plotOrientation, rectangle2D, categoryAxis, categoryItemRendererState, n2, n3);
        double d6 = 0.0;
        double d7 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Number number2;
            if (!comparable.equals(this.seriesToGroupMap.getGroup(categoryDataset.getRowKey(i2))) || (number2 = categoryDataset.getValue(i2, n3)) == null) continue;
            d3 = number2.doubleValue();
            if (d3 > 0.0) {
                d6 += d3;
                continue;
            }
            d7 += d3;
        }
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        if (d4 > 0.0) {
            d2 = valueAxis.valueToJava2D(d6, rectangle2D, rectangleEdge);
            d3 = valueAxis.valueToJava2D(d6 + d4, rectangle2D, rectangleEdge);
        } else {
            d2 = valueAxis.valueToJava2D(d7, rectangle2D, rectangleEdge);
            d3 = valueAxis.valueToJava2D(d7 + d4, rectangle2D, rectangleEdge);
        }
        double d8 = Math.min(d2, d3);
        double d9 = Math.max(Math.abs(d3 - d2), this.getMinimumBarLength());
        Rectangle2D.Double double_ = null;
        double_ = plotOrientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(d8, d5, d9, categoryItemRendererState.getBarWidth()) : new Rectangle2D.Double(d5, d8, categoryItemRendererState.getBarWidth(), d9);
        Paint paint = this.getItemPaint(n2, n3);
        if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
            object = (GradientPaint)paint;
            paint = this.getGradientPaintTransformer().transform((GradientPaint)object, double_);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemStroke(n2, n3));
            graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
            graphics2D.draw(double_);
        }
        if ((object = this.getItemLabelGenerator(n2, n3)) != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, categoryDataset, n2, n3, categoryPlot, (CategoryItemLabelGenerator)object, double_, d4 < 0.0);
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
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(double_, string, string2, categoryDataset, n2, categoryDataset.getColumnKey(n3), n3);
        entityCollection.add(categoryItemEntity);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof GroupedStackedBarRenderer)) return false;
        if (!super.equals(object)) return false;
        GroupedStackedBarRenderer groupedStackedBarRenderer = (GroupedStackedBarRenderer)object;
        if (groupedStackedBarRenderer.seriesToGroupMap.equals(this.seriesToGroupMap)) return true;
        return false;
    }
}

