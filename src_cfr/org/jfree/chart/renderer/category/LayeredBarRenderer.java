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
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectList;

public class LayeredBarRenderer
extends BarRenderer
implements Serializable {
    private static final long serialVersionUID = -8716572894780469487L;
    protected ObjectList seriesBarWidthList = new ObjectList();

    public double getSeriesBarWidth(int n2) {
        double d2 = Double.NaN;
        Number number = (Number)this.seriesBarWidthList.get(n2);
        if (number == null) return d2;
        return number.doubleValue();
    }

    public void setSeriesBarWidth(int n2, double d2) {
        this.seriesBarWidthList.set(n2, new Double(d2));
    }

    @Override
    protected void calculateBarWidth(CategoryPlot categoryPlot, Rectangle2D rectangle2D, int n2, CategoryItemRendererState categoryItemRendererState) {
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
        double d3 = d2 * this.getMaximumBarWidth();
        double d4 = 0.0;
        if (n3 > 1) {
            d4 = categoryAxis.getCategoryMargin();
        }
        double d5 = d2 * (1.0 - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin() - d4);
        if (n4 * n3 > 0) {
            categoryItemRendererState.setBarWidth(Math.min(d5 / (double)categoryDataset.getColumnCount(), d3));
            return;
        }
        categoryItemRendererState.setBarWidth(Math.min(d5, d3));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n2, n3);
            return;
        }
        if (plotOrientation != PlotOrientation.VERTICAL) return;
        this.drawVerticalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n2, n3);
    }

    protected void drawHorizontalItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3) {
        Object object;
        Object object2;
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        double d2 = number.doubleValue();
        double d3 = 0.0;
        double d4 = this.getLowerClip();
        double d5 = this.getUpperClip();
        if (d5 <= 0.0) {
            if (d2 >= d5) {
                return;
            }
            d3 = d5;
            if (d2 <= d4) {
                d2 = d4;
            }
        } else if (d4 <= 0.0) {
            if (d2 >= d5) {
                d2 = d5;
            } else if (d2 <= d4) {
                d2 = d4;
            }
        } else {
            if (d2 <= d4) {
                return;
            }
            d3 = d4;
            if (d2 >= d5) {
                d2 = d5;
            }
        }
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        double d6 = valueAxis.valueToJava2D(d3, rectangle2D, rectangleEdge);
        double d7 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        double d8 = Math.min(d6, d7);
        double d9 = Math.abs(d7 - d6);
        double d10 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        int n4 = this.getRowCount();
        double d11 = 0.0;
        double d12 = 0.0;
        double d13 = 1.0;
        double d14 = this.getSeriesBarWidth(n2);
        if (!Double.isNaN(d14)) {
            d13 = d14;
        }
        d12 = d13 * categoryItemRendererState.getBarWidth();
        d10 += (1.0 - d13) * categoryItemRendererState.getBarWidth() / 2.0;
        if (n4 > 1) {
            d11 = d12 * 0.2 / (double)(n4 - 1);
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(d8, d10 + (double)(n4 - 1 - n2) * d11, d9, d12 - (double)(n4 - 1 - n2) * d11 * 2.0);
        Paint paint = this.getItemPaint(n2, n3);
        GradientPaintTransformer gradientPaintTransformer = this.getGradientPaintTransformer();
        if (gradientPaintTransformer != null && paint instanceof GradientPaint) {
            paint = gradientPaintTransformer.transform((GradientPaint)paint, double_);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            object2 = this.getItemOutlineStroke(n2, n3);
            object = this.getItemOutlinePaint(n2, n3);
            if (object2 != null && object != null) {
                graphics2D.setStroke((Stroke)object2);
                graphics2D.setPaint((Paint)object);
                graphics2D.draw(double_);
            }
        }
        if ((object2 = this.getItemLabelGenerator(n2, n3)) != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, categoryDataset, n2, n3, categoryPlot, (CategoryItemLabelGenerator)object2, double_, d6 > d7);
        }
        if (categoryItemRendererState.getInfo() == null) return;
        object = categoryItemRendererState.getEntityCollection();
        if (object == null) return;
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
        object.add(categoryItemEntity);
    }

    protected void drawVerticalItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3) {
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        double d2 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        int n4 = this.getRowCount();
        double d3 = number.doubleValue();
        double d4 = 0.0;
        double d5 = this.getLowerClip();
        double d6 = this.getUpperClip();
        if (d6 <= 0.0) {
            if (d3 >= d6) {
                return;
            }
            d4 = d6;
            if (d3 <= d5) {
                d3 = d5;
            }
        } else if (d5 <= 0.0) {
            if (d3 >= d6) {
                d3 = d6;
            } else if (d3 <= d5) {
                d3 = d5;
            }
        } else {
            if (d3 <= d5) {
                return;
            }
            d4 = this.getLowerClip();
            if (d3 >= d6) {
                d3 = d6;
            }
        }
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        double d7 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge);
        double d8 = valueAxis.valueToJava2D(d3, rectangle2D, rectangleEdge);
        double d9 = Math.min(d8, d7);
        double d10 = categoryItemRendererState.getBarWidth();
        double d11 = Math.abs(d8 - d7);
        double d12 = 0.0;
        d10 = 0.0;
        double d13 = 1.0;
        double d14 = this.getSeriesBarWidth(n2);
        if (!Double.isNaN(d14)) {
            d13 = d14;
        }
        d10 = d13 * categoryItemRendererState.getBarWidth();
        d2 += (1.0 - d13) * categoryItemRendererState.getBarWidth() / 2.0;
        if (n4 > 1) {
            d12 = d10 * 0.2 / (double)(n4 - 1);
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(d2 + (double)(n4 - 1 - n2) * d12, d9, d10 - (double)(n4 - 1 - n2) * d12 * 2.0, d11);
        Paint paint = this.getItemPaint(n2, n3);
        GradientPaintTransformer gradientPaintTransformer = this.getGradientPaintTransformer();
        if (gradientPaintTransformer != null && paint instanceof GradientPaint) {
            paint = gradientPaintTransformer.transform((GradientPaint)paint, double_);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            Stroke stroke = this.getItemOutlineStroke(n2, n3);
            Paint paint2 = this.getItemOutlinePaint(n2, n3);
            if (stroke != null && paint2 != null) {
                graphics2D.setStroke(stroke);
                graphics2D.setPaint(paint2);
                graphics2D.draw(double_);
            }
        }
        double d15 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge);
        double d16 = valueAxis.valueToJava2D(d3, rectangle2D, rectangleEdge);
        CategoryItemLabelGenerator categoryItemLabelGenerator = this.getItemLabelGenerator(n2, n3);
        if (categoryItemLabelGenerator != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, categoryDataset, n2, n3, categoryPlot, categoryItemLabelGenerator, double_, d15 > d16);
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
}

