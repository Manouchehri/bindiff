/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class StatisticalBarRenderer
extends BarRenderer
implements Serializable,
Cloneable,
CategoryItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -4986038395414039117L;
    private transient Paint errorIndicatorPaint = Color.gray;

    public Paint getErrorIndicatorPaint() {
        return this.errorIndicatorPaint;
    }

    public void setErrorIndicatorPaint(Paint paint) {
        this.errorIndicatorPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        if (!(categoryDataset instanceof StatisticalCategoryDataset)) {
            throw new IllegalArgumentException("Requires StatisticalCategoryDataset.");
        }
        StatisticalCategoryDataset statisticalCategoryDataset = (StatisticalCategoryDataset)categoryDataset;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, statisticalCategoryDataset, n2, n3);
            return;
        }
        if (plotOrientation != PlotOrientation.VERTICAL) return;
        this.drawVerticalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, statisticalCategoryDataset, n2, n3);
    }

    protected void drawHorizontalItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, StatisticalCategoryDataset statisticalCategoryDataset, int n2, int n3) {
        EntityCollection entityCollection;
        RectangleEdge rectangleEdge = categoryPlot.getDomainAxisEdge();
        double d2 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, rectangleEdge);
        int n4 = this.getRowCount();
        int n5 = this.getColumnCount();
        if (n4 > 1) {
            double d3 = rectangle2D.getHeight() * this.getItemMargin() / (double)(n5 * (n4 - 1));
            d2 += (double)n2 * (categoryItemRendererState.getBarWidth() + d3);
        } else {
            d2 += (double)n2 * categoryItemRendererState.getBarWidth();
        }
        Number number = statisticalCategoryDataset.getMeanValue(n2, n3);
        double d4 = number.doubleValue();
        double d5 = 0.0;
        double d6 = this.getLowerClip();
        double d7 = this.getUpperClip();
        if (d7 <= 0.0) {
            if (d4 >= d7) {
                return;
            }
            d5 = d7;
            if (d4 <= d6) {
                d4 = d6;
            }
        } else if (d6 <= 0.0) {
            if (d4 >= d7) {
                d4 = d7;
            } else if (d4 <= d6) {
                d4 = d6;
            }
        } else {
            if (d4 <= d6) {
                return;
            }
            d5 = this.getLowerClip();
            if (d4 >= d7) {
                d4 = d7;
            }
        }
        RectangleEdge rectangleEdge2 = categoryPlot.getRangeAxisEdge();
        double d8 = valueAxis.valueToJava2D(d5, rectangle2D, rectangleEdge2);
        double d9 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge2);
        double d10 = Math.min(d9, d8);
        double d11 = categoryItemRendererState.getBarWidth();
        double d12 = Math.abs(d9 - d8);
        Rectangle2D.Double double_ = new Rectangle2D.Double(d10, d2, d12, d11);
        Paint paint = this.getItemPaint(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemStroke(n2, n3));
            graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
            graphics2D.draw(double_);
        }
        double d13 = statisticalCategoryDataset.getStdDevValue(n2, n3).doubleValue();
        double d14 = valueAxis.valueToJava2D(number.doubleValue() + d13, rectangle2D, rectangleEdge2);
        double d15 = valueAxis.valueToJava2D(number.doubleValue() - d13, rectangle2D, rectangleEdge2);
        if (this.errorIndicatorPaint != null) {
            graphics2D.setPaint(this.errorIndicatorPaint);
        } else {
            graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
        }
        Line2D.Double double_2 = null;
        double_2 = new Line2D.Double(d15, d2 + d11 / 2.0, d14, d2 + d11 / 2.0);
        graphics2D.draw(double_2);
        double_2 = new Line2D.Double(d14, d2 + d11 * 0.25, d14, d2 + d11 * 0.75);
        graphics2D.draw(double_2);
        double_2 = new Line2D.Double(d15, d2 + d11 * 0.25, d15, d2 + d11 * 0.75);
        graphics2D.draw(double_2);
        CategoryItemLabelGenerator categoryItemLabelGenerator = this.getItemLabelGenerator(n2, n3);
        if (categoryItemLabelGenerator != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, statisticalCategoryDataset, n2, n3, categoryPlot, categoryItemLabelGenerator, double_, d4 < 0.0);
        }
        if ((entityCollection = categoryItemRendererState.getEntityCollection()) == null) return;
        this.addItemEntity(entityCollection, statisticalCategoryDataset, n2, n3, double_);
    }

    protected void drawVerticalItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, StatisticalCategoryDataset statisticalCategoryDataset, int n2, int n3) {
        EntityCollection entityCollection;
        RectangleEdge rectangleEdge = categoryPlot.getDomainAxisEdge();
        double d2 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, rectangleEdge);
        int n4 = this.getRowCount();
        int n5 = this.getColumnCount();
        if (n4 > 1) {
            double d3 = rectangle2D.getWidth() * this.getItemMargin() / (double)(n5 * (n4 - 1));
            d2 += (double)n2 * (categoryItemRendererState.getBarWidth() + d3);
        } else {
            d2 += (double)n2 * categoryItemRendererState.getBarWidth();
        }
        Number number = statisticalCategoryDataset.getMeanValue(n2, n3);
        double d4 = number.doubleValue();
        double d5 = 0.0;
        double d6 = this.getLowerClip();
        double d7 = this.getUpperClip();
        if (d7 <= 0.0) {
            if (d4 >= d7) {
                return;
            }
            d5 = d7;
            if (d4 <= d6) {
                d4 = d6;
            }
        } else if (d6 <= 0.0) {
            if (d4 >= d7) {
                d4 = d7;
            } else if (d4 <= d6) {
                d4 = d6;
            }
        } else {
            if (d4 <= d6) {
                return;
            }
            d5 = this.getLowerClip();
            if (d4 >= d7) {
                d4 = d7;
            }
        }
        RectangleEdge rectangleEdge2 = categoryPlot.getRangeAxisEdge();
        double d8 = valueAxis.valueToJava2D(d5, rectangle2D, rectangleEdge2);
        double d9 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge2);
        double d10 = Math.min(d9, d8);
        double d11 = categoryItemRendererState.getBarWidth();
        double d12 = Math.abs(d9 - d8);
        Rectangle2D.Double double_ = new Rectangle2D.Double(d2, d10, d11, d12);
        Paint paint = this.getItemPaint(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemStroke(n2, n3));
            graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
            graphics2D.draw(double_);
        }
        double d13 = statisticalCategoryDataset.getStdDevValue(n2, n3).doubleValue();
        double d14 = valueAxis.valueToJava2D(number.doubleValue() + d13, rectangle2D, rectangleEdge2);
        double d15 = valueAxis.valueToJava2D(number.doubleValue() - d13, rectangle2D, rectangleEdge2);
        if (this.errorIndicatorPaint != null) {
            graphics2D.setPaint(this.errorIndicatorPaint);
        } else {
            graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
        }
        Line2D.Double double_2 = null;
        double_2 = new Line2D.Double(d2 + d11 / 2.0, d15, d2 + d11 / 2.0, d14);
        graphics2D.draw(double_2);
        double_2 = new Line2D.Double(d2 + d11 / 2.0 - 5.0, d14, d2 + d11 / 2.0 + 5.0, d14);
        graphics2D.draw(double_2);
        double_2 = new Line2D.Double(d2 + d11 / 2.0 - 5.0, d15, d2 + d11 / 2.0 + 5.0, d15);
        graphics2D.draw(double_2);
        CategoryItemLabelGenerator categoryItemLabelGenerator = this.getItemLabelGenerator(n2, n3);
        if (categoryItemLabelGenerator != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, statisticalCategoryDataset, n2, n3, categoryPlot, categoryItemLabelGenerator, double_, d4 < 0.0);
        }
        if ((entityCollection = categoryItemRendererState.getEntityCollection()) == null) return;
        this.addItemEntity(entityCollection, statisticalCategoryDataset, n2, n3, double_);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StatisticalBarRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        StatisticalBarRenderer statisticalBarRenderer = (StatisticalBarRenderer)object;
        if (PaintUtilities.equal(this.errorIndicatorPaint, statisticalBarRenderer.errorIndicatorPaint)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.errorIndicatorPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.errorIndicatorPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

